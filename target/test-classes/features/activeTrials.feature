Feature: Search for Active Trials in CTRP
  Scenario:  Search for Active Trials
    Given I click on trials menu option
    When I type active into current trial status
    Then I click on search
    Then I assert search results match search results