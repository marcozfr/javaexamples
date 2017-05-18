package com.example.ws.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;

import com.example.ws.model.Book;
import com.example.ws.model.BookType;
import com.sun.istack.logging.Logger;

public class AsyncResponseResource {
	
    private static Logger logger = Logger.getLogger(AsyncResponseResource.class);

	@GET
	@Path("book")
	@Produces("application/books+xml")
	public void getBookAsync(@Suspended AsyncResponse response){
		
		logger.info(this.getClass() + " working on " + Thread.currentThread().getName());
		
		new Thread(){
			@Override
			public void run() {
				Response resp = Response.serverError().build();
				try {
					
					logger.info(this.getClass() + " working on " + Thread.currentThread().getName());
					
					Book book = new Book();
					book.setId(30032l);
					book.setIsbn("ISBN9394");
					book.setType(BookType.HORROR);
					Thread.sleep(1000l);
					resp = Response.ok(book).build();
				} catch (Exception e) {
					e.printStackTrace();
					response.cancel(30);
				}
				response.resume(resp);
			}
		}.start();
		
	}

}
