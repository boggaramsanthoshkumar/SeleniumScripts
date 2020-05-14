package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductReturnsPOM {
	private WebDriver driver; 
	
	public ProductReturnsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='col-sm-10']//div[1]//label[1]")
	private WebElement RRDeadOnArrival;
	
	//@FindBy(xpath="//body[@class='account-return-add-1161 tb_width_1200 tb_lang_ltr tb_page_account_return_add is_logged head_glob_intro_glob_cont_glob_foot_glob_ar_head_glob_ar_intro__def_ar_cont__def_ar_col_l_glob_ar_foot_glob_en-gb_733d2 no_touch']/div[@id='wrapper']/section[@id='content']/div[@class='row tb_separate_columns tb_ip_50']/div[@class='main col col-xs-12 col-sm-fill col-md-fill']/div[@class='row_8rjbB row-wrap lazyloaded']/div[@class='row tb_gut_xs_30 tb_gut_sm_30 tb_gut_md_50 tb_gut_lg_50']/div[@class='col_hJRg2 col col-xs-12 col-sm-12 col-md-12 col-lg-12 col-align-default col-valign-top tb_pt_0 tb_pr_0 tb_pb_0 tb_pl_0']/div[@id='System_s3bhXNDb']/form[@id='return_request_form']/fieldset/div[@class='form-group required']/div[@class='col-sm-10']/label[1]")
	@FindBy(xpath="//label[@class='radio-inline']//input[@value='1']")
	private WebElement IsProductOpenedYes;
	
	@FindBy(xpath="//input[@type='radio'][@name='return_reason_id'][@value='1']")
	private WebElement ReasonForReturn;
	
	@FindBy(xpath="//textarea[@id='input-comment']")
	private WebElement ReturnReasonComments;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement SubmitReturn;
	
	@FindBy(xpath="//p[contains(text(),'Thank you for submitting')]")
	private WebElement ReturnConfirmMsg;
	

	
	
	public void SelectReasonForReturn() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//div[@class='col-sm-10']//div[1]//label[1]"));
		//js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("arguments[0].scrollIntoView();", Element);
		
       RRDeadOnArrival.sendKeys(Keys.PAGE_UP);
        Thread.sleep(3000);
		this.RRDeadOnArrival.click();
	}
	
	public void IsProductOpenedYes()
	{
		this.IsProductOpenedYes.click();
	}
	
	public void EnterReasonForReturn(String sReason)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//div[@class='col-sm-10']//div[1]//label[1]"));
		//js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("arguments[0].scrollIntoView();", Element);
		
		this.ReturnReasonComments.clear();
		this.ReturnReasonComments.clear();
		this.ReturnReasonComments.sendKeys(sReason);
		
	}
	
	public void SubmitReturn()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("arguments[0].scrollIntoView();", Element);
        
		this.SubmitReturn.click();
	}
	
	public String ReturnConfirmationMessage()
	{
		String msg=this.ReturnConfirmMsg.getText();
		System.out.println("Return Order Confirmation message :"+msg);
		return msg;
		
	}
	
}
