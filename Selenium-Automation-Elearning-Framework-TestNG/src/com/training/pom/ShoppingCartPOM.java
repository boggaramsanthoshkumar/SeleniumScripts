package com.training.pom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.training.generics.ScreenShot;

public class ShoppingCartPOM {
	private WebDriver driver; 
	private ScreenShot ScreenShot;
	
	public ShoppingCartPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	private WebElement checkoutBtn;
	
	@FindBy(xpath="//table[@class='table']//tbody//tr[1]//td[4]")
	private WebElement shoppingCartItem;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	private WebElement continuebtn;
	
	public void ClickCheckOuttBtn()  
	{
		this.checkoutBtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
	
	public void ViewItemsDetails()
	{
		try
		{
			WebElement table = driver.findElement(By.xpath("//div[@class='cart-info tb_min_w_500']//table[@class='table']/tbody"));
			
			if (table.isDisplayed())
			{
				List<WebElement> allRows = table.findElements(By.tagName("tr"));

				for (WebElement row : allRows) {
					List<WebElement> cells = row.findElements(By.tagName("td"));
					//row..getText().contains("Order ID"))
						for (WebElement cell : cells) 
						{
							System.out.println("Product Details---->>   " + cell.getText());
						}
					
					System.out.print("");
				}
			}
		}catch(NoSuchElementException e) {
			System.out.println("Shopping Cart is Empty");
			//System.exit(1);
		}
	}
	
	
	
	public void ClickContinueButton()  
	{
		this.continuebtn.click();

	}
}
