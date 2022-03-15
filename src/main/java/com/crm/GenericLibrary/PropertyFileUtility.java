package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * This class consist of property file methods
 * @author AJAY
 *
 */
public class PropertyFileUtility
{
	/**
	 * This method read the data of property file, it will return value as per key specified by the user
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(iPathConstants.PropertyFile);
		Properties pLib = new Properties();
		pLib.load(fis);
		String value = pLib.getProperty(key);
		return value;
		
		
	}
}
