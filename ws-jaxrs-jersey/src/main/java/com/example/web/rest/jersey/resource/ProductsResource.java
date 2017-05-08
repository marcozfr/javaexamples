package com.example.web.rest.jersey.resource;

import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.example.web.datalayer.ProductSessionBean;
import com.example.web.model.Product;

@Path("/products")
public class ProductsResource {
    
    @EJB
    ProductSessionBean productSessionBean;
    
    @Context
    ServletConfig servletConfig;

    @Path("/insert")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_XML)
    public Product createProductCatalog(
            @FormParam("code") String code,
            @FormParam("height") Double height,
            @FormParam("width") Double width,
            @FormParam("depth") Double depth){
        
        Product product = new Product(code, new BigDecimal(height), new BigDecimal(width), new BigDecimal(depth));
        
        productSessionBean.save(product);
        
//        XStream xs =new XStream(new DomDriver());
//        //xs.registerConverter(new ProductConverter());
//        xs.alias("product", Product.class);
//        String xml = xs.toXML(product);
//        //System.out.println(xml);
//        Product p = (Product)xs.fromXML(xml);
        System.out.println("id of created product " + product.getId());
        return product;
    }
    
}
