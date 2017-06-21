package com.example.ws.topdown.rpc;

import java.util.concurrent.ThreadLocalRandom;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(name = "TopDownRpcService", targetNamespace = "http://www.example.org/TopDownRpcService/",
        endpointInterface="com.example.ws.rpc.topdown.TopDownRpcService")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class TopDownRpcServiceImpl implements TopDownRpcService {
    
    @Override
    public ProductResponse registerProduct(String name, String weight, String label, String tag, double price)
            throws RegisterProductFault {
        if(price <= 0){
            throw new RegisterProductFault("validation error", 
                    new ProductResponseFault(){
                {
                    setDetails("Please provide a valid price");
                }
            });
        }
        ProductResponse response = new ProductResponse();
        response.setId(ThreadLocalRandom.current().nextLong());
        response.setStatus("REGISTERED");
        return response;
    }

}
