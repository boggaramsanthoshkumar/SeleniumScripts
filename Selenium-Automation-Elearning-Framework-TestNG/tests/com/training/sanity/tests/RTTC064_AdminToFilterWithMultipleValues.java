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

public class RTTC064_AdminToFilterWithMultipleValues {

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
	
	@Test(priority=2, dataProvider = "excel-inputs-RTTC064", dataProviderClass = LoginDataProviders.class)
	public void SearchProduct(String sProductName, String iPrice, String sProductStatus, String sProductModel,
			String iQuantity, String sProductImage, String sExpectedResult) throws InterruptedException {
		AdminProductsPOM.EnterProductName(sProductName);
		AdminProductsPOM.EnterProductPrice(iPrice);
		AdminProductsPOM.SelectProductStatus(sProductStatus);
		AdminProductsPOM.EnterProductModel(sProductModel);
		AdminProductsPOM.EnterProductQty(iQuantity);
		AdminProductsPOM.SelectProductImage(sProductImage);
		AdminProductsPOM.ClickOnFilterBtn();

		Thread.sleep(3000);

		String ActualResult = AdminProductsPOM.displayFilterResults();
		ScreenShot.captureScreenShot("RTTC064_Results_"+sExpectedResult+"_");
		Assert.assertEquals(ActualResult, sExpectedResult);
	}
}
