Feature: To test the SidePanel Item Lists and their functiona oriented scenarios

  Background: 
    Given User Login to the application with valid username "username" and password "password"

  #Scenario: To check the toggling and opening of Main Menu when clicking Menu Icon button
  #	  When User clicks on the main menu icon button
  #	  Then SidePanel gets toggled
  #	  When User clicks on the main menu icon button
  #	  Then SidePanel gets maximized
  
  #@regression
  #Scenario: Check the list of Main menu items in the side panel body
  #	Then check the list of menu items in the side panel
  #
  #Scenario: Check the presence of OrangeHRM logo at the top of SidePanel Menu
  #	Then Check the availability of Orange HRM Log
  #	
  #	
  #Scenario Outline: Check the search box functionality
  #	When Enter one menu item "<menuitem>" in the search text box
 #	  Then Matching menu item "<menuitem>" should be displayed
  #
  #Examples:
  #| menuitem    |
  #| Admin       |
  #| PIM         |
  #| Leave       |
  #| Time        |
  #| Recruitment |
  #| My Info     |
  #| Performance |
  #| Dashboard   |
  #| Directory   |
  #| Maintenance |
  #| Claim       |
  #| Buzz        |
  
  
  Scenario Outline: Check whether clicking the menu item in the side panel opens the corresponding page
    When Menu item "<menuitem>" in the side panel is clicked the Corresponding page "<pageDisplayed>" should be displayed

    Examples: 
      | menuitem    | pageDisplayed |
      | Admin       | Admin         |
      | PIM         | PIM           |
      | Leave       | Leave         |
      | Time        | Time          |
      | Recruitment | Recruitment   |
      | My Info     | PIM           |
      | Performance | Performance   |
      | Dashboard   | Dashboard     |
      | Directory   | Directory     |
      | Claim       | Claim         |
      | Buzz        | Buzz          |
