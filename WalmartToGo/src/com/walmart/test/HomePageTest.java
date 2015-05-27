package com.walmart.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.walmart.main.HomePage;
import com.walmart.main.InvalidZipPage;
import com.walmart.main.WelcomePage;

public class HomePageTest {

	WebDriver driver;
	static Properties allLocators;
	
	@BeforeClass
	public static void readLocators(){
		
		allLocators = new Properties();
		try {
			allLocators.load(new FileInputStream("resources/locators.properties"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Parameters("browser")
	@BeforeMethod(groups={"Functional","Non-Functional"})
	public void openBrowser(String browser){
	//	String browser = "ff";
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
	
	// test for valid zip search
	@Test(groups={"Functional"})
	public void testValidSearch(){
		By txtBxloc  = null;
	/*	String txtBoxSearchLoc = (String) allLocators.get("homepage.txtBoxsearch.id");
		
		
		
		String[] loc = txtBoxSearchLoc.split(".");
		if (loc[0].equals("css")) {
			txtBxloc = By.cssSelector(txtBoxSearchLoc);
					
		}
		
	*/	
		HomePage hp = new HomePage(driver);
	//	WelcomePage wp = hp.searchZipwithValidData("94538",txtBxloc);
		WelcomePage wp = hp.searchZipwithValidData("94538");
		boolean found = wp.getWelcomeMessage();
		Assert.assertTrue(found);
	}
	
	@Test(groups={"Non-Functional","QuickP1"})
	public void testThumbnailImages(){
		boolean passed = true;
		HomePage hp = new HomePage(driver); // dependency Injection
		List<WebElement> allImages = hp.getAllThumbnailImages();
		try {
		// check for the number of images
		Assert.assertTrue(allImages.size() ==  13);
		}
		catch(AssertionError e ){
			System.out.println("Image Size did not match..");
			Reporter.log("Image Size did not match..");
			passed = false;
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(screenshot, new File ("c:\\Users\\Shilpi\\SkyDrive\\training\\WTG Log\\"+screenshot.getName()), true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		// check for the alt attribute
		List<String> expValues = new ArrayList<String>();
		expValues.add("Guaranteed freshness");
		expValues.add("Save time and money");
		expValues.add("Get it when you choose");
		
		List<String> actValues = new ArrayList<String>();
		List<String> imgsrc = new ArrayList<String>();
		Iterator<WebElement> it = allImages.iterator();
		while (it.hasNext()) {
			WebElement img = it.next();
			String alt = img.getAttribute("alt");
			String src = img.getAttribute("src");
			actValues.add(alt);
			imgsrc.add(src);
			System.out.println(alt);
		}
		try {
		   Assert.assertTrue(actValues.containsAll(expValues));
		}
		catch(AssertionError e){
			System.out.println("Alt Values not matching");
			passed = false;
		}
		
		if (passed == false){
			Assert.fail();
		}
	}
	
	// This methods checks for the invalid Zip code
	@Test(groups={"Functional"},enabled = false)
	public void testSearchZipwithInvalid(){
		
		HomePage hp = new HomePage(driver);
		InvalidZipPage ip = hp.searchZipwithInvalidData("78378");
		String actualMsg = ip.getInvalidZipMessage();
		Assert.assertTrue(actualMsg.contains("Join the waitlist"));
		
		
	}
	
	@AfterMethod(groups={"Functional","Non-Functional"})
	public void closeBrowser(){
		
		if (driver != null) {
			driver.quit();
		}
	}
}
