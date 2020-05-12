package com.training.pom;

import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ChangePasswordPOM {
	private WebDriver driver; 
	
	public ChangePasswordPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement pwd;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	private WebElement chgpwd;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement continuebtn;
	
	public void password(String pwd)  
	{
		this.pwd.clear();
		this.pwd.sendKeys(pwd);
	}
	
	public void ConfirmPassword(String chgpwd)  
	{
		this.chgpwd.clear();
		this.chgpwd.sendKeys(chgpwd);
	}
	
	public void continueButton()  
	{
		this.continuebtn.click();
	}
	
	
}

