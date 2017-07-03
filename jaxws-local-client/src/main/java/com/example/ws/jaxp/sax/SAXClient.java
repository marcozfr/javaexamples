package com.example.ws.jaxp.sax;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class SAXClient {
    
    public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException {
        
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setValidating(true);
        SAXParser saxParser = spf.newSAXParser();
        XMLReader reader = saxParser.getXMLReader();
        reader.setContentHandler();
        
        InputStream istr = spf.getClass().getResourceAsStream("floresro@floresrojasart.com.xml");
        InputSource isource = new InputSource(istr);
        reader.parse(isource);
        
    }

}
