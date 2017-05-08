package com.example.ws.resource;

import javax.ws.rs.Path;

@Path("features")
public class FeaturesResource {
    
    @Path("cache")
    public CacheFeaturesResource getCacheFeatures(){
        return new CacheFeaturesResource();
    }
    
    @Path("params")
    public ParamsFeaturesResource getParamsFeatures(){
        return new ParamsFeaturesResource();
    }

    @Path("paths")
    public PathFeaturesResource getPathFeatures(){
        return new PathFeaturesResource();
    }
    
    @Path("media-type")
    public MediaTypeResource getMediaTypeFeatures(){
        return new MediaTypeResource();
    }
    
    @Path("uris")
    public UrisResource getUrisFeatures(){
        return new UrisResource();
    }
    
}
