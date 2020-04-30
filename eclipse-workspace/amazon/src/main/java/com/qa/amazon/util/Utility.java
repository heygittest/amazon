package com.qa.amazon.util;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class Utility {
	// get the screenshot when assert fails
	public static String getScreenshot(WebDriver driver, String name)
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		 
		   Instant instant = timestamp.toInstant();
		   Timestamp tsFromInstant = Timestamp.from(instant);

		 String date=  tsFromInstant.toString().replaceAll("[\\s|.|:]","-");
		
		 File src=ts.getScreenshotAs(OutputType.FILE);
		
		String path=System.getProperty("user.dir")+"\\src\\test\\resources\\screenshot\\"+name+"(" + date+").png";
		
		File destination=new File(path);
		
		try 
		{
			Files.copy(src, destination);;
		} catch (IOException e) 
		{
			System.out.println("Capture Failed "+e.getMessage());
		}
		
		return path;
	}
}
