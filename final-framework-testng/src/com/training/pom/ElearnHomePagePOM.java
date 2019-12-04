package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElearnHomePagePOM {
private WebDriver driver; 
	
	public ElearnHomePagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="btn btn-default dropdown-toggle")
	private WebElement dropDown; 
	
	
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
		
		this.userName.sendKeys("English");
	}
	public void enterloginCredentials(String adminUserName, String adminPassword) {
		this.userName.clear();
		this.userName.sendKeys(adminUserName);
		
		this.password.clear();
		this.password.sendKeys(adminPassword);
		
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
