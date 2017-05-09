package com.client;

import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

public class GetCitiesByCountry{
	
	public static void main (String args []) {

		if(args.length < 1){
			System.out.println("Usage: GetCitiesByCountry <country>");
			return;
		}

		GlobalWeather instance = new GlobalWeather();
		System.out.println("Testing out Cities by Country");
		System.out.println(instance.getGlobalWeatherSoap().getCitiesByCountry(args[0]));

	}

}