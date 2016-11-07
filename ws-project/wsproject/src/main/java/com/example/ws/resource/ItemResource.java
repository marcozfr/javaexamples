package com.example.ws.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.ws.model.Item;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;

@Path("/item")
public class ItemResource {
	
	@Path("/create")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(value={MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public String getItem(@FormParam("id") Integer id,
			@FormParam("note") String note, 
			@HeaderParam("Accept") String accept){
		
		Item item = new Item(id,note,null);
		
		XStream xstream = null;
		
		if(accept.equals(MediaType.APPLICATION_XML)){
			xstream = new XStream(new DomDriver());
		}else {
			xstream = new XStream(new JsonHierarchicalStreamDriver());
		}
		
		xstream.alias("Item", Item.class);
		String xmlItem = xstream.toXML(item);
		return xmlItem;
		
	}

}
