public class CheckoutSystem {
    private LinkedList cart; // Assuming your custom LinkedList class is used here

    public CheckoutSystem() {
        this.cart = new LinkedList();
    }

    // Set the cart to be processed
    public void setCart(LinkedList cart) {
        this.cart = cart;
    }

    // Simulate the checkout and purchase process
    public void checkout(Product_Management productManagement) {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty. Please add items before checking out.");
            return;
        }

        double totalCost = 0.0;

        System.out.println("Checkout Summary:");
        System.out.println("=================");

        for (int i = 0; i < cart.size(); i++) {
            int productId = cart.get(i);
            Product product = findProductById(productId, productManagement);
            if (product != null) {
                totalCost += product.getPrice();
                System.out.println("Product Name: " + product.getName());
                System.out.println("Price: $" + product.getPrice());
                System.out.println("Description: " + product.getDescription());
                System.out.println("-----------------");
                product.setStockCount(product.getStockCount() - 1); // Reduce stock count by 1
            }
        }

        System.out.println("Total Cost: $" + totalCost);
        System.out.println("Thank you for your purchase!");

        // Clear the cart after the purchase
        cart = new LinkedList(); // Assuming you have a method to create a new empty list
    }

    // Find a product by its ID
    private Product findProductById(int productId, Product_Management productManagement) {
        for (int i = 0; i < productManagement.size(); i++) {
            Product product = productManagement.get(i);
            if (product.getId() == productId) {
                return product;
            }
        }
        return null; // Product not found
    }
}
