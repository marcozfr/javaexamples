
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
    private final static QName _String_QNAME = new QName("http://remote.session.ejb.example.com/", "String");
    private final static QName _SaveCoverResponse_QNAME = new QName("http://remote.session.ejb.example.com/", "saveCoverResponse");
    private final static QName _SaveResponse_QNAME = new QName("http://remote.session.ejb.example.com/", "saveResponse");
    private final static QName _Books_QNAME = new QName("http://remote.session.ejb.example.com/", "books");
    private final static QName _GetCoverResponse_QNAME = new QName("http://remote.session.ejb.example.com/", "getCoverResponse");
    private final static QName _GetCover_QNAME = new QName("http://remote.session.ejb.example.com/", "getCover");
    private final static QName _SaveCover_QNAME = new QName("http://remote.session.ejb.example.com/", "saveCover");
    private final static QName _FindById_QNAME = new QName("http://remote.session.ejb.example.com/", "findById");
    private final static QName _Book_QNAME = new QName("http://remote.session.ejb.example.com/", "book");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.app.ws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BookArray }
     * 
     */
    public BookArray createBookArray() {
        return new BookArray();
    }

    /**
     * Create an instance of {@link SaveCover }
     * 
     */
    public SaveCover createSaveCover() {
        return new SaveCover();
    }

    /**
     * Create an instance of {@link Book }
     * 
     */
    public Book createBook() {
        return new Book();
    }

    /**
     * Create an instance of {@link SaveCoverResponse }
     * 
     */
    public SaveCoverResponse createSaveCoverResponse() {
        return new SaveCoverResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://remote.session.ejb.example.com/", name = "String")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveCoverResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://remote.session.ejb.example.com/", name = "saveCoverResponse")
    public JAXBElement<SaveCoverResponse> createSaveCoverResponse(SaveCoverResponse value) {
        return new JAXBElement<SaveCoverResponse>(_SaveCoverResponse_QNAME, SaveCoverResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://remote.session.ejb.example.com/", name = "getCoverResponse")
    public JAXBElement<byte[]> createGetCoverResponse(byte[] value) {
        return new JAXBElement<byte[]>(_GetCoverResponse_QNAME, byte[].class, null, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://remote.session.ejb.example.com/", name = "getCover")
    public JAXBElement<Long> createGetCover(Long value) {
        return new JAXBElement<Long>(_GetCover_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveCover }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://remote.session.ejb.example.com/", name = "saveCover")
    public JAXBElement<SaveCover> createSaveCover(SaveCover value) {
        return new JAXBElement<SaveCover>(_SaveCover_QNAME, SaveCover.class, null, value);
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
