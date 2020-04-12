package com.interBanking.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.interBanking.utilities.ReadConfig;


public class BaseClass {
	
	ReadConfig readconfig= new ReadConfig();
	
	public String baseURL= readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
	//public void setup() {	
		
		if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//Drivers//geckodriver.exe");
			readconfig.getFirefoxDriverpath();
			driver =new FirefoxDriver();
		  }
		
		else if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromeDriverpath());
			driver =new ChromeDriver();
			
			}
		else if(br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", readconfig.getIEDriverpath());
			driver =new InternetExplorerDriver();
			}
		
		logger=Logger.getLogger("InterBankingProject");
		PropertyConfigurator.configure("log4j.properties");
			
	}

	@AfterClass
	public void teardown() {
		driver.close();
	}
	
	//================== SCREENSHOT CAPTURE =======================
	public void captureSreenshot(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target= new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken.");
		
	}
	
	public String randomString() {
		String rndString=RandomStringUtils.randomAlphabetic(5);
		return rndString;
	}
	
	public String randomNumber() {
		String rndNum=RandomStringUtils.randomNumeric(5);
		return rndNum;
	}
	
}
