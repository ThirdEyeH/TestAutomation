
Feature: As a clinician I want to be able to create note

  @CreateTelehealthEvaluationNote
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
    * user select "Telehealth Evaluation" from Select of Note Type menu
    And clicks the green Go button, user able to see Create Note form
    * click view side by side button
    * user select any from primary chief complaint
    * enter any on Chief Complaint and History Present Illness box
      | Chief Complaint - Additional Details |  Testing  |
      | History Present Illness*    |  Testing  |
    * select any from review of system menu
    * click External EHR from Source of verification for all history*
    * select "Exam findings per nurse" from Physical Exam dropdown
    * enter any on Exam findings per nurse, Diagnostic Results boxs
      |  Exam findings per nurse             |  Not found     |
      |  Diagnostic Results and Diagnosis    |  test result   |
    * enter "A4159" on Diagnosis, Assessment Plan then click green + button
    * click A4159- Other - Gram negative sepsis radio button
    * click Notify TEH checkBox
    * select "Stay at Facility" from Disposition dropdown
    * select "Telephone" from Technology used menu
    * enter any number on phone visit only box
    * enter any number on Total time of encounter including connectivity box
    * click the save button
    Then user should see new note is displayed


#