package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.comcast.GenericUitility.ExcelUtility;
import com.crm.comcast.GenericUitility.FileUtility;
import com.crm.comcast.GenericUitility.IpathConstants;
import com.crm.comcast.GenericUitility.JavaUtility;
import com.crm.comcast.GenericUitility.WebDriverUtility;

public class Referance {
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
	driver.get(url);
	 
      //login to application
	
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.xpath("//a[text()=\"More\"]")).click();
	    Thread.sleep(2000);
	    
/*	driver.findElement(By.xpath("//a[@href=\"index.php?module=Vendors&action=index\"]")).click();
	driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
	driver.findElement(By.xpath("//input[@name=\"vendorname\"]")).sendKeys("karthi pg_"+rannum);
	driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
*/	driver.findElement(By.xpath("//a[@href=\"index.php?module=Products&action=index\"]")).click();
	driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
	driver.findElement(By.xpath("//input[@name=\"productname\"]")).sendKeys("Key"+rannum);
	driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
	driver.findElement(By.xpath("//a[text()=\"More\"]")).click();
	driver.findElement(By.name("Purchase Order")).click();    
	    
	driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
	driver.findElement(By.xpath("//input[@onfocus=\"this.className='detailedViewTextBoxOn'\"]")).sendKeys("hello"+rannum);
	driver.findElement(By.xpath("//img[@src=\"themes/softed/images/select.gif\"]")).click();
	    String partial = driver.getWindowHandle();   
	    wUtil.switchWindow(driver, partial);
	    String data = driver.findElement(By.xpath("//div[@style=\"overflow:auto;height:348px;\"]")).getText();
	    System.out.println(data);
	    
	driver.findElement(By.xpath("//a[@href=\"javascript:window.close();\"]")).click();
	//driver.findElement(By.xpath("//textarea[@name=\"bill_street\"]")).sendKeys("Bangalore");
	//driver.findElement(By.xpath("//textarea[@name=\"ship_street\"]")).sendKeys("Mysore");
	driver.findElement(By.xpath("//img[@id=\"searchIcon1\"]")).click();
	driver.findElement(By.xpath("//img[@id=\"searchIcon1\"]")).click();  
	driver.findElement(By.xpath("//textarea[@name='bill_street']")).sendKeys("showroom");
	driver.findElement(By.xpath("//textarea[@name='ship_street']")).sendKeys("office");
	driver.findElement(By.xpath("//img[@id='searchIcon1']")).click();
	driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
	driver.findElement(By.xpath("//input[@id='qty1']")).sendKeys("3");
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	driver.close();

	}


}
