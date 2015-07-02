package com.stm.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@Test
public class FileDownloadVerify {

	private WebDriver driver;
	private static String downloadPath = "D:/MyWorkspace/SeleniumTut/";
	private String url = "http://spreadsheetpage.com/index.php/file/C35/P10/";
	
	@BeforeClass
	public void testSetup() throws Exception
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	public void verifyDownloadWithFileName() {
		driver.get(url);
		driver.findElement(By.linkText("mp3filelister.xls")).click();
		AssertJUnit.assertTrue(isFileDownloaded(downloadPath, "mp3filelistener.xls"));
		
  }
	
	public boolean isFileDownloaded(String downloadPath, String fileName)
	{
		boolean flag = false;
		File dir = new File(downloadPath);
		File[] dir_contents = dir.listFiles();
		
		for(int i=0; i<dir_contents.length; i++)
		{
			if(dir_contents[i].getName().equals(fileName))
					{
				return flag = true;
				
					}
			
		}
		return flag;
	}
	
	public boolean isFileDownloadedWithExtension(String dirPath, String ext)
	{
		boolean flag = false;
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if(files == null && files.length == 0)
		{
			flag = false;
		}
		
		for(int i=0 ; i<files.length; i++)
		{
			if(files[i].getName().contains(ext))
			{
				flag = true;
			}
		}
		return flag;
		
		
		/*Get the latest file from a specific directory*/
	/*	private File getLatestFileFromDir(String dirPath2)
		{
			File dir2 = new File(dirPath2);
			File[] files2 = dir2.listFiles();
			if(files2 == null || files2.length ==0)
			{
				return null;
			}
			
			File lastModifiedFile = files[0];
			for (int i=1; i<files.length; i++)
			{
				if(lastModifiedFile.lastModified()<files[i].lastModified())
				{
					lastModifiedFile = files[i];
				}
			}
			return lastModifiedFile;
		}
		*/
	}
}
