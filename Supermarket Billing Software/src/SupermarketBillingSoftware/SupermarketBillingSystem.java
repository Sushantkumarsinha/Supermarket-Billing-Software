package SupermarketBillingSoftware;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Product {
    private String productName;
    private double price;

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return productName + " - ₹" + price;
    }
}

class ShoppingCart {
    private Map<Product, Integer> items = new HashMap<>();

    public void addItem(Product product, int quantity) {
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public void displayReceipt() {
        System.out.println("------ Receipt ------");
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            System.out.println(entry.getKey().toString() + " x" + entry.getValue());
        }
        System.out.println("---------------------");
        System.out.println("Total: ₹" + calculateTotal());
    }
}

public class SupermarketBillingSystem {

    public static void main(String[] args) {
   
        Product apple = new Product("Apple", 50.0);
        Product banana = new Product("Banana", 25.0);
        Product milk = new Product("Milk", 100.0);
        Product bread = new Product("Bread", 30.0);
        Product rice = new Product("Rice", 80.0);
        Product eggs = new Product("Eggs", 60.0);
        Product chicken = new Product("Chicken", 150.0);
        Product soap = new Product("Soap", 40.0);
        Product shampoo = new Product("Shampoo", 120.0);
        Product toothpaste = new Product("Toothpaste", 35.0);

        ShoppingCart cart = new ShoppingCart();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Available Products:");
            System.out.println("1. " + apple);
            System.out.println("2. " + banana);
            System.out.println("3. " + milk);
            System.out.println("4. " + bread);
            System.out.println("5. " + rice);
            System.out.println("6. " + eggs);
            System.out.println("7. " + chicken);
            System.out.println("8. " + soap);
            System.out.println("9. " + shampoo);
            System.out.println("10. " + toothpaste);
            System.out.println("11. Finish Shopping");

            System.out.print("Enter choice (1-11): ");
            int choice = scanner.nextInt();

            if (choice == 11) {
                break;
            }

            int quantity;
            do {
                System.out.print("Enter quantity: ");
                quantity = scanner.nextInt();
            } while (quantity <= 0);

            switch (choice) {
                case 1:
                    cart.addItem(apple, quantity);
                    break;
                case 2:
                    cart.addItem(banana, quantity);
                    break;
                case 3:
                    cart.addItem(milk, quantity);
                    break;
                case 4:
                    cart.addItem(bread, quantity);
                    break;
                case 5:
                    cart.addItem(rice, quantity);
                    break;
                case 6:
                    cart.addItem(eggs, quantity);
                    break;
                case 7:
                    cart.addItem(chicken, quantity);
                    break;
                case 8:
                    cart.addItem(soap, quantity);
                    break;
                case 9:
                    cart.addItem(shampoo, quantity);
                    break;
                case 10:
                    cart.addItem(toothpaste, quantity);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 11.");
            }
        }

        cart.displayReceipt();

        scanner.close();
    }
}
