package com.itsz.java.functional.stream;

import lombok.Data;

@Data
public class Book {

    private String id;

    private String name;

    private int page;

    public Book(String id, String name, int page) {
        this.id = id;
        this.name = name;
        this.page = page;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
