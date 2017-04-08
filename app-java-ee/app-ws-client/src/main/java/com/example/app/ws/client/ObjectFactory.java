
package com.example.app.ws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.app.ws.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Save_QNAME = new QName("http://remote.session.ejb.example.com/", "save");
    private final static QName _SaveResponse_QNAME = new QName("http://remote.session.ejb.example.com/", "saveResponse");
    private final static QName _Books_QNAME = new QName("http://remote.session.ejb.example.com/", "books");
    private final static QName _BusinessException_QNAME = new QName("http://remote.session.ejb.example.com/", "BusinessException");
    private final static QName _FindById_QNAME = new QName("http://remote.session.ejb.example.com/", "findById");
    private final static QName _Book_QNAME = new QName("http://remote.session.ejb.example.com/", "book");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.app.ws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BusinessException }
     * 
     */
    public BusinessException createBusinessException() {
        return new BusinessException();
    }

    /**
     * Create an instance of {@link BookArray }
     * 
     */
    public BookArray createBookArray() {
        return new BookArray();
    }

    /**
     * Create an instance of {@link Book }
     * 
     */
    public Book createBook() {
        return new Book();
    }

    /**
     * Create an instance of {@link Item }
     * 
     */
    public Item createItem() {
        return new Item();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Book }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://remote.session.ejb.example.com/", name = "save")
    public JAXBElement<Book> createSave(Book value) {
        return new JAXBElement<Book>(_Save_QNAME, Book.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Book }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://remote.session.ejb.example.com/", name = "saveResponse")
    public JAXBElement<Book> createSaveResponse(Book value) {
        return new JAXBElement<Book>(_SaveResponse_QNAME, Book.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://remote.session.ejb.example.com/", name = "books")
    public JAXBElement<BookArray> createBooks(BookArray value) {
        return new JAXBElement<BookArray>(_Books_QNAME, BookArray.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BusinessException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://remote.session.ejb.example.com/", name = "BusinessException")
    public JAXBElement<BusinessException> createBusinessException(BusinessException value) {
        return new JAXBElement<BusinessException>(_BusinessException_QNAME, BusinessException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://remote.session.ejb.example.com/", name = "findById")
    public JAXBElement<Long> createFindById(Long value) {
        return new JAXBElement<Long>(_FindById_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Book }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://remote.session.ejb.example.com/", name = "book")
    public JAXBElement<Book> createBook(Book value) {
        return new JAXBElement<Book>(_Book_QNAME, Book.class, null, value);
    }

}
