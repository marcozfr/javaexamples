package com.example.products.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BlobStorageToken {

    public BlobStorageToken(String storageUri, String storageAccessToken){
        this.storageUri = storageUri;
        this.storageAccessToken = storageAccessToken;
    }

    private String storageUri;
    private String storageAccessToken;

}
