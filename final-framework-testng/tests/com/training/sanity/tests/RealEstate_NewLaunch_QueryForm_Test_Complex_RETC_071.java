package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.HomePOM;
import com.training.pom.LoginPOM;
import com.training.pom.RealEstate_NewLaunchPOM;
import com.training.pom.RealEstate_QueryFormPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RealEstate_NewLaunch_QueryForm_Test_Complex_RETC_071 {

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
	
	@Test(dataProvider = "form_inputs", dataProviderClass = LoginDataProviders.class)
	public void validLoginTest(String userName, String email2, String subject, String messages) {
		realEstate_NewLaunchPOM.ClickNewLaunch();
		
		realEstate_NewLaunchPOM.ClickImageLink();
		
		realEstate_QueryFormPOM.sendYourName(userName);
		System.out.println(userName);
		
		realEstate_QueryFormPOM.sendEmail(email2);
		System.out.println(email2);
		
		realEstate_QueryFormPOM.SendSubject(subject);
		System.out.println(subject);
		
		realEstate_QueryFormPOM.SendMessage(messages);
		System.out.println(messages);
		
		realEstate_QueryFormPOM.clickSendBtn();
	}
}
