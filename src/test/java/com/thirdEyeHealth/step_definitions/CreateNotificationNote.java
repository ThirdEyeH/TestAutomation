package com.thirdEyeHealth.step_definitions;

import com.thirdEyeHealth.pages.CreateNote.CreateNotePage;
import com.thirdEyeHealth.pages.CreateNote.CreateNotificationNotePage;
import com.thirdEyeHealth.pages.LoginPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class CreateNotificationNote {

    CreateNotePage createNotePage = new CreateNotePage();
    LoginPage loginPage = new LoginPage();
    CreateNotificationNotePage createNotificationNotePage = new CreateNotificationNotePage();



    @Then("user select {string} from Select of Note Type menu")
    public void user_select_from_select_of_note_type_menu(String notificationNote) {
        createNotePage.SelectANote(notificationNote);
    }
    @Then("click Ok on red notification popup")
    public void click_ok_on_red_notification_popup() {

        createNotificationNotePage.clickOk();
    }
    @Then("user select any from primary chief complaint")
    public void user_select_any_from_primary_chief_complaint() {
       createNotificationNotePage.selectPrimaryChComplaint();
        System.out.println();
    }


    @Then("enter any on Chief Complaint - Additional Details and Summary* box")
    public void enter_any_on_chief_complaint_additional_details_and_summary_box(Map<String, String> dataTable) {

        String chiefComplaint_Add_Details = dataTable.get("Chief Complaint - Additional Details");
        String summary= dataTable.get("Summary*");
        System.out.println("Chief Complaint - Additional Details: "+chiefComplaint_Add_Details);
        System.out.println("summary: "+summary);
        createNotificationNotePage.textChComplaint_addDetailBox(chiefComplaint_Add_Details);
        createNotificationNotePage.textSummaryBox(summary);

    }
    @Then("click Notify TEH checkBox")
    public void click_notify_teh_check_box() {
        createNotificationNotePage.clickTEH_checkBox();
    }
    @Then("select {string} from Disposition dropdown")
    public void select_from_disposition_dropdown(String string) {
        createNotificationNotePage.selectDispositionDropdown(string);
    }

    @Then("select {string} from Technology used menu")
    public void select_from_technology_used_menu(String string) {
        createNotificationNotePage.selectTechnologyUsedDropdown(string);
    }
    @Then("user verifies that new note is displayed")
    public void user_verifies_that_new_note_is_displayed() {

    String actual = createNotificationNotePage.getDateFromTable();
    String expected = "Abnormal Vitals: Hypotension";
        Assert.assertEquals("not match",expected,actual);





    }









}
