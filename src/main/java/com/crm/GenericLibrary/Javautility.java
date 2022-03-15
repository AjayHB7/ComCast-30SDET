package com.crm.GenericLibrary;

import java.util.Date;
import java.util.Random;

/**
 * this class consists of generic methods 
 * @author AJAY
 *
 */
public class Javautility 
{
	/**
	 * this method will generate random number and return it to the user
	 * @return
	 */
	public int getRandomNumber()
	{
		Random ran = new Random();
		int random = ran.nextInt(500);
		return random;
	}
	
	/**
	 * this method will generate system date and return it to the user
	 * @return
	 */
	public String getSystemDate()
	{
		Date d = new Date();
		String date = d.toString();
		return date;	
	}
	/**
	 * this method will generate date with time in format and return it to the user
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		Date d = new Date();
		String d1 = d.toString();
		String[] date = d1.split(" ");
		String month = date[1];
		String day = date[2];
		String time =date[3].replace(":", "-");
		String year = date[5];
		
		String DateFormat = day+" "+month+" "+year+" "+time;
		return DateFormat;
		
	}

}
