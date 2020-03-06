package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RealEstate_NewLaunchPOM {
	private WebDriver driver; 
	
	public RealEstate_NewLaunchPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='fa fa-caret-down wpmm-megamenu-indicator']")
	private WebElement newLaunch; 
	
	@FindBy(xpath="//a[@href='http://realty-real-estatem1.upskills.in/maecenas-viverra/']")
	private WebElement imagelink;
	
	public void ClickNewLaunch() {
		this.newLaunch.click(); 
	}
	
	public void ClickImageLink() {
		this.imagelink.click(); 
	}
	
	
}
