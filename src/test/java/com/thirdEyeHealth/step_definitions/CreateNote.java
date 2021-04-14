package com.thirdEyeHealth.step_definitions;

import com.thirdEyeHealth.pages.CreateNote.CreateNotePage;
import com.thirdEyeHealth.pages.LoginPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class CreateNote {

    CreateNotePage createNotePage = new CreateNotePage();
    LoginPage loginPage = new LoginPage();

    @Then("user select {string} from the Select a NoteType menu")
    public void user_select_from_the_select_a_note_type_menu(String FollowUpNote) {
        createNotePage.SelectANote(FollowUpNote);

    }
    @Then("clicks the green Go button, user able to see Create Note form")
    public void clicks_the_green_go_button_user_able_to_see_create_note_form() {
        createNotePage.clickGo();
    }
    @Then("click view side by side button")
    public void click_view_side_by_side_button() {
        createNotePage.ViewFullScreen();
    }
    @Then("user select any from chief complaint")
    public void user_select_any_from_chief_complaint() {
        createNotePage.SelectPrimaryChiefComplaint();
    }


    @Then("enter any on interval History and interval exam box")
    public void enter_any_on_interval_history_and_interval_exam_box(Map<String, String> dataTable) {

        String interval_history = dataTable.get("Interval History");
        String intervalExam = dataTable.get("Interval Exam");
        System.out.println("Interval History: "+interval_history);
        System.out.println("Interval Exam"+ intervalExam);

        createNotePage.IntervalHistory(interval_history);
        createNotePage.IntervalExam(intervalExam);
    }
    @Then("enter {string} on Diagnosis, Assessment Plan then click green + button")
    public void enter_on_diagnosis_assessment_plan_then_click_green_button(String code) {
        createNotePage.DiagnosisAssessment(code);
    }
    @Then("click A4159- Other - Gram negative sepsis radio button")
    public void click_a4159_other_gram_negative_sepsis_radio_button() {
        createNotePage.checkbox();
    }

    @Then("enter {string} on assessment plan box")
    public void enter_on_assessment_plan_box(String text) {
        createNotePage.Entertext_assessment_planTextBox(text);
    }
    @Then("click Notify TEH checkBox on followUp")
    public void click_notify_teh_check_box_on_follow_up() {
     createNotePage.ClickNotifyTEHbx();
    }

    @Then("select any from Disposition")
    public void select_any_from_disposition() {
        createNotePage.SelectDisposition();
    }
    @Then("select {string} from Technology Used")
    public void select_from_technology_used(String TextOnly) {
        createNotePage.SelectTechnologyUsered(TextOnly);
    }
    @Then("select any form Text Only Reason dropdown")
    public void select_form_text_only_reason_dropdown() {
        createNotePage.TextOnlyReasonDropdown();
    }


    @Then("enter any number on Total time of encounter including connectivity box")
    public void enter_any_number_on_total_time_of_encounter_including_connectivity_box() {

        createNotePage.TotalTimeBox();
    }
    @Then("click the save button")
    public void click_the_save_button() {
        createNotePage.clickSaveBtn();

    }
    @Then("Then user verifies that new note is displayed")
    public void then_user_verifies_that_new_note_is_displayed() {


        String actual =createNotePage.getDateFromTable();
        String expected = "Abdominal Pain";

        Assert.assertEquals("not match",expected,actual);

    }



}
 /*
 @Then("click Notify TEH of any change in condition radio button")
    public void click_notify_teh_of_any_change_in_condition_radio_button() {
      createNotePage.checkbox();
    }
  */