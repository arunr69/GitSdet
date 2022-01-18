package purchaseOrderTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUitility.ExcelUtility;
import com.crm.comcast.GenericUitility.FileUtility;
import com.crm.comcast.GenericUitility.IpathConstants;
import com.crm.comcast.GenericUitility.JavaUtility;
import com.crm.comcast.GenericUitility.WebDriverUtility;
import com.crm.comcast.objectRepository.AddProductPage;
import com.crm.comcast.objectRepository.AddServicePage;
import com.crm.comcast.objectRepository.PurchaseOrderPage;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.PurchaseOrderInformationPage;
import com.crm.comcast.objectRepository.CreatePurchaseOrderPage;

@Listeners(com.crm.comcast.GenericUitility.ListenerImpClass.class)
public class PurchaseOrderWithItemAndAddServiceTest {
   @Test(groups = {"regressionTest"})
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
	 
	  AddServicePage addservicepage = new AddServicePage(driver);
	  addservicepage.AddServicePage(AddService);
	 
     PurchaseOrderPage CreatePurchaseOrderPage = new PurchaseOrderPage(driver);
	 CreatePurchaseOrderPage.CreatePurchaseOrderPageC(pruchase);
	 
	 PurchaseOrderInformationPage purchaseorderinfopage = new PurchaseOrderInformationPage(driver);
	 String actualpurchaseName = purchaseorderinfopage.getpurchaseOrderInformationText();
	 
	 //Purchase Order verification
	 if (actualpurchaseName.contains(pruchase)) {
		System.out.println("PurchaseOrder is created");
	}else {
		System.out.println("PurchaseOrder is not created");
		 
	 }
	
	}
	
}