package org.esdindev.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Represents the search result from the Open Library API.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResult {
    /**
     * The list of books that match the search query.
     */
    @JsonProperty("docs")
    private List<Book> docs;

    /**
     * The total number of books found.
     */
    @JsonProperty("numFound")
    private int numFound;

    /**
     * The starting index of the search results.
     */
    @JsonProperty("start")
    private int start;

    /**
     * Gets the list of books that match the search query.
     *
     * @return The list of books.
     */
    public List<Book> getDocs() {
        return docs;
    }

    /**
     * Sets the list of books that match the search query.
     *
     * @param docs The list of books.
     */
    public void setDocs(List<Book> docs) {
        this.docs = docs;
    }

    /**
     * Gets the total number of books found.
     *
     * @return The total number of books found.
     */
    public int getNumFound() {
        return numFound;
    }

    /**
     * Sets the total number of books found.
     *
     * @param numFound The total number of books found.
     */
    public void setNumFound(int numFound) {
        this.numFound = numFound;
    }

    /**
     * Gets the starting index of the search results.
     *
     * @return The starting index of the search results.
     */
    public int getStart() {
        return start;
    }

    /**
     * Sets the starting index of the search results.
     *
     * @param start The starting index of the search results.
     */
    public void setStart(int start) {
        this.start = start;
    }
}