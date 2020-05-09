package com.interBanking.testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.interBanking.pageObject.AddCustomerPage;
import com.interBanking.pageObject.LoginPage;
import com.interBanking.utilities.XLUtils;

public class TC_AddCustomerDDT  extends BaseClass {
	
	@Test(priority = 1, dataProvider="getData")      //getData is 2D array with all the values. i.e. array in DS format
	public void Login(String username, String password, String CustomerName, String Gender, String DOB, String Address, String City, String State, String PinNo, String Password) throws InterruptedException, IOException
	{
		driver.get(baseURL);
		logger.info("URL is Launched 777");
		Thread.sleep(3000);
		LoginPage lp= new LoginPage(driver);
		lp.txtUserName().sendKeys(username);
		logger.info("User Name Provided");
		lp.txtPassword().sendKeys(password);
		logger.info("Password Provided");
		lp.btnSubmit().click();
		Thread.sleep(3000);
		
	}
	
	@Test(priority = 2, dataProvider="getData")      //getData is 2D array with all the values. i.e. array in DS format
	public void addNewCustomer(String username, String password, String CustomerName, String Gender, String DOB, String Address, String City, String State, String PinNo, String Password) throws InterruptedException, IOException
	{
	
		//==Add Customer =====
		AddCustomerPage addCust= new AddCustomerPage(driver);
		addCust.linkAddCustomer().click();
		addCust.txtCustomerName().sendKeys(CustomerName);
		addCust.radioGender().click();
		addCust.txtDOB().click();
				
		addCust.txtDOB().sendKeys("10");
		addCust.txtDOB().sendKeys("15");
		addCust.txtDOB().sendKeys("2002");
		Thread.sleep(3000);
		addCust.txtAddress().sendKeys(Address);
		addCust.txtCity().sendKeys("Kolkata");
		addCust.txtState().sendKeys("West Bengal");
		addCust.txtPinno().sendKeys(PinNo);
		addCust.txtTelephoneno().sendKeys(randomNumber() + "64657");
		addCust.txtEmailid().sendKeys(randomString() + "@gmail.com");
		addCust.txtPassword().sendKeys(Password);
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
	

	
	@DataProvider
	public String[][] getData() throws IOException{
	// This method will read the data from excel and store in 2 dimentional array
	// and finally return a 2 dimensional array  to the actual test case
		String path="./src//test//java//com//interBanking//testData//AddCustomer.xlsx";
		//String path=System.getProperty("user.dir")+ "//src//test//java//com//interBanking//testData//LoginData.xlsx";
		int rownum=XLUtils.GetRowCount(path, "AddCust");
		int colcount=XLUtils.GetCellCount(path, "AddCust", 1);
		
		String logindata[][]=new String[rownum][colcount];
		for (int i=1;i<=rownum;i++) {
			for (int j=0; j<colcount;j++) {
				logindata[i-1][j]=XLUtils.GetCellData(path, "AddCust", i, j);
			}
		}
		
		return logindata;
		
	}

}
 
