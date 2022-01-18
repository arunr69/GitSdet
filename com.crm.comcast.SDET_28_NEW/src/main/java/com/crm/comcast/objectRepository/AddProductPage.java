package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductPage {
	public AddProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="searchIcon1")
	private WebElement productImgLink;

	public WebElement getProductImgLink() {
		return productImgLink;
	}
	
	//Business logic
	/**
	 * this method will add product
	 */
   public void AddProduct(){
	   productImgLink.click();
   }
}
   

