package com.indeed.main;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndeedSearchPage {

	WebDriver driver;

	public IndeedSearchPage(WebDriver driver) {
		this.driver = driver;
	}

	
	public void getResumeText(List<String> list) {

		// open file
	//	BufferedWriter bw = null;

		// this loop is going to different pages
		try {
       for (String searchKeyword : list) {
    	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get("http://www.indeed.com/");
			
            String dirPath = "C:\\Users\\Shilpi\\SkyDrive\\Downloaded Resumes\\Indeed\\" + searchKeyword;
			File dir = new File(dirPath);
			if (!dir.exists()) 
				if (!dir.mkdirs()) {
					System.out.println("Directories can't be created.");
				    break;
					
				}
			WebElement findresume = driver.findElement(By.id("rezLink"));
			findresume.click();
			WebElement where = driver.findElement(By.id("location"));
			where.clear();
			WebElement what = driver.findElement(By.id("query"));
	 
			what.sendKeys(searchKeyword);
			what.sendKeys(Keys.RETURN);
		/*	WebDriverWait wait = new WebDriverWait(driver,5);
			try{
			WebElement findJobs =wait.until(ExpectedConditions.elementToBeClickable(By.className("submit")));
			
		//	WebElement findJobs = driver.findElement(By.className("submit"));
			findJobs.click();
			}
			catch (TimeoutException e){
				continue;
			}
			catch (NoSuchElementException e){
				continue;
			}
			catch (Exception e){
				continue;
			}
			*/
			int count = 0;
			// this loop downloads all the resumes
			boolean isThereNextPage = true;
            
			while (isThereNextPage) {
				Thread.sleep(5000);
				List<WebElement> jobs = driver.findElements(By
						.cssSelector(".app_link"));
            
                if (jobs != null){
                    System.out.println("Number of jobs found : " + jobs.size());
				for (WebElement joblink : jobs) {
                    String tempName = joblink.getText();
              
                    StringBuffer name = new StringBuffer();
                    for (int i = 0 ; i <tempName.length() ; i++){
                    	if (Character.isLetterOrDigit(tempName.charAt(i)) || tempName.charAt(i) == ' ')
                    		name.append(tempName.charAt(i));
                    }
                    System.out.println(name);
					joblink.click();

					// Store the current window handle
					String winHandleBefore = driver.getWindowHandle();

					// Perform the click operation that opens new window

					// Switch to new window opened
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
					}

					// Perform the actions on new window
					// click on download button
					WebElement jobdescription = driver.findElement(By
							.id("resume"));
					String jd = jobdescription.getText();
				
					String filePath = dirPath + "\\" + ++count+ "-"  + name  +".doc";
					createFile(filePath, jd);
				//	File file = new File("C:\\Users\\Shilpi\\Google Drive\\Marketing Management\\DownloadedResumes\\Indeed\\" + searchKeyword +"\\"+ searchKeyword+ ++count + ".doc");
              /*      File file = new File(filePath);
					// if file doesnt exists, then create it
					if (!file.exists()) {
						file.createNewFile();
					}

					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					bw = new BufferedWriter(fw);
					bw.write(jd);
					bw.flush();*/

					// Close the new window, if that window no more required
					driver.close();

					// Switch back to original browser (first window)
					driver.switchTo().window(winHandleBefore);
				}
                }// end if
				// check if there is next page
				WebDriverWait wait1 = new WebDriverWait(driver, 3);
				
				try{
					WebElement next =wait1.until(ExpectedConditions.elementToBeClickable(By.className("next")));
					next.click();
				}
				catch (TimeoutException e){
					isThereNextPage = false;
				}
				catch (NoSuchElementException e){
					isThereNextPage = false;
				}
				catch (Exception e){
					isThereNextPage = false;
				}
			/*	List<WebElement> next = driver.findElements(By.className("next"));
				if (next.size() == 0)
					isThereNextPage = false;
				else
					next.get(0).click();*/
			}

		}// end for
		}// end try
		catch (Exception e) {
			e.printStackTrace();
		} 
	}
public static void createFile(String filepath, String body) throws IOException{
		
		XWPFDocument  doc = new XWPFDocument () ;
		XWPFParagraph paragraphOne = doc.createParagraph();


        XWPFRun paragraphOneRunOne = paragraphOne.createRun();

        paragraphOneRunOne.setFontFamily("Arial");
        paragraphOneRunOne.setText(body);
		OutputStream out = null;
		try {
			out = new FileOutputStream(new File(filepath));
			doc.write(out);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			out.close();
			
		}
				
	}
}

