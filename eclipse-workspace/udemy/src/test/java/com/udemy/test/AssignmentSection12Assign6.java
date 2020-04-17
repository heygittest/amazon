package com.udemy.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AssignmentSection12Assign6 {
	
	WebDriver driver;
	@Test
	public void Assignment6_qaclick() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\src\\test\\resources\\browser\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		//select the second checkbox
		WebElement check=driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]/input"));
	System.out.println("Hello");
		String getName=check.getAttribute("value");
		check.click();
		
		//dropdown select
		
		Select dropdown=new Select (driver.findElement(By.xpath("//*[@id='dropdown-class-example']")));
		dropdown.selectByValue(getName);
		
		//text box
		driver.findElement(By.xpath("//*[@id='name']")).sendKeys(getName);
		
		//alert
		driver.findElement(By.xpath("//*[@id='alertbtn']")).click();
		Alert a=driver.switchTo().alert();
		String alter_text=a.getText();
		if(alter_text.contains(getName))
		{
			System.out.println("Alert contains text " + getName);
		}
		else
		{
			System.out.println("Alert does  not contain text " + getName);
		}
		a.accept();
		driver.close();	
	}
	

}
