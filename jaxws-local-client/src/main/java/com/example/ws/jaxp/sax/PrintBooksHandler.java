package com.example.ws.jaxp.sax;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class PrintBooksHandler extends DefaultHandler {
	
	private static Logger logger = LoggerFactory.getLogger(PrintBooksHandler.class);
	
	List<String> bookNames;
	
	@Override
	public void startDocument() throws SAXException {
		logger.info("Start Xml document");
		bookNames = new ArrayList<>();
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if("book".equals(qName)){
			String id = attributes.getValue("id");
			logger.info("Book found with id: " + id);
		}
	}
	
	
	
	@Override
	public void endDocument() throws SAXException {
		logger.info("End Xml document");
	}

}
