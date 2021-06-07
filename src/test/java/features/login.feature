@LogInTest
Feature: Login into Application

Scenario Outline: Web Login Test
Given Initialize the browser with chrome
And Navigate to "http://www.demo.guru99.com/V4/" site
When user enters userid <username> and password <password> and logs in
Then verify user got successfully login
And browser close

Examples:
|username									|password				|
|mngr332003               |dAvUrup        |
