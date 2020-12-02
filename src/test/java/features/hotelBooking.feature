Feature: This feature will test the hotel booking functionality with customised details

Scenario: Hotel Booking at Trivago

Given I am on the trivago homepage
Then I click on the Login button and wait for sign in page
When I enter the valid email address
And I click on next button
And I enter the valid password
And click on the Register button
And  I search for Goa destination
And  I select the checkin and checkout dates
When  I select the Adults count and search
Then I see Azaya Beach goa hotel is listed or not
And I click on View Deal and see availability
When I select villa with the customised options
Then I will reserve the villa and enter personal details
And I will finalise the details