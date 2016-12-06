package com.example.web.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="catalog")
@XmlAccessorType(XmlAccessType.FIELD)
public class AppCatalog {
    
    @XmlElement(name="book")
    private List<AppBook> books;

    public List<AppBook> getBooks() {
        return books;
    }

    public void setBooks(List<AppBook> books) {
        this.books = books;
    }
    
}
