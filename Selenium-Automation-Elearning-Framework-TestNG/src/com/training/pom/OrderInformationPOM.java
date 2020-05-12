package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderInformationPOM {
	private WebDriver driver; 
	
	public OrderInformationPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover'][@xpath=\"1\"]")
	private WebElement OrderDetailsTable;
	
	@FindBy(xpath="//td[contains(text(),'Order Details')]")
	private WebElement ChkOrderDetailstable;
	
	public String ChkOrderDetailstable()
	{
		String str = this.ChkOrderDetailstable.getText();
		System.out.println("Order Details Displayed");
		return str;
	}
	
}
