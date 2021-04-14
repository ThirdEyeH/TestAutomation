package com.thirdEyeHealth.utilies;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {
    private static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);

    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clickOnElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static void clickWithJS(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        ((JavascriptExecutor) (Driver.getDriver())).executeScript("arguments[0].click()", element);
    }

    public static void enterText(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
//        wait.until(ExpectedConditions.attributeToBe(element, "value", text));
        BrowserUtils.wait(1);
        System.out.println("Entering text: " + text);
    }

    public static void waitVisibilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * For instance, selenium webdriver is trying to enter the text:
     * Expected text input  actual text input
     *
     * [java is great] --> [java is g]
     *
     * for some reason, selenium jumps to the next step without finishing text input here
     *
     * to prevent this issue, we need to make it wait until text is completely entered.
     *
     * How to do that?
     *
     * As we know, text is stored in the value attribute. So we need to wait until value attribute
     * of the element will obtain expected text.
     */

    public static void scrollDown(int pixelNum){

        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript("window.scrollBy(0,"+ pixelNum + ")");
    }

    public static void scrollIntoView(String xpathLocator) {

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator)));
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);

    }
    public static void acceptBrowserAlert(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    //this is method to decline browser alert.
    public static void declineBrowserAlert(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    // get alert text
    public static String getBrowserAlertText(WebDriver driver){
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            return alertText;
        } catch (Exception e) {
            System.out.println("no browser alert showing");
        }
        return null;
    }
}


