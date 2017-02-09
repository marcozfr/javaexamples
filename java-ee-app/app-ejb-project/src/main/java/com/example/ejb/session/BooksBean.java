package com.example.ejb.session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.example.ejb.session.local.BooksLocal;
import com.example.ejb.session.remote.BooksRemote;
import com.example.model.catalog.Book;

@Stateless
//@LocalBean
public class BooksBean implements BooksLocal,BooksRemote {

    @PersistenceContext(unitName="catalogJTAPU")
    private EntityManager entityManager;
    
    @Override
    public Book findBookById(Long bookId) {
        return entityManager.find(Book.class, bookId);
    }

    @Override
    public List<Book> findAllBooks() {
        TypedQuery<Book> q = entityManager.createNamedQuery("findAllBooks",Book.class);
        return q.getResultList();
    }

    @Override
    public Book saveBook(Book book) {
        entityManager.persist(book);
        return book;
    }
    
    

}
