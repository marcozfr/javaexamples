package com.example.web.rest.restlet;

import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import com.example.web.rest.restlet.resource.DummyResource;

public class RestletAppConfig extends org.restlet.Application {
    
    @Override
    public synchronized Restlet createInboundRoot() {
        Router router = new Router(getContext());
        
        Restlet restlet = new Restlet() {
            @Override
            public void handle(Request req, Response res) {
                res.setEntity("<test></test>", org.restlet.data.MediaType.APPLICATION_XML);
            }
        };
        
        router.attach("/test", restlet);
        router.attach("/catalog", DummyResource.class);
        return router;
    }
}
