package com.example.web.resource;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.xml.ws.WebServiceRef;

import com.example.app.ws.client.BookArray;
import com.example.app.ws.client.BooksBeanService;
import com.example.ejb.session.local.BooksLocal;
import com.example.model.catalog.Book;
import com.example.model.catalog.types.CurrencyType;

@Path("/book")
public class BookResource {
	
	@Inject
	BooksLocal booksLocal;
	
	@WebServiceRef
	BooksBeanService bookWsService;
	
	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public Book createBook(MultivaluedMap<String, String> form){
		Integer quantity = new Integer(form.getFirst("quantity"));
		BigDecimal price = new BigDecimal(form.getFirst("price"));
		String title = form.getFirst("title");
		String isbn = form.getFirst("isbn");
		CurrencyType currency = CurrencyType.valueOf(form.getFirst("currency"));
		List<String> tags = form.get("tags");
		
		Book book = new Book(null,price,quantity,title,isbn,currency,tags);
		return booksLocal.saveBook(book);
	}
	
	@GET
	@Produces("application/json")
	public Response allBooks(){
		BookArray books = bookWsService.getBookServicePort().findAll();
		GenericEntity<List<com.example.app.ws.client.Book>> booksEntity = new GenericEntity<List<com.example.app.ws.client.Book>>(books.getItem()){};
		return Response.ok(booksEntity).build();
	}
	
	

}
