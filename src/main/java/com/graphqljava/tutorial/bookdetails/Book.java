package com.graphqljava.tutorial.bookdetails;

import java.util.Collection;
import java.util.HashMap;

public class Book {

    private static final HashMap<String, Book> books = new HashMap<>() {{
        put("book-1", new Book("book-1", "Harry Potter and the Philosopher's Stone", 223, "author-1"));
        put("book-2", new Book("book-2", "Moby Dick", 635, "author-2"));
        put("book-3", new Book("book-3", "Interview with the vampire", 371, "author-3"));
    }};
    private String authorId;
    private String name;
    private int pageCount;
    private String id;

    public Book(String id, String name, int pageCount) {
        this.id = id;
        this.name = name;
        this.pageCount = pageCount;
    }

    public Book(String id, String name, int pageCount, String authorId) {
        this(id, name, pageCount);
        this.authorId = authorId;
    }

    public static Book getById(String id) {
        return books.getOrDefault(id, null);
    }

    public static Book addBook(Book book) {
        Book toAdd = book;
        toAdd.id = "book-" + (books.size() + 1);

        books.put(toAdd.id, toAdd);
        return toAdd;
    }

    public static Book updateBook(Book book) {
        Book toUpdate = getById(book.id);
        if (toUpdate != null) {
            toUpdate.name = book.name;
            toUpdate.pageCount = book.pageCount;
            books.put(toUpdate.id, toUpdate);
        }

        return toUpdate;
    }

    public static Collection<Book> getBooks() {
        return books.values();
    }

    public String getId() {
        return id;
    }

    public String getAuthorId() {
        return authorId;
    }
}
