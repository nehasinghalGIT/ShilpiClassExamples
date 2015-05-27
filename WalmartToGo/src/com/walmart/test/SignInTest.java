package com.walmart.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.walmart.main.SignInPage;

import come.walmart.utilities.WTGDataProvider;

public class SignInTest {

protected WebDriver driver;
	
	@BeforeMethod
	public void openBrowser(){
		String browser = "chrome";
		if (browser.equalsIgnoreCase("ff"))
		   driver = new FirefoxDriver();
		else if (browser.equals("chrome")){
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
			driver = new ChromeDriver();
		
		}
		else if (browser.equals("ie")){
			System.setProperty("webdriver.ie.driver", "lib/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
			
		driver.get("http://delivery.walmart.com/usd-estore/m/home/anonymouslanding.jsp");
		driver.manage().window().maximize();
	}
	
	@Test(enabled = false,dataProvider = "invalidlogin" , dataProviderClass = WTGDataProvider.class)
	public void testInvalidLogin(String username, String pswd){
		
	//	SignInPage sp = PageFactory.initElements(driver, SignInPage.class);
		SignInPage sp = new SignInPage(driver);
		Reporter.log("Running Test Case for username :" + username + " password:" + pswd);
		String actualmsg = sp.invalidSignIn(username, pswd);
		Assert.assertTrue(actualmsg.contains("Your password and email address do not match. Please try again."));
	}
	
	@Test
	public void testValidLogin(){
		
		SignInPage sp = new SignInPage(driver);
		String actualMsg = sp.validSignIn("shilpi@innova-path.com", "Whiteboxqa");
		Assert.assertTrue(actualMsg.contains("Shilpi"));
	}
	
	@AfterMethod
	public void closeBrowser(){
		
		if (driver != null) {
			driver.quit();
		}
	}
}
