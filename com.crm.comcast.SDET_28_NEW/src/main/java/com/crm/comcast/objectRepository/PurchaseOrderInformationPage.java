package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrderInformationPage {
	public PurchaseOrderInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebDriver purchaseOrderinfoText;

	public WebDriver getPurchaseOrderinfoText() {
		return purchaseOrderinfoText;
	}
	
	/**
	 * It will return the purchase order text
	 */
    public String getpurchaseOrderInformationText() {
    	return purchaseOrderinfoText.getTitle(); 
    }
}
    

