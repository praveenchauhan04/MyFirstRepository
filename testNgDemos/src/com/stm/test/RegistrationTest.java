package com.stm.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class RegistrationTest {
	private WebDriver driver;
	private String appUrl = "http://newtours.demoaut.com";
 @BeforeSuite
 public void setUp()
 {
	 System.setProperty("webdriver.chrome.driver", "D://MyWorkspace//chromedriver.exe");
	 driver = new ChromeDriver();
 }
	
 
 @Test
  public void testRegister() {
	  
	  driver.get(appUrl);
	  driver.findElement(By.linkText("REGISTER")).click();
	  
	  WebElement firstName = driver.findElement(By.name("firstName"));
	  firstName.clear();
	  firstName.sendKeys("Praveen");
	  
	  WebElement lastName = driver.findElement(By.name("lastName"));
	  lastName.clear();
	  lastName.sendKeys("Chauhan");
	  
	  driver.findElement(By.name("phone")).sendKeys("123232");
	  driver.findElement(By.name("userName")).sendKeys("pchauhan@gmail.com");
	  driver.findElement(By.name("address1")).sendKeys("Bavdhan");
	  driver.findElement(By.name("city")).sendKeys("CA");
	  driver.findElement(By.name("state")).sendKeys("USA");
	  driver.findElement(By.name("postalCode")).sendKeys("121313");
	  
	  Select select = new Select(driver.findElement(By.name("country")));
	  select.selectByVisibleText("INDIA");
	  
	  driver.findElement(By.name("email")).sendKeys("pchauhan");
	  driver.findElement(By.name("password")).sendKeys("test@!23");
	  driver.findElement(By.name("confirmPassword")).sendKeys("test@!23");
	  
	  driver.findElement(By.name("register")).click();
	  
  }
  
  @Test
  public void testLoginUser()
  {
	  driver.get(appUrl);
	  driver.findElement(By.name("userName")).sendKeys("pchauhan");
	  driver.findElement(By.name("password")).sendKeys("test@!23");
	  driver.findElement(By.name("login")).click();
	  String actualText = "Welcome: Mercury Tours";
	  String expectedTitle = driver.getTitle();
	  if(actualText.equals(expectedTitle))
			  {
		  AssertJUnit.assertEquals(expectedTitle, actualText);
			  }
  }
  
  @AfterSuite
  public void tearDown()
  {
	  driver.close();
	  driver.quit();
  }
}
