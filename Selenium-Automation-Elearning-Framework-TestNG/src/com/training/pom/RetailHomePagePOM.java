//package com.training.pom;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Action;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//
//import com.training.generics.ScreenShot;
//
//public class RetailHomePagePOM {
//	private WebDriver driver; 
//	private ScreenShot ScreenShot;
//	
//	public RetailHomePagePOM(WebDriver driver) {
//		this.driver = driver; 
//		PageFactory.initElements(driver, this);
//	}
//	
//	
//	//i[@class='fa fa-user-o']
//	
//	@FindBy(xpath="//i[@class='fa fa-user-o']")
//	private WebElement userIcon;
//	
//	@FindBy(xpath="//span[contains(text(),'LOGIN / REGISTER')]")
//	private WebElement loginRegister; 
//		
//	@FindBy(id="input-email")
//	private WebElement userName; 
//	
//	@FindBy(id="input-password")
//	private WebElement password;
//		
//	@FindBy(xpath="//input[@class='btn btn-primary']")
//	private WebElement loginBtn; 
//	
//	public void sendUserName(String userName) throws InterruptedException {
//		
//		WebDriverWait wait=new WebDriverWait(driver, 20);
//	
//		this.userName.clear();
//		this.userName.sendKeys(userName);
//	}
//	
//	public void sendPassword(String password) {
//		this.password.clear(); 
//		this.password.sendKeys(password); 
//	}
//	
//	public void clickLoginBtn() {
//		this.loginBtn.click(); 
//	}
//	
//	
//	public void LoginRetail(String sUserName, String sPassword) throws InterruptedException
//	{
//		ScreenShot = new ScreenShot(driver); 
//		
//		WebDriverWait wait=new WebDriverWait(driver, 20);
//		Actions builder = new Actions(driver);
//		Action mouseOver = builder.moveToElement(driver.findElement(By.xpath("//i[@class='fa fa-user-o']"))).build();
//	 	mouseOver.perform();
//	 	Thread.sleep(3000);
//	 	Actions mouseOver1 = builder.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'LOGIN / REGISTER')]")));
//	 	Thread.sleep(3000);
//	 	mouseOver1.build();
//	 	mouseOver1.click().perform();
//		
//		this.userName.clear();
//		this.userName.sendKeys(sUserName);
//		
//		this.password.clear(); 
//		this.password.sendKeys(sPassword); 
//		
//		this.loginBtn.click();
//		
//		String title=driver.getTitle();
//		Assert.assertEquals(title, "My Account");
//		System.out.println("Login Successful");
//		Thread.sleep(3000);
//		
//		//ScreenShot.captureScreenShot("screenshot_Login");
//		ScreenShot.captureScreenShot("Login");
//		//ScreenShot.captureScreenShot();
//	}
//}
