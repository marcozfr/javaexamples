package com.example.web.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.app.ws.client.aws.AWSECommerceService;
import com.example.app.ws.client.aws.ItemSearch;
import com.example.app.ws.client.aws.ItemSearchRequest;
import com.example.app.ws.client.aws.ItemSearchResponse;
import com.example.app.ws.client.aws.Items;

@Path("/aws")
public class AwsClientResource {

    @GET
    @Path("/searchItems")
    @Produces(MediaType.APPLICATION_XML)
    public Response itemSearch(@QueryParam("secretKey") String secretKey, 
            @QueryParam("searchIndex") String searchIndex, 
            @QueryParam("keywords") String keywords){
        
        AWSECommerceService service = new AWSECommerceService();
        
        ItemSearchRequest itemSearchRequest = new ItemSearchRequest();
        itemSearchRequest.setSearchIndex(searchIndex);
        itemSearchRequest.setKeywords(keywords);
        
        ItemSearch itemSearch = new ItemSearch();
        itemSearch.setAWSAccessKeyId(secretKey);
        itemSearch.setAssociateTag("kalin");
        itemSearch.getRequest().add(itemSearchRequest);
        
        ItemSearchResponse itemSearchResponse = service.getAWSECommerceServicePort().itemSearch(itemSearch);
        
        GenericEntity<List<Items>> itemsEntity = new GenericEntity(itemSearchResponse.getItems()){};
        return Response.ok(itemsEntity).build();
    }
    
}
