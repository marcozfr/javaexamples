package com.example.ejb;

import java.math.BigDecimal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.model.catalog.Book;
import com.example.model.catalog.CurrencyType;

@Stateless
public class StoreBean {
    
    @PersistenceContext(unitName="catalogPU")
    private EntityManager em;
    
    public void createBook(){
        Book book = new Book();
        book.setCurrency(CurrencyType.PEN);
        book.setIsbn("ISBN100201");
        book.setItem("It is a book");
        book.setPrice(BigDecimal.valueOf(122.2));
        book.setQuantity(12);
        
        em.persist(book);
        
        Book book1 = em.find(Book.class, book.getItemId());
        
        System.out.println(book1.getItemId());
    }

}
