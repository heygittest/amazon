package com.udemy.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AssignmentSection13Last {
	

	WebDriver driver;
	@Test
	public void Assignment13Last_qaclick() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\src\\test\\resources\\browser\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id='autocomplete']")).sendKeys("ind");
		
		WebElement data=driver.findElement(By.xpath("//*[@id='ui-id-1']"));
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement>  subdata = data.findElements(By.tagName("li"));
	
		Actions a=new Actions(driver);
		for (int i=0;i<subdata.size();i++)
		{
		
			WebElement ele=driver.findElement(By.xpath("//*[@id='ui-id-1']/li[" +(i+1)+"]"));
			String str=ele.getText();
		
			if(str.equalsIgnoreCase("India"))
			{
				WebElement ele1=driver.findElement(By.xpath("//*[@id='ui-id-1']/li[" +(i+1)+"]"));
				a.moveToElement(ele1);
				ele1.click();
				break;
			}
		}	
		driver.close();
		}
	

}
