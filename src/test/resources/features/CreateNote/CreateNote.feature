Feature: As a clinician I want to be able to create note
# this is a comment
#Background - test pre-condition

#  will be executed before every scenario in the particular feature file



  @CreateFollowUpNote
  Scenario: when clinician login with valid credential, user able to create consult and fullow up note
    Given user on the log in page
    When user logs in
    Then user navigate to "Consult Requests" from the top most menu
    * clicks the green Add Consult Request button
    * select facility "ThirdEyeHealth - Technical Support"
    * user select any nurse, patient, chief complaint, and clinician
    * user should be able to click Create Consult Request
    * click the cancel button
    Then user should be able to see new consult request on the table, and click green Create note button
    * user select "Follow up note" from the Select a NoteType menu
    And clicks the green Go button, user able to see Create Note form
    * click view side by side button
    * user select any from chief complaint
    * enter any on interval History and interval exam box
      | Interval History |  Testing  |
      | Interval Exam    |  Testing  |
    * enter "A4159" on Diagnosis, Assessment Plan then click green + button
    * click A4159- Other - Gram negative sepsis radio button
    * enter "Testing" on assessment plan box
    * select any from Disposition
    * select "Text Only" from Technology Used
    * select any form Text Only Reason dropdown
    * enter any number on Total time of encounter including connectivity box
    * click the save button
    * Then user verifies that new note is displayed



   #* click Notify TEH of any change in condition radio button
   #
   #
     # *
    #*
    #Then user should be able to see view note available on the table
 #

  #
  #
 # * on the Vital Signs box enter
 #      | T: 98
 #      | BP:
 #      | HR:
 #      | RR:
 #      | SpO2: