package com.example.ws.resource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.Reader;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;

import com.example.ws.model.Book;

/**
 * shows usage of Source, StreamingOutput, byte[] and Reader
 * @author floma4y
 *
 */
public class HandlersResource {
    
    @Path("put-book-xml")
    @PUT
    @Consumes({"text/xml;q=1.0","application/xml"})
    @Produces("application/json")
    public Book putBook(Source source) throws JAXBException{
        
        JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Book book = (Book) unmarshaller.unmarshal(source);
        
        return book;
    }
    
    
    @Path("echo-bytes")
    @POST
    public byte[] echoBytes(byte[] data){
        return data;
    }
    
    @Path("read-lines")
    @PUT
    @Consumes("text/plain")
    public Response putLines(Reader in) throws IOException{
        LineNumberReader lineReader = new LineNumberReader(in);
        String line = lineReader.readLine();
        
        return Response.ok(line).build();
    }
    
    @Path("streaming-pdf")
    @GET
    @Produces("application/pdf")
    public StreamingOutput getReport(@Context ServletContext context) throws IOException{
        
        InputStream is = context.getResourceAsStream("/WEB-INF/pdf/eCertificate.pdf");
        
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        
        int nRead;
        byte[] data = new byte[1024];
        while ((nRead = is.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
     
        buffer.flush();
        byte[] byteArray = buffer.toByteArray();
        
        return new StreamingOutput() {
            @Override
            public void write(OutputStream output) throws IOException, WebApplicationException {
                output.write(byteArray);
            }
        };
    }

}
