package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customListeners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@id = 'content']//h1")
    WebElement productText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'input-group date']//button")
    WebElement calendarButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")
    WebElement monthAndYearText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='next']")
    WebElement nextButton;
    By dateList = By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']");
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-quantity']")
    WebElement qtyField;
    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")

    WebElement addToCartButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement successMessage;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCartLink;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'input-group date']//button")
    WebElement datePicker;


    public String getProductText() throws InterruptedException {
        Thread.sleep(2000);
        CustomListeners.test.log(Status.PASS, "Get Product text " + productText);
        return getTextFromElement(productText);
    }

    public void selectDeliveryDate(String day, String month, String year) throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(datePicker);
        while (true) {
            String monthAndYear = getTextFromElement(monthAndYearText);
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(nextButton);
            }
        }
        List<WebElement> allDates = getListOfElements(dateList);
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(day)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnAddToCartButton() throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(addToCartButton);
        CustomListeners.test.log(Status.PASS, "Click on Add to Cart button " + addToCartButton);
    }

    public String getProductAddedSuccessMessage() throws InterruptedException {
        Thread.sleep(2000);
        CustomListeners.test.log(Status.PASS, "Get product added success message " + successMessage);
        return getTextFromElement(successMessage);
    }

    public void clickOnShoppingCartLinkIntoMessage() throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(shoppingCartLink);
        CustomListeners.test.log(Status.PASS, "Click on Shopping cart link into message " + shoppingCartLink);
    }

    public void enterQuantity(String qty) throws InterruptedException {
        Thread.sleep(2000);
        clearTextOnElement(qtyField);
        sendTextToElement(qtyField, qty);
        CustomListeners.test.log(Status.PASS, " Enter Quantity " + qtyField);
    }

}
