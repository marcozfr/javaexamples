package com.example.ejb.test;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import javax.naming.NamingException;

import org.junit.Test;

import com.example.ejb.session.BooksBean;
import com.example.ejb.session.local.BooksLocal;
import com.example.model.catalog.Book;
import com.example.model.catalog.types.CurrencyType;

public class BooksBeanTest extends EjbContainerTest {

	@Test
	public void createBookBeanTest() throws NamingException{
	    BooksLocal booksBean = (BooksLocal) context
		        .lookup("java:global/classes/BooksBean!com.example.ejb.session.local.BooksLocal");
	    Book book = new Book("book 1", BigDecimal.valueOf(344.43),45);
	    book.setCurrency(CurrencyType.PEN);
	    book.setIsbn("ISBN30032");
	    book.setTitle("book title 1");
		Book b = booksBean.saveBook(book);
		
		assertNotNull(b.getItemId());
		
	}
}
