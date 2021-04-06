package com.thirdEyeHealth.pages;

import com.thirdEyeHealth.utilies.BrowserUtils;
import com.thirdEyeHealth.utilies.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "loginLink")
    private WebElement signWithNonTeh;

    @FindBy(id = "i0116")
    private WebElement emailInput;

    @FindBy(id = "idSIButton9")
    private WebElement nextButton;

    @FindBy(id="i0118")
    private WebElement passwordInput;

    @FindBy(xpath="//input[@value='Sign in']")
    private WebElement signInButton;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement checkBox;

    @FindBy(xpath = "//input[@value='Yes']")
    private WebElement yesButton;




    public void login() {

        signWithNonTeh.click();

        String usernameValue = ConfigurationReader.getProperty("user");
        String passwordValue = ConfigurationReader.getProperty("pass");

        emailInput.sendKeys(usernameValue);
        nextButton.click();
        BrowserUtils.wait(3);



        passwordInput.sendKeys(passwordValue);
        signInButton.click();
        BrowserUtils.wait(3);

        checkBox.click();
        yesButton.click();

    }

}

