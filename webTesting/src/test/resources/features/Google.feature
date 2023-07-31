Feature: Google test Scenarios General Purpose

  Scenario Outline: [Google Search]
      1. verify cookies are clear as soon as browser is launch
  Given browser launches successfully
  And User enter "<searchCriteria>"
  And "User" clicks stay signed out option
  And "User" clicks enter to begin search
  Then Search is Verified "<searchCriteria>"

  Examples:
    | searchCriteria |
    | Latest News    |




