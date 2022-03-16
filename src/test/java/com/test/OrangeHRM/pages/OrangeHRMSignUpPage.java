package com.test.OrangeHRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class OrangeHRMSignUpPage {

	private RemoteWebDriver driver;
	private FluentWait<RemoteWebDriver> wait;
	private Select select;
	
	@FindBy(xpath = "//input[contains(@id,'Form_submitForm_s')]")
	private WebElement siteId;
	
	@FindBy(name = "Name")
	private WebElement name;
	
	@FindBy(name = "Contact")
	private WebElement phone_No;
	
	@FindBy(name = "Country")
	private WebElement country;
	
	@FindBy(name = "State")
	private WebElement state;
	
	@FindBy(xpath = "//label[@id='recaptcha-anchor-label']")
	private WebElement captcha;
	
	@FindBy(name = "action_request")
	private WebElement submit;
	
	@FindBy(xpath = "//h3[starts-with(text(),'Thank you')]")
	private WebElement signedUp;
	
	@FindBy(name = "Email")
	private WebElement email;
	
	public OrangeHRMSignUpPage(RemoteWebDriver driver,FluentWait<RemoteWebDriver> wait) {
		this.driver=driver;
		this.wait=wait;
		
		AjaxElementLocatorFactory af =new AjaxElementLocatorFactory(driver, 20);
		
		PageFactory.initElements(af, this);
	}
	
	public void fillSite(String site) {
		driver.manage().window().maximize();
		wait.until(ExpectedConditions.visibilityOf(siteId)).sendKeys(site);
	}
	
	public void fillFullName(String nam) {
		wait.until(ExpectedConditions.visibilityOf(name)).sendKeys(nam);
	}
	
	public void fillMobNo(String no) {
		wait.until(ExpectedConditions.visibilityOf(phone_No)).sendKeys(no);
	}
	
	public void selectCountry(String countryName) {
		select= new Select(country);
		
		wait.until(ExpectedConditions.visibilityOf(country));
		select.selectByVisibleText(countryName);
	}
	
	public void selectStateName(String stateName) {
		select= new Select(state);
		
		wait.until(ExpectedConditions.visibilityOf(state));
		select.selectByVisibleText(stateName);
	}
	
	public void clickOnIAmNotRobot() {
		wait.until(ExpectedConditions.elementToBeClickable(captcha)).click();
	}
	
	public void clickSubmit() {
		wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
	}
	
	//Here ternary operator Used
	public boolean verifySignUp(String value) {
		return signedUp.getText().contains(value)?true:false;
	}
	
}
