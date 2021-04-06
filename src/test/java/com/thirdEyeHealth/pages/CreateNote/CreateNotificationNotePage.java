package com.thirdEyeHealth.pages.CreateNote;

import com.thirdEyeHealth.pages.BasePage;
import com.thirdEyeHealth.utilies.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateNotificationNotePage extends BasePage {

    @FindBy(xpath = "//select[@id='ddlConsultForms']" )
    private WebElement selectANoteDropdown;

    @FindBy(xpath = "//input[@id='btnNonBillableAlertOK']")
    private WebElement okBtn;

    @FindBy(xpath = "//input[@value='Go']" )
    private WebElement GoButton;

    @FindBy(xpath = "//select[@name='ddl598BCA31-0103-43F7-91CF-7595234A9791']")
    private WebElement primaryChiefComplaint;

    @FindBy(xpath = "//textarea[@name='13DE25F8-B1C4-4AB5-9516-63A49C8CA8A5']")
    private WebElement chiefComplaint_addDetailBox;

    @FindBy(xpath = "//textarea[@id='D76332A6-E54B-4602-9EFA-19E9506F613D']")
    private WebElement summaryBox;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement notifyTEHCheckBox;

    @FindBy(xpath = "//select[@id='ddl145EC8A8-113C-4C15-AA1D-68CEF44896EE']")
    private WebElement dispositionDropdown;

    @FindBy(xpath = "//select[@id='ddlA89A051B-A05A-467B-9282-0FFB35CB7B4F']")
    private WebElement technologyUsed;

    @FindBy(xpath = "//table[@id='datatable']//tr[1]/td[3]")
    private WebElement chiefComplaitData;

    public void clickOk() {
        BrowserUtils.wait(3);
        BrowserUtils.clickOnElement(okBtn);
    }
    public void selectPrimaryChComplaint(){
        Select select = new Select(primaryChiefComplaint);
        select.selectByIndex(3);
        BrowserUtils.scrollDown(200);
    }

    public void textChComplaint_addDetailBox(String word){

        BrowserUtils.enterText(chiefComplaint_addDetailBox,word);
    }
    public void textSummaryBox(String word){
        BrowserUtils.enterText(summaryBox,word);
        BrowserUtils.scrollDown(100);
    }
    public void clickTEH_checkBox(){
        BrowserUtils.clickOnElement(notifyTEHCheckBox);
        BrowserUtils.scrollDown(200);
    }
    public void selectDispositionDropdown(String Stay_at_Facility){
        Select select = new Select(dispositionDropdown);
        select.selectByVisibleText(Stay_at_Facility);
        BrowserUtils.scrollDown(200);

    }

    public void selectTechnologyUsedDropdown(String Telephone){
        Select select= new Select(technologyUsed);
        select.selectByVisibleText(Telephone);

    }
    public String getDateFromTable(){

        String xpathResetAllFilters = "//a[@class='btn btn-lg btn-warning btn-block']";
        BrowserUtils.scrollIntoView(xpathResetAllFilters);

        BrowserUtils.waitVisibilityOfElement(chiefComplaitData);

        String text = chiefComplaitData.getText();
        System.out.println("actual text of chief complaint is " + text);

        return text;


    }






}
