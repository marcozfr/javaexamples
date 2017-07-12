package com.example.web.rest.restlet;

import org.restlet.Component;
import org.restlet.data.Protocol;

public class RestletApp {
    
    public static void main(String[] args) throws Exception {
        Component component = new Component();
        component.getServers().add(Protocol.HTTP,8182);
        component.getDefaultHost().attach("/restletapp",new RestletAppConfig());
        component.start();
    }

}
