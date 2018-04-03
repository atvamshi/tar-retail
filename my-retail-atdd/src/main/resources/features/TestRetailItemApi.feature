@USTestRetail
Feature: A feature to test the RESTful service that can retrieve product and price details by ID

  Scenario Outline: This Scenario will test the get one item of the item API
    Given I consume the Get Item API with "<Item_ID>" and I would expect Item_Name as "<Item_Name>" and Item_Price is "<Item_Price>" and Item_Currency_Type is "<Item_Currency_Type>"

    Examples:
      | Item_ID        | Item_Name                     | Item_Price | Item_Currency_Type |
      | 16696652       | Beats Solo 2 Wireless - Black | 9000       | USD                |
      | 000000         | null                          | null       | null               |
      | 13860428       | The Big Lebowski (Blu-ray)    | 2000       | USD                |
      | 16483589       | null                          | null       | null               |
      | 15117729       | null                          | null       | null               |
      | 13860428       | The Big Lebowski (Blu-ray)    | 2000       | USD                |
      | 16752456       | null                          | null       | null               |
      | 16696652       | Beats Solo 2 Wireless - Black | 9000       | USD                |
      | 15643793       | null                          | null       | null               |
      | efe            | null                          | null       | null               |
      | 15643334kj3793 | null                          | null       | null               |
      | (              | null                          | null       | null               |