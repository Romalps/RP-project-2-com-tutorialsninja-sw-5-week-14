package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customListeners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement shoppingCartText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productName;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")
    WebElement deliveryDate;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[3]")
    WebElement model;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement total;
    @CacheLookup
    @FindBy(xpath = "//input[contains(@name, 'quantity')]")

    WebElement qtyField;
    @CacheLookup
    @FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")

    WebElement qtyUpdateBtn;
    @CacheLookup
    @FindBy(xpath = "//div[@id='checkout-cart']/div[1]")
    WebElement successModifiedMessage;

    public String getShoppingCartText() throws InterruptedException {
        Thread.sleep(2000);
        CustomListeners.test.log(Status.PASS, "Get Shopping cart text " + shoppingCartText);
        return getTextFromElement(shoppingCartText);
    }

    public String getProductName() throws InterruptedException {
        Thread.sleep(2000);
        CustomListeners.test.log(Status.PASS, "Get Product name " + productName);
        return getTextFromElement(productName);
    }

    public String getDeliveryDate() throws InterruptedException {
        Thread.sleep(2000);
        CustomListeners.test.log(Status.PASS, "Get Delivery date " + deliveryDate);
        return getTextFromElement(deliveryDate);
    }

    public String getModel() throws InterruptedException {
        Thread.sleep(2000);
        CustomListeners.test.log(Status.PASS, "Get model " + model);
        return getTextFromElement(model);
    }

    public String getTotal() throws InterruptedException {
        Thread.sleep(2000);
        CustomListeners.test.log(Status.PASS, "Get total " + total);
        return getTextFromElement(total);
    }

    public void changeQuantity(String qty) throws InterruptedException {
        Thread.sleep(2000);
        sendTextToElement(qtyField, qty);
        CustomListeners.test.log(Status.PASS, "Change quantity " + qtyField);
    }

    public void clickOnQtyUpdateButton() throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(qtyUpdateBtn);
        CustomListeners.test.log(Status.PASS, " Click on qty update button " + qtyUpdateBtn);
    }

    public String getSuccessModifiedMessage() throws InterruptedException {
        Thread.sleep(2000);
        CustomListeners.test.log(Status.PASS, "Get success modified message " + successModifiedMessage);
        return getTextFromElement(successModifiedMessage);
    }
}
