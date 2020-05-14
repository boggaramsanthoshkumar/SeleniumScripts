package com.training.pom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.training.generics.ScreenShot;

public class CheckOutPOM {
	private WebDriver driver; 
	private ScreenShot ScreenShot;
	
	public CheckOutPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='tb_new_customer_box tb_sep']//div[2]//label[1]")
	private WebElement Guestcheckoutradio;
	

	@FindBy(xpath="//input[@id='button-account']")
	private WebElement Continuebtn;
	
	//Personal Details Elements
	@FindBy(xpath="//input[@id='input-payment-firstname']")
	private WebElement firstName;
	
	
	@FindBy(xpath="//input[@id='input-payment-lastname']")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@id='input-payment-email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='input-payment-telephone']")
	private WebElement telephone;
	
	
	//Your Address Elements
	@FindBy(xpath="//input[@id='input-payment-address-1']")
	private WebElement Address1;
	
	@FindBy(xpath="//input[@id='input-payment-city']")
	private WebElement City;
	
	@FindBy(xpath="//input[@id='input-payment-postcode']")
	private WebElement PostCode;
	
	@FindBy(name="country_id")
	private WebElement Country;
	
	@FindBy(name="zone_id")
	private WebElement RegionState;
	
	//@FindBy(xpath="//div[@id='collapse-payment-address']//div[@class='buttons']//label[1]")
	//@FindBy(xpath="//input[@name='shipping_address']")
	//@FindBy(xpath="//label[@class='checkbox']")
	@FindBy(xpath="//input[@type='checkbox'][@name='shipping_address']")
	private WebElement billdelisamechkbx;

	
	@FindBy(xpath="//input[@id='button-guest']")
	private WebElement guestContinuebtn;
	
	
	@FindBy(xpath="//textarea[@name='comment']")
	private WebElement DeliveryMethodComment;
	
	
	@FindBy(xpath="//input[@name='shipping_method']")
	private WebElement FreeShippingRadiobtn;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement TermsAndConditionsCheckBox;
	
	@FindBy(xpath="//input[@name='payment_method']")
	private WebElement CashOnDeliveryradiobtn;
	
	@FindBy(xpath="//textarea[contains(text(),'Delivery comments')]")
	//@FindBy(xpath="//textarea[@class='form-control'][@name='comment'][@xpath='2']")
	private WebElement PaymentMethodComments;
	
	@FindBy(xpath="//input[@id='button-confirm']")
	private WebElement ConfirmOrderBtn;
	
	@FindBy(xpath="//input[@id='button-shipping-method']")
	private WebElement ConitinueShippingMethod;
	
	@FindBy(xpath="//div[@class='tb_text_wrap tb_sep']//p[1]")
	private WebElement OrderSuccessMsg;
	
	@FindBy(xpath="//input[@id='button-payment-method']")
	private WebElement ContinuePaymentMethod;
	
	@FindBy(xpath="//h3[@class='heading']//span[@class='tb_items'][contains(text(),'0') or contains(text(),'1')]")
	//FindBy(xpath="/html[1]/body[1]/div[2]/header[1]/div[1]/div[1]/div[3]/div[2]/div[1]/ul[1]/li[1]/h3[1]/a[1]/span[1]")
	private WebElement bagCountZero;
	
	
	public void SelectGuestCheckOutRadio()  
	{
		this.Guestcheckoutradio.click();
		if(this.Guestcheckoutradio.isSelected())
		{
			System.out.println("Guest Checkout, selected");
		}

	}
	
	public void clickContinuebtn()  
	{
		this.Continuebtn.click();
	}
	
	
	
	public void EnterFirstName(String fName)  
	{
		this.firstName.clear();
		this.firstName.sendKeys(fName);
		
	}
	public void Enterlastname(String lName)  
	{
		this.lastName.clear();
		this.lastName.sendKeys(lName);
	}
	public void EnterEMail(String email)  
	{
		this.email.clear();
		this.email.sendKeys(email);
	}
	public void EnterTelephone(String telephone)  
	{
		this.telephone.clear();
		this.telephone.sendKeys(telephone);
	}
	public void EnterAddress1(String Address1)  
	{
		this.Address1.clear();
		this.Address1.sendKeys(Address1);
	}
	public void EnterCity(String City)  
	{
		this.City.clear();
		this.City.sendKeys(City);
	}
	public void EnterPostCode(String PostCode)  
	{
		this.PostCode.clear();
		this.PostCode.sendKeys(PostCode);
	}	
	public void SelectCountry(String Country)  
	{
		Select drpCountry = new Select(this.Country);
		drpCountry.selectByVisibleText(Country);
	}	
	public void SelectState(String state)  
	{
		Select drpstate = new Select(this.RegionState);
		drpstate.selectByVisibleText(state);
	}
	
	public void MydeliveryandbillingAddressesCheckBox() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//div[@id='collapse-payment-address']//div[@class='buttons']//label[1]"));
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Thread.sleep(5000);
		
		if(this.billdelisamechkbx.isSelected())
		{
			System.out.println("By Default checkbox selected: My delivery and billing addresses are the same.");
		}
		else
		{
			this.billdelisamechkbx.click();
			System.out.println("Selected Checkbox: My delivery and billing addresses are the same. ");
		}

	}
	
	public void ClickGuestContinuebtn()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//input[@id='button-guest']"));
        js.executeScript("arguments[0].scrollIntoView();", Element);
		this.guestContinuebtn.click();
	}
	
	public void FreeShippingRadiobtn()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//input[@name='shipping_method']"));
        js.executeScript("arguments[0].scrollIntoView();", Element);
       if(this.FreeShippingRadiobtn.isSelected())
       {
    	   System.out.println("Default: Free shipping selected");
       }
       else
       {
    	this.FreeShippingRadiobtn.click();
   		System.out.println("selected Free shipping radio button");   
       }
		
	}
	
	public void DeliveryMethodComment(String sText)
	{
		this.DeliveryMethodComment.sendKeys(sText);
		System.out.println("Entered comments in Delivery Method ");
	}
	
	public void TermsAndConditionsCheckBox()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//input[@name='agree']"));
        js.executeScript("arguments[0].scrollIntoView();", Element);
		
		if(this.TermsAndConditionsCheckBox.isSelected())
		{
			System.out.println("Default: Terms and Condition checkbox selected");
		}
		else
		{
			this.TermsAndConditionsCheckBox.click();
			System.out.println("Selected Terms and Conditions checkbox");
		}
	}
	
	public void CashOnDeliveryradiobtn()
	{
		if(this.CashOnDeliveryradiobtn.isSelected())
		{
			System.out.println("Default:: Selected CASH ON DELIVERY option");
		}
		else
		{
			this.CashOnDeliveryradiobtn.click();
			System.out.println("Selected Cash on Delivery Option");
		}
	}
	
	public void PaymentMethodComments(String comments)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//textarea[contains(text(),'delivery method')]"));
        js.executeScript("arguments[0].scrollIntoView();", Element);
        
		this.PaymentMethodComments.clear();
		this.PaymentMethodComments.sendKeys(comments);
		System.out.println("Entered Payment Method Comments");
	}
	
	public void ConfirmOrderBtn() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//input[@id='button-confirm']"));
        js.executeScript("arguments[0].scrollIntoView();", Element);
		
		if (this.ConfirmOrderBtn.isDisplayed())
		{
			//System.out.println("---->>>>Confirm order Button available <<<<<<------- ");
			this.ConfirmOrderBtn.click();
			Thread.sleep(3000);
		}
		else
		{
			System.out.println("Unable to get button properties");
		}
	}
	
	public void ConitinueShippingMethod()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//input[@id='button-shipping-method']"));
        js.executeScript("arguments[0].scrollIntoView();", Element);
        
		this.ConitinueShippingMethod.click();
	}
	
	public String OrderSuccessMsg() throws InterruptedException
	{
		Thread.sleep(3000);
		System.out.println("Message Displayed :: "+this.OrderSuccessMsg.getText());
		return (this.OrderSuccessMsg.getText());
	}
	
	public void ContinuePaymentMethod()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//input[@id='button-payment-method']"));
        js.executeScript("arguments[0].scrollIntoView();", Element);
		
        this.ContinuePaymentMethod.click();
	}
	
	public void displaybagCount() {
		if (this.bagCountZero.getText() =="0") {
			System.out.println("Cart Empty : " + this.bagCountZero.getText());
		} else {
			System.out.println("Cart Items : " + this.bagCountZero.getText());
		}
	}
	
}
