package purchaseOrderTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUitility.BaseClass;
import com.crm.comcast.GenericUitility.ExcelUtility;
import com.crm.comcast.GenericUitility.FileUtility;
import com.crm.comcast.GenericUitility.IpathConstants;
import com.crm.comcast.GenericUitility.JavaUtility;
import com.crm.comcast.GenericUitility.WebDriverUtility;
import com.crm.comcast.objectRepository.PurchaseOrderPage;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;
import com.crm.comcast.objectRepository.PurchaseOrderInformationPage;
import com.crm.comcast.objectRepository.CreatePurchaseOrderPage;
/**
 * Test Script for CreatePurchaseOrdreWithItemAndAddProduct
 * @author Arun
 *
 */
@Listeners(com.crm.comcast.GenericUitility.ListenerImpClass.class)
public class CreatePurchaseOrdreTest extends BaseClass{
	
	@Test
	 public void createPurchaseOrder() throws Throwable {
		
	JavaUtility jUtil = new JavaUtility();
	ExcelUtility eUtil = new ExcelUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	
	//Get the data from excel
	String Expectedpruchase = eUtil.getStringCellData("Sheet1", 5, 2);
	Expectedpruchase = Expectedpruchase+jUtil.getRandomNumber();
	    
	  //create purchase order 
	 WebDriver driver = null;
	 HomePage homepage = new HomePage(driver);
	 homepage.clickPurchaseOrderLink();
	 
	 CreatePurchaseOrderPage purchaseorderpage = new CreatePurchaseOrderPage(driver);
	 purchaseorderpage.clickPurOrderImg();
	 
     PurchaseOrderPage cpopage = new PurchaseOrderPage(driver);
     cpopage.createPurchaseOrder(Expectedpruchase);
	 
	 PurchaseOrderInformationPage purchaseorderinfopage = new PurchaseOrderInformationPage(driver);
	 String actualpurchaseName = purchaseorderinfopage.getpurchaseOrderInformationText();
	 
	 //Purchase Order verification
	 if (actualpurchaseName.contains(Expectedpruchase)) {
		System.out.println("PurchaseOrder is created");
	}else {
		System.out.println("PurchaseOrder is not created");
		 
	 }
	
	}
	
}
	
	
	
	
	

	





	
