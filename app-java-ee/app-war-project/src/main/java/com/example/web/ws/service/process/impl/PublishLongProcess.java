package com.example.web.ws.service.process.impl;

import javax.xml.ws.Endpoint;

public class PublishLongProcess {
    
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9090/LongProcessService", new LongProcessServiceImpl());
    }

}
