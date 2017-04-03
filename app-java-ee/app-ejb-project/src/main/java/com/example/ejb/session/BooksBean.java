package com.example.ejb.session;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import com.example.ejb.session.extension.LoggingInterceptor;
import com.example.ejb.session.local.BooksLocal;
import com.example.ejb.session.remote.BooksRemote;
import com.example.model.catalog.Book;

@Stateless
@Remote(BooksRemote.class)
@WebService(endpointInterface="com.example.ejb.session.remote.BooksRemote",name="BookService",portName="BookServicePort")
@Interceptors(LoggingInterceptor.class)
public class BooksBean implements BooksLocal,BooksRemote {

	@Resource
	private WebServiceContext wsContext;
	
	@Resource
	private SessionContext sessionContext;
	
    @PersistenceContext(unitName="catalogPU")
    private EntityManager entityManager;
    
    @Override
//    @PermitAll
    @WebMethod(exclude=true)
    public Book findBookById(Long bookId) {
        return entityManager.find(Book.class, bookId);
    }
    
    @Override
//    @PermitAll
    public List<Book> findAllBooks() {
    	
    	if(wsContext!=null){
    		Object headers = wsContext.getMessageContext().get(MessageContext.HTTP_REQUEST_HEADERS);
        	System.out.println(headers);
    	}
    	
        TypedQuery<Book> q = entityManager.createNamedQuery("findAllBooks",Book.class);
        return q.getResultList();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
//    @RolesAllowed("ADMIN")
    public Book saveBook(Book book) {
        entityManager.persist(book);
        return book;
    }
    
    

}
