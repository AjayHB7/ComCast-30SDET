package com.crm.PRACTICE;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeTestNG 
{
	@Test(priority = -1, invocationCount = 4)
	public void createOrg()
	{
		System.out.println("org created");
		Assert.fail();
	}
	
	@Test(priority = 0,dependsOnMethods="createOrg")
	public void modifyOrg()
	{
		System.out.println("org modified");
	}
	
	@Test(priority = 1)
	public void deleteOrg()
	{
		System.out.println("org deleted");
	}

}
