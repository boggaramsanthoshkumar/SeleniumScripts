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

public class RetailPOM {
	private WebDriver driver; 
	private ScreenShot ScreenShot;
	
	public RetailPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	//i[@class='fa fa-user-o']
	
	@FindBy(xpath="//i[@class='fa fa-user-o']")
	private WebElement userIcon;
	
	@FindBy(xpath="//span[contains(text(),'LOGIN / REGISTER')]")
	private WebElement loginRegister; 
	
	@FindBy(xpath="//span[contains(text(),'MY ORDERS')]")
	private WebElement loginMyOrders; 
	
	@FindBy(xpath="//span[contains(text(),'MY ORDERS')]")
	private WebElement MyOrderLink; 
	
	@FindBy(id="input-email")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
		
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//span[contains(text(),'Shop')]")
	private WebElement ShopIcon; 
	
	@FindBy(xpath="//span[contains(text(),'Ethnic')]")
	//span[contains(text(),'Ethnic')]
	private WebElement EthnicIcon; 
	
	
	@FindBy(xpath="//i[@class='tb_icon ico-linea-ecommerce-bag']")
	private WebElement bag;
	
	@FindBy(xpath="//a[contains(text(),'View Cart')]")
	private WebElement ViewCartbtn;
	
	public void sendUserName(String userName) throws InterruptedException 
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}

	
	
	
	public void LoginRetail(String sUserName, String sPassword) throws InterruptedException
	{
		ScreenShot = new ScreenShot(driver); 
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		Actions builder = new Actions(driver);
		Action mouseOver = builder.moveToElement(this.userIcon).build();
		mouseOver.perform();
	 	Thread.sleep(3000);
	 	Actions mouseOver1 = builder.moveToElement(this.loginRegister);
	 	Thread.sleep(3000);
	 	mouseOver1.build();
	 	mouseOver1.click().perform();
	
	 	sendUserName(sUserName);
		sendPassword(sPassword);
		clickLoginBtn();
		Thread.sleep(3000);
		ScreenShot.captureScreenShot("Login");
		System.out.println("Login Successful");
	}
	
	public void NavigateToMyOrders() throws InterruptedException {
		//WebDriverWait wait=new WebDriverWait(driver, 20);
	
		Actions builder = new Actions(driver);
		Action mouseOverHome = builder
				.moveToElement(this.userIcon)
				.build();
		mouseOverHome.perform();
		Thread.sleep(5000);
		
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(this.userIcon).moveToElement(this.MyOrderLink).moveToElement(this.MyOrderLink).click().perform();
		System.out.println("Navigated to Order History / My Orders page");
	}
	
	public void NavigateToShopEthnic() throws InterruptedException
	{
		ScreenShot = new ScreenShot(driver); 
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		Actions builder = new Actions(driver);
		Action mouseOverHome = builder
				.moveToElement(this.ShopIcon)
				.build();
		mouseOverHome.perform();
		Thread.sleep(5000);		
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(this.ShopIcon).moveToElement(this.EthnicIcon).moveToElement(this.EthnicIcon).click().perform();
		System.out.println("Navigated Ethnic page, Successfully");
		Thread.sleep(3000);
	}
	
	public void ViewCart() throws InterruptedException
	{
				
		WebDriverWait wait=new WebDriverWait(driver, 10);
		Thread.sleep(10000);		
		Actions builder = new Actions(driver);
		builder.moveToElement(this.bag).moveToElement(this.ViewCartbtn).click().perform();
		System.out.println("Shopping Cart page Opened, Successfully");
		Thread.sleep(3000);
		
		
	}
	
	
}
