package PurchaseOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.comcast.GenericUitility.ExcelUtility;
import com.crm.comcast.GenericUitility.FileUtility;
import com.crm.comcast.GenericUitility.IpathConstants;
import com.crm.comcast.GenericUitility.JavaUtility;
import com.crm.comcast.GenericUitility.WebDriverUtility;
/**
 * Test script for PurchaseOrderWithItemAndAddServiceTest
 * @author Dell
 *
 */
public class PurchaseOrderWithItemAndAddServiceTest {
	public static void main(String[] args)  throws Throwable {
		
		//create object for utilities
	FileUtility fUtil = new FileUtility();	
	JavaUtility jUtil = new JavaUtility();
	ExcelUtility eUtil = new ExcelUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	
	    //Get the data from property file
	String url = fUtil.getPropertyKeyValue("url");
	String username = fUtil.getPropertyKeyValue("username");
	String password = fUtil.getPropertyKeyValue("password");
	String browser = fUtil.getPropertyKeyValue("browser");
	
        //Get the data from excel
	String pruchase = eUtil.getStringCellData("Sheet1", 5, 1);
	pruchase = pruchase+jUtil.getRandomNumber();
	    
     //launch the browser
	WebDriver driver = null;
	if(browser.equalsIgnoreCase("chrome")) {
	System.setProperty(IpathConstants.CHROME_KEY,IpathConstants.CHROME_PATH);
	driver = new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("firefox")) {
	System.setProperty(IpathConstants.FIREFOX_KEY,IpathConstants.FIREFOX_PATH);
	driver = new FirefoxDriver();
	} else {
	System.out.println("browser is not supported");
	}
    driver.manage().window().maximize();
	wUtil.waitForPageLoad(driver);
	int rannum=jUtil.getRandomNumber();
	 
      //login to application
	driver.get(url);
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
	
	
	
	
	//driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']"))

}
}

	