# FO – Phát hành LC: Happy case & Edge case

Nguồn: `VCB_TradeFlat_Testcase_SIT_LC_ISS_Phat Hanh v1.1 (1).xlsx` (sheet đầu tiên). *row* = số dòng trong Excel.

Edge case chỉ liệt kê ở happy case **đầu tiên** đi qua bước đó; happy case sau chỉ liệt kê edge case của bước **mới** mà nó thêm vào.

## Happy case 1 – Tạo đề nghị → Gửi duyệt → Kế toán trưởng duyệt → Chủ tài khoản ký số → Đã gửi ngân hàng

- E2E: **TC 1, row 2** — Luồng happy case 1 cấp duyệt không ký số pháp nhân

### Edge cases

#### Danh sách & tìm kiếm giao dịch (49)

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

#### Thêm mới – truy cập, điều hướng các bước, tích hợp CIF/hạn mức, Gửi duyệt (27)

50. Kiểm tra quyền truy cập chức năng "Thêm mới" (FO) — *TC 154, row 155*
51. Kiểm tra chặn truy cập chức năng "Thêm mới" (FO) khi không được phân quyền — *TC 155, row 156*
52. Verify khi user đăng nhập thành công, hệ thống call API tới BO Admin Portal để lấy đúng thông tin phân quyền: CIF của user thuộc DN đang login, cây phân quyền … — *TC 156, row 157*
53. Verify hiển thị trạng thái của các step trong màn hình Thêm mới đúng theo mô tả: step đã hoàn thành hiển thị tick xanh, step hiện tại hiển thị ô màu xanh lá, s… — *TC 157, row 158*
54. Verify user có thể click trực tiếp vào số của step đã hoàn thành (đã tick xanh) để chuyển nhanh tới step đó. — *TC 158, row 159*
55. Verify khi step hiện tại chưa hoàn thiện đầy đủ thông tin, hệ thống không cho phép chọn Tiếp tục, Quay lại hoặc chọn vào bất kỳ step nào khác. — *TC 159, row 160*
56. Verify tại step 1, hệ thống truyền CIF sang hệ thống liên quan để lấy thông tin người đại diện, văn bản ủy quyền. — *TC 160, row 161*
57. Verify tại step 1, hệ thống truyền CIF sang GLIMS và nhận được mảng thông tin các hợp đồng (số facilityid) của CIF này. — *TC 161, row 162*
58. Verify khi chọn 1 hợp đồng (facilityid), hệ thống gọi CORE (API CreditLineInfo) với điều kiện credit line number trong CORE = facilityid, nhận về thông tin hợp… — *TC 162, row 163*
59. Verify hệ thống ghi nhận và lưu đúng thông tin Hạn mức khả dụng [AvailableAmount, FacilityCurrency], Hạn mức LC theo thỏa thuận [ApprovedAmount, FacilityCurren… — *TC 163, row 164*
60. Verify tại step 1, hệ thống truyền CIF sang CORE để lấy danh sách tài khoản của khách hàng. — *TC 164, row 165*
61. Verify hệ thống hiển thị đúng cảnh báo khi các trường thông tin bắt buộc bị bỏ trống (các trường khác đã nhập/chọn đầy đủ): trường kiểu chọn (select/dropdown/r… — *TC 165, row 166*
62. Verify luồng chính khi user chọn "Gửi duyệt" và toàn bộ thông tin hợp lệ, không có lỗi: hệ thống lưu bản ghi vào CSDL và hiển thị màn hình thông báo thành công. — *TC 166, row 167*
63. Verify khi Gửi duyệt thành công, hệ thống tự động sinh mã đề nghị mới, duy nhất, đúng định dạng "LCddmmyyxxxxISSxxx", và cập nhật trạng thái bản ghi = "Chờ duy… — *TC 167, row 168*
64. Verify sau khi Gửi duyệt thành công, hệ thống call API tới Admin Portal để xin chỉ thị luồng trả ra cấp phê duyệt tiếp theo, danh sách các user tương ứng và hạ… — *TC 168, row 169*
65. Verify sau khi Gửi duyệt thành công, hệ thống chuyển tới màn hình danh sách đề nghị. — *TC 169, row 170*
66. Verify sau khi Gửi duyệt thành công, hệ thống tự động gen file Đề nghị phát hành LC theo biểu mẫu của ngân hàng (đúng dữ liệu đã nhập trên màn hình) và đẩy fil… — *TC 170, row 171*
67. Verify sau khi Gửi duyệt thành công, hệ thống lưu log giao dịch gồm mã giao dịch, user, thời gian, hành động = "Gửi duyệt". — *TC 171, row 172*
68. Verify khi các trường hợp call API (Admin Portal/GLIMS/CORE/ECM...) bị lỗi, hệ thống lưu log lỗi gồm request, response, thời gian gọi, thời gian nhận response,… — *TC 172, row 173*
69. Verify khi user chọn "Đóng" và tại pop-up xác nhận "Hủy tạo mới đề nghị" chọn "Đồng ý", hệ thống đóng màn hình thêm mới, quay về màn danh sách bộ chứng từ và k… — *TC 173, row 174*
70. Verify khi user chọn "Đóng" và tại pop-up xác nhận "Hủy tạo mới đề nghị" chọn "Không", hệ thống chỉ đóng pop-up xác nhận, giữ nguyên màn hình Thêm mới và dữ li… — *TC 174, row 175*
71. Verify luồng chính khi user chọn "Lưu nháp": hệ thống lưu bản ghi, hiển thị MSG5, tự động sinh mã đề nghị duy nhất, trạng thái = "Bản nháp", chuyển màn hình da… — *TC 175, row 176*
72. Verify khi user DN nhấn "Gửi duyệt", hệ thống tự động cập nhật (cộng) số tiền LC vào trường Hạn mức sử dụng trong ngày lưu tại DB. — *TC 176, row 177*
73. Verify khi đề nghị LC bị Từ chối (DN từ chối/NH từ chối), hệ thống tự động cập nhật (trừ) số tiền LC khỏi trường Hạn mức sử dụng trong ngày. — *TC 177, row 178*
74. Verify khi user DN chỉnh sửa đề nghị phát hành LC (ĐNPH) làm tăng số tiền LC, hệ thống tự động cập nhật (cộng) phần chênh lệch tăng vào trường Hạn mức sử dụng … — *TC 178, row 179*
75. Verify khi Hạn mức sử dụng trong ngày (sau khi cộng số tiền LC) <= Hạn mức trong ngày [dailyLimit] do Admin Portal trả về, hệ thống cho phép user thực hiện tiế… — *TC 179, row 180*
76. Verify khi Hạn mức sử dụng trong ngày (sau khi cộng số tiền LC) > Hạn mức trong ngày [dailyLimit] do Admin Portal trả về, hệ thống hiển thị MSG14 và không cho … — *TC 180, row 181*

#### Thêm mới – rule chung các trường (52)

77. [Địa chỉ công ty (đại diện các trường Text Field áp dụng cùn…] Kiểm tra hệ thống xử lý khi trường bắt buộc chỉ nhập toàn khoảng trắng (space) — *TC 181, row 182*
78. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Chi nhánh" — *TC 182, row 183*
79. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Ô nhập liệu khi chọn LC khác" — *TC 183, row 184*
80. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Tên và địa chỉ" — *TC 184, row 185*
81. Kiểm tra giá trị mặc định của trường "Hình thức phát hành LC" khi truy cập màn hình Thêm mới lần đầu (chưa thao tác chọn) — *TC 185, row 186*
82. Kiểm tra ngày quá khứ được làm mờ (disable) trên lịch và không thể chọn được tại trường "Ngày khởi tạo" — *TC 186, row 187*
83. Kiểm tra chặn khi Ngày khởi tạo nhập muộn hơn Ngày giao hàng muộn nhất (Latest shipment date) — *TC 187, row 188*
84. Kiểm tra giá trị mặc định của trường "Ngày khởi tạo" khi truy cập màn hình Thêm mới lần đầu (chưa thao tác chọn) — *TC 188, row 189*
85. Kiểm tra chặn khi Ngày hết hạn (Expiry date) nhập BẰNG Ngày đề nghị/Ngày phát hành (Application Date) — case biên "=" — *TC 189, row 190*
86. Kiểm tra ngày quá khứ được làm mờ (disable) trên lịch và không thể chọn được tại trường "Ngày hết hạn" — *TC 190, row 191*
87. Kiểm tra chặn khi Ngày hết hạn (Expiry date) nhập BẰNG Ngày giao hàng muộn nhất (Latest shipment date) — case biên "=" — *TC 191, row 192*
88. Kiểm tra chặn khi Ngày hết hạn (Expiry date) nhập NHỎ HƠN (sớm hơn) Ngày đề nghị/Ngày phát hành (Application Date) — case "<" — *TC 192, row 193*
89. Kiểm tra chặn khi Ngày hết hạn (Expiry date) nhập NHỎ HƠN (sớm hơn) Ngày giao hàng muộn nhất (Latest shipment date) — case "<" — *TC 193, row 194*
90. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Nơi hết hạn" — *TC 194, row 195*
91. Kiểm tra hiển thị trường "Ngân hàng thông báo" — *TC 195, row 196*
92. Kiểm tra giá trị mặc định của trường "Địa chỉ Đơn vị phát hành LC" khi truy cập màn hình Thêm mới (tự động lấy theo địa chỉ đơn vị NSD đăng nhập) — *TC 196, row 197*
93. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Tỉnh/Thành phố/Bang của đơn vị phát hành LC" — *TC 197, row 198*
94. Kiểm tra chọn giá trị hợp lệ cho trường "Quốc gia của đơn vị phát hành LC" — *TC 198, row 199*
95. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Mã bưu chính của người yêu cầu mở LC" — *TC 199, row 200*
96. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Tỉnh/Thành phố/Bang của người thụ hưởng" — *TC 200, row 201*
97. Kiểm tra chọn giá trị hợp lệ cho trường "Quốc gia của người thụ hưởng" — *TC 201, row 202*
98. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Mã bưu chính của người thụ hưởng" — *TC 202, row 203*
99. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Số tài khoản" — *TC 203, row 204*
100. Kiểm tra giới hạn số chữ số nhập trường "Dung sai (%)" (tối đa 5 chữ số phần nguyên, 2 chữ số thập phân) — *TC 204, row 205*
101. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Ô nhập khi tick Any bank in city" — *TC 205, row 206*
102. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Ô nhập khi chọn Any bank in country" — *TC 206, row 207*
103. [Yêu cầu xuất trình hối phiếu (Drafts)] Kiểm tra giá trị mặc định = "No" và bị khoá không cho sửa khi mục "This credit is available with" chọn "Deferred Payment" — *TC 207, row 208*
104. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Other" — *TC 208, row 209*
105. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Nơi nhận hàng / Nơi gửi hàng / Nơi nhận hàng để vận chuyển" — *TC 209, row 210*
106. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Cảng xếp hàng / Sân bay khởi hành" — *TC 210, row 211*
107. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Cảng dỡ hàng / Sân bay đến" — *TC 211, row 212*
108. [Cảng dỡ hàng / Sân bay đến (Port of discharge/Airport of de…] Kiểm tra bắt buộc nhập trường "Cảng dỡ hàng / Sân bay đến" khi trường "Cảng xếp hàng / Sân bay khởi hành" đã có giá trị — *TC 212, row 213*
109. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Nơi đến cuối cùng / Nơi vận chuyển đến / Nơi giao hàng" — *TC 213, row 214*
110. Kiểm tra chặn khi Ngày giao hàng muộn nhất (Last Shipment Date) nhập muộn hơn Ngày hết hạn của LC — *TC 214, row 215*
111. [Ngày giao hàng muộn nhất / Kỳ giao hàng (Last Shipment Date…] Kiểm tra khi chọn "Ngày giao hàng muộn nhất" thì trường "Kỳ giao hàng" tự động ẩn đi (và ngược lại) — chỉ được chọn 1 trong 2 theo SRS — *TC 215, row 216*
112. Kiểm tra ngày quá khứ được làm mờ (disable) trên lịch và không thể chọn được tại trường "Ngày giao hàng muộn nhất" — *TC 216, row 217*
113. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Kỳ giao hàng" — *TC 217, row 218*
114. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Ô nhập liệu khi chọn Other" — *TC 218, row 219*
115. [Ô nhập liệu khi chọn Other (Điều kiện Incoterms)] Điều kiện Incoterms — *TC 219, row 220*
116. Kiểm tra danh sách giá trị của trường "Điều kiện Incoterms khác" khi "Điều kiện giao hàng" = INCOTERMS 2020 — *TC 220, row 221*
117. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Quy định vùng địa lý" — *TC 221, row 222*
118. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Mã phân loại hàng hoá" — *TC 222, row 223*
119. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Ô nhập nội dung tên chi nhánh" — *TC 223, row 224*
120. [Ô nhập nội dung khi tick vào Copies] Kiểm tra hiển thị dòng nội dung tĩnh (text hiển thị sẵn) phía sau các giá trị đã tick chọn của Institute Cargo Clause — *TC 224, row 225*
121. Kiểm tra bắt buộc chọn trường "marked freight" sang Mandatory (Y)) — *TC 225, row 226*
122. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Ô Nhập thông tin khi tick chọn Other" — *TC 226, row 227*
123. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Số hợp đồng mua bán" — *TC 227, row 228*
124. Kiểm tra bắt buộc chọn trường "Nguồn tiền thanh toán từ các nguồn" sang Mandatory (M)) — *TC 228, row 229*
125. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Lãi suất UPAS trong hạn" — *TC 229, row 230*
126. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Lãi suất áp dụng đối với dư nợ gốc quá hạn" — *TC 230, row 231*
127. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Lãi suất áp dụng đối với lãi chậm trả" — *TC 231, row 232*
128. Kiểm tra quy tắc "Không cho phép nhập khoảng trắng" đối với trường "Ô nhập liệu nội dung khác" — *TC 232, row 233*

#### Thêm mới – Thông tin khách hàng (14)

129. Kiểm tra bắt buộc nhập trường "Thông tin khách hàng" — *TC 233, row 234*
130. Kiểm tra hiển thị trường "Thông tin khách hàng" — *TC 234, row 235*
131. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "Mã khách hàng" — *TC 235, row 236*
132. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "Tên công ty" — *TC 236, row 237*
133. Kiểm tra hiển thị trường "Số DKKD/MST" — *TC 237, row 238*
134. Kiểm tra bắt buộc nhập trường "Địa chỉ công ty" — *TC 238, row 239*
135. Kiểm tra bắt buộc nhập trường "Người đại diện" — *TC 239, row 240*
136. Kiểm tra chọn giá trị hợp lệ cho trường "Người đại diện" — *TC 240, row 241*
137. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "Chức vụ" — *TC 241, row 242*
138. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "Văn bản ủy quyền" — *TC 242, row 243*
139. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "CCCD/ Hộ chiếu" — *TC 243, row 244*
140. Kiểm tra bắt buộc nhập trường "Hợp đồng hạn mức số" — *TC 244, row 245*
141. Kiểm tra chọn giá trị hợp lệ cho trường "Hợp đồng hạn mức số" — *TC 245, row 246*
142. Kiểm tra bắt buộc nhập trường "Chi nhánh" — *TC 246, row 247*

#### Thêm mới – Thông tin LC, ngân hàng, bên phát hành, người hưởng (75)

143. Kiểm tra bắt buộc nhập trường "Loại L/C" — *TC 247, row 248*
144. Kiểm tra danh sách giá trị lựa chọn của trường "Loại L/C" — *TC 248, row 249*
145. Kiểm tra chọn giá trị hợp lệ cho trường "Loại L/C" — *TC 249, row 250*
146. Kiểm tra danh sách giá trị lựa chọn của trường "Loại sản phẩm LC" — *TC 250, row 251*
147. Kiểm tra chọn giá trị hợp lệ cho trường "Loại sản phẩm LC" — *TC 251, row 252*
148. Kiểm tra điều kiện bắt buộc nhập trường "Ô nhập liệu khi chọn LC khác" theo quy tắc nghiệp vụ — *TC 252, row 253*
149. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Ô nhập liệu khi chọn LC khác" (tối đa 200 ký tự) — *TC 253, row 254*
150. Kiểm tra bắt buộc chọn "BIC Code" khi "Thông tin LC xác nhận" = "Other bank" — *TC 254, row 255*
151. Kiểm tra "BIC Code" CHỈ hiển thị khi "Thông tin LC xác nhận" = "Other bank" — *TC 255, row 256*
152. [Tên và địa chỉ] Kiểm tra "Full name & address" hiển thị và cho chỉnh sửa theo BIC code đã chọn khi "Thông tin LC xác nhận" = "Other bank" — *TC 256, row 257*
153. [Tên và địa chỉ] Kiểm tra bắt buộc nhập "Any bank" khi "Thông tin LC xác nhận" = "Any bank" — *TC 257, row 258*
154. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Chi nhánh" (tối đa 140 ký tự) — *TC 258, row 259*
155. Kiểm tra điều kiện bắt buộc nhập trường "BIC code" theo quy tắc nghiệp vụ — *TC 259, row 260*
156. Kiểm tra chọn giá trị hợp lệ cho trường "BIC code" — *TC 260, row 261*
157. Kiểm tra điều kiện bắt buộc nhập trường "BIC code" theo quy tắc nghiệp vụ — *TC 261, row 262*
158. Kiểm tra chọn giá trị hợp lệ cho trường "BIC code" — *TC 262, row 263*
159. Kiểm tra bắt buộc chọn "BIC Code" khi "Thông tin LC chuyển nhượng" = "Other bank" — *TC 263, row 264*
160. Kiểm tra chọn giá trị hợp lệ cho trường "BIC code" — *TC 264, row 265*
161. [Tên và địa chỉ] Kiểm tra bắt buộc chọn "BIC Code" khi "Thông tin LC chuyển nhượng" = "Other bank" — *TC 265, row 266*
162. [Tên và địa chỉ] Kiểm tra "BIC Code" CHỈ hiển thị khi "Thông tin LC chuyển nhượng" = "Other bank" — *TC 266, row 267*
163. [Tên và địa chỉ] Kiểm tra "Full name & address" hiển thị theo BIC code đã chọn và KHÔNG cho chỉnh sửa khi "Thông tin LC chuyển nhượng" = "Other bank" — *TC 267, row 268*
164. [Tên và địa chỉ] Kiểm tra bắt buộc nhập "Any bank" khi "Thông tin LC chuyển nhượng" = "Any bank" — *TC 268, row 269*
165. Kiểm tra điều kiện bắt buộc nhập trường "Tên và địa chỉ" theo quy tắc nghiệp vụ — *TC 269, row 270*
166. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Tên và địa chỉ" (tối đa 1024 ký tự) — *TC 270, row 271*
167. Kiểm tra bắt buộc nhập trường "Hình thức phát hành LC" — *TC 271, row 272*
168. Kiểm tra danh sách giá trị lựa chọn của trường "Hình thức phát hành LC" — *TC 272, row 273*
169. Kiểm tra chọn giá trị hợp lệ cho trường "Hình thức phát hành LC" — *TC 273, row 274*
170. Kiểm tra bắt buộc nhập trường "Yêu cầu chữ ký số trên điện LC" — *TC 274, row 275*
171. Kiểm tra danh sách giá trị lựa chọn của trường "Yêu cầu chữ ký số trên điện LC" — *TC 275, row 276*
172. Kiểm tra chọn giá trị hợp lệ cho trường "Yêu cầu chữ ký số trên điện LC" — *TC 276, row 277*
173. Kiểm tra bắt buộc nhập trường "Ngày khởi tạo" — *TC 277, row 278*
174. Kiểm tra định dạng ngày trường "Ngày khởi tạo" — *TC 278, row 279*
175. Kiểm tra nhập giá trị ngày hợp lệ trường "Ngày khởi tạo" — *TC 279, row 280*
176. Kiểm tra bắt buộc nhập trường "Ngày hết hạn" — *TC 280, row 281*
177. Kiểm tra định dạng ngày trường "Ngày hết hạn" — *TC 281, row 282*
178. Kiểm tra nhập giá trị ngày hợp lệ trường "Ngày hết hạn" — *TC 282, row 283*
179. Kiểm tra bắt buộc nhập trường "Nơi hết hạn" — *TC 283, row 284*
180. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Nơi hết hạn" (tối đa 29 ký tự) — *TC 284, row 285*
181. Kiểm tra bắt buộc nhập trường "Ngân hàng bên thụ hưởng" — *TC 285, row 286*
182. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "Ngân hàng thông báo" — *TC 286, row 287*
183. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "Thông tin bên phát hành" — *TC 287, row 288*
184. Kiểm tra bắt buộc nhập trường "Tên Đơn vị phát hành LC" — *TC 288, row 289*
185. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Tên Đơn vị phát hành LC" (tối đa 140 ký tự) — *TC 289, row 290*
186. Kiểm tra bắt buộc nhập trường "Địa chỉ Đơn vị phát hành LC" — *TC 290, row 291*
187. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Địa chỉ Đơn vị phát hành LC" (tối đa 140 ký tự) — *TC 291, row 292*
188. Kiểm tra bắt buộc nhập trường "Tỉnh/Thành phố/Bang của đơn vị phát hành LC" — *TC 292, row 293*
189. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Tỉnh/Thành phố/Bang của đơn vị phát hành LC" (tối đa 35 ký tự) — *TC 293, row 294*
190. Kiểm tra bắt buộc nhập trường "Quốc gia của đơn vị phát hành LC" — *TC 294, row 295*
191. Kiểm tra danh sách giá trị lựa chọn của trường "Quốc gia của đơn vị phát hành LC" (SRS mới: đổi từ Text Field sang Dropdown) — *TC 295, row 296*
192. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Mã bưu chính của người yêu cầu mở LC" (tối đa 16 ký tự) — *TC 296, row 297*
193. Kiểm tra bắt buộc nhập trường "Tên Người hưởng" — *TC 297, row 298*
194. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Tên Người hưởng" (tối đa 140 ký tự) — *TC 298, row 299*
195. Kiểm tra bắt buộc nhập trường "Địa chỉ Người hưởng" — *TC 299, row 300*
196. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Địa chỉ Người hưởng" (tối đa 140 ký tự) — *TC 300, row 301*
197. Kiểm tra bắt buộc nhập trường "Tỉnh/Thành phố/Bang của người thụ hưởng" — *TC 301, row 302*
198. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Tỉnh/Thành phố/Bang của người thụ hưởng" (tối đa 35 ký tự) — *TC 302, row 303*
199. Kiểm tra bắt buộc nhập trường "Quốc gia của người thụ hưởng" — *TC 303, row 304*
200. Kiểm tra danh sách giá trị lựa chọn của trường "Quốc gia của người thụ hưởng" (SRS mới: đổi từ Text Field sang Dropdown) — *TC 304, row 305*
201. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Mã bưu chính của người thụ hưởng" (tối đa 16 ký tự) — *TC 305, row 306*
202. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Số tài khoản" (tối đa 100 ký tự) — *TC 306, row 307*
203. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "Lưu danh sách người thụ hưởng" — *TC 307, row 308*
204. Kiểm tra chức năng nút "Tìm kiếm" — *TC 308, row 309*
205. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "Danh sách người thụ hưởng" — *TC 309, row 310*
206. Kiểm tra chọn giá trị hợp lệ cho trường "Icon chọn" — *TC 310, row 311*
207. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "STT" — *TC 311, row 312*
208. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "Tên người thụ hưởng" — *TC 312, row 313*
209. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "Địa chỉ người thụ hưởng" — *TC 313, row 314*
210. Kiểm tra chức năng nút "Đóng" tại màn hình danh sách người thụ hưởng — *TC 314, row 315*
211. Kiểm tra chức năng nút "Xác nhận" — *TC 315, row 316*
212. Kiểm tra điều kiện bắt buộc nhập trường "BIC code" theo quy tắc nghiệp vụ — *TC 316, row 317*
213. Kiểm tra chọn giá trị hợp lệ cho trường "BIC code" — *TC 317, row 318*
214. Kiểm tra điều kiện bắt buộc nhập trường "Tên và địa chỉ" theo quy tắc nghiệp vụ — *TC 318, row 319*
215. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Tên và địa chỉ" (tối đa 1024 ký tự) — *TC 319, row 320*
216. Kiểm tra điều kiện bắt buộc nhập trường "Tên và địa chỉ" theo quy tắc nghiệp vụ — *TC 320, row 321*
217. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Tên và địa chỉ" (tối đa 200 ký tự) — *TC 321, row 322*

#### Thêm mới – Giá trị LC, dung sai (10)

218. Kiểm tra bắt buộc nhập trường "Giá trị LC" — *TC 322, row 323*
219. Kiểm tra hiển thị và nhập dữ liệu hợp lệ cho trường "Dung sai (%)" (Optional) — *TC 323, row 324*
220. Kiểm tra định dạng dữ liệu số trường "Dung sai (%)" — *TC 324, row 325*
221. Kiểm tra bắt buộc nhập trường "Thư tín dụng có giá trị tại" — *TC 325, row 326*
222. Kiểm tra danh sách giá trị lựa chọn của trường "Thư tín dụng có giá trị tại" — *TC 326, row 327*
223. Kiểm tra chọn giá trị hợp lệ cho trường "Thư tín dụng có giá trị tại" — *TC 327, row 328*
224. Kiểm tra điều kiện bắt buộc nhập trường "Ô nhập khi tick Any bank in city" theo quy tắc nghiệp vụ — *TC 328, row 329*
225. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Ô nhập khi tick Any bank in city" (tối đa 100 ký tự) — *TC 329, row 330*
226. Kiểm tra điều kiện bắt buộc nhập trường "Ô nhập khi chọn Any bank in country" theo quy tắc nghiệp vụ — *TC 330, row 331*
227. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Ô nhập khi chọn Any bank in country" (tối đa 100 ký tự) — *TC 331, row 332*

#### Thêm mới – Phương thức thanh toán, hối phiếu, kỳ hạn (20)

228. Kiểm tra bắt buộc nhập trường "Phương thức thanh toán của LC" — *TC 332, row 333*
229. Kiểm tra danh sách giá trị lựa chọn của trường "Phương thức thanh toán của LC" — *TC 333, row 334*
230. Kiểm tra chọn giá trị hợp lệ cho trường "Phương thức thanh toán của LC" — *TC 334, row 335*
231. Kiểm tra bắt buộc nhập trường "Yêu cầu xuất trình hối phiếu" — *TC 335, row 336*
232. Kiểm tra danh sách giá trị lựa chọn của trường "Yêu cầu xuất trình hối phiếu" — *TC 336, row 337*
233. Kiểm tra chọn giá trị hợp lệ cho trường "Yêu cầu xuất trình hối phiếu" — *TC 337, row 338*
234. Kiểm tra bắt buộc nhập trường "Kỳ hạn thanh toán" — *TC 338, row 339*
235. Kiểm tra danh sách giá trị lựa chọn của trường "Kỳ hạn thanh toán" — *TC 339, row 340*
236. Kiểm tra chọn giá trị hợp lệ cho trường "Kỳ hạn thanh toán" — *TC 340, row 341*
237. Kiểm tra điều kiện bắt buộc nhập trường "Số Days/Months/Years" theo quy tắc nghiệp vụ — *TC 341, row 342*
238. Kiểm tra định dạng dữ liệu số trường "Số Days/Months/Years" — *TC 342, row 343*
239. Kiểm tra định dạng ngày trường "Ô nhập ngày khi chọn Maturity date" — *TC 343, row 344*
240. Kiểm tra nhập giá trị ngày hợp lệ trường "Ô nhập ngày khi chọn Maturity date" — *TC 344, row 345*
241. Kiểm tra bắt buộc nhập trường "Thông tin về người trả tiền trên Hối phiếu" — *TC 345, row 346*
242. Kiểm tra điều kiện bắt buộc nhập trường "Thông tin về người trả tiền trên Hối phiếu" theo quy tắc nghiệp vụ — *TC 346, row 347*
243. Kiểm tra danh sách giá trị lựa chọn của trường "Thông tin về người trả tiền trên Hối phiếu" — *TC 347, row 348*
244. Kiểm tra chọn giá trị hợp lệ cho trường "Thông tin về người trả tiền trên Hối phiếu" — *TC 348, row 349*
245. Kiểm tra chọn giá trị hợp lệ cho trường "Other bank" — *TC 349, row 350*
246. Kiểm tra điều kiện bắt buộc nhập trường "Other" theo quy tắc nghiệp vụ — *TC 350, row 351*
247. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Other" (tối đa 200 ký tự) — *TC 351, row 352*

#### Thêm mới – Giao hàng & hàng hoá (36)

248. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Nơi nhận hàng / Nơi gửi hàng / Nơi nhận hàng để vận chuyển" (tối đa 65 ký tự) — *TC 352, row 353*
249. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Cảng xếp hàng / Sân bay khởi hành" (tối đa 65 ký tự) — *TC 353, row 354*
250. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Cảng dỡ hàng / Sân bay đến" (tối đa 65 ký tự) — *TC 354, row 355*
251. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Nơi đến cuối cùng / Nơi vận chuyển đến / Nơi giao hàng" (tối đa 65 ký tự) — *TC 355, row 356*
252. Kiểm tra bắt buộc nhập trường "Giao hàng từng phần" — *TC 356, row 357*
253. Kiểm tra danh sách giá trị lựa chọn của trường "Giao hàng từng phần" — *TC 357, row 358*
254. Kiểm tra chọn giá trị hợp lệ cho trường "Giao hàng từng phần" — *TC 358, row 359*
255. Kiểm tra bắt buộc nhập trường "Chuyển tải" — *TC 359, row 360*
256. Kiểm tra danh sách giá trị lựa chọn của trường "Chuyển tải" — *TC 360, row 361*
257. Kiểm tra chọn giá trị hợp lệ cho trường "Chuyển tải" — *TC 361, row 362*
258. Kiểm tra bắt buộc nhập trường "Ngày giao hàng muộn nhất" — *TC 362, row 363*
259. Kiểm tra định dạng ngày trường "Ngày giao hàng muộn nhất" — *TC 363, row 364*
260. Kiểm tra nhập giá trị ngày hợp lệ trường "Ngày giao hàng muộn nhất" — *TC 364, row 365*
261. Kiểm tra bắt buộc nhập trường "Kỳ giao hàng" — *TC 365, row 366*
262. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Kỳ giao hàng" (tối đa 390 ký tự) — *TC 366, row 367*
263. Kiểm tra bắt buộc nhập trường "Điều kiện giao hàng" — *TC 367, row 368*
264. Kiểm tra danh sách giá trị lựa chọn của trường "Điều kiện giao hàng" — *TC 368, row 369*
265. Kiểm tra chọn giá trị hợp lệ cho trường "Điều kiện giao hàng" — *TC 369, row 370*
266. Kiểm tra bắt buộc nhập trường "Điều kiện Incoterms" — *TC 370, row 371*
267. Kiểm tra danh sách giá trị lựa chọn của trường "Điều kiện Incoterms" — *TC 371, row 372*
268. Kiểm tra chọn giá trị hợp lệ cho trường "Điều kiện Incoterms" — *TC 372, row 373*
269. Kiểm tra bắt buộc nhập trường "Ô nhập liệu khi chọn Other" — *TC 373, row 374*
270. Kiểm tra điều kiện bắt buộc nhập trường "Ô nhập liệu khi chọn Other" theo quy tắc nghiệp vụ — *TC 374, row 375*
271. Kiểm tra danh sách giá trị của trường "Điều kiện Incoterms khác" khi "Điều kiện giao hàng" = INCOTERMS 2010 — *TC 375, row 376*
272. Kiểm tra danh sách giá trị của trường "Điều kiện Incoterms khác" khi "Điều kiện giao hàng" = INCOTERMS 2000 — *TC 376, row 377*
273. Kiểm tra bắt buộc nhập trường "Quy định vùng địa lý" — *TC 377, row 378*
274. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Quy định vùng địa lý" (tối đa 60 ký tự) — *TC 378, row 379*
275. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Mã phân loại hàng hoá" (tối đa 12 ký tự) — *TC 379, row 380*
276. Kiểm tra hiển thị khối "Mô tả hàng hoá" (Description of Goods and/or Services - đổi cấu trúc SRS mới thành 2 checkbox Goods/Services) — *TC 380, row 381*
277. [Goods / Services] Kiểm tra bắt buộc tick chọn TỐI THIỂU 1 trong 2 giá trị "Goods" hoặc "Services" — *TC 381, row 382*
278. [Ô nhập nội dung Goods / Ô nhập nội dung Services] Kiểm tra hệ thống chặn NGAY KHI NHẬP LIỆU khi tổng ký tự của 2 trường "Ô nhập nội dung Goods" + "Ô nhập nội dung Services" vượt quá 6000 ký tự — *TC 382, row 383*
279. Kiểm tra hiển thị và bắt buộc nhập "Ô nhập nội dung Goods" khi tick chọn "Goods" — *TC 383, row 384*
280. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Ô nhập nội dung tên chi nhánh" (tối đa 100 ký tự) — *TC 384, row 385*
281. Kiểm tra danh sách giá trị lựa chọn của trường "Ô nội dung nhập khi tick vào Original" — *TC 385, row 386*
282. Kiểm tra chọn giá trị hợp lệ cho trường "Ô nội dung nhập khi tick vào Original" — *TC 386, row 387*
283. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "Ô nhập nội dung khi tick vào Copies" — *TC 387, row 388*

#### Thêm mới – Điều khoản bổ sung (16)

284. Kiểm tra chọn giá trị hợp lệ cho trường "Điều khoản bổ sung" — *TC 388, row 389*
285. Kiểm tra chọn giá trị hợp lệ cho trường "Điều khoản bổ sung" — *TC 389, row 390*
286. Kiểm tra bắt buộc nhập trường "Ô nhập ngày" — *TC 390, row 391*
287. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Ô nhập ngày" (tối đa 3 ký tự) — *TC 391, row 392*
288. Kiểm tra định dạng dữ liệu số trường "Ô nhập ngày" — *TC 392, row 393*
289. Kiểm tra bắt buộc nhập trường "Ô nhập nội dung" — *TC 393, row 394*
290. [Regardless of the L/C tenor, payment under this L/C is avai…] Kiểm tra hiển thị trường "Regardless of the L/C tenor, payment under this L/C is available at" — *TC 394, row 395*
291. Kiểm tra hiển thị trường "Regardless of the L/C tenor, payment under this L/C is available at" khi Loại LC là UPAS hoặc UPAS PLUS — *TC 395, row 396*
292. [Regardless of the L/C tenor, payment under this L/C is avai…] Kiểm tra bắt buộc chọn trường "Regardless of the L/C tenor, payment under this L/C is available at" (Mandatory) — *TC 396, row 397*
293. [Regardless of the L/C tenor, payment under this L/C is avai…] Kiểm tra danh sách giá trị lựa chọn của trường "Regardless of the L/C tenor, payment under this L/C is available at" (2 giá trị) — *TC 397, row 398*
294. [Regardless of the L/C tenor, payment under this L/C is avai…] Kiểm tra giá trị mặc định "Sight basis" khi Loại LC = UPAS, cho phép sửa lại — *TC 398, row 399*
295. [Regardless of the L/C tenor, payment under this L/C is avai…] Kiểm tra giá trị mặc định "at [Ô nhập ngày] days after [Ô nhập nội dung]" khi Loại LC = UPAS PLUS, cho phép sửa lại — *TC 399, row 400*
296. [Ô nhập ngày (Regardless of the L/C tenor...)] Regardless of the L/C tenor... — *TC 400, row 401*
297. [Ô nhập ngày (Regardless of the L/C tenor...)] Regardless of the L/C tenor... — *TC 401, row 402*
298. [Ô nhập nội dung (Regardless of the L/C tenor...)] Regardless of the L/C tenor... — *TC 402, row 403*
299. [Ô nhập nội dung (Regardless of the L/C tenor...)] Regardless of the L/C tenor... — *TC 403, row 404*

#### Thêm mới – Phí & thời hạn xuất trình (38)

300. Kiểm tra bắt buộc nhập trường "Ô nhập liệu khi chọn Other" — *TC 404, row 405*
301. Kiểm tra điều kiện bắt buộc nhập trường "Ô nhập liệu khi chọn Other" theo quy tắc nghiệp vụ — *TC 405, row 406*
302. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Ô nhập liệu khi chọn Other" (tối đa 1500 ký tự) — *TC 406, row 407*
303. [Ô nhập liệu khi chọn Other (Phí)] Phí — *TC 407, row 408*
304. [Ô nhập liệu khi chọn Other (Phí)] Phí — *TC 408, row 409*
305. Kiểm tra bắt buộc nhập trường "Phí" — *TC 409, row 410*
306. Kiểm tra chọn giá trị hợp lệ cho trường "Phí" — *TC 410, row 411*
307. Kiểm tra hiển thị trường "Phí" (mới bổ sung) khi Loại LC = Regular — *TC 411, row 412*
308. Kiểm tra bắt buộc chọn trường "Phí" (Mandatory) — *TC 412, row 413*
309. Kiểm tra danh sách giá trị lựa chọn của trường "Phí" (6 giá trị) — *TC 413, row 414*
310. Kiểm tra hiển thị trường "Trường hợp LC xác nhận/ Có thể xác nhận" — *TC 414, row 415*
311. Kiểm tra danh sách giá trị lựa chọn của trường "Phí xác nhận do" — *TC 415, row 416*
312. Kiểm tra danh sách giá trị lựa chọn của trường "Phí xác nhận do" — *TC 416, row 417*
313. Kiểm tra chọn giá trị hợp lệ cho trường "Phí xác nhận do" — *TC 417, row 418*
314. Kiểm tra hiển thị trường "Trường hợp LC chuyển nhượng" — *TC 418, row 419*
315. Kiểm tra bắt buộc nhập trường "Phí chuyển nhượng do" — *TC 419, row 420*
316. Kiểm tra danh sách giá trị lựa chọn của trường "Phí chuyển nhượng do" — *TC 420, row 421*
317. Kiểm tra chọn giá trị hợp lệ cho trường "Phí chuyển nhượng do" — *TC 421, row 422*
318. Kiểm tra hiển thị trường "Trường hợp LC xác nhận/ Có thể xác nhận" — *TC 422, row 423*
319. Kiểm tra bắt buộc nhập trường "Phí xác nhận do" — *TC 423, row 424*
320. Kiểm tra danh sách giá trị lựa chọn của trường "Phí xác nhận do" — *TC 424, row 425*
321. Kiểm tra chọn giá trị hợp lệ cho trường "Phí xác nhận do" — *TC 425, row 426*
322. Kiểm tra hiển thị trường "Trường hợp LC chuyển nhượng" — *TC 426, row 427*
323. Kiểm tra bắt buộc nhập trường "Phí chuyển nhượng do" — *TC 427, row 428*
324. Kiểm tra danh sách giá trị lựa chọn của trường "Phí chuyển nhượng do" — *TC 428, row 429*
325. Kiểm tra chọn giá trị hợp lệ cho trường "Phí chuyển nhượng do" — *TC 429, row 430*
326. Kiểm tra điều kiện bắt buộc nhập trường "Ô Nhập thông tin khi tick chọn Other" theo quy tắc nghiệp vụ — *TC 430, row 431*
327. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Ô Nhập thông tin khi tick chọn Other" (tối đa 200 ký tự) — *TC 431, row 432*
328. Kiểm tra hiển thị nhãn "Phí giao dịch" khi Loại LC = UPAS/UPAS PLUS (trường mới bổ sung) — *TC 432, row 433*
329. Kiểm tra bắt buộc chọn trường "a. Phí chấp nhận thanh toán" (Mandatory, chỉ hiển thị khi UPAS/UPAS PLUS) — *TC 433, row 434*
330. Kiểm tra hiển thị/nhập liệu "Ô nhập liệu khác" khi chọn "a. Phí chấp nhận thanh toán" = Khác/Other — *TC 434, row 435*
331. Kiểm tra hiển thị/nhập liệu "Ô nhập liệu khác" khi chọn "a. Phí chấp nhận thanh toán" = Khác/Other — *TC 435, row 436*
332. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "b. Phí trả nợ trước hạn" (trường mới bổ sung) — *TC 436, row 437*
333. Kiểm tra bắt buộc nhập trường "Ô nhập liệu khi chọn Other" — *TC 437, row 438*
334. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Ô nhập liệu khi chọn Other" (tối đa 1500 ký tự) — *TC 438, row 439*
335. Kiểm tra bắt buộc nhập trường "Thời hạn xuất trình chứng từ" — *TC 439, row 440*
336. Kiểm tra danh sách giá trị lựa chọn của trường "Thời hạn xuất trình chứng từ" — *TC 440, row 441*
337. Kiểm tra chọn giá trị hợp lệ cho trường "Thời hạn xuất trình chứng từ" — *TC 441, row 442*

#### Thêm mới – Thông tin khác, nguồn tiền, lãi suất, trả nợ (61)

338. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Thông tin khác" (tối đa 6500 ký tự) — *TC 442, row 443*
339. Kiểm tra bắt buộc nhập trường "Số hợp đồng mua bán" — *TC 443, row 444*
340. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Số hợp đồng mua bán" (tối đa 200 ký tự) — *TC 444, row 445*
341. Kiểm tra bắt buộc nhập trường "Ngày ký hợp đồng" — *TC 445, row 446*
342. Kiểm tra định dạng ngày trường "Ngày ký hợp đồng" — *TC 446, row 447*
343. Kiểm tra nhập giá trị ngày hợp lệ trường "Ngày ký hợp đồng" — *TC 447, row 448*
344. Kiểm tra danh sách giá trị lựa chọn của trường "Đây là giao dịch kinh doanh hàng hóa tạm nhập tái xuất" — *TC 448, row 449*
345. Kiểm tra danh sách giá trị lựa chọn của trường "Đây là giao dịch kinh doanh hàng hóa tạm nhập tái xuất" — *TC 449, row 450*
346. Kiểm tra chọn giá trị hợp lệ cho trường "Đây là giao dịch kinh doanh hàng hóa tạm nhập tái xuất" — *TC 450, row 451*
347. Kiểm tra bắt buộc nhập trường "Đây là giao dịch kinh doanh hàng hóa chuyển khẩu" — *TC 451, row 452*
348. Kiểm tra danh sách giá trị lựa chọn của trường "Đây là giao dịch kinh doanh hàng hóa chuyển khẩu" — *TC 452, row 453*
349. Kiểm tra chọn giá trị hợp lệ cho trường "Đây là giao dịch kinh doanh hàng hóa chuyển khẩu" — *TC 453, row 454*
350. Kiểm tra bắt buộc nhập trường "Khách hàng là Tổ chức kinh tế" — *TC 454, row 455*
351. Kiểm tra chọn giá trị hợp lệ cho trường "Khách hàng là Tổ chức kinh tế" — *TC 455, row 456*
352. Kiểm tra chọn giá trị hợp lệ cho trường "Khách hàng là Tổ chức kinh tế" — *TC 456, row 457*
353. Kiểm tra hiển thị trường "Thanh toán trả trước" (Advanced Payment - — *TC 457, row 458*
354. Kiểm tra bắt buộc chọn trường "Thanh toán trả trước" (Mandatory) — *TC 458, row 459*
355. Kiểm tra danh sách giá trị lựa chọn của trường "Thanh toán trả trước" (2 giá trị) — *TC 459, row 460*
356. Kiểm tra khi chọn "Thanh toán trả trước" = "Có" và "Description of Goods/Services" tích Goods thì kích hoạt khối Cam kết bổ sung chứng từ tương ứng — *TC 460, row 461*
357. Kiểm tra điều kiện bắt buộc nhập trường "Số tài khoản" theo quy tắc nghiệp vụ — *TC 461, row 462*
358. Kiểm tra chọn giá trị hợp lệ cho trường "Số tài khoản" — *TC 462, row 463*
359. Kiểm tra danh sách giá trị lựa chọn của trường "Nguồn tiền thanh toán từ các nguồn" — *TC 463, row 464*
360. Kiểm tra chọn giá trị hợp lệ cho trường "Nguồn tiền thanh toán từ các nguồn" — *TC 464, row 465*
361. [Nguồn tiền thanh toán từ các nguồn] Kiểm tra tick chọn "Deposit/ Ký quỹ" — trường "Số tài khoản" hiển thị danh sách tài khoản thanh toán (D/S/T) của khách hàng — *TC 465, row 466*
362. [Nguồn tiền thanh toán từ các nguồn] Kiểm tra tick chọn "Loan/ Vay" — trường "Số tài khoản" hiển thị danh sách hợp đồng tín dụng (Facility number) — *TC 466, row 467*
363. [Nguồn tiền thanh toán từ các nguồn] Kiểm tra tick chọn "Non-deposit/ Miễn ký quỹ" — trường "Số tài khoản" hiển thị danh sách hợp đồng tín dụng (Facility number) — *TC 467, row 468*
364. [Nguồn tiền thanh toán từ các nguồn] Kiểm tra hiển thị "Số tài khoản" dạng bảng, tách riêng từng mục theo từng loại nguồn tiền đã tick khi chọn đồng thời nhiều giá trị — *TC 468, row 469*
365. Kiểm tra định dạng dữ liệu số trường "Tỷ lệ (%)" — *TC 469, row 470*
366. Kiểm tra điều kiện bắt buộc nhập trường "Số tiền" theo quy tắc nghiệp vụ — *TC 470, row 471*
367. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Số tiền" (tối đa 16 ký tự) — *TC 471, row 472*
368. Kiểm tra định dạng dữ liệu số trường "Số tiền" — *TC 472, row 473*
369. Kiểm tra bắt buộc nhập trường "Tài khoản thu phí liên quan đến LC" — *TC 473, row 474*
370. Kiểm tra chọn giá trị hợp lệ cho trường "Tài khoản thu phí liên quan đến LC" — *TC 474, row 475*
371. Kiểm tra bắt buộc nhập trường "Ô text khi nhập nội dung khác" — *TC 475, row 476*
372. Kiểm tra điều kiện bắt buộc nhập trường "Ô text khi nhập nội dung khác" theo quy tắc nghiệp vụ — *TC 476, row 477*
373. Kiểm tra bắt buộc nhập trường "Ô text khi nhập nội dung khác" — *TC 477, row 478*
374. Kiểm tra bắt buộc nhập trường "Ô text khi nhập nội dung khác" — *TC 478, row 479*
375. Kiểm tra điều kiện bắt buộc nhập trường "Ô text khi nhập nội dung khác" theo quy tắc nghiệp vụ — *TC 479, row 480*
376. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Ô text khi nhập nội dung khác" (tối đa 2000 ký tự) — *TC 480, row 481*
377. Kiểm tra bắt buộc nhập trường "Phương thức trả nợ lãi" — *TC 481, row 482*
378. Kiểm tra danh sách giá trị lựa chọn của trường "Phương thức trả nợ lãi" — *TC 482, row 483*
379. Kiểm tra chọn giá trị hợp lệ cho trường "Phương thức trả nợ lãi" — *TC 483, row 484*
380. Kiểm tra hiển thị trường "Lãi suất áp dụng" — *TC 484, row 485*
381. Kiểm tra bắt buộc nhập trường "Lãi suất UPAS trong hạn" — *TC 485, row 486*
382. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Lãi suất UPAS trong hạn" (tối đa 100 ký tự) — *TC 486, row 487*
383. Kiểm tra bắt buộc nhập trường "Lãi suất áp dụng đối với dư nợ gốc quá hạn" — *TC 487, row 488*
384. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Lãi suất áp dụng đối với dư nợ gốc quá hạn" (tối đa 100 ký tự) — *TC 488, row 489*
385. Kiểm tra bắt buộc nhập trường "Lãi suất áp dụng đối với lãi chậm trả" — *TC 489, row 490*
386. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Lãi suất áp dụng đối với lãi chậm trả" (tối đa 100 ký tự) — *TC 490, row 491*
387. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "Khác" — *TC 491, row 492*
388. Kiểm tra bắt buộc nhập trường "Ô nhập liệu nội dung khác" — *TC 492, row 493*
389. Kiểm tra điều kiện bắt buộc nhập trường "Ô nhập liệu nội dung khác" theo quy tắc nghiệp vụ — *TC 493, row 494*
390. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Ô nhập liệu nội dung khác" (tối đa 2000 ký tự) — *TC 494, row 495*
391. [Ô text khi nhập nội dung khác (Phương thức trả nợ gốc)] Phương thức trả nợ gốc — *TC 495, row 496*
392. Kiểm tra hiển thị nhãn "Phương thức trả nợ gốc và lãi" khi Loại LC = UPAS/UPAS PLUS (trường mới bổ sung) — *TC 496, row 497*
393. Kiểm tra bắt buộc chọn trường "a. Phương thức trả nợ gốc" (Mandatory, trường mới bổ sung) — *TC 497, row 498*
394. Kiểm tra danh sách giá trị lựa chọn của trường "a. Phương thức trả nợ gốc" (2 giá trị) — *TC 498, row 499*
395. Kiểm tra chức năng nút "Đóng" — *TC 499, row 500*
396. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "Phương thức trả nợ lãi" — *TC 500, row 501*
397. Kiểm tra bắt buộc nhập trường "Đồng ý" — *TC 501, row 502*
398. Kiểm tra chọn giá trị hợp lệ cho trường "Đồng ý" — *TC 502, row 503*

#### Thêm mới – Điều khoản & điều kiện, Hồ sơ đính kèm (30)

399. Kiểm tra bắt buộc nhập trường "Điều khoản và điều kiện" — *TC 503, row 504*
400. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "Màn hình popup khi bấm vào hyperlink xem" — *TC 504, row 505*
401. [STT (Bảng tài liệu đính kèm)] Kiểm tra STT tự động đánh số tăng dần từ 01 và sắp xếp tài liệu cũ nhất lên đầu — *TC 505, row 506*
402. Kiểm tra chức năng nút "Đóng" — *TC 506, row 507*
403. [Đóng (popup Thêm tài liệu)] Kiểm tra chức năng nút "Đóng" trong popup Thêm tài liệu - không lưu thông tin đã nhập/chọn — *TC 507, row 508*
404. Kiểm tra xóa thành công 1 tài liệu khi xác nhận "Có" tại popup xác nhận xóa — *TC 508, row 509*
405. Kiểm tra không xóa tài liệu khi xác nhận "Không" tại popup xác nhận xóa — *TC 509, row 510*
406. [Hồ sơ đính kèm / Bảng tài liệu đính kèm] Kiểm tra chức năng "Xoá" 1 tài liệu — chỉ áp dụng khi CHƯA Xác nhận bổ sung — *TC 510, row 511*
407. Kiểm tra chặn khi Gửi duyệt mà chưa đính kèm tài liệu nào (bắt buộc tối thiểu 01 tài liệu) — *TC 511, row 512*
408. [Thêm mới (Add New) - Hồ sơ đính kèm] Kiểm tra đầy đủ hành vi nút "Thêm mới": vị trí hiển thị thay đổi theo trạng thái danh sách và chức năng mở popup — *TC 512, row 513*
409. [Thêm mới (nút, khu vực Hồ sơ đính kèm)] Kiểm tra chức năng nút "Thêm mới" mở popup "Thêm tài liệu" — *TC 513, row 514*
410. Kiểm tra Bảng tài liệu đính kèm hiển thị đầy đủ cột khi đã có ít nhất 1 tài liệu — *TC 514, row 515*
411. [Xóa tất cả (Bảng tài liệu đính kèm) - chỉ hiển thị khi có d…] Kiểm tra liên kết "Xóa tất cả" KHÔNG hiển thị khi bảng chưa có tài liệu nào — *TC 515, row 516*
412. [Tên tài liệu (Bảng tài liệu đính kèm)] Kiểm tra chức năng nút "Thêm mới" mở popup Thêm tài liệu (Bổ sung hồ sơ) — *TC 516, row 517*
413. Kiểm tra bắt buộc chọn trường "Loại tài liệu" trong popup Thêm tài liệu — *TC 517, row 518*
414. [Hình thức (popup Thêm tài liệu)] Kiểm tra bắt buộc chọn trường "Hình thức" trong popup Thêm tài liệu — *TC 518, row 519*
415. [Hình thức (popup Thêm tài liệu)] Kiểm tra danh sách giá trị lựa chọn của trường "Hình thức" trong popup Thêm tài liệu — *TC 519, row 520*
416. [Icon xem tài liệu (Bảng tài liệu đính kèm)] Bảng tài liệu đính kèm — *TC 520, row 521*
417. [Icon tải xuống (Bảng tài liệu đính kèm)] Bảng tài liệu đính kèm — *TC 521, row 522*
418. [Icon chỉnh sửa (Bảng tài liệu đính kèm)] Bảng tài liệu đính kèm — *TC 522, row 523*
419. Kiểm tra chức năng "Icon xóa" hiển thị popup xác nhận trước khi xóa 1 tài liệu — *TC 523, row 524*
420. Kiểm tra chặn file sai định dạng khi tải lên trong popup Thêm tài liệu (Bổ sung hồ sơ) — *TC 524, row 525*
421. Kiểm tra bắt buộc phải tải lên tối thiểu 1 file trong popup Thêm tài liệu — *TC 525, row 526*
422. [Kéo hoặc thả tập tin vào đây (popup Thêm tài liệu)] popup Thêm tài liệu — *TC 526, row 527*
423. [Kéo hoặc thả tập tin vào đây (popup Thêm tài liệu)] popup Thêm tài liệu — *TC 527, row 528*
424. [Kéo hoặc thả tập tin vào đây (popup Thêm tài liệu)] popup Thêm tài liệu — *TC 528, row 529*
425. [Kéo hoặc thả tập tin vào đây (popup Thêm tài liệu)] popup Thêm tài liệu — *TC 529, row 530*
426. [Chọn tệp tin (popup Thêm tài liệu)] popup Thêm tài liệu — *TC 530, row 531*
427. [Tên file đã chọn (popup Thêm tài liệu)] popup Thêm tài liệu — *TC 531, row 532*
428. [Lưu (popup Thêm tài liệu)] Kiểm tra chức năng nút "Lưu" khi đã nhập/chọn đầy đủ thông tin hợp lệ (thêm mới tài liệu) — *TC 532, row 533*

#### Thêm mới – Các nút cuối màn hình (8)

429. Kiểm tra chức năng nút "Lưu nháp" — *TC 533, row 534*
430. Kiểm tra chức năng nút "Tiếp tục" — *TC 534, row 535*
431. Kiểm tra chức năng nút "Quay lại" — *TC 535, row 536*
432. Kiểm tra chức năng nút "Đóng" — *TC 536, row 537*
433. Kiểm tra chức năng nút "Lưu nháp" — *TC 537, row 538*
434. Kiểm tra chức năng nút "Quay lại" — *TC 538, row 539*
435. Kiểm tra chức năng nút "Lưu template" — *TC 539, row 540*
436. Kiểm tra chức năng nút "Gửi duyệt" — *TC 540, row 541*

#### Thêm mới – Chứng từ yêu cầu (19)

437. Kiểm tra hiển thị điều kiện: tick chọn "Signed commercial invoice" thì hiện các trường thông tin con tương ứng, bỏ tick thì ẩn đi — *TC 689, row 690*
438. [Full set (3/3) of original clean shipped on board ocean Bil…] Kiểm tra hiển thị điều kiện: tick chọn "Full set (3/3) of original clean shipped on board ocean Bill of Lading, made out to" thì hiện các trường thông tin con … — *TC 690, row 691*
439. [marked freight (Bill of Lading)] Bill of Lading — *TC 691, row 692*
440. Kiểm tra hiển thị trường "Additional Conditions" thuộc điều khoản Bill of Lading — *TC 692, row 693*
441. Kiểm tra danh sách giá trị lựa chọn của trường "Additional Conditions" (2 giá trị) — *TC 693, row 694*
442. Kiểm tra hiển thị điều kiện: tick chọn "Original No.3 (for the shipper) of Air Waybill consigned to" thì hiện các trường thông tin con tương ứng, bỏ tick thì ẩ… — *TC 694, row 695*
443. [marked freight (Air Waybill)] Air Waybill — *TC 695, row 696*
444. Kiểm tra bắt buộc chọn trường "showing LC number and notifying the applicant" (Mandatory Y) — *TC 696, row 697*
445. [showing LC number and notifying the applicant] Kiểm tra danh sách giá trị lựa chọn (2 giá trị: Yes/No) — *TC 697, row 698*
446. Kiểm tra hiển thị điều kiện: tick chọn "Inspection certificate issued by" thì hiện các trường thông tin con tương ứng, bỏ tick thì ẩn đi — *TC 698, row 699*
447. [Certificate of quality and quantity issued by (bộ 1 - origi…] Kiểm tra hiển thị điều kiện: tick chọn "Certificate of quality and quantity issued by (bộ 1 - original/copies)" thì hiện các trường thông tin con tương ứng, bỏ… — *TC 699, row 700*
448. [Full set of original insurance policy/certificate in assign…] Kiểm tra hiển thị điều kiện: tick chọn "Full set of original insurance policy/certificate in assignable form and endorsed in blank" thì hiện các trường thông t… — *TC 700, row 701*
449. Kiểm tra danh sách giá trị lựa chọn của trường "covering Institute Cargo Clause" (5 giá trị) — *TC 701, row 702*
450. [Certificate of quality and quantity issued by (bộ 2 - issue…] Kiểm tra hiển thị điều kiện: tick chọn "Certificate of quality and quantity issued by (bộ 2 - issued by/number of original/copies)" thì hiện các trường thông t… — *TC 702, row 703*
451. Kiểm tra hiển thị điều kiện: tick chọn "Packing list in" thì hiện các trường thông tin con tương ứng, bỏ tick thì ẩn đi — *TC 703, row 704*
452. [Beneficiary's Certificate certifying that one set of non ne…] Kiểm tra hiển thị điều kiện: tick chọn "Beneficiary's Certificate certifying that one set of non negotiable documents plus" thì hiện các trường thông tin con t… — *TC 704, row 705*
453. [Document name (Beneficiary's Certificate)] Beneficiary's Certificate — *TC 705, row 706*
454. Kiểm tra hiển thị điều kiện: tick chọn "Other (Mô tả chứng từ)" thì hiện các trường thông tin con tương ứng, bỏ tick thì ẩn đi — *TC 706, row 707*
455. [Nội dung khi tick Other (Mô tả chứng từ)] Kiểm tra giới hạn độ dài dữ liệu nhập trường "Nội dung khi tick Other" (tối đa 5000 ký tự) — *TC 707, row 708*

#### Thêm mới – Additional conditions, LC xác nhận/chuyển nhượng, phí discounting (38)

456. Kiểm tra chức năng tìm kiếm (search) trong dropdown "BIC code" — nhập từ khoá lọc đúng kết quả — *TC 708, row 709*
457. Kiểm tra dropdown "BIC code" khi nhập từ khoá tìm kiếm không khớp với giá trị nào — *TC 709, row 710*
458. Kiểm tra hiển thị trường "Additional condition" (thay thế/tái cấu trúc từ "Other", nay có 5 giá trị) — *TC 710, row 711*
459. Kiểm tra bắt buộc chọn tối thiểu 1 giá trị cho trường "Additional condition" (Mandatory M) — *TC 711, row 712*
460. Kiểm tra danh sách giá trị lựa chọn của trường "Additional condition" (SRS mới bổ sung thêm 1 giá trị, nay 6 giá trị) — *TC 712, row 713*
461. Kiểm tra tick chọn ĐỒNG THỜI nhiều giá trị của "Additional condition" (cho phép chọn nhiều giá trị đồng thời theo SRS) — *TC 713, row 714*
462. [Additional condition - giá trị 1 (Sanction clause)] Kiểm tra giá trị mặc định của "Sanction clause" (giá trị 1) — Mặc định KHÔNG tích chọn — *TC 714, row 715*
463. [Additional condition - giá trị 2 (All documents in English)] Kiểm tra giá trị mặc định của "All documents must be issued in English" (giá trị 2) — Mặc định CÓ tích chọn khi Loại tiền LC KHÁC VND — *TC 715, row 716*
464. [Additional condition - giá trị 3 (amount utilized endorsed)] Kiểm tra giá trị mặc định của "The amount utilized must be endorsed..." (giá trị 3) — Mặc định CÓ tích chọn — *TC 716, row 717*
465. [Additional condition - giá trị 4 (due date falls...)] Kiểm tra giá trị mặc định của giá trị 4 (due date falls on 5 banking days...) — Mặc định KHÔNG tích chọn — *TC 717, row 718*
466. [Additional condition - giá trị 4 (due date falls...)] Kiểm tra giá trị 4 (due date falls...) bị ẨN khi "Draft to be drawn at - Kỳ hạn hối phiếu" tick vào Sight — *TC 718, row 719*
467. [Other (Additional condition - giá trị 5)] Kiểm tra bắt buộc nhập trường "Other" khi chọn giá trị 5 "Others (please specify)" của Additional condition — *TC 719, row 720*
468. Kiểm tra bắt buộc chọn trường "Đơn vị Days/Months/Years" khi chọn giá trị 3 của Kỳ hạn thanh toán (Mandatory) — *TC 720, row 721*
469. Kiểm tra danh sách giá trị lựa chọn của trường "Đơn vị Days/Months/Years" (3 giá trị) — *TC 721, row 722*
470. [Ô text khi chọn Other (Kỳ hạn thanh toán)] Kỳ hạn thanh toán — *TC 722, row 723*
471. [Ô nhập ngày khi chọn Maturity date] Kiểm tra bắt buộc chọn ngày khi Kỳ hạn thanh toán chọn giá trị 2 "Maturity date" (SRS mới: đổi từ N sang Mandatory) — *TC 723, row 724*
472. Kiểm tra hiển thị và bắt buộc nhập "Ô nhập nội dung Services" khi tick chọn "Services" — *TC 724, row 725*
473. [Goods / Services] Kiểm tra hệ thống cho phép tick chọn ĐỒNG THỜI cả "Goods" và "Services" — *TC 725, row 726*
474. Kiểm tra bắt buộc chọn trường "Thông tin LC xác nhận" khi Loại L/C tick "Confirmed" (Mandatory) — *TC 726, row 727*
475. Kiểm tra danh sách giá trị lựa chọn của trường "Thông tin LC xác nhận" (3 giá trị) — *TC 727, row 728*
476. [Thông tin LC xác nhận] Kiểm tra chọn "Advising bank" KHÔNG hiển thị thêm trường con nào — *TC 728, row 729*
477. Kiểm tra bắt buộc chọn trường "Thông tin LC chuyển nhượng" khi Loại L/C tick "Transferable" (Mandatory) — *TC 729, row 730*
478. Kiểm tra danh sách giá trị lựa chọn của trường "Thông tin LC chuyển nhượng" (3 giá trị) — *TC 730, row 731*
479. [Additional condition - giá trị mới (All documents in Englis…] Kiểm tra giá trị mặc định của "All documents must be issued in English and/or Vietnamese" (giá trị mới) — Mặc định CÓ tích chọn khi Loại tiền LC = VND — *TC 731, row 732*
480. [Additional condition - giá trị 2 và giá trị mới] Kiểm tra 2 giá trị "All documents in English" và "All documents in English and/or Vietnamese" không cùng tích chọn mặc định (loại trừ theo Loại tiền) — *TC 732, row 733*
481. [Phí (Discounting)] Kiểm tra hiển thị trường "Phí" khi Loại LC = Discounting — *TC 733, row 734*
482. [Phí (Discounting)] Kiểm tra bắt buộc chọn trường "Phí" khi Loại LC = Discounting (Mandatory) — *TC 734, row 735*
483. [Phí (Discounting)] Kiểm tra danh sách giá trị lựa chọn của trường "Phí" khi Loại LC = Discounting (6 giá trị) — *TC 735, row 736*
484. [Ô nhập liệu khi chọn Other (Phí Discounting)] Phí Discounting — *TC 736, row 737*
485. [Ô nhập liệu khi chọn Other (Phí Discounting)] Phí Discounting — *TC 737, row 738*
486. Kiểm tra hiển thị nội dung mặc định và cho phép chỉnh sửa trường "Phí LC discounting" — *TC 738, row 739*
487. Kiểm tra hiển thị và bắt buộc chọn trường "Phí xác nhận do" khi Loại LC Discounting đồng thời chọn Confirmed/May add — *TC 739, row 740*
488. Kiểm tra danh sách giá trị lựa chọn của trường "Phí xác nhận do" (2 giá trị) — *TC 740, row 741*
489. Kiểm tra hiển thị và bắt buộc chọn trường "Phí chuyển nhượng do" khi Loại LC Discounting đồng thời chọn Transferable — *TC 741, row 742*
490. Kiểm tra danh sách giá trị lựa chọn của trường "Phí chuyển nhượng do" (2 giá trị) — *TC 742, row 743*
491. Kiểm tra hiển thị trường "Phí Chấp nhận thanh toán LC Discounting" chỉ khi Loại LC = Discounting — *TC 743, row 744*
492. Kiểm tra hiển thị trường "Lãi, Phí thương lượng thanh toán của Ngân hàng thương lượng" chỉ khi Loại LC = Discounting — *TC 744, row 745*
493. [Màn hình popup Điều khoản và điều kiện (LC Discounting)] Kiểm tra nội dung popup Điều khoản và điều kiện riêng cho LC Discounting (khác nội dung LC Regular/UPAS) — *TC 745, row 746*

#### Thêm mới – Cam kết bổ sung chứng từ (19)

494. Kiểm tra hiển thị khối cam kết bổ sung chứng từ "Bổ sung chứng từ (tạm nhập tái xuất)" khi Giao dịch kinh doanh hàng hóa tạm nhập tái xuất = Yes VÀ Description… — *TC 746, row 747*
495. [Ngày bổ sung chứng từ (tạm nhập tái xuất)] Kiểm tra chọn ngày hợp lệ cho "Ngày bổ sung chứng từ" (trường hợp tạm nhập tái xuất) — *TC 747, row 748*
496. [Đối với báo Có tiền hàng tái xuất theo hợp đồng tái xuất hà…] Kiểm tra khi tick chọn "Đối với báo Có tiền hàng tái xuất..." thì hiện thêm ô nhập số tháng — *TC 748, row 749*
497. [Ngày bổ sung chứng từ (tự động tính từ số tháng)] Kiểm tra "Ngày bổ sung chứng từ" tự động tính theo công thức (ngày ký số gửi ngân hàng + số tháng đã nhập) — *TC 749, row 750*
498. Kiểm tra hiển thị khối cam kết bổ sung chứng từ "Bổ sung chứng từ (chuyển khẩu)" khi Giao dịch kinh doanh hàng hóa chuyển khẩu = Yes VÀ Description of Goods/Se… — *TC 750, row 751*
499. Kiểm tra hiển thị khối cam kết bổ sung chứng từ "Bổ sung chứng từ (thanh toán trả trước)" khi Thanh toán trả trước = Yes VÀ Description of Goods/Services tick … — *TC 751, row 752*
500. [Ô điền số tháng (các khối cam kết bổ sung chứng từ)] Kiểm tra định dạng dữ liệu số cho "Ô điền số tháng" ở các khối cam kết bổ sung chứng từ — *TC 752, row 753*
501. [Description of Goods and/ or Services - Services] Kiểm tra hiển thị khối "Liên quan đến giao dịch của chúng tôi..." khi tick chọn "Services" — *TC 753, row 754*
502. [Chứng từ khác (Services)] Kiểm tra bắt buộc nhập "Ô nhập nội dung chứng từ khác" khi tick chọn checkbox "Chứng từ khác" — *TC 754, row 755*
503. [Chứng từ cam kết bổ sung (Hyperlink xem tài liệu)] Kiểm tra click vào "Chứng từ cam kết bổ sung" mở xem trước tài liệu đã tải lên — *TC 755, row 756*
504. [Chứng từ cam kết bổ sung (DOCUMENTS TO BE PRESENTED)] Kiểm tra bắt buộc tick chọn tối thiểu 1 trong 12 giá trị của "DOCUMENTS TO BE PRESENTED" (Mandatory) — *TC 756, row 757*
505. [Chứng từ cam kết bổ sung (DOCUMENTS TO BE PRESENTED)] Kiểm tra danh sách giá trị lựa chọn của "DOCUMENTS TO BE PRESENTED" (12 giá trị) — *TC 757, row 758*
506. [Chứng từ cam kết bổ sung khác (mục 12 - Other Documents to …] Kiểm tra bắt buộc nhập "Chứng từ cam kết bổ sung khác" khi tick chọn mục 12 "Chứng từ khác" của DOCUMENTS TO BE PRESENTED — *TC 758, row 759*
507. [Sẽ nhận tiền thanh toán... về tài khoản của tôi/chúng tôi t…] Kiểm tra giá trị mặc định của checkbox "Sẽ nhận tiền thanh toán theo hợp đồng tái xuất hàng hóa..." — Mặc định CÓ tích và cho sửa — *TC 759, row 760*
508. [Đây là giao dịch kinh doanh hàng hóa tạm nhập tái xuất / ch…] Kiểm tra chặn khi chọn "Có" đồng thời ở CẢ 2 trường "tạm nhập tái xuất" và "chuyển khẩu" — *TC 771, row 772*
509. [Đây là giao dịch kinh doanh hàng hóa tạm nhập tái xuất / ch…] Kiểm tra cho phép chọn "Có" ở 1 trong 2 trường, trường còn lại vẫn có thể chọn "Không" bình thường — *TC 772, row 773*
510. [Bổ sung chứng từ tại mục CHỨNG TỪ CAM KẾT BỔ SUNG dưới đây …] Kiểm tra checkbox bị ẨN khi "Giao dịch kinh doanh hàng hóa chuyển khẩu" = Yes (và tick Goods) — *TC 773, row 774*
511. [Bổ sung chứng từ tại mục CHỨNG TỪ CAM KẾT BỔ SUNG dưới đây …] Kiểm tra checkbox bị ẨN khi "Giao dịch kinh doanh hàng hóa tạm nhập tái xuất" = Yes (và tick Goods) — *TC 774, row 775*
512. [Bổ sung chứng từ tại mục CHỨNG TỪ CAM KẾT BỔ SUNG dưới đây …] Kiểm tra checkbox HIỂN THỊ bình thường khi cả 2 điều kiện (tạm nhập tái xuất, chuyển khẩu) đều = Không — *TC 775, row 776*

#### Xem chi tiết (39)

513. Kiểm tra quyền truy cập chức năng "Xem chi tiết" (FO) — *TC 115, row 116*
514. Kiểm tra chặn truy cập chức năng "Xem chi tiết" (FO) khi không được phân quyền — *TC 116, row 117*
515. Kiểm tra hệ thống thực hiện phân quyền đúng theo cây phân quyền (TTTM > LCNK > Phát hành LC (PHLC) > Truy vấn hồ sơ (V_PHLC)) khi user đăng nhập thành công và … — *TC 117, row 118*
516. Kiểm tra hiển thị trường [Lý do từ chối] khi hồ sơ có trạng thái = Từ chối và bị từ chối bởi người dùng DN — *TC 118, row 119*
517. Kiểm tra hiển thị trường [Lý do từ chối] khi hồ sơ có trạng thái = Từ chối và bị từ chối bởi người dùng Ngân hàng — *TC 119, row 120*
518. Kiểm tra trường [Lý do từ chối] không hiển thị khi hồ sơ không ở trạng thái = Từ chối — *TC 120, row 121*
519. Kiểm tra chức năng nút <Lịch sử giao dịch> mở tab xem chi tiết thông tin ghi nhận thay đổi của giao dịch — *TC 121, row 122*
520. Kiểm tra chức năng nút <Đóng> đóng màn hình xem chi tiết và quay lại màn hình trước đó — *TC 122, row 123*
521. Kiểm tra nút <Chỉnh sửa> hiển thị và hoạt động đúng khi hồ sơ có trạng thái = Bản nháp — *TC 123, row 124*
522. Kiểm tra nút <Chỉnh sửa> hiển thị và hoạt động đúng khi hồ sơ có trạng thái = Yêu cầu bổ sung — *TC 124, row 125*
523. Kiểm tra nút <Chỉnh sửa> không hiển thị khi hồ sơ ở trạng thái khác Bản nháp/Yêu cầu bổ sung — *TC 125, row 126*
524. Kiểm tra nút <Xóa đề nghị> hiển thị và mở popup xác nhận xóa khi hồ sơ có trạng thái = Bản nháp — *TC 126, row 127*
525. Kiểm tra nút <Xóa đề nghị> không hiển thị khi hồ sơ ở trạng thái khác Bản nháp — *TC 127, row 128*
526. Kiểm tra nút <Hủy giao dịch> hiển thị và mở popup xác nhận hủy đề nghị khi hồ sơ có trạng thái = Yêu cầu bổ sung — *TC 128, row 129*
527. Kiểm tra nút <Hủy giao dịch> không hiển thị khi hồ sơ ở trạng thái khác Yêu cầu bổ sung — *TC 129, row 130*
528. Kiểm tra nút <Sao chép> hiển thị và mở popup xác nhận sao chép khi hồ sơ ở trạng thái khác Bản nháp — *TC 130, row 131*
529. Kiểm tra nút <Sao chép> không hiển thị khi hồ sơ có trạng thái = Bản nháp — *TC 131, row 132*
530. Kiểm tra nút <Phê duyệt> hiển thị và mở popup phê duyệt khi hồ sơ có trạng thái = Chờ duyệt — *TC 132, row 133*
531. Kiểm tra nút <Phê duyệt> không hiển thị khi hồ sơ ở trạng thái khác Chờ duyệt — *TC 133, row 134*
532. Kiểm tra nút <Từ chối> hiển thị và mở popup xác nhận từ chối phê duyệt khi hồ sơ có trạng thái = Chờ duyệt — *TC 134, row 135*
533. Kiểm tra nút <Từ chối> không hiển thị khi hồ sơ ở trạng thái khác Chờ duyệt — *TC 135, row 136*
534. Kiểm tra nút <Ký số cá nhân> hiển thị và mở màn hình ký số cá nhân khi hồ sơ có trạng thái = Chờ duyệt cấp tiếp theo — *TC 136, row 137*
535. Kiểm tra nút <Ký số cá nhân> không hiển thị khi hồ sơ ở trạng thái khác Chờ duyệt cấp tiếp theo — *TC 137, row 138*
536. Kiểm tra hiển thị trường "Trạng thái" — *TC 138, row 139*
537. Kiểm tra nhập/hiển thị dữ liệu hợp lệ trường "Lịch sử giao dịch" — *TC 139, row 140*
538. Kiểm tra hiển thị trường "Mã đề nghị" — *TC 140, row 141*
539. Kiểm tra hiển thị trường "Ngày đề nghị" — *TC 141, row 142*
540. Kiểm tra hiển thị trường "Người tạo" — *TC 142, row 143*
541. Kiểm tra hiển thị trường "Thời gian phê duyệt" — *TC 143, row 144*
542. Kiểm tra hiển thị trường "Người phê duyệt" — *TC 144, row 145*
543. Kiểm tra hiển thị trường "Lý do từ chối" — *TC 145, row 146*
544. Kiểm tra chức năng nút "Đóng" — *TC 146, row 147*
545. Kiểm tra chức năng nút "Xóa đề nghị" — *TC 147, row 148*
546. Kiểm tra chức năng nút "Hủy giao dịch" — *TC 148, row 149*
547. Kiểm tra chức năng nút "Chỉnh sửa" — *TC 149, row 150*
548. Kiểm tra chức năng nút "Sao chép" — *TC 150, row 151*
549. Kiểm tra chức năng nút "Phê duyệt" — *TC 151, row 152*
550. Kiểm tra chức năng nút "Từ chối" — *TC 152, row 153*
551. Kiểm tra chức năng nút "Ký số cá nhân" — *TC 153, row 154*

#### Phê duyệt (22)

552. Kiểm tra quyền truy cập chức năng "Phê duyệt" (FO) — *TC 597, row 598*
553. Kiểm tra chặn truy cập chức năng "Phê duyệt" (FO) khi không được phân quyền — *TC 598, row 599*
554. Kiểm tra NSD được phân quyền phê duyệt có thể truy vấn và xem chi tiết giao dịch ở trạng thái Chờ duyệt/Chờ duyệt cấp tiếp theo theo đúng đường dẫn quy định — *TC 599, row 600*
555. Kiểm tra khi đăng nhập thành công hệ thống gọi API tới BO Admin Portal để lấy đầy đủ thông tin phân quyền của user (CIF, cây phân quyền 4 tầng, roleName, hạn m… — *TC 600, row 601*
556. Kiểm tra luồng chính: Tổng Số tiền LC trong ngày của user <= Hạn mức phê duyệt của user thì hệ thống cho phép thực hiện phê duyệt — *TC 601, row 602*
557. Kiểm tra ngoại lệ: Tổng Số tiền LC trong ngày của user vượt quá Hạn mức phê duyệt được cấp thì hệ thống chặn phê duyệt và hiển thị thông báo MSG14 — *TC 602, row 603*
558. Kiểm tra khi NSD chọn <Phê duyệt> hệ thống hiển thị popup Xác thực và gọi API tới hệ thống 2FA để lấy danh sách phương thức xác thực khả dụng của người dùng (S… — *TC 603, row 604*
559. Kiểm tra luồng chính: NSD nhập đúng mã xác thực trong thời gian hiệu lực OTP, chọn <Xác nhận> thì hệ thống xác thực thành công, hiển thị màn hình thông báo thà… — *TC 604, row 605*
560. Kiểm tra ngoại lệ: NSD nhập sai mã OTP vượt quá số lần nhập sai tối đa cho phép thì hệ thống từ chối xác thực và không ghi nhận phê duyệt — *TC 605, row 606*
561. Kiểm tra ngoại lệ: NSD chọn <Đóng> tại popup Xác thực OTP — *TC 606, row 607*
562. Kiểm tra ngoại lệ: NSD chọn <Đóng> tại popup Xác thực thì hệ thống đóng popup và không ghi nhận phê duyệt — *TC 607, row 608*
563. Kiểm tra luồng chính TH1: DN có nhiều cấp duyệt không theo thứ tự - sau khi phê duyệt thành công, hệ thống gọi API Admin Portal để lấy cấp phê duyệt tiếp theo … — *TC 608, row 609*
564. Kiểm tra luồng chính TH2: DN có nhiều cấp duyệt phải tuân theo thứ tự - sau khi phê duyệt thành công, hệ thống xác định đúng user/cấp phê duyệt kế tiếp theo đú… — *TC 609, row 610*
565. Kiểm tra luồng chính TH3: DN chỉ có 1 cấp duyệt - sau khi phê duyệt thành công, giao dịch hoàn tất quy trình phê duyệt (không còn cấp tiếp theo) — *TC 610, row 611*
566. Kiểm tra sau khi phê duyệt thành công, hệ thống gửi EMAIL01 tới đúng người dùng có quyền phê duyệt bản ghi ở cấp tiếp theo — *TC 611, row 612*
567. Kiểm tra hệ thống lưu log giao dịch sau mỗi lần phê duyệt thành công với đầy đủ thông tin mã giao dịch, user thực hiện, thời gian và hành động — *TC 612, row 613*
568. Kiểm tra ngoại lệ: khi gọi API tới Admin Portal/2FA bị lỗi (timeout, lỗi hệ thống, response lỗi), hệ thống ghi log đầy đủ thông tin request/response và không c… — *TC 613, row 614*
569. Kiểm tra bắt buộc nhập trường "Hình thức nhận mã giao dịch OTP" — *TC 614, row 615*
570. Kiểm tra chọn giá trị hợp lệ cho trường "Hình thức nhận mã giao dịch OTP" — *TC 615, row 616*
571. Kiểm tra bắt buộc nhập trường "Nhập mã giao dịch OTP" — *TC 616, row 617*
572. Kiểm tra chức năng nút "Đóng" — *TC 617, row 618*
573. Kiểm tra chức năng nút "Xác nhận" — *TC 618, row 619*

#### Ký số cá nhân (13)

574. Kiểm tra quyền truy cập chức năng "Ký số cá nhân" (FO) — *TC 636, row 637*
575. Kiểm tra chặn truy cập chức năng "Ký số cá nhân" (FO) khi không được phân quyền — *TC 637, row 638*
576. Kiểm tra luồng chính ký số cá nhân thành công (Online) khi approveLegal = true, giao dịch phải chuyển tiếp sang chờ ký số pháp nhân — *TC 638, row 639*
577. Kiểm tra luồng ký số cá nhân thành công khi approveLegal = false, doanh nghiệp không cần ký số pháp nhân, giao dịch được gửi thẳng sang BO — *TC 639, row 640*
578. Kiểm tra thông báo khi user chưa đăng ký chữ ký số (CKS) thực hiện ký số Online — *TC 640, row 641*
579. Kiểm tra hệ thống trả về danh sách nhà cung cấp CKS theo CIF khi user đã đăng ký CKS và nhấn Ký số Online — *TC 641, row 642*
580. Kiểm tra luồng ký số cá nhân thành công bằng hình thức Ký số USB token — *TC 642, row 643*
581. Kiểm tra xử lý khi call API ký số (Online hoặc USB token) tới hệ thống ký số/Admin Portal bị lỗi — *TC 643, row 644*
582. Kiểm tra hiển thị trường "Nhà cung cấp" tại màn hình Ký số cá nhân — *TC 644, row 645*
583. Kiểm tra bắt buộc nhập trường "Nhà cung cấp" — *TC 645, row 646*
584. Kiểm tra chọn giá trị hợp lệ cho trường "Nhà cung cấp" — *TC 646, row 647*
585. Kiểm tra chức năng nút "Đóng" — *TC 647, row 648*
586. Kiểm tra chức năng nút "Xác nhận" — *TC 648, row 649*

## Happy case 2 – Như Happy case 1 + Ký số pháp nhân

- E2E: **TC 2, row 3** — Luồng happy case 1 cấp duyệt có ký số pháp nhân

### Edge cases

#### Ký số pháp nhân (15)

1. Kiểm tra quyền truy cập chức năng "Ký số pháp nhân" (FO) — *TC 649, row 650*
2. Kiểm tra chặn truy cập chức năng "Ký số pháp nhân" (FO) khi không được phân quyền — *TC 650, row 651*
3. Kiểm tra luồng chính: NSD được phân quyền ký số pháp nhân truy cập chức năng và xem đúng danh sách giao dịch đang chờ ký số pháp nhân của chính mình — *TC 651, row 652*
4. Kiểm tra hệ thống tự động tạo tác vụ xử lý cho user khi API lấy danh sách chữ ký số theo DN trả về user đã đăng ký CKS pháp nhân — *TC 652, row 653*
5. Kiểm tra hệ thống hiển thị cảnh báo khi API lấy danh sách chữ ký số theo DN trả về chưa có user nào khai báo CKS pháp nhân — *TC 653, row 654*
6. Kiểm tra thông báo MSG15 khi user thực hiện Ký số Online nhưng chưa đăng ký CKS trên Admin portal — *TC 654, row 655*
7. Kiểm tra hệ thống trả về danh sách nhà cung cấp CKS theo CIF và xử lý ký số pháp nhân thành công khi user đã đăng ký CKS và chọn Ký số Online — *TC 655, row 656*
8. Kiểm tra luồng ký số pháp nhân thành công bằng hình thức Ký số USB token — *TC 656, row 657*
9. Kiểm tra luồng chính đầy đủ khi ký số pháp nhân thành công: hiển thị thông báo thành công, chuyển trạng thái giao dịch, đẩy giao dịch sang BO, gửi EMAIL03 và l… — *TC 657, row 658*
10. Kiểm tra xử lý và lưu log khi call API (lấy danh sách CKS theo DN, gọi Admin portal khi ký số Online/USB token, hoặc đẩy giao dịch sang BO) bị lỗi — *TC 658, row 659*
11. Kiểm tra chức năng nút <Đóng> trên màn hình xem đề nghị ký số pháp nhân — *TC 659, row 660*
12. Kiểm tra bắt buộc nhập trường "Nhà cung cấp" — *TC 660, row 661*
13. Kiểm tra chọn giá trị hợp lệ cho trường "Nhà cung cấp" — *TC 661, row 662*
14. [Đóng] Kiểm tra chức năng nút "Xác nhận" tại màn hình Ký số cá nhân — *TC 662, row 663*
15. Kiểm tra chức năng nút "Xác nhận" — *TC 663, row 664*

## Happy case 3 – Duyệt 2 cấp (Kế toán phó → Kế toán trưởng), không ký số pháp nhân

- E2E: **TC 3, row 4** — Luồng happy case 2 cấp duyệt không có ký số pháp nhân

*Không có edge case riêng – dùng chung edge case của các happy case trên.*

## Happy case 4 – Duyệt 2 cấp + Ký số pháp nhân

- E2E: **TC 4, row 5** — Luồng happy case 2 cấp duyệt có ký số pháp nhân

*Không có edge case riêng – dùng chung edge case của các happy case trên.*

## Happy case 5 – Lưu nháp → mở lại → Gửi duyệt → … → Đã gửi ngân hàng

- E2E: **TC 7, row 8** — Luồng lưu nháp rồi phát hành 1 cấp duyệt không có ký số pháp nhân
- Biến thể: TC 5, row 6 — Luồng lưu nháp rồi phát hành 1 cấp duyệt có ký số pháp nhân
- Biến thể: TC 8, row 9 — Luồng lưu nháp rồi phát hành 2 cấp duyệt không có ký số pháp nhân
- Biến thể: TC 6, row 7 — Luồng lưu nháp rồi phát hành 2 cấp duyệt có ký số pháp nhân

### Edge cases

#### Chỉnh sửa bản nháp (12)

1. Kiểm tra quyền truy cập chức năng "Chỉnh sửa" (FO) — *TC 541, row 542*
2. Kiểm tra chặn truy cập chức năng "Chỉnh sửa" (FO) khi không được phân quyền — *TC 542, row 543*
3. Verify khi user đăng nhập thành công và có quyền Chỉnh sửa hồ sơ (mã U_PHLC), hệ thống gọi API tới BO Admin Portal để lấy thông tin CIF, cây phân quyền (TTTM >… — *TC 543, row 544*
4. Verify user không được cấp quyền Chỉnh sửa hồ sơ (mã U_PHLC) trong cây phân quyền thì không được phép truy cập/thực hiện chức năng Chỉnh sửa đề nghị Phát hành … — *TC 544, row 545*
5. Verify màn hình Chỉnh sửa đề nghị áp dụng quy tắc tương tự màn hình Thêm mới, riêng trường [Mã đề nghị] không cho phép cập nhật. — *TC 545, row 546*
6. Verify khi thực hiện chỉnh sửa không phát sinh lỗi, hệ thống cập nhật thông tin mới cho bản ghi đề nghị và hiển thị màn hình thông báo thành công. — *TC 546, row 547*
7. Verify hệ thống lưu log giao dịch (mã giao dịch, user, thời gian, hành động = "Chỉnh sửa") khi thao tác chỉnh sửa đề nghị Phát hành LC hoàn tất. — *TC 547, row 548*
8. Verify khi các trường hợp gọi API (ví dụ API xác thực phân quyền tới BO Admin Portal) bị lỗi, hệ thống lưu log đầy đủ thông tin liên quan đến lần gọi API đó. — *TC 548, row 549*
9. Kiểm tra chức năng nút "Đóng" — *TC 549, row 550*
10. Kiểm tra chức năng nút "Quay lại" — *TC 550, row 551*
11. Kiểm tra chức năng nút "Lưu nháp" — *TC 551, row 552*
12. Kiểm tra chức năng nút "Gửi duyệt" — *TC 552, row 553*

## Happy case 6 – Bị Trả lại → Maker chỉnh sửa, gửi lại → … → Đã gửi ngân hàng

- E2E: **TC 14, row 15** — Yêu cầu chỉnh sửa rồi phát hành thành công luồng duyệt 1 cấp không ký số pháp nhân
- Biến thể: TC 15, row 16 — Yêu cầu chỉnh sửa rồi phát hành thành công luồng duyệt 1 cấp có ký số pháp nhân
- Biến thể: TC 16, row 17 — Yêu cầu chỉnh sửa rồi phát hành thành công luồng duyệt 2 cấp không ký số pháp nhân
- Biến thể: TC 17, row 18 — Yêu cầu chỉnh sửa rồi phát hành thành công luồng duyệt 2 cấp có ký số pháp nhân

*Không có edge case riêng – dùng chung edge case của các happy case trên.*

## Ngoài happy case

#### Luồng lỗi E2E (5)

1. Hủy giao dịch từ bản nháp — *TC 9, row 10*
2. Từ chối tại Kế toán trưởng — *TC 10, row 11*
3. Từ chối tại Chủ tài khoản — *TC 11, row 12*
4. Kiểm tra bước Ký số pháp nhân KHÔNG có tùy chọn Từ chối — *TC 12, row 13*
5. Yêu cầu chỉnh sửa rồi hủy — *TC 13, row 14*

#### Từ chối (17)

6. Kiểm tra quyền truy cập chức năng "Từ chối" (FO) — *TC 619, row 620*
7. Kiểm tra chặn truy cập chức năng "Từ chối" (FO) khi không được phân quyền — *TC 620, row 621*
8. Kiểm tra luồng chính: NSD đủ quyền và trong hạn mức thực hiện Từ chối thành công giao dịch có TT = Chờ duyệt cấp tiếp theo — *TC 621, row 622*
9. Kiểm tra luồng chính: NSD đủ quyền và trong hạn mức thực hiện Từ chối thành công giao dịch có TT = Chờ duyệt cấp tiếp theo — *TC 622, row 623*
10. Kiểm tra hệ thống gọi API tới BO Admin Portal để lấy thông tin phân quyền (CIF, cây phân quyền, roleName, hạn mức phê duyệt) khi NSD đăng nhập, phục vụ chức nă… — *TC 623, row 624*
11. Kiểm tra hệ thống chặn thao tác Từ chối khi user không được phân quyền Đồng ý/từ chối phát hành LC (Mã A_PHLC) trong cây phân quyền — *TC 624, row 625*
12. Kiểm tra hệ thống ngăn thực hiện Từ chối khi Tổng Số tiền LC trong ngày của user vượt Hạn mức phê duyệt — *TC 625, row 626*
13. Kiểm tra hệ thống không cho phép Từ chối đối với giao dịch không ở Trạng thái Chờ duyệt hoặc Chờ duyệt cấp tiếp theo (ví dụ Trạng thái = Từ chối/Đã duyệt/Bản n… — *TC 626, row 627*
14. Kiểm tra hệ thống hiển thị popup Xác thực khi NSD đủ điều kiện chọn <Từ chối> — *TC 627, row 628*
15. Kiểm tra chức năng đóng popup Xác thực khi NSD chọn <Đóng>, không thực hiện Từ chối — *TC 628, row 629*
16. Kiểm tra hệ thống gửi EMAIL01 tới đúng user maker đã tạo giao dịch sau khi Từ chối thành công — *TC 629, row 630*
17. Kiểm tra hệ thống lưu đầy đủ và chính xác log giao dịch sau khi thực hiện Từ chối thành công — *TC 630, row 631*
18. Kiểm tra hệ thống lưu log khi call API tới Admin Portal (đóng luồng) bị lỗi trong quá trình Từ chối — *TC 631, row 632*
19. Kiểm tra bắt buộc nhập trường "Lý do từ chối" — *TC 632, row 633*
20. Kiểm tra giới hạn độ dài dữ liệu nhập trường "Lý do từ chối" (tối đa 200 ký tự) — *TC 633, row 634*
21. Kiểm tra chức năng nút "Không" — *TC 634, row 635*
22. Kiểm tra chức năng nút "Từ chối" — *TC 635, row 636*

#### Hủy đề nghị (15)

23. Kiểm tra quyền truy cập chức năng "Hủy đề nghị" (FO) — *TC 568, row 569*
24. Kiểm tra chặn truy cập chức năng "Hủy đề nghị" (FO) khi không được phân quyền — *TC 569, row 570*
25. Kiểm tra luồng chính: NSD được phân quyền thực hiện Hủy đề nghị thành công đối với giao dịch đang ở trạng thái hợp lệ (Yêu cầu bổ sung), không bị khóa, không b… — *TC 570, row 571*
26. Kiểm tra popup xác nhận Hủy đề nghị hiển thị đúng nội dung và các nút chức năng khi NSD chọn <Hủy đề nghị>. — *TC 571, row 572*
27. Kiểm tra NSD chọn <Không> tại popup xác nhận thì hệ thống hủy bỏ thao tác, đóng popup và không thay đổi trạng thái giao dịch. — *TC 572, row 573*
28. Kiểm tra hệ thống không cho phép/hiển thị cảnh báo khi Hủy đề nghị đối với giao dịch không ở trạng thái Yêu cầu bổ sung. — *TC 573, row 574*
29. Kiểm tra hệ thống không cho phép Hủy đề nghị khi giao dịch đang bị khóa bởi user khác — *TC 574, row 575*
30. Kiểm tra hệ thống không cho phép Hủy đề nghị khi giao dịch đã được gửi duyệt bởi user khác. — *TC 575, row 576*
31. Kiểm tra hệ thống không cho phép NSD không đủ phân quyền (không có Mã D_PHLC trong cây phân quyền) thực hiện chức năng Hủy đề nghị. — *TC 576, row 577*
32. Kiểm tra hệ thống ghi log khi call API lấy thông tin phân quyền tới BO Admin Portal bị lỗi. — *TC 577, row 578*
33. Kiểm tra hậu điều kiện: sau khi Hủy đề nghị thành công, trạng thái được cập nhật đồng bộ ở cả FO và BO (nếu có liên kết BO). — *TC 578, row 579*
34. Kiểm tra log giao dịch được lưu đầy đủ và chính xác thông tin sau khi thực hiện Hủy đề nghị thành công. — *TC 579, row 580*
35. Kiểm tra hiển thị trường "Tiêu đề" — *TC 580, row 581*
36. Kiểm tra chức năng nút "Không" — *TC 581, row 582*
37. Kiểm tra chức năng nút "Có" — *TC 582, row 583*

#### Xóa đề nghị (15)

38. Kiểm tra quyền truy cập chức năng "Xóa đề nghị" (FO) — *TC 553, row 554*
39. Kiểm tra chặn truy cập chức năng "Xóa đề nghị" (FO) khi không được phân quyền — *TC 554, row 555*
40. Kiểm tra luồng chính: NSD có đủ quyền xóa thành công đề nghị Phát hành LC đang ở trạng thái Bản nháp. — *TC 555, row 556*
41. Kiểm tra NSD hủy thao tác xóa khi chọn <Không> tại popup xác nhận. — *TC 556, row 557*
42. Kiểm tra hệ thống chặn xóa khi giao dịch không còn ở trạng thái Bản nháp (đã được gửi duyệt/xử lý sang trạng thái khác). — *TC 557, row 558*
43. Kiểm tra hệ thống chặn xóa khi giao dịch đang bị khóa hoặc đang được gửi duyệt bởi user khác. — *TC 558, row 559*
44. Kiểm tra hệ thống không cho phép NSD không đủ quyền (thiếu mã quyền Xóa - D_PHLC) thực hiện xóa đề nghị. — *TC 559, row 560*
45. Kiểm tra dữ liệu trên DB được cập nhật đúng sau khi xóa đề nghị thành công. — *TC 560, row 561*
46. Kiểm tra hệ thống gửi email thông báo sau khi xóa đề nghị thành công — *TC 561, row 562*
47. Kiểm tra hệ thống gọi API tới Admin Portal để thực thi đóng luồng sau khi xóa đề nghị thành công. — *TC 562, row 563*
48. Kiểm tra hệ thống xử lý khi API xác thực phân quyền từ BO Admin Portal không phản hồi/lỗi tại thời điểm đăng nhập, ảnh hưởng tới khả năng thao tác Xóa đề nghị. — *TC 563, row 564*
49. Kiểm tra hậu điều kiện: sau khi xóa thành công, giao dịch bị loại bỏ hoàn toàn khỏi danh sách hiển thị cho NSD. — *TC 564, row 565*
50. Kiểm tra hiển thị trường "Tiêu đề" — *TC 565, row 566*
51. Kiểm tra chức năng nút "Không" — *TC 566, row 567*
52. Kiểm tra chức năng nút "Có" — *TC 567, row 568*

#### Sao chép (14)

53. Kiểm tra quyền truy cập chức năng "Sao chép" (FO) — *TC 583, row 584*
54. Kiểm tra chặn truy cập chức năng "Sao chép" (FO) khi không được phân quyền — *TC 584, row 585*
55. Kiểm tra luồng chính Sao chép giao dịch thành công đối với giao dịch có trạng thái khác Bản nháp — *TC 585, row 586*
56. Kiểm tra luồng huỷ khi NSD chọn <Không> trên popup xác nhận Sao chép — *TC 586, row 587*
57. Kiểm tra hệ thống không cho phép Sao chép khi user không được phân quyền chức năng Sao chép hồ sơ (Mã S_PHLC) trong cây phân quyền — *TC 587, row 588*
58. Kiểm tra hệ thống không cho phép Sao chép đối với giao dịch đang ở trạng thái Bản nháp — *TC 588, row 589*
59. Kiểm tra đề nghị mới sinh ra sau khi Sao chép có mã ID mới (khác ID gốc) và trạng thái khởi tạo = Bản nháp — *TC 589, row 590*
60. Kiểm tra đề nghị mới sinh ra sau khi Sao chép ở trạng thái Bản nháp — *TC 590, row 591*
61. Kiểm tra hệ thống lưu log khi Sao chép giao dịch thành công, bao gồm ID gốc, ID mới, user thực hiện và thời gian thực hiện — *TC 591, row 592*
62. Kiểm tra nội dung và các nút thao tác trên popup xác nhận Sao chép hiển thị đúng theo BR — *TC 592, row 593*
63. Kiểm tra đường dẫn truy cập chức năng Sao chép: Menu > Phát hành LC > Xem chi tiết giao dịch — *TC 593, row 594*
64. Kiểm tra hiển thị trường "Tiêu đề" — *TC 594, row 595*
65. Kiểm tra chức năng nút "Không" — *TC 595, row 596*
66. Kiểm tra chức năng nút "Có" — *TC 596, row 597*

#### Quản lý template (11)

67. Kiểm tra quyền truy cập chức năng "Quản lý template" (FO) — *TC 760, row 761*
68. [Quyền truy cập] Kiểm tra chặn truy cập chức năng "Quản lý template" khi không được phân quyền — *TC 761, row 762*
69. [Lưu template (nút, màn Thêm mới)] Kiểm tra chức năng nút "Lưu template" tại màn hình Thêm mới lưu thông tin thành 1 template mới — *TC 762, row 763*
70. Kiểm tra cột "STT" tự động đánh số thứ tự tăng dần trong danh sách template — *TC 763, row 764*
71. Kiểm tra "Mã template" sinh đúng cấu trúc ddmmyyyyxxx — *TC 764, row 765*
72. [Danh sách tìm kiếm template - Tìm kiếm nhanh] Kiểm tra chức năng tìm kiếm nhanh theo Mã template, Tên template — *TC 765, row 766*
73. [Lọc - Số CIF / Tên khách hàng / Tên bên thụ hưởng] Kiểm tra chức năng lọc nâng cao theo Số CIF, Tên khách hàng, Tên bên thụ hưởng — *TC 766, row 767*
74. [Khởi tạo LC (nút, popup xem chi tiết template)] Kiểm tra chức năng nút "Khởi tạo LC" mở màn hình Thêm mới với thông tin điền sẵn theo template — *TC 767, row 768*
75. [Khởi tạo LC (nút, popup xem chi tiết template)] Kiểm tra dữ liệu điền sẵn từ template khi Khởi tạo LC vẫn tuân thủ đầy đủ rule validate như màn hình Thêm mới thông thường — *TC 768, row 769*
76. [Lưu (nút, chỉnh sửa bản ghi template)] Kiểm tra chỉnh sửa bản ghi template — dữ liệu chỉnh sửa tuân thủ đúng rule validate của màn hình Thêm mới LC — *TC 769, row 770*
77. [Thoát (nút, xem/chỉnh sửa template)] Kiểm tra chức năng nút "Thoát" quay lại danh sách template, không lưu thay đổi — *TC 770, row 771*

#### Bổ sung hồ sơ sau phát hành (cần BO phát hành xong) (25)

78. Kiểm tra quyền truy cập chức năng "Bổ sung hồ sơ sau phát hành" (FO) — *TC 664, row 665*
79. Kiểm tra chặn truy cập khi user không có quyền truy vấn giao dịch TT = "Hoàn thành – Chờ bổ sung hồ sơ" — *TC 665, row 666*
80. Kiểm tra tab "Hồ sơ bổ sung" CHỈ hiển thị với giao dịch TT = "Hoàn thành – Chờ bổ sung hồ sơ" — *TC 666, row 667*
81. Kiểm tra 2 tab "Đề nghị phát hành" và "Kết quả xử lý của ngân hàng" hiển thị giống các màn view khác — *TC 667, row 668*
82. [Chưa có hồ sơ nào được upload] Kiểm tra hiển thị trạng thái rỗng khi lần đầu truy cập tab "Hồ sơ bổ sung" (chưa upload tài liệu nào) — *TC 668, row 669*
83. Kiểm tra chức năng nút "Thêm mới" mở popup/màn hình Thêm tài liệu — *TC 669, row 670*
84. Kiểm tra hiển thị và danh sách giá trị trường "Loại tài liệu" trong popup Thêm tài liệu (Bổ sung hồ sơ) — *TC 670, row 671*
85. Kiểm tra bắt buộc chọn trường "Hình thức" (Mandatory) trong popup Thêm tài liệu (Bổ sung hồ sơ) — *TC 671, row 672*
86. Kiểm tra danh sách giá trị lựa chọn của trường "Hình thức" (2 giá trị: Ký số/Không ký số) — *TC 672, row 673*
87. Kiểm tra bắt buộc upload tối thiểu 1 file (Mandatory) trong popup Thêm tài liệu (Bổ sung hồ sơ) — *TC 673, row 674*
88. Kiểm tra chặn file sai định dạng/vượt dung lượng — áp dụng đúng quy tắc như Hồ sơ đính kèm Bước 3 (MSG11, MSG4) — *TC 674, row 675*
89. [Đóng (popup Thêm tài liệu)] Kiểm tra chức năng nút "Đóng" trong popup Thêm tài liệu (Bổ sung hồ sơ) — không lưu thông tin — *TC 675, row 676*
90. [Lưu (popup Thêm tài liệu)] Kiểm tra hiển thị Bảng danh mục tài liệu đã upload (Bổ sung hồ sơ) khi chưa có tài liệu nào — *TC 676, row 677*
91. Kiểm tra hiển thị đầy đủ cột của Bảng danh mục tài liệu đã upload sau khi thêm tài liệu — *TC 677, row 678*
92. [STT (Bảng danh mục tài liệu đã upload)] Kiểm tra STT tự động đánh số tăng dần — *TC 678, row 679*
93. [Tên tài liệu (Bảng danh mục tài liệu đã upload)] Kiểm tra click vào "Tên tài liệu" mở xem trước nội dung tài liệu — *TC 679, row 680*
94. [Xoá (Bảng danh mục tài liệu đã upload)] Kiểm tra chức năng "Xoá" 1 tài liệu — chỉ áp dụng khi CHƯA Xác nhận bổ sung — *TC 680, row 681*
95. [Xoá tất cả (Bảng danh mục tài liệu đã upload)] Kiểm tra chức năng "Xoá tất cả" — xoá toàn bộ tài liệu của lần bổ sung hiện tại (chưa xác nhận) — *TC 681, row 682*
96. Kiểm tra bắt buộc có tối thiểu 1 tài liệu trước khi cho phép nhấn "Xác nhận bổ sung" (Mandatory) — *TC 682, row 683*
97. Kiểm tra chức năng "Xác nhận bổ sung" chốt danh sách thành "Danh mục bổ sung hồ sơ lần 1" (chỉ xem) và gửi email thông báo — *TC 683, row 684*
98. Kiểm tra "Danh mục bổ sung hồ sơ lần 1" hiển thị ở chế độ CHỈ XEM, không cho sửa/xoá tài liệu đã xác nhận — *TC 684, row 685*
99. [Thêm mới (Danh mục bổ sung hồ sơ lần 1)] Kiểm tra nút "Thêm mới" tại cuối Danh mục lần 1 mở khu vực upload mới cho lần bổ sung tiếp theo (lần 2) — *TC 685, row 686*
100. Kiểm tra luồng bổ sung lần 2 hoạt động đúng tương tự lần 1 (thêm tài liệu, xác nhận, chuyển thành lịch sử chỉ xem) — *TC 686, row 687*
101. Kiểm tra nút "Sao chép" áp dụng đúng quy tắc Sao chép đề nghị chung, KHÔNG sao chép nội dung tab Hồ sơ bổ sung — *TC 687, row 688*
102. [Đóng (cuối màn hình)] Kiểm tra nút "Đóng" ở cuối màn hình thoát khỏi màn hình bổ sung hồ sơ, quay lại màn hình trước đó — *TC 688, row 689*

#### Nhập thông tin hồ sơ hậu kiểm (cần BO phát hành xong) (22)

103. [Tải lên file hố sơ hậu kiểm] Điều kiện: - Người dùng đăng nhập thành công vào hệ thống và có quyền thao tác - Đường dẫn: LC > Phát hành >Truy vấn giao dịch/Nhấn hyperlink ( giao dịch có TT… — *TC 776, row 777*
104. [Tải lên file hố sơ hậu kiểm] Điều kiện: - Người dùng đăng nhập thành công vào hệ thống và có quyền thao tác - Đường dẫn: LC > Phát hành >Truy vấn giao dịch/Nhấn hyperlink ( giao dịch có TT… — *TC 777, row 778*
105. [Tải lên file hố sơ hậu kiểm] Điều kiện: - Người dùng đăng nhập thành công vào hệ thống và có quyền thao tác - Đường dẫn: LC > Phát hành >Truy vấn giao dịch/Nhấn hyperlink ( giao dịch có TT… — *TC 778, row 779*
106. [Tải lên file hố sơ hậu kiểm] Điều kiện: - Người dùng đăng nhập thành công vào hệ thống và có quyền thao tác - Đường dẫn: LC > Phát hành >Truy vấn giao dịch/Nhấn hyperlink ( giao dịch có TT… — *TC 779, row 780*
107. [Tải lên file hố sơ hậu kiểm] Điều kiện: - Người dùng đăng nhập thành công vào hệ thống và có quyền thao tác - Đường dẫn: LC > Phát hành >Truy vấn giao dịch/Nhấn hyperlink ( giao dịch có TT… — *TC 780, row 781*
108. [Tải lên file hố sơ hậu kiểm] Điều kiện: - Người dùng đăng nhập thành công vào hệ thống và có quyền thao tác - Đường dẫn: LC > Phát hành >Truy vấn giao dịch/Nhấn hyperlink ( giao dịch có TT… — *TC 781, row 782*
109. [Tải lên file hố sơ hậu kiểm] Điều kiện: - Người dùng đăng nhập thành công vào hệ thống và có quyền thao tác - Đường dẫn: LC > Phát hành >Truy vấn giao dịch/Nhấn hyperlink ( giao dịch có TT… — *TC 782, row 783*
110. [Tải lên file hố sơ hậu kiểm] Điều kiện: - Người dùng đăng nhập thành công vào hệ thống và có quyền thao tác - Đường dẫn: LC > Phát hành >Truy vấn giao dịch/Nhấn hyperlink ( giao dịch có TT… — *TC 783, row 784*
111. [Tải lên file hố sơ hậu kiểm] Điều kiện: - Người dùng đăng nhập thành công vào hệ thống và có quyền thao tác - Đường dẫn: LC > Phát hành >Truy vấn giao dịch/Nhấn hyperlink ( giao dịch có TT… — *TC 784, row 785*
112. [Tải lên file hố sơ hậu kiểm] Điều kiện: - Người dùng đăng nhập thành công vào hệ thống và có quyền thao tác - Đường dẫn: LC > Phát hành >Truy vấn giao dịch/Nhấn hyperlink ( giao dịch có TT… — *TC 785, row 786*
113. [Tải lên file hố sơ hậu kiểm] Điều kiện: - Người dùng đăng nhập thành công vào hệ thống và có quyền thao tác - Đường dẫn: LC > Phát hành >Truy vấn giao dịch/Nhấn hyperlink ( giao dịch có TT… — *TC 786, row 787*
114. [Tải lên file hố sơ hậu kiểm] Điều kiện: - Người dùng đăng nhập thành công vào hệ thống và có quyền thao tác - Đường dẫn: LC > Phát hành >Truy vấn giao dịch/Nhấn hyperlink ( giao dịch có TT… — *TC 787, row 788*
115. [Tải lên file hố sơ hậu kiểm] Điều kiện: - Người dùng đăng nhập thành công vào hệ thống và có quyền thao tác - Đường dẫn: LC > Phát hành >Truy vấn giao dịch/Nhấn hyperlink ( giao dịch có TT… — *TC 788, row 789*
116. [Tải lên file hố sơ hậu kiểm] Điều kiện: - Người dùng đăng nhập thành công vào hệ thống và có quyền thao tác - Đường dẫn: LC > Phát hành >Truy vấn giao dịch/Nhấn hyperlink ( giao dịch có TT… — *TC 789, row 790*
117. [Tải lên file hố sơ hậu kiểm] Điều kiện: - Người dùng đăng nhập thành công vào hệ thống và có quyền thao tác - Đường dẫn: LC > Phát hành >Truy vấn giao dịch/Nhấn hyperlink ( giao dịch có TT… — *TC 790, row 791*
118. [Tải lên file hố sơ hậu kiểm] Điều kiện: - Người dùng đăng nhập thành công vào hệ thống và có quyền thao tác - Đường dẫn: LC > Phát hành >Truy vấn giao dịch/Nhấn hyperlink ( giao dịch có TT… — *TC 791, row 792*
119. [Tải lên file hố sơ hậu kiểm] Điều kiện: - Người dùng đăng nhập thành công vào hệ thống và có quyền thao tác - Đường dẫn: LC > Phát hành >Truy vấn giao dịch/Nhấn hyperlink ( giao dịch có TT… — *TC 792, row 793*
120. [Tải lên file hố sơ hậu kiểm] Điều kiện: - Người dùng đăng nhập thành công vào hệ thống và có quyền thao tác - Đường dẫn: LC > Phát hành >Truy vấn giao dịch/Nhấn hyperlink ( giao dịch có TT… — *TC 793, row 794*
121. [Tải lên file hố sơ hậu kiểm] Điều kiện: - Người dùng đăng nhập thành công vào hệ thống và có quyền thao tác - Đường dẫn: LC > Phát hành >Truy vấn giao dịch/Nhấn hyperlink ( giao dịch có TT… — *TC 794, row 795*
122. [Tải lên file hố sơ hậu kiểm] Điều kiện: - Người dùng đăng nhập thành công vào hệ thống và có quyền thao tác - Đường dẫn: LC > Phát hành >Truy vấn giao dịch/Nhấn hyperlink ( giao dịch có TT… — *TC 795, row 796*
123. [Tải lên file hố sơ hậu kiểm] Điều kiện: - Người dùng đăng nhập thành công vào hệ thống và có quyền thao tác - Đường dẫn: LC > Phát hành >Truy vấn giao dịch/Nhấn hyperlink ( giao dịch có TT… — *TC 796, row 797*
124. [Tải lên file hố sơ hậu kiểm] Điều kiện: - Người dùng đăng nhập thành công vào hệ thống và có quyền thao tác - Đường dẫn: LC > Phát hành >Truy vấn giao dịch/Nhấn hyperlink ( giao dịch có TT… — *TC 797, row 798*

