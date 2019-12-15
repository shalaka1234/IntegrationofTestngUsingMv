package com.model;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MercuryDemo {
	  public WebDriver driver;
	   
	  @Test(priority=1,description="Verify that valid user able to login into Mercury Tours application by using valid username and password")
	  public void loginwithValids1() 
	  {
		 System.out.println("In loginwithValids1 method under Test");  
	    System.out.println("In loginwithValids1 method under Test");
	    driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Suvidyap1");
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("P@ssword1");
	    driver.findElement(By.xpath("//input[@name='login']")).click();
	    System.out.println("User1 has login into Mercury Tours application successfully");
	    boolean act_flag=driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
	    System.out.println("Flight Finder image is displayed"+act_flag);
	    boolean exp_flag=true;
	    AssertJUnit.assertEquals(act_flag, exp_flag);
	    driver.findElement(By.linkText("SIGN-OFF")).click();
	    
	  }
	  
	  @Test(priority=2,description="Verify that valid user able to login into Mercury Tours application by using valid username and password")
	  public void loginwithValids2() 
	  {
	    System.out.println("In loginwithValids2 method under Test");
	    driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Suvidyap2");
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("P@ssword2");
	    driver.findElement(By.xpath("//input[@name='login']")).click();
	    System.out.println("User2 has login into Mercury Tours application successfully");
	    boolean act_flag1=driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
	    System.out.println("Flight Finder image is displayed"+act_flag1);
	    boolean exp_flag1=true;
	    AssertJUnit.assertEquals(act_flag1, exp_flag1);
	    driver.findElement(By.linkText("SIGN-OFF")).click();
	    
	  }
	  
	  
	  @Test(priority=3,description="Verify that invalid user not able to login into Mercury Tours application by using invalid username and password")
	  public void loginwithInValids() 
	  {
	    System.out.println("In loginwithInValids method under Test");
	    driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Suvidyap");
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("P@ssword");
	    driver.findElement(By.xpath("//input[@name='login']")).click();
	    boolean act_flag2=driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
	    System.out.println("Flight Finder image is displayed"+act_flag2);
	    boolean exp_flag2=true;
	    AssertJUnit.assertEquals(act_flag2, exp_flag2);
	  }
	  
	  
	  @BeforeMethod
	  public void getAllCookies() 
	  {
		Set<Cookie> cookies=driver.manage().getCookies();
		for(Cookie cookie:cookies)
		{
			System.out.println(cookie.getName());
		}
		
		
	  }

	  @AfterMethod
	  public void captureScreenshot() throws IOException
	  {
		   System.out.println("Screenshot is captured successfully");
		  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFileToDirectory(src, new File("C:\\Users\\Aishwarya\\workspace\\IntegrationofTestngUsingMv\\Screenshot\\"));
	      System.out.println("Screenshot is captured successfully");
	  }

	  @BeforeClass
	  public void maximizeBrowser() 
	  {
		  driver.manage().window().maximize();
	  }

	  @AfterClass
	  public void deleteAllCookies()
	  {
		  driver.manage().deleteAllCookies();
	  }

	  @BeforeTest
	  public void enterApplicationURL()
	  {
		  System.out.println("enterApplicationURL");
		  driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		  System.out.println("Application URL is entered successfully");
	  }

	  @AfterTest
	  public void dbConnectionClosed() 
	  {
		  System.out.println("dbConnectionClosed method under AfterTest");
	  }

	  @BeforeSuite
	  public void openBrowser() 
	  {
		  System.setProperty("webdriver.chrome.driver","D:\\CJC Softwares\\11092019\\chromedriver_win32\\chromedriver1.exe");
		  driver = new ChromeDriver();
		  System.out.println("Chrome browser is opened successfully");
	  }

	  @AfterSuite
	  public void closeBrowser()
	  {
		  driver.close();
	  }

}
