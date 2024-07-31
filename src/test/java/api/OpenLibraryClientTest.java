
package api;

import org.esdindev.api.OpenLibraryClient;
import org.esdindev.model.Book;
import org.esdindev.model.SearchResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.IOException;
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
        mockUrl = new URL("http://openlibrary.org/search.json?q=java");
        mockConnection = mock(HttpURLConnection.class);
        client = new OpenLibraryClient() {
            protected HttpURLConnection createConnection(URL url) throws IOException {
                return mockConnection;
            }
        };
    }

    @Test
    public void testSearchBooksSuccess() throws IOException {
        String jsonResponse = "{\"docs\":[{\"title\":\"Effective Java\"}],\"numFound\":1,\"start\":0}";
        when(mockConnection.getInputStream()).thenReturn(new ByteArrayInputStream(jsonResponse.getBytes()));
        when(mockConnection.getResponseCode()).thenReturn(HttpURLConnection.HTTP_OK);

        SearchResult result = client.searchBooks("El+Nombre+Del+Viento");

        assertNotNull(result);
        assertEquals(9, result.getNumFound());
        assertEquals(0, result.getStart());
        assertEquals("El nombre del viento", result.getDocs().get(0).getTitle());
    }

    @Test
    public void testSearchBooksNotFound() throws IOException {
        String jsonResponse = "{\"docs\":[],\"numFound\":0,\"start\":0}";
        when(mockConnection.getInputStream()).thenReturn(new ByteArrayInputStream(jsonResponse.getBytes()));
        when(mockConnection.getResponseCode()).thenReturn(HttpURLConnection.HTTP_OK);

        SearchResult result = client.searchBooks("nonexistentbook");

        assertNotNull(result);
        assertEquals(0, result.getNumFound());
        assertTrue(result.getDocs().isEmpty());
    }

//    @Test
//    public void testSearchBooksApiError() throws IOException {
//        when(mockConnection.getResponseCode()).thenReturn(HttpURLConnection.HTTP_INTERNAL_ERROR);
//
//        assertThrows(IOException.class, () -> client.searchBooks("java"));
//    }

//    @Test
//    public void testSearchBooksMalformedJson() throws IOException {
//        String jsonResponse = "malformed json";
//        when(mockConnection.getInputStream()).thenReturn(new ByteArrayInputStream(jsonResponse.getBytes()));
//        when(mockConnection.getResponseCode()).thenReturn(HttpURLConnection.HTTP_OK);
//
//        assertThrows(IOException.class, () -> client.searchBooks("java"));
//    }
}