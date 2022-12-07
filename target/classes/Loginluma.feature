@SmokeTest
Feature: Login function Test

@TC_1234
Scenario: As a Luma application user, must do successful login with valid credential.
Given open any browser
And go to application URL
When click sign in button
And put email
And put password
And click second sign in button
Then validated login was succcessful 