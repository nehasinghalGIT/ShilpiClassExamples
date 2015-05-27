package com.walmart.main;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Footer {

	WebDriver driver;
	WebElement lnkFeedback;
	
	
	public Footer(WebDriver driver){
		
		this.driver = driver;
	}
	
	public Feedback writeFeedback(){
		
		lnkFeedback = driver.findElement(By.partialLinkText("Feedback"));
		lnkFeedback.click();
		
		Set<String> allWinHandles = driver.getWindowHandles();
		Iterator<String> it = allWinHandles.iterator();
		while (it.hasNext()) {
			String handle = it.next();
			System.out.println(handle);
			driver.switchTo().window(handle);
			String currentUrl = driver.getCurrentUrl();
			if (currentUrl.contains("comment"))
				break;
		}
		
		return new Feedback(driver);
		
	}
}
