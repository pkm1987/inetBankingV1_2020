package com.interBanking.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver ldriver;
	public LoginPage(WebDriver rdriver){
		ldriver= rdriver;
	}
	

	public WebElement txtUserName() {
		return ldriver.findElement(By.name("uid"));
	}
	public WebElement txtPassword() {
		//txtPassword.sendKeys(pwd);
		return ldriver.findElement(By.name("password"));
	}
	public WebElement btnSubmit() {
		return ldriver.findElement(By.name("btnLogin"));
	}
	
	public WebElement btnLogout() {
		return ldriver.findElement(By.xpath("//a[@href='Logout.php']"));
	}
	
	/*@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;*/
}
