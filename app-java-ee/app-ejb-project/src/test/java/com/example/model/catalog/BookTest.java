package com.example.model.catalog;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Test;

import com.example.model.catalog.AbstractTest;
import com.example.model.catalog.Book;
import com.example.model.catalog.types.CurrencyType;

public class BookTest extends AbstractTest{
    
    @Test
    public void testBook(){
        
        Book book = new Book();
        book.setIsbn("ISBN000113");
        book.setTitle("La ciudad y los perros ");
        book.setCurrency(CurrencyType.GBP);
        book.setTags(Arrays.asList("DRAMA","FICTIONAL","SPANISH"));
        
        tx.begin();
        
        em.persist(book);
        
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
//        assertNotEquals(books.size(),0 );
    }
    
}
