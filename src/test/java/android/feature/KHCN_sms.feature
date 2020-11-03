@golive @KHCN_sms @KHCN
Feature: KHCN for sms otp

  @KHCN_sms @UninstallAndroid
  Scenario: Kiểm tra hardcode sms với chuyển khoản trong
    Given I open app
    When I login with "user_live" and "password"
    And I do transaction from "002704070016025" account with type is "CK trong HD"
    Then I transfer to "002704070011069" account, "1" amount and "AUTO DESCRIPTION 000000" description with fee payer is "Người chuyển trả"
    And I input "000000" OTP code
    And I confirm the above transaction
    Then I verify "Mật khẩu giao dịch không đúng. Quý khách vui lòng nhập lại." is displayed
    And I close notice popup by "Đồng ý" button
    And I go to Home
    And I do transaction from "002704070016025" account with type is "CK trong HD"
    Then I transfer to "002704070011069" account, "2" amount and "AUTO DESCRIPTION 999999" description with fee payer is "Người chuyển trả"
    And I input "999999" OTP code
    And I confirm the above transaction
    Then I verify "Mật khẩu giao dịch không đúng. Quý khách vui lòng nhập lại." is displayed
    And I close notice popup by "Đồng ý" button
    And I go to Home
    And I do transaction from "002704070016025" account with type is "CK trong HD"
    Then I transfer to "002704070011069" account, "3" amount and "AUTO DESCRIPTION 123456" description with fee payer is "Người chuyển trả"
    And I input "123456" OTP code
    And I confirm the above transaction
    Then I verify "Mật khẩu giao dịch không đúng. Quý khách vui lòng nhập lại." is displayed
    And I close notice popup by "Đồng ý" button
    And I go to Home
    And I do transaction from "002704070016025" account with type is "CK trong HD"
    Then I transfer to "002704070011069" account, "4" amount and "AUTO DESCRIPTION 111111" description with fee payer is "Người chuyển trả"
    And I input "111111" OTP code
    And I confirm the above transaction
    Then I verify "Mật khẩu giao dịch không đúng. Quý khách vui lòng nhập lại." is displayed
    And I close notice popup by "Đồng ý" button
    And I go to Home
    And I do transaction from "002704070016025" account with type is "CK trong HD"
    Then I transfer to "002704070011069" account, "5" amount and "AUTO DESCRIPTION 654321" description with fee payer is "Người chuyển trả"
    And I input "654321" OTP code
    And I confirm the above transaction
    Then I verify "Mật khẩu giao dịch không đúng. Quý khách vui lòng nhập lại." is displayed
    And I close notice popup by "Đồng ý" button