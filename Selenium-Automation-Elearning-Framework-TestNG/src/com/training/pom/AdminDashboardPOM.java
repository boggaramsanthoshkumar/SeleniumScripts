package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.training.generics.ScreenShot;

public class AdminDashboardPOM {
	private WebDriver driver; 
	private ScreenShot ScreenShot;
	
	public AdminDashboardPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy(xpath="//i[@class='fa fa-indent fa-lg']")
	private WebElement HomeMenu;
	
	@FindBy(xpath="//i[@class='fa fa-dedent fa-lg']")
	private WebElement HomeMenuClose;
	
	@FindBy(xpath="//body/div[@id='container']/nav[@id='column-left']/ul[@id='menu']/li[@id='menu-catalog']/a[1]")
	private WebElement menuCatalog;
	
	@FindBy(xpath="//a[contains(text(),'Products')]")
	private WebElement ProductsLink;
	
	@FindBy(xpath="//h1[contains(text(),'Products')]")
	private WebElement ProductsHome;
	
	public void HomeMenu()
	{
		this.HomeMenu.click();
	}
	
	public void OpenCatalogProducts()
	{
		this.HomeMenu.click();
		this.menuCatalog.click();
		this.ProductsLink.click();
		if(this.ProductsHome.isDisplayed())
		{
			System.out.println("Products Page displayed");
		}
		this.HomeMenuClose.click();
	}
	
}
