package com.thirdEyeHealth.step_definitions;

import com.thirdEyeHealth.pages.signNote.SignNote;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class signNote {

    SignNote signNote = new SignNote();

    @Given("user on Note page")
    public void user_on_note_page() {
      signNote.clickNote();
    }


    @When("user click View Note on the first row of datatable")
    public void user_click_view_note_on_the_first_row_of_datatable() {
       signNote.clickViewNote();
    }
    @When("user on sign note page and click sign green button")
    public void user_on_sign_note_page_and_click_sign_green_button() {
    signNote.clickSignBtn();
        System.out.println("Click Green Sign button");
    }
    @When("click Ok on popup alert")
    public void click_ok_on_popup_alert()
    {
        signNote.clickOk();
    }

    @When("click Ok again on second popup")
    public void click_ok_again_on_second_popup()
    {
     signNote.clickOk();
    }
    @Then("user verifies that signed is displayed")
    public void user_verifies_that_signed_is_displayed() {
        String actual =signNote.getTxt();
        boolean expected = !actual.isEmpty();
        Assert.assertTrue(expected);
    }
    @Then("user verifies that signed is displayed in telenote")
    public void user_verifies_that_signed_is_displayed_in_telenote() {
       String actual =signNote.getTxtofTeleHealth();
       boolean expected = !actual.isEmpty();
       Assert.assertTrue(expected);

    }



}
