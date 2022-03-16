package com.test.OrangeHRM.glue;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.test.OrangeHRM.pages.OrangeHRMHomePage;
import com.test.OrangeHRM.pages.OrangeHRMSignUpPage;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class OrangeHRMShared {

	 public RemoteWebDriver driver;
	 public FluentWait<RemoteWebDriver> wait;
	 public OrangeHRMHomePage homePage;
	 public OrangeHRMSignUpPage signUpPage;
	 public Scenario s;
	
	@Before
	public void initScenario(Scenario s) {
		this.s=s;
	}
}
