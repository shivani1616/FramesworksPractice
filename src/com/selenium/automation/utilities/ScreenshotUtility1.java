package com.selenium.automation.utilities;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.selenium.automation.base.BaseEngine1;


public interface ScreenshotUtility1{
	public static String screenShot() throws IOException {
		String imagePath = "D:\\Automation\\FramesworksPractice\\Screenshot\\gmailTest.jpeg";
		TakesScreenshot takeShot = (TakesScreenshot) BaseEngine1.getDriver();
		File fileImage = takeShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fileImage, new File(imagePath) );
		return imagePath;		
		}
	
	
}
//Basic approach of taking Screenshot
/*import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class ScreenshotUtility{
	
	public static void screenShot() throws IOException, InterruptedException {

		
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\FramesworksPractice\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // or RemoteWebDriver also we can use
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	
		Thread.sleep(5000);
		driver.get("https://www.gmail.com");
		driver.findElement(By.id("identifierId")).sendKeys("hello123");;
		String imagePath = "D:\\Automation\\FramesworksPractice\\Screenshot\\gmailTest.jpeg";
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;// when used 
		File fileImage = takesScreenshot.getScreenshotAs(OutputType.FILE);
		//if RemoteWebDriver is used then no need to have 49 and 50 line 
		//take File fileImage = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fileImage, new File(imagePath) );
		
		driver.quit();
		
	}
	public static void main(String[] args) throws IOException, InterruptedException {
		screenShot();
	
		
	}
}
*/
	
