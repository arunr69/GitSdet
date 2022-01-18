package com.crm.comcast.GenericUitility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;

/**
 * This is the base class which contain all the configuration annotation
 * @author Arun
 *
 */

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	public FileUtility fUtil = new FileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public JavaUtility jUtil = new JavaUtility();
	public ExcelUtility eUtil = new ExcelUtility();
	  
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configBs() {
		// connection to db
		System.out.println("===conect to db==");
	}
	@Parameters("browser")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void configBc(String browser ) throws Throwable {
		// launching the browser
	//	String browser = fUtil.getPropertyFileData("browser");
		String url = fUtil.getPropertyFileData("url");
		
		if(browser.equals("chrome")) {
			System.setProperty(IpathConstants.CHROME_KEY,IpathConstants.CHROME_PATH);
			driver = new ChromeDriver();
			}
			else if(browser.equals("firefox")) {
			System.setProperty(IpathConstants.FIREFOX_KEY,IpathConstants.FIREFOX_PATH);
			driver = new FirefoxDriver();
			} else {
			System.out.println("browser is not supported");
			}
		    sdriver=driver;
		    driver.manage().window().maximize();
			wUtil.waitForPageLoad(driver);
			driver.get(url);
	}
	
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void configBm() throws Throwable{
		
		// fetch the data from propertity file
		 String username = fUtil.getPropertyFileData("username");
		 String password = fUtil.getPropertyFileData("password");
		 
		 //login to application
		 LoginPage login = new LoginPage(driver);
		 login.loginToApplication(username,password);
	}
	
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void configAm() {
		HomePage homepage = new HomePage(driver);
		homepage.logout();
	}
	
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void configAc() {
		//closing or quitting the browser
		driver.quit();
	}
	
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void configAs() {
		//closing the database connection
		System.out.println("====connection is closed");
	}
}
