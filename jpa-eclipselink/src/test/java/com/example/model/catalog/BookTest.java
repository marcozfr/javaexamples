package com.example.model.catalog;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.example.model.catalog.Book;
import com.example.model.catalog.CurrencyType;

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
        
        tx.commit();
        
        Query q = em.createNamedQuery("getBookById");
        q.setParameter("id", book.getBookId());
        Book savedBook = (Book) q.getSingleResult();
        
        assertNotNull(savedBook);
        
    }
    
}
