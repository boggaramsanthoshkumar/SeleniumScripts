package com.training.pom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	
	@FindBy(xpath="//a[@class='btn btn-danger tb_no_text']")
	private WebElement ReturnButton;
	
	
	
	public String ChkOrderDetailstable()
	{
		String str = this.ChkOrderDetailstable.getText();
		System.out.println("Order Details Displayed");
		return str;
	}
	
	public void ClickReturnButton()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//a[@class='btn btn-danger tb_no_text']"));
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("arguments[0].scrollIntoView();", Element);
        
        //this.ReturnButton.click();
		
		driver.findElement(By.xpath("//a[@class='btn btn-danger tb_no_text']")).click();
	}
	
}
