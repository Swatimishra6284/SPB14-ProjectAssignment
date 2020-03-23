package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RealEstate_AdminLoginPOM {
	private WebDriver driver; 
	
	public RealEstate_AdminLoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='http://realty-real-estatem1.upskills.in/my-profile/']")
	private WebElement login;
	
	@FindBy(id="user_login")
	private WebElement yourName; 
	
	@FindBy(id="user_pass")
	private WebElement email;
	
	@FindBy(xpath="//input[@name='login']")
	private WebElement signInBtn; 
	
	private WebElement pageTitle;
	
		
	public void clickLoginLink() {
		this.login.click();
	}
	
	public void sendUserName(String userName) {
		this.yourName.clear();
		this.yourName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.email.clear(); 
		this.email.sendKeys(password); 
	}
	
	public void clickSignIn() {
		this.signInBtn.click(); 
	}
	
	public void getPageTitle() {
		String actual = driver.getTitle();
		if (actual == "Dashboard ‹ Real Estate — WordPress" ) {
			System.out.println("Admin Login :"+ actual);
		}
	}
	
	
}

		
	
	
