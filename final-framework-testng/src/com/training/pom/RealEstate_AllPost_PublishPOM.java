package com.training.pom;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RealEstate_AllPost_PublishPOM {
	private WebDriver driver; 
	private WebDriverWait wait; 
	
	public RealEstate_AllPost_PublishPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
//	All Post
	@FindBy(xpath="//div[@class ='wp-menu-name' and contains(text(),'Posts')]")
	private WebElement posts;
	
	@FindBy(xpath="//a[@href='edit.php']")
	private WebElement allPost;
	
	@FindBy(className="page-title-action")
	private WebElement addNewPostBtn;
	
	@FindBy(xpath="//input[@name='post_title']")
	private WebElement addNewPostTitle;
	
	@FindBy(id="content")
	private WebElement content;
	
	@FindBy(xpath="//a[@href='#category-all']")
	private WebElement allCategoryLink;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div[2]/div[1]/div[3]/form/div/div/div[2]/div/div[2]/div/div/div[2]/ul/li[1]/label/input")
	private WebElement checkbox;
	
	@FindBy(xpath="//input[@name='publish']")
	private WebElement publish;
	
	@FindBy(xpath="//a[text()='View post']")
	private WebElement viewPost;
	
//	@FindBy(xpath="//a[@href='http://realty-real-estatem1.upskills.in/ibm-post/']")
//	private WebElement verifyPost;

	public void ClickPosts() {
		this.posts.click();
	}
	
	public void ClickToAllPost(){
		this.allPost.click();
		
	}
	
	public void ClickAddNewPostBtn() {
		this.addNewPostBtn.click();
	}
	
	public void EnterAddNewPostTitle(String title)
	{
		this.addNewPostTitle.sendKeys(title);
	}
	
	public void EnterContent(String cnt) {
		this.content.clear();
		this.content.sendKeys(cnt);
	}
	
	public void SelectAllCategoryLink() {
		this.allCategoryLink.click();
		
	}
	
	public void SelectCheckBox() throws InterruptedException {
		this.checkbox.click();
		Thread.sleep(3000);
	}
	
	
	public void ClickPublish() throws InterruptedException {
		this.publish.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					
	}
	
	public void ClickViewPost() throws InterruptedException {
		this.viewPost.click();

	}
	
//	public void VerifyPost(String verify) {
//		
//		String actual = this.verifyPost.getText();
//		this.verifyPost.sendKeys(verify);
//		String expected = "IBM Post";
//		actual.equalsIgnoreCase(expected);
//		
//	}
	
}
