package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.HomePOM;
import com.training.pom.LoginPOM;
import com.training.pom.RealEstate_AddPost;
import com.training.pom.RealEstate_AdminLoginPOM;
import com.training.pom.RealEstate_AllPost_Publish;
import com.training.pom.RealEstate_NewLaunchPOM;
import com.training.pom.RealEstate_QueryFormPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RealEstate_AddPost_Test_Medium_RETC_040 {

	private WebDriver driver;
	private String baseUrl;
	private RealEstate_AdminLoginPOM realEstate_AdminLoginPOM;
	private RealEstate_AddPost realEstate_AddPost;
	private RealEstate_AllPost_Publish realEstate_AllPost_Publish;
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
		realEstate_AddPost = new RealEstate_AddPost(driver);
		realEstate_AllPost_Publish= new RealEstate_AllPost_Publish(driver);
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

	
//	Medium -RETC_040- To verify whether application displays added post in blog section of home screen
	@Test
	public void addPostTest() throws InterruptedException
	{
		realEstate_AdminLoginPOM.sendUserName("admin");
		realEstate_AdminLoginPOM.sendPassword("admin@123");
		realEstate_AdminLoginPOM.clickSignIn();
		
//	Add New Category		
		realEstate_AddPost.addNewPost();
		realEstate_AddPost.goToCategory();
		realEstate_AddPost.sendName("Mokshit");
		realEstate_AddPost.sendSlug("Mokshit");
		realEstate_AddPost.sendDescription("Mokshit");
		realEstate_AddPost.addNewCategoryBtn();
		
//		Search add category
		realEstate_AddPost.sendSerchOption("Mokshit");
		realEstate_AddPost.clickSearchBtn();
		realEstate_AddPost.validateSerach();
		
//		All Post
		realEstate_AllPost_Publish.ClickToAllPost();
		realEstate_AllPost_Publish.ClickAddNewPostBtn();
		realEstate_AllPost_Publish.EnterAddNewPostTitle("IBM Post");
		realEstate_AllPost_Publish.EnterContent("test");
		
		realEstate_AllPost_Publish.SelectAllCategoryLink();
		realEstate_AllPost_Publish.SelectCheckBox();
		realEstate_AllPost_Publish.ClickPublish();
		realEstate_AllPost_Publish.ClickViewPost();
		realEstate_AllPost_Publish.VerifyPost("IBM Post");
		
	}
}
