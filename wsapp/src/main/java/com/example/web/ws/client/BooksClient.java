package com.example.web.ws.client;

import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.xml.namespace.QName;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BooksClient {
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CatalogWServiceImplService service = new CatalogWServiceImplService();
        CatalogWServiceImpl serviceImpl = service.getCatalogWServiceImplPort();
//        List<AppBook> books = serviceImpl.getBook("");
        Future resp = serviceImpl.getBookAsync("", new BookHandler());
        System.out.println("Finishing method main ");
        
        // wait until book handler thread finishes 
        Thread.sleep(15*1000);
        System.out.println("exiting");
    }
    
    
    static class BookHandler implements AsyncHandler<GetBookResponse>{

        @Override
        public void handleResponse(Response<GetBookResponse> res) {
             try {
                 ObjectMapper om = new ObjectMapper();
                 GetBookResponse response =  res.get();
                 response.getReturn().stream().forEach(a -> {
                     try {
                        Thread.sleep(1000);
                        System.out.println(om.writeValueAsString(a));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                 });
                 
            } catch (InterruptedException | ExecutionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }
    
    static class BookSoapHandler implements SOAPHandler<SOAPMessageContext>{

        @Override
        public boolean handleMessage(SOAPMessageContext context) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean handleFault(SOAPMessageContext context) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public void close(MessageContext context) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public Set<QName> getHeaders() {
            // TODO Auto-generated method stub
            return null;
        }
        
    }

}
