package com.example.products.service.impl;

import com.azure.storage.common.implementation.StorageImplUtils;
import com.example.products.model.BlobStorageToken;
import com.example.products.service.ProductStorageService;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ProductAzureStorageLegacyServiceImpl implements ProductStorageService {

    private static final String ACCOUNT_NAME = "exampleapistorage";
    private static final String BLOB_SAS_URL = "https://" +ACCOUNT_NAME + ".blob.core.windows.net/";
    private static final String ACCOUNT_KEY = "2WE0gYNFTZYytQlQWcVeyyiLO2TTDm0bTtz9ZEr8pl+eb+OIudzs00QKTkEYpLp3HUSs5FWijwzN3NjNejPLLw==";

    @Override
    public BlobStorageToken generateAccessToken() {
        return getSASTokenLegacy();
    }

    private static BlobStorageToken getSASTokenLegacy() {
        LocalDateTime expiryTime = LocalDateTime.now(ZoneOffset.UTC).plus(1, ChronoUnit.MINUTES);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String sasToken = null;
        try {
            String signedexpiry = URLEncoder.encode(fmt.format(expiryTime), "UTF-8");
            String signedversion = "2019-12-12";
            String signedresourcetype = "co";
            String signedservices = "b";
            String signedpermissions = "rwdl"; // container
            String sip =  "198.168.1.3"; // allow certain ips
            String spr = "https,http";

            StringBuilder stringToSignBuilder = new StringBuilder().append(ACCOUNT_NAME).append("\n")
                    .append(signedpermissions).append("\n")
                    .append(signedservices).append("\n")
                    .append(signedresourcetype).append("\n")
                    .append("\n")
                    .append(signedexpiry).append("\n")
                    .append("\n")
                    .append("\n")
                    .append(signedversion).append("\n");
            String signature = StorageImplUtils.computeHMac256(ACCOUNT_KEY, stringToSignBuilder.toString());
            StringBuilder sasTokenBuilder =
                    new StringBuilder().append("sv").append("=").append(signedversion)
                            .append("&").append("ss").append("=").append(signedservices)
                            .append("&").append("srt").append("=").append(signedresourcetype)
                            .append("&").append("sp").append("=").append(signedpermissions)
                            .append("&").append("se").append("=").append(signedexpiry)
                            .append("&").append("sig").append("=").append(signature);

            sasToken = sasTokenBuilder.toString();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new BlobStorageToken(BLOB_SAS_URL , sasToken);
    }
}
