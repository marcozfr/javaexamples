package com.example.web.model;

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
