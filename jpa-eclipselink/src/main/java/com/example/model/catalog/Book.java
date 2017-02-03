package com.example.model.catalog;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="getBookById",query="select b from Book b where b.bookId = :id ")
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private int bookId;
    
    @Column(length = 200, nullable = false)
    private String title;
    
    @Column(nullable = false)
    private String isbn;
    
    @Column(precision=16,scale=4)
    private BigDecimal price;
    
    @Enumerated(EnumType.STRING)
    private CurrencyType currency;
    
    @ElementCollection(fetch=FetchType.LAZY)
    @CollectionTable(name="Tag") // default name would be book_tags
    @Column(name="Value") // value column on Tag table
    private List<String> tags;
    
    public List<String> getTags() {
        return tags;
    }
    public void setTags(List<String> tags) {
        this.tags = tags;
    }
    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public CurrencyType getCurrency() {
        return currency;
    }
    public void setCurrency(CurrencyType currency) {
        this.currency = currency;
    }
    
}
