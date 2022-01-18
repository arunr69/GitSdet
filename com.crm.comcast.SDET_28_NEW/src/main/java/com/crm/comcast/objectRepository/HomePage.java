package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUitility.WebDriverUtility;
/**
 * Homepage pom design
 * @author Arun R
 *
 */
public class HomePage extends WebDriverUtility {
	//initialization of element
	WebDriver driver;
    public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
		}
	//declaration of element
	
	@FindBy(xpath = "//a[@href='index.php?module=Products&action=index']")
	private WebElement productLink;
	
	@FindBy(name="Purchase Order")
	private WebElement purchaseorderlink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
	@FindBy(xpath = "//a[@href='javascript:;']")
	private WebElement moreLink;
	
	
    //getter method

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getPurchaseorderlink() {
		return purchaseorderlink;
	}

	public WebElement getLogoutImg() {
		return logoutImg;
	}

	public WebElement getLogoutsinoutLink() {
		return signOutLink;
	}
	
	//business logic
	/**
	 * this method will perform click productlink	
	 */
	public void clickProductLink() {
		productLink.click();
	}
	/**
	 * this method will perform click purchase order
	 * 
	 */
	public void clickPurchaseOrderLink(){
	purchaseorderlink.click();
	}
		
	public void logout() {
		mouseOver(driver, logoutImg);
		signOutLink.click();
	}
		
		public void gomoreLink() {
			mouseOver(driver, moreLink);
			moreLink.click();	
		

	}
		
		
		
	}

		
	
	

	
	
	
	


