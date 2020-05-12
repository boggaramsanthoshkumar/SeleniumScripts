package com.training.pom;

import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MyAccountPOM {
	private WebDriver driver; 
	
	public MyAccountPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Edit your account information')]")
	private WebElement editAccountLink;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement altmessage;
	
	@FindBy(xpath="//a[contains(text(),'Change your password')]")
	private WebElement changepwdlink;		
	
	
	public void editAccountLink()  
	{
		//driver.findElement(By.xpath("//a[contains(text(),'Edit your account information')]")).click();
		//WebDriverWait wait=new WebDriverWait(driver, 20);
		
		this.editAccountLink.isDisplayed();
		this.editAccountLink.click();
		
		String title=driver.getTitle();
		Assert.assertEquals(title, "My Account Information");
	}
	
	public void changepwdlink()  
	{
		this.changepwdlink.isDisplayed();
		this.changepwdlink.click();	
	}
	
	
	public String verifymsg()
	{
		String smsg = this.altmessage.getText();
		return smsg;
	}
	
	public String chanagepwdmsg()
	{
		String smsg = this.altmessage.getText();
		System.out.println("Password Change, Message displayed : "+smsg);
		return smsg;
	}
	
	
	
}

