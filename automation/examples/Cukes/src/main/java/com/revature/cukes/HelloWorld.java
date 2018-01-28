package com.revature.cukes;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HelloWorld {

	@Given("^I have (\\d+) dollars in my account$")
	public void sddssdvdfddfzdvdfd(int arg1) throws Throwable {
		System.out.println("inside the given method of hello world");
	}

	@When("^I try to withdraw (\\d+) from my account$")
	public void can_i_change_this_name(int arg1) throws Throwable {
		System.out.println("inside the when method of hello world");
	}

	@Then("^I should be able to see the remaining balance of (\\d+) dollars$")
	public void i_should_be_able_to_see_the_remaining_balance_of_dollars(int arg1) throws Throwable {
		System.out.println("inside the then method of hello world");
	}
	
	@Given("^there are (\\d+) cucumbers for lunch$")
	public void there_are_cucumbers(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("total cukes are: " + arg1);
	}

	@Given("^they are in my fridge$")
	public void they_are_in_my_fridge() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("they are easily accessible in fridge");
	}
	
	@When("^I eat (\\d+) cucumbers$")
	public void i_eat_cucumbers(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println(" cukes eaten: " + arg1);
	}

	@Then("^I should have (\\d+) cucumbers left$")
	public void i_should_have_cucumbers_left(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println(" cukes remaining: " + arg1);
	}

	@Given("^I logged in as \"([^\"]*)\"$")
	public void i_logged_in_as(String user) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("User successfully logged in as "+ user);
	}

	@When("^I try to post a question about \"([^\"]*)\"$")
	public void i_try_to_post_a_question_about(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Tom posted a question about "+ arg1);
	}

	@Then("^I should see my question posted in the forum with \"([^\"]*)\"$")
	public void i_should_see_my_question_posted_in_the_forum_with(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Tom is able to see the "+ arg1);
	}
	
	@Given("^there are cucumbers:$")
	public void there_are_cucumbers(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		System.out.println("this is printed from the background");
	}
}
