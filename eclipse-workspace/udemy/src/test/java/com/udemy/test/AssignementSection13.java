package com.udemy.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AssignementSection13 {

	WebDriver driver;
	@Test
	public void Assignmentsection13_qaclick() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\src\\test\\resources\\browser\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		List<WebElement> rows=driver.findElements(By.xpath("//*[@id='product']/tbody/tr"));
		System.out.println("Number of rows "+rows.size());
		
		List<WebElement> colmn=driver.findElements(By.xpath("//*[@id='product']/tbody/tr[1]/th"));
		System.out.println("Number of columns "+colmn.size());
		
		List<WebElement> data=driver.findElements(By.xpath("//*[@id='product']/tbody/tr[3]/td"));
		
		for (int i=0;i<data.size();i++)
		{
			System.out.println(data.get(i).getText());
		}
		
		driver.close();
	}
}
