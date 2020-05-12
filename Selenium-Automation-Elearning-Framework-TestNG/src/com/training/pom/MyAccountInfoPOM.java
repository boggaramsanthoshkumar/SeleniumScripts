package com.training.pom;

import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.training.generics.ScreenShot;

public class MyAccountInfoPOM {
	private WebDriver driver; 
	private ScreenShot ScreenShot;
	
	public MyAccountInfoPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//a[contains(text(),'Edit your account information')]")
	private WebElement editMyAcc;
	
	
	@FindBy(xpath="//input[@id='input-firstname']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement eMail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	private WebElement telephone;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement continuebtn;
	
	
	
	
	public void firstName(String firstName) 
	{
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
	}
	
	public void lastName(String lastName) 
	{
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
	}
	
	public void eMail(String eMail) 
	{
		this.eMail.clear();
		this.eMail.sendKeys(eMail);
	}
	
	public void telephone(String telephone) 
	{
		this.telephone.clear();
		this.telephone.sendKeys(telephone);
	}
	
	

	public void VerifyPersonalDetails()
	{
		String fName = this.firstName.getAttribute("value");
		System.out.println("First name is: "+fName);
		
		String lName = this.lastName.getAttribute("value");
		System.out.println("Last name is: "+lName);
		
		String eMail = this.eMail.getAttribute("value");
		System.out.println("Enail is: "+eMail);
		
		String telephone = this.telephone.getAttribute("value");
		System.out.println("Telephone is: "+telephone);
		

	}
	
	public void bntContinue() 
	{
		this.continuebtn.click();
	}
	
}
