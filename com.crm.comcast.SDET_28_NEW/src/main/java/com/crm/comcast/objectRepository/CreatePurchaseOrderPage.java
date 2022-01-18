package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
/**
 * purchase order page
 */
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePurchaseOrderPage {
	public CreatePurchaseOrderPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="Purchase Order")
	private WebElement purchaseorderlink;

	public WebElement getPurchaseorderlink() {
		return purchaseorderlink;
	}
	
	//business logic
	 /**
	  * this method will click on CreatePurchaseOrder
	  */
	public void clickPurOrderImg(){
		purchaseorderlink.click();
		
	}
	

}
