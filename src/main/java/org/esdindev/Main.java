package org.esdindev;

import org.esdindev.api.OpenLibraryClient;
import org.esdindev.model.Book;

import java.io.IOException;
import java.util.List;

/**
 * The main class to run the Open Library client application.
 */
public class Main {
    /**
     * The main method to execute the application.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        OpenLibraryClient client = new OpenLibraryClient();
        try {
            List<Book> books = client.searchBooks("The Lord of the Rings");
            for (Book book : books) {
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthorName());
                System.out.println("Publish Year: " + book.getPublishYear());
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}