package com.qa.amazon.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.amazon.base.AmazonBase;

public class loginPage extends AmazonBase{

		public loginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
		}
		//sign in button
		@FindBy(partialLinkText="Account & Lists")
		WebElement signin;
		
		//sign in button 2
		@FindBy(partialLinkText="Sign in")
		WebElement btnsignin;

		@FindBy(name="email")
		WebElement emailid;
		
		@FindBy(id="continue")
		WebElement btnContinue;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(id="signInSubmit")
		WebElement btnSubmit;
		
		// method to sign in
		public HomePage login(String email_id, String Pass) throws InterruptedException, IOException
		{
			//click on sign in button
			Actions a = new Actions(driver);
			a.moveToElement(signin).build().perform();
			signin.click();
			
			// click and send value for email 
			WebDriverWait wait1= new WebDriverWait(driver,60);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
			emailid.sendKeys(email_id);
			btnContinue.click();
			// value for password
			WebDriverWait wait=new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
			password.sendKeys(Pass);
			//submit
			btnSubmit.click();
			return new HomePage();
		}
		
}
