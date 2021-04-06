
Feature: As a clinician I want to be able to create note

@CreateNotificationNote
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
  * user select "Notification Note" from Select of Note Type menu
  * click Ok on red notification popup
  And clicks the green Go button, user able to see Create Note form
  * click view side by side button
  * user select any from primary chief complaint
  * enter any on Chief Complaint - Additional Details and Summary* box
  | Chief Complaint - Additional Details |  Testing  |
  | Summary*   |  Testing  |
  * click Notify TEH checkBox
  * select "Stay at Facility" from Disposition dropdown
  * select "Telephone" from Technology used menu
  * enter any number on Total time of encounter including connectivity box
  * click the save button
  Then user verifies that new note is displayed






#