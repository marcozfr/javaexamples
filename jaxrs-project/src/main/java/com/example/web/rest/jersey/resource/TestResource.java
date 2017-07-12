package com.example.web.rest.jersey.resource;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Locale;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.Encoded;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.StreamingOutput;

import com.example.web.app.exception.LocalException;
import com.example.web.model.Product;

@Path("/r")
public class TestResource {

    @Path("/resource")
    @GET
    public String getResource(@PathParam("id") String id) {
        return id;
    }

    @Path("{id:[ABC]}")
    public InspectorResource getTest1Resource() {
        return new TestResource.InspectorResource();
    }

    public static class InspectorResource {

        @GET
        @Path("matrix")
        public String getResource(@PathParam("id") String id, @MatrixParam("mp") String param) {
            return param != null ? id.concat(";mp=").concat(param) : id;
        }

        @GET
        @Path("withsegment")
        public String getPathSegmentResource(@PathParam("id") PathSegment idSegment) {
            MultivaluedMap<String, String> mps = idSegment.getMatrixParameters();
            return mps.toString();
        }

        @GET
        @Path("headers")
        public StreamingOutput getPathSegmentResource(@Context HttpHeaders headers, 
                @HeaderParam("Referer") URL Referer) {
            return new StreamingOutput() {

                @Override
                public void write(OutputStream output) throws IOException, WebApplicationException {
                    PrintStream pr = new PrintStream(output);
                    pr.print("<h2>Headers</h2>");
                    for (String key : headers.getRequestHeaders().keySet()) {
                        pr.print("<div>" + key + " : " + headers.getHeaderString(key) + "<br></div>");
                    }
                    pr.print("<h2>Cookies</h2>");
                    for(String c : headers.getCookies().keySet()){
                        pr.print("<div>" + c + " : " + headers.getCookies().get(c).getValue() + "<br></div>");
                    };
                }
            };
        }
        
        @GET
        @Path("cookies")
        @Produces("text/html")
        public String getPathSegmentResource(
                @CookieParam("mycookie") String mycookie,
                @CookieParam("JSESSIONID") Cookie jsessionId) {
            StringBuilder sb = new StringBuilder();
            sb.append("mycookie:" + mycookie);
            if(jsessionId!=null){
                sb.append("JSESSIONID:" + jsessionId.getPath() +"#"+jsessionId.getValue()); 
            }
            return sb.toString();
        }
        
        @GET
        @Path("encodeParams")
        public String getEncodeParams( 
                @Encoded @QueryParam("param") String param) {
            return param.toString();
        }
        
        @Path("multivalued")
        @POST
        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
        @Produces(MediaType.APPLICATION_FORM_URLENCODED)
        public MultivaluedMap<String,String> postMultivalue(
                MultivaluedMap<String,String> form){
            return form;
        }
        
        
        @Path("getproduct")
        @POST
        @Consumes("application/x-www-form-urlencoded")
        @Produces("application/json")
        public Product createProduct(MultivaluedMap<String,String> form){
            String code = form.getFirst("code");
            String height = form.getFirst("height");
            String width = form.getFirst("width");
            String depth = form.getFirst("depth");
            return new Product(code, new BigDecimal(height), new BigDecimal(width), new BigDecimal(depth));
        }
        
        @Path("readproduct")
        @POST
        @Consumes("application/json")
        public Response readProduct(Product product){
            System.out.println("Product ");
            System.out.println("code: "+product.getCode());
            System.out.println("color: "+product.getColor());
            System.out.println("id: "+product.getId());
            
            ResponseBuilder rb = Response.ok();
            rb.language(Locale.ENGLISH)
                .header("Status", "Ok");
            
            NewCookie cookie = new NewCookie("pd", String.valueOf(product.getId()));
            rb.cookie(cookie);
            
            return rb.build();
        }
        
        @Path("exception")
        @GET
        @Produces("text/html")
        public Response genException(@QueryParam("gen") String gen){
            if(gen == null){
                throw new LocalException("No param");
            }
            
            if(gen.equals("gen")){
                throw new NotFoundException();
            }
            
            return Response.status(Status.BAD_GATEWAY).build();
        }
        
    }

}
