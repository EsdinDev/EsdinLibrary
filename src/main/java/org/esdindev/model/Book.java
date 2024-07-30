package org.esdindev.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Represents a book from the Open Library API.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
    /**
     * The title of the book.
     */
    @JsonProperty("title")
    private String title;

    /**
     * The name of the author(s) of the book.
     */
    @JsonProperty("author_name")
    private List<String> authorName;

    /**
     * The year(s) the book was published.
     */
    @JsonProperty("publish_year")
    private List<Integer> publishYear;

    /**
     * An alternative name(s) for the author of the book.
     */
    @JsonProperty("author_alternative_name")
    private List<String> authorAlternativeName;

    /**
     * The ISBN(s) of the book.
     */
    @JsonProperty("isbn")
    private List<String> isbn;

    /**
     * The key of the book.
     */
    @JsonProperty("key")
    private String key;

    /**
     * Gets the title of the book.
     *
     * @return The title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book.
     *
     * @param title The title of the book.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the name of the author(s) of the book.
     *
     * @return The name of the author(s) of the book.
     */
    public List<String> getAuthorName() {
        return authorName;
    }

    /**
     * Sets the name of the author(s) of the book.
     *
     * @param authorName The name of the author(s) of the book.
     */
    public void setAuthorName(List<String> authorName) {
        this.authorName = authorName;
    }

    /**
     * Gets the year(s) the book was published.
     *
     * @return The year(s) the book was published.
     */
    public List<Integer> getPublishYear() {
        return publishYear;
    }

    /**
     * Sets the year(s) the book was published.
     *
     * @param publishYear The year(s) the book was published.
     */
    public void setPublishYear(List<Integer> publishYear) {
        this.publishYear = publishYear;
    }

    /**
     * Gets an alternative name(s) for the author of the book.
     *
     * @return An alternative name(s) for the author of the book.
     */
    public List<String> getAuthorAlternativeName() {
        return authorAlternativeName;
    }

    /**
     * Sets an alternative name(s) for the author of the book.
     *
     * @param authorAlternativeName An alternative name(s) for the author of the book.
     */
    public void setAuthorAlternativeName(List<String> authorAlternativeName) {
        this.authorAlternativeName = authorAlternativeName;
    }

    /**
     * Gets the ISBN(s) of the book.
     *
     * @return The ISBN(s) of the book.
     */
    public List<String> getIsbn() {
        return isbn;
    }

    /**
     * Sets the ISBN(s) of the book.
     *
     * @param isbn The ISBN(s) of the book.
     */
    public void setIsbn(List<String> isbn) {
        this.isbn = isbn;
    }

    /**
     * Gets the key of the book.
     *
     * @return The key of the book.
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the key of the book.
     *
     * @param key The key of the book.
     */
    public void setKey(String key) {
        this.key = key;
    }
}