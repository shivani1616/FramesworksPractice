package com.selenium.automation.scripts;

import org.testng.annotations.Test;

public class Grouping_mechanism {
	
	@Test(groups="rt")
	public void m3(){
		System.out.println("m3()  rt");
	}
	
	@Test(groups="rt")
	public void m2(){
		System.out.println("m2()  rt");
	}
	
	@Test(groups="rt")
	public void m1(){
		System.out.println("m1()  rt");
	}	

}
