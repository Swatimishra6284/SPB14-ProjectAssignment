package com.training.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RealEstate_PropertyPOM {
	private WebDriver driver; 
	
	public RealEstate_PropertyPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='edit.php?post_type=property']")
	private WebElement properties; 
	
	@FindBy(xpath="//a[@href='edit-tags.php?taxonomy=property_feature&post_type=property']")
	private WebElement features; 
	
	@FindBy(id="tag-name")
	private WebElement name;
	
	@FindBy(id="tag-slug")
	private WebElement slug;
	
	@FindBy(id="tag-description")
	private WebElement description;
	
	@FindBy(xpath="//input[@id='submit']")
	private WebElement addNewFeatureBtn;
	
	
	public void clickProperties() {
		this.properties.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void clickFeatures() {
		this.features.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void enterName(String nm) {
		this.name.clear();
		this.name.sendKeys(nm);
	}

	public void enterSlug(String sl) {
		this.slug.clear();
		this.slug.sendKeys(sl);
	}
	
	public void enterDescription(String ds) {
		this.description.clear();
		this.description.sendKeys(ds);
	}
	
	public void clickAddNewFeatureBtn() {
		this.addNewFeatureBtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
}

