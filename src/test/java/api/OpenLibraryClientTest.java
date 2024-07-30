package api;

import org.esdindev.api.OpenLibraryClient;
import org.esdindev.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OpenLibraryClientTest {

    private OpenLibraryClient client;
    private HttpURLConnection mockConnection;
    private URL mockUrl;

    @BeforeEach
    public void setUp() throws Exception {
        client = new OpenLibraryClient();
        mockConnection = mock(HttpURLConnection.class);
        mockUrl = new URL("https://openlibrary.org/search.json?q=mock");
    }

    @Test
    public void testSearchBooks() throws IOException {
        // Mock the URL and connection
        when(mockUrl.openConnection()).thenReturn(mockConnection);
        when(mockConnection.getResponseCode()).thenReturn(200);

        // Mock the response
        String jsonResponse = "{\"docs\":[{\"title\":\"The Lord of the Rings\"}],\"numFound\":1,\"start\":0}";
        InputStream inputStream = new ByteArrayInputStream(jsonResponse.getBytes());
        when(mockConnection.getInputStream()).thenReturn(inputStream);

        // Call the method
        List<Book> books = client.searchBooks("The Lord of the Rings");

        // Verify the results
        assertNotNull(books);
        assertFalse(books.isEmpty());
        assertEquals("The Lord of the Rings", books.get(0).getTitle());
    }

    @Test
    public void testSearchBooksNotFound() throws IOException {
        // Mock the URL and connection
        when(mockUrl.openConnection()).thenReturn(mockConnection);
        when(mockConnection.getResponseCode()).thenReturn(200);

        // Mock the response
        String jsonResponse = "{\"docs\":[],\"numFound\":0,\"start\":0}";
        InputStream inputStream = new ByteArrayInputStream(jsonResponse.getBytes());
        when(mockConnection.getInputStream()).thenReturn(inputStream);

        // Call the method
        List<Book> books = client.searchBooks("EsdinDevBook");

        // Verify the results
        assertNotNull(books);
        assertTrue(books.isEmpty());
    }

    @Test
    public void testSearchBooksApiError() throws IOException {
        // Mock the URL and connection
        when(mockUrl.openConnection()).thenReturn(mockConnection);
        when(mockConnection.getResponseCode()).thenReturn(500);

        // Call the method and expect an exception
        assertThrows(RuntimeException.class, () -> client.searchBooks("The Lord of the Rings"));
    }
}