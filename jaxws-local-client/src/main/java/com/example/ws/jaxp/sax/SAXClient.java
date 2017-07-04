package com.example.ws.jaxp.sax;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class SAXClient {
	
	private static Logger logger = LoggerFactory.getLogger(SAXClient.class);
    
    public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException {
        
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setValidating(true);
        SAXParser saxParser = spf.newSAXParser();
        XMLReader reader = saxParser.getXMLReader();
        reader.setContentHandler(new PrintBooksHandler());
        
        InputStream istr = SAXClient.class.getResourceAsStream("/xml/catalog.xml");
        InputSource isource = new InputSource(istr);
        reader.parse(isource);
        
    }

}
