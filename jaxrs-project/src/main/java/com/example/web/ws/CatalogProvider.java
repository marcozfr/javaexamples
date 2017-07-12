package com.example.web.ws;

import java.beans.XMLEncoder;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;

import javax.annotation.Resource;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.BindingType;
import javax.xml.ws.Provider;
import javax.xml.ws.Service.Mode;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;

import com.example.web.repository.CatalogRepository;

@WebServiceProvider
@ServiceMode(Mode.MESSAGE)
@BindingType(HTTPBinding.HTTP_BINDING)
public class CatalogProvider implements Provider<Source> {

    @Resource
    protected WebServiceContext wsCtx;
    
    
    @Override
    public Source invoke(Source request) {
        
        if(wsCtx==null)
            throw new RuntimeException("Injection failed on wsctx");
        
        MessageContext mctx = wsCtx.getMessageContext();
        String httpMethod = (String) mctx.get(MessageContext.HTTP_REQUEST_METHOD);
        if(httpMethod.equals("GET")){
            String qs = (String) mctx.get(MessageContext.QUERY_STRING);
            return toSource(toXml(CatalogRepository.getAppCatalog()));
        }
        return null;
    }
    
    private String toXml(Object obj) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        XMLEncoder enc = new XMLEncoder(out);
        enc.writeObject(obj);
        enc.close();
        return out.toString();
    }
    
    private StreamSource toSource(String str) {
        return new StreamSource(new StringReader(str));
    }

}
