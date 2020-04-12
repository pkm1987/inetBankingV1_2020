package com.interBanking.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddCustomerPage {
	
	WebDriver ldriver;
	
	public AddCustomerPage (WebDriver rdriver) {
		ldriver=rdriver;
		}
	
	public WebElement linkAddCustomer() {
		return ldriver.findElement(By.xpath("//a[@href='addcustomerpage.php']"));
	}	
	
	public WebElement txtCustomerName() {
		return ldriver.findElement(By.xpath("//input[@name='name' and @type='text']"));
	}	
	
	public WebElement radioGender() {
		return ldriver.findElement(By.xpath("//input[@name='rad1' and @type='radio' and @value='f']"));
	}	
	
	public WebElement txtDOB() {
		return ldriver.findElement(By.xpath("//input[@name='dob' and @type='date']"));
	}	
	
	public WebElement txtAddress() {
		return ldriver.findElement(By.xpath("//textarea[@name='addr']"));
	}	
	
	public WebElement txtCity() {
		return ldriver.findElement(By.xpath("//input[@name='city']"));
	}	
	
	public WebElement txtState() {
		return ldriver.findElement(By.xpath("//input[@name='state']"));
	}	
	
	public WebElement txtPinno() {
		return ldriver.findElement(By.xpath("//input[@name='pinno']"));
	}		

	public WebElement txtTelephoneno() {
		return ldriver.findElement(By.xpath("//input[@name='telephoneno']"));
	}	
	
	public WebElement txtEmailid() {
		return ldriver.findElement(By.xpath("//input[@name='emailid']"));
	}
			
	public WebElement txtPassword() {
		return ldriver.findElement(By.xpath("//input[@name='password']"));
	}

	public WebElement btnSubmit() {
		return ldriver.findElement(By.xpath("//input[@value='Submit']"));
	}	
		
	
}
