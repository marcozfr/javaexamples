package com.example.ws.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {
    
    public Book() {
        super();
    }

    private long id;
    private String isbn;
    private BookType type;
    private boolean save;

    public boolean isSave() {
        return save;
    }

    public void setSave(boolean save) {
        this.save = save;
    }

    public BookType getType() {
        return type;
    }

    public void setType(BookType type) {
        this.type = type;
    }

    public Book(String isbn) {
        this.isbn = isbn;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", isbn=" + isbn + ", type=" + type + ", save=" + save + "]";
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    
}
