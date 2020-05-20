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

public class AdministrationLoginPOM {
	private WebDriver driver; 
	private ScreenShot ScreenShot;
	
	public AdministrationLoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy(xpath="//input[@id='input-username']")
	private WebElement userName;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement LoginBtn;
	
	public void EnterUserName(String sName)
	{
		this.userName.clear();
		this.userName.sendKeys(sName);
	}
	
	public void EnterPassword(String sPwd)
	{
		this.password.clear();
		this.password.sendKeys(sPwd);
	}
	
	public void ClickLogin()
	{
		this.LoginBtn.click();
	}
	
	public void AdminLogin(String sUserId, String sPassword)
	{
		this.EnterUserName(sUserId);
		this.EnterPassword(sPassword);
		this.ClickLogin();
		System.out.println("Login Success");
	}
	
}
