package com.qa.amazon.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.amazon.base.AmazonBase;

public class HomePage extends AmazonBase{

	public HomePage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	// find search box on home page
	@FindBy (id="twotabsearchtextbox")
	WebElement serach_box;
	

	public String getTitle()
	{
		System.out.println(driver.getTitle()+"Title");
		return driver.getTitle();
				
	}
	
	//method to get search text and click on one of the item in suggestion list
	public boolean mobilesearch(String mobilename) throws InterruptedException
	{
	
		serach_box.sendKeys(mobilename);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[1]/header/div/div[1]/div[5]/div/div/div")));
		//get all the matching search options in a list, here One plus7 is the searched text sent as argument
		List<WebElement> list = driver.findElements(By.xpath("/html/body/div[1]/header/div/div[1]/div[5]/div/div/div[1]"));
		String str= list.get(0).getText();
		boolean flag=false;
		// all options are in concatenated hence split it
		String split1[]=str.split("\\r?\\n");
		for(int i = 0 ;i< split1.length;i++)
		{
			System.out.println(split1[i]);
			//select oneplus 7t back cover from the list
			if(split1[i].equalsIgnoreCase("oneplus 7t back cover"))
			{
					// click on desire item
					driver.findElement(By.xpath("//span[contains(text(),'oneplus 7t back cover')]")).click();
					// send status as true if product found
					flag=true;
				break;
			}
	
		}
		return flag;
	}
}
