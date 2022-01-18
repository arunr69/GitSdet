package practice;

import org.testng.annotations.Test;

public class Customer1 {
	
	@Test(groups = {"smokeTest"})
	public void customerTest1() {
		System.out.println("this is smoke");
	}
	
		
		@Test(groups = {"regressionTest"})
		public void customerTest2() {
			System.out.println("this is regressionTest");
		}
		
		@Test(groups = {"smokeTest"})
		public void customerTest3() {
			System.out.println("this is smoke");
	
		}
		
		@Test(groups = {"regressionTest"})
		public void customerTest4() {
			System.out.println("this is regressionTest");
		}
}
