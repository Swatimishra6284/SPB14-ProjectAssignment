package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RealEstate_CommentVerifyPOM {
	private WebDriver driver; 
	private WebDriverWait wait;
	
	public RealEstate_CommentVerifyPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Blog')]")
	private WebElement blogLink;
	
	@FindBy(linkText="Read More")
	private WebElement readmore;
	
	@FindBy(id="comment")
	private WebElement commentSection;
	
	@FindBy(id="author")
	private WebElement name;
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="url")
	private WebElement website;
	
	@FindBy(id="submit")
	private WebElement submitbtn;
	
	@FindBy(xpath="//a[contains(text(),'Log In / Register')]")	
	private WebElement login;
	
	@FindBy(id="user_login")
	private WebElement yourName; 
	
	@FindBy(id="user_pass")
	private WebElement email1;
	
	@FindBy(xpath="//input[@name='login']")
	private WebElement signInBtn; 
	
	@FindBy(xpath="//li[@id='menu-comments']/a/div[3]")
	private WebElement commentlink;
	
	@FindBy(xpath="//li[7]/a/div[3]")
	private WebElement commentCol;
	

	public void ClickBlogLink() throws InterruptedException {
		this.blogLink.click();
		Thread.sleep(3000);
	}
	
	public void ClickReadMore() {
		this.readmore.click();
	}
	
	public void FindCommentSection(String cmt) {
		this.commentSection.clear();
		this.commentSection.sendKeys(cmt);
	}
	
	public void EnterName(String nm) {
		this.name.clear();
		this.name.sendKeys(nm);
	}
	
	public void EnterEmail(String eml) {
		this.email.clear();
		this.email.sendKeys(eml);
	}
	
	public void EnterWebsite(String url) {
		this.website.clear();
		this.website.sendKeys(url);
	}
	
	public void ClickSubmit() throws InterruptedException {
		this.submitbtn.click();
		Thread.sleep(3000);
	}
	
	public void clickLoginLink() {
		driver.get("http://realty-real-estatem1.upskills.in/");
		this.login.click();
		
	}
	
	public void sendUserName(String userName) {
		this.yourName.clear();
		this.yourName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.email1.clear(); 
		this.email1.sendKeys(password); 
	}
	
	public void clickSignIn() {
		this.signInBtn.click(); 
	}
	
	public void clickCommentLink() {
		this.commentlink.click();
	}
	
	public void VerifyComment() throws InterruptedException {
		String expected =this.commentCol.getText();
		String actual =this.commentSection.getText();
		if(expected == actual ) {
			System.out.println("Comments present"+ actual);
		}
		Thread.sleep(3000);
	}
	
	
}


