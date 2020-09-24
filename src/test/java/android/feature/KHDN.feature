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

  @KHDN-02 @AndroidInput
    Scenario: Chuyển khoản trong with user nhập
    Given I open app
    Then As input user, I login with "autotestnhap" and "abc123"
    And As KHDN, I do transaction with type is "CK trong HD" in Home page 1
    Then As KHDN, I transfer to "002704070011069" account, "1" amount and "AUTO DESCRIPTION" description with fee payer is "Người chuyển trả"
    Then I input soft HDBank with code is "112233"
    And I verify "GIAO DỊCH ĐÃ ĐƯỢC CHẤP NHẬN VÀ ĐANG CHỜ DUYỆT" is displayed after doing transaction successfully

  @KHDN-02 @AndroidApproval
  Scenario: Chuyển khoản trong with user duyệt
    Given I open app
    Then  As approval user, I login with "autotestduyet" and "abc123"
    And As KHDN, I do transaction with type is "Phê duyệt" in Home page 1
    And I choose "Duyệt giao dịch"
    And I search the above transaction
    Then I approve the above transaction with code is "112233"
    And I verify "THÀNH CÔNG" is displayed
    
  @KHDN-03 @AndroidInput
  Scenario: Chuyển khoản ngoài citad with user nhập
    Given I open app
    Then As input user, I login with "autotestnhap" and "abc123"
    And As KHDN, I do transaction from "045704070000966" account with type is "CK ngoài HD"
    Then I add new account with "ACB" bank, "249515269" account number and "VO MINH SON" receiver
    And I update "249515269" account with type is Chuyển khoản thông thường
    Then As KHDN, I transfer to "ACB" bank, "249515269" account, "VO MINH SON" receiver, "1" amount and "AUTO EXTERNAL TRANSFER 03" description with fee payer as default
    Then I input soft HDBank with code is "112233"
    And I verify "Loại giao dịch" "Chuyển khoản thường tài khoản đến tài khoản" is displayed after doing transaction successfully
    And I verify "GIAO DỊCH ĐÃ ĐƯỢC CHẤP NHẬN VÀ ĐANG CHỜ DUYỆT" is displayed after doing transaction successfully

  @KHDN-03 @AndroidApproval
  Scenario: Chuyển khoản ngoài citad with user duyệt
    Given I open app
    When As approval user, I login with "autotestduyet" and "abc123"
    And As KHDN, I do transaction with type is "Phê duyệt" in Home page 1
    And I choose "Duyệt giao dịch"
    And I search the above transaction
    Then I approve the above transaction with code is "112233"
    And I verify "THÀNH CÔNG" is displayed

  @KHDN-04 @AndroidInput
  Scenario: Chuyển khoản ngoài napas with user nhập
    Given I open app
    Then As input user, I login with "autotestnhap" and "abc123"
    And As KHDN, I do transaction from "045704070000966" account with type is "CK ngoài HD"
    Then I add new account with "ACB" bank, "249515269" account number and "VO MINH SON" receiver
    And I update "249515269" account with type is Chuyển khoản tự động
    Then As KHDN, I transfer to "ACB" bank, "249515269" account, "VO MINH SON" receiver, "2" amount and "AUTO EXTERNAL TRANSFER 03" description with fee payer as default
    Then I input soft HDBank with code is "112233"
    And I verify "Loại giao dịch" "Chuyển khoản nhanh 24/7" is displayed after doing transaction successfully
    And I verify "GIAO DỊCH ĐÃ ĐƯỢC CHẤP NHẬN VÀ ĐANG CHỜ DUYỆT" is displayed after doing transaction successfully

  @KHDN-04 @AndroidApproval
  Scenario: Chuyển khoản ngoài napas with user duyệt
    Given I open app
    When As approval user, I login with "autotestduyet" and "abc123"
    And As KHDN, I do transaction with type is "Phê duyệt" in Home page 1
    And I choose "Duyệt giao dịch"
    And I search the above transaction
    Then I approve the above transaction with code is "112233"
    And I verify "THÀNH CÔNG" is displayed

  @KHDN-05 @AndroidInput
  Scenario: Chuyển khoản qua thẻ with user nhập
    Given I open app
    Then As input user, I login with "autotestnhap" and "abc123"
    And As KHDN, I do transaction from "045704070000966" account with type is "CK qua thẻ"
    Then I transfer to "4987666802993375" card number, "1" amount and "AUTO TRANSFER BY CARD 04" description
    Then I input soft HDBank with code is "112233"
    And I verify "GIAO DỊCH ĐÃ ĐƯỢC CHẤP NHẬN VÀ ĐANG CHỜ DUYỆT" is displayed after doing transaction successfully

  @KHDN-05 @AndroidApproval
  Scenario: Chuyển khoản qua thẻ with user duyệt
    Given I open app
    When As approval user, I login with "autotestduyet" and "abc123"
    And As KHDN, I do transaction with type is "Phê duyệt" in Home page 1
    And I choose "Duyệt giao dịch"
    And I search the above transaction
    Then I approve the above transaction with code is "112233"
    And I verify "THÀNH CÔNG" is displayed

  @KHDN-06 @AndroidInput
  Scenario: Top up VietJetAir with user nhập
    Given I open app
    Then As input user, I login with "autotestnhap" and "abc123"
    And I do transaction with type is "Thanh toán" in Home page 1
    Then I pay "" bill in "Topup cho đại lý VietjetAir" service
    And I do paying bill from "045704070000966" account for "33000056" agent code with amount is "1"
    Then I input soft HDBank with code is "112233"
    And I verify "GIAO DỊCH ĐÃ ĐƯỢC CHẤP NHẬN VÀ ĐANG CHỜ DUYỆT" is displayed after doing transaction successfully

  @KHDN-06 @AndroidApproval
  Scenario: Top up VietJetAir with user duyệt
    Given I open app
    When As approval user, I login with "autotestduyet" and "abc123"
    And As KHDN, I do transaction with type is "Phê duyệt" in Home page 1
    And I choose "Duyệt giao dịch"
    And I search the above transaction
    Then I approve the above transaction with code is "112233"
    And I verify "THÀNH CÔNG" is displayed
