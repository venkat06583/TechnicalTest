package com.johnlewis.pages;

import com.johnlewis.base.WebDriverBase;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProductDetailsPage extends WebDriverBase {

    private WebDriver driver;

    @FindBy(css = "[data-testid='product:title:content']")
    private WebElement productTitle;

    @FindBy(id = "minibasket-icon-anchor")
    private WebElement productCountInBasket;

    @FindBy(id = "basket:add:button")
    private WebElement addToBasket;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isProductPageDisplayed() {
        return waitForVisibility(productTitle).isDisplayed();
    }

    public void addProductToBasket() {
        waitForVisibility(addToBasket);
        scrollToElementAndClick(addToBasket);
    }

    public int getProductCountInBasket() {
        waitForVisibility(productCountInBasket);
        try {
            TimeUnit.SECONDS.sleep(5);
            String basketText = getTextUsingJS(productCountInBasket).replaceAll("[^0-9]", "");
            return basketText.isEmpty() ? 0 : Integer.parseInt(basketText);
        } catch (Exception e) {
            return 0;
        }
    }


}
