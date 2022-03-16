package com.test.OrangeHRM.glue;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.test.OrangeHRM.pages.OrangeHRMHomePage;
import com.test.OrangeHRM.pages.OrangeHRMSignUpPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMStepDef {

	public OrangeHRMShared sh;
	
	public OrangeHRMStepDef(OrangeHRMShared sh) {
		this.sh=sh;
	}
	
	@Given ("open Browser and launch {string} site")
	public void launchSite(String URL) {
		WebDriverManager.chromedriver().setup();
		sh.driver=new ChromeDriver();
		sh.driver.get(URL);
		
		sh.wait=new FluentWait<RemoteWebDriver>(sh.driver);
		sh.wait.withTimeout(Duration.ofSeconds(20));
		sh.wait.pollingEvery(Duration.ofMillis(150));
		
		//Initially create the objects of page classes
		sh.homePage=new OrangeHRMHomePage(sh.driver, sh.wait);
		sh.signUpPage =new OrangeHRMSignUpPage(sh.driver, sh.wait);
	}
	
	@Then ("{string} Title should displayed")
	public void titleVerify(String title) {
		if(sh.homePage.getTitle().contains(title)) {
			sh.s.log("Title match and test passed");
		}else {
			sh.s.log("Title doesn't match and test fail");
		}
	}
	
	@Then ("fill {string} mail id")
	public void fillEmail(String mail) {
		sh.homePage.fillEmail(mail);
	}
	
	@And ("click on Get A Free Trial")
	public void clickFreeTrial() {
		sh.homePage.clickGetFreeTrial();
	}
	
	@Then ("Registeration page should displayed")
	public void verifyRegPage() {
		if(sh.homePage.regPage_displayed()) {
			sh.s.log("Registeration page opened and Test Passed");
		}else {
			sh.s.log("Registeration page not opened and Test failed");
		}
	}
}
