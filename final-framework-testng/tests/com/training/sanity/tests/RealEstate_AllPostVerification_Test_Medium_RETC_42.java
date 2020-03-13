package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RealEstate_AdminLoginPOM;
import com.training.pom.RealEstate_AllPost_PublishPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RealEstate_AllPostVerification_Test_Medium_RETC_42 {

	private WebDriver driver;
	private String baseUrl;
	private RealEstate_AdminLoginPOM realEstate_AdminLoginPOM;
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

	
//	Medium -RETC_042- To verify whether application displays added post in all post 
	@Test
	public void addPostTest() throws InterruptedException
	{   realEstate_AdminLoginPOM.clickLoginLink();
		realEstate_AdminLoginPOM.sendUserName("admin");
		realEstate_AdminLoginPOM.sendPassword("admin@123");
		realEstate_AdminLoginPOM.clickSignIn();
		
		
//		All Post
		realEstate_AllPost_PublishPOM.ClickPosts();
		realEstate_AllPost_PublishPOM.ClickToAllPost();
		realEstate_AllPost_PublishPOM.ClickAddNewPostBtn();
		realEstate_AllPost_PublishPOM.EnterAddNewPostTitle("IBM");
		realEstate_AllPost_PublishPOM.EnterContent("IBM Post");
		realEstate_AllPost_PublishPOM.ClickPublish();
		realEstate_AllPost_PublishPOM.ClickToAllPost();
				
		driver.findElement(By.xpath("//a[contains(text(),'IBM')]"));
		String actual = driver.findElement(By.xpath("//a[contains(text(),'IBM')]")).getText();
		System.out.println(actual);
		String expected = "IBM";
		Assert.assertEquals(actual, expected);
	}
}
