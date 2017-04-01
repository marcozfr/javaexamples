package com.example.ws.resource;

import javax.servlet.ServletResponse;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

@Path("/order")
public class OrdersResource {
	
	@Context
	ServletResponse response;
	
//	@Path("/toJson")
//	@POST
//	@Consumes(MediaType.APPLICATION_XML)
//	@Produces(value={MediaType.APPLICATION_JSON})
//	public void getItem(InputStream is) throws SAXException, JAXBException, IOException{
//		
//		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); 
//		Schema schema = sf.newSchema(OrdersResource.class.getClassLoader().getResource("purchaseOrder.xsd"));
//		
//		JAXBContext ctx = JAXBContext.newInstance(PurchaseOrderType.class);
//		Unmarshaller um = ctx.createUnmarshaller();
//		um.setSchema(schema);
//		
//		PurchaseOrderType orders = (PurchaseOrderType)um.unmarshal(is);
//		
//		XStream xs = new XStream(new JsonHierarchicalStreamDriver());
//		xs.toXML(orders,response.getOutputStream());
//	}

}
