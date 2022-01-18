package com.crm.comcast.GenericUitility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	public String getPropertyFileData(String key) throws Throwable {
	FileInputStream file= new FileInputStream("./src/test/resources/data.properties");
	 Properties property = new Properties();
	 property.load(file);
	 String value = property.getProperty(key);
	return value ;
	}

	}
	


