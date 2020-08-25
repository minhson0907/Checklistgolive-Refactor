@golive @KHDN
Feature: KHDN

#  @KHDN-01 @Android
#  Scenario: Đăng ký soft token cho user duyệt - KHDN
#    Given I open app
#    When I login with "user_duyệt" and "abc123"
#    And I input OTP code that is sent to your phone within "10" seconds
#    Then I register HDBank OTP
#    And I input "112233" PIN code
#    Then I verify "Quý khách đã đăng ký thành công HDBank OTP" is displayed

  @KHDN-02 @UninstallAndroid
    Scenario: Chuyển khoản trong
    Given I open app
    Then I login with "autotestnhap" and "abc123"
    And I do transaction from "045704070000966" account with type is "CK trong HD"
    And I get amount total before doing transaction
    Then I transfer to "011704070001534" account, "100000" amount and "AUTO DESCRIPTION" description with fee payer is "Người nhận trả"
    Then I input soft HDBank with code is "112233"
    Then I logout app
    When I login with "autotestduyet" and "abc123"
    And As KHDN, I do transaction with type is "Phê duyệt" in Home page 1
    And I choose "Duyệt giao dịch"
    And I search the above transaction
    And I get transferred amount
    And I get fee
    Then I approve the above transaction with code is "112233"
    And I get amount total after doing transaction
    Then I verify before total amount = after total amount + debit amount + fee

  @KHDN-03 @UninstallAndroid
  Scenario: Chuyển khoản ngoài citad
    Given I open app
    Then As KHDN, I login with "autotestnhap" and "abc123"
    And I do transaction from "045704070000966" account with type is "CK ngoài HD"
    And I get amount total before doing transaction
    And I update "0129837294" account with type is Chuyển khoản thông thường
    Then As KHDN, I transfer to "DONGA BANK" bank, "0129837294" account, "NGUYEN VAN NAPAS TEST ONLINE IBFT 247 VN" receiver, "200000" amount and "AUTO EXTERNAL TRANSFER 03" description with fee payer as default
    Then I input soft HDBank with code is "112233"
    Then I logout app
    When As KHDN, I login with "autotestduyet" and "abc123"
    And As KHDN, I do transaction with type is "Phê duyệt" in Home page 1
    And I choose "Duyệt giao dịch"
    And I search the above transaction
    And I get transferred amount
    Then I approve the above transaction with code is "112233"
    And I get amount total after doing transaction
    Then I verify before total amount = after total amount + debit amount + fee

  @KHDN-04 @UninstallAndroid
  Scenario: Chuyển khoản ngoài citad
    Given I open app
    Then As KHDN, I login with "autotestnhap" and "abc123"
    And I do transaction from "045704070000966" account with type is "CK ngoài HD"
    And I get amount total before doing transaction
    And I update "0129837294" account with type is Chuyển khoản tự động
    Then As KHDN, I transfer to "DONGA BANK" bank, "0129837294" account, "NGUYEN VAN NAPAS TEST ONLINE IBFT 247 VN" receiver, "200000" amount and "AUTO EXTERNAL TRANSFER 03" description with fee payer as default
    Then I input soft HDBank with code is "112233"
    Then I logout app
    When As KHDN, I login with "autotestduyet" and "abc123"
    And As KHDN, I do transaction with type is "Phê duyệt" in Home page 1
    And I choose "Duyệt giao dịch"
    And I search the above transaction
    And I get transferred amount
    Then I approve the above transaction with code is "112233"
    And I get amount total after doing transaction
    Then I verify before total amount = after total amount + debit amount + fee

  @KHDN-05 @UninstallAndroid
  Scenario: Chuyển khoản qua thẻ
    Given I open app
    Then As KHDN, I login with "autotestnhap" and "abc123"
    And I do transaction from "045704070000966" account with type is "CK qua thẻ"
    And I get amount total before doing transaction
    Then I transfer to "9704060129837294" card number, "200000" amount and "AUTO TRANSFER BY CARD 04" description
    Then I input soft HDBank with code is "112233"
    Then I logout app
    When As KHDN, I login with "autotestduyet" and "abc123"
    And As KHDN, I do transaction with type is "Phê duyệt" in Home page 1
    And I choose "Duyệt giao dịch"
    And I search the above transaction
    And I get transferred amount
    Then I approve the above transaction with code is "112233"
    And I get amount total after doing transaction
    Then I verify before total amount = after total amount + debit amount + fee

  @KHDN-06 @UninstallAndroid
  Scenario: Top up VietJetAir
    Given I open app
    Then As KHDN, I login with "autotestnhap" and "abc123"
    And I do transaction with type is "Thanh toán" in Home page 1
    Then I pay "" bill in "Topup cho đại lý VietjetAir" service
    And I do paying bill from "045704070000966" account for "37380512" agent code with amount is "1000000"
    Then I input soft HDBank with code is "112233"
    Then I logout app
    When As KHDN, I login with "autotestduyet" and "abc123"
    And As KHDN, I do transaction with type is "Phê duyệt" in Home page 1
    And I choose "Duyệt giao dịch"
    And I search the above transaction
    And I get transferred amount
    Then I approve the above transaction with code is "112233"
    And I get amount total after doing transaction
    Then I verify before total amount = after total amount + debit amount + fee
