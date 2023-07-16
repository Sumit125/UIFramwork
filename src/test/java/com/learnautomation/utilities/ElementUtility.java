package com.learnautomation.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ElementUtility {
	
	public static void capturescreenshot(WebDriver driver)
	{
		String despath =System.getProperty("user.dir") + "/Screenshots/" + System.currentTimeMillis()
				 + ".png";
		File srcFile = ((TakesScreenshot)
				 driver).getScreenshotAs(OutputType.FILE);
		try
		{
			FileHandler.copy(srcFile,new File(despath));
			System.out.println("Screenshot captured");
		}catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
}
