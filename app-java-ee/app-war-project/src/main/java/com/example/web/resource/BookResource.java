package com.example.web.resource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.WebServiceRef;

import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import com.example.app.ws.client.Book;
import com.example.app.ws.client.BookArray;
import com.example.app.ws.client.BooksBeanService;
import com.example.app.ws.client.BusinessException_Exception;
import com.example.app.ws.client.CurrencyType;
import com.example.app.ws.client.SaveCover;
import com.example.app.ws.client.SaveCoverResponse;
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
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createBook(MultivaluedMap<String, String> form) throws BusinessException_Exception {	
		String title = form.getFirst("title");
		String isbn = form.getFirst("isbn");
		CurrencyType currency = CurrencyType.valueOf(form.getFirst("currency"));
		List<String> tags = form.get("tags");
		
		Book book = new Book();
		book.setTitle(title);
		book.setIsbn(isbn);
		book.setCurrency(currency);
		if(tags!=null){
			book.getTags().addAll(tags);
		}
		Book savedBook = bookWsService.getBooksBeanPort().save(book);
		return Response.ok(savedBook).build();
	}
	
	@POST
	@Path("/cover")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveBookCover(@QueryParam("id") Long id, MultipartFormDataInput multipartInput) throws IOException{
		
		Map<String,List<InputPart>> upload = multipartInput.getFormDataMap();
		
		List<InputPart> parts = upload.get("file");
		
		byte [] bytes = null;
		for (InputPart inputPart : parts) {
			
			MultivaluedMap<String, String> headers =  inputPart.getHeaders();
			System.out.println("Headers: " + headers);
			
			InputStream inputStream = inputPart.getBody(InputStream.class,null);
			
		    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		    int nRead;
		    byte[] data = new byte[1024];
		    while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
		        buffer.write(data, 0, nRead);
		    }
		 
		    buffer.flush();
		    bytes = buffer.toByteArray();
		}
		
		SaveCover saveCover = new SaveCover();
		saveCover.setArg0(id);
		saveCover.setArg1(bytes);
		SaveCoverResponse result = bookWsService.getBooksBeanPort().saveCover(saveCover);
		return Response.ok(result.isReturn()).build();
	}
	
	@GET
	@Produces("application/json")
	public Response allBooks(){
		
		BookArray books = bookWsService.getBooksBeanPort().findAll();
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
