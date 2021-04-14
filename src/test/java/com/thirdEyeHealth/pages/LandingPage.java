package com.thirdEyeHealth.pages;

import com.thirdEyeHealth.utilies.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LandingPage extends BasePage{


    @FindBy(id = "reqPermissionBtn")
    private WebElement requestPermissionButton;

    @FindBy(id = "btnAddConsultRequest")
    private WebElement addConsultRequestButton;

    @FindBy(css="select[id='ddlchatuserfacility']")
    private WebElement selectFacilityDropdown;

    @FindBy(xpath = "//table[@id='chatusers']//tr[1]/td[1]/label")
    private WebElement selectNurse;

    @FindBy(xpath = "//table[@id='patients']//tr[3]/td[1]/label")
    private WebElement selectPatient;

    @FindBy(xpath = "//select[@id='ddlchiefcomplaints']")
    private WebElement selectCheifComplaint;

    @FindBy(xpath = "//select[@id='ddlclinician']")
    private WebElement selectClinician;

    @FindBy(xpath = "//input[@id='btnCreateConsultRequest']")
    private WebElement createConsultRequestButton;

    @FindBy(xpath = "//div[@class='allownotificationsClass']/button[1]")
    private WebElement cancelButton;

    @FindBy(xpath = "//tbody//tr[1]//td[1]//input[@value='Create Note']")
    private WebElement CreateNoteButton;



    public void clickAddConsultRequest(){
        requestPermissionButton.click();
        BrowserUtils.clickOnElement(addConsultRequestButton);
    }
    public void selectFacility(String facilityName){

        Select select= new Select(selectFacilityDropdown);
        select.selectByVisibleText(facilityName);

    }
    public void selectNurse(){
        BrowserUtils.clickOnElement(selectNurse);

    }
    public void selectPt(){
        BrowserUtils.clickOnElement(selectPatient);
    }
    public void setCheifComplaint(){
        Select select= new Select(selectCheifComplaint);
        select.selectByIndex(1);
    }
    public void selectClinician(){
        Select select= new Select(selectClinician);
        select.selectByVisibleText("Test Clinician");
    }
    public void clickConsultRequestButton(){
        BrowserUtils.clickOnElement(createConsultRequestButton);
    }

    public void clickCancel(){
        BrowserUtils.waitVisibilityOfElement(cancelButton);
        cancelButton.click();
    }

    public void clickCreateNoteButton(){
        CreateNoteButton.click();
        System.out.println("clicking on Create Note button");
    }
}

