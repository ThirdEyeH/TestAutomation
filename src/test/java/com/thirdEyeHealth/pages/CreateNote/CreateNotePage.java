package com.thirdEyeHealth.pages.CreateNote;

import com.thirdEyeHealth.pages.BasePage;
import com.thirdEyeHealth.utilies.BrowserUtils;
import com.thirdEyeHealth.utilies.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNotePage extends BasePage {

    @FindBy(xpath = "//select[@id='ddlConsultForms']" )
    private WebElement selectANoteDropdown;

    @FindBy(xpath = "//input[@value='Go']" )
    private WebElement goButton;

    @FindBy(xpath = "//button[@title='View fullscreen']" )
    private WebElement viewFullScreenButton;

    @FindBy(xpath = "//select[@class='chiefcomplaintdropdown select2 select2-hidden-accessible']")
    private WebElement primaryChiefComplaintDropdown;

    @FindBy(xpath = "//div/textarea[@id='2DF26F70-3306-47E9-975D-F59EDB365225']")
    private WebElement vitalSignsBox;

    @FindBy(xpath = "//div/textarea[@id='F6D39B4C-F6F2-4442-94DD-AE357D8DF294']")
    private WebElement intervalHistoryBox;

    @FindBy(xpath = "//div/textarea[@id='1C652B36-146B-4F6B-98DB-C8FEF95B706C']")
    private WebElement intervalExamBox;

    @FindBy(xpath = "input[id='ddl2D76BFB8-9594-4347-80EF-466A594F4825']")
    private WebElement diagnosisAssessmentBox;

    @FindBy (xpath = "//button[@class='btn btn-success']")
    private WebElement greenPlusButton;

    @FindBy (id = "chk_A4159 - Other Gram-negative sepsis")
    private WebElement checkBox;

    @FindBy(id = "txt_A4159 - Other Gram-negative sepsis(Primary)")
    private WebElement assessment_planTextBox;

    @FindBy(xpath = "//input[@name='ddl2D76BFB8-9594-4347-80EF-466A594F4825']")
    private WebElement assessmentTextBox;

    @FindBy(xpath = "//div/input[@id='notifyOrders']")
    private WebElement NotifyTEHIOrderCheckBox;

    @FindBy(css = "select[id=ddl145EC8A8-113C-4C15-AA1D-68CEF44896EE]")
    private WebElement dispositionDropdown;

    @FindBy (css = "select[id=ddlA89A051B-A05A-467B-9282-0FFB35CB7B4F]")
    private WebElement technologyUsedDropDown;

    @FindBy (xpath = "//span[@id='select2-ptorquestiondropdown-container']")
    private WebElement textOnlyReasonDropdown;

    @FindBy(xpath = "//ul/li[contains(text(),'Connectivity Issue')]")
    private WebElement connectivityIssue;

    @FindBy (xpath = "//input[@id='8BC88075-C3F4-4B30-B89F-F54661D6417F']")
    private WebElement totalTimeEncounterBox;

    @FindBy (xpath = "//input[@id='btnSave']")
    private WebElement saveBtn;

    @FindBy(xpath = "//table[@id='datatable']//tr[1]/td[3]")
    private WebElement chiefComplaint;

    public void SelectANote(String FollowUpNote){
        Select select= new Select(selectANoteDropdown);
        select.selectByVisibleText(FollowUpNote);
    }
    public void clickGo(){
        BrowserUtils.wait(3);
        BrowserUtils.clickOnElement(goButton);
        System.out.println("clicking on GO button");
    }
    public void ViewFullScreen(){
        BrowserUtils.clickOnElement(viewFullScreenButton);
        //JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        //js.executeScript("window.scrollBy(0,600)");
        BrowserUtils.scrollDown(600);
    }
    public void SelectPrimaryChiefComplaint(){
        Select select= new Select(primaryChiefComplaintDropdown);
        select.selectByIndex(1);
        BrowserUtils.scrollDown(200);
    }
    public void IntervalHistory(String word){

        BrowserUtils.enterText(intervalHistoryBox,word);
    }
    public void IntervalExam(String word){
        BrowserUtils.enterText(intervalExamBox,word);

        BrowserUtils.scrollDown(200);
    }
    public void DiagnosisAssessment(String Code){

        BrowserUtils.enterText(assessmentTextBox,Code);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);
        wait.until(ExpectedConditions.visibilityOf(greenPlusButton));
        BrowserUtils.clickOnElement(greenPlusButton);
    }
    public void checkbox(){
        BrowserUtils.clickOnElement(checkBox);
        BrowserUtils.scrollDown(200);
    }
    public void Entertext_assessment_planTextBox(String text){
        BrowserUtils.enterText(assessment_planTextBox,text);
        BrowserUtils.scrollDown(100);
    }
    public void SelectDisposition(){
        Select select= new Select(dispositionDropdown);
        select.selectByVisibleText("Transfer to Emergency Department");
        BrowserUtils.scrollDown(200);
    }
    public void SelectTechnologyUsered(String TextOnly){
        Select select= new Select(technologyUsedDropDown);
        select.selectByVisibleText(TextOnly);
    }
    public void TextOnlyReasonDropdown(){
        BrowserUtils.clickOnElement(textOnlyReasonDropdown);
        BrowserUtils.clickOnElement(connectivityIssue);
        BrowserUtils.scrollDown(200);
    }
    public void TotalTimeBox(){
        totalTimeEncounterBox.sendKeys("5");
    }

    public void clickSaveBtn() {
        BrowserUtils.clickOnElement(saveBtn);

    }

    public String getDateFromTable(){

        String xpathResetAllFilters = "//a[@class='btn btn-lg btn-warning btn-block']";
        BrowserUtils.scrollIntoView(xpathResetAllFilters);

        BrowserUtils.waitVisibilityOfElement(chiefComplaint);

        String text = chiefComplaint.getText();
        System.out.println("actual text of chief complaint: " + text);

        return text;


    }



}



/*
public void ClickNotifyOrder(){
        BrowserUtils.clickOnElement(NotifyTEHIOrderCheckBox);
        BrowserUtils.scrollDown(300);
    }
 */
