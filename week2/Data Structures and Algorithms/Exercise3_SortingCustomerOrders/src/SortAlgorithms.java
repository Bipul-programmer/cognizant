package sorting;

import java.util.Arrays;

public class SortAlgorithms {

    // Bubble Sort (Descending by total price)
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() < orders[j + 1].getTotalPrice()) {
                    // swap
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // Array is already sorted
        }
    }

    // Quick Sort (Descending by total price)
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1); // index of smaller element

        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() >= pivot) {
                i++;
                // swap
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        // swap pivot
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Order[] ordersForBubble = {
            new Order("O001", "Alice", 250.50),
            new Order("O002", "Bob", 150.00),
            new Order("O003", "Charlie", 300.75),
            new Order("O004", "Diana", 50.25)
        };
        
        Order[] ordersForQuick = Arrays.copyOf(ordersForBubble, ordersForBubble.length);

        System.out.println("Before Bubble Sort: " + Arrays.toString(ordersForBubble));
        bubbleSort(ordersForBubble);
        System.out.println("After Bubble Sort: " + Arrays.toString(ordersForBubble));

        System.out.println("\nBefore Quick Sort: " + Arrays.toString(ordersForQuick));
        quickSort(ordersForQuick, 0, ordersForQuick.length - 1);
        System.out.println("After Quick Sort: " + Arrays.toString(ordersForQuick));
    }
}
