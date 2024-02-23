import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Interface {
    private static void mainMenu() {
    	System.out.println("Main menu\n");
        System.out.println("Choose the option you want to manage:");
        System.out.println("1.Product\n2.Cart\n3.Exit");
        System.out.print("Choose (1-3): ");
    }

    private static void productMenu() {
        System.out.println("Product Menu\n------------\n1.Add Product\n2.Delete Product\n3.Update Product\n4.Back");
        System.out.print("Choose (1-4): ");
    }

    private static void cartMenu() {
        System.out.println("Cart Menu\n---------\n1.Add Products by ID\n2.Remove Items from the cart\n3.Change Order\n4.Display Product\n5.Back");
        System.out.print("Choose (1-5): ");
    }
     

    public static void main(String[] args) throws FileNotFoundException, IOException {

    	boolean f = false;
    	boolean f2 = false;
    	
        // import csv file
        Product_Management productManagement = new Product_Management();
        productManagement.importFromCSV("e-commerce.csv"); //You must change to your csv file's location.

        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        Product_Management product_Management = new Product_Management();
        CartManagement cart_Management = new CartManagement();

     // Welcome text title
        String welcomeMessage = "Welcome to Home Workout Equipment shop<3";
        String border = new String(new char[welcomeMessage.length()]).replace("\0", "*");
        String cartInput;
        System.out.println(border);
        System.out.println("");
        System.out.println(welcomeMessage);
        System.out.println("");
        System.out.println(border);
        System.out.println("");
        System.out.println("- E-commerce cart system -\n");

        // Loop for main menu
        while (true) {
            mainMenu();
            
            int input = scanner.nextInt();
            // Product management
            if (input == 1) {
                while (!f) {
                    System.out.println("");
                    productMenu();
                    String productinput = scanner1.nextLine();

                    // add product                    
                    switch(productinput){
                    	case "1":
                    		product_Management.addProduct();
                    		f = false;
                    		break;
                    	case "2":
                    		product_Management.deleteProduct();
                    		f = false;
                    		break;
                    	case "3":
                    		product_Management.updateProduct();
                    		f = false;
                    		break;
                    	case "4":
                    		f = true;
                    		break;	
                    	default:
                    		System.out.println("Wrong input please try again.");
                    		f = false;
                    		break;
                    }
                }

                // Cart management
            } else if (input == 2) {
                while (!f2) {
                    cartMenu();
                    cartInput = scanner1.nextLine();
                    
                    switch(cartInput) {
                    // add product to cart
                    	case "1":
                    		cart_Management.addCart(product_Management);
                    		f2 = false;
                    		break;

                        // remove product from cart
                    	case "2":
                    		cart_Management.removeCart();    
                    		f2 = false;
                    		break;
                     
                        // Change product
                    	case "3":
                    		cart_Management.changeOrder();
                            System.out.println("Work Well");
                            f2 = false;
                    		break;
                    	
                        // display cart
                    	case "4":
                        	cart_Management.displayCart();
                            f2 = false;
                    		break;
                        
                        // back to main menu
                    	case "5":
                            f2 = true;
                    		break;

                        // In any case type wrong
                    	default:
                    		System.out.println("Wrong input please try again.");
                    		f = false;
                    		break;
                }
                }

                // Exit service
            } else if (input == 3) {
                break;

                // In any case type wrong
            } else {
                System.out.println("Wrong input, please try again.");
            }
        }
        System.out.println("Thank you for using our service.");

        //scanner.close();
    }
}