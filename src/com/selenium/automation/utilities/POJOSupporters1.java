package com.selenium.automation.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.selenium.automation.supporters.ExcelReader1;
import com.selenium.automation.supporters.PropertyUtilities1;

public class POJOSupporters1 {
	private static PropertyUtilities1 proOR1;
	private static PropertyUtilities1 proCon1;
	private static ExcelReader1 excRea1;
	
	public static PropertyUtilities1 getProOr1() throws IOException {
		proOR1 = new PropertyUtilities1(FilePath1.objRepoPath);		
		return proOR1;
	}
	
	public static PropertyUtilities1 getProCon1() throws IOException {
		proCon1 = new PropertyUtilities1(FilePath1.configPath);
		return proCon1;
	}
	
	public static ExcelReader1 getExcRea1() throws FileNotFoundException {
		excRea1 = new ExcelReader1(FilePath1.excelPath);
		return excRea1;
	}
	
	
	
}
