package com.example.ws.jaxp.stax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.events.XMLEvent;

public class StAXProcessor {
    
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        StAXProcessor processor = new StAXProcessor();
        String folderXML = "folder.xml";
        processor.writeXMLDocument(folderXML);
        processor.readXMLDocumentIterator(folderXML);
        processor.readXMLDocumentCursor(folderXML);
    }
    
    private void readXMLDocumentCursor(String folderXML) throws XMLStreamException, FileNotFoundException {
        XMLInputFactory input = XMLInputFactory.newFactory();
        input.setProperty(XMLInputFactory.IS_VALIDATING, "yes");
        XMLEventReader evtReader = input.createXMLEventReader(new FileInputStream(folderXML));
        while(evtReader.hasNext()){
            XMLEvent evt = evtReader.nextEvent();
            if(evt.isStartElement()){
            }
        }
    }

    public void readXMLDocumentIterator(String folderXML) throws FileNotFoundException, XMLStreamException {
        XMLInputFactory input = XMLInputFactory.newFactory();
        input.setProperty(XMLInputFactory.IS_VALIDATING, "yes");
        XMLStreamReader reader = input.createXMLStreamReader(new FileInputStream(folderXML));
        while(reader.hasNext()){
             reader.next();
        };
    }

    public void writeXMLDocument(String folderXML) throws FileNotFoundException, XMLStreamException{
        XMLOutputFactory output = XMLOutputFactory.newFactory();
        XMLStreamWriter writer = output.createXMLStreamWriter(new FileOutputStream(folderXML));
        
        writer.writeStartDocument("1.0");
        writer.setPrefix("d", "http://example.org/document");
        
        writer.writeStartElement("http://example.org/document","document");
        writer.writeNamespace("d", "http://example.org/document");
        writer.writeAttribute("id","3400");
        
        writer.writeStartElement("http://example.org/document","reference");
        writer.writeCharacters("CF99238832");
        writer.writeEndElement();
        
        writer.writeStartElement("http://example.org/document","content");
        writer.writeCData("Digital Transformation is taking place in different areas of companies");
        writer.writeEndElement();
        
        writer.writeEndElement();
        writer.writeEndDocument();
        writer.flush();
        
    }

}
