package com.walmart.main;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WelcomePage {
	
	protected WebDriver driver;
	WebElement txtWelcome;
	WebElement popUpMsg;
	
	public WelcomePage(WebDriver driver){
		
		this.driver = driver;
	}
	
	public boolean getWelcomeMessage(){
		boolean found = false;
		try{
		  txtWelcome = driver.findElement(By.xpath("//span[contains(text(),'Welcome')]"));
		  found = true;
		}
		catch(NoSuchElementException e){
			found = false;
		}
		return found;
	}
	
	public String checkPopUp(){
		
		popUpMsg = driver.findElement(By.xpath("//div[contains(@class,'modal__window')]/h2"));
		return popUpMsg.getText();
	}
	
	public List<WebElement> getDropDownElementsofDepartments(){
		
		driver.get("http://www.walmart.com");
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	//	WebElement btn = driver.findElement(By.xpath("(//button[contains(text(),'All')])[1]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement btn = (WebElement)js.executeScript("return document.getElementByClass('js-flyout')");
	//	js.executeScript("arguments[0].click()", btn);
		btn.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> linksList = driver.findElements(By.xpath("//ul[@class='block-list']/li"));
		return linksList;
	}

}
