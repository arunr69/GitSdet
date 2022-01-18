package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
/**
 * CreatingPurchaseOrderPage pom class
 */
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrderPage {
	public PurchaseOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name= "subject")
	private WebElement subjectTextFiled;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement vendorPlusImg;
	
	@FindBy(xpath = "//a[@href='javascript:window.close();']")
	private WebElement clickVendor;
	
	@FindBy(name = "bill_street")
	private WebDriver billingAddressTextField;
	
	@FindBy(name = "ship_street")
	private WebDriver shippingAddressTextField;
	
	
	@FindBy(id = "searchIcon1")
	private WebDriver productimg;
	
	@FindBy(id = "qty1")
	private WebDriver quantityTextField;
	
	@FindBy(id="Save [Alt+S]")
	private WebElement saveButton;
	
	//getters method

	public WebElement getClickVendor() {
		return clickVendor;
	}

	public WebDriver getBillingAddressTextField() {
		return billingAddressTextField;
	}

	public WebDriver getShippingAddressTextField() {
		return shippingAddressTextField;
	}

	public WebDriver getProductimg() {
		return productimg;
	}

	public WebDriver getQuantityTextField() {
		return quantityTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public WebElement getSubjectTextFiled() {
		return subjectTextFiled;
	}
	//business logic
	/**
	 * this method will creating purchase order
	 * @param purchase
	 * @param shop
	 * @param home
	 * @param two
	 */

	public void CreatingPurchaseOrderPage(String purchase,String shop,String home, String two) {
	subjectTextFiled.sendKeys(purchase);
	billingAddressTextField.sendKeys(shop);
	shippingAddressTextField.sendKeys(home);
	quantityTextField.sendKeys(two);
	saveButton.click();
	
	}

	public void createPurchaseOrder(String expectedpruchase) {
		// TODO Auto-generated method stub
		
	}
}

	
	
	