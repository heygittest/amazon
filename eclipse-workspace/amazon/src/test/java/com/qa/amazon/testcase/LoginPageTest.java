package com.qa.amazon.testcase;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.amazon.base.AmazonBase;
import com.qa.amazon.pages.HomePage;
import com.qa.amazon.pages.loginPage;
import com.qa.amazon.util.UtilClass;

import junit.framework.Assert;

public class LoginPageTest extends AmazonBase{

	public loginPage login;
	public static HomePage home;
	public UtilClass util1;
	
	public LoginPageTest() throws IOException {
		super();
		
	}
	@Test (priority=-1)
	public void setup() throws IOException
	{
		// TODO Auto-generated constructor stub
		//init();
		extentTest=extent.startTest("Login  init");
		login=new loginPage();
		util1=new UtilClass();
		Assert.assertTrue(true);
		
	}
	@Test (priority=1)
	public void logintoHome() throws InterruptedException, IOException
	{
		extentTest=extent.startTest("Login test");
		home=login.login(prop.getProperty("emailid"), prop.getProperty("password"));
		Assert.assertTrue("Login Successful",true);
	}
	
	
	
}
