package com.thirdEyeHealth.pages.signNote;

import com.thirdEyeHealth.pages.BasePage;
import com.thirdEyeHealth.utilies.BrowserUtils;
import com.thirdEyeHealth.utilies.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignNote extends BasePage {

    @FindBy(linkText = "Notes")
    private WebElement NotesModule;

    @FindBy(xpath = "(//tbody//td[1])/a[2]")
    private WebElement reviewNote;

    @FindBy(xpath = "//input[@id='btn-sign']")
    private WebElement signButton;

    @FindBy(linkText = "Electronically signed by: Test Clinician ")
    private WebElement ElectronicSignedBy;

    @FindBy(xpath = "//table[@id='viewrecord']//tr[2]//td//div/a")
    private WebElement PtName;

    @FindBy(xpath = "//table[@id='viewrecord']//tr[3]//td//a")
    private WebElement PtNameTeleHealth;
    public void clickNote(){
        BrowserUtils.clickOnElement(NotesModule);
    }
    public void clickViewNote(){
        BrowserUtils.clickOnElement(reviewNote);
    }
    public void clickSignBtn(){
        BrowserUtils.scrollIntoView("//input[@id='btn-sign']");
        BrowserUtils.clickOnElement(signButton);
    }
    public void clickOk(){
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }
    public String getTxt(){
        BrowserUtils.wait(20);
        BrowserUtils.scrollDown(700);
        BrowserUtils.waitVisibilityOfElement(PtName);
        String text = PtName.getText();

        System.out.println(text);
        return text;
    }
    public String getTxtofTeleHealth(){
        BrowserUtils.wait(20);
        BrowserUtils.scrollDown(700);
        BrowserUtils.waitVisibilityOfElement(PtNameTeleHealth);
        String text = PtNameTeleHealth.getText();

        System.out.println(text);
        return text;
    }

}





