package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CourseCatalogPOM;
import com.training.pom.LoginPOM;
import com.training.pom.MyCoursesPOM;
import com.training.pom.SignUpPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_013_TC002_StundentRegisterToSeleniumCourseTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private MyCoursesPOM myCoursesPOM;
	private CourseCatalogPOM courseCatalogPOM;
	SignUpPOM signUpPOM= new SignUpPOM(driver);
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
		loginPOM = new LoginPOM(driver); 
		signUpPOM= new SignUpPOM(driver);
		myCoursesPOM = new MyCoursesPOM(driver);
		courseCatalogPOM= new CourseCatalogPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);         
		
		loginPOM.clickSignUp();
		
		String expectation="My Organization - My education - Registration";
		String actual=driver.getTitle();
		System.out.println(actual);
		Assert.assertEquals(expectation, actual);
		

		
		//signUpPOM.clickFollowCourse();
		System.out.println("abc");
		signUpPOM.FollowCourseregisteration("student1", "first", "student1first@gmail.com", "student1first", "student1first@1234", "student1first@1234" );
		
	    //wait for sign up submit button
		WebDriverWait wait =new WebDriverWait(driver,1000);
        
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='registration_submit']")));

        signUpPOM.clicksregisterBtn();
		/*String expectation1="Your personal settings have been registered.";
		String actual1 = driver.findElement(By.className("col-xs-12 col-md-12")).getAttribute("textContent");
		Assert.assertEquals(expectation1, actual1);
		System.out.println(actual);*/
		
	}
	
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	@Test
	public void validLoginTest() {
		signUpPOM.clicksMyCourcesBtn();
		myCoursesPOM.clicksCourseCatalogBtn();
		courseCatalogPOM.enterInSearch("selenium");
		courseCatalogPOM.clicksSearchBtn();
		
		//User student1 first (student1first) has been registered to course Automation
		courseCatalogPOM.clicksSubscribeBtn();
		/*loginPOM.sendUserName("student1first");
		loginPOM.sendPassword("student1first@124");
		loginPOM.clickLoginBtn();
		myCoursesPOM.clicksCourseCatalogBtn();*/
		
		//screenShot.captureScreenShot("First");
	}
}
