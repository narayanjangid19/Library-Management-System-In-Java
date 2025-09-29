import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    void show() {
        System.out.println("Title: " + title + " | Author: " + author + " | Year: " + year);
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();
    Scanner sc;

    public Library(Scanner sc) {
        this.sc = sc;
    }

    void addBook() {
        System.out.print("Enter title: ");
        String title = sc.nextLine();
        System.out.print("Enter author: ");
        String author = sc.nextLine();
        System.out.print("Enter year: ");
        int year = Integer.parseInt(sc.nextLine().trim());
        books.add(new Book(title, author, year));
        System.out.println("Book added.");
    }

    void viewByTitle() {
        System.out.print("Enter title to search: ");
        String q = sc.nextLine();
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(q)) {
                b.show();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    void viewAll() {
        if (books.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }
        System.out.println("\nAll books:");
        for (Book b : books) b.show();
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library(sc);
        while (true) {
            System.out.println("\n1. Add book    2. View by title    3. View all    0. Exit");
            System.out.print("Choice: ");
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1": lib.addBook(); break;
                case "2": lib.viewByTitle(); break;
                case "3": lib.viewAll(); break;
                case "0":
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default: System.out.println("Invalid choice.");
            }
        }
    }
}
