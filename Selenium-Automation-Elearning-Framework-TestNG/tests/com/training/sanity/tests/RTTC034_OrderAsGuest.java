package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.*;
import com.training.pom.RetailPOM;
import com.training.pom.EthnicHomePagePOM;
import com.training.pom.FingerRingForladiesPOM;

import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC034_OrderAsGuest {

	private WebDriver driver;
	private String baseUrl;
	private RetailPOM RetailPOM;
	private EthnicHomePagePOM EthnicHomePagePOM;
	private FingerRingForladiesPOM FingerRingForladiesPOM;
	private ShoppingCartPOM ShoppingCartPOM;
	private CheckOutPOM CheckOutPOM;
	
	private static Properties properties;
	private ScreenShot ScreenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		
		RetailPOM = new RetailPOM(driver);
		EthnicHomePagePOM = new EthnicHomePagePOM(driver); 
		FingerRingForladiesPOM = new FingerRingForladiesPOM(driver);
		ShoppingCartPOM = new ShoppingCartPOM(driver);
		CheckOutPOM = new CheckOutPOM(driver);
		
		baseUrl = properties.getProperty("baseURL");
		ScreenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
		
	}

	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
	

	@Test(priority=0)
	public void OrderAsGuest() throws InterruptedException 
	{
		RetailPOM.NavigateToShopEthnic();
		
		EthnicHomePagePOM.ClickProduct("Engagement Ring");
		
		//System.out.println("Navigated to Ethnic page, and opened the product");
		ScreenShot.captureScreenShot("RTTC034_Ethnic Page");
	}
	
	@Test(priority=1)
	public void AddProdToCart() throws InterruptedException 
	{
		String winHandleBefore = driver.getWindowHandle();
		
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		
		FingerRingForladiesPOM.ClickAddToCartBtn();
				
		RetailPOM.ViewCart();
		
		ShoppingCartPOM.ViewItemsDetails();
		
		Assert.assertEquals(driver.getTitle(), "Shopping Cart");	

	}
	
	@Test(priority=2)
	public void CheckOut() throws InterruptedException 
	{
		CheckOutPOM.displaybagCount();
		
		ShoppingCartPOM.ClickCheckOuttBtn();	
		
		//CheckOut Options
		CheckOutPOM.SelectGuestCheckOutRadio();		
		CheckOutPOM.clickContinuebtn();
		
		//Billing Details
		CheckOutPOM.EnterFirstName("Santhosh");
		CheckOutPOM.Enterlastname("Boggaram");
		CheckOutPOM.EnterEMail("santhosh.boggaram@in.ibm.com");
		CheckOutPOM.EnterTelephone("9999999999");
		CheckOutPOM.EnterAddress1("Bangalore");
		CheckOutPOM.EnterCity("Bangalore");
		CheckOutPOM.EnterPostCode("560045");
		CheckOutPOM.SelectCountry("India");
		CheckOutPOM.SelectState("Telangana");
		System.out.println("Entered Billing Details");
		
		Thread.sleep(10000);
		CheckOutPOM.MydeliveryandbillingAddressesCheckBox();
		CheckOutPOM.ClickGuestContinuebtn();
		System.out.println("Clicked on Guest Continue Button");
		
		//Delivery Method
		CheckOutPOM.FreeShippingRadiobtn();	
		CheckOutPOM.DeliveryMethodComment("Delivery Method Comments");
		CheckOutPOM.ConitinueShippingMethod();
		
		//Payment Method
		CheckOutPOM.CashOnDeliveryradiobtn();
		CheckOutPOM.TermsAndConditionsCheckBox();
		CheckOutPOM.ContinuePaymentMethod();
		
			
		CheckOutPOM.ConfirmOrderBtn();
		
		CheckOutPOM.displaybagCount();
		
		ScreenShot.captureScreenShot("RTTC034_OrderSuccess");
		Assert.assertEquals(CheckOutPOM.OrderSuccessMsg(), "Your order has been successfully processed!");
	}
	
}
