package com.stm.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class storeDemoQA {
	private WebDriver driver;
	private String appUrl = "http://www.toolsqa.com/automation-practice-form";
	
  @Test
  public void testRegistration() {
	  
	  //Open the app url
	  driver.get(appUrl);
	  
	  //Initialize the webelement for firstname and sendKeys
	  WebElement firstName = driver.findElement(By.name("firstname"));
	  firstName.clear();
	  firstName.sendKeys("Praveen");
	  
	  //Initialize the webelement for lastName and sendkeys	  
	  WebElement lastName = driver.findElement(By.name("lastname"));
	  lastName.clear();
	  lastName.sendKeys("Chauhan");
	  
	  //Select the deselected radio button (female) for category sex (Use isSelected method)
	  //Storing all the elements under category "Sex" in the list of webelements
	  List<WebElement> rad_Sex = driver.findElements(By.name("sex"));
	  
	  //Create a boolean variable which will hold the value (true/false)
	  boolean bVal = false;
	  
	  //This statement will return true, in case of first radio button is selected
	  bVal = rad_Sex.get(0).isSelected();
	  
	  //This will check that bVal is true means if the first radio button is selected
	  if(bVal == true)
	  {
		  //This will select second radio button, if first radio button selected by default
		  rad_Sex.get(0).click();
	  }
	  else
	  {
		  //If the first radio button is not selected by default, the first will be selected
		  rad_Sex.get(1).click();
	  }
	  
	  //Select the third radio button for category "Years of exp"
	  WebElement rdBtn_Exp = driver.findElement(By.id("exp-2"));
	  rdBtn_Exp.click();
	  
	  	   
	  driver.findElement(By.id("datepicker")).sendKeys("07-05-2015");
	  
	//Check the checkbox button "Automation Tester" for category "Profession"
	  //Find the checkbox or radio button element by name

	  List<WebElement> chBx_Profession = (List<WebElement>) driver.findElements(By.name("profession"));

	  //This will tell you number of checkboxes are present
	  int iSize = chBx_Profession.size();
	  
	  for(int i=0; i<iSize; i++)
	  {
		  String sValue = chBx_Profession.get(i).getAttribute("value");
		  if(sValue.equalsIgnoreCase("Automation Tester"))
		  {
			  chBx_Profession.get(i).click();
			  break;
		  }
	  }
	  
	  WebElement oCheckBox = driver.findElement(By.cssSelector("input[value='Selenium IDE']"));
	  oCheckBox.click();
	  
	  Select select = new Select(driver.findElement(By.id("selenium_commands")));
	  select.selectByVisibleText("Switch Commands");
	  
	  driver.findElement(By.name("submit")).click();
	  
	  
  }
  @BeforeSuite
  public void beforeSuite() {
	  
	  //Set system property for chrome driver
	  System.setProperty("webdriver.chrome.driver", "D://MyWorkspace//chromedriver.exe");
	  
	  //Create a new instance of Chrome driver
	  driver = new ChromeDriver();
	  
	  //Maximize the browser window
	  driver.manage().window().maximize();
	  
	  //Set implicit wait for 10 miliseconds
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterSuite
  public void afterSuite() {
	  driver.close();
	  driver.quit();
  }

}
