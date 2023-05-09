package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customListeners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountRegisterPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement registerAccountText;
    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstNameField;
    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastNameField;
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailField;
    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement telephoneField;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement passwordConfirmField;

    By subscribeRadios = By.xpath("//fieldset[3]//input");
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@name='agree']")
    WebElement privacyPolicyCheckBox;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@value='Continue']")
    WebElement continueBtn;

    @CacheLookup
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement loginBtn;

    public String getRegisterAccountText() throws InterruptedException {
        Thread.sleep(2000);
        CustomListeners.test.log(Status.PASS, "Get Register Account Text " + registerAccountText);
        return getTextFromElement(registerAccountText);

    }

    public void enterFirstName(String fName) throws InterruptedException {
        Thread.sleep(2000);
        sendTextToElement(firstNameField, fName);
        CustomListeners.test.log(Status.PASS, "Enter First Name " + firstNameField);
    }

    public void enterLastName(String lName) throws InterruptedException {
        Thread.sleep(2000);
        sendTextToElement(lastNameField, lName);
        CustomListeners.test.log(Status.PASS, "Enter Last name " + lastNameField);
    }

    public void enterEmail(String email) throws InterruptedException {
        Thread.sleep(2000);
        sendTextToElement(emailField, email);
        CustomListeners.test.log(Status.PASS, "Enter Email " + emailField);
    }

    public void enterTelephone(String telephone) throws InterruptedException {
        Thread.sleep(2000);
        sendTextToElement(telephoneField, telephone);
        CustomListeners.test.log(Status.PASS, "Enter Telephone Number " + telephoneField);
    }

    public void enterPassword(String password) throws InterruptedException {
        Thread.sleep(2000);
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS, "Enter Password " + passwordField);
    }

    public void enterConfirmPassword(String cPassword) throws InterruptedException {
        Thread.sleep(2000);
        sendTextToElement(passwordConfirmField, cPassword);
        CustomListeners.test.log(Status.PASS, "Enter confirm Password " + passwordConfirmField);
    }

    public void selectSubscription(String option) throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> radioButtons = getListOfElements(subscribeRadios);
        for (WebElement e : radioButtons) {
            if (e.getText().equals(option)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnPrivacyPolicyCheckBox() throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(privacyPolicyCheckBox);
        CustomListeners.test.log(Status.PASS, "Click on Privacy Policy Checkbox " + privacyPolicyCheckBox);
    }

    public void clickOnContinueButton() throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(continueBtn);
        CustomListeners.test.log(Status.PASS, "Click on Continue Button " + continueBtn);
    }

}
