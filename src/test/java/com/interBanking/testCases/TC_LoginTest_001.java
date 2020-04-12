package com.interBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.interBanking.pageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws InterruptedException, IOException {
		driver.get(baseURL);
		logger.info("URL is Launched 777");
		Thread.sleep(3000);
 		LoginPage lp= new LoginPage(driver);
		lp.txtUserName().sendKeys(username);
		logger.info("Entered UID");
		lp.txtPassword().sendKeys(password);
		logger.info("Entered Password");
		
		lp.btnSubmit().click();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login Test Pass");
		}else 
		{
			captureSreenshot(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login Test Fail");
					}
		
	}

}
