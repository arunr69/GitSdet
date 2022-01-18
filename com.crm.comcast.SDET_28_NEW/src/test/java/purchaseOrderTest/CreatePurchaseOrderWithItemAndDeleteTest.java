package purchaseOrderTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUitility.ExcelUtility;
import com.crm.comcast.GenericUitility.JavaUtility;
import com.crm.comcast.GenericUitility.WebDriverUtility;
import com.crm.comcast.objectRepository.PurchaseOrderPage;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.PurchaseOrderInformationPage;
import com.crm.comcast.objectRepository.CreatePurchaseOrderPage;

/**
 * Test Script for CreatePurchaseOrderWithItemAndDeleteTest
 * @author Arun
 *
 */
@Listeners(com.crm.comcast.GenericUitility.ListenerImpClass.class)
public class CreatePurchaseOrderWithItemAndDeleteTest {
	
	@Test
	 public void createPurchaseOrder() throws Throwable {
		
		
	JavaUtility jUtil = new JavaUtility();
	ExcelUtility eUtil = new ExcelUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	
	//Get the data from excel
	String pruchase = eUtil.getStringCellData("Sheet1", 5, 1);
	pruchase = pruchase+jUtil.getRandomNumber();
	    
	 //create purchase order 
	 WebDriver driver = null;
	 HomePage homepage = new HomePage(driver);
	 homepage.clickPurchaseOrderLink();
	 
	 CreatePurchaseOrderPage purchaseorderpage = new CreatePurchaseOrderPage(driver);
	 purchaseorderpage.clickPurOrderImg();
	 
    PurchaseOrderPage createpurchaseorderpage = new PurchaseOrderPage(driver);
	 createpurchaseorderpage.CreatePurchaseOrderPageC(Expectedpurchase);
	 
	 PurchaseOrderInformationPage purchaseorderinfopage = new PurchaseOrderInformationPage(driver);
	 String actualpurchaseName = purchaseorderinfopage.getpurchaseOrderInformationText();
	 	
	}

}