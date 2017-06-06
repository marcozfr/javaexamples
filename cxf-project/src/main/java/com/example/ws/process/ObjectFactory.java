
package com.example.ws.process;

import javax.xml.bind.annotation.XmlRegistry;


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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.ws.process
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link StartProcessRequest }
     * 
     */
    public StartProcessRequest createStartProcessRequest() {
        return new StartProcessRequest();
    }

    /**
     * Create an instance of {@link StartProcessResponse }
     * 
     */
    public StartProcessResponse createStartProcessResponse() {
        return new StartProcessResponse();
    }

    /**
     * Create an instance of {@link CheckProcessStatusRequest }
     * 
     */
    public CheckProcessStatusRequest createCheckProcessStatusRequest() {
        return new CheckProcessStatusRequest();
    }

    /**
     * Create an instance of {@link CheckProcessStatusResponse }
     * 
     */
    public CheckProcessStatusResponse createCheckProcessStatusResponse() {
        return new CheckProcessStatusResponse();
    }

    /**
     * Create an instance of {@link FinishProcessRequest }
     * 
     */
    public FinishProcessRequest createFinishProcessRequest() {
        return new FinishProcessRequest();
    }

    /**
     * Create an instance of {@link FinishProcessResponse }
     * 
     */
    public FinishProcessResponse createFinishProcessResponse() {
        return new FinishProcessResponse();
    }

}
