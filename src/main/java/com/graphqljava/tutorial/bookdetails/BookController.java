package com.graphqljava.tutorial.bookdetails;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
public class BookController {
    @QueryMapping
    public Collection<Book> books() {
        return Book.getBooks();
    }

    @QueryMapping
    public Book bookById(@Argument String id) {
        return Book.getById(id);
    }

    @MutationMapping
    public Book addBook(@Argument String name, @Argument String authorId, @Argument int pageCount) {
        Book toAdd = new Book("", name, pageCount, authorId);
        return Book.addBook(toAdd);
    }

    @MutationMapping
    public Book updateBook(@Argument String id, @Argument String name, @Argument int pageCount) {
        Book toUpdate = new Book(id, name, pageCount);

        return Book.updateBook(toUpdate);
    }

    @SchemaMapping
    public Author author(Book book) {
        return Author.getById(book.getAuthorId());
    }
}
