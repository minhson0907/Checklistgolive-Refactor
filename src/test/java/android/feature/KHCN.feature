@golive @KHCN
Feature: KHCN for soft otp

  @KHCN-01 @UninstallAndroid
  Scenario: Chuyển khoản trong
    Given I open app
    When I login with "user_live" and "password"
    And I do transaction from "002704070016025" account with type is "CK trong HD"
    And I get amount total before doing transaction
    Then I transfer to "002704070011069" account, "2" amount and "AUTO DESCRIPTION" description with fee payer is "Người chuyển trả"
    Then I input soft HDBank with code is "112233"
    Then I get fee
    And I get transferred amount
    And I scroll up page
    Then I get amount total after doing transaction
    And I verify before total amount = after total amount + debit amount + fee
    Then I verify "Quý khách đã thực hiện giao dịch Chuyển khoản trong HDBank. Quý khách đánh giá giao dịch này thế nào?" is displayed after doing transaction successfully
    And I tap on rating section
    Then I verify "Chúng tôi luôn mong muốn nhận được phản hồi của Quý khách để nâng cao chất lượng dịch vụ." is displayed after doing transaction successfully
    And I tap on icon star with level is "5"
    Then I verify "Rất tốt" is displayed after doing transaction successfully
    And I do rating with "AUTO COMMENT" comment
    Then I verify "Thông báo" "Cảm ơn Quý khách đã gửi đánh giá." is displayed after doing transaction successfully

  @KHCN-02 @UninstallAndroid
  Scenario: Chuyển khoản citad
    Given I open app
    When I login with "user_live" and "password"
    And I do transaction from "002704070016025" account with type is "CK ngoài HD"
    And I get amount total before doing transaction
    Then I add new account with "ACB" bank, "249515269" account number and "VO MINH SON" receiver
    And I update "249515269" account with type is Chuyển khoản thông thường
    Then I transfer to "ACB" bank, "249515269" account, "VO MINH SON" receiver, "1" amount and "AUTO EXTERNAL TRANSFER 04" description with fee payer is "Người chuyển trả"
    Then I input soft HDBank with code is "112233"
    And I verify "Loại giao dịch" "Chuyển khoản thường tài khoản đến tài khoản" is displayed after doing transaction successfully
    Then I get fee
    And I get transferred amount
    And I scroll up page
    Then I get amount total after doing transaction
    And I verify before total amount = after total amount + debit amount + fee

  @KHCN-03 @UninstallAndroid
  Scenario: Chuyển khoản napas
    Given I open app
    When I login with "user_live" and "password"
    And I do transaction from "002704070016025" account with type is "CK ngoài HD"
    And I get amount total before doing transaction
    Then I add new account with "ACB" bank, "249515269" account number and "VO MINH SON" receiver
    And I update "249515269" account with type is Chuyển khoản tự động
    Then I transfer to "DONGA BANK" bank, "249515269" account, "VO MINH SON" receiver, "2" amount and "AUTO EXTERNAL TRANSFER 05" description with fee payer is "Người chuyển trả"
    Then I input soft HDBank with code is "112233"
    And I verify "Loại giao dịch" "Chuyển khoản nhanh 24/7" is displayed after doing transaction successfully
    Then I get fee
    And I get transferred amount
    And I scroll up page
    Then I get amount total after doing transaction
    And I verify before total amount = after total amount + debit amount + fee

  @KHCN-04 @UninstallAndroid
  Scenario: Chuyển khoản qua thẻ
    Given I open app
    When I login with "user_live" and "password"
    And I do transaction from "002704070016025" account with type is "CK qua thẻ"
    And I get amount total before doing transaction
    Then I transfer to "9704366814567141015" card number, "2" amount and "AUTO DESCRIPTION" description
    Then I input soft HDBank with code is "112233"
    Then I get fee
    And I get transferred amount
    And I scroll up page
    Then I get amount total after doing transaction
    And I verify before total amount = after total amount + debit amount + fee

  @KHCN-05 @UninstallAndroid
  Scenario: Test các chức năng thanh toán: điện, nước, internet, truyền hình cáp, Di động trả sau, Điện thoại cố định, Nạp tiền điện thoại, Topup VJ
    Given I open app
    When I login with "user_live" and "password"
    And I do transaction with type is "Thanh toán" in Home page 1
    Then I pay "Điện" bill in "Hóa đơn sinh hoạt" service
    And I do paying an electronic bill from "002704070016025" account with customer ID is "PK06000122470"
    Then I verify "Xác nhận" is displayed if bill is not paid or "Hóa đơn không còn nợ, vui lòng kiểm tra lại" is displayed if bill has been paid
    And I go to Home
    And I do transaction with type is "Thanh toán" in Home page 1
    Then I pay "Nước" bill in "Hóa đơn sinh hoạt" service
    And I do paying bill from "002704070016025" account to "Cấp nước Thủ Đức" provider with code ID is "16021110302"
    Then I verify "Xác nhận" is displayed if bill is not paid or "Hóa đơn không còn nợ, vui lòng kiểm tra lại" is displayed if bill has been paid
    And I go to Home
    And I do transaction with type is "Thanh toán" in Home page 1
    Then I pay "Internet" bill in "Hóa đơn sinh hoạt" service
    And I do paying bill from "002704070016025" account to "VNPT Cần Thơ - Internet" provider with customer ID is "CTO-01-0134638"
    Then I verify "Xác nhận" is displayed if bill is not paid or "Hóa đơn không còn nợ, vui lòng kiểm tra lại" is displayed if bill has been paid
    Then I go to Home
    And I do transaction with type is "Thanh toán" in Home page 1
    Then I pay "Truyền hình cáp" bill in "Hóa đơn sinh hoạt" service
    And I do paying bill from "002704070016025" account to "SCTV Hồ Chí Minh" provider with customer ID is "0011900910A"
    Then I verify "Xác nhận" is displayed if bill is not paid or "Hóa đơn không còn nợ, vui lòng kiểm tra lại" is displayed if bill has been paid
    Then I go to Home
    And I do transaction with type is "Thanh toán" in Home page 1
    Then I pay "Di động trả sau" bill in "Hóa đơn sinh hoạt" service
    And I do paying bill from "002704070016025" account to "Viettel - Thanh toán cước điện thoại di động trả sau" provider with customer ID is "0348736666"
    Then I verify "Xác nhận" is displayed if bill is not paid or "Hóa đơn không còn nợ, vui lòng kiểm tra lại" is displayed if bill has been paid
    Then I go to Home
    And I do transaction with type is "Thanh toán" in Home page 1
    Then I pay "Nạp tiền điện thoại" bill in "Nạp tiền" service
    And I close permission popup
    And I get amount total before doing transaction in topup mobile
    And I topup "10,000 VND" into "0983234167" phone number
    Then I input soft HDBank with code is "112233"
    And I get transferred amount in payment service
    And I get amount total after doing transaction for topup mobile
    Then I verify before total amount = after total amount + debit amount
    Then I go to Home
    And I do transaction with type is "Thanh toán" in Home page 1
    Then I pay "" bill in "Topup cho đại lý VietjetAir" service
    And I get amount total before doing transaction
    And I do paying bill from "002704070016025" account for "33000085" agent code with amount is "1"
    Then I input soft HDBank with code is "112233"
    And I get transferred amount in payment service
    Then I get amount total after doing transaction for topup VietJetAir
    And I verify before total amount = after total amount + debit amount

  @KHCN-06 @UninstallAndroid
    Scenario: Thanh toán vé máy bay
    Given I open app
    When I login with "user_live" and "password"
    And I do transaction with type is "Đặt vé máy bay" in Home page 2
    Then I book an one way domestic flight from "TP Hồ Chí Minh" to "Nha Trang" on Vietnam Airlines airline with method is Pay later
    And I fill "Vo Minh Son" full name, "Nam" gender, "sonvm3@hdbank.com.vn" email, "0983234167" phone number with "AUTO DESCRIPTION" description
    And I check on use for Passenger information
    Then I confirm the above flight with method is Pay later
    And I get reservation code
    Then I go to Home after booking airline ticket
    And I do transaction with type is "Thanh toán" in Home page 1
    Then I pay "Vé máy bay" bill in "Dịch vụ vận chuyển" service
    And I do paying bill from "002704070016025" account to Thanh toán vé đặt qua VNPAY provider with the above reservation code
    Then I verify "Xác nhận" is displayed if bill is not paid or "Hóa đơn không còn nợ, vui lòng kiểm tra lại" is displayed if bill has been paid

  @KHCN-07 @UninstallAndroid
    Scenario: Đặt phòng Khách sạn
    Given I open app
    When I login with "user_live" and "password"
    And I do transaction with type is "Đặt phòng Khách sạn" in Home page 2
    And I looking for the hotel in "Hà Nội"
    And I close permission popup
    Then I book a hotel with email info is "sonvm3@hdbank.com.vn"
    Then I continue to book hotel
    Then I verify "Xác nhận" is displayed if bill is not paid or "Hóa đơn không còn nợ, vui lòng kiểm tra lại" is displayed if bill has been paid

  @KHCN-08 @UninstallAndroid
  Scenario: Order a bouquet
    Given I open app
    When I login with "datathanhvan" and "abc123"
    And I do transaction with type is "Đặt hoa" in Home page 2
    Then I order a bouquet with name is "Yêu Xa"
    And I fill info as below
      | testauto@gmail.com | 174 Phan Dang Luu |
    And I give to "Bạn bè" with "Happy birthday" message
    Then I verify "Email" "testauto@gmail.com" is displayed after doing transaction successfully
    And I scroll up page
    And I continue to book flower
    Then I verify "Xác nhận" is displayed if bill is not paid or "Hóa đơn không còn nợ, vui lòng kiểm tra lại" is displayed if bill has been paid

  @KHCN-09 @UninstallAndroid
    Scenario: Đặt vé tàu
    Given I open app
    When I login with "user_live" and "password"
    And I do transaction with type is "Đặt vé tàu" in Home page 2
    Then I book an one way train from "Sài Gòn" to "Hà Nội" with seat type is "Nằm khoang 6"
    And I choose departing and return time for one way train
    And I fill passenger info as below
      | Vo Minh Son | 311858656 |
    Then I scroll up page
    And I fill contact info as below
      | 311858977 | sonvm3@hdbank.com.vn |
    Then I choose "Không xuất hóa đơn"
    And I continue to book train
    And I scroll up page
    Then I continue to book the train
    Then I verify "Xác nhận" is displayed if bill is not paid or "Hóa đơn không còn nợ, vui lòng kiểm tra lại" is displayed if bill has been paid

  @KHCN-10 @UninstallAndroid
    Scenario: Đặt vé máy bay
    Given I open app
    When I login with "user_live" and "password"
    And I do transaction with type is "Đặt vé máy bay" in Home page 2
    Then I book an one way domestic flight from "TP Hồ Chí Minh" to "Phú Quốc" on all airline with method is Pay now
    And I fill "Vo Minh Son" full name, "Nam" gender, "sonvm3@hdbank.com.vn" email, "0983234167" phone number with "AUTO DESCRIPTION" description
    And I check on use for Passenger information
    Then I confirm the above flight with method is Pay now
    And I scroll up page
    And I continue to book the above flight
    Then I verify "Xác nhận" is displayed if bill is not paid or "Hóa đơn không còn nợ, vui lòng kiểm tra lại" is displayed if bill has been paid

  @KHCN-11 @UninstallAndroid
    Scenario: Đặt vé xem phim
    Given I open app
    When I login with "user_live" and "password"
    And I do transaction with type is "Đặt vé Xem phim" in Home page 2
    And I buy a film ticket at "BHD Star Cineplex" cinema
    Then I verify "Xác nhận" is displayed if bill is not paid or "Hóa đơn không còn nợ, vui lòng kiểm tra lại" is displayed if bill has been paid

  @KHCN-12 @UninstallAndroid
  Scenario: Mở sổ tiết kiệm
    Given I open app
    When I login with "user_live" and "password"
    And I do transaction with type is "Tiết kiệm" in Home page 1
    Then I choose "Mở tiết kiệm" to open online saving account
    And I read Terms & Conditions and agree
    Then I open online saving account from "002704070016025" account, "1000000" amount, "01 tháng" terms with method is "Tự động tái tục vốn, lãi chuyển vào tài khoản chỉ định"
    Then I input soft HDBank with code is "112233"
    And I verify "GIAO DỊCH THÀNH CÔNG" is displayed

  @KHCN-13 @UninstallAndroid
  Scenario: Tất toán sổ tiết kiệm
    Given I open app
    When I login with "user_live" and "password"
    And I do transaction with type is "Tài khoản" in Home page 1
    Then I redeem an online saving account
    Then I input soft HDBank with code is "112233"
    And I verify "GIAO DỊCH THÀNH CÔNG" is displayed

  @KHCN-14 @UninstallAndroid
  Scenario: Thanh toán thẻ tín dụng
    Given I open app
    When I login with "user_live" and "password"
    And I do transaction with type is "Thẻ" in Home page 1
    Then I pay card from "002704070016025" to "812550023530" with amount is "1"
    Then I input soft HDBank with code is "112233"
    And I verify "GIAO DỊCH THÀNH CÔNG" is displayed

  @KHCN-15 @UninstallAndroid
  Scenario: Đóng Thanh toán online
    Given I open app
    When I login with "user_live" and "password"
    And I do transaction with type is "Thẻ" in Home page 1
    Then I close the online payment
    Then I input soft HDBank with code is "112233"
    And I verify "GIAO DỊCH THÀNH CÔNG" is displayed

  @KHCN-16 @UninstallAndroid
  Scenario: Mở Thanh toán online
    Given I open app
    When I login with "user_live" and "password"
    And I do transaction with type is "Thẻ" in Home page 1
    Then I open the online payment
    Then I input soft HDBank with code is "112233"
    And I verify "GIAO DỊCH THÀNH CÔNG" is displayed

  @KHCN-17 @UninstallAndroid
  Scenario: Tạo QR thông tin cá nhân, Chuyển khoản QR, Thanh toán QR
    Given I open app
    When I login with "user_live" and "password"
    And I transfer to other account by QR with "1" amount and "AUTO DESCRIPTION" description with fee payer is "Người chuyển trả"
    Then I input soft HDBank with code is "112233"
    And I verify "GIAO DỊCH THÀNH CÔNG" is displayed
    Then I go to Home
    And I pay by QR
    Then I pay service with amount is "1"
    Then I input soft HDBank with code is "112233"
    And I verify "Tên điểm bán" "Shop Ton That Tung" is displayed after doing transaction successfully
    Then I go to Home
    And I access in left menu
    And I create QR personal information
    Then I verify "Họ tên" is displayed
    And I verify "Số điện thoại" is displayed
    And I verify "Lưu mã QR" is displayed

  @KHCN-18 @UninstallAndroid
  Scenario: Thông tin trái phiếu
    Given I open app
    When I login with "user_live" and "password"
    Then I do transaction with type is "Tài khoản" in Home page 1
    And I scroll up page
    And I verify "Danh sách trái phiếu đã bán" is displayed
    Then I tap on Danh sách trái phiếu đã bán
    And I verify "Quý khách không có trái phiếu đã bán." is displayed

#  @KHCN-19 @UninstallAndroid
#  Scenario: Khóa Thẻ
#    Given I open app
#    Then I login with "user_live" and "password"
#    And I do transaction with type is "Thẻ" in Home page 1
#    And I lock card
#    Then I input soft HDBank with code is "112233"
#    And I verify "GIAO DỊCH THÀNH CÔNG" is displayed
#    And I verify "Lý do khóa thẻ" "Khoa the tam thoi" is displayed after doing transaction successfully








