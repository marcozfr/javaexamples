
package com.example.web.ws.service.process.gen;

import java.util.concurrent.Future;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.Response;
import javax.xml.ws.ResponseWrapper;
import com.example.web.ws.service.process.ObjectFactory;
import com.example.web.ws.service.process.RunResponse;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b14002
 * Generated source version: 2.2
 * 
 */
@WebService(name = "LongProcessPortType", targetNamespace = "http://process.service.ws.web.example.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface LongProcessServiceRef {


    /**
     * 
     * @param arg0
     * @return
     *     returns javax.xml.ws.Response<com.example.web.ws.service.process.RunResponse>
     */
    @WebMethod(operationName = "run")
    @RequestWrapper(localName = "run", targetNamespace = "http://process.service.ws.web.example.com/", className = "com.example.web.ws.service.process.Run")
    @ResponseWrapper(localName = "runResponse", targetNamespace = "http://process.service.ws.web.example.com/", className = "com.example.web.ws.service.process.RunResponse")
    public Response<RunResponse> runProcessAsync(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @param asyncHandler
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "run")
    @RequestWrapper(localName = "run", targetNamespace = "http://process.service.ws.web.example.com/", className = "com.example.web.ws.service.process.Run")
    @ResponseWrapper(localName = "runResponse", targetNamespace = "http://process.service.ws.web.example.com/", className = "com.example.web.ws.service.process.RunResponse")
    public Future<?> runProcessAsync(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<RunResponse> asyncHandler);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "run")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "run", targetNamespace = "http://process.service.ws.web.example.com/", className = "com.example.web.ws.service.process.Run")
    @ResponseWrapper(localName = "runResponse", targetNamespace = "http://process.service.ws.web.example.com/", className = "com.example.web.ws.service.process.RunResponse")
    public String runProcess(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
