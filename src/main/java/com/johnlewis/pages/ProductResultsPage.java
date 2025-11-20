package com.johnlewis.pages;

import com.johnlewis.base.WebDriverBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductResultsPage extends WebDriverBase {

    private WebDriver driver;

    @FindBy(css = "[data-testid='component-grid-column'] .ProductGrid_product-grid__product__9xTwK")
    private List<WebElement> productList;

    public ProductResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ProductDetailsPage selectFirstProduct() {
        waitForResultsToLoad();
        if (productList == null || productList.isEmpty()) {
            throw new NoSuchElementException("No products found in results");
        }
        waitAndClick(productList.get(0));
        return new ProductDetailsPage(driver);
    }

    public String getProductBrandName() {
        return productList.get(0).getText();
    }

    public int getProductsResultCount() {
        waitForResultsToLoad();
        return productList == null ? 0 : productList.size();
    }

}
