package com.training.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RealEstate_AddPostPOM {
	private WebDriver driver; 
	
	public RealEstate_AddPostPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Posts")
	private WebElement newPost; 
	
	@FindBy(xpath="//a[@href='edit-tags.php?taxonomy=category']")
	private WebElement category;
	
	@FindBy(id="tag-name")
	private WebElement name;
	
	@FindBy(id="tag-slug")
	private WebElement slug;
	
	@FindBy(id="tag-description")
	private WebElement description;
	
	@FindBy(id="submit")
	private WebElement addCategoryBtn;
	
//	Search Added Category
	@FindBy(id="tag-search-input")
	private WebElement search;
	
	@FindBy(id="search-submit")
	private WebElement searchButton;
	
	@FindBy(xpath="//*[@class='description column-description']//*[text()='Mokshit']")
	private WebElement validateSerach;
	
	public void addNewPost() {
		this.newPost.click();
	}
	
	public void goToCategory() {
		this.category.click();
	}
	
	public void sendName(String categoryName) {
		this.name.clear();
		this.name.sendKeys(categoryName);
	}
	
	public void sendSlug(String slugName) {
		this.slug.clear();
		this.slug.sendKeys(slugName);
	}
	
	public void sendDescription(String Description) {
		this.description.clear();
		this.description.sendKeys(Description);
	}
	
	public void addNewCategoryBtn() {
		this.addCategoryBtn.click();
			
	}
	
	public void sendSerchOption(String searchSend) {
		this.search.clear();
		this.search.sendKeys(searchSend);
			
	}
	
	public void clickSearchBtn() {
		this.searchButton.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void validateSerach() {
		String expected = this.search.getText();
		String actual = this.validateSerach.getText();
		
		if(expected == actual) {
			System.out.println("Passed");
		}
	}
	
		
}
