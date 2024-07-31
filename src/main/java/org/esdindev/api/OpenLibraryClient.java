package org.esdindev.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.esdindev.model.Book;
import org.esdindev.model.SearchResult;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

/**
 * A client for interacting with the Open Library API.
 */
public class OpenLibraryClient {
    private static final String API_URL = "https://openlibrary.org/search.json?q=";

    /**
     * Searches for books using the Open Library API.
     *
     * @param query The search query string.
     * @return A list of books that match the search query.
     * @throws IOException If an I/O error occurs when sending or receiving data.
     */
    public SearchResult searchBooks(String query) throws IOException {
        String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8.toString());
        URL url = new URL(API_URL + encodedQuery);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new IOException("HttpResponseCode: " + responseCode);
        }

        Scanner scanner = new Scanner(url.openStream());
        StringBuilder inline = new StringBuilder();
        while (scanner.hasNext()) {
            inline.append(scanner.nextLine());
        }
        scanner.close();

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(inline.toString(), SearchResult.class);
    }

    protected HttpURLConnection createConnection(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }
}