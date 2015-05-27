package com.indeed.main;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestIndeedSearchPage {

	
		WebDriver driver;

		@BeforeMethod
		public void openBrowser() {
			System.setProperty("webdriver.chrome.driver",
					"lib/chromedriver.exe");
			driver = new ChromeDriver();
		//	driver = new FirefoxDriver();
		}

	//	@Test(dataProvider="keywords")
		@Test(dataProvider="failedKeywords")
		public void testTC1(List<String> list)  {
			IndeedSearchPage test = new IndeedSearchPage(driver);
			test.getResumeText(list);

		}

		
		@DataProvider(name="failedKeywords" , parallel =true)
		public static Object[][] data1(){
			List<String> list1 = new ArrayList<String>();
			list1.addAll(Arrays.asList(new String[] {"QA Lead"}) );
			List<String> list2 = new ArrayList<String>();
			list2.addAll(Arrays.asList(new String[] {"Quality Center"}) );
			
			return new Object[][]{
					{list1},
					{list2}
			};
		}
		
		
		@DataProvider(name="keywords",parallel=true)
		public static Object[][] data(){
			List<String> list1 = new ArrayList<String>();
			list1.addAll(Arrays.asList(new String[] {"SQL","Oracle","Developer"}) );
			List<String> list2 = new ArrayList<String>();
			list2.addAll(Arrays.asList(new String[] {"QA",".NET","SSIS","SSRS","SSAS"}) );
			List<String> list3 = new ArrayList<String>();
			list3.addAll(Arrays.asList(new String[] {"Hadoop","Spring","Hibernate","QTP"}) );
			List<String> list4 = new ArrayList<String>();
			list4.addAll(Arrays.asList(new String[] {"JSP","OOP","ANT","MAVEN","JIRA","QC"}) );
			List<String> list5 = new ArrayList<String>();
			list5.addAll(Arrays.asList(new String[] {"WebDriver","SAP","Siebel"}) );
			List<String> list6 = new ArrayList<String>();
			list6.addAll(Arrays.asList(new String[] {"Oracle Apps","ADO.NET","ASP.NET","Silverlight","Hadoop"}) );
			
			return new Object[][]{
					{list1},
					{list2},
					{list3},
					{list4},
					{list5},
					{list6}
			};
		}
		
		@DataProvider(name="keywordsFromCSV",parallel=true)
		public static Object[][] dataFromCSV(){
			return readCSV("data/keywords.csv");
		}
		
		public static Object[][] readCSV(String filepath){
			Object[][] data = new Object[6][];
			BufferedReader buff = null;
			try {
				buff = new BufferedReader(new FileReader(filepath));
				String line = "";
				int i =0;
				
				while ((line = buff.readLine())!= null){
					List<String> wordList = new ArrayList<String>();
					String [] words = line.split(",");
					wordList.addAll(Arrays.asList(words));
					data[i][0] = wordList;
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				try {
					buff.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return data;
		}
	//	@AfterMethod
		public void closeBrowser() {
			driver.quit();
		}
      
 
	}
