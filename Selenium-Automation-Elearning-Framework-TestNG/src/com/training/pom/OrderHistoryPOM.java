package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generics.ScreenShot;

public class OrderHistoryPOM {
	private WebDriver driver; 
	private ScreenShot ScreenShot;
	
	
	public OrderHistoryPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//table[@class='table table-hover']")
	private WebElement OrderDetailsTable; 
	
	
	//@FindBy(xpath="//table[@class='table table-hover']//tr[1]//td[7]")
	@FindBy(xpath="//i[@class='fa fa-eye']")
	private WebElement viewButton;
	
	public void clickViewBttn()
	{
		this.viewButton.click();
	}
	
	
	public void viewOrders() throws NoSuchElementException, InterruptedException {
		ScreenShot = new ScreenShot(driver);
		try {
			ScreenShot.captureScreenShot("ViewOrders");
			if (driver.findElement(By.xpath("//table[@class='table table-hover']/thead")).isDisplayed()) {
				System.out.println("TagName of View icon is: "+this.viewButton.getTagName());
				this.viewButton.click();
				System.out.println("Clicked on View Icon");
				Thread.sleep(3000);
				// table[@class='table table-bordered table-hover'][@xpath="1"]

			}

		} catch (NoSuchElementException e) {
			System.out.println("Unable to click VIEW icon");
			System.exit(1);
		}

	}
	
	
	
	public void displayOrderDetailsTableHeader() throws NoSuchElementException
	{
		
		try
		{
			WebElement table = driver.findElement(By.xpath("//table[@class='table table-hover']/thead"));

			if (table.isDisplayed())
			{
				List<WebElement> allRows = table.findElements(By.tagName("tr"));

				for (WebElement row : allRows) {
					List<WebElement> cells = row.findElements(By.tagName("td"));
					//row..getText().contains("Order ID"))
						for (WebElement cell : cells) 
						{
							System.out.println("Table content >>   " + cell.getText());
						}
					
					System.out.print("");
				}
			}
		}catch(NoSuchElementException e) {
			System.out.println("No Orders to Display / No Table");
			System.exit(1);
		}

	}
}
