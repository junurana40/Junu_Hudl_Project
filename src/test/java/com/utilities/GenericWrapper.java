package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericWrapper extends Baseclass {
	/********* browser launch ****************/
	public void launchChromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void launchFirefoxBrowser() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	public void launchEdgeBrowser() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
	}
	/***** Validate the web element is enabled or not? *****/
	public void ValidateWebelementIsEnabledOrNot(By locator) {
		WebElement ele = driver.findElement(locator);
		if (ele.isEnabled()) {
			System.out.println("The webelement is Enabled state***");
		} else {
			System.out.println("The webelement is NOT in Enabled state***");
		}
	}
	/** sendkeys by any locators for Editbox/Textbox *********/
	public void sendKeyByAnyLocator(By locator, String testdata) {
		WebElement ele = driver.findElement(locator);
		if (ele.isDisplayed()) {
			if (ele.isEnabled()) {
				ele.clear();
				ele.sendKeys(testdata);
			} else {
				System.out.println("element is disable state, please check the locator***");
			}
		} else {
			System.out.println("element is not displayed, please check the locator***");
		}
	}
	
	/************ click on any webelement *************/
	public void clickByAnylocator(By locator) {
		WebElement ele = driver.findElement(locator);
		if (ele.isDisplayed() && ele.isEnabled()) {
			ele.click();
		} else {
			System.out.println("The given locator is not displayed on DOM or not in enabled state****");
		}
	}
	/******** Implicit wait *****************/
	public void implicitWait(int TimeInMillySeconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeInMillySeconds));
	}
	/*************to get data from property file**************/
	public String getData(String key) {
		String keyvlaue = null;
		try {
			keyvlaue = prop.getProperty(key);
		} catch (Exception e) {
			System.out.println("Error description: " + e.getStackTrace());
		}
		return keyvlaue;
	}
	// to get the test data from Property file
		public void loadTestData(String path) {
			file = new File(path);
			fi = null;
			try {
				fi = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				prop.load(fi);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		/******** get text info *********/

		public void GetText(By Locators) {
			WebElement el = driver.findElement(Locators);
			String text = el.getText();
			System.out.println(text);

		}
		/*** get Text from element by locator in the page ************/
		public String getTextByLocator(By locator) {
			return driver.findElement(locator).getText();
		}
		



}
