package com.example.ws;

import com.example.ws.geoip.GeoIPService;

import net.webservicex.GeoIP;

public class GeoIpClient {
    
    public static void main(String[] args) {
        String ipAddress = args[0];
        GeoIPService geoIpService  = new GeoIPService();
        GeoIP geoIp = geoIpService.getGeoIPServiceSoap().getGeoIP(ipAddress);
        System.out.println("code:"  + geoIp.getCountryCode());
        System.out.println("name:"  + geoIp.getCountryName());
        System.out.println("ret code:"  + geoIp.getReturnCode());
        System.out.println("ret code det:"  + geoIp.getReturnCodeDetails());
    }

}
