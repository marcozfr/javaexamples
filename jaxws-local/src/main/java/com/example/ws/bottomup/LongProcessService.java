package com.example.ws.bottomup;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import javax.activation.DataHandler;
import javax.annotation.Resource;
import javax.jws.HandlerChain;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.xml.ws.Action;
import javax.xml.ws.BindingType;
import javax.xml.ws.FaultAction;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.soap.Addressing;
import javax.xml.ws.soap.AddressingFeature.Responses;
import javax.xml.ws.soap.MTOM;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.ws.domain.files.File;
import com.example.ws.domain.files.FileRef;
import com.sun.xml.ws.developer.JAXWSProperties;
import com.sun.xml.ws.rx.mc.api.MakeConnectionSupported;

@WebService(name = "LongProcessPortType", portName = "LongProcessPort", serviceName = "LongProcessService", targetNamespace = "http://process.ws.example.com")
@HandlerChain(file="secure-handler.xml")
@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
@MTOM(enabled = true, threshold = 3000)
@Addressing(enabled = true, required = false, responses = Responses.ALL)
public class LongProcessService {

    private static Logger logger = LoggerFactory.getLogger(LongProcessService.class);

    private static Map<String, File> fileHolder = new HashMap<>();;

    private static void addFile(String key, File object) {
        fileHolder.put(key, object);
    }

    private static File getFile(String key) {
        return fileHolder.get(key);
    }

    @Resource
    WebServiceContext webServiceContext;

    @WebMethod(operationName = "run", exclude = false, action = "http://process.ws.example.com/run")
    @Action(input="runActionInput", output="runActionOutput", fault={@FaultAction(className=ProcessException.class,value="runActionFault")})
    public String run(String in,
            @WebParam(header = true, name = "reference", targetNamespace = "http://www.example.org/Headers") String reference)
            throws ProcessException {

        final int secs = ThreadLocalRandom.current().nextInt(1, 3);
        // new Thread(() -> {
        try {
            Thread.sleep(secs * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("Done in " + Thread.currentThread().getName());
        // }).start();

        return "Wroking " + in + " in background for " + secs + " seconds. Ref: " + reference;
    }

    @WebMethod
    @Oneway
    public void runLong(@WebParam(mode = Mode.IN) String in) {
        int secs = ThreadLocalRandom.current().nextInt(6, 10);
        try {
            Thread.sleep(secs * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("Worked on long process on " + in + " for " + secs + " seconds");
    }

    @WebMethod
    @SOAPBinding(parameterStyle = ParameterStyle.BARE)
    @WebResult(partName = "runResponse", header = true)
    public String runSecure(@WebParam(header = true) String token) {
        logger.info("Token: " + token);
        return "Called runSecure with token " + token + ", echo on " + Thread.currentThread().getName();
    }

    @WebMethod
    @SOAPBinding(parameterStyle = ParameterStyle.BARE)
    public String runUpload(@WebParam File file) {
        addFile(file.getName(), file);
        return "Received " + file.getName();
    }

    @WebMethod
    public File download(@WebParam String fileName) {
        return getFile(fileName);
    }

    @WebMethod
    public FileRef downloadWithswaRef(@WebParam String fileName) {
        File file = getFile(fileName);
        FileRef f = new FileRef();
        f.setContent(new DataHandler(file.getContent(), "image/jpeg"));
        f.setName(file.getName());
        return f;
    }

    @WebMethod
    @Oneway
    public final void checkHeaders(@WebParam(mode = Mode.IN) String message) {
        logger.info("Checking headers, message: " + message);
        String addrAction = (String) webServiceContext.getMessageContext().get(JAXWSProperties.ADDRESSING_ACTION);
        String addrFrom = (String) webServiceContext.getMessageContext().get(JAXWSProperties.ADDRESSING_FROM);
        String addrMessageId = (String) webServiceContext.getMessageContext().get(JAXWSProperties.ADDRESSING_MESSAGEID);
        logger.info("action: " + addrAction);
        logger.info("from: " + addrFrom);
        logger.info("messageid: " + addrMessageId);
    }

}
