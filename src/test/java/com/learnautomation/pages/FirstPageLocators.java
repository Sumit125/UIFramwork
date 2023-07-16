package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import io.qameta.allure.Step;
public class FirstPageLocators {	
	
     static WebDriver driver;

	private static By checkpoint23= By.id("checkBoxOption1");
	private static By checkpoint24=By.xpath("//input[@id='name']");
	public FirstPageLocators(WebDriver ldriver) {
		FirstPageLocators.driver = ldriver;
	}

	/*
	 * @FindBy(id="checkBoxOption1") static WebElement checkpoint23;
	 */
	public static  void clickOnNewProject() {
		driver.findElement(checkpoint23).click();
	
	}

	public static  void TC2() {
		System.out.println(driver.findElement(checkpoint23).isSelected());
	
	}
	public static  void TC3(String value) {
		driver.findElement(checkpoint24).sendKeys(value);
	
	} 
	
	@Step
	public static  void TC4(int value) {
		String value1=Integer.toString(value);
		driver.findElement(checkpoint24).sendKeys(value1);
	
	} 

}
