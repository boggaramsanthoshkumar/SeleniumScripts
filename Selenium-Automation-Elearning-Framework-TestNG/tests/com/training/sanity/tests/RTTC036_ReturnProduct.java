package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminDashboardPOM;
import com.training.pom.AdminProductsPOM;
import com.training.pom.AdministrationLoginPOM;
import com.training.pom.LoginPOM;
import com.training.pom.RetailPOM;
import com.training.pom.OrderHistoryPOM;
import com.training.pom.OrderInformationPOM;
import com.training.pom.ProductReturnsPOM;
import com.training.pom.ProductReturnsPOM;

import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC036_ReturnProduct {

	private WebDriver driver;
	private String baseURL;
	private RetailPOM RetailPOM;
	private OrderHistoryPOM OrderHistoryPOM;
	private OrderInformationPOM OrderInformationPOM;
	private ProductReturnsPOM ProductReturnsPOM;
	private static Properties properties;
	private ScreenShot ScreenShot;
	
	@FindBy(xpath="//a[@class='btn btn-danger tb_no_text']")
	private WebElement ReturnButton;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		
		RetailPOM = new RetailPOM(driver);
		OrderHistoryPOM = new OrderHistoryPOM(driver);
		ProductReturnsPOM = new ProductReturnsPOM(driver);
		
		
		baseURL = properties.getProperty("baseURL");
		ScreenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseURL);
	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
	
	
	@Test(priority=0)
	public void LoginTest() throws InterruptedException {
		RetailPOM.LoginRetail("santhosh.boggaram@in.ibm.com", "Welcome2IBM");
	}
	
	@Test(priority=1)
	public void OpenOrderDetails() throws InterruptedException {
		RetailPOM.NavigateToMyOrders();

		OrderHistoryPOM.clickViewBttn();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	@Test(priority=2)
	public void ReturnOrder() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='btn btn-danger tb_no_text']")).click();
				
		ProductReturnsPOM.SelectReasonForReturn();
		
		ProductReturnsPOM.IsProductOpenedYes();
		
		ProductReturnsPOM.EnterReasonForReturn("product is faulty");
		
		ProductReturnsPOM.SubmitReturn();
		
		ScreenShot.captureScreenShot("RTTC036_OrderReturnConfimation");
		
		Assert.assertEquals(ProductReturnsPOM.ReturnConfirmationMessage(), "Thank you for submitting your return request. Your request has been sent to the relevant department for processing.");
		
		
	}
	
	
}
