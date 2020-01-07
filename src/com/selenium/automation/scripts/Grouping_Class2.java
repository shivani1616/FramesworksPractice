package com.selenium.automation.scripts;

import org.testng.annotations.Test;

public class Grouping_Class2 {
	
	@Test(groups= {"st","rt"})
	public void m4(){
		System.out.println("m4()  rt");
	}
	
	@Test(groups="rt")
	public void m5(){
		System.out.println("m5()  rt");
	}
	
	@Test(groups="st")
	public void m6(){
		System.out.println("m6() ");
	}

}
