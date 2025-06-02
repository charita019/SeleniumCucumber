Feature: Sauce Labs Demo Login Functionality
User should be able to login to access the application features

Background: 
Given User is on the login page

Scenario: Login Using Valid User Credentials
When User enters valid username "standard_user"
And User enters valid password "secret_sauce"
And User clicks on Login Button
Then User is navigated to Swag Labs page


Scenario Outline: Login using multiple users
When User enters valid username "<username>"
And User enters valid password "<password>"
And User clicks on Login Button
Then User is navigated to Swag Labs page

Examples:
| username      | password     |
| visual_user   | secret_sauce |
| standard_user | secret_sauce |

Scenario Outline: Login using invalid credentials
When User enters username "<username>"
And User enters password "<password>"
And User clicks on Login Button
Then User is not logged in and gets message as "<error_message>"

Examples:
| username        | password     | error_message                                                             |
| test1234        | test1234     | Epic sadface: Username and password do not match any user in this service |
| locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out.                       |
| standard_user   | 1234         | Epic sadface: Username and password do not match any user in this service |
| test1234        | secret_sauce | Epic sadface: Username and password do not match any user in this service |
| STANDARD_USER   | SECRET_SAUCE | Epic sadface: Username and password do not match any user in this service |

Scenario: Login without providing any credentials
When User does not enter any credentials
And User clicks on Login Button
Then User is not logged in and gets required field validation "Epic sadface: Username is required"

Scenario: Check required field validation is coming correctly for password field
When User enters valid username "standard_user"
But User leave password field blank
And User clicks on Login Button
Then User is not logged in and gets required field validation "Epic sadface: Password is required"

Scenario: Tab and Enter keys work on the login form
When User enters valid username "standard_user"
And User presses TAB key
And User enters valid password "secret_sauce"
And User presses TAB key
And User presses ENTER key
Then User is navigated to Swag Labs page

# Scenario: Navigate into application after logout using browser back Button
# When User enters valid username "standard_user"
# And User enters valid password "secret_sauce"
# And User clicks on Login Button
# And User is navigated to Swag Labs page
# And User clicks on logout link
# And User clicks on browser back Button
# Then User should not be logged in and get message as "Epic sadface: You can only access '/inventory.html' when you are logged in."
