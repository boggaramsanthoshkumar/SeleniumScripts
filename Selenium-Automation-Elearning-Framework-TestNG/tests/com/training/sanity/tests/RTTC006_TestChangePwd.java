package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.RetailPOM;
import com.training.pom.MyAccountPOM;
import com.training.pom.MyAccountInfoPOM;
import com.training.pom.ChangePasswordPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC006_TestChangePwd {

	private WebDriver driver;
	private String baseUrl;
	private RetailPOM RetailPOM;
	private MyAccountPOM MyAccountPOM;
	private MyAccountInfoPOM MyAccountInfoPOM;
	private ChangePasswordPOM ChangePasswordPOM;
	private static Properties properties;
	private ScreenShot ScreenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		RetailPOM = new RetailPOM(driver);
		MyAccountInfoPOM = new MyAccountInfoPOM(driver); 
		MyAccountPOM= new MyAccountPOM(driver); 
		ChangePasswordPOM = new ChangePasswordPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		ScreenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
	

	@Test
	public void validLoginTest() throws InterruptedException 
	{
		
		RetailPOM.LoginRetail("santhosh.boggaram@in.ibm.com", "Welcome2IBM");

		MyAccountPOM.changepwdlink();
		
		ChangePasswordPOM.password("Welcome3IBM");
		ChangePasswordPOM.ConfirmPassword("Welcome3IBM");
		
		ChangePasswordPOM.continueButton();
		
		Assert.assertEquals(MyAccountPOM.chanagepwdmsg(), "Success: Your password has been successfully updated.");
		
		ScreenShot.captureScreenShot("RTTC006_PwdMsg");
	 	
	}
}
