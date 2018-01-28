package com.revature.cukes;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MercuryToursCukes {

	@Given("^the \"([^\"]*)\" is opened in chrome$")
	public void the_url_is_opened_in_chrome(String url) throws Throwable {
		MercuryTours.openApp(url);
	}

	@When("^valid \"([^\"]*)\" and \"([^\"]*)\" are entered$")
	public void valid_username_and_password_are_entered(String user, String pass) throws Throwable {
		MercuryTours.login(user, pass);
	}

	@Then("^I should see the home page$")
	public void i_should_see_the_home_page() throws Throwable {
	}


}
