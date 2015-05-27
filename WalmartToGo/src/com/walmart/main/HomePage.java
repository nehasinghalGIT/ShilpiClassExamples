package com.walmart.main;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import come.walmart.utilities.WGTLocators;

public class HomePage implements WGTLocators {
	
	protected WebDriver driver;

	@CacheLookup
	@FindBy(id = "verifyAddress-zip")
	private WebElement imgLogo; // id 
	
	@FindBy(xpath = "")
	private WebElement linkSignIn;
	
	private WebElement txtBoxSearch;
	private WebElement btnSearch;
	
	@FindBys({@FindBy(css = ".benefits img") })
	private List<WebElement> imgsThubnail;
	
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
	}
	
/*	
	public WelcomePage searchZipwithValidData(String zip, By locator){
		
	//	txtBoxSearch = driver.findElement(By.id("verifyAddress-zip"));
	//	txtBoxSearch = driver.findElement(By.id(locator));
		txtBoxSearch.sendKeys(zip);
//		btnSearch = driver.findElement(By.cssSelector("#verifyAddress-button"));
//		btnSearch = driver.findElement(By.cssSelector(HP_SUBNITBTN));
		btnSearch = driver.findElement(locator);
		btnSearch.click();
		
		WelcomePage wp = new WelcomePage(driver);
		return wp;
		
	}
*/	
	public WelcomePage searchZipwithValidData(String zip){
		
		txtBoxSearch = driver.findElement(By.id("verifyAddress-zip"));
		txtBoxSearch.sendKeys(zip);
		btnSearch = driver.findElement(By.cssSelector("#verifyAddress-button"));
        btnSearch.click();
		
		WelcomePage wp = new WelcomePage(driver);
		return wp;
	}
	
	public InvalidZipPage searchZipwithInvalidData(String zip){
		
		txtBoxSearch = driver.findElement(By.id("verifyAddress-zip"));
		txtBoxSearch.sendKeys(zip);
		btnSearch = driver.findElement(By.cssSelector("#verifyAddress-button"));
        btnSearch.click();
        
        InvalidZipPage ip = PageFactory.initElements(driver, InvalidZipPage.class);
        return ip;
	}
	
	public List<WebElement> getAllThumbnailImages(){
		
		imgsThubnail = driver.findElements(By.cssSelector(".benefits picture img"));
		return imgsThubnail;
		
	}
	
	public void getAllThumbnailTexts(){
		
	}
	
	public void getFooterLinks(){
		
	}
	
	
}
