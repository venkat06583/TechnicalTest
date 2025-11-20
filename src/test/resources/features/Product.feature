@Product
Feature: Product - Search, Filter and Add to Cart

  @ProductSearch
  Scenario: Search for a product and filter by brand
    When the user searches for "Laptops"
    And the user applies the brand filter "Apple"
    Then the search results are filtered by brand "Apple"
    And the user selects the first product from the results
    Then the product details page should be displayed
    When the user adds the product to the cart
    Then the cart count should increase by 1

  @AddProduct
  Scenario Outline: Add products to cart and check the count
    When the user searches for "<productName>"
    And the user selects the first product from the results
    And the user adds the product to the cart
    Then the cart count should increase by 1

    Examples:
      | productName     |
      | electric kettle |
      | toaster         |
      | hand blender    |
