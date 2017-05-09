package com.client;

import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

public class GetWeatherClient {
	
	public static void main (String args []) {

		if(args.length < 2){
			System.out.println("Usage: GlobalWeatherClient <city> <country>");
			return;
		}

		GlobalWeather instance = new GlobalWeather();
		String city = args[0];
		String country = args[1];
		System.out.println("Testing out Weather for " + city + "/" + country);
		System.out.println(instance.getGlobalWeatherSoap().getWeather(city,country));

	}

}