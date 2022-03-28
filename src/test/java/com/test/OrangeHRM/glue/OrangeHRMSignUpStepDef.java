package com.test.OrangeHRM.glue;

import org.openqa.selenium.OutputType;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrangeHRMSignUpStepDef {

	public OrangeHRMShared sh;
	
	public OrangeHRMSignUpStepDef(OrangeHRMShared sh) {
		this.sh=sh;
	}
	
	@Given ("Fill {string} site in site field")
	public void fillSiteName(String sName) {
		sh.signUpPage.fillSite(sName);
	}
	
	@And ("Fill {string} in full name field")
	public void fillFullName(String name) {
		sh.signUpPage.fillFullName(name);
	}
	
	@And ("add phone number {string} in phone number field")
	public void fillMobNo(String no) {
		sh.signUpPage.fillMobNo(no);
	}
	
	@And ("select {string} country in country dropdown")
	public void selectCountry(String country) {
		sh.signUpPage.selectCountry(country);
	}
	
	@And ("select {string} state dropdown")
	public void selectState(String state) {
		sh.signUpPage.selectStateName(state);
	}
	
	@And ("click on I Am not Robot")
	public void clickOnRobot() {
		try {
			sh.signUpPage.clickOnIAmNotRobot();
		}catch(Exception e) {
			byte[] bScreen=sh.driver.getScreenshotAs(OutputType.BYTES);
			sh.s.attach(bScreen, "image/png", "notclicked");
		}
	}
	
	@When ("click on Submit")
	public void clickSubmit() {
		sh.signUpPage.clickSubmit();
	}
	
	@Then ("{string} page should displayed")
	public void verifySignedUp(String msg) {
		sh.s.log(sh.signUpPage.verifySignUp(msg)?"Signed Up successfully Test Passed"
				:"Signed Up failed Test Failed");
	}
	
	@And ("Author is {string}")
	public void autonr_name(String name) {
		
	}
}
