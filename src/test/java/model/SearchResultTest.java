package org.esdindev.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchResultTest {

    @Test
    public void testGetDocs() {
        SearchResult searchResult = new SearchResult();
        Book book = new Book();
        book.setTitle("The Lord of the Rings");
        searchResult.setDocs(Arrays.asList(book));
        assertEquals(Arrays.asList(book), searchResult.getDocs());
    }

    @Test
    public void testGetNumFound() {
        SearchResult searchResult = new SearchResult();
        searchResult.setNumFound(1);
        assertEquals(1, searchResult.getNumFound());
    }

    @Test
    public void testGetStart() {
        SearchResult searchResult = new SearchResult();
        searchResult.setStart(0);
        assertEquals(0, searchResult.getStart());
    }
}