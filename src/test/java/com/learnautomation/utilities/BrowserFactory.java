package com.learnautomation.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	
	public static WebDriver startApplication(WebDriver driver,String browserName,String appUrl,Boolean mode)
	{
		if(browserName.equals("Chrome"))
		{
			String driverpath= System.getProperty("user.dir")+"/Drivers/chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverpath);
		
			// Create ChromeOptions and enable headless mode
	        ChromeOptions options = new ChromeOptions();
	        
	        // Passing Mode value
	        options.setHeadless(mode);
		      driver= new ChromeDriver(options);
		} 
		else if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\Chrome\\chromedriver_win32\\chromedriver.exe");
		      driver= new FirefoxDriver();
		} 
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\SeleniumDriver\\edgedriver\\msedgedriver.exe");
			 EdgeOptions options = new EdgeOptions();
			// Passing Mode value
		        options.setHeadless(mode);
			driver = new EdgeDriver(options);
		} 
		else
		{
			System.out.println("We do not support this browser");
		}
		
		driver.manage().window().maximize();
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return driver;
	}
	
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
		System.out.print("Browser Closed");
	}

}
