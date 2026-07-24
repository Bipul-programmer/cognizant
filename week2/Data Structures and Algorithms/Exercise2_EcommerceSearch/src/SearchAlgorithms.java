package search;

import java.util.Arrays;

public class SearchAlgorithms {
    
    // Linear Search
    public static Product linearSearch(Product[] products, String targetProductId) {
        for (Product p : products) {
            if (p.getProductId().equals(targetProductId)) {
                return p;
            }
        }
        return null; // Not found
    }

    // Binary Search
    public static Product binarySearch(Product[] sortedProducts, String targetProductId) {
        int left = 0;
        int right = sortedProducts.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = sortedProducts[mid].getProductId().compareTo(targetProductId);

            if (comparison == 0) {
                return sortedProducts[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Not found
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product("P001", "Laptop", "Electronics"),
            new Product("P005", "Desk", "Furniture"),
            new Product("P003", "Chair", "Furniture"),
            new Product("P002", "Smartphone", "Electronics"),
            new Product("P004", "Monitor", "Electronics")
        };

        // Linear Search test
        System.out.println("Linear Search for P003: " + linearSearch(products, "P003"));
        
        // Binary search requires sorted array based on productId
        Arrays.sort(products);
        
        // Binary Search test
        System.out.println("Binary Search for P004: " + binarySearch(products, "P004"));
        System.out.println("Binary Search for P999 (not exist): " + binarySearch(products, "P999"));
    }
}
