@smoke
Feature: user will be able to login with valid credentials

  Scenario: user will be able to login with valid Email and password
    Given the cookies popup is displayed and the user accepts it
    And the user is on the login page
    When the user enters valid credentials "Ahmed50" , "Ahmed50#"
    Then user will be able to see "لوحة التحكم"


  Scenario: user will be able to login with invalid Email and password
    Given the cookies popup is displayed and the user accepts it
    And the user is on the login page
    When the user enters valid credentials "Ahmed50" , "Ahmed5007#"
    Then login validation message "اسم المستخدم أو كلمة المرور غير صحيح"





