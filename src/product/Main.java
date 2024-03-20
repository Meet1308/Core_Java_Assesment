package product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private String productId;
    private String productName;
    private int quantity;

    public Product(String productId, String productName, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class InventoryManager {
    private List<Product> productList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addProduct() {
        System.out.println("\nAdd Product:");
        System.out.print("Enter Product ID: ");
        String productId = scanner.next();
        System.out.print("Enter Product Name: ");
        String productName = scanner.next();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();

        Product product = new Product(productId, productName, quantity);
        productList.add(product);

        System.out.println("Product added successfully!");
    }

    public void viewProducts() {
        System.out.println("\nView Products:");
        if (productList.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (Product product : productList) {
                System.out.println("Product ID: " + product.getProductId() +
                        ", Product Name: " + product.getProductName() +
                        ", Quantity: " + product.getQuantity());
            }
        }
    }

    public void searchProduct() {
        System.out.println("\nSearch Product:");
        System.out.print("Enter Product ID to search: ");
        String productId = scanner.next();

        for (Product product : productList) {
            if (product.getProductId().equals(productId)) {
                System.out.println("Product found:");
                System.out.println("Product ID: " + product.getProductId() +
                        ", Product Name: " + product.getProductName() +
                        ", Quantity: " + product.getQuantity());
                return;
            }
        }

        System.out.println("Product not found.");
    }

    public void editProduct() {
        System.out.println("\nEdit Product:");
        System.out.print("Enter Product ID to edit: ");
        String productId = scanner.next();

        for (Product product : productList) {
            if (product.getProductId().equals(productId)) {
                System.out.print("Enter new quantity: ");
                int newQuantity = scanner.nextInt();
                product.setQuantity(newQuantity);
                System.out.println("Quantity updated successfully!");
                return;
            }
        }

        System.out.println("Product not found.");
    }

    public void deleteProduct() {
        System.out.println("\nDelete Product:");
        System.out.print("Enter Product ID to delete: ");
        String productId = scanner.next();

        for (Product product : productList) {
            if (product.getProductId().equals(productId)) {
                productList.remove(product);
                System.out.println("Product deleted successfully!");
                return;
            }
        }

        System.out.println("Product not found.");
    }
}
public class Main {
	public static void main(String[] args) {
	InventoryManager inventoryManager = new InventoryManager();
    Scanner scanner = new Scanner(System.in);
    int choice;

    do {
        System.out.println("\nMenu:");
        System.out.println("1. Add Product");
        System.out.println("2. View Products");
        System.out.println("3. Search Product");
        System.out.println("4. Edit Product");
        System.out.println("5. Delete Product");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                inventoryManager.addProduct();
                break;
            case 2:
                inventoryManager.viewProducts();
                break;
            case 3:
                inventoryManager.searchProduct();
                break;
            case 4:
                inventoryManager.editProduct();
                break;
            case 5:
                inventoryManager.deleteProduct();
                break;
            case 6:
                System.out.println("Exiting the program. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    } while (choice != 6);

    scanner.close();
}
}

