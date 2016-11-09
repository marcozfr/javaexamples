
package com.example.web.ws.client;

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
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CatalogWServiceImplService", targetNamespace = "http://ws.web.example.com/", wsdlLocation = "http://localhost:8180/wsapp/jaxws/catalogWService?wsdl")
public class CatalogWServiceImplService
    extends Service
{

    private final static URL CATALOGWSERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException CATALOGWSERVICEIMPLSERVICE_EXCEPTION;
    private final static QName CATALOGWSERVICEIMPLSERVICE_QNAME = new QName("http://ws.web.example.com/", "CatalogWServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8180/wsapp/jaxws/catalogWService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CATALOGWSERVICEIMPLSERVICE_WSDL_LOCATION = url;
        CATALOGWSERVICEIMPLSERVICE_EXCEPTION = e;
    }

    public CatalogWServiceImplService() {
        super(__getWsdlLocation(), CATALOGWSERVICEIMPLSERVICE_QNAME);
    }

    public CatalogWServiceImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CATALOGWSERVICEIMPLSERVICE_QNAME, features);
    }

    public CatalogWServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, CATALOGWSERVICEIMPLSERVICE_QNAME);
    }

    public CatalogWServiceImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CATALOGWSERVICEIMPLSERVICE_QNAME, features);
    }

    public CatalogWServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CatalogWServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CatalogWServiceImpl
     */
    @WebEndpoint(name = "CatalogWServiceImplPort")
    public CatalogWServiceImpl getCatalogWServiceImplPort() {
        return super.getPort(new QName("http://ws.web.example.com/", "CatalogWServiceImplPort"), CatalogWServiceImpl.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CatalogWServiceImpl
     */
    @WebEndpoint(name = "CatalogWServiceImplPort")
    public CatalogWServiceImpl getCatalogWServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.web.example.com/", "CatalogWServiceImplPort"), CatalogWServiceImpl.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CATALOGWSERVICEIMPLSERVICE_EXCEPTION!= null) {
            throw CATALOGWSERVICEIMPLSERVICE_EXCEPTION;
        }
        return CATALOGWSERVICEIMPLSERVICE_WSDL_LOCATION;
    }

}
