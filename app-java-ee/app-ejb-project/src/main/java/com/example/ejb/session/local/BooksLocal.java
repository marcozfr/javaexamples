package com.example.ejb.session.local;

import java.util.List;

import javax.ejb.Local;

import com.example.model.catalog.Book;

@Local
public interface BooksLocal {
    
    List<Book> findAllBooks();

    Book saveBook(Book book);
    
}
