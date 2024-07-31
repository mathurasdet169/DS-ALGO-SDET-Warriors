Feature: To check the logout feature 

	Scenario: To check logout after valid login
	  Given Enter a valid username "username" in the homepage
    And Enter a valid password "password" in the homepage
    When User clicks on the Login button
    And User clicks on Logout Dropdown
    And User clicks Logout Link
    Then User logout successfully and navigate to home page