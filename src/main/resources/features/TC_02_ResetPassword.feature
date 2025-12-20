#@smoke
Feature:User will be able to reset his password with a valid email

  Scenario: User will be able to reset his password
    Given the cookies popup is displayed and the user accepts it
    And the user is on the login page
    When the user clicks the Forget Password link
    And user enter recovery "Ahmed50@grr.la"
    Then a confirmation message should appear "ستصل رسالة بريد إلكتروني تحوي التعليمات اللازمة لإعادة ضبط كلمة السر"


  Scenario: User will not be able to reset his password with invalid email
    Given the cookies popup is displayed and the user accepts it
    And the user is on the login page
    When the user clicks the Forget Password link
    And user enter recovery "Ahmeeeeed50@grr.la"
    Then a validation message should appear "لم يتم العثور على المستخدم"

