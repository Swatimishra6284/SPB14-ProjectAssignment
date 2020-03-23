package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class RealEstate_NewLaunch_QueryForm_Test_Complex_RETC_072 {

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
	
	@Test(dataProvider = "form_inputs_neg", dataProviderClass = LoginDataProviders.class)
	public void validLoginTest(String userName, String email1, String subject, String messages) {
		realEstate_NewLaunchPOM.ClickNewLaunch();
		
		realEstate_NewLaunchPOM.ClickImageLink();
		
		realEstate_QueryFormPOM.sendYourName(userName);
		System.out.println(userName);
		
		realEstate_QueryFormPOM.sendEmail(email1);
		System.out.println(email1);
		
		realEstate_QueryFormPOM.SendSubject(subject);
		System.out.println(subject);
		
		realEstate_QueryFormPOM.SendMessage(messages);
		System.out.println(messages);
		
		realEstate_QueryFormPOM.clickSendBtn();
		
		//*[@id="wpcf7-f4-o1"]/form/p[1]/label/span/input
		//*[@id="wpcf7-f4-o1"]/form/p[2]/label/span/input
		
		if(userName == " ") {
			if(email1 == " ") {
				driver.findElement(By.xpath("//*[@id=\"wpcf7-f4-o1\"]/form/p[1]/label/span/input]"));
				driver.findElement(By.xpath("//*[@id=\"wpcf7-f4-o1\"]/form/p[2]/label/span/input"));
				String errorMsg = driver.findElement(By.xpath("//span[@role='alert' and text()='The field is required.']")).getText();
				System.out.println("UserName and Email fields are empty:  " + errorMsg);
			}else {
				
				driver.findElement(By.xpath("//*[@id=\"wpcf7-f4-o1\"]/form/p[1]/label/span/input]"));
				String errorMsg = driver.findElement(By.xpath("//span[@role='alert' and text()='The field is required.']")).getText();
				System.out.println("UserName and Email fields are empty:  " + errorMsg);
			}
			
		}else {
			if(userName != " ") {
				if(email1 == " ") {
					driver.findElement(By.xpath("//*[@id=\"wpcf7-f4-o1\"]/form/p[2]/label/span/input"));
					String errorMsg = driver.findElement(By.xpath("//span[@role='alert' and text()='The field is required.']")).getText();
					System.out.println("UserName and Email fields are empty:  " + errorMsg);
				}
			}
			
		}
		
	

		}
	
}
			
	
		
	


