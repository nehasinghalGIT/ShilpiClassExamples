package com.walmart.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicDemo {
	
	WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicDemo ex = new BasicDemo();
		//ex.checkZip();
		ex.signin();
		
	}
	
	public void checkZip(){
		
		driver = new FirefoxDriver();
		driver.get("http://delivery.walmart.com/usd-estore/m/home/anonymouslanding.jsp");
		WebElement txtbxZip = driver.findElement(By.id("verifyAddress-zip"));
		txtbxZip.sendKeys("94568");
		WebElement btnSubmit = driver.findElement(By.id("verifyAddress-button"));
		btnSubmit.click();
		WebElement h1 = driver.findElement(By.tagName("h1"));

		System.out.println(h1.getText());
		
		if (h1.getText().equals("Join the waitlist"))
			System.out.println("Test Case Passed");
		else System.out.println("Test Case Failed");
		
	}
	
	public void signin(){
		
	//	driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.walmart.com/account/login");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		WebElement txtEmail = driver.findElement(By.id("login-username"));
		txtEmail.sendKeys("test@test.com");
		WebElement txtPswd = driver.findElement(By.id("login-password"));
		txtPswd.sendKeys("ywuieyuwe");
		WebElement btnSubmit = driver.findElement(By.cssSelector("button[data-automation-id='login-sign-in'"));
		btnSubmit.click();
		
	}

}
