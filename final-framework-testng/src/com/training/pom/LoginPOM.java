package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="btn btn-default dropdown-toggle")
	private WebElement langDropDown; 
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="form-login_submitAuth")
	private WebElement loginBtn; 
	
	@FindBy(linkText="Sign up!")
	private WebElement signUp; 
	
	@FindBy(linkText="I lost my password")
	private WebElement lostPassword; 
	
     public void selectLanguage(String dropDown) {
		
		this.langDropDown.sendKeys("Deutsch ");
				
	}
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void clickSignUp() {
		this.signUp.click(); 
	}
	
	public void clickLostPassword() {
		this.lostPassword.click(); 
	}
	
}
