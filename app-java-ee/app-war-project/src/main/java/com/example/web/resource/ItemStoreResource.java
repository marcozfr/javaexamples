package com.example.web.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.ws.WebServiceRef;

import com.example.ejb.session.ItemStoreBean;
import com.example.model.catalog.Store;

@Path("/store")
public class ItemStoreResource {

    @WebServiceRef
    private ItemStoreBean itemStoreBean;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveStore(Store store){
        
        itemStoreBean.saveStore(store);
        
        return Response.ok(store,MediaType.APPLICATION_JSON).build();
    }
    
}
