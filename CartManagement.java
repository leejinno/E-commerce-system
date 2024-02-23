import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CartManagement {
    MyArrayList<Product> cart; // Use MyArrayList to store cart items
    Product_Management productManagement;
    Scanner scanner = new Scanner(System.in);

    public CartManagement() {
        this.cart = new MyArrayList<>();
    }

    public void addCart(Product_Management productManagement) throws FileNotFoundException, IOException {
        boolean found = false;

        System.out.print("Enter the product ID to add to the cart: ");
        String id = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader("e-commerce.csv"))) {
            String line;
            String header = br.readLine(); // Skip the header

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int productId = Integer.parseInt(parts[0].trim()); // Assuming ID is in the first column

                if (productId == Integer.parseInt(id)) {
                    String name = parts[1].trim();
                    String des = parts[2].trim();
                    double price = Double.parseDouble(parts[3].trim());
                    int q = Integer.parseInt(parts[4].trim());

                    Product product = new Product(productId, name, des, price, q);
                    cart.add(product);

                    found = true;
                    System.out.println("Added to cart");
                    break; // Exit the loop when the product is found
                }
                int Quantity = scanner.nextInt();
                if (productId >= 0 && productId < cart.size()) {
                    Product product = cart.get(productId);
                    product.setStockCount(Quantity);
                    System.out.println("Quantity updated in the cart.");
                }
            }

            if (!found) {
                System.out.println("Product with ID " + id + " not found in the CSV file.");
            }
            
            
            
            
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeCart() {
        System.out.print("Enter product ID to remove from cart: ");
        int idToRemove = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        boolean removed = false;
        for (int i = 0; i < cart.size(); i++) {
            Product product = cart.get(i);
            if (product.getId() == idToRemove) {
                cart.delete(i);
                System.out.println("Product with ID " + idToRemove + " removed from the cart.");
                removed = true;
                break; // Exit the loop after removing the first occurrence
            }
        }

        if (!removed) {
            System.out.println("Product with ID " + idToRemove + " not found in the cart.");
        }
    }

    public void changeOrder() {
        System.out.print("Enter the id of the product to update: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter the new quantity: ");
        int newQuantity = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (index >= 0 && index < cart.size()) {
            Product product = cart.get(index);
            product.setStockCount(newQuantity);
            System.out.println("Quantity updated in the cart.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    public void displayCart() {
        // Display the contents of the cart (MyArrayList)
        System.out.println("User's Cart:");
        double totalPrice = 0.0;

        for (int i = 0; i < cart.size(); i++) {
            Product product = cart.get(i);
            System.out.println("Product ID: " + product.getId());
            System.out.println("Product Name: " + product.getName());
            System.out.println("Product Price: $" + product.getPrice());
            System.out.println("Quantity in Cart: " + product.getStockCount());

            totalPrice += (product.getPrice() * product.getStockCount());
        }

        System.out.println("Total Price: $" + totalPrice);
    }
}