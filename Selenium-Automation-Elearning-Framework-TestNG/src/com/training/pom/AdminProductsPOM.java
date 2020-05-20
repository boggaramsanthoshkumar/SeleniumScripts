package com.training.pom;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.training.generics.ScreenShot;

public class AdminProductsPOM {
	private WebDriver driver; 
	private ScreenShot ScreenShot;
	
	public AdminProductsPOM(WebDriver driver) {
		this.driver = driver; 
		ScreenShot = new ScreenShot(driver); 
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy(xpath="//div[@class='pull-right']//a[@class='btn btn-primary']")
	private WebElement AddNewProduct;
	
	//Catalog->Products->Search Product
	@FindBy(xpath="//input[@id='input-name']")
	private WebElement SearchProductName;
	
	//Catalog->Products->Add New Product->Enter Product
	@FindBy(xpath="//input[@id='input-name1']")
	private WebElement AddProductName;
	
	@FindBy(xpath="//input[@id='input-meta-title1']")
	private WebElement MetaTagTitle;

	@FindBy(xpath="//a[contains(text(),'Data')]")
	private WebElement DataTab;
	
	@FindBy(xpath="//input[@id='input-model']")
	private WebElement ModelName;
	
	@FindBy(xpath="//input[@id='input-price']")
	private WebElement Price;
	
	@FindBy(xpath="//input[@id='input-quantity']")
	private WebElement Quantity;
	
	@FindBy(xpath="//a[contains(text(),'Links')]")
	private WebElement Linkstab;
	
	@FindBy(xpath="//input[@id='input-category']")
	//input[@id='input-category']
	private WebElement Categories;
	

	
	@FindBy(xpath="//a[contains(text(),'Discount')]")
	private WebElement DiscountTab;
	
	@FindBy(xpath="//table[@id='discount']//button[@class='btn btn-primary']")
	private WebElement AddDiscountIcon;
	
	@FindBy(xpath="//td[@class='text-right']//input[@placeholder='Quantity']")
	private WebElement DiscountQuantity;
	
	@FindBy(xpath="//td[@class='text-right']//input[@placeholder='Price']")
	private WebElement DiscountPrice;
	
	@FindBy(xpath="//input[@placeholder='Date Start']")
	private WebElement DiscountDateStart;
	
	@FindBy(xpath="//td[5]//div[1]//span[1]//button[1]//i[1]")
	private WebElement DiscountDateStartCalenderIcon;
	
	@FindBy(xpath="//input[@placeholder='Date End']")
	private WebElement DiscountDateEnd;
	
	@FindBy(xpath="//td[6]//div[1]//span[1]//button[1]//i[1]")
	private WebElement DiscountDateEndCalenderIcon;
	
	@FindBy(xpath="//ul[@class='nav nav-tabs']//a[contains(text(),'Reward Points')]")
	private WebElement RewardsPointsTab;
	
	@FindBy(xpath="//input[@id='input-points']")
	private WebElement RewardsPoints;
	
	@FindBy(xpath="//i[@class='fa fa-save']")
	private WebElement SaveProduct;
	
	@FindBy(xpath="//i[@class='fa fa-reply']")
	private WebElement CancelButton;
	
	//@FindBy(xpath="//div[@class='alert alert-success']")
	@FindBy(xpath="//div[@class='alert alert-success' and contains(text(),'Success')]")
	private WebElement SuccessMsg;
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	private WebElement ErrorMsg;
	
	@FindBy(xpath="//td[5]//div[1]//span[1]//button[1]")
	private WebElement StartDateCalenderIcon;
	
	@FindBy(xpath="//div[@class='bootstrap-datetimepicker-widget dropdown-menu picker-open bottom']//td[@class='day active today']")
	private WebElement dayActiveToday;
	
	
	
	@FindBy(xpath="//td[6]//div[1]//span[1]//button[1]//i[1]")
	private WebElement EndDateCalenderIcon;
	
	@FindBy(xpath="//input[@id='input-price']")
	private WebElement ProductPrice;
	
	@FindBy(xpath="//select[@id='input-status']")
	private WebElement ProductStatus;
	
	@FindBy(xpath="//input[@id='input-model']")
	private WebElement ProductModel;
	
	@FindBy(xpath="//input[@id='input-quantity']")
	private WebElement ProductQty;
	
	@FindBy(xpath="//select[@id='input-image']")
	private WebElement ProductImage;
	
	@FindBy(xpath="//button[@id='button-filter']")
	private WebElement ProductFilterBtn;
	
	
	
	
	
	public void AddNewProduct()
	{
		this.AddNewProduct.click();
	}
	
	public void EnterProductName(String sProductname)
	{
		this.SearchProductName.clear();
		this.SearchProductName.sendKeys(sProductname);
	}
	public void AddProductName(String sProductname)
	{
		this.AddProductName.clear();
		this.AddProductName.sendKeys(sProductname);
	}
	public void EnterProductPrice(String iPrice)
	{
		this.ProductPrice.clear();
		//this.ProductPrice.sendKeys(String.valueOf(iPrice));
		this.ProductPrice.sendKeys(iPrice);
	}
	public void SelectProductStatus(String sProductStatus)
	{
		this.ProductStatus.sendKeys(sProductStatus);
		
	}
	
	public void EnterProductModel(String sProductModel)
	{
		this.ProductModel.clear();
		this.ProductModel.sendKeys(sProductModel);		
	}
	
	public void EnterProductQty(String iProductQty)
	{
		this.ProductQty.clear();
		this.ProductQty.sendKeys(iProductQty);		
	}
	
	public void SelectProductImage(String sProductImg)
	{
		this.ProductImage.sendKeys(sProductImg);	
	}
	
	public void EnterMetaTagTitle(String sMetaTagTitle)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//input[@id='input-meta-title1']"));
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("arguments[0].scrollIntoView();", Element);
		
		this.MetaTagTitle.clear();
		this.MetaTagTitle.sendKeys(sMetaTagTitle);
	}
	
	public void OpenDatatab()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//a[contains(text(),'Data')]"));
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("arguments[0].scrollIntoView();", Element);
		
		this.DataTab.click();
	}
	
	public void EnterModelname(String sModelName)
	{
		this.ModelName.clear();
		this.ModelName.sendKeys(sModelName);
	}
	
	public void EnterPrice(String sPrice)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//input[@id='input-price']"));
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("arguments[0].scrollIntoView();", Element);
        
        
		this.Price.clear();
		this.Price.sendKeys(sPrice);
	}
	
	public void EnterQuantity(String sQuantity)
	{
		this.Quantity.clear();
		this.Quantity.sendKeys(sQuantity);
	}
	
	public void OpenLinksTab()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//a[contains(text(),'Links')]"));
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("arguments[0].scrollIntoView();", Element);
        
        this.Linkstab.click();
	}
	
	public void selectCategories(String sCategories) throws InterruptedException
	{
		
		//@FindBy(xpath="//a[contains(text(),'EARRINGS')]")
		
		this.Categories.click();
		Thread.sleep(3000);
		this.Categories.sendKeys(sCategories);
		Thread.sleep(3000);	
		WebElement element =  driver.findElement(By.xpath("//a[contains(text(),'"+sCategories+"')]"));
		//a[contains(text(),'"+sCategories+"')]
		if(element.isEnabled())
			element.click();
		System.out.println("Selected Categories as: "+sCategories);
	}
	
	public void OpenDiscountTab()
	{
		this.DiscountTab.click();
	}
	
	public void ClickAddDiscountIcon()
	{
		this.AddDiscountIcon.click();
	}
	
	public void EnterDiscountQuantity(String sDiscountQuantity)
	{
		this.DiscountQuantity.click();
		this.DiscountQuantity.sendKeys(sDiscountQuantity);
	}
	
	public void EnterDicountPrice(String sDiscountPrice)
	{
		this.DiscountPrice.click();
		this.DiscountPrice.sendKeys(sDiscountPrice);
	}
	
	public void SelectStartDateAndEndDate() throws InterruptedException
	{		
		
		Calendar calendar1 = Calendar.getInstance();
		calendar1.add(Calendar.DAY_OF_YEAR, 1);		
		Date currentDateTime1 = calendar1.getTime();
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd");
		String FutureDate = sdf1.format(currentDateTime1);
		//Thread.sleep(3000);
		System.out.println("Future Date: "+FutureDate);
		
		
		
		this.StartDateCalenderIcon.click();
		Thread.sleep(2000);
		this.dayActiveToday.click();
		Thread.sleep(2000);	
		this.EndDateCalenderIcon.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[6]//td[@class='day'][contains(text(),'"+FutureDate+"')]")).click();	
		
	}
	
	public void OpenRewardsPointsTab()
	{
		this.RewardsPointsTab.click();
	}
	
	public void EnterRewardsPoints(String sPoints)
	{
		this.RewardsPoints.click();
		this.RewardsPoints.sendKeys(sPoints);
	}
	
	public void ClickSaveButton()
	{
		this.SaveProduct.click();
	}
	
	public void ClickCancelButton()
	{
		this.CancelButton.click();
	}
	
	public String GetConfimMessage()
	{
		String str = this.SuccessMsg.getText();
		return str;
	}
	
	public String GetErrorMessage()
	{
		String str = this.ErrorMsg.getText();
		return str;
	}
	
	public void ClickOnFilterBtn()
	{
		this.ProductFilterBtn.click();
	}
	
	public String displayFilterResults() throws NoSuchElementException {
		String str="";
		try {
			WebElement table = driver
					.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody"));
			
			
			if (table.isDisplayed()) {
				List<WebElement> allRows = table.findElements(By.tagName("tr"));
				
				for (WebElement row : allRows) {
					List<WebElement> cells = row.findElements(By.tagName("td"));
					// row..getText().contains("Order ID"))
					for (WebElement cell : cells) {
						System.out.println("Table content >>   " + cell.getText());
						str=cell.getText();
//						if("No results!".equals(str))
//						{
//							count=count+1;
//						}
					}
					System.out.print("");
				}
			}
			if("No results!".equals(str))
				return "InValid";
			else
				return "Valid";
			
		} catch (NoSuchElementException e) {
			System.out.println("No Orders to Display / No Table");
			System.exit(1);
			return str;

		}

	}
	
	
}
