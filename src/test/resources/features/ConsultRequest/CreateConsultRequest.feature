Feature: As a user I want to be able to create consult request
# this is a comment
#Background - test pre-condition
 # Given user on the log in page
  #When user logs in

#  will be executed before every scenario in the particular feature file



  @CreateConsult
  Scenario: after user able to create consult, user able to create note
    Given user on the log in page
    When user logs in
    Then user navigate to "Consult Requests" from the top most menu
    * clicks the green Add Consult Request button
    * select facility "ThirdEyeHealth - Technical Support"
    * user select any nurse, patient, chief complaint, and clinician
    * user should be able to click Create Consult Request
    * click the cancel button
    Then user should be able to see new consult request on the table, and click green Create note button