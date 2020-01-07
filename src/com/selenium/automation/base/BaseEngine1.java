package com.selenium.automation.base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.selenium.automation.supporters.ExcelReader1;
import com.selenium.automation.supporters.PropertyUtilities1;
import com.selenium.automation.utilities.POJOSupporters1;
import com.selenium.automation.utilities.ScreenshotUtility1;

public class BaseEngine1 {
	private static WebDriver driver;
	private static String curDir; 
	private static String tcName;
	private static ExcelReader1 excReader1;
	private static PropertyUtilities1 proConfig1;
	private static PropertyUtilities1 proObjeReposit;
	
	@Parameters("browser")
	@BeforeSuite
	public static void openBrowser(@Optional("chrome") String browser) throws IOException {
		
		if(browser.equalsIgnoreCase("chrome")) {
			excReader1 = POJOSupporters1.getExcRea1();
			proConfig1 = POJOSupporters1.getProCon1();
			proObjeReposit = POJOSupporters1.getProOr1();
			curDir = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", curDir+"\\Drivers\\chromedriver79.exe");
			driver = new ChromeDriver();	
			driverInit();			
		}else if(browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", curDir+"\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			driverInit();
		}else if(browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",curDir+"\\Driver\\InternetExplorerdriver.exe");
			driver = new InternetExplorerDriver();
			driverInit();
		}
	}
	
	private static void driverInit() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);		
	}
	
	@BeforeMethod
	public static String beforeMethod(Method method) {
		tcName = method.getName();
		return tcName;
	}
	
	@AfterMethod
	public static void afterMethod(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.SUCCESS) {
			System.out.println("The result is " +tcName);			
		}else if(result.getStatus() == ITestResult.FAILURE) {
			System.out.println("FAILURE - The result is " + result.getThrowable());			
				ScreenshotUtility1.screenShot();			
		}else if(result.getStatus() == ITestResult.SKIP) {
			System.out.println("SKIP - The result is " + result.getThrowable());
				ScreenshotUtility1.screenShot();
			
		}		
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static String getCurDir() {
		return curDir;
	}

	public static String getTcName() {
		return tcName;
	}

	@AfterSuite
	public static void closeBrowser() throws InterruptedException {
		java.util.Optional<WebDriver> op = java.util.Optional.ofNullable(driver);
		Thread.sleep(2000);
		if(op.isPresent()) {
			driver.close();
		}else {
			System.out.println("The browser is pointing to null");
		}
	}
	
	

	
	
}
