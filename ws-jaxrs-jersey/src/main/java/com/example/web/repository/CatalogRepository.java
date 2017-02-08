package com.example.web.repository;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.example.web.model.AppCatalog;

public class CatalogRepository {
    

    private static AppCatalog catalog;
    
    static {
        
        InputStream catalogXml = Thread.currentThread().getContextClassLoader().getResourceAsStream("books.xml");
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(AppCatalog.class);
            
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            catalog = (AppCatalog) unmarshaller.unmarshal(catalogXml);
            
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    
    public static AppCatalog getAppCatalog(){
        return catalog;
    }

}
