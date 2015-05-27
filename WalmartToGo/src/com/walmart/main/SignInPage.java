package com.walmart.main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {

	protected WebDriver driver;
	
//	@CacheLookup
//	@FindBy(xpath = "//input[@id='login-username']")
	WebElement txtEmail;
	
//	@CacheLookup
//	@FindBy(xpath =  "//input[@id = 'login-password']")
	WebElement txtPswd;
	
//	@CacheLookup
//	@FindBy( css = "button[data-automation-id='login-sign-in'")
	WebElement btnSubmit;
	
	
	public SignInPage(WebDriver driver){
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.walmart.com/account/login");
	}
	
	// This method is doing signin with valid credentials
	public String validSignIn(String username, String pswd){
		
		txtEmail = driver.findElement(By.cssSelector("#login-username"));
		txtEmail.sendKeys(username);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		txtPswd = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#login-password")));
	//	txtPswd = driver.findElement(By.cssSelector("login-password"));
		txtPswd.sendKeys(pswd);
		btnSubmit = driver.findElement(By.cssSelector("button[data-automation-id='login-sign-in'"));
		btnSubmit.click();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement h1 = driver.findElement(By.tagName("h2"));
		return h1.getText();
		
	}
	// This method is doing signin with invalid credentails
	
	public String invalidSignIn(String username, String pswd){
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		txtEmail = driver.findElement(By.cssSelector("#login-username"));
		txtEmail.sendKeys(username);
		txtPswd = driver.findElement(By.cssSelector("#login-password"));
		txtPswd.sendKeys(pswd);
		btnSubmit = driver.findElement(By.cssSelector("button[data-automation-id='login-sign-in'"));
		btnSubmit.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement msg = driver.findElement(By.xpath("//div[contains(@class,'login-container')]/span"));
		return msg.getText();
		
	}
}
