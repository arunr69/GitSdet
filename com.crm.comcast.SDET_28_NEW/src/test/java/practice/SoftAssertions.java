package practice;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertions {
	@Test
	public void sample() {
		String expectedName="arun";
		String actualName="arun";
		
		Reporter.log("this is the soft asster class",true);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(expectedName,actualName);
		sa.assertAll();
		
		
	}

}
