package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPOM {
private WebDriver driver; 
	
	public SignUpPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='qf_e917c5']")
	private WebElement followCourse; 
	
	
	@FindBy(id="qf_b04447")
	private WebElement teachCources; 
	
	@FindBy(id="registration_firstname")
	private WebElement firstName;
	
	@FindBy(id="registration_lastname")
	private WebElement lastName; 
	
	@FindBy(id="registration_email")
	private WebElement eMail; 
	
	@FindBy(id="username")
	private WebElement userName; 
	
	@FindBy(id="pass1")
	private WebElement pass;
	
	@FindBy(id="pass2")
	private WebElement confirmPassword;
	
	@FindBy(id="registration_submit")
	private WebElement registerBtn;
	
	@FindBy(linkText="My courses")
	private WebElement myCources;

	
	public void FollowCourseregisteration(String firstName, String lastName, String eMail, String userName, String pass, String confirmPassword ) {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
		
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
		this.eMail.clear();
		this.eMail.sendKeys(eMail);
		this.userName.clear();
		this.userName.sendKeys(userName);
		this.pass.clear();
		this.pass.sendKeys(pass);
		this.confirmPassword.clear();
		this.confirmPassword.sendKeys(confirmPassword);
	
		
	}
	public void clickFollowCourse() {
		this.followCourse.click(); 
	}
	
	public void clicksTeachCources() {
		this.teachCources.click(); 
	}
	public void clicksregisterBtn() {
		this.registerBtn.click(); 
	}
	
	public void clicksMyCourcesBtn() {
		this.myCources.click(); 
	}
	
	/*public void clickLostPassword() {
		this.lostPassword.click(); 
	}*/
}

