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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC005_Test {

	private WebDriver driver;
	private String baseUrl;
	private RetailPOM LoginRetailPOM;
	private MyAccountPOM MyAccountPOM;
	private MyAccountInfoPOM MyAccountInfoPOM;
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
		LoginRetailPOM = new RetailPOM(driver);
		MyAccountInfoPOM = new MyAccountInfoPOM(driver); 
		MyAccountPOM= new MyAccountPOM(driver); 
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
		
		LoginRetailPOM.LoginRetail("santhosh.boggaram@in.ibm.com", "Welcome2IBM");

		MyAccountPOM.editAccountLink();

		MyAccountInfoPOM.VerifyPersonalDetails();
		Thread.sleep(5000);	
		ScreenShot.captureScreenShot("RTTC005_BeforeEdit");


		MyAccountInfoPOM.firstName("Santhosh");
		MyAccountInfoPOM.lastName("Boggaram");
		MyAccountInfoPOM.eMail("santhosh.boggaram@in.ibm.com");
		MyAccountInfoPOM.telephone("9999999999");

		MyAccountInfoPOM.VerifyPersonalDetails();
		Thread.sleep(5000);		
		ScreenShot.captureScreenShot("RTTC005_AfterEdit");

		MyAccountInfoPOM.bntContinue();
		
		Assert.assertEquals(MyAccountPOM.verifymsg(), "Success: Your account has been successfully updated.");

		ScreenShot.captureScreenShot("RTTC005_Msg");
	 	
	}
}
