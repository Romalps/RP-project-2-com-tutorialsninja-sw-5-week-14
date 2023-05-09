package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customListeners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AccountLoginPage extends Utility {


    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/div/div[2]//h2")
    WebElement returningCustomerText;
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/div/div[1]//h2")
    WebElement newCustomerText;
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailAddressField;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement loginBtn;

    public String getReturningCustomerText() throws InterruptedException {
        Thread.sleep(2000);
        CustomListeners.test.log(Status.PASS, "Get Returning Customer Text " + returningCustomerText);
        return getTextFromElement(returningCustomerText);

    }

    public String getNewCustomerText() throws InterruptedException {
        Thread.sleep(2000);
        CustomListeners.test.log(Status.PASS, "Get New Customer text " + newCustomerText);
        return getTextFromElement(newCustomerText);
    }

    public void enterEmailAddress(String email) throws InterruptedException {
        Thread.sleep(2000);
        sendTextToElement(emailAddressField, email);
        CustomListeners.test.log(Status.PASS, "Enter Email Address " + emailAddressField);
    }

    public void enterPassword(String password) throws InterruptedException {
        Thread.sleep(2000);
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS, "Enter Password " + passwordField);
    }

    public void clickOnLoginButton() throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(loginBtn);
        CustomListeners.test.log(Status.PASS, "Click On Login button " + loginBtn);
    }

}
