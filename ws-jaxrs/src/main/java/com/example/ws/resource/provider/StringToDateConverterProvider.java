package com.example.ws.resource.provider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Arrays;
import java.util.Date;

import javax.swing.text.DateFormatter;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

@Provider
public class StringToDateConverterProvider implements ParamConverterProvider {

    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
        if(Date.class.equals(rawType)){
            new StringToDateConverter();
        }
        
        return null;
    }
    
    
    
    static class StringToDateConverter implements ParamConverter<Date>{
        
        private static final String FORMAT = "ddMMyyyy";
        private final DateFormat df = new SimpleDateFormat(FORMAT);
        
        @Override
        public Date fromString(String value) {
            try {
                return df.parse(value);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public String toString(Date value) {
            return df.format(value);
        }
        
    }

}
