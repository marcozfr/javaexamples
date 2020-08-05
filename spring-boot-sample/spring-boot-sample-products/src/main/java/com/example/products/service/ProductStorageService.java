package com.example.products.service;

import com.example.products.model.BlobStorageToken;

public interface ProductStorageService {

    public BlobStorageToken generateAccessToken();
}
