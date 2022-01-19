package practise;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateContact {
	public static void main(String[] args) {
		
		//Launch Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	/*	Random ran = new Random();
		int randomvalu = ran.nextInt(100);
		String rand = Integer.toString(randomvalu);
	*/
		
		
		 
		//Enter Url
	     driver.get("http://localhost:8888");
	     
		 
		// Login to App
	 	driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
	    driver.findElement(By.id("submitButton")).click();

}
}
