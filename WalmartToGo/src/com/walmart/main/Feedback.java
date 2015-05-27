package com.walmart.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Feedback {

	WebDriver driver;
	WebElement msg;
	
	public Feedback(WebDriver driver){
		
		this.driver = driver;
	}
	
	public String getMessage(){
		
		return (driver.findElement(By.id("ovText")).getText());
	}
}
