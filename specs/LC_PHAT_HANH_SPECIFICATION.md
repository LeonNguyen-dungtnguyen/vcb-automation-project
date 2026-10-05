# Chỉ Tiêu Kỹ Thuật: Quy Trình Phát Hành Chứng Chỉ Phí (LC)

**Tính năng:** Phát Hành Chứng Chỉ Phí - 1 Cấp Duyệt  
**Ticket:** LC-001  
**Môi trường:** SIT (Kiểm Thử Tích Hợp Hệ Thống)  
**Lĩnh vực:** Tài Chính Thương Mại / Front Office  

---

## Những Gì Chúng Ta Xây Dựng

Bộ kiểm thử tự động cho quy trình Phát Hành Chứng Chỉ Phí (LC) của VCB TradeFlat. Phần đầu tiên bao gồm **luồng happy case với 1 cấp duyệt và xác thực 2FA**.

### Không Bao Gồm (phần này)
- Quy trình duyệt 2 cấp
- Các kịch bản ký số pháp nhân
- Test case tiêu cực (từ chối/hủy)
- Kiểm thử hiệu năng/tải
- Kiểm thử API

---

## User Story

**Là** Kỹ sư QA tự động hóa  
**Tôi muốn** xác minh quy trình Phát Hành LC với 1 cấp duyệt  
**Để có thể** đảm bảo luồng giao dịch từ khởi tạo đến gửi ngân hàng hoạt động chính xác  

---

## Tiêu Chí Chấp Nhận

### AC1: Maker có thể khởi tạo và gửi yêu cầu Phát Hành LC
- Maker đăng nhập hệ thống FO
- Khởi tạo bản ghi Phát Hành LC mới với các trường thông tin bắt buộc
- Gửi thành công → Trạng thái bản ghi = "Chờ duyệt"

### AC2: Kế toán trưởng có thể duyệt với xác thực 2FA
- Kế toán trưởng đăng nhập và điều hướng đến các giao dịch chờ duyệt
- Thực hiện xác thực 2FA
- Duyệt thành công → Trạng thái bản ghi vẫn là "Chờ duyệt" (sẵn sàng cho bước ký)

### AC3: Chủ tài khoản có thể ký số điện tử
- Chủ tài khoản đăng nhập
- Thực hiện ký số điện tử trên LC đã được duyệt
- Ký số thành công → Trạng thái bản ghi = "Đã gửi ngân hàng"

### AC4: Hệ thống hiển thị thông báo thành công
- Sau ký số cuối cùng, hệ thống hiển thị thông báo thành công
- Mã tham chiếu giao dịch được hiển thị
- Người dùng có thể điều hướng đến lịch sử giao dịch

---

## Bối Cảnh Kinh Doanh

**Module VCB TradeFlat:** Phát Hành Chứng Chỉ Phí (LC ISS)  

**Luồng Kinh Doanh:**
1. Khách hàng (Maker) khởi tạo yêu cầu Phát Hành LC qua FO
2. Người phê duyệt nội bộ (Kế toán trưởng) xem xét và phê duyệt với 2FA
3. Chủ tài khoản cung cấp ký số điện tử
4. Giao dịch được gửi đến hệ thống ngân hàng

**Các Quy Tắc Kinh Doanh Chính:**
- LC phải chứa đầy đủ, thông tin hợp lệ trước khi phê duyệt
- Xác thực 2FA bắt buộc ở bước phê duyệt (yêu cầu bảo mật)
- Ký số điện tử bắt buộc trước khi gửi ngân hàng
- Sau khi gửi, các thay đổi yêu cầu hủy + tạo yêu cầu mới

---

## Bối Cảnh Kỹ Thuật

**Framework Kiểm Thử:** Katalon Studio  
**Ứng Dụng:** VCB TradeFlat FO (Front Office)  
**Dữ liệu Test:** 1 tài khoản Maker, 1 Kế toán trưởng, 1 Chủ tài khoản  
**Môi trường Test:** SIT  
**Thời gian Thực Hiện Dự Kiến:** ~5 phút cho mỗi test case  

---

## Kịch Bản Kiểm Thử (Phần Đầu)

### Kịch Bản 1.1: Luồng Happy - 1 Cấp Duyệt, Không Ký Pháp Nhân

**Điều Kiện Tiên Quyết:**
- Các tài khoản kiểm thử được tạo (Maker, Kế toán trưởng, Chủ tài khoản)
- Module Phát Hành LC cấu hình cho 1 cấp duyệt
- Xác thực 2FA được bật
- Không yêu cầu ký pháp nhân

**Các Bước Kiểm Thử:**

| # | Bước | Người Thực Hiện | Hành Vi Mong Đợi |
|---|------|--|---|
| 1 | Đăng nhập vào hệ thống FO | Maker | Trang chủ hiển thị, không có lỗi |
| 2 | Điều hướng đến "Tạo Đề Nghị Phát Hành" | Maker | Form tải với tất cả các trường bắt buộc |
| 3 | Điền tất cả các trường bắt buộc (Số tiền LC, ngoại tệ, người thụ hưởng, v.v.) | Maker | Form chấp nhận dữ liệu, kiểm tra hợp lệ |
| 4 | Gửi để phê duyệt | Maker | Trạng thái thay đổi thành "Chờ duyệt" |
| 5 | Đăng xuất Maker, đăng nhập như Kế toán trưởng | Kế toán trưởng | Xác thực thành công |
| 6 | Điều hướng đến các giao dịch chờ duyệt | Kế toán trưởng | Yêu cầu LC hiển thị trong danh sách chờ duyệt |
| 7 | Mở yêu cầu LC | Kế toán trưởng | Chi tiết giao dịch đầy đủ hiển thị |
| 8 | Thực hiện xác thực 2FA | Kế toán trưởng | Thử thách 2FA được trình bày, mã OTP được chấp nhận |
| 9 | Phê duyệt giao dịch | Kế toán trưởng | Trạng thái vẫn là "Chờ duyệt" |
| 10 | Đăng xuất Kế toán trưởng, đăng nhập như Chủ tài khoản | Chủ tài khoản | Xác thực thành công |
| 11 | Điều hướng đến "Ký Giao Dịch" | Chủ tài khoản | LC đã phê duyệt hiển thị trong danh sách |
| 12 | Mở LC để ký | Chủ tài khoản | Trường ký sẵn sàng |
| 13 | Thực hiện ký số điện tử | Chủ tài khoản | Ký số được ghi lại thành công |
| 14 | Xác nhận ký số | Chủ tài khoản | Thông báo thành công hiển thị, trạng thái = "Đã gửi ngân hàng" |
| 15 | Xem mã tham chiếu giao dịch | Chủ tài khoản | Số tham chiếu được tạo và hiển thị |

**Kết Quả Mong Đợi:**
- ✅ Yêu cầu LC chuyển thành công qua phê duyệt → ký → gửi ngân hàng
- ✅ Tất cả chuyển tiếp trạng thái chính xác
- ✅ Không có thông báo lỗi
- ✅ Thông báo thành công hiển thị

---

## Yêu Cầu Dữ Liệu Kiểm Thử

**Tài Khoản Maker:**
- Tên người dùng: `maker_lc_001`
- Quyền: Tạo yêu cầu Phát Hành LC
- 2FA bật: Có

**Tài Khoản Kế toán trưởng:**
- Tên người dùng: `head_accounting_001`
- Quyền: Phê duyệt LC theo giới hạn
- 2FA bật: Có
- Giới hạn phê duyệt: >$100.000 USD

**Tài Khoản Chủ Tài Khoản:**
- Tên người dùng: `owner_account_001`
- Quyền: Ký yêu cầu Phát Hành LC
- Chứng chỉ điện tử: Hợp lệ

**Dữ Liệu Yêu Cầu Phát Hành LC:**
- Số tiền LC: $50.000 USD
- Người thụ hưởng: Test Beneficiary Corp
- Ngày hết hạn: 6 tháng kể từ ngày khởi tạo
- Hướng dẫn: Điều khoản LC tiêu chuẩn
- Các trường bắt buộc khác: Điền dữ liệu kiểm thử hợp lệ

---

## Số Liệu Thành Công

✅ Cả 3 người dùng hoàn thành thành công các hành động của họ  
✅ Cả 5 chuyển tiếp trạng thái xảy ra theo thứ tự chính xác  
✅ Xác thực 2FA thành công  
✅ Ký số điện tử được chấp nhận  
✅ Không có lỗi xác thực trong quá trình gửi  
✅ Thông báo thành công hiển thị cho người dùng  
✅ Dấu vết kiểm toán ghi lại tất cả hành động  

---

## Phụ Thuộc & Rủi Ro

**Phụ Thuộc:**
- Môi trường kiểm thử (SIT) có thể truy cập
- Các tài khoản kiểm thử được cấp phát
- Module Phát Hành LC được cấu hình
- Hệ thống 2FA hoạt động
- Dịch vụ ký số điện tử có sẵn

**Rủi Ro:**
- Hết giờ 2FA trong quá trình thực thi kiểm thử
- Sự cố đồng bộ đồng hồ hệ thống
- Dọn dẹp dữ liệu kiểm thử giữa các lần chạy
- Độ trễ mạng ảnh hưởng đến dịch vụ ký

**Giảm Thiểu:**
- Đặt thời chờ hào phòng trong chờ kiểm thử
- Đồng bộ đồng hồ hệ thống trước chạy kiểm thử
- Sử dụng quy trình dọn dẹp dữ liệu kiểm thử
- Kiểm thử kết nối mạng trước khi thực thi

---

## Câu Hỏi Làm Rõ (Tiền Triển Khai)

**Cho Chuyên Gia Phân Tích Kinh Doanh:**
1. Hết giờ OTP 2FA là bao lâu? (30 giây? 1 phút?)
2. Chủ tài khoản luôn ký, hay chỉ khi số tiền > ngưỡng?
3. Sau khi Kế toán trưởng phê duyệt, Maker có thể thay đổi trước khi ký?
4. Có quy trình quay lại nếu ký số thất bại không?

**Cho Trưởng Kỹ Thuật:**
1. Ký số điện tử được xác minh trong môi trường kiểm thử như thế nào?
2. Chúng ta có thể sử dụng 2FA giả hay phải dùng hệ thống OTP sản xuất?
3. Số lượng yêu cầu Phát Hành LC đồng thời tối đa trong quá trình kiểm thử là bao nhiêu?
4. Có API endpoints mà chúng ta nên kiểm thử ngoài UI không?

---

## Ghi Chú Triển Khai

**Cấu Trúc Keyword:**
- `LC_Create_Request` - Tạo LC mới, xác thực form tải
- `LC_Submit_For_Approval` - Gửi LC, xác thực thay đổi trạng thái
- `LC_Approve_With_2FA` - Đăng nhập như người phê duyệt, thực hiện 2FA, phê duyệt
- `LC_Sign_Digitally` - Đăng nhập như người ký, thực hiện ký số điện tử
- `LC_Verify_Completion` - Xác thực thông báo thành công, trạng thái, tham chiếu

**Dữ Liệu Kiểm Thử:**
- Lưu trữ trong `Data Files/LC_TestData.xlsx`
- Cột: actor_type, username, password, lc_amount, currency

**Báo Cáo Mong Đợi:**
- Trạng thái Vượt/Thất bại cho mỗi bước
- Ảnh chụp màn hình tại các chuyển tiếp chính
- Thời gian thực thi
- Thời gian phản hồi 2FA
- Bất kỳ thông báo lỗi nào

---

## Bước Tiếp Theo

1. ✅ Hoàn thiện chỉ tiêu này (tài liệu này)
2. ⏳ Trưởng kỹ thuật phê duyệt chỉ tiêu
3. ⏳ Tạo kế hoạch triển khai
4. ⏳ Chia thành 3-5 task triển khai
5. ⏳ Viết script kiểm thử Katalon
6. ⏳ Thực thi và xác minh trên SIT

---

**Chủ Sở Hữu Chỉ Tiêu:** Trưởng QA  
**Trạng Thái:** Sẵn Sàng Cho Đánh Giá Trưởng Kỹ Thuật  
**Cập Nhật Lần Cuối:** 05/10/2026
