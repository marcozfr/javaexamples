package com.example.model.catalog;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Test;

import com.example.model.catalog.types.CurrencyType;

public class BookTest extends AbstractTest{
    
    @Test
    public void testBook(){
        
        Book book = new Book();
        book.setIsbn("ISBN000113");
        book.setPrice(BigDecimal.valueOf(345.5));
        book.setTitle("La ciudad y los perros ");
        book.setCurrency(CurrencyType.GBP);
        book.setTags(Arrays.asList("DRAMA","FICTIONAL","SPANISH"));
        
        tx.begin();
        
        em.persist(book);
        
        EntityTransaction tx1 = em1.getTransaction();
        tx1.begin();
        em1.find(Book.class, book.getItemId());
        tx1.commit();

        tx.commit();
        
        Query q = em.createNamedQuery("getItemById");
        q.setParameter("id", book.getItemId());
        Book savedBook = (Book) q.getSingleResult();
        
        assertNotNull(savedBook);
        
    }
    
    @Test
    public void testBooksList(){

        TypedQuery<Book> tq = em.createNamedQuery("findAllBooks",Book.class);
        
        List<Book> books = tq.getResultList();
        assertNotNull(books);
        assertNotEquals(books.size(),0 );
    }
    
}
