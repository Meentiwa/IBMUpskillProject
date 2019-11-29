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
	
	
	@FindBy(xpath="//*[@id='qf_2d0bb9']")
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

	@FindBy(xpath="//*[@id='navbar']/ul[2]/li[2]/a")
	private WebElement logoutDropDown;
	
	
	@FindBy(id="logout_button")
	private WebElement logout;
	
	@FindBy(xpath="//*[@id='login-block']/div/ul/li[2]/a")
	private WebElement lostPassword;
	
	@FindBy(id="lost_password_user")
	private WebElement usernameOrEmail;
	
	
	@FindBy(xpath="//*[@id='lost_password_submit']")
	private WebElement sendMessageBtn;
	
	
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

		if(this.followCourse.isSelected()==true)
		{
			System.out.println("followCourse has been selected");
		}
		else {
			System.out.println("followCourse is not selectable");
		}

		this.teachCources.click(); 
	}
	public void clicksregisterBtn() {
		this.registerBtn.click(); 
	}
	
	public void clicksMyCourcesBtn() {
		this.myCources.click(); 
	}
	
	public void clicksLogoutDropDown() {
		this.logoutDropDown.click(); 
	}
	
	public void clicksLogOut() {
		this.logout.click(); 
	}
	
	public void clicksLostPassword() {
		this.lostPassword.click(); 
	}
	
	public void usernameOrEmail(String email) {
		this.usernameOrEmail.sendKeys(email);
	}
	
	public void clicksSendMessageBtn() {
		this.sendMessageBtn.click();; 
	}
	/*public void clickLostPassword() {
		this.lostPassword.click(); 
	}*/
}

