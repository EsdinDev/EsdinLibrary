package model;

import org.esdindev.model.Book;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {

    @Test
    public void testGetTitle() {
        Book book = new Book();
        book.setTitle("The Lord of the Rings");
        assertEquals("The Lord of the Rings", book.getTitle());
    }

    @Test
    public void testGetAuthorName() {
        Book book = new Book();
        book.setAuthorName(Arrays.asList("J.R.R. Tolkien"));
        assertEquals(Arrays.asList("J.R.R. Tolkien"), book.getAuthorName());
    }

    @Test
    public void testGetPublishYear() {
        Book book = new Book();
        book.setPublishYear(Arrays.asList(1954));
        assertEquals(Arrays.asList(1954), book.getPublishYear());
    }

    @Test
    public void testGetAuthorAlternativeName() {
        Book book = new Book();
        book.setAuthorAlternativeName(Arrays.asList("John Ronald Reuel Tolkien"));
        assertEquals(Arrays.asList("John Ronald Reuel Tolkien"), book.getAuthorAlternativeName());
    }

    @Test
    public void testGetIsbn() {
        Book book = new Book();
        book.setIsbn(Arrays.asList("978-0261102385"));
        assertEquals(Arrays.asList("978-0261102385"), book.getIsbn());
    }

    @Test
    public void testGetKey() {
        Book book = new Book();
        book.setKey("/works/OL27448W");
        assertEquals("/works/OL27448W", book.getKey());
    }

    @Test
    public void testBookToString(){
        Book book = new Book();
        book.setTitle("The Lord of the Rings");
        book.setAuthorName(Arrays.asList("J.R.R. Tolkien"));
        book.setPublishYear(Arrays.asList(1954));
        book.setAuthorAlternativeName(Arrays.asList("John Ronald Reuel Tolkien"));
        book.setIsbn(Arrays.asList("978-0261102385"));
        book.setKey("/works/OL27448W");

        assertEquals("Book{title='The Lord of the Rings', authorName=[J.R.R. Tolkien], publishYear=[1954], " +
                "authorAlternativeName=[John Ronald Reuel Tolkien], isbn=[978-0261102385], key='/works/OL27448W'}",
                book.toString());
    }
}