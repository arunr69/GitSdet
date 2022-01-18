package com.crm.comcast.GenericUitility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImpClass extends BaseClass implements ITestListener {
	public void onTestFailure(ITestResult result) {
		String testCaseName = result.getMethod().getMethodName();
		System.out.println(testCaseName);
		
		// take screenShotAs code
		EventFiringWebDriver event = new EventFiringWebDriver(BaseClass.sdriver);
		File source = event.getScreenshotAs(OutputType.FILE);
		File destination = new File("./errorshot/"+testCaseName+"png");
		try {
			FileUtility.copyfile(source,destination);
			//source.renameTo (destinstion)
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
