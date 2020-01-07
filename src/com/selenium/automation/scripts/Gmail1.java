package com.selenium.automation.scripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.selenium.automation.base.BaseEngine1;
import com.selenium.automation.utilities.POJOSupporters1;

public class Gmail1 extends BaseEngine1 {
	
	@Test
	public  static void gmailLogin() throws IOException {
		String URL = POJOSupporters1.getProCon1().getPropertyValue("url1");
		getDriver().get(URL);
		String un = POJOSupporters1.getProOr1().getPropertyValue("username_id");
		String unNxt = POJOSupporters1.getProOr1().getPropertyValue("username_xpath_next");
		String passWrd = POJOSupporters1.getProOr1().getPropertyValue("password_xpath_type");
		String passNxt = POJOSupporters1.getProOr1().getPropertyValue("password_xpath_next");
		String undata = POJOSupporters1.getExcRea1().getSingleCellData("second", 1, 0);
		String pasData = POJOSupporters1.getExcRea1().getSingleCellData("second", 1, 1);
		getDriver().findElement(By.id(un)).sendKeys(undata);
		getDriver().findElement(By.xpath(unNxt)).click();
		getDriver().findElement(By.xpath(passWrd)).sendKeys(pasData);
		getDriver().findElement(By.xpath(passNxt)).click();
		
		/*getDriver().get("https://www.gmail.com");
		getDriver().findElement(By.id("identifierId")).sendKeys("8143605389");
		getDriver().findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
		getDriver().findElement(By.name("password")).sendKeys("hello123");
		getDriver().findElement(By.xpath("//span[text()='Next']")).click();*/
		
	}
	
	
}
