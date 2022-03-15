package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtilty;

public class DataProviderPractice 
{ 	
	@Test(dataProvider="getData")
	public void sampleDataProvider1(String Name, String model, int qty )
	{
		System.out.println(Name+"----"+model+"----"+qty);
	}

	@Test(dataProvider="newData", priority=1)
	public void sampleDataProvider2(String Name, int size)
	{
		System.out.println(Name+"-----"+size);
	}

	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj = new Object[4][3];
		obj[0][0]="redmi";
		obj[0][1]="note 10 pro";
		obj[0][2]=10;

		obj[1][0]="samsung";
		obj[1][1]="s20 pro";
		obj[1][2]=11;

		obj[2][0]="iphone";
		obj[2][1]="13 pro max";
		obj[2][2]=6;

		obj[3][0]="googlepixel";
		obj[3][1]="g11";
		obj[3][2]=4;

		return obj;

	}

	@DataProvider
	public Object[][] newData()
	{
		Object obj[][] = new Object[6][2];
		obj[0][0]="apple";
		obj[0][1]=5;

		obj[1][0]="orange";
		obj[1][1]=6;

		obj[2][0]="kiwi";
		obj[2][1]=4;

		obj[3][0]="pinapple";
		obj[3][1]=8;

		obj[4][0]="grapes";
		obj[4][1]=6;

		obj[5][0]="pomegranate";
		obj[5][1]=11;

		return obj;
	}


}
