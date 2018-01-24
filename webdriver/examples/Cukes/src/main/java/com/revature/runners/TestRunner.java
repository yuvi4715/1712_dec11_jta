package com.revature.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features= {"src/test/resources","src/main/resources"}, tags="iteration1")
public class TestRunner extends AbstractTestNGCucumberTests{
	
}
