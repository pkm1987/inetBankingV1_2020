package com.interBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.interBanking.pageObject.LoginPage;
import com.interBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{

	@Test(dataProvider="getData")      //getData is 2D array with all the values. i.e. array in DS format
	public void loginDDT(String username, String password) throws InterruptedException {
		driver.get(baseURL);
		logger.info("URL Launched");
		LoginPage lp= new LoginPage(driver);
		lp.txtUserName().sendKeys(username);
		logger.info("User Name Provided");
		lp.txtPassword().sendKeys(password);
		logger.info("Password Provided");
		lp.btnSubmit().click();
		Thread.sleep(3000);
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed");
			}
			else {
				Assert.assertTrue(true);
				logger.info("Login Pass");
				lp.btnLogout().click();
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();
			}
	}
	
	public boolean isAlertPresent() { //user defined method to check that whether alert is present or not
		try {
			driver.switchTo().alert();
			return true;
			}
		catch (NoAlertPresentException e) {
			return false;
			}		
	}
	
	@DataProvider
	public String[][] getData() throws IOException{
	// This method will read the data from excel and store in 2 dimentional array
	// and finally return a 2 dimensional array  to the actual test case
		String path="./src//test//java//com//interBanking//testData//LoginData.xlsx";
		//String path=System.getProperty("user.dir")+ "//src//test//java//com//interBanking//testData//LoginData.xlsx";
		int rownum=XLUtils.GetRowCount(path, "Sheet1");
		int colcount=XLUtils.GetCellCount(path, "Sheet1", 1);
		String logindata[][]=new String[rownum][colcount];
		for (int i=1;i<=rownum;i++) {
			for (int j=0; j<colcount;j++) {
				logindata[i-1][j]=XLUtils.GetCellData(path, "Sheet1", i, j);
			}
		}
		  
		return logindata;
		
	}
}
