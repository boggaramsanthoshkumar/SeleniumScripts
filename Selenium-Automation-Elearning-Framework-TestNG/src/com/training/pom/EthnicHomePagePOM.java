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

public class EthnicHomePagePOM {
	private WebDriver driver; 
	private ScreenShot ScreenShot;
	
	public EthnicHomePagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	private WebElement ProductInteger; 
	
	//[text()='" + dynamicString + "']	
	
	public void ClickProduct(String dynamicString) {
				
		driver.findElement(By.xpath("//a[contains(text(),'"+dynamicString+"')]")).click();
		System.out.println("Clicked on Product  : "+dynamicString);
	}
	
	
}
