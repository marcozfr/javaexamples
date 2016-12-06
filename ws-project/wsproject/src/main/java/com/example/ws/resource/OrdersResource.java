package com.example.ws.resource;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import com.example.ws.model.orders.PurchaseOrderType;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;

@Path("/order")
public class OrdersResource {
	
	@Context
	ServletResponse response;
	
	@Path("/toJson")
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(value={MediaType.APPLICATION_JSON})
	public void getItem(InputStream is) throws SAXException, JAXBException, IOException{
		
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); 
		Schema schema = sf.newSchema(OrdersResource.class.getClassLoader().getResource("purchaseOrder.xsd"));
		
		JAXBContext ctx = JAXBContext.newInstance(PurchaseOrderType.class);
		Unmarshaller um = ctx.createUnmarshaller();
		um.setSchema(schema);
		
		PurchaseOrderType orders = (PurchaseOrderType)um.unmarshal(is);
		
		XStream xs = new XStream(new JsonHierarchicalStreamDriver());
		xs.toXML(orders,response.getOutputStream());
	}

}
