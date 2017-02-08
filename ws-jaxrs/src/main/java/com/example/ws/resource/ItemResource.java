package com.example.ws.resource;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Variant;

import com.example.ws.model.Item;
//import com.thoughtworks.xstream.XStream;
//import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
//import com.thoughtworks.xstream.io.xml.DomDriver;

@Path("/item")
public class ItemResource {
	
//	@Path("/create")
//	@POST
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@Produces(value={MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
//	public String getItem(MultivaluedMap<String,String> form,
//			@Context Request request, @Context HttpHeaders headers){
//		
//		Item item = new Item(Integer.valueOf(form.getFirst("id")),form.getFirst("note"),form.getFirst("url"));
//		
//		XStream xstream = null;
//		
//		Map<String, String> m = new HashMap<>();
//		m.put("version", "1");
//		MediaType mt = new MediaType("application", "vnd.vz+xml", m);
//		
//		System.out.println(headers.getAcceptableMediaTypes());
//		Variant variant = request.selectVariant(Variant.mediaTypes(MediaType.APPLICATION_JSON_TYPE,MediaType.APPLICATION_XML_TYPE)
//				.add().mediaTypes(mt).build());
//		
//		if(MediaType.APPLICATION_XML_TYPE.equals(variant.getMediaType())){
//			xstream = new XStream(new DomDriver());
//		}else {
//			xstream = new XStream(new JsonHierarchicalStreamDriver());
//		}
//		
//		xstream.alias("Item", Item.class);
//		String xmlItem = xstream.toXML(item);
//		return xmlItem;
//		
//	}

}
