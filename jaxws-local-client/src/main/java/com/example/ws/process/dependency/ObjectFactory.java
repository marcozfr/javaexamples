
package com.example.ws.process.dependency;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.ws.process.dependency package. 
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

    private final static QName _AddressedService_QNAME = new QName("http://process.ws.example.com", "addressedService");
    private final static QName _ProcessException_QNAME = new QName("http://process.ws.example.com", "ProcessException");
    private final static QName _AddressedServiceResponse_QNAME = new QName("http://process.ws.example.com", "addressedServiceResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.ws.process.dependency
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ProcessException }
     * 
     */
    public ProcessException createProcessException() {
        return new ProcessException();
    }

    /**
     * Create an instance of {@link AddressedServiceResponse }
     * 
     */
    public AddressedServiceResponse createAddressedServiceResponse() {
        return new AddressedServiceResponse();
    }

    /**
     * Create an instance of {@link AddressedService }
     * 
     */
    public AddressedService createAddressedService() {
        return new AddressedService();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddressedService }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://process.ws.example.com", name = "addressedService")
    public JAXBElement<AddressedService> createAddressedService(AddressedService value) {
        return new JAXBElement<AddressedService>(_AddressedService_QNAME, AddressedService.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcessException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://process.ws.example.com", name = "ProcessException")
    public JAXBElement<ProcessException> createProcessException(ProcessException value) {
        return new JAXBElement<ProcessException>(_ProcessException_QNAME, ProcessException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddressedServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://process.ws.example.com", name = "addressedServiceResponse")
    public JAXBElement<AddressedServiceResponse> createAddressedServiceResponse(AddressedServiceResponse value) {
        return new JAXBElement<AddressedServiceResponse>(_AddressedServiceResponse_QNAME, AddressedServiceResponse.class, null, value);
    }

}
