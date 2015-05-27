package com.xyz.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.module.jsv.JsonSchemaValidator.*;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.xyz.main.GoogleGeocoding;



public class GoogleGeocodingTest {
	
	@Test
	public void testGetGoogleGeocoding(){
		
		GoogleGeocoding api = new GoogleGeocoding("https://maps.googleapis.com", "/maps/api/geocode/json");
		Response response = api.getGoogleGeocoding("2000 Walnut Ave, Fremont, CA", "AIzaSyD9o5emg6WrnPR7vwdcG_mB1M37CrXA81c");
		System.out.println(response.toString());
	//	JsonPath jsonpath = response.jsonPath().setRoot("results");
	//	Assert.assertEquals(jsonpath.getString("status"),"OK");
		
	}
	
}
