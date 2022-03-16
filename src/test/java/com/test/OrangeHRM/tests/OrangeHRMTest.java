package com.test.OrangeHRM.tests;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features ={"src//test//resources//features//GetFreeTrial.feature",
							},
				glue = "com/test/OrangeHRM/glue",
				plugin = {"pretty","html:target/myresult"},
				 monochrome = true)					
public class OrangeHRMTest {

}
//"src//test//resources//features//RegOnOrangeHRM.feature"