@golive @UI
Feature: Verify UI

  @UI-01 @UninstallAndroid
  Scenario: Verify UI in left menu after/before login
    Given I open app
    Then I login with "user_live" and "password"
    And I go to left menu
    And I tap on "Đăng ký HDBank OTP"
    Then I verify "Điều khoản & Điều kiện" is displayed
    And I back to left menu
    And I tap on Tài khoản at position is "3" in left menu
    Then I verify "Tài khoản thanh toán" is displayed
    And I back to left menu
    And I tap on Chuyển khoản at position is "4" in left menu
    Then I verify "Chuyển khoản trong HDBank" is displayed
    Then I verify "Chuyển khoản ngoài HDBank" is displayed
    Then I verify "Chuyển khoản qua số thẻ" is displayed
    And I back to left menu
    And I tap on "Nạp tiền"
    Then I tap on "ALLOW" button on popup
    And I verify "Nạp tiền điện thoại" is displayed
    And I back to left menu
    Then I tap on "Thanh toán hóa đơn"
    And I verify "Topup cho đại lý VietjetAir" is displayed
    And I back to left menu
    Then I tap on "Thanh toán vé máy bay"
    And I verify "Chọn hãng vé hàng không" is displayed
    And I back to left menu
    Then I tap on "Lì xì của tôi"
    And I verify "Chúc bạn năm mới Canh Tý thật nhiều vui vẻ và may mắn" is displayed
    And I tap on "Đóng" button on popup
    Then I tap on "QR nhận lì xì"
    And I tap on "ALLOW" button on popup
    And I verify "Quét mã QR" is displayed
    Then I back to left menu
    And I tap on "Định danh khách hàng"
    And I verify "Điều khoản & Điều kiện" is displayed
    Then I back to left menu
    And I tap on "Đặt vé máy bay"
    And I verify "Đặt vé máy bay Nội địa" is displayed
    Then I back to left menu from booking
    And I scroll up page
    And I tap on "Thông tin chứng khoán"
    Then I verify "Thị trường" is displayed
    And I back to left menu from stock market
    Then I create QR personal information
    And I verify "Họ tên" is displayed
    And I verify "Số điện thoại" is displayed
    And I verify "Lưu mã QR" is displayed
    Then I back to left menu
    And I tap on "Đổi mật khẩu"
    And I verify "Quy định đặt mật khẩu" is displayed
    Then I back to left menu
    And I tap on "Cài đặt"
    And I verify "Cài đặt đăng nhập" is displayed
    Then I back to left menu
    And I tap on "Thông tin ứng dụng"
    And I verify "HDBank mBanking là dịch vụ ngân hàng trực tuyến cho phép khách hàng giao dịch tài chính trên thiết bị di động." is displayed
    Then I back to left menu
    And I tap on "Chúng tôi luôn mong muốn nhận được phản hồi của Quý khách để nâng cao chất lượng dịch vụ."
    And I verify "Đánh giá ứng dụng" is displayed
    And I tap on icon star with level is "4"
    Then I send a rating request to HDBank
    And I close notice popup
    Then I tap on "Lịch sử đánh giá"
    And I verify "Đánh giá cá nhân" is displayed
    And I back to left menu
    Then I logout app from left menu
    And I go to left menu
    And I tap on "Sản phẩm - Dịch vụ của HDBank"
    Then I verify "HDBank" is displayed
    And I back to left menu
    Then I tap on "Ưu đãi dành cho khách hàng"
    And I verify "HDBank" is displayed
    And I back to left menu
    Then I tap on "Thông tin lãi suất"
    And I verify "HDBank" is displayed
    And I back to left menu
#    Then I tap on "Thông tin chứng khoán"
#    And I verify "Thị trường" is displayed
#    And I back to left menu
    Then I tap on "Địa điểm Chi nhánh/ATM"
    And I verify "HDBank" is displayed
    And I back to left menu
    And I tap on "Cài đặt"
    And I verify "Cài đặt ngôn ngữ" is displayed
    Then I back to left menu
    And I tap on "Trợ giúp"
    And I verify "Dịch vụ chưa được hỗ trợ. Quý khách vui lòng quay lại sau" is displayed
    And I tap on "Đồng ý"
    And I tap on "Thông tin ứng dụng"
    And I verify "HDBank mBanking là dịch vụ ngân hàng trực tuyến cho phép khách hàng giao dịch tài chính trên thiết bị di động." is displayed
    Then I back to left menu
    And I create QR personal information
    And I verify "Họ tên" is displayed
    And I verify "Số điện thoại" is displayed
    And I verify "Lưu mã QR" is displayed
    Then I back to left menu
    Then I scroll up page
    And I tap on "Chúng tôi luôn mong muốn nhận được phản hồi của Quý khách để nâng cao chất lượng dịch vụ."
    And I verify "Đánh giá ứng dụng" is displayed
    And I tap on icon star with level is "4"
    Then I send a rating request to HDBank
    And I close notice popup
    Then I tap on "Lịch sử đánh giá"
    And I verify "Tổng số lượt đánh giá" is displayed








    
    


    

