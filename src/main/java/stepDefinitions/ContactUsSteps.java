package stepDefinitions;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import utils.DriverFactory;

public class ContactUsSteps extends DriverFactory {
	
	@Given("^I access webdriveruniversity contact us form$")
	public void i_access_webdriveruniversity_contact_us_form() throws Throwable {
		contactUsPage.getContactUsPage();
	}

	@When("^I enter a valid firstname$")
	public void i_enter_a_valid_firstname() throws Exception {
		contactUsPage.enterFirstName();
	}


	@When("^I enter a valid last name$")
	public void i_enter_a_valid_last_name(DataTable dataTable) throws Exception{
		contactUsPage.enterLastName(dataTable, 0, 1);
	}

	@When("^i enter a valid email address on the form$")
	public void i_enter_a_valid_email_address_on_the_form() throws Throwable  {
		contactUsPage.enterEmailAddress("webdriveruniversity@gmail.com");
		
	}

	@And("^i enter comments on form$")
	public void i_enter_comment_on_forms(DataTable dataTable) throws Exception {
		contactUsPage.enterComments(dataTable, 0, 1);
	}

	@When("^i click on the submit button on form$")
	public void i_click_on_the_submit_button_on_form() throws Exception {
		contactUsPage.clickSubmitButton();
	}

	@Then("^the information should successfully be submitted via the contact us form$")
	public void the_information_should_successfully_be_submitted_via_the_contact_us_form() throws Exception  {
		contactUsPage.conformContactUsFormSubmissionWasSuccessful();
	}
	

}
