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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.RetailPOM;
import com.training.pom.OrderHistoryPOM;
import com.training.pom.OrderInformationPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC004_LoginTest {

	private WebDriver driver;
	private String baseUrl;
	private RetailPOM RetailPOM;
	private OrderHistoryPOM OrderHistoryPOM;
	private OrderInformationPOM OrderInformationPOM;
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
		OrderHistoryPOM = new OrderHistoryPOM(driver);
		OrderInformationPOM = new OrderInformationPOM(driver);
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
	public void validLoginTest() throws InterruptedException {
		
		
		RetailPOM.LoginRetail("santhosh.boggaram@in.ibm.com","Welcome2IBM");
		
		RetailPOM.NavigateToMyOrders();
		
		OrderHistoryPOM.clickViewBttn();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Assert.assertEquals(OrderInformationPOM.ChkOrderDetailstable(), "Order Details");
		
		ScreenShot.captureScreenShot("RTTC004_OrderDetails");
	}
}
