package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import com.sun.rowset.internal.Row;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.*;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class RTTC065_AdminToAddMultipleProducts {

	private WebDriver driver;
	private String adminURL;
	private String excelPath="C:\\Users\\SanthoshKumarBoggara\\git\\repository\\git3\\Selenium-Automation-Elearning-Framework-TestNG\\documents\\DataSheet.xlsx";
	
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
	//@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
	

	
	@Test(priority=0, dataProvider = "excel-inputs-Login", dataProviderClass = LoginDataProviders.class)
	//@Test(priority=0)
	public void Login(String userName, String password) throws InterruptedException 
	{
		AdministrationLoginPOM.AdminLogin(userName, password);

	}
	
	@Test(priority=1)
	public void OpenCatalogProducts() throws InterruptedException 
	{
		AdminDashboardPOM.OpenCatalogProducts();
	}
	
	@Test(priority=2, dataProvider = "excel-inputs-RTTC065", dataProviderClass = LoginDataProviders.class)
	public void CreateNewProduct(String sProductName, 
			String sMetaTitle, 
			String sModel,
			String sPrice,
			String sQuantity,
			String sCategory,
			String sExpectedResult) throws InterruptedException {
		
		AdminProductsPOM.AddNewProduct();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		AdminProductsPOM.AddProductName(sProductName);
		
		AdminProductsPOM.EnterMetaTagTitle(sMetaTitle);
		
		AdminProductsPOM.OpenDatatab();
		
		AdminProductsPOM.EnterModelname(sModel);
		
		AdminProductsPOM.EnterPrice(sPrice);
		
		AdminProductsPOM.EnterQuantity(sQuantity);
		
		AdminProductsPOM.OpenLinksTab();
		
		AdminProductsPOM.selectCategories(sCategory);
		
		AdminProductsPOM.ClickSaveButton();

		ScreenShot.captureScreenShot("RTTC065-AddedProduct-"+sCategory+"-");

		
		String str=AdminProductsPOM.GetConfimMessage();
		str = str.length() > 36 ? str.substring(0, 36) : str;
		System.out.println("Confirmation Message: "+str);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Assert.assertEquals(str, "Success: You have modified products!");

	}
}
