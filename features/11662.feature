@11662
Feature: 11662
 
  
  Scenario: 11662
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with proper login
   Then Generate_Safety_Acknowledgement_Status_Tracking_Report
   Then Verify_Fields
   Then Enter_all_data_generate_report
   Then Verify_mentionedfield
   #Then Verify_fields_sortable
   Then Verify_No_Column
   Then Verify_Thereputicarea_Column
   Then Verify_compound_Column
   Then Verify_studyid_Column
   Then Verify_country_Column
   Then Verify_studysite_Column
   Then Verify_documentname_Column
   Then Verify_acknowledgementstatus_Column
   Then Verify_acknowledgementmode_Column
   Then Verify_dataacknowledgement_Column
   Then Verify_acknowlededgebysiteuserrole_Column
   Then Verify_acknowlededgebysiteusername_Column
   Then Verify_facilityname_Column
   Then Verify_daterecievedbysiteA_Column
   Then Verify_SponsorreceiveddateB_Column
   Then Verify_Duration
   Then Verify_safety_notification_reportdate
   Then Verify_susar_subtype
   Then Verify_Initial_SUSAR_distributed_outside_system
   Then Verify_Reporting_Timeline
   Then Verify_manufracture_report_number
   Then Verify_sposor_version_number
   Then Logout from Application
   
   

 