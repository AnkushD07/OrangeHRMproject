Feature: OrangeHRM Trial

  Scenario: Get Free Trial Demo
    Given open Browser and launch "https://www.orangehrm.com/" site
    Then "OrangeHRM" Title should displayed
    Then fill "info.anku527@gmail.com" mail id
    And click on Get A Free Trial
    Then Registeration page should displayed
    Given Fill "ankushd1234" site in site field
    And Fill "Ankush Dongre" in full name field
    And add phone number "9145204527" in phone number field
    And select "India" country in country dropdown
    And select "Maharashtra" state dropdown
    And click on I Am not Robot
    When click on Submit
    Then "Thank you for signing up" page should displayed
