package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RealEstate_AdminLoginPOM;
import com.training.pom.RealEstate_AllPost_PublishPOM;
import com.training.pom.RealEstate_PropertyPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RealEstate_PropertiesDetails_Test_Complex_RETC_070 {

	private WebDriver driver;
	private WebDriverWait wait;
	private String baseUrl;
	private RealEstate_AdminLoginPOM realEstate_AdminLoginPOM;
    private RealEstate_PropertyPOM realEstate_PropertyPOM;
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
		realEstate_PropertyPOM = new RealEstate_PropertyPOM(driver);
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

	
//	Medium -RETC_042- To verify whether application displays added post in all post 
	@Test
	public void addPostTest() throws InterruptedException
	{   realEstate_AdminLoginPOM.clickLoginLink();
		realEstate_AdminLoginPOM.sendUserName("admin");
		realEstate_AdminLoginPOM.sendPassword("admin@123");
		realEstate_AdminLoginPOM.clickSignIn();
		
		realEstate_PropertyPOM.clickProperties();
		realEstate_PropertyPOM.clickFeatures();
		realEstate_PropertyPOM.enterName("New Launches");
		realEstate_PropertyPOM.enterSlug("launch");
		realEstate_PropertyPOM.enterDescription("New Launches of villas, apartments, flats");
		realEstate_PropertyPOM.clickAddNewFeatureBtn();
		
		driver.findElement(By.id("tag-search-input")).sendKeys("New Launches");
		
//		click using JavaScript
		
		WebElement element = driver.findElement(By.xpath("//input[@class='button' and @value='Search Features']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		
		driver.findElement(By.xpath("//a[contains(text(),'New Launches')]"));
		String actual = driver.findElement(By.xpath("//a[contains(text(),'New Launches')]")).getText();
		System.out.println(actual);
		String expected = "New Launches";
		Assert.assertEquals(actual, expected);
		

	}
}
