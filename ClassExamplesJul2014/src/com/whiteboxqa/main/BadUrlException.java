package com.whiteboxqa.main;

public class BadUrlException extends Exception {
	
	public BadUrlException(String url){
		super("The url " + url + " does not confirm with the requirements.");
	}

}
