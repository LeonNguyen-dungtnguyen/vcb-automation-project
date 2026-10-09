# FO – Test case automate được

Nguồn: `VCB_TradeFlat_Testcase_SIT_LC_ISS_Phat Hanh v1.1 (1).xlsx`, sheet `Tinh chỉnh`. **Row** = số dòng trong Excel.

**593 / 749 TC FO** automate được ngay; 19 TC cần xác nhận thêm (cuối file). Các TC này không cần OTP, ký số, giả lập lỗi API, email, log, hạn mức, và không phụ thuộc bản ghi đã qua OTP/ký số/BO. Phần còn lại xem `FO_automation_blockers.md`.

Điều kiện chung: user Maker (và Kế toán trưởng/Chủ tài khoản cho màn Phê duyệt/Từ chối – chỉ mở màn hình, không xác thực OTP). Bản ghi "Chờ duyệt" do Maker tạo được, không cần OTP.

## Tóm tắt

| Nhóm | Số TC |
|---|---|
| Danh sách & tìm kiếm giao dịch | 49 |
| Thêm mới – truy cập, điều hướng các bước, tích hợp CIF/hạn mức, Gửi duyệt | 11 |
| Thêm mới – rule chung các trường | 52 |
| Thêm mới – Thông tin khách hàng | 14 |
| Thêm mới – Thông tin LC, ngân hàng, bên phát hành, người hưởng | 75 |
| Thêm mới – Giá trị LC, dung sai | 10 |
| Thêm mới – Phương thức thanh toán, hối phiếu, kỳ hạn | 20 |
| Thêm mới – Giao hàng & hàng hoá | 36 |
| Thêm mới – Điều khoản bổ sung | 16 |
| Thêm mới – Phí & thời hạn xuất trình | 38 |
| Thêm mới – Thông tin khác, nguồn tiền, lãi suất, trả nợ | 61 |
| Thêm mới – Điều khoản & điều kiện, Hồ sơ đính kèm | 30 |
| Thêm mới – Các nút cuối màn hình | 8 |
| Thêm mới – Chứng từ yêu cầu | 19 |
| Thêm mới – Additional conditions, LC xác nhận/chuyển nhượng, phí discounting | 37 |
| Thêm mới – Cam kết bổ sung chứng từ | 19 |
| Xem chi tiết | 33 |
| Phê duyệt | 4 |
| Chỉnh sửa bản nháp | 10 |
| Từ chối | 7 |
| Hủy đề nghị | 10 |
| Xóa đề nghị | 10 |
| Sao chép | 13 |
| Quản lý template | 11 |
| **Tổng automate được** | **593** |
| Cần xác nhận thêm (cuối file) | 19 |

## Danh sách & tìm kiếm giao dịch (49)

1. Kiểm tra quyền truy cập chức năng "Danh sách và tìm kiếm giao dịch" (FO) — *TC 66, row 67*
2. Kiểm tra chặn truy cập chức năng "Danh sách và tìm kiếm giao dịch" (FO) khi không được phân quyền — *TC 67, row 68*
3. Kiểm tra hệ thống gọi API tới BO Admin Portal để lấy thông tin phân quyền (CIF, cây phân quyền, roleName) ngay sau khi đăng nhập thành công — *TC 68, row 69*
4. Kiểm tra hậu điều kiện phân quyền theo CIF: NSD chỉ xem được toàn bộ danh sách giao dịch đề nghị phát hành LC thuộc chính CIF của mình — *TC 69, row 70*
5. Kiểm tra chức năng tìm kiếm nhanh (realtime) trên khung tìm kiếm theo trường Mã đề nghị — *TC 70, row 71*
6. Kiểm tra chức năng tìm kiếm nhanh (realtime) trên khung tìm kiếm theo trường Bên nhận LC — *TC 71, row 72*
7. Kiểm tra chức năng tìm kiếm nhanh (realtime) trên khung tìm kiếm theo trường Số tiền — *TC 72, row 73*
8. Kiểm tra chức năng mở màn hình Bộ lọc nâng cao khi nhấn nút <Bộ lọc> — *TC 73, row 74*
9. Kiểm tra chức năng tìm kiếm bằng Bộ lọc nâng cao khi nhập nhiều điều kiện và nhấn <Áp dụng>, đảm bảo điều kiện giữa các trường là quan hệ AND — *TC 74, row 75*
10. Kiểm tra quy tắc tìm kiếm CONTAIN (chứa giá trị nhập) và không phân biệt hoa/thường khi tìm kiếm — *TC 75, row 76*
11. Kiểm tra kết quả tìm kiếm/danh sách được sắp xếp ưu tiên theo Ngày đề nghị giảm dần — *TC 76, row 77*
12. Kiểm tra chức năng phân trang: hiển thị 10 bản ghi/trang và cho phép xem thêm bản ghi khi còn bản ghi bị ẩn — *TC 77, row 78*
13. Kiểm tra thông báo khi tìm kiếm/lọc không có kết quả phù hợp — *TC 78, row 79*
14. Kiểm tra chức năng nút "Thêm mới LC" — *TC 79, row 80*
15. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Tìm kiếm" (tối đa 50 ký tự) — *TC 80, row 81*
16. Kiểm tra định dạng ngày trường "Ngày đề nghị" — *TC 81, row 82*
17. Kiểm tra nhập giá trị ngày hợp lệ trường "Ngày đề nghị" — *TC 82, row 83*
18. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Số tham chiếu LC" (tối đa 20 ký tự) — *TC 83, row 84*
19. Kiểm tra danh sách giá trị lựa chọn của trường "Loại LC" (cập nhật SRS mới: 4 giá trị) — *TC 84, row 85*
20. Kiểm tra chọn giá trị hợp lệ cho trường "Loại LC" — *TC 85, row 86*
21. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Tên khách hàng" (tối đa 140 ký tự) — *TC 86, row 87*
22. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Tên bên thụ hưởng" (tối đa 140 ký tự) — *TC 87, row 88*
23. Kiểm tra định dạng dữ liệu số trường "Số tiền LC" — *TC 88, row 89*
24. Kiểm tra chọn giá trị hợp lệ cho trường "Loại tiền LC" — *TC 89, row 90*
25. Kiểm tra chọn giá trị hợp lệ cho trường "Trạng thái" — *TC 90, row 91*
26. Kiểm tra chức năng nút "Áp dụng" — *TC 91, row 92*
27. Kiểm tra chức năng nút "Xóa bộ lọc" — *TC 92, row 93*
28. Kiểm tra hiển thị trường "STT" — *TC 93, row 94*
29. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "Mã giao dịch" — *TC 94, row 95*
30. Kiểm tra hiển thị trường "Số tham chiếu LC" — *TC 95, row 96*
31. Kiểm tra hiển thị trường "Loại LC" — *TC 96, row 97*
32. Kiểm tra hiển thị trường "Ngày đề nghị" — *TC 97, row 98*
33. Kiểm tra hiển thị trường "Số CIF" — *TC 98, row 99*
34. Kiểm tra hiển thị trường "Tên khách hàng" — *TC 99, row 100*
35. Kiểm tra hiển thị trường "Tên bên thụ hưởng" — *TC 100, row 101*
36. Kiểm tra hiển thị trường "Số hợp đồng" — *TC 101, row 102*
37. Kiểm tra hiển thị trường "Ngày hết hạn" — *TC 102, row 103*
38. Kiểm tra hiển thị trường "Trạng thái" — *TC 103, row 104*
39. Kiểm tra chọn giá trị hợp lệ cho trường "Đề nghị mỗi trang" — *TC 104, row 105*
40. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "Phân trang" — *TC 105, row 106*
41. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "Tạo mới L/C" — *TC 106, row 107*
42. [Ngày đề nghị (Từ ngày - Đến ngày)] Kiểm tra validate khi nhập Từ ngày > Đến ngày tại bộ lọc nâng cao trường "Ngày đề nghị" — *TC 107, row 108*
43. [Ngày đề nghị (Từ ngày - Đến ngày)] Kiểm tra biên khi nhập Từ ngày = Đến ngày tại bộ lọc nâng cao trường "Ngày đề nghị" — *TC 108, row 109*
44. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Số tham chiếu LC" — *TC 109, row 110*
45. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Tên khách hàng" — *TC 110, row 111*
46. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Tên bên thụ hưởng" — *TC 111, row 112*
47. Kiểm tra giới hạn số chữ số nhập trường "Số tiền LC" tại bộ lọc tìm kiếm (tối đa 16 chữ số phần nguyên, 2 chữ số thập phân) — *TC 112, row 113*
48. Kiểm tra giá trị mặc định của trường "Trạng thái" khi truy cập màn hình lần đầu (chưa thao tác chọn) — *TC 113, row 114*
49. Kiểm tra giá trị mặc định của trường "Đề nghị mỗi trang" khi truy cập màn hình lần đầu (chưa thao tác chọn) — *TC 114, row 115*

## Thêm mới – truy cập, điều hướng các bước, tích hợp CIF/hạn mức, Gửi duyệt (11)

1. Kiểm tra quyền truy cập chức năng "Thêm mới" (FO) — *TC 154, row 155*
2. Kiểm tra chặn truy cập chức năng "Thêm mới" (FO) khi không được phân quyền — *TC 155, row 156*
3. Verify hiển thị trạng thái của các step trong màn hình Thêm mới đúng theo mô tả: step đã hoàn thành hiển thị tick xanh, step hiện tại hiển thị ô màu xanh lá, s… — *TC 157, row 158*
4. Verify user có thể click trực tiếp vào số của step đã hoàn thành (đã tick xanh) để chuyển nhanh tới step đó. — *TC 158, row 159*
5. Verify khi step hiện tại chưa hoàn thiện đầy đủ thông tin, hệ thống không cho phép chọn Tiếp tục, Quay lại hoặc chọn vào bất kỳ step nào khác. — *TC 159, row 160*
6. Verify hệ thống hiển thị đúng cảnh báo khi các trường thông tin bắt buộc bị bỏ trống (các trường khác đã nhập/chọn đầy đủ): trường kiểu chọn (select/dropdown/r… — *TC 165, row 166*
7. Verify luồng chính khi user chọn "Gửi duyệt" và toàn bộ thông tin hợp lệ, không có lỗi: hệ thống lưu bản ghi vào CSDL và hiển thị màn hình thông báo thành công. — *TC 166, row 167*
8. Verify khi Gửi duyệt thành công, hệ thống tự động sinh mã đề nghị mới, duy nhất, đúng định dạng "LCddmmyyxxxxISSxxx", và cập nhật trạng thái bản ghi = "Chờ duy… — *TC 167, row 168*
9. Verify sau khi Gửi duyệt thành công, hệ thống chuyển tới màn hình danh sách đề nghị. — *TC 169, row 170*
10. Verify khi user chọn "Đóng" và tại pop-up xác nhận "Hủy tạo mới đề nghị" chọn "Đồng ý", hệ thống đóng màn hình thêm mới, quay về màn danh sách bộ chứng từ và k… — *TC 173, row 174*
11. Verify khi user chọn "Đóng" và tại pop-up xác nhận "Hủy tạo mới đề nghị" chọn "Không", hệ thống chỉ đóng pop-up xác nhận, giữ nguyên màn hình Thêm mới và dữ li… — *TC 174, row 175*

## Thêm mới – rule chung các trường (52)

1. [Địa chỉ công ty (đại diện các trường Text Field áp dụng cùn…] Kiểm tra hệ thống xử lý khi trường bắt buộc chỉ nhập toàn khoảng trắng (space) — *TC 181, row 182*
2. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Chi nhánh" — *TC 182, row 183*
3. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Ô nhập liệu khi chọn LC khác" — *TC 183, row 184*
4. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Tên và địa chỉ" — *TC 184, row 185*
5. Kiểm tra giá trị mặc định của trường "Hình thức phát hành LC" khi truy cập màn hình Thêm mới lần đầu (chưa thao tác chọn) — *TC 185, row 186*
6. Kiểm tra ngày quá khứ được làm mờ (disable) trên lịch và không thể chọn được tại trường "Ngày khởi tạo" — *TC 186, row 187*
7. Kiểm tra chặn khi Ngày khởi tạo nhập muộn hơn Ngày giao hàng muộn nhất (Latest shipment date) — *TC 187, row 188*
8. Kiểm tra giá trị mặc định của trường "Ngày khởi tạo" khi truy cập màn hình Thêm mới lần đầu (chưa thao tác chọn) — *TC 188, row 189*
9. Kiểm tra chặn khi Ngày hết hạn (Expiry date) nhập BẰNG Ngày đề nghị/Ngày phát hành (Application Date) — case biên "=" — *TC 189, row 190*
10. Kiểm tra ngày quá khứ được làm mờ (disable) trên lịch và không thể chọn được tại trường "Ngày hết hạn" — *TC 190, row 191*
11. Kiểm tra chặn khi Ngày hết hạn (Expiry date) nhập BẰNG Ngày giao hàng muộn nhất (Latest shipment date) — case biên "=" — *TC 191, row 192*
12. Kiểm tra chặn khi Ngày hết hạn (Expiry date) nhập NHỎ HƠN (sớm hơn) Ngày đề nghị/Ngày phát hành (Application Date) — case "<" — *TC 192, row 193*
13. Kiểm tra chặn khi Ngày hết hạn (Expiry date) nhập NHỎ HƠN (sớm hơn) Ngày giao hàng muộn nhất (Latest shipment date) — case "<" — *TC 193, row 194*
14. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Nơi hết hạn" — *TC 194, row 195*
15. Kiểm tra hiển thị trường "Ngân hàng thông báo" — *TC 195, row 196*
16. Kiểm tra giá trị mặc định của trường "Địa chỉ Đơn vị phát hành LC" khi truy cập màn hình Thêm mới (tự động lấy theo địa chỉ đơn vị NSD đăng nhập) — *TC 196, row 197*
17. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Tỉnh/Thành phố/Bang của đơn vị phát hành LC" — *TC 197, row 198*
18. Kiểm tra chọn giá trị hợp lệ cho trường "Quốc gia của đơn vị phát hành LC" — *TC 198, row 199*
19. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Mã bưu chính của người yêu cầu mở LC" — *TC 199, row 200*
20. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Tỉnh/Thành phố/Bang của người thụ hưởng" — *TC 200, row 201*
21. Kiểm tra chọn giá trị hợp lệ cho trường "Quốc gia của người thụ hưởng" — *TC 201, row 202*
22. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Mã bưu chính của người thụ hưởng" — *TC 202, row 203*
23. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Số tài khoản" — *TC 203, row 204*
24. Kiểm tra giới hạn số chữ số nhập trường "Dung sai (%)" (tối đa 5 chữ số phần nguyên, 2 chữ số thập phân) — *TC 204, row 205*
25. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Ô nhập khi tick Any bank in city" — *TC 205, row 206*
26. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Ô nhập khi chọn Any bank in country" — *TC 206, row 207*
27. [Yêu cầu xuất trình hối phiếu (Drafts)] Kiểm tra giá trị mặc định = "No" và bị khoá không cho sửa khi mục "This credit is available with" chọn "Deferred Payment" — *TC 207, row 208*
28. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Other" — *TC 208, row 209*
29. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Nơi nhận hàng / Nơi gửi hàng / Nơi nhận hàng để vận chuyển" — *TC 209, row 210*
30. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Cảng xếp hàng / Sân bay khởi hành" — *TC 210, row 211*
31. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Cảng dỡ hàng / Sân bay đến" — *TC 211, row 212*
32. [Cảng dỡ hàng / Sân bay đến (Port of discharge/Airport of de…] Kiểm tra bắt buộc nhập trường "Cảng dỡ hàng / Sân bay đến" khi trường "Cảng xếp hàng / Sân bay khởi hành" đã có giá trị — *TC 212, row 213*
33. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Nơi đến cuối cùng / Nơi vận chuyển đến / Nơi giao hàng" — *TC 213, row 214*
34. Kiểm tra chặn khi Ngày giao hàng muộn nhất (Last Shipment Date) nhập muộn hơn Ngày hết hạn của LC — *TC 214, row 215*
35. [Ngày giao hàng muộn nhất / Kỳ giao hàng (Last Shipment Date…] Kiểm tra khi chọn "Ngày giao hàng muộn nhất" thì trường "Kỳ giao hàng" tự động ẩn đi (và ngược lại) — chỉ được chọn 1 trong 2 theo SRS — *TC 215, row 216*
36. Kiểm tra ngày quá khứ được làm mờ (disable) trên lịch và không thể chọn được tại trường "Ngày giao hàng muộn nhất" — *TC 216, row 217*
37. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Kỳ giao hàng" — *TC 217, row 218*
38. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Ô nhập liệu khi chọn Other" — *TC 218, row 219*
39. [Ô nhập liệu khi chọn Other (Điều kiện Incoterms)] Điều kiện Incoterms — *TC 219, row 220*
40. Kiểm tra danh sách giá trị của trường "Điều kiện Incoterms khác" khi "Điều kiện giao hàng" = INCOTERMS 2020 — *TC 220, row 221*
41. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Quy định vùng địa lý" — *TC 221, row 222*
42. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Mã phân loại hàng hoá" — *TC 222, row 223*
43. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Ô nhập nội dung tên chi nhánh" — *TC 223, row 224*
44. [Ô nhập nội dung khi tick vào Copies] Kiểm tra hiển thị dòng nội dung tĩnh (text hiển thị sẵn) phía sau các giá trị đã tick chọn của Institute Cargo Clause — *TC 224, row 225*
45. Kiểm tra bắt buộc chọn trường "marked freight" sang Mandatory (Y)) — *TC 225, row 226*
46. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Ô Nhập thông tin khi tick chọn Other" — *TC 226, row 227*
47. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Số hợp đồng mua bán" — *TC 227, row 228*
48. Kiểm tra bắt buộc chọn trường "Nguồn tiền thanh toán từ các nguồn" sang Mandatory (M)) — *TC 228, row 229*
49. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Lãi suất UPAS trong hạn" — *TC 229, row 230*
50. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Lãi suất áp dụng đối với dư nợ gốc quá hạn" — *TC 230, row 231*
51. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Lãi suất áp dụng đối với lãi chậm trả" — *TC 231, row 232*
52. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Ô nhập liệu nội dung khác" — *TC 232, row 233*

## Thêm mới – Thông tin khách hàng (14)

1. Kiểm tra bắt buộc nhập trường "Thông tin khách hàng" — *TC 233, row 234*
2. Kiểm tra hiển thị trường "Thông tin khách hàng" — *TC 234, row 235*
3. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "Mã khách hàng" — *TC 235, row 236*
4. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "Tên công ty" — *TC 236, row 237*
5. Kiểm tra hiển thị trường "Số DKKD/MST" — *TC 237, row 238*
6. Kiểm tra bắt buộc nhập trường "Địa chỉ công ty" — *TC 238, row 239*
7. Kiểm tra bắt buộc nhập trường "Người đại diện" — *TC 239, row 240*
8. Kiểm tra chọn giá trị hợp lệ cho trường "Người đại diện" — *TC 240, row 241*
9. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "Chức vụ" — *TC 241, row 242*
10. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "Văn bản ủy quyền" — *TC 242, row 243*
11. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "CCCD/ Hộ chiếu" — *TC 243, row 244*
12. Kiểm tra bắt buộc nhập trường "Hợp đồng hạn mức số" — *TC 244, row 245*
13. Kiểm tra chọn giá trị hợp lệ cho trường "Hợp đồng hạn mức số" — *TC 245, row 246*
14. Kiểm tra bắt buộc nhập trường "Chi nhánh" — *TC 246, row 247*

## Thêm mới – Thông tin LC, ngân hàng, bên phát hành, người hưởng (75)

1. Kiểm tra bắt buộc nhập trường "Loại L/C" — *TC 247, row 248*
2. Kiểm tra danh sách giá trị lựa chọn của trường "Loại L/C" — *TC 248, row 249*
3. Kiểm tra chọn giá trị hợp lệ cho trường "Loại L/C" — *TC 249, row 250*
4. Kiểm tra danh sách giá trị lựa chọn của trường "Loại sản phẩm LC" — *TC 250, row 251*
5. Kiểm tra chọn giá trị hợp lệ cho trường "Loại sản phẩm LC" — *TC 251, row 252*
6. Kiểm tra điều kiện bắt buộc nhập trường "Ô nhập liệu khi chọn LC khác" theo quy tắc nghiệp vụ — *TC 252, row 253*
7. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Ô nhập liệu khi chọn LC khác" (tối đa 200 ký tự) — *TC 253, row 254*
8. Kiểm tra bắt buộc chọn "BIC Code" khi "Thông tin LC xác nhận" = "Other bank" — *TC 254, row 255*
9. Kiểm tra "BIC Code" CHỈ hiển thị khi "Thông tin LC xác nhận" = "Other bank" — *TC 255, row 256*
10. [Tên và địa chỉ] Kiểm tra "Full name & address" hiển thị và cho chỉnh sửa theo BIC code đã chọn khi "Thông tin LC xác nhận" = "Other bank" — *TC 256, row 257*
11. [Tên và địa chỉ] Kiểm tra bắt buộc nhập "Any bank" khi "Thông tin LC xác nhận" = "Any bank" — *TC 257, row 258*
12. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Chi nhánh" (tối đa 140 ký tự) — *TC 258, row 259*
13. Kiểm tra điều kiện bắt buộc nhập trường "BIC code" theo quy tắc nghiệp vụ — *TC 259, row 260*
14. Kiểm tra chọn giá trị hợp lệ cho trường "BIC code" — *TC 260, row 261*
15. Kiểm tra điều kiện bắt buộc nhập trường "BIC code" theo quy tắc nghiệp vụ — *TC 261, row 262*
16. Kiểm tra chọn giá trị hợp lệ cho trường "BIC code" — *TC 262, row 263*
17. Kiểm tra bắt buộc chọn "BIC Code" khi "Thông tin LC chuyển nhượng" = "Other bank" — *TC 263, row 264*
18. Kiểm tra chọn giá trị hợp lệ cho trường "BIC code" — *TC 264, row 265*
19. [Tên và địa chỉ] Kiểm tra bắt buộc chọn "BIC Code" khi "Thông tin LC chuyển nhượng" = "Other bank" — *TC 265, row 266*
20. [Tên và địa chỉ] Kiểm tra "BIC Code" CHỈ hiển thị khi "Thông tin LC chuyển nhượng" = "Other bank" — *TC 266, row 267*
21. [Tên và địa chỉ] Kiểm tra "Full name & address" hiển thị theo BIC code đã chọn và KHÔNG cho chỉnh sửa khi "Thông tin LC chuyển nhượng" = "Other bank" — *TC 267, row 268*
22. [Tên và địa chỉ] Kiểm tra bắt buộc nhập "Any bank" khi "Thông tin LC chuyển nhượng" = "Any bank" — *TC 268, row 269*
23. Kiểm tra điều kiện bắt buộc nhập trường "Tên và địa chỉ" theo quy tắc nghiệp vụ — *TC 269, row 270*
24. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Tên và địa chỉ" (tối đa 1024 ký tự) — *TC 270, row 271*
25. Kiểm tra bắt buộc nhập trường "Hình thức phát hành LC" — *TC 271, row 272*
26. Kiểm tra danh sách giá trị lựa chọn của trường "Hình thức phát hành LC" — *TC 272, row 273*
27. Kiểm tra chọn giá trị hợp lệ cho trường "Hình thức phát hành LC" — *TC 273, row 274*
28. Kiểm tra bắt buộc nhập trường "Yêu cầu chữ ký số trên điện LC" — *TC 274, row 275*
29. Kiểm tra danh sách giá trị lựa chọn của trường "Yêu cầu chữ ký số trên điện LC" — *TC 275, row 276*
30. Kiểm tra chọn giá trị hợp lệ cho trường "Yêu cầu chữ ký số trên điện LC" — *TC 276, row 277*
31. Kiểm tra bắt buộc nhập trường "Ngày khởi tạo" — *TC 277, row 278*
32. Kiểm tra định dạng ngày trường "Ngày khởi tạo" — *TC 278, row 279*
33. Kiểm tra nhập giá trị ngày hợp lệ trường "Ngày khởi tạo" — *TC 279, row 280*
34. Kiểm tra bắt buộc nhập trường "Ngày hết hạn" — *TC 280, row 281*
35. Kiểm tra định dạng ngày trường "Ngày hết hạn" — *TC 281, row 282*
36. Kiểm tra nhập giá trị ngày hợp lệ trường "Ngày hết hạn" — *TC 282, row 283*
37. Kiểm tra bắt buộc nhập trường "Nơi hết hạn" — *TC 283, row 284*
38. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Nơi hết hạn" (tối đa 29 ký tự) — *TC 284, row 285*
39. Kiểm tra bắt buộc nhập trường "Ngân hàng bên thụ hưởng" — *TC 285, row 286*
40. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "Ngân hàng thông báo" — *TC 286, row 287*
41. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "Thông tin bên phát hành" — *TC 287, row 288*
42. Kiểm tra bắt buộc nhập trường "Tên Đơn vị phát hành LC" — *TC 288, row 289*
43. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Tên Đơn vị phát hành LC" (tối đa 140 ký tự) — *TC 289, row 290*
44. Kiểm tra bắt buộc nhập trường "Địa chỉ Đơn vị phát hành LC" — *TC 290, row 291*
45. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Địa chỉ Đơn vị phát hành LC" (tối đa 140 ký tự) — *TC 291, row 292*
46. Kiểm tra bắt buộc nhập trường "Tỉnh/Thành phố/Bang của đơn vị phát hành LC" — *TC 292, row 293*
47. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Tỉnh/Thành phố/Bang của đơn vị phát hành LC" (tối đa 35 ký tự) — *TC 293, row 294*
48. Kiểm tra bắt buộc nhập trường "Quốc gia của đơn vị phát hành LC" — *TC 294, row 295*
49. Kiểm tra danh sách giá trị lựa chọn của trường "Quốc gia của đơn vị phát hành LC" (SRS mới: đổi từ Text Field sang Dropdown) — *TC 295, row 296*
50. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Mã bưu chính của người yêu cầu mở LC" (tối đa 16 ký tự) — *TC 296, row 297*
51. Kiểm tra bắt buộc nhập trường "Tên Người hưởng" — *TC 297, row 298*
52. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Tên Người hưởng" (tối đa 140 ký tự) — *TC 298, row 299*
53. Kiểm tra bắt buộc nhập trường "Địa chỉ Người hưởng" — *TC 299, row 300*
54. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Địa chỉ Người hưởng" (tối đa 140 ký tự) — *TC 300, row 301*
55. Kiểm tra bắt buộc nhập trường "Tỉnh/Thành phố/Bang của người thụ hưởng" — *TC 301, row 302*
56. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Tỉnh/Thành phố/Bang của người thụ hưởng" (tối đa 35 ký tự) — *TC 302, row 303*
57. Kiểm tra bắt buộc nhập trường "Quốc gia của người thụ hưởng" — *TC 303, row 304*
58. Kiểm tra danh sách giá trị lựa chọn của trường "Quốc gia của người thụ hưởng" (SRS mới: đổi từ Text Field sang Dropdown) — *TC 304, row 305*
59. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Mã bưu chính của người thụ hưởng" (tối đa 16 ký tự) — *TC 305, row 306*
60. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Số tài khoản" (tối đa 100 ký tự) — *TC 306, row 307*
61. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "Lưu danh sách người thụ hưởng" — *TC 307, row 308*
62. Kiểm tra chức năng nút "Tìm kiếm" — *TC 308, row 309*
63. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "Danh sách người thụ hưởng" — *TC 309, row 310*
64. Kiểm tra chọn giá trị hợp lệ cho trường "Icon chọn" — *TC 310, row 311*
65. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "STT" — *TC 311, row 312*
66. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "Tên người thụ hưởng" — *TC 312, row 313*
67. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "Địa chỉ người thụ hưởng" — *TC 313, row 314*
68. Kiểm tra chức năng nút "Đóng" tại màn hình danh sách người thụ hưởng — *TC 314, row 315*
69. Kiểm tra chức năng nút "Xác nhận" — *TC 315, row 316*
70. Kiểm tra điều kiện bắt buộc nhập trường "BIC code" theo quy tắc nghiệp vụ — *TC 316, row 317*
71. Kiểm tra chọn giá trị hợp lệ cho trường "BIC code" — *TC 317, row 318*
72. Kiểm tra điều kiện bắt buộc nhập trường "Tên và địa chỉ" theo quy tắc nghiệp vụ — *TC 318, row 319*
73. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Tên và địa chỉ" (tối đa 1024 ký tự) — *TC 319, row 320*
74. Kiểm tra điều kiện bắt buộc nhập trường "Tên và địa chỉ" theo quy tắc nghiệp vụ — *TC 320, row 321*
75. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Tên và địa chỉ" (tối đa 200 ký tự) — *TC 321, row 322*

## Thêm mới – Giá trị LC, dung sai (10)

1. Kiểm tra bắt buộc nhập trường "Giá trị LC" — *TC 322, row 323*
2. Kiểm tra hiển thị và nhập dữ liệu hợp lệ cho trường "Dung sai (%)" (Optional) — *TC 323, row 324*
3. Kiểm tra định dạng dữ liệu số trường "Dung sai (%)" — *TC 324, row 325*
4. Kiểm tra bắt buộc nhập trường "Thư tín dụng có giá trị tại" — *TC 325, row 326*
5. Kiểm tra danh sách giá trị lựa chọn của trường "Thư tín dụng có giá trị tại" — *TC 326, row 327*
6. Kiểm tra chọn giá trị hợp lệ cho trường "Thư tín dụng có giá trị tại" — *TC 327, row 328*
7. Kiểm tra điều kiện bắt buộc nhập trường "Ô nhập khi tick Any bank in city" theo quy tắc nghiệp vụ — *TC 328, row 329*
8. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Ô nhập khi tick Any bank in city" (tối đa 100 ký tự) — *TC 329, row 330*
9. Kiểm tra điều kiện bắt buộc nhập trường "Ô nhập khi chọn Any bank in country" theo quy tắc nghiệp vụ — *TC 330, row 331*
10. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Ô nhập khi chọn Any bank in country" (tối đa 100 ký tự) — *TC 331, row 332*

## Thêm mới – Phương thức thanh toán, hối phiếu, kỳ hạn (20)

1. Kiểm tra bắt buộc nhập trường "Phương thức thanh toán của LC" — *TC 332, row 333*
2. Kiểm tra danh sách giá trị lựa chọn của trường "Phương thức thanh toán của LC" — *TC 333, row 334*
3. Kiểm tra chọn giá trị hợp lệ cho trường "Phương thức thanh toán của LC" — *TC 334, row 335*
4. Kiểm tra bắt buộc nhập trường "Yêu cầu xuất trình hối phiếu" — *TC 335, row 336*
5. Kiểm tra danh sách giá trị lựa chọn của trường "Yêu cầu xuất trình hối phiếu" — *TC 336, row 337*
6. Kiểm tra chọn giá trị hợp lệ cho trường "Yêu cầu xuất trình hối phiếu" — *TC 337, row 338*
7. Kiểm tra bắt buộc nhập trường "Kỳ hạn thanh toán" — *TC 338, row 339*
8. Kiểm tra danh sách giá trị lựa chọn của trường "Kỳ hạn thanh toán" — *TC 339, row 340*
9. Kiểm tra chọn giá trị hợp lệ cho trường "Kỳ hạn thanh toán" — *TC 340, row 341*
10. Kiểm tra điều kiện bắt buộc nhập trường "Số Days/Months/Years" theo quy tắc nghiệp vụ — *TC 341, row 342*
11. Kiểm tra định dạng dữ liệu số trường "Số Days/Months/Years" — *TC 342, row 343*
12. Kiểm tra định dạng ngày trường "Ô nhập ngày khi chọn Maturity date" — *TC 343, row 344*
13. Kiểm tra nhập giá trị ngày hợp lệ trường "Ô nhập ngày khi chọn Maturity date" — *TC 344, row 345*
14. Kiểm tra bắt buộc nhập trường "Thông tin về người trả tiền trên Hối phiếu" — *TC 345, row 346*
15. Kiểm tra điều kiện bắt buộc nhập trường "Thông tin về người trả tiền trên Hối phiếu" theo quy tắc nghiệp vụ — *TC 346, row 347*
16. Kiểm tra danh sách giá trị lựa chọn của trường "Thông tin về người trả tiền trên Hối phiếu" — *TC 347, row 348*
17. Kiểm tra chọn giá trị hợp lệ cho trường "Thông tin về người trả tiền trên Hối phiếu" — *TC 348, row 349*
18. Kiểm tra chọn giá trị hợp lệ cho trường "Other bank" — *TC 349, row 350*
19. Kiểm tra điều kiện bắt buộc nhập trường "Other" theo quy tắc nghiệp vụ — *TC 350, row 351*
20. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Other" (tối đa 200 ký tự) — *TC 351, row 352*

## Thêm mới – Giao hàng & hàng hoá (36)

1. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Nơi nhận hàng / Nơi gửi hàng / Nơi nhận hàng để vận chuyển" (tối đa 65 ký tự) — *TC 352, row 353*
2. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Cảng xếp hàng / Sân bay khởi hành" (tối đa 65 ký tự) — *TC 353, row 354*
3. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Cảng dỡ hàng / Sân bay đến" (tối đa 65 ký tự) — *TC 354, row 355*
4. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Nơi đến cuối cùng / Nơi vận chuyển đến / Nơi giao hàng" (tối đa 65 ký tự) — *TC 355, row 356*
5. Kiểm tra bắt buộc nhập trường "Giao hàng từng phần" — *TC 356, row 357*
6. Kiểm tra danh sách giá trị lựa chọn của trường "Giao hàng từng phần" — *TC 357, row 358*
7. Kiểm tra chọn giá trị hợp lệ cho trường "Giao hàng từng phần" — *TC 358, row 359*
8. Kiểm tra bắt buộc nhập trường "Chuyển tải" — *TC 359, row 360*
9. Kiểm tra danh sách giá trị lựa chọn của trường "Chuyển tải" — *TC 360, row 361*
10. Kiểm tra chọn giá trị hợp lệ cho trường "Chuyển tải" — *TC 361, row 362*
11. Kiểm tra bắt buộc nhập trường "Ngày giao hàng muộn nhất" — *TC 362, row 363*
12. Kiểm tra định dạng ngày trường "Ngày giao hàng muộn nhất" — *TC 363, row 364*
13. Kiểm tra nhập giá trị ngày hợp lệ trường "Ngày giao hàng muộn nhất" — *TC 364, row 365*
14. Kiểm tra bắt buộc nhập trường "Kỳ giao hàng" — *TC 365, row 366*
15. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Kỳ giao hàng" (tối đa 390 ký tự) — *TC 366, row 367*
16. Kiểm tra bắt buộc nhập trường "Điều kiện giao hàng" — *TC 367, row 368*
17. Kiểm tra danh sách giá trị lựa chọn của trường "Điều kiện giao hàng" — *TC 368, row 369*
18. Kiểm tra chọn giá trị hợp lệ cho trường "Điều kiện giao hàng" — *TC 369, row 370*
19. Kiểm tra bắt buộc nhập trường "Điều kiện Incoterms" — *TC 370, row 371*
20. Kiểm tra danh sách giá trị lựa chọn của trường "Điều kiện Incoterms" — *TC 371, row 372*
21. Kiểm tra chọn giá trị hợp lệ cho trường "Điều kiện Incoterms" — *TC 372, row 373*
22. Kiểm tra bắt buộc nhập trường "Ô nhập liệu khi chọn Other" — *TC 373, row 374*
23. Kiểm tra điều kiện bắt buộc nhập trường "Ô nhập liệu khi chọn Other" theo quy tắc nghiệp vụ — *TC 374, row 375*
24. Kiểm tra danh sách giá trị của trường "Điều kiện Incoterms khác" khi "Điều kiện giao hàng" = INCOTERMS 2010 — *TC 375, row 376*
25. Kiểm tra danh sách giá trị của trường "Điều kiện Incoterms khác" khi "Điều kiện giao hàng" = INCOTERMS 2000 — *TC 376, row 377*
26. Kiểm tra bắt buộc nhập trường "Quy định vùng địa lý" — *TC 377, row 378*
27. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Quy định vùng địa lý" (tối đa 60 ký tự) — *TC 378, row 379*
28. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Mã phân loại hàng hoá" (tối đa 12 ký tự) — *TC 379, row 380*
29. Kiểm tra hiển thị khối "Mô tả hàng hoá" (Description of Goods and/or Services - đổi cấu trúc SRS mới thành 2 checkbox Goods/Services) — *TC 380, row 381*
30. [Goods / Services] Kiểm tra bắt buộc tick chọn TỐI THIỂU 1 trong 2 giá trị "Goods" hoặc "Services" — *TC 381, row 382*
31. [Ô nhập nội dung Goods / Ô nhập nội dung Services] Kiểm tra hệ thống chặn NGAY KHI NHẬP LIỆU khi tổng ký tự của 2 trường "Ô nhập nội dung Goods" + "Ô nhập nội dung Services" vượt quá 6000 ký tự — *TC 382, row 383*
32. Kiểm tra hiển thị và bắt buộc nhập "Ô nhập nội dung Goods" khi tick chọn "Goods" — *TC 383, row 384*
33. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Ô nhập nội dung tên chi nhánh" (tối đa 100 ký tự) — *TC 384, row 385*
34. Kiểm tra danh sách giá trị lựa chọn của trường "Ô nội dung nhập khi tick vào Original" — *TC 385, row 386*
35. Kiểm tra chọn giá trị hợp lệ cho trường "Ô nội dung nhập khi tick vào Original" — *TC 386, row 387*
36. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "Ô nhập nội dung khi tick vào Copies" — *TC 387, row 388*

## Thêm mới – Điều khoản bổ sung (16)

1. Kiểm tra chọn giá trị hợp lệ cho trường "Điều khoản bổ sung" — *TC 388, row 389*
2. Kiểm tra chọn giá trị hợp lệ cho trường "Điều khoản bổ sung" — *TC 389, row 390*
3. Kiểm tra bắt buộc nhập trường "Ô nhập ngày" — *TC 390, row 391*
4. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Ô nhập ngày" (tối đa 3 ký tự) — *TC 391, row 392*
5. Kiểm tra định dạng dữ liệu số trường "Ô nhập ngày" — *TC 392, row 393*
6. Kiểm tra bắt buộc nhập trường "Ô nhập nội dung" — *TC 393, row 394*
7. [Regardless of the L/C tenor, payment under this L/C is avai…] Kiểm tra hiển thị trường "Regardless of the L/C tenor, payment under this L/C is available at" — *TC 394, row 395*
8. Kiểm tra hiển thị trường "Regardless of the L/C tenor, payment under this L/C is available at" khi Loại LC là UPAS hoặc UPAS PLUS — *TC 395, row 396*
9. [Regardless of the L/C tenor, payment under this L/C is avai…] Kiểm tra bắt buộc chọn trường "Regardless of the L/C tenor, payment under this L/C is available at" (Mandatory) — *TC 396, row 397*
10. [Regardless of the L/C tenor, payment under this L/C is avai…] Kiểm tra danh sách giá trị lựa chọn của trường "Regardless of the L/C tenor, payment under this L/C is available at" (2 giá trị) — *TC 397, row 398*
11. [Regardless of the L/C tenor, payment under this L/C is avai…] Kiểm tra giá trị mặc định "Sight basis" khi Loại LC = UPAS, cho phép sửa lại — *TC 398, row 399*
12. [Regardless of the L/C tenor, payment under this L/C is avai…] Kiểm tra giá trị mặc định "at [Ô nhập ngày] days after [Ô nhập nội dung]" khi Loại LC = UPAS PLUS, cho phép sửa lại — *TC 399, row 400*
13. [Ô nhập ngày (Regardless of the L/C tenor...)] Regardless of the L/C tenor... — *TC 400, row 401*
14. [Ô nhập ngày (Regardless of the L/C tenor...)] Regardless of the L/C tenor... — *TC 401, row 402*
15. [Ô nhập nội dung (Regardless of the L/C tenor...)] Regardless of the L/C tenor... — *TC 402, row 403*
16. [Ô nhập nội dung (Regardless of the L/C tenor...)] Regardless of the L/C tenor... — *TC 403, row 404*

## Thêm mới – Phí & thời hạn xuất trình (38)

1. Kiểm tra bắt buộc nhập trường "Ô nhập liệu khi chọn Other" — *TC 404, row 405*
2. Kiểm tra điều kiện bắt buộc nhập trường "Ô nhập liệu khi chọn Other" theo quy tắc nghiệp vụ — *TC 405, row 406*
3. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Ô nhập liệu khi chọn Other" (tối đa 1500 ký tự) — *TC 406, row 407*
4. [Ô nhập liệu khi chọn Other (Phí)] Phí — *TC 407, row 408*
5. [Ô nhập liệu khi chọn Other (Phí)] Phí — *TC 408, row 409*
6. Kiểm tra bắt buộc nhập trường "Phí" — *TC 409, row 410*
7. Kiểm tra chọn giá trị hợp lệ cho trường "Phí" — *TC 410, row 411*
8. Kiểm tra hiển thị trường "Phí" (mới bổ sung) khi Loại LC = Regular — *TC 411, row 412*
9. Kiểm tra bắt buộc chọn trường "Phí" (Mandatory) — *TC 412, row 413*
10. Kiểm tra danh sách giá trị lựa chọn của trường "Phí" (6 giá trị) — *TC 413, row 414*
11. Kiểm tra hiển thị trường "Trường hợp LC xác nhận/ Có thể xác nhận" — *TC 414, row 415*
12. Kiểm tra danh sách giá trị lựa chọn của trường "Phí xác nhận do" — *TC 415, row 416*
13. Kiểm tra danh sách giá trị lựa chọn của trường "Phí xác nhận do" — *TC 416, row 417*
14. Kiểm tra chọn giá trị hợp lệ cho trường "Phí xác nhận do" — *TC 417, row 418*
15. Kiểm tra hiển thị trường "Trường hợp LC chuyển nhượng" — *TC 418, row 419*
16. Kiểm tra bắt buộc nhập trường "Phí chuyển nhượng do" — *TC 419, row 420*
17. Kiểm tra danh sách giá trị lựa chọn của trường "Phí chuyển nhượng do" — *TC 420, row 421*
18. Kiểm tra chọn giá trị hợp lệ cho trường "Phí chuyển nhượng do" — *TC 421, row 422*
19. Kiểm tra hiển thị trường "Trường hợp LC xác nhận/ Có thể xác nhận" — *TC 422, row 423*
20. Kiểm tra bắt buộc nhập trường "Phí xác nhận do" — *TC 423, row 424*
21. Kiểm tra danh sách giá trị lựa chọn của trường "Phí xác nhận do" — *TC 424, row 425*
22. Kiểm tra chọn giá trị hợp lệ cho trường "Phí xác nhận do" — *TC 425, row 426*
23. Kiểm tra hiển thị trường "Trường hợp LC chuyển nhượng" — *TC 426, row 427*
24. Kiểm tra bắt buộc nhập trường "Phí chuyển nhượng do" — *TC 427, row 428*
25. Kiểm tra danh sách giá trị lựa chọn của trường "Phí chuyển nhượng do" — *TC 428, row 429*
26. Kiểm tra chọn giá trị hợp lệ cho trường "Phí chuyển nhượng do" — *TC 429, row 430*
27. Kiểm tra điều kiện bắt buộc nhập trường "Ô Nhập thông tin khi tick chọn Other" theo quy tắc nghiệp vụ — *TC 430, row 431*
28. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Ô Nhập thông tin khi tick chọn Other" (tối đa 200 ký tự) — *TC 431, row 432*
29. Kiểm tra hiển thị nhãn "Phí giao dịch" khi Loại LC = UPAS/UPAS PLUS (trường mới bổ sung) — *TC 432, row 433*
30. Kiểm tra bắt buộc chọn trường "a. Phí chấp nhận thanh toán" (Mandatory, chỉ hiển thị khi UPAS/UPAS PLUS) — *TC 433, row 434*
31. Kiểm tra hiển thị/nhập liệu "Ô nhập liệu khác" khi chọn "a. Phí chấp nhận thanh toán" = Khác/Other — *TC 434, row 435*
32. Kiểm tra hiển thị/nhập liệu "Ô nhập liệu khác" khi chọn "a. Phí chấp nhận thanh toán" = Khác/Other — *TC 435, row 436*
33. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "b. Phí trả nợ trước hạn" (trường mới bổ sung) — *TC 436, row 437*
34. Kiểm tra bắt buộc nhập trường "Ô nhập liệu khi chọn Other" — *TC 437, row 438*
35. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Ô nhập liệu khi chọn Other" (tối đa 1500 ký tự) — *TC 438, row 439*
36. Kiểm tra bắt buộc nhập trường "Thời hạn xuất trình chứng từ" — *TC 439, row 440*
37. Kiểm tra danh sách giá trị lựa chọn của trường "Thời hạn xuất trình chứng từ" — *TC 440, row 441*
38. Kiểm tra chọn giá trị hợp lệ cho trường "Thời hạn xuất trình chứng từ" — *TC 441, row 442*

## Thêm mới – Thông tin khác, nguồn tiền, lãi suất, trả nợ (61)

1. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Thông tin khác" (tối đa 6500 ký tự) — *TC 442, row 443*
2. Kiểm tra bắt buộc nhập trường "Số hợp đồng mua bán" — *TC 443, row 444*
3. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Số hợp đồng mua bán" (tối đa 200 ký tự) — *TC 444, row 445*
4. Kiểm tra bắt buộc nhập trường "Ngày ký hợp đồng" — *TC 445, row 446*
5. Kiểm tra định dạng ngày trường "Ngày ký hợp đồng" — *TC 446, row 447*
6. Kiểm tra nhập giá trị ngày hợp lệ trường "Ngày ký hợp đồng" — *TC 447, row 448*
7. Kiểm tra danh sách giá trị lựa chọn của trường "Đây là giao dịch kinh doanh hàng hóa tạm nhập tái xuất" — *TC 448, row 449*
8. Kiểm tra danh sách giá trị lựa chọn của trường "Đây là giao dịch kinh doanh hàng hóa tạm nhập tái xuất" — *TC 449, row 450*
9. Kiểm tra chọn giá trị hợp lệ cho trường "Đây là giao dịch kinh doanh hàng hóa tạm nhập tái xuất" — *TC 450, row 451*
10. Kiểm tra bắt buộc nhập trường "Đây là giao dịch kinh doanh hàng hóa chuyển khẩu" — *TC 451, row 452*
11. Kiểm tra danh sách giá trị lựa chọn của trường "Đây là giao dịch kinh doanh hàng hóa chuyển khẩu" — *TC 452, row 453*
12. Kiểm tra chọn giá trị hợp lệ cho trường "Đây là giao dịch kinh doanh hàng hóa chuyển khẩu" — *TC 453, row 454*
13. Kiểm tra bắt buộc nhập trường "Khách hàng là Tổ chức kinh tế" — *TC 454, row 455*
14. Kiểm tra chọn giá trị hợp lệ cho trường "Khách hàng là Tổ chức kinh tế" — *TC 455, row 456*
15. Kiểm tra chọn giá trị hợp lệ cho trường "Khách hàng là Tổ chức kinh tế" — *TC 456, row 457*
16. Kiểm tra hiển thị trường "Thanh toán trả trước" (Advanced Payment - — *TC 457, row 458*
17. Kiểm tra bắt buộc chọn trường "Thanh toán trả trước" (Mandatory) — *TC 458, row 459*
18. Kiểm tra danh sách giá trị lựa chọn của trường "Thanh toán trả trước" (2 giá trị) — *TC 459, row 460*
19. Kiểm tra khi chọn "Thanh toán trả trước" = "Có" và "Description of Goods/Services" tích Goods thì kích hoạt khối Cam kết bổ sung chứng từ tương ứng — *TC 460, row 461*
20. Kiểm tra điều kiện bắt buộc nhập trường "Số tài khoản" theo quy tắc nghiệp vụ — *TC 461, row 462*
21. Kiểm tra chọn giá trị hợp lệ cho trường "Số tài khoản" — *TC 462, row 463*
22. Kiểm tra danh sách giá trị lựa chọn của trường "Nguồn tiền thanh toán từ các nguồn" — *TC 463, row 464*
23. Kiểm tra chọn giá trị hợp lệ cho trường "Nguồn tiền thanh toán từ các nguồn" — *TC 464, row 465*
24. [Nguồn tiền thanh toán từ các nguồn] Kiểm tra tick chọn "Deposit/ Ký quỹ" — trường "Số tài khoản" hiển thị danh sách tài khoản thanh toán (D/S/T) của khách hàng — *TC 465, row 466*
25. [Nguồn tiền thanh toán từ các nguồn] Kiểm tra tick chọn "Loan/ Vay" — trường "Số tài khoản" hiển thị danh sách hợp đồng tín dụng (Facility number) — *TC 466, row 467*
26. [Nguồn tiền thanh toán từ các nguồn] Kiểm tra tick chọn "Non-deposit/ Miễn ký quỹ" — trường "Số tài khoản" hiển thị danh sách hợp đồng tín dụng (Facility number) — *TC 467, row 468*
27. [Nguồn tiền thanh toán từ các nguồn] Kiểm tra hiển thị "Số tài khoản" dạng bảng, tách riêng từng mục theo từng loại nguồn tiền đã tick khi chọn đồng thời nhiều giá trị — *TC 468, row 469*
28. Kiểm tra định dạng dữ liệu số trường "Tỷ lệ (%)" — *TC 469, row 470*
29. Kiểm tra điều kiện bắt buộc nhập trường "Số tiền" theo quy tắc nghiệp vụ — *TC 470, row 471*
30. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Số tiền" (tối đa 16 ký tự) — *TC 471, row 472*
31. Kiểm tra định dạng dữ liệu số trường "Số tiền" — *TC 472, row 473*
32. Kiểm tra bắt buộc nhập trường "Tài khoản thu phí liên quan đến LC" — *TC 473, row 474*
33. Kiểm tra chọn giá trị hợp lệ cho trường "Tài khoản thu phí liên quan đến LC" — *TC 474, row 475*
34. Kiểm tra bắt buộc nhập trường "Ô text khi nhập nội dung khác" — *TC 475, row 476*
35. Kiểm tra điều kiện bắt buộc nhập trường "Ô text khi nhập nội dung khác" theo quy tắc nghiệp vụ — *TC 476, row 477*
36. Kiểm tra bắt buộc nhập trường "Ô text khi nhập nội dung khác" — *TC 477, row 478*
37. Kiểm tra bắt buộc nhập trường "Ô text khi nhập nội dung khác" — *TC 478, row 479*
38. Kiểm tra điều kiện bắt buộc nhập trường "Ô text khi nhập nội dung khác" theo quy tắc nghiệp vụ — *TC 479, row 480*
39. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Ô text khi nhập nội dung khác" (tối đa 2000 ký tự) — *TC 480, row 481*
40. Kiểm tra bắt buộc nhập trường "Phương thức trả nợ lãi" — *TC 481, row 482*
41. Kiểm tra danh sách giá trị lựa chọn của trường "Phương thức trả nợ lãi" — *TC 482, row 483*
42. Kiểm tra chọn giá trị hợp lệ cho trường "Phương thức trả nợ lãi" — *TC 483, row 484*
43. Kiểm tra hiển thị trường "Lãi suất áp dụng" — *TC 484, row 485*
44. Kiểm tra bắt buộc nhập trường "Lãi suất UPAS trong hạn" — *TC 485, row 486*
45. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Lãi suất UPAS trong hạn" (tối đa 100 ký tự) — *TC 486, row 487*
46. Kiểm tra bắt buộc nhập trường "Lãi suất áp dụng đối với dư nợ gốc quá hạn" — *TC 487, row 488*
47. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Lãi suất áp dụng đối với dư nợ gốc quá hạn" (tối đa 100 ký tự) — *TC 488, row 489*
48. Kiểm tra bắt buộc nhập trường "Lãi suất áp dụng đối với lãi chậm trả" — *TC 489, row 490*
49. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Lãi suất áp dụng đối với lãi chậm trả" (tối đa 100 ký tự) — *TC 490, row 491*
50. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "Khác" — *TC 491, row 492*
51. Kiểm tra bắt buộc nhập trường "Ô nhập liệu nội dung khác" — *TC 492, row 493*
52. Kiểm tra điều kiện bắt buộc nhập trường "Ô nhập liệu nội dung khác" theo quy tắc nghiệp vụ — *TC 493, row 494*
53. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Ô nhập liệu nội dung khác" (tối đa 2000 ký tự) — *TC 494, row 495*
54. [Ô text khi nhập nội dung khác (Phương thức trả nợ gốc)] Phương thức trả nợ gốc — *TC 495, row 496*
55. Kiểm tra hiển thị nhãn "Phương thức trả nợ gốc và lãi" khi Loại LC = UPAS/UPAS PLUS (trường mới bổ sung) — *TC 496, row 497*
56. Kiểm tra bắt buộc chọn trường "a. Phương thức trả nợ gốc" (Mandatory, trường mới bổ sung) — *TC 497, row 498*
57. Kiểm tra danh sách giá trị lựa chọn của trường "a. Phương thức trả nợ gốc" (2 giá trị) — *TC 498, row 499*
58. Kiểm tra chức năng nút "Đóng" — *TC 499, row 500*
59. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "Phương thức trả nợ lãi" — *TC 500, row 501*
60. Kiểm tra bắt buộc nhập trường "Đồng ý" — *TC 501, row 502*
61. Kiểm tra chọn giá trị hợp lệ cho trường "Đồng ý" — *TC 502, row 503*

## Thêm mới – Điều khoản & điều kiện, Hồ sơ đính kèm (30)

1. Kiểm tra bắt buộc nhập trường "Điều khoản và điều kiện" — *TC 503, row 504*
2. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "Màn hình popup khi bấm vào hyperlink xem" — *TC 504, row 505*
3. [STT (Bảng tài liệu đính kèm)] Kiểm tra STT tự động đánh số tăng dần từ 01 và sắp xếp tài liệu cũ nhất lên đầu — *TC 505, row 506*
4. Kiểm tra chức năng nút "Đóng" — *TC 506, row 507*
5. [Đóng (popup Thêm tài liệu)] Kiểm tra chức năng nút "Đóng" trong popup Thêm tài liệu - không lưu thông tin đã nhập/chọn — *TC 507, row 508*
6. Kiểm tra xóa thành công 1 tài liệu khi xác nhận "Có" tại popup xác nhận xóa — *TC 508, row 509*
7. Kiểm tra không xóa tài liệu khi xác nhận "Không" tại popup xác nhận xóa — *TC 509, row 510*
8. [Hồ sơ đính kèm / Bảng tài liệu đính kèm] Kiểm tra chức năng "Xoá" 1 tài liệu — chỉ áp dụng khi CHƯA Xác nhận bổ sung — *TC 510, row 511*
9. Kiểm tra chặn khi Gửi duyệt mà chưa đính kèm tài liệu nào (bắt buộc tối thiểu 01 tài liệu) — *TC 511, row 512*
10. [Thêm mới (Add New) - Hồ sơ đính kèm] Kiểm tra đầy đủ hành vi nút "Thêm mới": vị trí hiển thị thay đổi theo trạng thái danh sách và chức năng mở popup — *TC 512, row 513*
11. [Thêm mới (nút, khu vực Hồ sơ đính kèm)] Kiểm tra chức năng nút "Thêm mới" mở popup "Thêm tài liệu" — *TC 513, row 514*
12. Kiểm tra Bảng tài liệu đính kèm hiển thị đầy đủ cột khi đã có ít nhất 1 tài liệu — *TC 514, row 515*
13. [Xóa tất cả (Bảng tài liệu đính kèm) - chỉ hiển thị khi có d…] Kiểm tra liên kết "Xóa tất cả" KHÔNG hiển thị khi bảng chưa có tài liệu nào — *TC 515, row 516*
14. [Tên tài liệu (Bảng tài liệu đính kèm)] Kiểm tra chức năng nút "Thêm mới" mở popup Thêm tài liệu (Bổ sung hồ sơ) — *TC 516, row 517*
15. Kiểm tra bắt buộc chọn trường "Loại tài liệu" trong popup Thêm tài liệu — *TC 517, row 518*
16. [Hình thức (popup Thêm tài liệu)] Kiểm tra bắt buộc chọn trường "Hình thức" trong popup Thêm tài liệu — *TC 518, row 519*
17. [Hình thức (popup Thêm tài liệu)] Kiểm tra danh sách giá trị lựa chọn của trường "Hình thức" trong popup Thêm tài liệu — *TC 519, row 520*
18. [Icon xem tài liệu (Bảng tài liệu đính kèm)] Bảng tài liệu đính kèm — *TC 520, row 521*
19. [Icon tải xuống (Bảng tài liệu đính kèm)] Bảng tài liệu đính kèm — *TC 521, row 522*
20. [Icon chỉnh sửa (Bảng tài liệu đính kèm)] Bảng tài liệu đính kèm — *TC 522, row 523*
21. Kiểm tra chức năng "Icon xóa" hiển thị popup xác nhận trước khi xóa 1 tài liệu — *TC 523, row 524*
22. Kiểm tra chặn file sai định dạng khi tải lên trong popup Thêm tài liệu (Bổ sung hồ sơ) — *TC 524, row 525*
23. Kiểm tra bắt buộc phải tải lên tối thiểu 1 file trong popup Thêm tài liệu — *TC 525, row 526*
24. [Kéo hoặc thả tập tin vào đây (popup Thêm tài liệu)] popup Thêm tài liệu — *TC 526, row 527*
25. [Kéo hoặc thả tập tin vào đây (popup Thêm tài liệu)] popup Thêm tài liệu — *TC 527, row 528*
26. [Kéo hoặc thả tập tin vào đây (popup Thêm tài liệu)] popup Thêm tài liệu — *TC 528, row 529*
27. [Kéo hoặc thả tập tin vào đây (popup Thêm tài liệu)] popup Thêm tài liệu — *TC 529, row 530*
28. [Chọn tệp tin (popup Thêm tài liệu)] popup Thêm tài liệu — *TC 530, row 531*
29. [Tên file đã chọn (popup Thêm tài liệu)] popup Thêm tài liệu — *TC 531, row 532*
30. [Lưu (popup Thêm tài liệu)] Kiểm tra chức năng nút "Lưu" khi đã nhập/chọn đầy đủ thông tin hợp lệ (thêm mới tài liệu) — *TC 532, row 533*

## Thêm mới – Các nút cuối màn hình (8)

1. Kiểm tra chức năng nút "Lưu nháp" — *TC 533, row 534*
2. Kiểm tra chức năng nút "Tiếp tục" — *TC 534, row 535*
3. Kiểm tra chức năng nút "Quay lại" — *TC 535, row 536*
4. Kiểm tra chức năng nút "Đóng" — *TC 536, row 537*
5. Kiểm tra chức năng nút "Lưu nháp" — *TC 537, row 538*
6. Kiểm tra chức năng nút "Quay lại" — *TC 538, row 539*
7. Kiểm tra chức năng nút "Lưu template" — *TC 539, row 540*
8. Kiểm tra chức năng nút "Gửi duyệt" — *TC 540, row 541*

## Thêm mới – Chứng từ yêu cầu (19)

1. Kiểm tra hiển thị điều kiện: tick chọn "Signed commercial invoice" thì hiện các trường thông tin con tương ứng, bỏ tick thì ẩn đi — *TC 689, row 690*
2. [Full set (3/3) of original clean shipped on board ocean Bil…] Kiểm tra hiển thị điều kiện: tick chọn "Full set (3/3) of original clean shipped on board ocean Bill of Lading, made out to" thì hiện các trường thông tin con … — *TC 690, row 691*
3. [marked freight (Bill of Lading)] Bill of Lading — *TC 691, row 692*
4. Kiểm tra hiển thị trường "Additional Conditions" thuộc điều khoản Bill of Lading — *TC 692, row 693*
5. Kiểm tra danh sách giá trị lựa chọn của trường "Additional Conditions" (2 giá trị) — *TC 693, row 694*
6. Kiểm tra hiển thị điều kiện: tick chọn "Original No.3 (for the shipper) of Air Waybill consigned to" thì hiện các trường thông tin con tương ứng, bỏ tick thì ẩ… — *TC 694, row 695*
7. [marked freight (Air Waybill)] Air Waybill — *TC 695, row 696*
8. Kiểm tra bắt buộc chọn trường "showing LC number and notifying the applicant" (Mandatory Y) — *TC 696, row 697*
9. [showing LC number and notifying the applicant] Kiểm tra danh sách giá trị lựa chọn (2 giá trị: Yes/No) — *TC 697, row 698*
10. Kiểm tra hiển thị điều kiện: tick chọn "Inspection certificate issued by" thì hiện các trường thông tin con tương ứng, bỏ tick thì ẩn đi — *TC 698, row 699*
11. [Certificate of quality and quantity issued by (bộ 1 - origi…] Kiểm tra hiển thị điều kiện: tick chọn "Certificate of quality and quantity issued by (bộ 1 - original/copies)" thì hiện các trường thông tin con tương ứng, bỏ… — *TC 699, row 700*
12. [Full set of original insurance policy/certificate in assign…] Kiểm tra hiển thị điều kiện: tick chọn "Full set of original insurance policy/certificate in assignable form and endorsed in blank" thì hiện các trường thông t… — *TC 700, row 701*
13. Kiểm tra danh sách giá trị lựa chọn của trường "covering Institute Cargo Clause" (5 giá trị) — *TC 701, row 702*
14. [Certificate of quality and quantity issued by (bộ 2 - issue…] Kiểm tra hiển thị điều kiện: tick chọn "Certificate of quality and quantity issued by (bộ 2 - issued by/number of original/copies)" thì hiện các trường thông t… — *TC 702, row 703*
15. Kiểm tra hiển thị điều kiện: tick chọn "Packing list in" thì hiện các trường thông tin con tương ứng, bỏ tick thì ẩn đi — *TC 703, row 704*
16. [Beneficiary's Certificate certifying that one set of non ne…] Kiểm tra hiển thị điều kiện: tick chọn "Beneficiary's Certificate certifying that one set of non negotiable documents plus" thì hiện các trường thông tin con t… — *TC 704, row 705*
17. [Document name (Beneficiary's Certificate)] Beneficiary's Certificate — *TC 705, row 706*
18. Kiểm tra hiển thị điều kiện: tick chọn "Other (Mô tả chứng từ)" thì hiện các trường thông tin con tương ứng, bỏ tick thì ẩn đi — *TC 706, row 707*
19. [Nội dung khi tick Other (Mô tả chứng từ)] Kiểm tra giới hạn độ dài dữ liệu nhập trường "Nội dung khi tick Other" (tối đa 5000 ký tự) — *TC 707, row 708*

## Thêm mới – Additional conditions, LC xác nhận/chuyển nhượng, phí discounting (37)

1. Kiểm tra chức năng tìm kiếm (search) trong dropdown "BIC code" — nhập từ khoá lọc đúng kết quả — *TC 708, row 709*
2. Kiểm tra dropdown "BIC code" khi nhập từ khoá tìm kiếm không khớp với giá trị nào — *TC 709, row 710*
3. Kiểm tra hiển thị trường "Additional condition" (thay thế/tái cấu trúc từ "Other", nay có 5 giá trị) — *TC 710, row 711*
4. Kiểm tra bắt buộc chọn tối thiểu 1 giá trị cho trường "Additional condition" (Mandatory M) — *TC 711, row 712*
5. Kiểm tra danh sách giá trị lựa chọn của trường "Additional condition" (SRS mới bổ sung thêm 1 giá trị, nay 6 giá trị) — *TC 712, row 713*
6. Kiểm tra tick chọn ĐỒNG THỜI nhiều giá trị của "Additional condition" (cho phép chọn nhiều giá trị đồng thời theo SRS) — *TC 713, row 714*
7. [Additional condition - giá trị 1 (Sanction clause)] Kiểm tra giá trị mặc định của "Sanction clause" (giá trị 1) — Mặc định KHÔNG tích chọn — *TC 714, row 715*
8. [Additional condition - giá trị 2 (All documents in English)] Kiểm tra giá trị mặc định của "All documents must be issued in English" (giá trị 2) — Mặc định CÓ tích chọn khi Loại tiền LC KHÁC VND — *TC 715, row 716*
9. [Additional condition - giá trị 3 (amount utilized endorsed)] Kiểm tra giá trị mặc định của "The amount utilized must be endorsed..." (giá trị 3) — Mặc định CÓ tích chọn — *TC 716, row 717*
10. [Additional condition - giá trị 4 (due date falls...)] Kiểm tra giá trị mặc định của giá trị 4 (due date falls on 5 banking days...) — Mặc định KHÔNG tích chọn — *TC 717, row 718*
11. [Additional condition - giá trị 4 (due date falls...)] Kiểm tra giá trị 4 (due date falls...) bị ẨN khi "Draft to be drawn at - Kỳ hạn hối phiếu" tick vào Sight — *TC 718, row 719*
12. [Other (Additional condition - giá trị 5)] Kiểm tra bắt buộc nhập trường "Other" khi chọn giá trị 5 "Others (please specify)" của Additional condition — *TC 719, row 720*
13. Kiểm tra danh sách giá trị lựa chọn của trường "Đơn vị Days/Months/Years" (3 giá trị) — *TC 721, row 722*
14. [Ô text khi chọn Other (Kỳ hạn thanh toán)] Kỳ hạn thanh toán — *TC 722, row 723*
15. [Ô nhập ngày khi chọn Maturity date] Kiểm tra bắt buộc chọn ngày khi Kỳ hạn thanh toán chọn giá trị 2 "Maturity date" (SRS mới: đổi từ N sang Mandatory) — *TC 723, row 724*
16. Kiểm tra hiển thị và bắt buộc nhập "Ô nhập nội dung Services" khi tick chọn "Services" — *TC 724, row 725*
17. [Goods / Services] Kiểm tra hệ thống cho phép tick chọn ĐỒNG THỜI cả "Goods" và "Services" — *TC 725, row 726*
18. Kiểm tra bắt buộc chọn trường "Thông tin LC xác nhận" khi Loại L/C tick "Confirmed" (Mandatory) — *TC 726, row 727*
19. Kiểm tra danh sách giá trị lựa chọn của trường "Thông tin LC xác nhận" (3 giá trị) — *TC 727, row 728*
20. [Thông tin LC xác nhận] Kiểm tra chọn "Advising bank" KHÔNG hiển thị thêm trường con nào — *TC 728, row 729*
21. Kiểm tra bắt buộc chọn trường "Thông tin LC chuyển nhượng" khi Loại L/C tick "Transferable" (Mandatory) — *TC 729, row 730*
22. Kiểm tra danh sách giá trị lựa chọn của trường "Thông tin LC chuyển nhượng" (3 giá trị) — *TC 730, row 731*
23. [Additional condition - giá trị mới (All documents in Englis…] Kiểm tra giá trị mặc định của "All documents must be issued in English and/or Vietnamese" (giá trị mới) — Mặc định CÓ tích chọn khi Loại tiền LC = VND — *TC 731, row 732*
24. [Additional condition - giá trị 2 và giá trị mới] Kiểm tra 2 giá trị "All documents in English" và "All documents in English and/or Vietnamese" không cùng tích chọn mặc định (loại trừ theo Loại tiền) — *TC 732, row 733*
25. [Phí (Discounting)] Kiểm tra hiển thị trường "Phí" khi Loại LC = Discounting — *TC 733, row 734*
26. [Phí (Discounting)] Kiểm tra bắt buộc chọn trường "Phí" khi Loại LC = Discounting (Mandatory) — *TC 734, row 735*
27. [Phí (Discounting)] Kiểm tra danh sách giá trị lựa chọn của trường "Phí" khi Loại LC = Discounting (6 giá trị) — *TC 735, row 736*
28. [Ô nhập liệu khi chọn Other (Phí Discounting)] Phí Discounting — *TC 736, row 737*
29. [Ô nhập liệu khi chọn Other (Phí Discounting)] Phí Discounting — *TC 737, row 738*
30. Kiểm tra hiển thị nội dung mặc định và cho phép chỉnh sửa trường "Phí LC discounting" — *TC 738, row 739*
31. Kiểm tra hiển thị và bắt buộc chọn trường "Phí xác nhận do" khi Loại LC Discounting đồng thời chọn Confirmed/May add — *TC 739, row 740*
32. Kiểm tra danh sách giá trị lựa chọn của trường "Phí xác nhận do" (2 giá trị) — *TC 740, row 741*
33. Kiểm tra hiển thị và bắt buộc chọn trường "Phí chuyển nhượng do" khi Loại LC Discounting đồng thời chọn Transferable — *TC 741, row 742*
34. Kiểm tra danh sách giá trị lựa chọn của trường "Phí chuyển nhượng do" (2 giá trị) — *TC 742, row 743*
35. Kiểm tra hiển thị trường "Phí Chấp nhận thanh toán LC Discounting" chỉ khi Loại LC = Discounting — *TC 743, row 744*
36. Kiểm tra hiển thị trường "Lãi, Phí thương lượng thanh toán của Ngân hàng thương lượng" chỉ khi Loại LC = Discounting — *TC 744, row 745*
37. [Màn hình popup Điều khoản và điều kiện (LC Discounting)] Kiểm tra nội dung popup Điều khoản và điều kiện riêng cho LC Discounting (khác nội dung LC Regular/UPAS) — *TC 745, row 746*

## Thêm mới – Cam kết bổ sung chứng từ (19)

1. Kiểm tra hiển thị khối cam kết bổ sung chứng từ "Bổ sung chứng từ (tạm nhập tái xuất)" khi Giao dịch kinh doanh hàng hóa tạm nhập tái xuất = Yes VÀ Description… — *TC 746, row 747*
2. [Ngày bổ sung chứng từ (tạm nhập tái xuất)] Kiểm tra chọn ngày hợp lệ cho "Ngày bổ sung chứng từ" (trường hợp tạm nhập tái xuất) — *TC 747, row 748*
3. [Đối với báo Có tiền hàng tái xuất theo hợp đồng tái xuất hà…] Kiểm tra khi tick chọn "Đối với báo Có tiền hàng tái xuất..." thì hiện thêm ô nhập số tháng — *TC 748, row 749*
4. [Ngày bổ sung chứng từ (tự động tính từ số tháng)] Kiểm tra "Ngày bổ sung chứng từ" tự động tính theo công thức (ngày ký số gửi ngân hàng + số tháng đã nhập) — *TC 749, row 750*
5. Kiểm tra hiển thị khối cam kết bổ sung chứng từ "Bổ sung chứng từ (chuyển khẩu)" khi Giao dịch kinh doanh hàng hóa chuyển khẩu = Yes VÀ Description of Goods/Se… — *TC 750, row 751*
6. Kiểm tra hiển thị khối cam kết bổ sung chứng từ "Bổ sung chứng từ (thanh toán trả trước)" khi Thanh toán trả trước = Yes VÀ Description of Goods/Services tick … — *TC 751, row 752*
7. [Ô điền số tháng (các khối cam kết bổ sung chứng từ)] Kiểm tra định dạng dữ liệu số cho "Ô điền số tháng" ở các khối cam kết bổ sung chứng từ — *TC 752, row 753*
8. [Description of Goods and/ or Services - Services] Kiểm tra hiển thị khối "Liên quan đến giao dịch của chúng tôi..." khi tick chọn "Services" — *TC 753, row 754*
9. [Chứng từ khác (Services)] Kiểm tra bắt buộc nhập "Ô nhập nội dung chứng từ khác" khi tick chọn checkbox "Chứng từ khác" — *TC 754, row 755*
10. [Chứng từ cam kết bổ sung (Hyperlink xem tài liệu)] Kiểm tra click vào "Chứng từ cam kết bổ sung" mở xem trước tài liệu đã tải lên — *TC 755, row 756*
11. [Chứng từ cam kết bổ sung (DOCUMENTS TO BE PRESENTED)] Kiểm tra bắt buộc tick chọn tối thiểu 1 trong 12 giá trị của "DOCUMENTS TO BE PRESENTED" (Mandatory) — *TC 756, row 757*
12. [Chứng từ cam kết bổ sung (DOCUMENTS TO BE PRESENTED)] Kiểm tra danh sách giá trị lựa chọn của "DOCUMENTS TO BE PRESENTED" (12 giá trị) — *TC 757, row 758*
13. [Chứng từ cam kết bổ sung khác (mục 12 - Other Documents to …] Kiểm tra bắt buộc nhập "Chứng từ cam kết bổ sung khác" khi tick chọn mục 12 "Chứng từ khác" của DOCUMENTS TO BE PRESENTED — *TC 758, row 759*
14. [Sẽ nhận tiền thanh toán... về tài khoản của tôi/chúng tôi t…] Kiểm tra giá trị mặc định của checkbox "Sẽ nhận tiền thanh toán theo hợp đồng tái xuất hàng hóa..." — Mặc định CÓ tích và cho sửa — *TC 759, row 760*
15. [Đây là giao dịch kinh doanh hàng hóa tạm nhập tái xuất / ch…] Kiểm tra chặn khi chọn "Có" đồng thời ở CẢ 2 trường "tạm nhập tái xuất" và "chuyển khẩu" — *TC 771, row 772*
16. [Đây là giao dịch kinh doanh hàng hóa tạm nhập tái xuất / ch…] Kiểm tra cho phép chọn "Có" ở 1 trong 2 trường, trường còn lại vẫn có thể chọn "Không" bình thường — *TC 772, row 773*
17. [Bổ sung chứng từ tại mục CHỨNG TỪ CAM KẾT BỔ SUNG dưới đây …] Kiểm tra checkbox bị ẨN khi "Giao dịch kinh doanh hàng hóa chuyển khẩu" = Yes (và tick Goods) — *TC 773, row 774*
18. [Bổ sung chứng từ tại mục CHỨNG TỪ CAM KẾT BỔ SUNG dưới đây …] Kiểm tra checkbox bị ẨN khi "Giao dịch kinh doanh hàng hóa tạm nhập tái xuất" = Yes (và tick Goods) — *TC 774, row 775*
19. [Bổ sung chứng từ tại mục CHỨNG TỪ CAM KẾT BỔ SUNG dưới đây …] Kiểm tra checkbox HIỂN THỊ bình thường khi cả 2 điều kiện (tạm nhập tái xuất, chuyển khẩu) đều = Không — *TC 775, row 776*

## Xem chi tiết (33)

1. Kiểm tra quyền truy cập chức năng "Xem chi tiết" (FO) — *TC 115, row 116*
2. Kiểm tra chặn truy cập chức năng "Xem chi tiết" (FO) khi không được phân quyền — *TC 116, row 117*
3. Kiểm tra hệ thống thực hiện phân quyền đúng theo cây phân quyền (TTTM > LCNK > Phát hành LC (PHLC) > Truy vấn hồ sơ (V_PHLC)) khi user đăng nhập thành công và … — *TC 117, row 118*
4. Kiểm tra trường [Lý do từ chối] không hiển thị khi hồ sơ không ở trạng thái = Từ chối — *TC 120, row 121*
5. Kiểm tra chức năng nút <Lịch sử giao dịch> mở tab xem chi tiết thông tin ghi nhận thay đổi của giao dịch — *TC 121, row 122*
6. Kiểm tra chức năng nút <Đóng> đóng màn hình xem chi tiết và quay lại màn hình trước đó — *TC 122, row 123*
7. Kiểm tra nút <Chỉnh sửa> hiển thị và hoạt động đúng khi hồ sơ có trạng thái = Bản nháp — *TC 123, row 124*
8. Kiểm tra nút <Chỉnh sửa> không hiển thị khi hồ sơ ở trạng thái khác Bản nháp/Yêu cầu bổ sung — *TC 125, row 126*
9. Kiểm tra nút <Xóa đề nghị> hiển thị và mở popup xác nhận xóa khi hồ sơ có trạng thái = Bản nháp — *TC 126, row 127*
10. Kiểm tra nút <Xóa đề nghị> không hiển thị khi hồ sơ ở trạng thái khác Bản nháp — *TC 127, row 128*
11. Kiểm tra nút <Hủy giao dịch> không hiển thị khi hồ sơ ở trạng thái khác Yêu cầu bổ sung — *TC 129, row 130*
12. Kiểm tra nút <Sao chép> hiển thị và mở popup xác nhận sao chép khi hồ sơ ở trạng thái khác Bản nháp — *TC 130, row 131*
13. Kiểm tra nút <Sao chép> không hiển thị khi hồ sơ có trạng thái = Bản nháp — *TC 131, row 132*
14. Kiểm tra nút <Phê duyệt> hiển thị và mở popup phê duyệt khi hồ sơ có trạng thái = Chờ duyệt — *TC 132, row 133*
15. Kiểm tra nút <Phê duyệt> không hiển thị khi hồ sơ ở trạng thái khác Chờ duyệt — *TC 133, row 134*
16. Kiểm tra nút <Từ chối> hiển thị và mở popup xác nhận từ chối phê duyệt khi hồ sơ có trạng thái = Chờ duyệt — *TC 134, row 135*
17. Kiểm tra nút <Từ chối> không hiển thị khi hồ sơ ở trạng thái khác Chờ duyệt — *TC 135, row 136*
18. Kiểm tra nút <Ký số cá nhân> không hiển thị khi hồ sơ ở trạng thái khác Chờ duyệt cấp tiếp theo — *TC 137, row 138*
19. Kiểm tra hiển thị trường "Trạng thái" — *TC 138, row 139*
20. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "Lịch sử giao dịch" — *TC 139, row 140*
21. Kiểm tra hiển thị trường "Mã đề nghị" — *TC 140, row 141*
22. Kiểm tra hiển thị trường "Ngày đề nghị" — *TC 141, row 142*
23. Kiểm tra hiển thị trường "Người tạo" — *TC 142, row 143*
24. Kiểm tra hiển thị trường "Thời gian phê duyệt" — *TC 143, row 144*
25. Kiểm tra hiển thị trường "Người phê duyệt" — *TC 144, row 145*
26. Kiểm tra hiển thị trường "Lý do từ chối" — *TC 145, row 146*
27. Kiểm tra chức năng nút "Đóng" — *TC 146, row 147*
28. Kiểm tra chức năng nút "Xóa đề nghị" — *TC 147, row 148*
29. Kiểm tra chức năng nút "Hủy giao dịch" — *TC 148, row 149*
30. Kiểm tra chức năng nút "Chỉnh sửa" — *TC 149, row 150*
31. Kiểm tra chức năng nút "Sao chép" — *TC 150, row 151*
32. Kiểm tra chức năng nút "Phê duyệt" — *TC 151, row 152*
33. Kiểm tra chức năng nút "Từ chối" — *TC 152, row 153*

## Phê duyệt (4)

1. Kiểm tra quyền truy cập chức năng "Phê duyệt" (FO) — *TC 597, row 598*
2. Kiểm tra chặn truy cập chức năng "Phê duyệt" (FO) khi không được phân quyền — *TC 598, row 599*
3. Kiểm tra NSD được phân quyền phê duyệt có thể truy vấn và xem chi tiết giao dịch ở trạng thái Chờ duyệt/Chờ duyệt cấp tiếp theo theo đúng đường dẫn quy định — *TC 599, row 600*
4. Kiểm tra chức năng nút "Đóng" — *TC 617, row 618*

## Chỉnh sửa bản nháp (10)

1. Kiểm tra quyền truy cập chức năng "Chỉnh sửa" (FO) — *TC 541, row 542*
2. Kiểm tra chặn truy cập chức năng "Chỉnh sửa" (FO) khi không được phân quyền — *TC 542, row 543*
3. Verify khi user đăng nhập thành công và có quyền Chỉnh sửa hồ sơ (mã U_PHLC), hệ thống gọi API tới BO Admin Portal để lấy thông tin CIF, cây phân quyền (TTTM >… — *TC 543, row 544*
4. Verify user không được cấp quyền Chỉnh sửa hồ sơ (mã U_PHLC) trong cây phân quyền thì không được phép truy cập/thực hiện chức năng Chỉnh sửa đề nghị Phát hành … — *TC 544, row 545*
5. Verify màn hình Chỉnh sửa đề nghị áp dụng quy tắc tương tự màn hình Thêm mới, riêng trường [Mã đề nghị] không cho phép cập nhật. — *TC 545, row 546*
6. Verify khi thực hiện chỉnh sửa không phát sinh lỗi, hệ thống cập nhật thông tin mới cho bản ghi đề nghị và hiển thị màn hình thông báo thành công. — *TC 546, row 547*
7. Kiểm tra chức năng nút "Đóng" — *TC 549, row 550*
8. Kiểm tra chức năng nút "Quay lại" — *TC 550, row 551*
9. Kiểm tra chức năng nút "Lưu nháp" — *TC 551, row 552*
10. Kiểm tra chức năng nút "Gửi duyệt" — *TC 552, row 553*

## Từ chối (7)

1. Kiểm tra quyền truy cập chức năng "Từ chối" (FO) — *TC 619, row 620*
2. Kiểm tra chặn truy cập chức năng "Từ chối" (FO) khi không được phân quyền — *TC 620, row 621*
3. Kiểm tra hệ thống chặn thao tác Từ chối khi user không được phân quyền Đồng ý/từ chối phát hành LC (Mã A_PHLC) trong cây phân quyền — *TC 624, row 625*
4. Kiểm tra hệ thống không cho phép Từ chối đối với giao dịch không ở Trạng thái Chờ duyệt hoặc Chờ duyệt cấp tiếp theo (ví dụ Trạng thái = Từ chối/Đã duyệt/Bản n… — *TC 626, row 627*
5. Kiểm tra bắt buộc nhập trường "Lý do từ chối" — *TC 632, row 633*
6. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Lý do từ chối" (tối đa 200 ký tự) — *TC 633, row 634*
7. Kiểm tra chức năng nút "Không" — *TC 634, row 635*

## Hủy đề nghị (10)

1. Kiểm tra quyền truy cập chức năng "Hủy đề nghị" (FO) — *TC 568, row 569*
2. Kiểm tra chặn truy cập chức năng "Hủy đề nghị" (FO) khi không được phân quyền — *TC 569, row 570*
3. Kiểm tra popup xác nhận Hủy đề nghị hiển thị đúng nội dung và các nút chức năng khi NSD chọn <Hủy đề nghị>. — *TC 571, row 572*
4. Kiểm tra NSD chọn <Không> tại popup xác nhận thì hệ thống hủy bỏ thao tác, đóng popup và không thay đổi trạng thái giao dịch. — *TC 572, row 573*
5. Kiểm tra hệ thống không cho phép Hủy đề nghị khi giao dịch đang bị khóa bởi user khác — *TC 574, row 575*
6. Kiểm tra hệ thống không cho phép Hủy đề nghị khi giao dịch đã được gửi duyệt bởi user khác. — *TC 575, row 576*
7. Kiểm tra hệ thống không cho phép NSD không đủ phân quyền (không có Mã D_PHLC trong cây phân quyền) thực hiện chức năng Hủy đề nghị. — *TC 576, row 577*
8. Kiểm tra hiển thị trường "Tiêu đề" — *TC 580, row 581*
9. Kiểm tra chức năng nút "Không" — *TC 581, row 582*
10. Kiểm tra chức năng nút "Có" — *TC 582, row 583*

## Xóa đề nghị (10)

1. Kiểm tra quyền truy cập chức năng "Xóa đề nghị" (FO) — *TC 553, row 554*
2. Kiểm tra chặn truy cập chức năng "Xóa đề nghị" (FO) khi không được phân quyền — *TC 554, row 555*
3. Kiểm tra NSD hủy thao tác xóa khi chọn <Không> tại popup xác nhận. — *TC 556, row 557*
4. Kiểm tra hệ thống chặn xóa khi giao dịch không còn ở trạng thái Bản nháp (đã được gửi duyệt/xử lý sang trạng thái khác). — *TC 557, row 558*
5. Kiểm tra hệ thống chặn xóa khi giao dịch đang bị khóa hoặc đang được gửi duyệt bởi user khác. — *TC 558, row 559*
6. Kiểm tra hệ thống không cho phép NSD không đủ quyền (thiếu mã quyền Xóa - D_PHLC) thực hiện xóa đề nghị. — *TC 559, row 560*
7. Kiểm tra hậu điều kiện: sau khi xóa thành công, giao dịch bị loại bỏ hoàn toàn khỏi danh sách hiển thị cho NSD. — *TC 564, row 565*
8. Kiểm tra hiển thị trường "Tiêu đề" — *TC 565, row 566*
9. Kiểm tra chức năng nút "Không" — *TC 566, row 567*
10. Kiểm tra chức năng nút "Có" — *TC 567, row 568*

## Sao chép (13)

1. Kiểm tra quyền truy cập chức năng "Sao chép" (FO) — *TC 583, row 584*
2. Kiểm tra chặn truy cập chức năng "Sao chép" (FO) khi không được phân quyền — *TC 584, row 585*
3. Kiểm tra luồng chính Sao chép giao dịch thành công đối với giao dịch có trạng thái khác Bản nháp — *TC 585, row 586*
4. Kiểm tra luồng huỷ khi NSD chọn <Không> trên popup xác nhận Sao chép — *TC 586, row 587*
5. Kiểm tra hệ thống không cho phép Sao chép khi user không được phân quyền chức năng Sao chép hồ sơ (Mã S_PHLC) trong cây phân quyền — *TC 587, row 588*
6. Kiểm tra hệ thống không cho phép Sao chép đối với giao dịch đang ở trạng thái Bản nháp — *TC 588, row 589*
7. Kiểm tra đề nghị mới sinh ra sau khi Sao chép có mã ID mới (khác ID gốc) và trạng thái khởi tạo = Bản nháp — *TC 589, row 590*
8. Kiểm tra đề nghị mới sinh ra sau khi Sao chép ở trạng thái Bản nháp — *TC 590, row 591*
9. Kiểm tra nội dung và các nút thao tác trên popup xác nhận Sao chép hiển thị đúng theo BR — *TC 592, row 593*
10. Kiểm tra đường dẫn truy cập chức năng Sao chép: Menu > Phát hành LC > Xem chi tiết giao dịch — *TC 593, row 594*
11. Kiểm tra hiển thị trường "Tiêu đề" — *TC 594, row 595*
12. Kiểm tra chức năng nút "Không" — *TC 595, row 596*
13. Kiểm tra chức năng nút "Có" — *TC 596, row 597*

## Quản lý template (11)

1. Kiểm tra quyền truy cập chức năng "Quản lý template" (FO) — *TC 760, row 761*
2. [Quyền truy cập] Kiểm tra chặn truy cập chức năng "Quản lý template" khi không được phân quyền — *TC 761, row 762*
3. [Lưu template (nút, màn Thêm mới)] Kiểm tra chức năng nút "Lưu template" tại màn hình Thêm mới lưu thông tin thành 1 template mới — *TC 762, row 763*
4. Kiểm tra cột "STT" tự động đánh số thứ tự tăng dần trong danh sách template — *TC 763, row 764*
5. Kiểm tra "Mã template" sinh đúng cấu trúc ddmmyyyyxxx — *TC 764, row 765*
6. [Danh sách tìm kiếm template - Tìm kiếm nhanh] Kiểm tra chức năng tìm kiếm nhanh theo Mã template, Tên template — *TC 765, row 766*
7. [Lọc - Số CIF / Tên khách hàng / Tên bên thụ hưởng] Kiểm tra chức năng lọc nâng cao theo Số CIF, Tên khách hàng, Tên bên thụ hưởng — *TC 766, row 767*
8. [Khởi tạo LC (nút, popup xem chi tiết template)] Kiểm tra chức năng nút "Khởi tạo LC" mở màn hình Thêm mới với thông tin điền sẵn theo template — *TC 767, row 768*
9. [Khởi tạo LC (nút, popup xem chi tiết template)] Kiểm tra dữ liệu điền sẵn từ template khi Khởi tạo LC vẫn tuân thủ đầy đủ rule validate như màn hình Thêm mới thông thường — *TC 768, row 769*
10. [Lưu (nút, chỉnh sửa bản ghi template)] Kiểm tra chỉnh sửa bản ghi template — dữ liệu chỉnh sửa tuân thủ đúng rule validate của màn hình Thêm mới LC — *TC 769, row 770*
11. [Thoát (nút, xem/chỉnh sửa template)] Kiểm tra chức năng nút "Thoát" quay lại danh sách template, không lưu thay đổi — *TC 770, row 771*

## ⚠ Cần xác nhận thêm (19)

Thao tác UI bình thường, nhưng cần dữ liệu ở trạng thái đặc biệt, OTP, hoặc kiểm tra phía backend.

| # | TC | Row | Màn hình | Summary | Lý do |
|---|---|---|---|---|---|
| 1 | 118 | 119 | Xem chi tiết | Kiểm tra hiển thị trường [Lý do từ chối] khi hồ sơ có trạng thái = Từ chối và bị từ chối bởi người dùng DN | Cần bản ghi bị DN từ chối (thao tác từ chối cần OTP) |
| 2 | 119 | 120 | Xem chi tiết | Kiểm tra hiển thị trường [Lý do từ chối] khi hồ sơ có trạng thái = Từ chối và bị từ chối bởi người dùng Ngân hàng | Cần bản ghi bị Ngân hàng từ chối (BO) |
| 3 | 124 | 125 | Xem chi tiết | Kiểm tra nút <Chỉnh sửa> hiển thị và hoạt động đúng khi hồ sơ có trạng thái = Yêu cầu bổ sung | Cần bản ghi Yêu cầu bổ sung (BO trả về) |
| 4 | 128 | 129 | Xem chi tiết | Kiểm tra nút <Hủy giao dịch> hiển thị và mở popup xác nhận hủy đề nghị khi hồ sơ có trạng thái = Yêu cầu bổ sung | Cần bản ghi Yêu cầu bổ sung (BO trả về) |
| 5 | 153 | 154 | Xem chi tiết | Kiểm tra chức năng nút "Ký số cá nhân" | Cần bản ghi Chờ duyệt cấp tiếp theo (đã qua OTP) |
| 6 | 156 | 157 | Thêm mới | Verify khi user đăng nhập thành công, hệ thống call API tới BO Admin Portal để lấy đúng thông tin phân quyền: CIF của user thuộc DN đang login, cây phân quyền … | Kiểm tra gọi API Admin Portal (backend) – UI chỉ thấy kết quả |
| 7 | 160 | 161 | Thêm mới | Verify tại step 1, hệ thống truyền CIF sang hệ thống liên quan để lấy thông tin người đại diện, văn bản ủy quyền. | Tích hợp hệ thống ngoài – cần dữ liệu SIT ổn định |
| 8 | 161 | 162 | Thêm mới | Verify tại step 1, hệ thống truyền CIF sang GLIMS và nhận được mảng thông tin các hợp đồng (số facilityid) của CIF này. | Tích hợp GLIMS – cần dữ liệu SIT ổn định |
| 9 | 162 | 163 | Thêm mới | Verify khi chọn 1 hợp đồng (facilityid), hệ thống gọi CORE (API CreditLineInfo) với điều kiện credit line number trong CORE = facilityid, nhận về thông tin hợp… | Tích hợp CORE – cần dữ liệu SIT ổn định |
| 10 | 163 | 164 | Thêm mới | Verify hệ thống ghi nhận và lưu đúng thông tin Hạn mức khả dụng [AvailableAmount, FacilityCurrency], Hạn mức LC theo thỏa thuận [ApprovedAmount, FacilityCurren… | Tích hợp GLIMS/CORE – cần dữ liệu SIT ổn định |
| 11 | 164 | 165 | Thêm mới | Verify tại step 1, hệ thống truyền CIF sang CORE để lấy danh sách tài khoản của khách hàng. | Tích hợp CORE – cần dữ liệu SIT ổn định |
| 12 | 170 | 171 | Thêm mới | Verify sau khi Gửi duyệt thành công, hệ thống tự động gen file Đề nghị phát hành LC theo biểu mẫu của ngân hàng (đúng dữ liệu đã nhập trên màn hình) và đẩy fil… | Kiểm tra file sinh ra & đẩy sang hệ thống khác |
| 13 | 560 | 561 | Xóa đề nghị | Kiểm tra dữ liệu trên DB được cập nhật đúng sau khi xóa đề nghị thành công. | Kiểm tra DB |
| 14 | 562 | 563 | Xóa đề nghị | Kiểm tra hệ thống gọi API tới Admin Portal để thực thi đóng luồng sau khi xóa đề nghị thành công. | Kiểm tra gọi API Admin Portal (backend) |
| 15 | 573 | 574 | Hủy đề nghị | Kiểm tra hệ thống không cho phép/hiển thị cảnh báo khi Hủy đề nghị đối với giao dịch không ở trạng thái Yêu cầu bổ sung. | Cần bản ghi Yêu cầu bổ sung (BO trả về) |
| 16 | 578 | 579 | Hủy đề nghị | Kiểm tra hậu điều kiện: sau khi Hủy đề nghị thành công, trạng thái được cập nhật đồng bộ ở cả FO và BO (nếu có liên kết BO). | Kiểm tra đồng bộ trạng thái FO–BO |
| 17 | 618 | 619 | Phê duyệt | Kiểm tra chức năng nút "Xác nhận" | Nút Xác nhận ở popup Phê duyệt – cần OTP |
| 18 | 621 | 622 | Từ chối | Kiểm tra luồng chính: NSD đủ quyền và trong hạn mức thực hiện Từ chối thành công giao dịch có TT = Chờ duyệt cấp tiếp theo | Cần bản ghi Chờ duyệt cấp tiếp theo (đã qua OTP) |
| 19 | 635 | 636 | Từ chối | Kiểm tra chức năng nút "Từ chối" | Nút Từ chối có thể mở popup Xác thực (OTP) |

