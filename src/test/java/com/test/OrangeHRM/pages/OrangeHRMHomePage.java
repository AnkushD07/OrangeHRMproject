package com.test.OrangeHRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class OrangeHRMHomePage {

	private RemoteWebDriver driver;
	private FluentWait<RemoteWebDriver> wait;
	
	@FindBy(xpath = "//input[@class='home-tril-email']")
	private WebElement email;
	
	@FindBy(id = "linkadd")
	private WebElement get_Free_Trial;
	
	@FindBy(xpath = "//img[@alt='OrangeHRM Inc Logo']/parent::a")
	private WebElement logo_Orange_HRM;
	
	@FindBy(xpath = "//a[@title='Accept Cookies']")
	private WebElement acceptCookies;
	
	public OrangeHRMHomePage(RemoteWebDriver driver, FluentWait<RemoteWebDriver> wait) {
		this.driver=driver;
		this.wait=wait;
		
		AjaxElementLocatorFactory af =new AjaxElementLocatorFactory(driver, 20);
		
		PageFactory.initElements(af, this);
	}
	
	public String getTitle() {
		wait.until(ExpectedConditions.visibilityOf(logo_Orange_HRM));
		return driver.getTitle();
	}
	
	public void fillEmail(String mail) {
		wait.until(ExpectedConditions.visibilityOf(email)).sendKeys(mail);
	}
	
	public void clickGetFreeTrial() {
		if(wait.until(ExpectedConditions.elementToBeClickable(acceptCookies)).isDisplayed()) {
			acceptCookies.click();
		   wait.until(ExpectedConditions.elementToBeClickable(get_Free_Trial)).click();
		}else 
			wait.until(ExpectedConditions.elementToBeClickable(get_Free_Trial)).click();
	}
	
	public boolean regPage_displayed() {
		return  wait.until(ExpectedConditions.visibilityOf(logo_Orange_HRM)).isDisplayed();
	}
}
