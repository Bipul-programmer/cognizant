package library;

import java.util.Arrays;

public class LibraryManagement {

    // Linear Search by title
    public static Book linearSearch(Book[] books, String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    // Binary Search by title
    public static Book binarySearch(Book[] sortedBooks, String title) {
        int left = 0;
        int right = sortedBooks.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = sortedBooks[mid].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return sortedBooks[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book("B002", "1984", "George Orwell"),
            new Book("B003", "To Kill a Mockingbird", "Harper Lee"),
            new Book("B004", "Pride and Prejudice", "Jane Austen"),
            new Book("B005", "Moby Dick", "Herman Melville")
        };

        // Linear Search test
        System.out.println("Linear Search for '1984': " + linearSearch(books, "1984"));

        // Binary search requires sorted array based on title
        Arrays.sort(books);
        
        System.out.println("\nBooks sorted by title:");
        for (Book b : books) {
            System.out.println(b);
        }

        // Binary Search test
        System.out.println("\nBinary Search for 'Moby Dick': " + binarySearch(books, "Moby Dick"));
        System.out.println("Binary Search for 'Unknown Book': " + binarySearch(books, "Unknown Book"));
    }
}
