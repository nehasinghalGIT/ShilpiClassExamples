package com.walmart.test;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.walmart.main.HomePage;
import com.walmart.main.WelcomePage;

public class WelcomePageTest {

	protected WebDriver driver;
	
	@BeforeMethod(groups={"Functional"})
	public void openBrowser(){
		String browser = "ff";
		if (browser.equalsIgnoreCase("ff"))
		   driver = new FirefoxDriver();
		else if (browser.equals("chrome")){
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
	
	@Test(groups={"Functional"},enabled = false)
	public void verifyPopUPonvalidZipsearch(){
		
		HomePage hp = new HomePage(driver);
		WelcomePage wp = hp.searchZipwithValidData("94538");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actualMsg = wp.checkPopUp();
		Assert.assertTrue(actualMsg.contains("Good news!"));
	}
	
	@Test
	public void testSearchDepartmentDD(){
		
		WelcomePage wp = new WelcomePage(driver);
		List<WebElement> allLinks = wp.getDropDownElementsofDepartments();
		Assert.assertTrue(allLinks.size() > 10);
	}
	
	@AfterMethod(groups={"Functional"})
	public void closeBrowser(){
		
		if (driver != null) {
			driver.quit();
		}
	}
}
