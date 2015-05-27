package com.walmart.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class InvalidZipPage {

	WebDriver driver;
	
	@CacheLookup
	@FindBy(tagName = "h1")
	WebElement invalidZipMessage;
	
	@CacheLookup
	@FindBy(xpath = "//span/parent::h2")
	WebElement message2;
	
	public InvalidZipPage(WebDriver driver){
		
		this.driver = driver;
	}
	
	public String getInvalidZipMessage(){
		
		String msg = invalidZipMessage.getText();
		return msg;
	}
	
	public String getMessage2(){
		
		return message2.getText();
	}
}
