package com.example.web.model;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class ProductConverter implements Converter {

    @Override
    public boolean canConvert(Class arg0) {
        if(arg0.equals(Product.class)){
            return true;
        }
        return false;
    }
    
    @Override
    public void marshal(Object arg0, HierarchicalStreamWriter writer, MarshallingContext ctx) {
        Product p = (Product)arg0;
        writer.startNode("Product");
        writer.setValue(p.getCode());
        writer.endNode();
    }
    
    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext ctx) {
        Product p = new Product();
        reader.moveDown();
        p.setCode(reader.getValue());
        reader.moveUp();
        return p;
    }
    
}
