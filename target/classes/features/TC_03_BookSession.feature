@smoke
Feature: The user can book Consultation and Treatment sessions using a credit card or wallet

  Scenario: The user can book a consultation session with a case using a credit card
    Given the cookies popup is displayed and the user accepts it
    And the user is on the login page
    When the user enters valid credentials "Ahmed50" , "Ahmed50#"
    And The user opens virtual clinics and selects a service provider
    And The user selects a consultant session and an available time slot
    And The user selects case "Yes" , "محمد"
    When The user applies coupon "No" , "m"
    And The user toggles wallet "No"
    And The user proceeds to payment using "Card"
    And The booking should be completed successfully


  #---------------------------------------------------------
  Scenario: The user can book a consultation session using a credit card
    Given the cookies popup is displayed and the user accepts it
    And the user is on the login page
    When the user enters valid credentials "Ahmed50" , "Ahmed50#"
    And The user opens virtual clinics and selects a service provider
    And The user selects a consultant session and an available time slot
    And The user selects case "No" , "ahmed Mohammed"
    When The user applies coupon "No" , "m"
    And The user toggles wallet "No"
    And The user proceeds to payment using "Card"
    And The booking should be completed successfully


  #---------------------------------------------------------
  Scenario: The user can book a consultation session using a wallet
    Given the cookies popup is displayed and the user accepts it
    And the user is on the login page
    When the user enters valid credentials "Ahmed50" , "Ahmed50#"
    And The user opens virtual clinics and selects a service provider
    And The user selects a consultant session and an available time slot
    And The user selects case "No" , "ahmed Mohammed"
    When The user applies coupon "No" , "m"
    And The user toggles wallet "Yes"
    And The user proceeds to payment using "Wallet"
    And The booking should be completed successfully


  #---------------------------------------------------------
  Scenario: The user can book a consultation session using wallet + credit card
    Given the cookies popup is displayed and the user accepts it
    And the user is on the login page
    When the user enters valid credentials "Ahmed50" , "Ahmed50#"
    And The user opens virtual clinics and selects a service provider
    And The user selects a consultant session and an available time slot
    And The user selects case "No" , "ahmed Mohammed"
    When The user applies coupon "No" , "m"
    And The user toggles wallet "Yes"
    And The user proceeds to payment using "Wallet+Card"
    And The booking should be completed successfully


  #---------------------------------------------------------
  Scenario: The user can book a consultation session using a credit card with a coupon
    Given the cookies popup is displayed and the user accepts it
    And the user is on the login page
    When the user enters valid credentials "Ahmed50" , "Ahmed50#"
    And The user opens virtual clinics and selects a service provider
    And The user selects a consultant session and an available time slot
    And The user selects case "No" , "ahmed Mohammed"
    When The user applies coupon "Yes" , "m"
    And The user toggles wallet "No"
    And The user proceeds to payment using "Card"
    And The booking should be completed successfully


  #---------------------------------------------------------
  Scenario: The user can book a consultation session using the wallet with a coupon
    Given the cookies popup is displayed and the user accepts it
    And the user is on the login page
    When the user enters valid credentials "Ahmed50" , "Ahmed50#"
    And The user opens virtual clinics and selects a service provider
    And The user selects a consultant session and an available time slot
    And The user selects case "No" , "ahmed Mohammed"
    When The user applies coupon "Yes" , "m"
    And The user toggles wallet "Yes"
    And The user proceeds to payment using "Wallet"
    And The booking should be completed successfully


  #---------------------------------------------------------
  Scenario: The user can book a consultation session using wallet + credit card with a coupon
    Given the cookies popup is displayed and the user accepts it
    And the user is on the login page
    When the user enters valid credentials "Ahmed50" , "Ahmed50#"
    And The user opens virtual clinics and selects a service provider
    And The user selects a consultant session and an available time slot
    And The user selects case "No" , "ahmed Mohammed"
    When The user applies coupon "Yes" , "m"
    And The user toggles wallet "Yes"
    And The user proceeds to payment using "Wallet+Card"
    And The booking should be completed successfully


# Treatment session

  Scenario: The user can book a Treatment session using a credit card
    Given the cookies popup is displayed and the user accepts it
    And the user is on the login page
    When the user enters valid credentials "Ahmed50" , "Ahmed50#"
    And the user opens the virtual clinic
    And the user selects a doctor for Treatment
    And the user selects an available time slot
    And the user selects a case
    And the user proceeds to the order summary
    And the user Proceed to Pay
    And the user completes the payment on the Telr payment gateway
    Then the system should display a successful booking confirmation message


  Scenario: The user will not be able to book a Treatment session without selecting a case
    Given the cookies popup is displayed and the user accepts it
    And the user is logged in successfully with "Ahmed50" and "Ahmed50#"
    When the user attempts to book a treatment session without selecting a case
    Then a validation message should appear "اسم الحالة مطلوب"
