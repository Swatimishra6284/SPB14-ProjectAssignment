package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RealEstate_AdminLoginPOM;
import com.training.pom.RealEstate_AllPost_PublishPOM;
import com.training.pom.RealEstate_CommentVerifyPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RealEstate_CommentVerififcation_Test_Medium_RETC_41 {

	private WebDriver driver;
	private String baseUrl;
	private RealEstate_CommentVerifyPOM realEstate_CommentVerifyPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		realEstate_CommentVerifyPOM = new RealEstate_CommentVerifyPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	
//	Medium -RETC_041- To verify whether application display comments added by the user in admin page
	@Test
	public void addPostTest() throws InterruptedException
	{
		
		realEstate_CommentVerifyPOM.ClickBlogLink();
		driver.findElement(By.xpath("//a[@href='http://realty-real-estatem1.upskills.in/ibm-post/' and text()='IBM Post']"));
		realEstate_CommentVerifyPOM.ClickReadMore();
		realEstate_CommentVerifyPOM.FindCommentSection("best project");
		realEstate_CommentVerifyPOM.EnterName("Test");
		realEstate_CommentVerifyPOM.EnterEmail("test@test.com");
		realEstate_CommentVerifyPOM.EnterWebsite("https://google.co.in");
		realEstate_CommentVerifyPOM.ClickSubmit();
		
//    Admin login to verify comment
		
		realEstate_CommentVerifyPOM.clickLoginLink();
		realEstate_CommentVerifyPOM.sendUserName("admin");
		realEstate_CommentVerifyPOM.sendPassword("admin@123");
		realEstate_CommentVerifyPOM.clickSignIn();
		realEstate_CommentVerifyPOM.clickCommentLink();
		realEstate_CommentVerifyPOM.VerifyComment();
		
		
		
	}
}
