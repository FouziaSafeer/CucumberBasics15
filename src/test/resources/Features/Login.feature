Feature: Login Functionalities
  @smoke
  Scenario: Valid Admin login
    #Given open the browser and launch HRMS application
    When user enters valid user name and password
    And click on login button
    Then user is logged in successfully



  @smoke2
  Scenario: Valid Admin login
    #Given open the browser and launch HRMS application
    When user enters valid "ADMIN" and "Hum@nhrm123"
    And click on login button
    Then user is logged in successfully

  #if you want to use parameterization
  @scenarioOutline
  #parameteriztion/Data Driven
  Scenario Outline: Login with multiple credentials using Scenario Outline
   #Given open the browser and launch HRMS application
    When user enters valid "<username>" and "<password>"
    And click on login button
    Then user is logged in successfully
    #Close the browser
  Examples:
  |username | password |
  | admin   | Hum@nhrm123|
  |ADMIN    | Hum@nhrm123 |
  |Jason    |Hum@nhrm123  |
  #data table
  @dataTable
  Scenario: Login with multiple credentials using data table
    When user enters username and password and verifies login
      | username | password    |
      | admin    | Hum@nhrm123 |
      | ADMIN    | Hum@nhrm123 |
      | Jason    | Hum@nhrm123 |










     #-----------------Cucumber itself provides multiple option through which we can feed data from
   # feature file into Step Definition---------------------------------------------
   #3. Regular Expressions
       # put the data in double quotes [""]
   #4. Scenario Outline
       # Provides you an alternative to Data driven testing
       # Also supports parametrization








   # And close the browser
    # TO ADD COMMENT
  #hooks: opening and closing browser pre n post steps in cucumber framework
  #always in step definition folder
  # this class cannot be inherted, hooks will take care of pre n post condition
  #HOOKS: For defining pre and Post steps in any Cucumber framework
        #     : This is always created inside the StepDefinitions folder
        #     : Hooks will take care of pre and post conditions irrespective
        #     : of what goes in between the test steps

        #BACKGROUND: Its the clubbing of common steps in different scenarios of a feature file
        #             till flow is not broken
        #1. Hard Code
        #2. Config file
        #-----------------Cucumber itself provides multiple option through which we can feed data from
        # feature file into Step Definition---------------------------------------------
        #3. Regular Expressions
        # put the data in double quotes [""]
   #===================================PARAMETERIZATION================================
  # Executing the same test case with multiple data