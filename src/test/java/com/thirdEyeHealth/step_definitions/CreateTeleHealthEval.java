package com.thirdEyeHealth.step_definitions;

import com.thirdEyeHealth.pages.CreateNote.CreateNotePage;
import com.thirdEyeHealth.pages.CreateNote.CreateTeleHealthEvalPage;
import com.thirdEyeHealth.pages.LoginPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class CreateTeleHealthEval {


    CreateNotePage createNotePage = new CreateNotePage();
    LoginPage loginPage = new LoginPage();
    CreateTeleHealthEvalPage createTeleHealthEvalPage = new CreateTeleHealthEvalPage();



    @Then("enter any on Chief Complaint and History Present Illness box")
    public void enter_any_on_chief_complaint_and_history_present_illness_box(Map<String, String> dataTable) {

        String chiefComplainte = dataTable.get("Chief Complaint - Additional Details");
        String historyPresentIll= dataTable.get("History Present Illness*");

        System.out.println("Chief Complaint - Additional Details: "+chiefComplainte);
        System.out.println("History Present Illness*"+historyPresentIll);

        createTeleHealthEvalPage.enterTextToChiefComlaintBx(chiefComplainte);
        createTeleHealthEvalPage.enterTextToHistoryPresentIllBx(historyPresentIll);
    }
    @Then("select any from review of system menu")
    public void select_any_from_review_of_system_menu() {
        createTeleHealthEvalPage.selectReviewOfSysDropD();
    }

    @Then("click External EHR from Source of verification for all history*")
    public void click_external_ehr_from_source_of_verification_for_all_history() {
     createTeleHealthEvalPage.checkExternalEHRBx();
    }
    @Then("select {string} from Physical Exam dropdown")
    public void select_from_physical_exam_dropdown(String string) {
     createTeleHealthEvalPage.selectphysicalExamDropD(string);
    }
    @Then("click Notify TEH checkBox on TeleNote")
    public void click_notify_teh_check_box_on_tele_note() {
     createTeleHealthEvalPage.clickTEHBx();
    }
    @Then("enter any on Exam findings per nurse, Diagnostic Results boxs")
    public void enter_any_on_exam_findings_per_nurse_diagnostic_results_boxs(Map<String, String> dataTable) {
       String examFindingsPerNurse = dataTable.get("Exam findings per nurse");
       String diagnosticResult = dataTable.get("Diagnostic Results and Diagnosis");
       createTeleHealthEvalPage.enterExamFindingPerNurseBx(examFindingsPerNurse);
       createTeleHealthEvalPage.enterDiagnosticResultBx(diagnosticResult);

    }
    @Then("enter any number on phone visit only box")
    public void enter_any_number_on_phone_visit_only_box() {
        createTeleHealthEvalPage.enterTxPhoneVisitOnly();
    }
    @Then("user should see new note is displayed")
    public void user_should_see_new_note_is_displayed() {
      String actual = createTeleHealthEvalPage.getData();
      String expected = "Telehealth Evaluation";
        Assert.assertEquals(actual,expected);
    }



}
