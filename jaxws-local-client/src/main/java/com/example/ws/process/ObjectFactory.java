
package com.example.ws.process;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.ws.process package. 
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

    private final static QName _RunResponse_QNAME = new QName("http://process.ws.example.com", "runResponse");
    private final static QName _Run_QNAME = new QName("http://process.ws.example.com", "run");
    private final static QName _RunLong_QNAME = new QName("http://process.ws.example.com", "runLong");
    private final static QName _ProcessException_QNAME = new QName("http://process.ws.example.com", "ProcessException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.ws.process
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
     * Create an instance of {@link RunLong }
     * 
     */
    public RunLong createRunLong() {
        return new RunLong();
    }

    /**
     * Create an instance of {@link Run }
     * 
     */
    public Run createRun() {
        return new Run();
    }

    /**
     * Create an instance of {@link RunResponse }
     * 
     */
    public RunResponse createRunResponse() {
        return new RunResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RunResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://process.ws.example.com", name = "runResponse")
    public JAXBElement<RunResponse> createRunResponse(RunResponse value) {
        return new JAXBElement<RunResponse>(_RunResponse_QNAME, RunResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Run }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://process.ws.example.com", name = "run")
    public JAXBElement<Run> createRun(Run value) {
        return new JAXBElement<Run>(_Run_QNAME, Run.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RunLong }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://process.ws.example.com", name = "runLong")
    public JAXBElement<RunLong> createRunLong(RunLong value) {
        return new JAXBElement<RunLong>(_RunLong_QNAME, RunLong.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcessException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://process.ws.example.com", name = "ProcessException")
    public JAXBElement<ProcessException> createProcessException(ProcessException value) {
        return new JAXBElement<ProcessException>(_ProcessException_QNAME, ProcessException.class, null, value);
    }

}
