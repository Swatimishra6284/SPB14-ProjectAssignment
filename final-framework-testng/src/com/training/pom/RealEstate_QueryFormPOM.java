package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RealEstate_QueryFormPOM {
	private WebDriver driver; 
	
	public RealEstate_QueryFormPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="your-name")
	private WebElement yourName; 
	
	@FindBy(name="your-email")
	private WebElement email;
	
	@FindBy(name="your-subject")
	private WebElement subject; 

	@FindBy(name="your-message")
	private WebElement message;
	
	@FindBy(xpath="//input[@value='Send']")
	private WebElement sendBtn; 
	
	public void sendYourName(String yourName) {
		this.yourName.clear();
		this.yourName.sendKeys(yourName);
		
	}
	
	public void sendEmail(String email) {
		this.email.clear(); 
		this.email.sendKeys(email);	

	}
	
	public void SendSubject(String subject) {
		this.subject.clear(); 
		this.subject.sendKeys(subject); 
	}
	
	public void SendMessage(String message) {
		this.message.clear(); 
		this.message.sendKeys(message); 
	}
	
	public void clickSendBtn() {
		this.sendBtn.click(); 
	}
}
