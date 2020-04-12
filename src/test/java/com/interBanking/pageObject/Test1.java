package com.interBanking.pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Test1 {

	
//	public static void main(String []args) {
	@Test
	public void aTest() {
		// TODO Auto-generated method stub
		System.out.println("-------------1");
		//setting the driver executable
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\JAR\\geckodriver.exe");
		WebDriver driver =new FirefoxDriver();
		System.out.println("------------21");


		//Applied wait time
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("-------------3");
		//maximize window
		driver.manage().window().maximize();
		System.out.println("-------------4");

		//open browser with desried URL
		driver.get("https://www.google.com");
		System.out.println("-------------5");

		//closing the browser
		driver.close();
		System.out.println("6");
	}

}
