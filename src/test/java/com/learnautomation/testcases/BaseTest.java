package com.learnautomation.testcases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.learnautomation.pages.FirstPageLocators;
import com.learnautomation.utilities.BrowserFactory;
import com.learnautomation.utilities.ConfigDataProvider;
import com.learnautomation.utilities.ElementUtility;
import com.learnautomation.utilities.ExcelUtility;

public class BaseTest {
	
	
	WebDriver ldriver;
	public ExcelUtility eu;
	public FirstPageLocators ft;
	public ConfigDataProvider cdp;
	public ElementUtility eeu;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void testsetup()
	{
	
		eu=new ExcelUtility();
	}
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) throws IOException
	{
		   
		   cdp=new ConfigDataProvider();
		   
		   String headlessValue = cdp.getdatafromConfig("headless");
		   boolean isHeadless = Boolean.parseBoolean(headlessValue);
			
		// Below line is for taking the browser from the testng2.xml for parallel execution
		//Headless value comes from the config.properties file
		   ldriver=BrowserFactory.startApplication(ldriver,browser,cdp.getdatafromConfig("Url"),isHeadless);
		   
			System.out.println(ldriver.getTitle());	
	}
	@AfterClass
	public void teardown() {
		BrowserFactory.quitBrowser(ldriver);
	}
	
	@AfterMethod
	public void teardownMethod(ITestResult result)
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			eeu.capturescreenshot(ldriver);
		}
	}

}
