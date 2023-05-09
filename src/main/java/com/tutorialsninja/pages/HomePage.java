package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customListeners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends Utility {

    By topMenu = By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*");

    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktopLink;
    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopsAndNotebooksLink;
    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement componentsLinks;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currencyTab;
    By currencyList = By.xpath("//ul[@class = 'dropdown-menu']/li");

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccountTab;

    By myAccountOptions = By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li");


    public void selectMenu(String menu) throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> topMenuList = getListOfElements(topMenu);
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements(topMenu);
        }
    }

    public void mouseHoverOnDesktopsLinkAndClick() throws InterruptedException {
        Thread.sleep(2000);
        mouseHoverToElementAndClick(desktopLink);
        CustomListeners.test.log(Status.PASS, "Mouse Hover on Desktops link and click " + desktopLink);
    }

    public void mouseHoverOnLaptopsAndNotebooksLinkAndClick() throws InterruptedException {
        Thread.sleep(2000);
        mouseHoverToElementAndClick(laptopsAndNotebooksLink);
        CustomListeners.test.log(Status.PASS, "Mouse Hover on Laptops and Notebooks link and click " + laptopsAndNotebooksLink);
    }

    public void mouseHoverOnComponentLinkAndClick() throws InterruptedException {
        Thread.sleep(2000);
        mouseHoverToElementAndClick(componentsLinks);
        CustomListeners.test.log(Status.PASS, "Mouse Hover on Component link and click " + componentsLinks);
    }

    public void selectCurrency(String currency) throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(currencyTab);
        List<WebElement> listOfElements = getListOfElements(currencyList);
        for (WebElement e : listOfElements) {
            if (e.getText().equalsIgnoreCase(currency)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnMyQAccountTab() throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(myAccountTab);
        CustomListeners.test.log(Status.PASS, "Click on My Account tab " + myAccountTab);
    }

    public void selectMyAccountOptions(String option) throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> myAccountList = getListOfElements(myAccountOptions);
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = getListOfElements(myAccountOptions);
        }
    }

}
