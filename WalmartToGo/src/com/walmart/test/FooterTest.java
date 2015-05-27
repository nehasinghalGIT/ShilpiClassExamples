package com.walmart.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.walmart.main.Feedback;
import com.walmart.main.Footer;

public class FooterTest {

protected WebDriver driver;
	
	@BeforeMethod(groups={"Non-Functional"})
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
	
	@Test(groups={"Non-Functional"})
	public void testFeedback(){
		
		Footer footer = new Footer(driver);
		Feedback fb = footer.writeFeedback();
		String msg = fb.getMessage();
		
		Assert.assertTrue(msg.contains("Please rate your current Walmart Grocery site experience"));
		
	}
	
	@AfterMethod(groups={"Non-Functional"})
	public void closeBrowser(){
		
		if (driver != null) {
			driver.quit();
		}
	}
}
