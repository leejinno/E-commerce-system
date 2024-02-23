import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Product_Management {
    MyArrayList productList;

    public Product_Management() throws FileNotFoundException, IOException {
        this.productList = new MyArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader("e-commerce.csv"))) {
            String line;
            String header = br.readLine();

            while ((line = br.readLine()) != null) {
                this.productList.add(line);
            }
        }
    }

    public void addProduct() {
        // MyArrayList list = new MyArrayList();
        String list = "";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product's ID: ");
        String productId = scanner.nextLine();
        list = list + productId + ",";
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        list = list + name + ",";

        System.out.print("Enter product description: ");
        String description = scanner.nextLine();
        list = list + description + ",";

        System.out.print("Enter product price: $");
        String price = scanner.nextLine();
        list = list + price + ",";

        System.out.print("Enter product stock count: ");
        String stockCount = scanner.nextLine();
        list = list + stockCount;

        // Write in CSV file
        addToCSV(list);
        productList.add(list);
        System.out.println("Successfully added product");
        
    }

    // CSV Read and write
    public void importFromCSV(String csvFilePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            boolean headerSkipped = false;

            while ((line = br.readLine()) != null) {
                if (!headerSkipped) {
                    // Skip the header line
                    headerSkipped = true;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length == 5) {
                	String id = data[0];
                    String name = data[1];
                    String description = data[2];
                    double price = Double.parseDouble(data[3]);
                    int stockCount = Integer.parseInt(data[4]);

                    MyArrayList list = new MyArrayList();
                    list.add(name);
                    list.add(id);
                    list.add(description);
                    list.add(String.valueOf(price));
                    list.add(String.valueOf(stockCount));

                    productList.add(list);
                    
                 // Print the product details here
                    
                    System.out.println("Product Name: " + name);
                    System.out.println("ID: " + id);
                    System.out.println("Product Description: " + description);
                    System.out.println("Product Price: " + price + " Baht");
                    System.out.println("Stock Count: " + stockCount);
                    System.out.println(); // Add a blank line for separation
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void addToCSV(String list) {
        try (BufferedReader br = new BufferedReader(new FileReader("e-commerce.csv"))) {
            String line;
            String header = br.readLine();
            MyArrayList data = new MyArrayList();

            while ((line = br.readLine()) != null) {
            	
                data.add(line);
            }
            
            PrintWriter writer = new PrintWriter("e-commerce.csv");
            writer.println(header);
            data.join(",");

            for (int j = 0; j < data.size(); j++) {
                writer.println(data.get(j));
            }

            writer.println(list);

            writer.flush();
            writer.close();
            

        } catch (

        IOException e) {
            e.printStackTrace();
        }
    }

    // -------------------------------------------------------

    public void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the product to delete: ");
        String id = scanner.nextLine();

        // CSV text file remove
        try (BufferedReader br = new BufferedReader(new FileReader("e-commerce.csv"))) {
            String line;
            String header = br.readLine();
            MyArrayList data = new MyArrayList();

            boolean found = false;
            while ((line = br.readLine()) != null) {
                if (!line.contains(id)) {
                    data.add(line);
                    found = true;
                }
            }
            if (found) {
                System.out.println("Successfully Deleted.");
            } else {
                System.out.println("ID not found.");
            }

            PrintWriter writer = new PrintWriter("e-commerce.csv");
            writer.println(header);
            data.join(",");

            for (int j = 0; j < data.size(); j++) {
                writer.println(data.get(j));
            }
            writer.flush();
            writer.close();

        } catch (

        IOException e) {
            e.printStackTrace();
        }

        scanner.close();
        // ----------------------------------------------------------
    }

    public void updateProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the product to update: ");
        String id = scanner.nextLine();

        // CSV text file remove
        try (BufferedReader br = new BufferedReader(new FileReader("e-commerce.csv"))) {
            String line;
            String header = br.readLine();
            MyArrayList data = new MyArrayList();

            boolean found = false;
            String choice;
            while ((line = br.readLine()) != null) {
                if (line.contains(id)) {
                    while (true) {
                        System.out.println("What do you want to change?");
                        System.out.println("1.ID");
                        System.out.println("2.Name");
                        System.out.println("3.Description");
                        System.out.println("4.Price");
                        System.out.println("5.Stock");
                        System.out.print("Choose (1-5): ");
                        choice = scanner.nextLine();
                        if (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4")
                                && !choice.equals("5")) {
                            System.out.println("Wrong input, please try again");
                        } else {
                            break;
                        }
                    }

                    String[] row = line.split(",");
                    System.out.print("Enter new data: ");
                    String newData = scanner.nextLine();
                    row[Integer.parseInt(choice) - 1] = newData;
                    data.add(Arrays.toString(row));
                    found = true;
                } else {
                    data.add(line);
                }
            }
            if (!found) {
                System.out.println("ID not found.");
            } else {
                System.out.println("Successfully updated data.");
            }

            PrintWriter writer = new PrintWriter("e-commerce.csv");
            writer.println(header);
            data.join(",");

            for (int j = 0; j < data.size(); j++) {
                writer.println(data.get(j));
            }
            writer.flush();
            writer.close();

        } catch (

        IOException e) {
            e.printStackTrace();
        }

        scanner.close();
    }

public int size() {
		// TODO Auto-generated method stub
		return size();
	}

public Product get(int i) {
	// TODO Auto-generated method stub
	return null;
}
}