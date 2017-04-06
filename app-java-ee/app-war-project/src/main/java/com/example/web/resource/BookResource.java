package com.example.web.resource;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.WebServiceRef;

import com.example.app.ws.client.Book;
import com.example.app.ws.client.BookArray;
import com.example.app.ws.client.BooksBeanService;
import com.example.app.ws.client.CurrencyType;
import com.example.app.ws.client.handler.ClientHandlerResolver;
import com.example.ejb.session.local.BooksLocal;

@Path("/book")
public class BookResource {
	
	@Inject
	BooksLocal booksLocal;
	
	@WebServiceRef
	BooksBeanService bookWsService;
	
	@PostConstruct
	public void init(){
		bookWsService.setHandlerResolver(new ClientHandlerResolver(true,"catalogUser"));
	}
	
	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public Response createBook(MultivaluedMap<String, String> form) {
		Integer quantity = new Integer(form.getFirst("quantity"));
		BigDecimal price = new BigDecimal(form.getFirst("price"));
		String title = form.getFirst("title");
		String isbn = form.getFirst("isbn");
		CurrencyType currency = CurrencyType.valueOf(form.getFirst("currency"));
		List<String> tags = form.get("tags");
		
		Book book = new Book();
		book.setPrice(price);
		book.setQuantity(quantity);
		book.setTitle(title);
		book.setIsbn(isbn);
		book.setCurrency(currency);
		if(tags!=null){
			book.getTags().addAll(tags);
		}
		try {
			Book savedBook = bookWsService.getBookServicePort().save(book);
			return Response.ok(savedBook).build();
		} catch (com.example.app.ws.client.BusinessException e) {
			return Response.accepted(e.getMessage()).build();
		}
	}
	
	@GET
	@Produces("application/json")
	public Response allBooks(){
		
		BookArray books = bookWsService.getBookServicePort().findAll();
		GenericEntity<List<Book>> booksEntity = new GenericEntity<List<Book>>(books.getItem()){};
		return Response.ok(booksEntity).build();
	}
	
	static class BooksHandler implements AsyncHandler<BookArray> {

		@Override
		public void handleResponse(javax.xml.ws.Response<BookArray> res) {
			
			try {
				BookArray bookArray  = res.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
