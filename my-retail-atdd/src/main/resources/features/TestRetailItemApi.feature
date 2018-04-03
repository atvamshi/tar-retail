@USTestRetail
Feature: A feature to test the RESTful service that can retrieve product and price details by ID

  @TestGetOneItem
  Scenario Outline: This Scenario will test the get one item of the item API
    Given I consume the Get Item API with "<Item_ID>" and I would expect Item_Name as "<Item_Name>" and Item_Price is "<Item_Price>" and Item_Currency_Type is "<Item_Currency_Type>"

    Examples:
      | Item_ID | Item_Name | Item_Price | Item_Currency_Type |
      |         |           |            |                    |