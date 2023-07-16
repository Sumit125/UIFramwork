package com.learnautomation.testcases;

import org.testng.annotations.Test;

import com.learnautomation.pages.FirstPageLocators;
import com.learnautomation.utilities.DataInput;

public class SecondPageTestCases extends BaseTest {
	
	/*
	 * @BeforeTest public void testStart() { FirstPageLocators ft=new
	 * FirstPageLocators(ldriver); }
	 */

	@Test(testName="TestCase 1")
	public void TestCase1()
	{
		 ft=new FirstPageLocators(ldriver);
		FirstPageLocators.clickOnNewProject();
		
		
	}
	
	@Test(testName="TestCase 2")
	public void TestCase2()
	{
		 ft=new FirstPageLocators(ldriver);
		FirstPageLocators.TC2();
	}
	
	@Test(description="Take input from excelutility by passing string value",testName="TestCase 3")
	public void TestCase3() throws InterruptedException
	{
		
		 String value12=eu.datavalueInString("Sumit", 0, 0);
		 ft=new FirstPageLocators(ldriver);
	     FirstPageLocators.TC3(value12); 
	     Thread.sleep(2000);	 
	}
	
	@Test(description="Take input from excelutility by passing integer value",testName="TestCase 4")
	public void TestCase4() throws InterruptedException
	{
		
		 int value12=eu.datavalueInInt("Sumit", 1, 1);
		 System.out.println(value12);
		 ft=new FirstPageLocators(ldriver);
	     FirstPageLocators.TC4(value12);
	     Thread.sleep(2000);	 
	}
	
	@Test(description="Take input from DataInput Class",dataProvider = "testdata",dataProviderClass = DataInput.class)
	public void TestCase5(String value12) throws InterruptedException
	{
		 ft=new FirstPageLocators(ldriver);
	     FirstPageLocators.TC3(value12);
	     Thread.sleep(2000);	 
	}

}
