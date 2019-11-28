package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCoursesPOM {
private WebDriver driver; 
	
	public MyCoursesPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='homepage-course']/div/a")
	private WebElement courseCatalogBtn; 
	
	      
	@FindBy(xpath="//*[@id='page']/div/div/div/div/div[2]/h4/a")
	private WebElement courseDescription; 
	
	
	public void clicksCourseCatalogBtn() {
		this.courseCatalogBtn.click(); 
	}
	
	public void clicksCourseDescription() {
		this.courseDescription.click(); 
	}
}
