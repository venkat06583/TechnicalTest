package com.johnlewis.stepdefinitions;

import com.johnlewis.base.WebDriverBase;
import com.johnlewis.pages.ProductDetailsPage;
import com.johnlewis.pages.ProductResultsPage;
import com.johnlewis.pages.ProductSearchPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductSearchStepDef {

    private WebDriver driver;
    private ProductSearchPage productSearchPage;
    private ProductResultsPage productResultsPage;
    private ProductDetailsPage productDetailsPage;
    private int previousBasketCount = 0;

    @Before
    public void setup() {
        driver = WebDriverBase.initialBrowser();
        productSearchPage = new ProductSearchPage(driver);
        productResultsPage = new ProductResultsPage(driver);
    }

    @When("the user searches for {string}")
    public void the_user_searches_for(String productName) {
        productSearchPage.searchProduct(productName);
    }

    @When("the user applies the brand filter {string}")
    public void the_user_applies_the_brand_filter(String brandName) {
        productResultsPage = productSearchPage.filterProductsByBrandName(brandName);
    }

    @Then("the search results are filtered by brand {string}")
    public void the_search_results_are_filtered_by_brand(String brandName) {
        assertTrue(productResultsPage.getProductsResultCount() > 0);
        assertTrue(productResultsPage.getProductBrandName().contains(brandName));

    }

    @Then("the user selects the first product from the results")
    public void the_user_selects_the_first_product_from_the_results() {
        productDetailsPage = productResultsPage.selectFirstProduct();
    }

    @Then("the product details page should be displayed")
    public void the_product_details_page_should_be_displayed() {
        assertTrue(productDetailsPage.isProductPageDisplayed());
    }

    @When("the user adds the product to the cart")
    public void the_user_adds_the_product_to_the_cart() {
        previousBasketCount = productDetailsPage.getProductCountInBasket();
        productDetailsPage.addProductToBasket();
    }

    @Then("the cart count should increase by {int}")
    public void the_cart_count_should_increase_by(Integer productCount) {
        assertEquals(previousBasketCount + productCount, productDetailsPage.getProductCountInBasket());
    }


    @After
    public void tearDown() {
        WebDriverBase.close();
    }

}



