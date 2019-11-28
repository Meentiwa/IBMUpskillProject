package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CourseCatalogPOM {
private WebDriver driver; 
	
	public CourseCatalogPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="search_term")
	private WebElement search; 
	
	@FindBy(xpath="//*[@id='cm-content']/div/div[2]/div/div/div/div[1]/form/div/div/button")
	private WebElement searchbtn; 
	//*[@id="cm-content"]/div/div[3]/div[1]/div/div[2]/div[4]/div/a
	
	@FindBy(xpath="//*[@id='cm-content']/div/div[3]/div[7]/div/div[2]/div[4]/div/a")
	private WebElement subscribeBtn; 
	
	public void enterInSearch(String searchValue) {
		this.search.clear(); 
		this.search.sendKeys(searchValue); 
	}
	public void clicksSearchBtn() {
		this.searchbtn.click();
	
	}
	public void clicksSubscribeBtn() {
		this.subscribeBtn.click();
	
	}
}
