package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customListeners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement laptopsAndNotebooksText;
    By productsPrices = By.xpath("//p[@class ='price']");
    By productsList = By.xpath("//h4/a");
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortBy;

    public String getLaptopsAndNotebooksText() throws InterruptedException {
        Thread.sleep(2000);
        CustomListeners.test.log(Status.PASS, "Get Laptops and Notebooks text " + laptopsAndNotebooksText);
        return getTextFromElement(laptopsAndNotebooksText);
    }

    public ArrayList<Double> getProductsPriceList() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> products = getListOfElements(productsPrices);
        ArrayList<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        return originalProductsPrice;
    }

    public void selectSortByOption(String option) throws InterruptedException {
        Thread.sleep(2000);
        selectByVisibleTextFromDropDown(sortBy, option);
        CustomListeners.test.log(Status.PASS, "Select sort by option " + sortBy);
    }

    public void selectProductByName(String product) throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> products = getListOfElements(productsList);
        for (WebElement e : products) {
            if (e.getText().equals(product)) {
                e.click();
                break;
            }
        }
    }


}
