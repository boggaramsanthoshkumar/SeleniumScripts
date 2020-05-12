package com.training.pom;

import java.util.concurrent.TimeUnit;

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

public class FingerRingForladiesPOM {
	private WebDriver driver; 
	private ScreenShot ScreenShot;
	
	public FingerRingForladiesPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@id='button-cart']")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="//ul[@class='noty_cont noty_layout_topRight']")
	private WebElement AddToCartPopUp;
	
	public void ClickAddToCartBtn()  
	{
		this.addToCartBtn.click();
		System.out.println("Clicked on Add to Cart Button");
		String sPopUpMessage = this.AddToCartPopUp.getText();
		System.out.println("Pop up Message: "+sPopUpMessage);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
	
	
}
