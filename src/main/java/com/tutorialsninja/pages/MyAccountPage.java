package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customListeners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement accountLogoutText;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement accountCreatedText;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueBtn;

    public String getAccountLogoutText() throws InterruptedException {
        Thread.sleep(2000);
        CustomListeners.test.log(Status.PASS, "Get Account Logout text " + accountLogoutText);
        return getTextFromElement(accountLogoutText);
    }

    public String getYourAccountHasBeenCreatedText() throws InterruptedException {
        Thread.sleep(2000);
        CustomListeners.test.log(Status.PASS, "Get your Account has been created text " + accountCreatedText);
        return getTextFromElement(accountCreatedText);
    }

    public void clickOnContinueButton() throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(continueBtn);
        CustomListeners.test.log(Status.PASS, " Click on Continue button " + continueBtn);
    }
}
