package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddServicePage {
	public AddServicePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="comment1")
	private WebElement serviceTextField;
	
	public WebElement getserviceTextField() {
		return serviceTextField;
	}
	
	public void AddService(String freeservice){
		serviceTextField.sendKeys(freeservice);
	}


}
