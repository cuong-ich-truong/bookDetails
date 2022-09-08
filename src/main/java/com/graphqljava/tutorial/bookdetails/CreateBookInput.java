package com.graphqljava.tutorial.bookdetails;

public class CreateBookInput {
    private String authorId;
    private String name;
    private int pageCount;

    public CreateBookInput(String authorId, String name, int pageCount) {
        this.authorId = authorId;
        this.name = name;
        this.pageCount = pageCount;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getName() {
        return name;
    }

    public int getPageCount() {
        return pageCount;
    }
}
