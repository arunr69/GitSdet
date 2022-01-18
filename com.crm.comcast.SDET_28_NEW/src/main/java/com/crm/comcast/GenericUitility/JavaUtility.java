package com.crm.comcast.GenericUitility;


import java.util.Date;
import java.util.Random;

/**
 * Java Utility Class
 * @author Arun R
 *
 */
public class JavaUtility {
	public int getRandomNumber() {
		Random ran = new Random();
		int randomNumber = ran.nextInt(5000);
		return randomNumber;
		
		
	}
/**
 * @return
 */
	public String systemDataAndTime() {
		Date date = new Date();
		String dateAndTime = date.toString();
        return dateAndTime ;
		
	}
}
