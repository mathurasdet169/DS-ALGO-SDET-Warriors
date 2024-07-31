Feature: To test the Login feature of the application

  @sanity
  Scenario: Login to the application with valid username and password
    Given Enter a valid username "username" in the homepage
    And Enter a valid password "password" in the homepage
    When User clicks on the Login button
    Then User should enter into Dashboard page succesfully

  @regression
  Scenario Outline: Login to the application with either invalid username or password
    Given Enter a invalid username "<username>" in the homepage
    And Enter a invalid password "<password>" in the homepage
    When User clicks on the Login button
    Then User should get an error message stating Invalid Credentials

    Examples: 
      | username | password |
      | Admin    | Vijee123 |
      | Vijee    | admin123 |
      | Vijee    | Vijee123 |

	@regression
  Scenario Outline: Login to the application either without username or password
    Given Enter just one either username "<username>" or password "<password>" in the homepage
    When User clicks on the Login button
    Then Required message should be displayed under the missed Credentials

    Examples: 
      | username | password |
      |          | admin123 |
      | Vijee    |          |
      |          |          |
