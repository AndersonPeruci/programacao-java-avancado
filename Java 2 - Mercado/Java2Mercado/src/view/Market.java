package view;

import helper.Utils;
import model.Product;

import java.util.*;

public class Market {
    private static final Scanner keyboard = new Scanner(System.in);
    private static ArrayList<Product> products;
    private static Map<Product, Integer> cart;

    public static void main(String[] args) {
        products = new ArrayList<>();
        cart = new HashMap<>();
        Market.menu();

    }

    private static void menu(){
        System.out.println("========================================");
        System.out.println("=============== Welcome ================");
        System.out.println("============= Supermarket ==============");
        System.out.println("========================================");

        System.out.println("Select an option below: ");
        System.out.println(
                "1 - Register a product" +
                "\n2 - Show products available" +
                "\n3 - Add products to the cart" +
                "\n4 - Show shopping cart" +
                "\n5 - Finalize order" +
                "\n6 - Exit"
        );
        int optionMenu = 0;

        try {
            optionMenu = Integer.parseInt(Market.keyboard.nextLine());
        } catch (InputMismatchException | NumberFormatException exception) {
            Market.menu();
        }

        switch (optionMenu) {
            case 1 -> Market.registerProduct();
            case 2 -> Market.listProducts();
            case 3 -> Market.addProductsToCart();
            case 4 -> Market.showShoppingCart();
            case 5 -> Market.buyProducts();
            case 6 -> {
                System.out.println("Good bye! See you again");
                Utils.stop(2);
                System.exit(0);
            }
            default -> {
                System.out.println("Invalid option");
                Utils.stop(2);
                Market.menu();
            }
        }
    }

    private static void registerProduct() {
        System.out.println("Register product");
        System.out.println("================");

        System.out.print("Enter the product name: ");
        String pName = Market.keyboard.nextLine();

        System.out.print("Enter the product price: ");
        Double pPrice = Market.keyboard.nextDouble();

        Product product = new Product(pName, pPrice);

        Market.products.add(product);

        System.out.println("The product " + product.getName() + " product has been successfully registered");
        Utils.stop(2);
        Market.menu();
    }

    private static void listProducts() {
        if (Market.products.size() > 0){
            System.out.println("=Available products=");
            for (Product product: Market.products) {
                System.out.println(product);
            }
        } else {
            System.out.println("There are no registered products");
        }
        Utils.stop(2);
        Market.menu();
    }

    private static void addProductsToCart() {
        if (Market.products.size() > 0) {
            System.out.println("Enter de product code that wish to add in the cart:");
            for (Product product: Market.products) {
                System.out.println(product);
                System.out.println("____________________________________");
            }
            int code = Integer.parseInt(Market.keyboard.nextLine());
            boolean existProduct = false;
            for (Product product: Market.products) {
                if(product.getCode() == code){
                    existProduct = true;
                    try {
                        Market.cart.put(product, Market.cart.get(product) + 1);
                    } catch (NullPointerException nullPointerException) {
                        Market.cart.put(product, 1);
                    }
                    break;
                }
            }

            if (existProduct) {
                System.out.print("Do you want to add another product?\n1 - Yes\n2 - No");
                if (Integer.parseInt(Market.keyboard.nextLine()) == 1)
                    Market.addProductsToCart();
                else
                    Market.menu();

            } else {
                System.out.println("Invalid product code");
                System.out.println("Enter again");
                Utils.stop(2);
                Market.addProductsToCart();
            }


        } else {
            System.out.print("There are no registered products");
        }
        Utils.stop(2);
        Market.menu();
    }

    private static void showShoppingCart() {
        if (Market.cart.size() > 0) {
            System.out.println("Products in the cart");
            for (Product product: Market.cart.keySet())
                System.out.println("Product " + product + "\nAmount: " + Market.cart.get(product));

        } else {
            System.out.println("Empty cart");
        }
        Utils.stop(2);
        Market.menu();
    }

    private static void buyProducts() {
        if (Market.cart.size() == 0){
            System.out.println("Cart is empty. Add a product to complete the purchase");
            Utils.stop(2);
            Market.menu();
        }

        Double totalValue = 0.0;
        System.out.println("Products in the cart");
        for (Product product: Market.cart.keySet()) {
            System.out.println("Product " + product + "\nAmount: " + Market.cart.get(product));
            totalValue += product.getPrice() * Market.cart.get(product);
        }
        System.out.println("Total value: " + Utils.doubleToString(totalValue));
        Market.cart.clear();
        System.out.println("Thanks for the purchase");
        Utils.stop(5);
        Market.menu();
    }
}
