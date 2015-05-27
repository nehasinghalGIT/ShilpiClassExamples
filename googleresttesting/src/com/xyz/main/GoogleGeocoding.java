package com.xyz.main;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class GoogleGeocoding {

	private String requestUrl ;
	private String resourcePath;
	
	
	public GoogleGeocoding(String requestUrl, String resourcePath){
		
		this.requestUrl = requestUrl;
		this.resourcePath = resourcePath;
		
	}

	public Response getGoogleGeocoding(String address,String api_key){
		
		RestAssured.given().header("header1","Something1").and().header("header2", "Something2");
		Response response = 
	    RestAssured.given()
		      .param("address", address)
		      .param("key", api_key)
		.when()
				.get(this.requestUrl+this.resourcePath)
	    .then()
				.extract()
				.response();
		
		return response;
	}
}
