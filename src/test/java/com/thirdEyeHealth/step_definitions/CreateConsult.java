package com.thirdEyeHealth.step_definitions;

import com.thirdEyeHealth.pages.LandingPage;
import com.thirdEyeHealth.pages.LoginPage;
import com.thirdEyeHealth.utilies.ConfigurationReader;
import com.thirdEyeHealth.utilies.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateConsult {

    LoginPage loginPage = new LoginPage();

    LandingPage landingPage = new LandingPage();



    @Given("user on the log in page")
    public void user_on_the_log_in_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user logs in")
    public void user_logs_in() {
        loginPage.login();
    }

    @When("user navigate to {string} from the top most menu")
    public void user_navigate_to_from_the_top_most_menu(String string) {

        landingPage.clickModule(string);
    }

    @When("clicks the green Add Consult Request button")
    public void clicks_the_green_button (){
        landingPage.clickAddConsultRequest();
    }

    @When("select facility {string}")
    public void select_facility(String string) {
        landingPage.selectFacility(string);
    }

    @When("user select any nurse, patient, chief complaint, and clinician")
    public void user_select_any_nurse_patient_chief_complaint_and_clinician() {
        landingPage.selectNurse();
        landingPage.selectPt();
        landingPage.setCheifComplaint();
        landingPage.selectClinician();

    }
    @Then("user should be able to click Create Consult Request")
    public void user_should_be_able_to_click() {
        landingPage.clickConsultRequestButton();
    }

    @Then("click the cancel button")
    public void click_the_cancel_button() {
        landingPage.clickCancel();
    }

    @Then("user should be able to see new consult request on the table, and click green Create note button")
    public void user_should_be_able_to_see_new_consult_request_on_the_table_and_click_green_create_note_button() {
        landingPage.clickCreateNoteButton();

    }

}
