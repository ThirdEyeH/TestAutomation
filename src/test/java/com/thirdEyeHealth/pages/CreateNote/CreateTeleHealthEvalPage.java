package com.thirdEyeHealth.pages.CreateNote;

import com.thirdEyeHealth.pages.BasePage;
import com.thirdEyeHealth.utilies.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateTeleHealthEvalPage extends BasePage {

    //@FindBy(xpath = "//select[@id='ddl598BCA31-0103-43F7-91CF-7595234A9791']")
   private WebElement primaryChiefComplaintDropdown;

    @FindBy(xpath = "//div/textarea[@id='13DE25F8-B1C4-4AB5-9516-63A49C8CA8A5']")
    private WebElement chiefComplaintBox;

    @FindBy(xpath = "//textarea[@name='6BE9F966-99EE-4A9A-AE45-7FC95961C9A3']")
    private WebElement historyPresentIllnessBox;

    @FindBy(xpath = "//select[@id='ddl_1162BA0C-DD46-496B-AFE1-B5B24FDF3611_0']")
    private WebElement reviewOfSystemDropdown;

    @FindBy(css = "input[id='9948DDF4-4E2F-46B3-A67C-18456EAD1993']")
    private WebElement externalEHRchB;

    @FindBy(css = "select[id='ddlD299002E-C7E3-4DD6-9258-16484A9AEFC7']")
    private WebElement physicalExamDropD;

    @FindBy(css = "textarea[id='3915E7FA-1C8F-4019-AF50-C496F15D36D4']")
    private WebElement examFidingPerNursebx;

    @FindBy(css = "textarea[id='03D5881D-944C-49EC-8DB3-B857FE567998']")
    private WebElement diagnosticResultBx;


    @FindBy(xpath = "//input[@id='ddl2D76BFB8-9594-4347-80EF-466A594F4825']")
    private WebElement diagnosis_assessmentPlanBx;

    @FindBy(css = "input[id='notifyOrders']")
    private WebElement TEHcheckBx;


    @FindBy(css = "input[name='29EE3555-884D-456E-B2DE-8BA7A773A6FF']")
    private WebElement phoneVisitOnlyBx;

    @FindBy(xpath = "//table[@id='datatable']//tr[1]/td[5]")
    private WebElement datatableDT;


    public void setPrimaryChiefComplaintDropdown(String name){
        Select select= new Select(primaryChiefComplaintDropdown);
        select.selectByVisibleText(name);

    }
    public void enterTextToChiefComlaintBx(String word){
        BrowserUtils.enterText(chiefComplaintBox,word);
        BrowserUtils.scrollDown(100);
    }
    public void enterTextToHistoryPresentIllBx(String word){
        BrowserUtils.enterText(historyPresentIllnessBox, word);
    }

    public void selectReviewOfSysDropD(){

        Select select =new Select(reviewOfSystemDropdown);
        select.selectByIndex(2);
        BrowserUtils.scrollDown(200);
    }
    public void checkExternalEHRBx(){
        BrowserUtils.clickOnElement(externalEHRchB);
    }
    public void selectphysicalExamDropD(String ExamFindingSperNurse){
        Select select = new Select(physicalExamDropD);
        select.selectByVisibleText(ExamFindingSperNurse);
    }

    public void enterExamFindingPerNurseBx(String word) {
        BrowserUtils.enterText(examFidingPerNursebx, word);

    }
    public void enterDiagnosticResultBx(String word){
        BrowserUtils.enterText(diagnosticResultBx,word);
        BrowserUtils.scrollDown(100);
        BrowserUtils.wait(30);
    }


    public void clickTEHBx(){
        BrowserUtils.clickOnElement(TEHcheckBx);
    }
    public void enterTxPhoneVisitOnly(){
        BrowserUtils.enterText(phoneVisitOnlyBx,"2");
    }
    public String getData(){
        String xpathResetAllFilters = "//a[@class='btn btn-lg btn-warning btn-block']";
        BrowserUtils.scrollIntoView(xpathResetAllFilters);
        BrowserUtils.waitVisibilityOfElement(datatableDT);

        String text = datatableDT.getText();
        System.out.println("actual text of Note type : "+text);

        return text;

    }




    /*
     public String getDateFromTable(){



        BrowserUtils.waitVisibilityOfElement(chiefComplaitData);

        String text = chiefComplaitData.getText();
        System.out.println("actual text of chief complaint is " + text);

        return text;


    }

     */


}
