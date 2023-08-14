Feature: Google test Scenarios General Purpose

  Scenario Outline: [Google Search]
      1. verify cookies are clear as soon as browser is launch
  Given browser launches successfully
  And User enter "<searchCriteria>"
  And "User" clicks stay signed out option
  And "User" clicks enter to begin search
  Then Search is Verified "<searchCriteria>"

  Examples:
    | searchCriteria  |
    | Mastodon social |



    Scenario Outline: [click Mastodon Option] [log in]
      1. Once in the google search option show Mastodon option click on the link.
      2. Sing in to Mastodon using credentials
      Given browser launches successfully
      And User enter "<searchCriteria>"
      And "User" clicks stay signed out option
      And "User" clicks enter to begin search
      Then Search is Verified "<searchCriteria>"
      And mastodon social option is click
      And Log in to mastodon "<Email>" "<Password>"

      Examples:
        | searchCriteria  |
        | Mastodon social |


      Scenario Outline: [check username]
              1. verify that username is displayed properly when logged in.
              2. verify the date of the creation of the account.
        Given browser launches successfully
        And User enter "<searchCriteria>"
        And "User" clicks stay signed out option
        And "User" clicks enter to begin search
        Then Search is Verified "<searchCriteria>"
        And mastodon social option is click
        And Log in to mastodon "<Email>" "<Password>"
        And user clicks on the profile image
        And site display the right "<username>"label
        And site display the right "<joineddate>"

        Examples:
          | username  | joineddate   | searchCriteria  |
          | RudyJ5000 | Aug 06, 2023 | Mastodon social |


        Scenario Outline: [create a POST]
              1. write something  an create a post
          Given browser launches successfully
          And User enter "<searchCriteria>"
          And "User" clicks stay signed out option
          And "User" clicks enter to begin search
          Then Search is Verified "<searchCriteria>"
          And mastodon social option is click
          And Log in to mastodon "<Email>" "<Password>"
          And post something "<post>"
          Then "user" clicks publish button

          Examples:
            | post                      | searchCriteria  |
            | Hi everyone Happy to join | Mastodon social |

  @test
  Scenario Outline: [Delete a POST]
              1. delete the last post created
          Given browser launches successfully
          And User enter "<searchCriteria>"
          And "User" clicks stay signed out option
          And "User" clicks enter to begin search
          Then Search is Verified "<searchCriteria>"
          And mastodon social option is click
          And Log in to mastodon "<Email>" "<Password>"
          And post something "<post>"
          Then "user" clicks publish button
          Then Post is deleted

          Examples:
            | searchCriteria  | post                      |
            | Mastodon social | Hi everyone Happy to join |
