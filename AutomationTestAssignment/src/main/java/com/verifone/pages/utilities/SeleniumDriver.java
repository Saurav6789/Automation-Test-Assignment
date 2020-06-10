package com.verifone.pages.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDriver {
	private static SeleniumDriver seleniumDriver;

	// initialize webdriver
	private static WebDriver driver;

	// initialize timeouts
	public static WebDriverWait waitDriver;
	public final static int TIMEOUT = 15;
	public final static int PAGE_LOAD_TIMEOUT = 60;
	public static FileInputStream fis;

	public static Properties config = new Properties();
	public static String browser;

	private SeleniumDriver() {

		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			config.load(fis);
			

		} catch (IOException e) {
			e.printStackTrace();
		}

		if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {

			browser = System.getenv("browser");
		} else {

			browser = config.getProperty("browser");

		}

		config.setProperty("browser", browser);

		if (config.getProperty("browser").equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			

		} else if (config.getProperty("browser").equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			

		} else if (config.getProperty("browser").equals("ie")) {

			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			

		}

		driver.manage().window().maximize();
		waitDriver = new WebDriverWait(driver, TIMEOUT);
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	public static void openPage() {

		driver.get(config.getProperty("testsiteurl"));
		

	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setUpDriver() {
		if (seleniumDriver == null)
			seleniumDriver = new SeleniumDriver();

	}

	public static void tearDown() {
		if (driver != null) {

			driver.quit();

		}
		seleniumDriver = null;
		

	}

	public static String getCurrentURL() {

		return driver.getCurrentUrl();

	}

	public static void clkWebElement(WebElement ele) {

		Actions action = new Actions(driver);
		action.moveToElement(ele).click().build().perform();
	}


	public static void waitElementToClickable(WebElement ele) {
		waitDriver = new WebDriverWait(driver, 15);
		waitDriver.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(ele)));

	}

	public static void waitElementToVisible(WebElement ele) {
		waitDriver = new WebDriverWait(driver, 15);
		waitDriver.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(ele)));

	}

	public static void switchTab(){
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	}
	
	
}
