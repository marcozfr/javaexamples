
package com.example.ws.service.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.ws.service.client package. 
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

    private final static QName _NextResponse_QNAME = new QName("http://service.ws.example.com/", "nextResponse");
    private final static QName _NextNResponse_QNAME = new QName("http://service.ws.example.com/", "nextNResponse");
    private final static QName _NextN_QNAME = new QName("http://service.ws.example.com/", "nextN");
    private final static QName _Next_QNAME = new QName("http://service.ws.example.com/", "next");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.ws.service.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Next }
     * 
     */
    public Next createNext() {
        return new Next();
    }

    /**
     * Create an instance of {@link NextResponse }
     * 
     */
    public NextResponse createNextResponse() {
        return new NextResponse();
    }

    /**
     * Create an instance of {@link NextNResponse }
     * 
     */
    public NextNResponse createNextNResponse() {
        return new NextNResponse();
    }

    /**
     * Create an instance of {@link NextN }
     * 
     */
    public NextN createNextN() {
        return new NextN();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NextResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.example.com/", name = "nextResponse")
    public JAXBElement<NextResponse> createNextResponse(NextResponse value) {
        return new JAXBElement<NextResponse>(_NextResponse_QNAME, NextResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NextNResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.example.com/", name = "nextNResponse")
    public JAXBElement<NextNResponse> createNextNResponse(NextNResponse value) {
        return new JAXBElement<NextNResponse>(_NextNResponse_QNAME, NextNResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NextN }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.example.com/", name = "nextN")
    public JAXBElement<NextN> createNextN(NextN value) {
        return new JAXBElement<NextN>(_NextN_QNAME, NextN.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Next }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.example.com/", name = "next")
    public JAXBElement<Next> createNext(Next value) {
        return new JAXBElement<Next>(_Next_QNAME, Next.class, null, value);
    }

}
