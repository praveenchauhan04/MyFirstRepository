package com.crossbrowser.test;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Guru99 {
	WebDriver driver ;
	
	
	@BeforeMethod
	@Parameters("browser")
	public void setup(String browser) throws Exception
	{
		//Check if parameter passed from testNg is 'firefox'
		if(browser.equals("firefox"))
		{
			//Create a firefox instance
			driver = new FirefoxDriver();
			
	    }
		//Check if parameter passed from testNg is 'Chrome'
		else if(browser.equals("chrome"))
		{
			//Set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver","D://MyWorkspace//chromedriver.exe");
			//Create a chrome driver instance
			driver = new ChromeDriver();
		}
		else
		{
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
	}
	
	@Test
	public void testParameterWithXML() throws InterruptedException
	{
		driver.get("http://demo.guru99.com/V4");
		WebElement userId = driver.findElement(By.name("uid"));
		userId.clear();
		userId.sendKeys("guru99");
		
		WebElement password = driver.findElement(By.name("password"));
		password.clear();
		password.sendKeys("guru99");
		
		WebElement login = driver.findElement(By.name("btnLogin"));
		login.clear();
		login.submit();
	}
	
	@AfterMethod
	public void teardown()
	{
		try {
			driver.wait(15000);
		} catch (Exception e) {
			// TODO: handle exception
			driver.close();
			driver.quit();
		}
	}
}
