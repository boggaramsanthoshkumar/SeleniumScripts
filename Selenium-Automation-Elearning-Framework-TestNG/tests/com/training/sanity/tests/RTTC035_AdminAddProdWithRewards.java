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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC035_AdminAddProdWithRewards {

	private WebDriver driver;
	private String adminURL;
	private AdministrationLoginPOM AdministrationLoginPOM;
	private AdminDashboardPOM AdminDashboardPOM;
	private AdminProductsPOM AdminProductsPOM;
	
	private static Properties properties;
	private ScreenShot ScreenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		
		AdministrationLoginPOM = new AdministrationLoginPOM(driver);
		AdminDashboardPOM = new AdminDashboardPOM(driver);
		AdminProductsPOM = new AdminProductsPOM(driver);

		
		adminURL = properties.getProperty("adminURL");
		ScreenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(adminURL);
		
		
	}

	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
	

	@Test(priority=0)
	public void Login() throws InterruptedException 
	{
		AdministrationLoginPOM.EnterUserName("admin");
		AdministrationLoginPOM.EnterPassword("admin@123");
		AdministrationLoginPOM.ClickLogin();
		System.out.println("Login Success");
		
	}
	
	@Test(priority=1)
	public void OpenProducts() throws InterruptedException 
	{
		AdminDashboardPOM.OpenCatalogProducts();
	}
	
	@Test(priority=2)
	public void AddNewproduct() throws InterruptedException 
	{
		AdminProductsPOM.AddNewProduct();
		
		AdminProductsPOM.EnterProductName("Finger Ring_santhosh");
		
		AdminProductsPOM.EnterMetaTagTitle("Finger Ring for ladies");
		
		AdminProductsPOM.OpenDatatab();
		
		AdminProductsPOM.EnterModelname("SKU-012");
		
		AdminProductsPOM.EnterPrice("500");
		
		AdminProductsPOM.EnterQuantity("50");
		
		AdminProductsPOM.OpenLinksTab();
		
		AdminProductsPOM.selectCategories("EARRINGS");
		
		AdminProductsPOM.OpenDiscountTab();
		
		AdminProductsPOM.ClickAddDiscountIcon();
		
		AdminProductsPOM.EnterDiscountQuantity("1");
		
		AdminProductsPOM.EnterDicountPrice("50");
		
		AdminProductsPOM.SelectStartDateAndEndDate();
		
		AdminProductsPOM.OpenRewardsPointsTab();
		
		AdminProductsPOM.EnterRewardsPoints("20");
		
		AdminProductsPOM.ClickSaveButton();
		
		ScreenShot.captureScreenShot("RTTC035_AdminToAddProdWithRewards");
		
		String str=AdminProductsPOM.GetConfimMessage();
		str = str.length() > 36 ? str.substring(0, 36) : str;
		System.out.println("Confirmation Message: "+str);
		
		Assert.assertEquals(str, "Success: You have modified products!");
		
	
	}
	
}
