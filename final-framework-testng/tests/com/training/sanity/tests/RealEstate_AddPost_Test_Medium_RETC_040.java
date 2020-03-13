package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.HomePOM;
import com.training.pom.LoginPOM;
import com.training.pom.RealEstate_AddPostPOM;
import com.training.pom.RealEstate_AdminLoginPOM;
import com.training.pom.RealEstate_AllPost_PublishPOM;
import com.training.pom.RealEstate_NewLaunchPOM;
import com.training.pom.RealEstate_QueryFormPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RealEstate_AddPost_Test_Medium_RETC_040 {

	private WebDriver driver;
	private String baseUrl;
	private RealEstate_AdminLoginPOM realEstate_AdminLoginPOM;
	private RealEstate_AddPostPOM realEstate_AddPostPOM;
	private RealEstate_AllPost_PublishPOM realEstate_AllPost_PublishPOM;
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
		realEstate_AdminLoginPOM = new RealEstate_AdminLoginPOM(driver);
		realEstate_AddPostPOM = new RealEstate_AddPostPOM(driver);
		realEstate_AllPost_PublishPOM= new RealEstate_AllPost_PublishPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
//		driver.quit();
	}

	
//	Medium -RETC_040- To verify whether application displays added post in blog section of home screen
	@Test
	public void addPostTest() throws InterruptedException
	{   realEstate_AdminLoginPOM.clickLoginLink();
		realEstate_AdminLoginPOM.sendUserName("admin");
		realEstate_AdminLoginPOM.sendPassword("admin@123");
		realEstate_AdminLoginPOM.clickSignIn();
		
//	Add New Category		
		realEstate_AddPostPOM.addNewPost();
		realEstate_AddPostPOM.goToCategory();
		realEstate_AddPostPOM.sendName("Mokshit");
		realEstate_AddPostPOM.sendSlug("Mokshit");
		realEstate_AddPostPOM.sendDescription("Mokshit");
		realEstate_AddPostPOM.addNewCategoryBtn();
		
//		Search add category
		realEstate_AddPostPOM.sendSerchOption("Mokshit");
		realEstate_AddPostPOM.clickSearchBtn();
		realEstate_AddPostPOM.validateSerach();
		
//		All Post
		realEstate_AllPost_PublishPOM.ClickToAllPost();
		realEstate_AllPost_PublishPOM.ClickAddNewPostBtn();
		realEstate_AllPost_PublishPOM.EnterAddNewPostTitle("IBM Post");
		realEstate_AllPost_PublishPOM.EnterContent("test");
		
		realEstate_AllPost_PublishPOM.SelectAllCategoryLink();
		realEstate_AllPost_PublishPOM.SelectCheckBox();
		realEstate_AllPost_PublishPOM.ClickPublish();
		realEstate_AllPost_PublishPOM.ClickViewPost();
//		realEstate_AllPost_PublishPOM.VerifyPost("IBM Post");
		
		driver.findElement(By.xpath("//a[@href='http://realty-real-estatem1.upskills.in/ibm-post/' and text()='IBM Post']")).getText();
		String actual = driver.findElement(By.xpath("//a[@href='http://realty-real-estatem1.upskills.in/ibm-post/']")).getText();
		
		System.out.println(actual);
		String expected = "IBM Post";
		Assert.assertEquals(actual, expected);
			
	}
}
