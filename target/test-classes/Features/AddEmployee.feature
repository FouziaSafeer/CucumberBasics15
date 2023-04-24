Feature: Add  Employee
  @testcase2 @smoke
  Scenario: Adding a new Employee
  #  Given open the browser and launch HRMS application
    When user enters valid user name and password
    And click on login button
    When user click on PIM option
    And user clicks on add employee button
    And user enters firstname and middlename and lastname
    And user clicks on save button
   # And close the browser

