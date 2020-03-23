package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.HomePOM;
import com.training.pom.LoginPOM;
import com.training.pom.RealEstate_NewLaunchPOM;
import com.training.pom.RealEstate_QueryFormPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RealEstate_NewLaunch_QueryForm_Test_Simple_RETC_010 {

	private WebDriver driver;
	private String baseUrl;
	private RealEstate_NewLaunchPOM realEstate_NewLaunchPOM;
	private RealEstate_QueryFormPOM realEstate_QueryFormPOM;
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
		realEstate_NewLaunchPOM = new RealEstate_NewLaunchPOM(driver);
		realEstate_QueryFormPOM = new RealEstate_QueryFormPOM(driver);
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
	@Test
	public void validLoginTest() {
		realEstate_NewLaunchPOM.ClickNewLaunch();
		realEstate_NewLaunchPOM.ClickImageLink();
		realEstate_QueryFormPOM.sendYourName("manzoor");
		realEstate_QueryFormPOM.sendEmail("manzoor@gmail.com");
		realEstate_QueryFormPOM.SendSubject("apartments");
		realEstate_QueryFormPOM.SendMessage("looking for an apartments");
		realEstate_QueryFormPOM.clickSendBtn();
		WebElement error = driver.findElement(By.xpath("//div[text()='There was an error trying to send your message. Please try again later.']"));
		String errorMsg = error.getText();
		System.out.println(errorMsg);
	}
}
