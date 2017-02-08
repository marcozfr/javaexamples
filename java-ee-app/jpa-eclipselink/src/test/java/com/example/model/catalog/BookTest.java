package com.example.model.catalog;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.Arrays;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.Test;
<<<<<<< HEAD:jpa-eclipselink/src/test/java/com/example/model/catalog/BookTest.java
=======
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.example.model.catalog.Book;
import com.example.model.catalog.types.CurrencyType;
>>>>>>> 89ca26dfd1858650222cae0e5711b29f3a1a1063:java-ee-app/jpa-eclipselink/src/test/java/com/example/model/catalog/BookTest.java

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
    
}
