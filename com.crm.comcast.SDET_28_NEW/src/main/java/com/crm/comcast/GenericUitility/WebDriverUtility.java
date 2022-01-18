package com.crm.comcast.GenericUitility;

import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ContextClickAction;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.cj.jdbc.Driver;
public class WebDriverUtility {
	
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
/**
 * This method will wait till element is visible
 * @param driver
 * @param element
 */
	
	
	public void waitForPageLoad(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
		
		
	}
	/**
	 * this method wait till element is visible
	 * @param driver
	 * @param element
	 */
	
	
	public void waitaForVisibilityOfElement(WebDriver driver,WebElement element) {
    WebDriverWait wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOf(element));
	
	}
	/**
	 * This Method will wait till element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitaForElementToBeClick(WebDriver driver,WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		}
	
	/**
	 * The method will select the element based on index
	 * @param element
	 * @param index
	 */
	
   public void SelectOption(WebElement element,int index) {
	   Select select = new Select(element);
	   select.selectByIndex(index);
	   
   }
   
   /**
    * The method is used to select the value based on the value
    * @param element
    * @param value
    */
   public void SelectOption(WebElement element,String value) {
	   Select select = new Select(element);
	   select.selectByValue(value);
   }
   

 
   /**
    * The method is used to select the value based on the text
    * @param text
    * @param element
    */
   public void SelectOption(String text,WebElement element) {
	   Select select = new Select(element);
	   select.selectByVisibleText(text);
   
   }   

   /**
    * This method performs mouse hovering action
    * @param driver
    * @param element
    */
   public void mouseOver(WebDriver driver, WebElement element) {
	  Actions action = new Actions(driver);
	  action.contextClick(element).perform();
   
   }

   /**
    * this method perform right click perfornm
    * @param driver
    * @param element
    */
   public void rightClick (WebDriver driver, WebElement element) {
	   Actions action = new Actions(driver);
		  action.contextClick(element).perform();
   }
   /**
    * used to perform java script click on element
    * @param driver
    * @param element
    */
   public void jsClick (WebDriver driver, WebElement element) {
	   JavascriptExecutor js = (JavascriptExecutor)driver;
	   js.executeScript("arguments[0].click",element);
   }
   
   /**
    *This Method is used to send the value using java script executor 
    * @param driver
    * @param valueTOEnter
    * @param element
    */
  
   public void enterDataUsingJs(WebDriver driver,String valueTOEnter,WebElement element) {
	   JavascriptExecutor js = (JavascriptExecutor)driver;
	   js.executeScript("arguments[0].value='"+valueTOEnter+"'",element);
	   
   }
  
   /**
    * The meathod will Switch to different window using partial title
    * @param driver
    * @param partialWindowTitle
    */
   
   public void switchWindow(WebDriver driver,String partialWindowTitle) {
	Set<String> winIds = driver.getWindowHandles();
	 java.util.Iterator<String> it = winIds.iterator();
	while(it.hasNext()) {
		 String windId = it.next(); 
		 String title = driver.switchTo().window(windId).getTitle();
		 if(title.contains(partialWindowTitle)) {
			 break;
		 }
	}
	
}
	/**
	 * 
	 * @param driver
	 * @param testcaseName
	 * @return 
	 * @return
	 */
	
 
 public String screenShot(WebDriver driver, String testCaseName) {
	 JavaUtility jUtil = new JavaUtility();
	 String filePath = "./errorshot/"+testCaseName+jUtil.systemDataAndTime()+".png";
	 TakesScreenshot ts = (TakesScreenshot)driver;
	 File sources = ts.getScreenshotAs(OutputType.FILE);
	 File destination = new File(filePath);
	 sources.renameTo(destination);
    return filePath;
 }  
	 
	 

/**
    * This method will switch to frame based on the index passed 
    * @param driver
    * @param index
    */
   public void switchframes(WebDriver driver,int index) {
	   driver.switchTo().frame(index);
	   
   }
    
   /**
    * This method will switch to frame based on the name or id passed 
    * @param driver
    * @param nameOrId
    */
   public void switchframes(WebDriver driver,String nameOrId ) {
	   driver.switchTo().frame(nameOrId);
   }
   
   
   /**
    * This method will switch to frame based on the webelement passed
    * @param driver
    * @param element
    */
   public void switchframes(WebDriver driver,WebElement element ) {
	   driver.switchTo().frame(element);
   }
   
   /**
    * method will accept the alert
    * @param driver
    */
   public void acceptAlert(WebDriver driver) {
	   driver.switchTo().alert().accept();
   }
   
   /**
    * this method will click on dismiss button in alert popup
    * @param driver
    */
   public void dismissAlert(WebDriver driver) {
	   driver.switchTo().alert().dismiss();
   }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
   }

 
	 
   
   
	














