package com.example.ejb.session;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.MTOM;

import com.example.ejb.exception.BusinessException;
import com.example.ejb.session.extension.LoggingInterceptor;
import com.example.ejb.session.local.BooksLocal;
import com.example.ejb.session.remote.BooksRemote;
import com.example.model.catalog.Book;

@Stateless
@Remote(BooksRemote.class)
@WebService(endpointInterface="com.example.ejb.session.remote.BooksRemote",name="BookService",portName="BookServicePort")
@Interceptors(LoggingInterceptor.class)
//@BindingType(value=javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_MTOM_BINDING)
@MTOM
public class BooksBean implements BooksLocal,BooksRemote {

	@Resource
	private WebServiceContext wsContext;
	
	@Resource
	private SessionContext sessionContext;
	
    @PersistenceContext(unitName="catalogPU")
    private EntityManager entityManager;
    
    @Override
//    @PermitAll
//    @WebMethod(exclude=true)
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
    public Book saveBook(Book book) throws BusinessException {
    	
    	if(book.getTags() == null || book.getTags().isEmpty()){
    		throw new BusinessException("0012", "Item Tags are required");
    	}
    	
        entityManager.persist(book);
        return book;
    }
    
    public byte[] getBookCover(Long id){
    	Query q = entityManager.createNamedQuery("getBookCover");
    	q.setParameter("itemId", id);
    	byte[] img = (byte[])q.getSingleResult();
    	return img;
    }

	@Override
	public boolean saveBookCover(Long bookId, byte[] cover) {
		Query q = entityManager.createQuery("update Book b set b.cover = :cover where b.itemId = :id");
		q.setParameter("id", bookId);
		q.setParameter("cover", cover);
		int i = q.executeUpdate();
		return i >= 0 ? true :false;
	}
    

}
