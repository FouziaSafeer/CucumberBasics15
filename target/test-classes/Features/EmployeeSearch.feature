Feature: Searching the employee

  Background:
    #this is used to define all the common steps that multiple secarios have
    #int the same feature file, till the time flow is not broken
    When user enters valid user name and password
    And click on login button
    When user click on PIM option
@smoke1
  Scenario: Search Employee by ID
   # Given open the browser and launch HRMS application
    #When user enters valid user name and password
    #And click on login button
    #When user click on PIM option
    When user enters valid employee id
    And Clicks on search button
    And user see employee information is displayed
 # And close the browser

  @smoke1
  Scenario: Search Employee by Job Title
  #  Given open the browser and launch HRMS application
   # When user enters valid user name and password
    #And click on login button
    #When user click on PIM option
    When user select Job Title
    And Clicks on search button
    And user see employee information is displayed
    #And close the browser

