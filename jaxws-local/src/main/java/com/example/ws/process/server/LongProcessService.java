package com.example.ws.process.server;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.Resource;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.MTOM;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.ws.domain.files.File;

@WebService(name="LongProcessPortType",portName="LongProcessPort",
    serviceName="LongProcessService",targetNamespace="http://process.ws.example.com")
//@HandlerChain(file="handler-chain.xml")
//@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP11HTTP_MTOM_BINDING) does not work.
@MTOM(enabled=true,threshold=3000)
public class LongProcessService {
	
	private static Logger logger = LoggerFactory.getLogger(LongProcessService.class);
	
	private static Map<String,File> fileHolder = new HashMap<>(); ;
	
	private static void addFile(String key, File object){
		fileHolder.put(key,object);
	}
	
	private static File getFile(String key){
		return fileHolder.get(key);
	}
	
    @Resource
    WebServiceContext webServiceContext;

    @WebMethod(operationName="run", exclude=false)
    public String run(String in) throws ProcessException {
        
        MessageContext messageContext = webServiceContext.getMessageContext();
        
        String pathInfo = (String) messageContext.get(MessageContext.QUERY_STRING);
        
        final int secs = ThreadLocalRandom.current().nextInt(1, 3);
//        new Thread(() -> {
            try {
                Thread.sleep(secs*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("Done in " + Thread.currentThread().getName());
//        }).start();
        
        return "Wroking "+ in +" in background for " + secs+ " seconds";
    }
    
    @WebMethod
    @Oneway
    public void runLong(@WebParam(mode=Mode.IN) String in){
        int secs = ThreadLocalRandom.current().nextInt(6, 10);
        try {
            Thread.sleep(secs*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("Worked on long process on "+ in +" for " + secs+ " seconds");
    }
    
    @WebMethod
    @SOAPBinding(parameterStyle=ParameterStyle.BARE)
    @WebResult(partName="runResponse",header=true)
    public String runSecure(@WebParam(header=true) String token){
    	logger.info("Token: " + token);
        return "Called runSecure with token "+token+", echo on " + Thread.currentThread().getName();
    }
    
    @WebMethod
    @SOAPBinding(parameterStyle=ParameterStyle.BARE)
    public String runUpload(@WebParam File file){
    	addFile(file.getName(), file);
    	return "Received " + file.getName();
    }
    
    @WebMethod
    public File download(@WebParam String fileName){
    	return getFile(fileName);
    }
    
//    @WebMethod
//    @Addressing(enabled=true)
//    public String runAddressed(){
//    	
//    }

}
