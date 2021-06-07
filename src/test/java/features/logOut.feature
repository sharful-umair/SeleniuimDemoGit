@LogOutTest
Feature: Logout from the Application

Scenario Outline: Web Logout Test
Given Initialize the browser with chrome
And Navigate to "http://www.demo.guru99.com/V4/" site
And user enters userid <username> and password <password> and logs in
When user Logout from the application
Then verify user got successfully logout
And browser close


Examples:
|username									|password				|
|mngr332003               |dAvUrup        |