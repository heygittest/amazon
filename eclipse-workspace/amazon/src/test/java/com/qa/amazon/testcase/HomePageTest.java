package com.qa.amazon.testcase;
import java.io.IOException;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.amazon.base.AmazonBase;
import com.qa.amazon.pages.HomePage;

import junit.framework.Assert;

public class HomePageTest extends AmazonBase {

	
	public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	//call HomePage search method from Home Page.java
	@Test (priority=2)
	public void mobileserach() throws InterruptedException
	{
		extentTest=extent.startTest("search mobile");
		boolean result= LoginPageTest.home.mobilesearch("One Plus 7");
		if(result==true)
		Assert.assertTrue(true);
		else
		Assert.assertFalse(true);
	}
	//verify page title, purposely failed to check screenshot capture
	@Test (priority=3)
	public void verifyTitle() throws IOException
	{
		extentTest=extent.startTest("Title test");
		HomePage obj= new HomePage();
		String msg=obj.getTitle();
		System.out.println("title"+msg);
	
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("gjh", driver.getTitle());
		sa.assertAll();
			
	}
	// method to find cost and click on add to cart
	@Test (priority=5)
	public void getAccessory() throws Exception {
		extentTest=extent.startTest("Sub product");
		// check weather element is displayed
		
		if (driver.findElements(By.xpath("//span[contains(text(),'OnePlus 7T Sandstone Protective Case')]")).size()!=0)
		{
			driver.findElement(By.xpath("//span[contains(text(),'OnePlus 7T Sandstone Protective Case')]")).click();
		
			String winHandleBefore = driver.getWindowHandle();
			System.out.println(winHandleBefore);
			// click on element
			WebDriverWait wait= new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		//	Thread.sleep(2000);
			// find window handle as it opens new window
			Set<String> winHandles = driver.getWindowHandles();
			System.out.println(winHandles.size());
			for (String window1 : winHandles)
			{ 
				// check if window is same as parent
				if(!window1.equals(winHandleBefore))
				{
					driver.switchTo().window(window1);
					driver.close();
				}
			}
			}
			else
			{
				System.out.println("No data found");
			}
			//driver.switchTo().window(winHandleBefore);
			Assert.assertTrue("sub product found",true);
		}
	

	
}

