package org.esdindev;

import org.esdindev.api.OpenLibraryClient;
import org.esdindev.model.Book;
import org.esdindev.model.SearchResult;

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
            SearchResult books = client.searchBooks("El+Nombre+Del+Viento");
            List<Book> docs = books.getDocs();

            for (Book book : docs) {
                System.out.println(book.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}