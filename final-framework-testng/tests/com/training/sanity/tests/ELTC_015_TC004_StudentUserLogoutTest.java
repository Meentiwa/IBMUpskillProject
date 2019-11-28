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
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CourseCatalogPOM;
import com.training.pom.LoginPOM;
import com.training.pom.MyCoursesPOM;
import com.training.pom.SignUpPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_015_TC004_StudentUserLogoutTest {
 
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
		signUpPOM.FollowCourseregisteration("student4", "fourth", "student4fourth@gmail.com", "student4fourth", "student4fourth@1234", "student4fourth@1234" );
		
	    //wait for sign up submit button
		WebDriverWait wait =new WebDriverWait(driver,1000);
        
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='registration_submit']")));

        signUpPOM.clicksregisterBtn();
	    //logout the student user
        signUpPOM.clicksLogoutDropDown();
        
        
         WebDriverWait wait1 =new WebDriverWait(driver,5000);
        
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_button")));
        signUpPOM.clicksLogOut();
	}
	
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	@Test
	public void validLogoutTest() {
		
		loginPOM.sendUserName("student4fourth");
		loginPOM.sendPassword("student4fourth@1234");
		loginPOM.clickLoginBtn();
		signUpPOM.clicksLogoutDropDown();
		signUpPOM.clicksLogOut();
		
		//screenShot.captureScreenShot("First");
	
	
}
}