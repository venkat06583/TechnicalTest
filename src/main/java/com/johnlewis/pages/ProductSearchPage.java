package com.johnlewis.pages;

import com.johnlewis.base.WebDriverBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSearchPage extends WebDriverBase {

    private WebDriver driver;
    @FindBy(name = "search-term")
    private WebElement searchBox;
    @FindBy(css = ".search-input-glassIconContainer--2cd0b")
    private WebElement enableSearchOption;
    @FindBy(id = "facet-search-Brand")
    private WebElement filerSearch;
    @FindBy(css = "details:nth-child(6) .option_c-option__label__Y3_qx.option_c-option__label--checkbox__kWJvN")
    private WebElement brandCheckBox;


    public ProductSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchProduct(String productName) {
        waitAndClick(enableSearchOption);
        searchBox.sendKeys(productName);
        searchBox.sendKeys(Keys.ENTER);
        waitForResultsToLoad();
    }

    public ProductResultsPage filterProductsByBrandName(String brandName) {
        filerSearch.sendKeys(brandName);
        waitAndClick(brandCheckBox);
        waitForResultsToLoad();
        return new ProductResultsPage(driver);
    }

}
