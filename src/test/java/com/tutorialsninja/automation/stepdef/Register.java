package com.tutorialsninja.automation.stepdef;

import java.util.Map;

import org.junit.Assert;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.pages.AccountSuccessPage;
import com.tutorialsninja.automation.pages.HeadersSection;
import com.tutorialsninja.automation.pages.RegisterPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.*;


public class Register {
	
	HeadersSection headersSection = new HeadersSection();
	RegisterPage registerPage = new RegisterPage();
	AccountSuccessPage accountSuccessPage = new AccountSuccessPage();
	

	@Given("^I launch the application$")
	public void i_launch_the_application(){
		Base.driver.get(Base.reader.getUrl());
		
	}

	@And("^I navigate to Register page$")
	public void i_navigate_to_Register_page(){
		
		Elements.click(HeadersSection.myAccountLink);
		Elements.click(HeadersSection.register);
		
	}

	@When("^I provide all the below valid details$")
	public void i_provide_all_the_below_valid_details(DataTable dataTable){
		
		RegisterPage.enterAllDetails(dataTable,"unique");	    
	}

	@And("^I select the Privacy Policy$")
	public void i_select_the_Privacy_Policy(){
		
		Elements.click(RegisterPage.privacyPolicy);
	    
	}

	@And("^I click on Continue button$")
	public void i_click_on_Continue_button(){
		
		Elements.click(RegisterPage.continueButton);
	   
	}
	
	@Then("^I should see that the User Account has succeessfully created$")
	public void i_should_see_that_the_User_Account_has_succeessfully_created() {
		
		Assert.assertTrue(Elements.isDisplayed(AccountSuccessPage.successBreadCrumb));
		
	    
	}
	
	@Then("^I should see that the User Account is not created$")
	public void i_should_see_that_the_User_Account_is_not_created(){
		
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.registerBreadCrumb));
	    
	}

	@And("^I should see the error messages informing the User to fill the mandatory fields$")
	public void i_should_see_the_error_messages_informing_the_User_to_fill_the_mandatory_fields() {
		
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.firstNameWarning));
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.lastNameWarning));
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.emailWarning));
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.telephoneWarning));
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.passwordWarning));
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.mainWarning));
		
		
	
	}
	
	@And("^I subscribe to Newsletter$")
	public void i_subscribe_to_Newsletter() {
		
		Elements.click(RegisterPage.yesToNewsletter);
	  
	}
	
	@When("^I provide the below duplicate details$")
	public void i_provide_the_below_duplicate_details(DataTable dataTable){
		
		RegisterPage.enterAllDetails(dataTable,"duplicate");
	    
	}

	@Then("^I should see that the User is restricted from creating duplicate account$")
	public void i_should_see_that_the_User_is_restricted_from_creating_duplicate_account(){
	
		Assert.assertTrue(Elements.VerifyTextEquals(RegisterPage.mainWarning, "Warning: E-Mail Address is already registered!"));
	
	}




}
