package com.example.products.service.impl;

import com.azure.storage.common.StorageSharedKeyCredential;
import com.azure.storage.common.implementation.StorageImplUtils;
import com.azure.storage.common.sas.AccountSasPermission;
import com.azure.storage.common.sas.AccountSasResourceType;
import com.azure.storage.common.sas.AccountSasService;
import com.azure.storage.common.sas.AccountSasSignatureValues;
import com.example.products.model.BlobStorageToken;
import com.example.products.service.ProductStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Service
@Slf4j
public class ProductAzureStorageServiceImpl implements ProductStorageService {

    private static final String ACCOUNT_NAME = "exampleapistorage";
    private static final Integer EXPIRATION_IN_SECONDS = 60;
    private static final String BLOB_SUFFIX = ".blob.core.windows.net";
    private static final String CONNECTION_STRING = "DefaultEndpointsProtocol=https;AccountName=exampleapistorage;AccountKey=2WE0gYNFTZYytQlQWcVeyyiLO2TTDm0bTtz9ZEr8pl+eb+OIudzs00QKTkEYpLp3HUSs5FWijwzN3NjNejPLLw==;EndpointSuffix=core.windows.net";
    private static final String BLOB_SAS_URL = "https://" +ACCOUNT_NAME + BLOB_SUFFIX + "/";


    @Override
    public BlobStorageToken generateAccessToken() {
        return getSASToken();
    }

    private BlobStorageToken getSASToken(){
        OffsetDateTime expiryTime = OffsetDateTime.now().plus(EXPIRATION_IN_SECONDS, ChronoUnit.SECONDS);
        AccountSasPermission permissions = new AccountSasPermission();
        permissions.setListPermission(true);
        permissions.setWritePermission(true);
        permissions.setReadPermission(true);
        AccountSasService services = new AccountSasService();
        services.setBlobAccess(true);
        AccountSasResourceType accountSasResourceType = new AccountSasResourceType();
        accountSasResourceType.setContainer(true);
        accountSasResourceType.setObject(true);
        AccountSasSignatureValues accountSasSignatureValues =
                new AccountSasSignatureValues(expiryTime, permissions, services, accountSasResourceType);
        StorageSharedKeyCredential storageSharedKeyCredentials =
                StorageSharedKeyCredential.fromConnectionString(CONNECTION_STRING);
        String sasToken = accountSasSignatureValues.generateSasQueryParameters(storageSharedKeyCredentials).encode();
        return new BlobStorageToken(BLOB_SAS_URL , sasToken);
    }



}
