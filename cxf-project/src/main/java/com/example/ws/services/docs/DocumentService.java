package com.example.ws.services.docs;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.example.ws.model.LegalDocument;

@WebService
public class DocumentService {
    
    @WebMethod(operationName="document")
    public LegalDocument getDocumentById(Long id){
        LegalDocument d = new LegalDocument();
        d.setId(10023l);
        d.setSummary("Recent investigation");
        d.setTitle("CQRS Research");
        return d;
    }

}
