
package com.example.web.ws.service.process.gen;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b14002
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "LongProcessService", targetNamespace = "http://process.service.ws.web.example.com/", wsdlLocation = "http://localhost:8080/app-war-project/LongProcessService?wsdl")
public class LongProcessService
    extends Service
{

    private final static URL LONGPROCESSSERVICE_WSDL_LOCATION;
    private final static WebServiceException LONGPROCESSSERVICE_EXCEPTION;
    private final static QName LONGPROCESSSERVICE_QNAME = new QName("http://process.service.ws.web.example.com/", "LongProcessService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/app-war-project/LongProcessService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        LONGPROCESSSERVICE_WSDL_LOCATION = url;
        LONGPROCESSSERVICE_EXCEPTION = e;
    }

    public LongProcessService() {
        super(__getWsdlLocation(), LONGPROCESSSERVICE_QNAME);
    }

    public LongProcessService(WebServiceFeature... features) {
        super(__getWsdlLocation(), LONGPROCESSSERVICE_QNAME, features);
    }

    public LongProcessService(URL wsdlLocation) {
        super(wsdlLocation, LONGPROCESSSERVICE_QNAME);
    }

    public LongProcessService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, LONGPROCESSSERVICE_QNAME, features);
    }

    public LongProcessService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public LongProcessService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns LongProcessServiceRef
     */
    @WebEndpoint(name = "LongProcessServicePort")
    public LongProcessServiceRef getLongProcessServicePort() {
        return super.getPort(new QName("http://process.service.ws.web.example.com/", "LongProcessServicePort"), LongProcessServiceRef.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns LongProcessServiceRef
     */
    @WebEndpoint(name = "LongProcessServicePort")
    public LongProcessServiceRef getLongProcessServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://process.service.ws.web.example.com/", "LongProcessServicePort"), LongProcessServiceRef.class, features);
    }

    private static URL __getWsdlLocation() {
        if (LONGPROCESSSERVICE_EXCEPTION!= null) {
            throw LONGPROCESSSERVICE_EXCEPTION;
        }
        return LONGPROCESSSERVICE_WSDL_LOCATION;
    }

}
