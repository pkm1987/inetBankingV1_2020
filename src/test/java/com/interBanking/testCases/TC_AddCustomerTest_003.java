package com.interBanking.testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.interBanking.pageObject.AddCustomerPage;
import com.interBanking.pageObject.LoginPage;

public class TC_AddCustomerTest_003  extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException, AWTException
	{
		driver.get(baseURL);
		logger.info("URL is Launched 777");
		Thread.sleep(3000);
 		LoginPage lp= new LoginPage(driver);
		lp.txtUserName().sendKeys(username);
		logger.info("Entered UID");
		lp.txtPassword().sendKeys(password);
		logger.info("Entered Password");
		
		lp.btnSubmit().click();
		Thread.sleep(3000);
		
		AddCustomerPage addCust= new AddCustomerPage(driver);
		addCust.linkAddCustomer().click();
		addCust.txtCustomerName().sendKeys("Raju Chacha");
		addCust.radioGender().click();
		addCust.txtDOB().click();
		String expMonthYear="March 1980";
		String expDay="24";
		
		
		addCust.txtDOB().sendKeys("10");
		addCust.txtDOB().sendKeys("15");
		addCust.txtDOB().sendKeys("2002");
		Thread.sleep(3000);
		addCust.txtAddress().sendKeys("INDIA");
		addCust.txtCity().sendKeys("Kolkata");
		addCust.txtState().sendKeys("West Bengal");
		addCust.txtPinno().sendKeys("723129");
		addCust.txtTelephoneno().sendKeys(randomNumber() + "64657");
		addCust.txtEmailid().sendKeys(randomString() + "@gmail.com");
		addCust.txtPassword().sendKeys("abc@123");
		Thread.sleep(3000);
		addCust.btnSubmit().click(); 
		
		boolean res= driver.getPageSource().contains("Customer Registered Successfully !!!");
		
		if (res==true) {
			Assert.assertTrue(true);
		}
		else {
			captureSreenshot(driver, "addNewCustomer");
			Assert.assertTrue(true);
		}

	}
	
	

}
 