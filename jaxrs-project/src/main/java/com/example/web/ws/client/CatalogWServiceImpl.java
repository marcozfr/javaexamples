
package com.example.web.ws.client;

import java.util.List;
import java.util.concurrent.Future;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.Response;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CatalogWServiceImpl", targetNamespace = "http://ws.web.example.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CatalogWServiceImpl {


    /**
     * 
     * @param arg0
     * @return
     *     returns javax.xml.ws.Response<com.example.web.ws.client.GetBookResponse>
     */
    @WebMethod(operationName = "getBook")
    @RequestWrapper(localName = "getBook", targetNamespace = "http://ws.web.example.com/", className = "com.example.web.ws.client.GetBook")
    @ResponseWrapper(localName = "getBookResponse", targetNamespace = "http://ws.web.example.com/", className = "com.example.web.ws.client.GetBookResponse")
    public Response<GetBookResponse> getBookAsync(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @param asyncHandler
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "getBook")
    @RequestWrapper(localName = "getBook", targetNamespace = "http://ws.web.example.com/", className = "com.example.web.ws.client.GetBook")
    @ResponseWrapper(localName = "getBookResponse", targetNamespace = "http://ws.web.example.com/", className = "com.example.web.ws.client.GetBookResponse")
    public Future<?> getBookAsync(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<GetBookResponse> asyncHandler);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<com.example.web.ws.client.AppBook>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getBook", targetNamespace = "http://ws.web.example.com/", className = "com.example.web.ws.client.GetBook")
    @ResponseWrapper(localName = "getBookResponse", targetNamespace = "http://ws.web.example.com/", className = "com.example.web.ws.client.GetBookResponse")
    @Action(input = "http://ws.web.example.com/CatalogWServiceImpl/getBookRequest", output = "http://ws.web.example.com/CatalogWServiceImpl/getBookResponse")
    public List<AppBook> getBook(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}