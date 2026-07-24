package inventory;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Product> products;

    public Inventory() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (products.containsKey(product.getProductId())) {
            System.out.println("Product with ID " + product.getProductId() + " already exists.");
        } else {
            products.put(product.getProductId(), product);
            System.out.println("Product added successfully.");
        }
    }

    public void updateProduct(String productId, Product updatedProduct) {
        if (products.containsKey(productId)) {
            products.put(productId, updatedProduct);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    public void deleteProduct(String productId) {
        if (products.containsKey(productId)) {
            products.remove(productId);
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    public Product getProduct(String productId) {
        return products.get(productId);
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        
        Product p1 = new Product("P001", "Laptop", 10, 1500.00);
        Product p2 = new Product("P002", "Smartphone", 25, 800.00);
        
        inventory.addProduct(p1);
        inventory.addProduct(p2);
        
        System.out.println(inventory.getProduct("P001"));
        
        Product p1Updated = new Product("P001", "Gaming Laptop", 8, 1600.00);
        inventory.updateProduct("P001", p1Updated);
        
        System.out.println(inventory.getProduct("P001"));
        
        inventory.deleteProduct("P002");
        System.out.println("P002 after deletion: " + inventory.getProduct("P002"));
    }
}
