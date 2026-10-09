# BO – Phát hành LC: Happy case & Edge case

Nguồn: `VCB_TradeFlat_Testcase_SIT_LC_ISS_Phat Hanh v1.1 (1).xlsx` (sheet đầu tiên). *row* = số dòng trong Excel.

**Điều kiện chung cho mọi TC BO:** cần 1 đề nghị FO ở trạng thái *Đã gửi ngân hàng* (FO đã qua OTP + ký số) – xem `../FO/FO_automation_blockers.md`.

Edge case chỉ liệt kê ở happy case **đầu tiên** đi qua bước đó.

## Happy case 1 – Đề xuất phê duyệt, KHÔNG cần thẩm quyền BGĐ CN: CA xử lý → CA lead duyệt → CRC xử lý → CRC lead duyệt & ký số điện → TI → Hoàn thành

- E2E: **TC 27, row 28** — Luồng (1) – Đề xuất phê duyệt - Không cần thẩm quyền BGĐ CN – FO yêu cầu điện phát hành bản không ký số – FO không chọn giao dịch chuyển khẩu/tạm nhập tái xuất → Hoàn thành
- Biến thể: TC 28, row 29 — Luồng (1) – Đề xuất phê duyệt - Không cần thẩm quyền BGĐ CN – FO yêu cầu bản điện tử có ký số – LĐ QLN ký – FO không chọn giao dịch chuyển khẩu/tạm nhập tái xuất → Hoàn thành
- Biến thể: TC 29, row 30 — Luồng (1) – Đề xuất phê duyệt - Không cần thẩm quyền BGĐ CN – FO yêu cầu bản điện tử có ký số – BGĐ CN ký – FO không chọn giao dịch chuyển khẩu/tạm nhập tái xuất → Hoàn thành
- Biến thể: TC 30, row 31 — Luồng (1) – Đề xuất phê duyệt - Không cần thẩm quyền BGĐ CN – FO yêu cầu điện phát hành bản không ký số – FO có chọn giao dịch chuyển khẩu/tạm nhập tái xuất → Hoàn thành - Chờ bổ sung hồ sơ
- Biến thể: TC 31, row 32 — Luồng (1) – Đề xuất phê duyệt - Không cần thẩm quyền BGĐ CN – FO yêu cầu bản điện tử có ký số – LĐ QLN ký – FO có chọn giao dịch chuyển khẩu/tạm nhập tái xuất → Hoàn thành - Chờ bổ sung hồ sơ
- Biến thể: TC 32, row 33 — Luồng (1) – Đề xuất phê duyệt - Không cần thẩm quyền BGĐ CN – FO yêu cầu bản điện tử có ký số – BGĐ CN ký – FO có chọn giao dịch chuyển khẩu/tạm nhập tái xuất → Hoàn thành - Chờ bổ sung hồ sơ

### Edge cases

#### B01 · Danh sách, phân trang, bộ lọc (chung) (71)

1. [List] Lưới chức năng – Kiểm tra tổng thể giao diện màn hình → 1. Bố cục - Các label, textbox, button được bố trí thẳng hàng, có độ … — *TC 798, row 799*
2. [List] Lưới chức năng – Kiểm tra giao diện màn hình → 1. Màn hình phải hiển thị và hoạt đọng bình thường sau khi resize 2. … — *TC 799, row 800*
3. [List] Lưới chức năng – Kiểm tra hiển thị danh sách theo phân quyền user → Chỉ thấy các giao dịch thuộc phạm vi phân quyền của user đang đăng nh… — *TC 800, row 801*
4. [List] Lưới chức năng – Kiểm tra hiển thị các trường thông tin trên màn hình → 1. Màn hình đầy đủ thông tin như prototype 2, Hiển thị title: "L/C - … — *TC 801, row 802*
5. [List] Lưới chức năng – Kiểm tra khi nhấn icon reload trên trình duyệt nhiều lần → Trang thông tin được hiển thị đầy đủ — *TC 802, row 803*
6. [List] Lưới chức năng – Kiểm tra kết quả hiển thị của danh sách khi người dùng tìm kiếm dữ liệu Không tồn tại trong hệ thống → Hiển thị text <Không c… — *TC 803, row 804*
7. [List] Lưới chức năng – Kiểm tra kết quả hiển thị của danh sách khi người dùng tìm kiếm dữ liệu có tồn tại trong hệ thống → Hiển thị danh sách giao d… — *TC 804, row 805*
8. [List] Lưới chức năng – Kiểm tra sắp xếp hiển thị các trường trên màn hình danh sách → Các trường thông tin hiển thị lên theo đúng các trường đã chọn… — *TC 805, row 806*
9. [List] Tác vụ – Kiểm tra tác vụ hiển thị → Hiển thị 2 tác vụ: - Truy vấn giao dịch - mở màn hình xem chi tiết đề… — *TC 806, row 807*
10. [List] Mã đề nghị – Kiểm tra dữ liệu hiển thị → Hiển thị chính xác thông tin của mã đề nghị - Mã hệ thống tự sinh sau… — *TC 807, row 808*
11. [List] Trạng thái – Kiểm tra dữ liệu hiển thị → Hiển thị chính xác trạng thái của đề nghị đã được tạo, gồm: - Chờ tiế… — *TC 808, row 809*
12. [List] Quan sát cột Khách hàng – Kiểm tra dữ liệu hiển thị → Hiển thị đúng mã CIF khách hàng — *TC 809, row 810*
13. [List] Quan sát cột Số L/C – Kiểm tra dữ liệu hiển thị → Hiển thị chính xác thông tin số L/C do TI trả ra khi đề nghị đã lấy đ… — *TC 810, row 811*
14. [List] Quan sát cột Số tiền L/C – Kiểm tra dữ liệu hiển thị → - Hiển thị chính xác thông tin số tiền L/C - Căn lề phải - Format: xx… — *TC 811, row 812*
15. [List] Quan sát cột Loại tiền – Kiểm tra dữ liệu hiển thị → Hiển thị chính xác thông tin loại tiền L/C - Format: {VND} - Nối chuỗ… — *TC 812, row 813*
16. [List] Quan sát cột Kênh đề nghị – Kiểm tra dữ liệu hiển thị → Hiển thị đúng Tên kênh đề nghị — *TC 813, row 814*
17. [List] Quan sát cột Kênh đề nghị – Kiểm tra hiển thị khi dữ liệu chứa nội dung dài hơn độ rộng của cột → Hiển thị dấu (...) ở phía cuối, nơi dữ liệu … — *TC 814, row 815*
18. [List] Quan sát cột Kênh đề nghị – Kiểm tra nội dung hiển thị khi hover vào nội dung dài và có dấu (...) → Hiển thị tooltip và đầy đủ nội dung của tr… — *TC 815, row 816*
19. [List] Quan sát cột Ngày đề nghị – Kiểm tra dữ liệu hiển thị → Hiển thị [Ngày đề nghị] là thời gian Khách hàng ký số pháp nhân thành… — *TC 816, row 817*
20. [List] Quan sát cột Ngày phát hành – Kiểm tra dữ liệu hiển thị → Hiển thị chính xác thông tin ngày phát hành L/C do TI trả ra khi đề n… — *TC 817, row 818*
21. [List] Quan sát cột Ngày hết hiệu lực – Kiểm tra dữ liệu hiển thị → Hiển thị chính xác thông tin ngày hết hiệu lực L/C do TI trả ra khi đ… — *TC 818, row 819*
22. [List] Gõ từ khóa tìm kiếm vào ô tìm kiếm nhanh – Kiểm tra chức năng → Hiển thị danh sách tương ứng — *TC 819, row 820*
23. [List] Column Setting – Kiểm tra chức năng → Hệ thống hiển thị/ẩn các cột theo cấu hình đã lựa chọn - thứ tự và th… — *TC 820, row 821*
24. [List] Nhập/chọn các tiêu chí tìm kiếm ở Filter Table – Kiểm tra chức năng → Hệ thống hiển thị danh sách các bản ghi phù hợp với điều kiện lọc Cho… — *TC 821, row 822*
25. [List] Download Grid – Kiểm tra chức năng → Hệ thống tải xuống file dữ liệu thành công - dữ liệu trong file đầy đ… — *TC 822, row 823*
26. [Phân trang] Kiểm tra trường Row number → Hệ thống tự động hiển thị 10, 20, 30, 50 bản ghi trên danh sách tương… — *TC 823, row 824*
27. [Phân trang] Previous – Kiểm tra hoạt động → Hệ thống hiển thị danh sách trang kế trước — *TC 824, row 825*
28. [Phân trang] Next – Kiểm tra hoạt động → Hệ thống hiển thị danh sách trang tiếp theo — *TC 825, row 826*
29. [Phân trang] Page line – Kiểm tra hoạt động → Hệ thống hiển thị đúng màn hình danh sách trang đã chọn — *TC 826, row 827*
30. [Xem chi tiết] Kết quả xử lý giao dịch – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị các trường thông tin: - Số tham chiếu LC - label (số tr… — *TC 827, row 828*
31. [Xem chi tiết] Số tham chiếu LC – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị dữ liệu master ref (TI) trả về lấy thông tin tại trường ti-e… — *TC 828, row 829*
32. [Xem chi tiết] File Điện phát hành LC – Kiểm tra thông tin tab Điện phát hành L/C → Điều kiện: Trong Q2: có event = issue , step = Authorise , status… — *TC 829, row 830*
33. [Xem chi tiết] Lịch sử giao dịch – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị các trường thông tin và hiển thị giá trị tương ứng: - Hành đ… — *TC 830, row 831*
34. [Xem chi tiết] Lịch sử giao dịch – Kiểm tra các hành động lưu lại lịch sử → Khi người dùng thực hiện các chức năng dưới đây 1. FO duyệt cuối (trư… — *TC 831, row 832*
35. [Bộ lọc] Tìm kiếm – Kiểm tra kết quả khi người dùng click vào nút → Hệ thống hiển thị kết quả tìm kiếm chính xác theo điều kiện lọc: - Đi… — *TC 832, row 833*
36. [Bộ lọc] Đặt lại – Kiểm tra kết quả khi người dùng click vào nút → Hệ thống xóa dữ liệu đã nhập tại các trường thông tin > Trả lại màn d… — *TC 833, row 834*
37. [Bộ lọc] Kiểm tra trường Mã đề nghị → - Hiển thị danh sách kết quả tương ứng với điều kiện đã chọn - Hiển t… — *TC 834, row 835*
38. [Bộ lọc] Kiểm tra trường Mã đề nghị → Hệ thống không cho phép nhập khoảng trắng Hệ thống tự động trim khoản… — *TC 835, row 836*
39. [Bộ lọc] Kiểm tra trường Mã đề nghị → Cho phép copy paste Hiển thị dữ liệu đã copy paste — *TC 836, row 837*
40. [Bộ lọc] Kiểm tra trường CIF → - Hiển thị danh sách kết quả tương ứng với điều kiện đã chọn - Hiển t… — *TC 837, row 838*
41. [Bộ lọc] Kiểm tra trường CIF → Hệ thống không cho phép nhập khoảng trắng Hệ thống tự động trim khoản… — *TC 838, row 839*
42. [Bộ lọc] Kiểm tra trường CIF → Cho phép copy paste Hiển thị dữ liệu đã copy paste — *TC 839, row 840*
43. [Bộ lọc] Kiểm tra trường Tên bên đề nghị → - Hiển thị danh sách kết quả tương ứng với điều kiện đã chọn - Hiển t… — *TC 840, row 841*
44. [Bộ lọc] Kiểm tra trường Tên bên đề nghị → Hệ thống không cho phép nhập khoảng trắng Hệ thống tự động trim khoản… — *TC 841, row 842*
45. [Bộ lọc] Kiểm tra trường Tên bên đề nghị → Cho phép copy paste Hiển thị dữ liệu đã copy paste — *TC 842, row 843*
46. [Bộ lọc] Kiểm tra trường Số hợp đồng hạn mức → - Hiển thị danh sách kết quả tương ứng với điều kiện đã chọn - Hiển t… — *TC 843, row 844*
47. [Bộ lọc] Kiểm tra trường Số hợp đồng hạn mức → Hệ thống không cho phép nhập khoảng trắng Hệ thống tự động trim khoản… — *TC 844, row 845*
48. [Bộ lọc] Kiểm tra trường Số hợp đồng hạn mức → Cho phép copy paste Hiển thị dữ liệu đã copy paste — *TC 845, row 846*
49. [Bộ lọc] Kiểm tra trường Người thụ hưởng → - Hiển thị danh sách kết quả tương ứng với điều kiện đã chọn - Hiển t… — *TC 846, row 847*
50. [Bộ lọc] Kiểm tra trường Người thụ hưởng → Hệ thống không cho phép nhập khoảng trắng Hệ thống tự động trim khoản… — *TC 847, row 848*
51. [Bộ lọc] Kiểm tra trường Người thụ hưởng → Cho phép copy paste Hiển thị dữ liệu đã copy paste — *TC 848, row 849*
52. [Bộ lọc] Kiểm tra trường Số L/C → - Hiển thị danh sách kết quả tương ứng với điều kiện đã chọn - Hiển t… — *TC 849, row 850*
53. [Bộ lọc] Kiểm tra trường Số L/C → Hệ thống không cho phép nhập khoảng trắng Hệ thống tự động trim khoản… — *TC 850, row 851*
54. [Bộ lọc] Kiểm tra trường Số L/C → Cho phép copy paste Hiển thị dữ liệu đã copy paste — *TC 851, row 852*
55. [Bộ lọc] Kiểm tra trường Số tiền → Hệ thống không cho phép nhập khoảng trắng Hệ thống tự động trim khoản… — *TC 852, row 853*
56. [Bộ lọc] Kiểm tra trường Số tiền → Cho phép copy paste Hiển thị dữ liệu đã copy paste — *TC 853, row 854*
57. [Bộ lọc] Kiểm tra trường Số tiền → - Chỉ cho phép nhập số và lớn hơn hoặc bằng 0 - Không cho phép nhập k… — *TC 854, row 855*
58. [Bộ lọc] Kiểm tra trường Ngày đề nghị → 1. Hiển thị danh sách kết quả tương ứng với ngày đã chọn 2. Hệ thống … — *TC 855, row 856*
59. [Bộ lọc] Kiểm tra trường Ngày đề nghị → Hệ thống không cho phép nhập khoảng trắng Hệ thống tự động trim khoản… — *TC 856, row 857*
60. [Bộ lọc] Kiểm tra trường Ngày đề nghị → Cho phép copy paste Hiển thị dữ liệu đã copy paste — *TC 857, row 858*
61. [Bộ lọc] Kiểm tra trường Ngày phát hành → 1. Hiển thị danh sách kết quả tương ứng với ngày đã chọn 2. Hệ thống … — *TC 858, row 859*
62. [Bộ lọc] Kiểm tra trường Ngày phát hành → Hệ thống không cho phép nhập khoảng trắng Hệ thống tự động trim khoản… — *TC 859, row 860*
63. [Bộ lọc] Kiểm tra trường Ngày phát hành → Cho phép copy paste Hiển thị dữ liệu đã copy paste — *TC 860, row 861*
64. [Bộ lọc] Kiểm tra trường Ngày hết hạn → 1. Hiển thị danh sách kết quả tương ứng với ngày đã chọn 2. Hệ thống … — *TC 861, row 862*
65. [Bộ lọc] Kiểm tra trường Ngày hết hạn → Hệ thống không cho phép nhập khoảng trắng Hệ thống tự động trim khoản… — *TC 862, row 863*
66. [Bộ lọc] Kiểm tra trường Ngày hết hạn → Cho phép copy paste Hiển thị dữ liệu đã copy paste — *TC 863, row 864*
67. [Bộ lọc] Kiểm tra trường Loại L/C → - Hiển thị danh sách kết quả tương ứng với điều kiện đã chọn - Hiển t… — *TC 864, row 865*
68. [Bộ lọc] Kiểm tra trường Trạng thái → - Hiển thị danh sách Trạng thái: Chờ tiếp nhận, CBTĐ xử lý, QLTĐ phê … — *TC 865, row 866*
69. [Bộ lọc] Kiểm tra trường Trạng thái → - Chỉ cho phép chữ Hoa/thường - Không cho phép nhập khoảng trắng hoặc… — *TC 866, row 867*
70. [List (Mới bổ sung)] Lưới chức năng – Kiểm tra hiển thị danh sách theo phân quyền user → Chỉ thấy các giao dịch phát hành LC thuộc phạm vi phân quyền… — *TC 867, row 868*
71. [List (Mới bổ sung)] Lưới chức năng – Kiểm tra counter tab Tất cả/Cần xử lý/Đang theo dõi/Đã hoàn thành → 1. Số lượng Counter = số bản ghi của từng t… — *TC 868, row 869*

#### B02 · Xem chi tiết hồ sơ (chung) (145)

1. [Xem chi tiết] Hình thức phát hành LC – Kiểm tra thông tin hiển thị trên màn hình → Hiển thị dữ liệu: 1. Các trường thông tin: Hiển thị đúng các trườ… — *TC 869, row 870*
2. [Xem chi tiết] Yêu cầu chữ ký số trên điện LC – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị các trường thông tin: - Số tham chiếu LC - label… — *TC 870, row 871*
3. [Xem chi tiết] Lịch sử giao dịch – Kiểm tra chức năng khi người dùng click vào → Hiển thị popup có các trường thông tin và hiển thị giá trị tương ứng… — *TC 871, row 872*
4. [Xem chi tiết] Lịch sử giao dịch – Kiểm tra các hành động lưu lại lịch sử → Khi người dùng thực hiện các chức năng dưới đây: 1. FO duyệt cuối (tr… — *TC 872, row 873*
5. [Xem chi tiết] Tiêu đề/ Mã GD – Kiểm tra dữ liệu hiển thị → Hiển thị tiêu đề: "Đề nghị phát hành L/C [Mã GD]" — *TC 873, row 874*
6. [Xem chi tiết] Badge trạng thái – Kiểm tra giá trị hiển thị → Hiển thị chính xác trạng thái giao dịch = CBTĐ xử lý — *TC 874, row 875*
7. [Xem chi tiết] Ngày đề nghị – Kiểm tra giá trị hiển thị → Hiển thị ngày FO thao tác ký số thành công ở bước cuối và đẩy sang BO… — *TC 875, row 876*
8. [Xem chi tiết] Người đại diện hợp pháp – Kiểm tra giá trị hiển thị → Hiển thị Tên người dùng FO thao tác ký số thành công ở bước cuối và đ… — *TC 876, row 877*
9. [Xem chi tiết] Hồ sơ bị từ chối – Kiểm tra giá trị hiển thị → ❖ Hiển thị thông tin từ chối với giao dịch có TT = Từ chối ❖ Hiển thị… — *TC 877, row 878*
10. [Xem chi tiết] A. THÔNG TIN ĐỀ NGHỊ PHÁT HÀNH – Kiểm tra dữ liệu hiển thị → Hiển thị đúng tiêu đề: A. THÔNG TIN ĐỀ NGHỊ PHÁT HÀNH — *TC 878, row 879*
11. [Xem chi tiết] Thông tin khách hàng – Kiểm tra dữ liệu hiển thị → Hiển thị đúng tên trường <THÔNG TIN KHÁCH HÀNG> — *TC 879, row 880*
12. [Xem chi tiết] Mã khách hàng – Kiểm tra dữ liệu hiển thị → Hiển thị số CIF của khách hàng — *TC 880, row 881*
13. [Xem chi tiết] Tên công ty – Kiểm tra dữ liệu hiển thị → đây là thông tin khách hàng (theo CIF/hồ sơ KH) từ FO gửi sang — *TC 881, row 882*
14. [Xem chi tiết] Địa chỉ công ty – Kiểm tra dữ liệu hiển thị → đây là thông tin khách hàng (theo CIF/hồ sơ KH) từ FO gửi sang — *TC 882, row 883*
15. [Xem chi tiết] Số DKKD/MST – Kiểm tra chức năng khi click nút → Hiển thị chính xác dữ liệu prefill từ FO (nếu có) — *TC 883, row 884*
16. [Xem chi tiết] Số điện thoại – Kiểm tra chức năng khi click nút → Hiển thị chính xác dữ liệu prefill từ FO (nếu có) — *TC 884, row 885*
17. [Xem chi tiết] Người đại diện – Kiểm tra chức năng khi click nút → Hiển thị chính xác dữ liệu prefill từ FO (nếu có) — *TC 885, row 886*
18. [Xem chi tiết] Chức vụ – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO (nếu có) — *TC 886, row 887*
19. [Xem chi tiết] Văn bản ủy quyền – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO (nếu có) — *TC 887, row 888*
20. [Xem chi tiết] Ngày ủy quyền – Kiểm tra validate trường → Hiển thị chính xác dữ liệu prefill từ FO (nếu có) — *TC 888, row 889*
21. [Xem chi tiết] CCCD/Hộ chiếu – Kiểm tra validate trường → Hiển thị chính xác dữ liệu prefill từ FO (nếu có) — *TC 889, row 890*
22. [Xem chi tiết] Phân hạng khách hàng – Kiểm tra validate trường → Hiển thị chính xác dữ liệu prefill từ FO (nếu có) — *TC 890, row 891*
23. [Xem chi tiết] Hợp đồng hạn mức – Kiểm tra hiển thị → Hiển thị đúng tên trường <Hợp đồng hạn mức> — *TC 891, row 892*
24. [Xem chi tiết] Hợp đồng hạn mức số – Kiểm tra hiển thị → Hiển thị chính xác giá trị theo Số hợp đồng hạn mức đã chọn ở FO — *TC 892, row 893*
25. [Xem chi tiết] Chi nhánh – Kiểm tra hiển thị → Hiển thị chính xác giá trị theo Số hợp đồng hạn mức đã chọn từ FO For… — *TC 893, row 894*
26. [Xem chi tiết] Hạn mức theo HĐ CHM – Kiểm tra hiển thị → Hiển thị chính xác giá trị theo Số hợp đồng hạn mức đã chọn ở FO Hiển… — *TC 894, row 895*
27. [Xem chi tiết] Hạn mức khả dụng – Kiểm tra hiển thị → Hiển thị chính xác giá trị theo Số hợp đồng hạn mức đã chọn ở FO Hiển… — *TC 895, row 896*
28. [Xem chi tiết] Thông tin đề nghị – Kiểm tra hiển thị → Hiển thị đúng tên trường <Thông tin đề nghị> — *TC 896, row 897*
29. [Xem chi tiết] Loại LC – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO: [Giá trị mặc định: Không hủ… — *TC 897, row 898*
30. [Xem chi tiết] Loại sản phẩm L/C – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO: Loại sản phẩm UPAS/UPAS PLU… — *TC 898, row 899*
31. [Xem chi tiết] Ô nhập liệu khi chọn LC khác – Kiểm tra hiển thị → Hiển thị thông tin đã nhập ở FO khi chọn loại sản phẩm L/C là “Khác” — *TC 899, row 900*
32. [Xem chi tiết] Thông tin LC xác nhận – Kiểm tra hiển thị → Hiển thị đúng tên trường <Thông tin LC xác nhận> Thông tin hiển thị k… — *TC 900, row 901*
33. [Xem chi tiết] Ngân hàng xác nhận – Kiểm tra hiển thị → Hiển thị thông tin đã nhập ở FO dạng BIC - Tên ngân hàng — *TC 901, row 902*
34. [Xem chi tiết] Thông tin LC chuyển hượng – Kiểm tra hiển thị → Hiển thị đúng tên trường <Thông tin LC chuyển nhượng> Thông tin hiển … — *TC 902, row 903*
35. [Xem chi tiết] Ngân hàng chuyển nhượng – Kiểm tra hiển thị → Hiển thị thông tin đã nhập ở FO dạng BIC - Tên ngân hàng — *TC 903, row 904*
36. [Xem chi tiết] Hình thức phát hành LC – Kiểm tra hiển thị → Hiển thị thông tin đã nhập ở FO: Mail/SWIFT — *TC 904, row 905*
37. [Xem chi tiết] Yêu cầu chữ ký số trên điện LC – Kiểm tra hiển thị → Hiển thị thông tin đã nhập ở FO: Bản điện tử có/không ký số — *TC 905, row 906*
38. [Xem chi tiết] Ngày hết hạn – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 906, row 907*
39. [Xem chi tiết] Nơi hết hạn – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 907, row 908*
40. [Xem chi tiết] Ngân hàng bên thụ hưởng – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO: "Mã SWIFT/BIC code (nếu FO … — *TC 908, row 909*
41. [Xem chi tiết] Ngân hàng thông báo – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO: "Mã SWIFT/BIC code (nếu FO … — *TC 909, row 910*
42. [Xem chi tiết] Thông tin bên phát hành – Kiểm tra hiển thị → Hiển thị đúng tên trường <Thông tin bên phát hành> — *TC 910, row 911*
43. [Xem chi tiết] Tên Đơn vị phát hành LC – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 911, row 912*
44. [Xem chi tiết] Thông tin bên người hưởng – Kiểm tra hiển thị → Hiển thị đúng tên trường <Thông tin bên người hưởng> — *TC 912, row 913*
45. [Xem chi tiết] Tên người hưởng – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO: Tên + Địa chỉ + Tỉnh/Thành … — *TC 913, row 914*
46. [Xem chi tiết] Số tài khoản – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 914, row 915*
47. [Xem chi tiết] Giá trị LC – Kiểm tra hiển thị → Hiển thị đúng tên trường <Giá trị LC> — *TC 915, row 916*
48. [Xem chi tiết] Giá trị L/C – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO Hiển thị dạng Số tiền - Loại… — *TC 916, row 917*
49. [Xem chi tiết] Số tiền bằng chữ – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO Hiển thị số tiền bằng chữ tư… — *TC 917, row 918*
50. [Xem chi tiết] Dung sai (+) – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 918, row 919*
51. [Xem chi tiết] Dung sai (-) – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 919, row 920*
52. [Xem chi tiết] Thư tín dụng có giá trị tại – Kiểm tra hiển thị → 1. Hiển thị chính xác dữ liệu prefill từ FO 2. Nếu trường này ở FO ch… — *TC 920, row 921*
53. [Xem chi tiết] Thông tin ngân hàng khác – Kiểm tra hiển thị → 1. Hiển thị chính xác dữ liệu prefill từ FO 2. Nếu trưởng “Thư tín dụ… — *TC 921, row 922*
54. [Xem chi tiết] Thông tin “any bank in city” – Kiểm tra hiển thị → 1. Hiển thị chính xác dữ liệu prefill từ FO 2. Nếu trưởng “Thư tín dụ… — *TC 922, row 923*
55. [Xem chi tiết] Phương thức thanh toán của LC – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO: Payment/Acceptance/….. — *TC 923, row 924*
56. [Xem chi tiết] Chỉ thị về Thanh toán hỗn hợp (Mix payment details) – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO: Hiển thị thông tin… — *TC 924, row 925*
57. [Xem chi tiết] Chỉ thị về Thanh toán chiết khấu/trả chậm (Negotiation/ Deferred payment details) – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu pre… — *TC 925, row 926*
58. [Xem chi tiết] Yêu cầu xuất trình hối phiếu – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO: Có/Không — *TC 926, row 927*
59. [Xem chi tiết] Kỳ hạn thanh toán – Kiểm tra hiển thị → 1. Hiển thị chính xác dữ liệu prefill từ FO 2. Trường này nếu ở FO ch… — *TC 927, row 928*
60. [Xem chi tiết] Thông tin về người trả tiền trên Hối phiếu – Kiểm tra hiển thị → 1. Hiển thị chính xác dữ liệu prefill từ FO 2. Trường này nếu ở FO ch… — *TC 928, row 929*
61. [Xem chi tiết] Thông tin giao hàng – Kiểm tra hiển thị → Hiển thị đúng tên trường <Thông tin giao hàng> — *TC 929, row 930*
62. [Xem chi tiết] Nơi nhận hàng / Nơi gửi hàng / Nơi nhận hàng để vận chuyển – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 930, row 931*
63. [Xem chi tiết] Cảng xếp hàng / Sân bay khởi hành – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 931, row 932*
64. [Xem chi tiết] Cảng dỡ hàng / Sân bay đến – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 932, row 933*
65. [Xem chi tiết] Nơi đến cuối cùng / Nơi vận chuyển đến/ Nơi giao hàng – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 933, row 934*
66. [Xem chi tiết] Giao hàng từng phần – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 934, row 935*
67. [Xem chi tiết] Chuyển tải – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 935, row 936*
68. [Xem chi tiết] Ngày giao hàng muộn nhất – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 936, row 937*
69. [Xem chi tiết] Kỳ giao hàng – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 937, row 938*
70. [Xem chi tiết] Điều kiện giao hàng – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 938, row 939*
71. [Xem chi tiết] Điều kiện Incoterms – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 939, row 940*
72. [Xem chi tiết] Quy định vùng địa lý – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 940, row 941*
73. [Xem chi tiết] Mã phân loại hàng hóa – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 941, row 942*
74. [Xem chi tiết] Mô tả chứng từ – Kiểm tra hiển thị → 1. Cụm thông tin này hiển thị toàn bộ các nội dung mà FO đã tick chọn… — *TC 942, row 943*
75. [Xem chi tiết] Điều khoản hóa đơn thương mại – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 943, row 944*
76. [Xem chi tiết] Điều khoản vận đơn – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 944, row 945*
77. [Xem chi tiết] Điều khoản bản gốc số 3 của vận đơn hàng không – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 945, row 946*
78. [Xem chi tiết] Điều khoản giấy chứng nhận kiểm định/giám định do ai cấp – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 946, row 947*
79. [Xem chi tiết] Điều khoản giấy chứng nhận số lượng/chất lượng do ai cấp – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 947, row 948*
80. [Xem chi tiết] Điều khoản về chứng từ bảo hiểm hàng hóa – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 948, row 949*
81. [Xem chi tiết] Điều khoản về giấy chứng nhận xuất xứ – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 949, row 950*
82. [Xem chi tiết] Điều khoản về phiếu đóng gói hàng hóa – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 950, row 951*
83. [Xem chi tiết] Điều khoản chứng thư cam kết của người thụ hưởng – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 951, row 952*
84. [Xem chi tiết] Điều khoản bổ sung – Kiểm tra hiển thị → 1. Cụm thông tin này hiển thị toàn bộ các nội dung mà FO đã tick chọn… — *TC 952, row 953*
85. [Xem chi tiết] Điều khoản thanh toán LC tại đâu, bất kể kỳ hạn – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 953, row 954*
86. [Xem chi tiết] Các điều khoản: sanction clause, all docs issued in English, the amount utilized, due date falls on – Kiểm tra hiển thị → Hiển thị chí… — *TC 954, row 955*
87. [Xem chi tiết] Điều khoản khác – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 955, row 956*
88. [Xem chi tiết] Phí (Đối với loại L/C là LC thường - Regular) – Kiểm tra hiển thị → Hiển thị đúng tên trường <Phí> — *TC 956, row 957*
89. [Xem chi tiết] Phí – Kiểm tra hiển thị → 1. Hiển thị chính xác dữ liệu prefill từ FO 2. Ở trường này nếu FO ch… — *TC 957, row 958*
90. [Xem chi tiết] Ô nhập phí khác – Kiểm tra hiển thị → 1. Hiển thị chính xác dữ liệu prefill từ FO 2. Ở trường “Phí”, nếu FO… — *TC 958, row 959*
91. [Xem chi tiết] Phí (Đối với loại L/C là LC UPAS/UPAS PLUS) – Kiểm tra hiển thị → Hiển thị đúng tên trường <Phí> — *TC 959, row 960*
92. [Xem chi tiết] Các khoản phí và tiền lãi của ngân hàng phát hành L/C do – Kiểm tra hiển thị → Phí (Đối với loại L/C là LC UPAS/UPAS PLUS) — *TC 960, row 961*
93. [Xem chi tiết] Các khoản phí ngân hàng khác (bao gồm cả phí hoàn trả/thanh toán bồi hoàn, nếu có) do – Kiểm tra hiển thị → Phí (Đối với loại L/C là L… — *TC 961, row 962*
94. [Xem chi tiết] Trường hợp LC xác nhận / Có thể xác nhận (Chỉ hiển thị nếu FO chọn L/C Confirmed/May add ở trường Thông tin xác nhận L/C) – Kiểm tra h… — *TC 962, row 963*
95. [Xem chi tiết] Phí xác nhận do – Kiểm tra hiển thị → 1. Hiển thị chính xác dữ liệu prefill từ FO 2. Ở trường "Thông tin xá… — *TC 963, row 964*
96. [Xem chi tiết] Trường hợp LC chuyển nhượng (Chỉ hiển thị nếu FO chọn L/C Transferable ở trường Thông tin xác nhận L/C) – Kiểm tra hiển thị → Hiển thị… — *TC 964, row 965*
97. [Xem chi tiết] Phí chuyển nhượng do – Kiểm tra hiển thị → 1. Hiển thị chính xác dữ liệu prefill từ FO 2. Ở trường "Thông tin xá… — *TC 965, row 966*
98. [Xem chi tiết] Thời hạn xuất trình chứng từ – Kiểm tra hiển thị → Hiển thị đúng tên trường <Thời hạn xuất trình chứng từ> — *TC 966, row 967*
99. [Xem chi tiết] Thời hạn xuất trình chứng từ – Kiểm tra hiển thị → 1. Hiển thị chính xác dữ liệu prefill từ FO 2. Nếu trường này ở FO ng… — *TC 967, row 968*
100. [Xem chi tiết] Chỉ thị với ngân hàng thanh toán/chấp nhận/thương lượng sau khi nhận được – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ … — *TC 968, row 969*
101. [Xem chi tiết] Chỉ thị khác – Kiểm tra hiển thị → Hiển thị đúng tên trường <Chỉ thị khác> — *TC 969, row 970*
102. [Xem chi tiết] Chỉ thị khác – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 970, row 971*
103. [Xem chi tiết] Thông tin giao dịch – Kiểm tra hiển thị → Hiển thị đúng tên trường <Thông tin giao dịch> — *TC 971, row 972*
104. [Xem chi tiết] Số hợp đồng mua bán – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 972, row 973*
105. [Xem chi tiết] Ngày ký hợp đồng – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 973, row 974*
106. [Xem chi tiết] Đây là giao dịch kinh doanh hàng hóa tạm nhập tái xuất – Kiểm tra hiển thị → 1. Hiển thị chính xác dữ liệu prefill từ FO 2. Hiển thị t… — *TC 974, row 975*
107. [Xem chi tiết] Đây là giao dịch kinh doanh hàng hóa chuyển khẩu – Kiểm tra hiển thị → 1. Hiển thị chính xác dữ liệu prefill từ FO 2. Hiển thị tick xa… — *TC 975, row 976*
108. [Xem chi tiết] Khách hàng là Tổ chức kinh tế – Kiểm tra hiển thị → 1. Hiển thị chính xác dữ liệu prefill từ FO 2. Hiển thị Khách hàng là… — *TC 976, row 977*
109. [Xem chi tiết] Khách hàng cam kết cung cấp tờ khai hải quan và/hoặc hoàn tất nghĩa vụ thuế nhà thầu chậm nhất vào – Kiểm tra hiển thị → Hiển thị chín… — *TC 977, row 978*
110. [Xem chi tiết] Phương án sử dụng vốn – Kiểm tra hiển thị → Hiển thị đúng tên trường <Phương án sử dụng vốn> — *TC 978, row 979*
111. [Xem chi tiết] Cụm thông tin phương án sử dụng vốn – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO gồm Tỷ lệ, Số tài khoản, số … — *TC 979, row 980*
112. [Xem chi tiết] Tài khoản thu phí – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 980, row 981*
113. [Xem chi tiết] Phí giao dịch – Hiển thị khi loại LC là LC UPAS/UPAS PLUS – Kiểm tra hiển thị → Hiển thị đúng tên trường <Phí giao dịch> — *TC 981, row 982*
114. [Xem chi tiết] Phí chấp nhận thanh toán – Kiểm tra hiển thị → 1. Hiển thị chính xác dữ liệu prefill từ FO 2. Nếu trường này ở FO ch… — *TC 982, row 983*
115. [Xem chi tiết] Phí trả nợ trước hạn – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 983, row 984*
116. [Xem chi tiết] Phương thức trả nợ gốc và lãi – Kiểm tra hiển thị → Hiển thị đúng tên trường <Phương thức trả nợ gốc và lãi> — *TC 984, row 985*
117. [Xem chi tiết] Phương thức trả nợ gốc – Kiểm tra hiển thị → 1. Hiển thị chính xác dữ liệu prefill từ FO 2. Nếu trường này ở FO ch… — *TC 985, row 986*
118. [Xem chi tiết] Phương thức trả nợ lãi – Kiểm tra hiển thị → 1. Hiển thị chính xác dữ liệu prefill từ FO 2. Nếu trường này ở FO ch… — *TC 986, row 987*
119. [Xem chi tiết] Lãi suất áp dụng – Kiểm tra hiển thị → Hiển thị đúng tên trường <Lãi suất áp dụng> — *TC 987, row 988*
120. [Xem chi tiết] Lãi suất UPAS trong hạn – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 988, row 989*
121. [Xem chi tiết] Lãi suất áp dụng đối với dư nợ gốc quá hạn – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 989, row 990*
122. [Xem chi tiết] Lãi suất áp dụng đối với lãi chậm trả – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 990, row 991*
123. [Xem chi tiết] Cam kết và cam đoan của khách hàng – Kiểm tra hiển thị → Hiển thị đúng tên trường <Cam kết và cam đoan của khách hàng> — *TC 991, row 992*
124. [Xem chi tiết] Cam kết và cam đoan của khách hàng – Kiểm tra hiển thị → Hiển thị dấu tick chọn của người dùng FO đồng ý với điểu khoản điều k… — *TC 992, row 993*
125. [Xem chi tiết] Hồ sơ đính kèm – Kiểm tra khi user thực hiện phê duyệt → Hiển thị đúng tên trường <HỒ SƠ ĐÍNH KÈM> — *TC 993, row 994*
126. [Xem chi tiết] Tab Tất cả – Kiểm tra giá trị hiển thị → 1. Hiển thị số đếm file từ FO đẩy sang = tất cả các file 2. Hiển thị … — *TC 994, row 995*
127. [Xem chi tiết] Tab Hồ sơ có ký số – Kiểm tra giá trị hiển thị → 1. Hiển thị số đếm file từ FO đẩy sang = số file CÓ ký số - danh sách… — *TC 995, row 996*
128. [Xem chi tiết] Tab Hồ sơ không có ký số – Kiểm tra giá trị hiển thị → 1. Hiển thị số đếm file từ FO đẩy sang = số file KHÔNG có ký số - dan… — *TC 996, row 997*
129. [Xem chi tiết] STT – Kiểm tra hiển thị → Tự động tăng dần — *TC 997, row 998*
130. [Xem chi tiết] Tên tài liệu – Kiểm tra dữ liệu hiển thị → Hiển thị giá trị theo FO tương ứng — *TC 998, row 999*
131. [Xem chi tiết] Loại tài liệu – Kiểm tra dữ liệu hiển thị → Hiển thị chính xác giá trị Loại tài liệu tương ứng với hồ sơ FO đính … — *TC 999, row 1000*
132. [Xem chi tiết] Hình thức – Kiểm tra dữ liệu hiển thị → Hiển thị chính xác giá trị hình thức: - Hồ sơ có ký số - Hồ sơ không … — *TC 1000, row 1001*
133. [Xem chi tiết] Ngày – Kiểm tra dữ liệu hiển thị → Hiển thị chính xác ngày cấp phê duyệt cuối tại FO gửi giao dịch qua B… — *TC 1001, row 1002*
134. [Xem chi tiết] Kiểm tra ký số – Kiểm tra chức năng khi click nút → File có ký số: Call API CA để kiểm tra thông tin ký số → Thông tin ký… — *TC 1002, row 1003*
135. [Xem chi tiết] Xem – Kiểm tra chức năng khi click nút → Hiển thị màn hình cho phép người dùng preview file inline — *TC 1003, row 1004*
136. [Xem chi tiết] Tải xuống – Kiểm tra chức năng khi click nút → Cho phép người dùng tải file về máy — *TC 1004, row 1005*
137. [Xem chi tiết] Kết quả xử lý giao dịch – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị các trường thông tin: - Số tham chiếu LC - label (số tr… — *TC 1005, row 1006*
138. [Xem chi tiết] Số tham chiếu LC – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị dữ liệu master ref (TI) trả về lấy thông tin tại trường Mast… — *TC 1006, row 1007*
139. [Xem chi tiết] File Thông báo thu phí – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị file Thông báo thu phí — *TC 1007, row 1008*
140. [Xem chi tiết] File Điện phát hành LC – Kiểm tra thông tin tab Điện phát hành L/C → Điều kiện: Trong Q2: có event = , step = Authorise , status = com… — *TC 1008, row 1009*
141. [Xem chi tiết] Kiểm tra các Mã templatecode trả ra từ TI để hiển thị lên các mục Điện phát hành và Thông báo thu phsi → Chỉ lọc lấy các mã code trong… — *TC 1009, row 1010*
142. [Tiếp nhận] Tiếp nhận – Kiểm tra hiển thị button → Cán bộ CA thuộc chi nhánh phát hành trên thông tin Đề nghị phát hành … — *TC 1010, row 1011*
143. [Tiếp nhận] Tiếp nhận – Kiểm tra chức năng khi nhấn Button → 1. Nhận giao dịch về chân user CA đang tiếp nhận, Các cán bộ CA khác … — *TC 1011, row 1012*
144. [Tiếp nhận] Tiếp nhận – Kiểm tra chức năng khi nhiều user cùng thao tác Tiếp nhận → 1. User nào thực hiện tiếp nhận trước thì hiển thị MSG 12: "Tiếp … — *TC 1012, row 1013*
145. [Tiếp nhận] Tích hợp – Kiểm tra khi nhấn <Tiếp nhận> hệ thống kiểm tra CKS trên fie → Hệ thống gọi API tới hệ thống CA để kiểm tra thông tin CKS trên… — *TC 1013, row 1014*

#### B03 · CA – Tiếp nhận & Xử lý tác nghiệp (147)

1. [Xử lý tác nghiệp] Loại giao dịch – Kiểm tra hiển thị → Hiển thị giá trị cố định "Phát hành thư tín dụng" — *TC 1014, row 1015*
2. [Xử lý tác nghiệp] Tên khách hàng – Kiểm tra hiển thị → Hiển thị tên doanh nghiệp tạo đề nghị, gắn với CIF đăng ký — *TC 1015, row 1016*
3. [Xử lý tác nghiệp] CIF – Kiểm tra hiển thị → Hiển thị số CIF của doanh nghiệp tạo đề nghị — *TC 1016, row 1017*
4. [Xử lý tác nghiệp] Phân hạng khách hàng – Kiểm tra hiển thị → Hiển thị giá trị phân hạng của khách hàng — *TC 1017, row 1018*
5. [Xử lý tác nghiệp] Giấy đề nghị mở L/C, điều chỉnh L/C – Kiểm tra hiển thị → Hiển thị mã đề nghị do hệ thống tự sinh khi FO tạo giao dịch, cấu trú… — *TC 1018, row 1019*
6. [Xử lý tác nghiệp] Ngày – Kiểm tra hiển thị → Hiển thị ngày mà user FO duyệt cuối và gửi giao dịch sang BO — *TC 1019, row 1020*
7. [Xử lý tác nghiệp] Số tiền đề nghị tài trợ – Kiểm tra hiển thị → Hiển thị số tiền mà user FO đã nhập ở trường "Giá trị L/C" và "Loại t… — *TC 1020, row 1021*
8. [Xử lý tác nghiệp] Cảnh báo – Kiểm tra hiển thị → Hiển thị cảnh báo: Số tiền đề nghị tài trợ > hạn mức còn được sử dụng… — *TC 1021, row 1022*
9. [Xử lý tác nghiệp] Kiểm tra trường Thời hạn cấp tín dụng (từ) → 1. Cho phép chọn ngày ≤ Thời hạn cấp tín dụng (đến) — *TC 1022, row 1023*
10. [Xử lý tác nghiệp] Kiểm tra trường Thời hạn cấp tín dụng (từ) → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thông tin] — *TC 1023, row 1024*
11. [Xử lý tác nghiệp] Kiểm tra trường Thời hạn cấp tín dụng (đến) → 1. Cho phép chọn ngày ≤ Thời hạn cấp tín dụng (đến) — *TC 1024, row 1025*
12. [Xử lý tác nghiệp] Kiểm tra trường Thời hạn cấp tín dụng (đến) → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thông tin] — *TC 1025, row 1026*
13. [Xử lý tác nghiệp] Kiểm tra trường Mục đích phát hành L/C → Hiển thị placeholder “Nhập + [Trường thông tin]" — *TC 1026, row 1027*
14. [Xử lý tác nghiệp] Kiểm tra trường Mục đích phát hành L/C → Cho phép nhập số nguyên, số thập phân, giá trị text và các ký tự dặc … — *TC 1027, row 1028*
15. [Xử lý tác nghiệp] Kiểm tra trường Mục đích phát hành L/C → Không cho phép nhập/paste vượt quá 3000 ký tự Hệ thống tự động cắt nộ… — *TC 1028, row 1029*
16. [Xử lý tác nghiệp] Kiểm tra trường Mục đích phát hành L/C → Hệ thống tự động trimspace đầu cuối — *TC 1029, row 1030*
17. [Xử lý tác nghiệp] Kiểm tra trường Mục đích phát hành L/C → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thông tin] — *TC 1030, row 1031*
18. [Xử lý tác nghiệp] HĐTD theo hạn mức số – Kiểm tra hiển thị → 1. Hiển thị giá trị cố định số HĐTD 2. Dữ liệu lấy từ số HĐTD do FO c… — *TC 1031, row 1032*
19. [Xử lý tác nghiệp] Ngày – Kiểm tra hiển thị → 1. Hiển thị giá trị cố định ngày bắt đầu hiệu lực của số HĐTD 2. Dữ l… — *TC 1032, row 1033*
20. [Xử lý tác nghiệp] Kiểm tra trường Ký quỹ → 1. Giá trị mặc định phụ thuộc vào lựa chọn của FO ở trường "Nguồn tiề… — *TC 1033, row 1034*
21. [Xử lý tác nghiệp] Kiểm tra trường Tỷ lệ ký quỹ → 1. Giá trị mặc định phụ thuộc vào lựa chọn của FO ở trường "Nguồn tiề… — *TC 1034, row 1035*
22. [Xử lý tác nghiệp] Kiểm tra trường Tỷ lệ ký quỹ → Hiển thị placeholder “Nhập + [Trường thông tin]" — *TC 1035, row 1036*
23. [Xử lý tác nghiệp] Kiểm tra trường Tỷ lệ ký quỹ → Cho phép nhập số nguyên, số thập phân — *TC 1036, row 1037*
24. [Xử lý tác nghiệp] Kiểm tra trường Tỷ lệ ký quỹ → Không cho phép nhập/paste vượt quá 3 ký tự phần nguyên và 2 ký tự phầ… — *TC 1037, row 1038*
25. [Xử lý tác nghiệp] Kiểm tra trường Tỷ lệ ký quỹ → Hệ thống tự động trimspace đầu cuối — *TC 1038, row 1039*
26. [Xử lý tác nghiệp] Kiểm tra trường Tỷ lệ ký quỹ → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thông tin] — *TC 1039, row 1040*
27. [Xử lý tác nghiệp] Kiểm tra trường Tài khoản trích tiền ký quỹ → 1. Giá trị mặc định phụ thuộc vào lựa chọn của FO ở trường ""Nguồn ti… — *TC 1040, row 1041*
28. [Xử lý tác nghiệp] Kiểm tra trường Tài khoản trích tiền ký quỹ → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thông tin] — *TC 1041, row 1042*
29. [Xử lý tác nghiệp] Kiểm tra trường Nguồn thanh toán L/C khi đến hạn → 1. Giá trị mặc định phụ thuộc vào lựa chọn của FO ở trường "Nguồn tiề… — *TC 1042, row 1043*
30. [Xử lý tác nghiệp] Kiểm tra trường Nguồn thanh toán L/C khi đến hạn → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thông tin] — *TC 1043, row 1044*
31. [Xử lý tác nghiệp] Kiểm tra trường Số tài khoản → 1. Giá trị mặc định phụ thuộc vào lựa chọn của FO ở trường ""Nguồn ti… — *TC 1044, row 1045*
32. [Xử lý tác nghiệp] Kiểm tra trường Số tài khoản → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thông tin] — *TC 1045, row 1046*
33. [Xử lý tác nghiệp] Kiểm tra trường Số HĐTD → 1. Giá trị mặc định phụ thuộc vào lựa chọn của FO ở trường "Nguồn tiề… — *TC 1046, row 1047*
34. [Xử lý tác nghiệp] Kiểm tra trường Số HĐTD → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thông tin] — *TC 1047, row 1048*
35. [Xử lý tác nghiệp] Kiểm tra trường Nguồn thanh toán L/C khi đến hạn → 1. Hiển thị placeholder “Nhập thông tin” 2. Giá trị = rỗng Trường bắt… — *TC 1048, row 1049*
36. [Xử lý tác nghiệp] Kiểm tra trường Nguồn thanh toán L/C khi đến hạn → Cho phép nhập số nguyên, số thập phân, giá trị text và các ký tự dặc … — *TC 1049, row 1050*
37. [Xử lý tác nghiệp] Kiểm tra trường Nguồn thanh toán L/C khi đến hạn → Không cho phép nhập/paste vượt quá 3000 ký tự Hệ thống tự động cắt nộ… — *TC 1050, row 1051*
38. [Xử lý tác nghiệp] Kiểm tra trường Nguồn thanh toán L/C khi đến hạn → Hệ thống tự động trimspace đầu cuối — *TC 1051, row 1052*
39. [Xử lý tác nghiệp] Kiểm tra trường Nguồn thanh toán L/C khi đến hạn → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thông tin] — *TC 1052, row 1053*
40. [Xử lý tác nghiệp] Kiểm tra trường Tình hình khách hàng → Hiển thị các giá trị: 1. Bình thường, có khả năng thanh toán L/C, có … — *TC 1053, row 1054*
41. [Xử lý tác nghiệp] Kiểm tra trường Tình hình khách hàng → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thông tin] — *TC 1054, row 1055*
42. [Xử lý tác nghiệp] Kiểm tra trường Tình hình khách hàng → 1. Hiển thị placeholder “Nhập thông tin” 2. Giá trị = rỗng Trường bắt… — *TC 1055, row 1056*
43. [Xử lý tác nghiệp] Kiểm tra trường Tình hình khách hàng → Cho phép nhập số nguyên, số thập phân, giá trị text và các ký tự dặc … — *TC 1056, row 1057*
44. [Xử lý tác nghiệp] Kiểm tra trường Tình hình khách hàng → Không cho phép nhập/paste vượt quá 3000 ký tự Hệ thống tự động cắt nộ… — *TC 1057, row 1058*
45. [Xử lý tác nghiệp] Kiểm tra trường Tình hình khách hàng → Hệ thống tự động trimspace đầu cuối — *TC 1058, row 1059*
46. [Xử lý tác nghiệp] Kiểm tra trường Tình hình khách hàng → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thông tin] — *TC 1059, row 1060*
47. [Xử lý tác nghiệp] Kiểm tra trường Tình hình khách hàng → 1. Hiển thị placeholder “Nhập thông tin” 2. Giá trị = rỗng Trường bắt… — *TC 1060, row 1061*
48. [Xử lý tác nghiệp] Kiểm tra trường Tình hình khách hàng → Cho phép nhập số nguyên, số thập phân, giá trị text và các ký tự dặc … — *TC 1061, row 1062*
49. [Xử lý tác nghiệp] Kiểm tra trường Tình hình khách hàng → Không cho phép nhập/paste vượt quá 3000 ký tự Hệ thống tự động cắt nộ… — *TC 1062, row 1063*
50. [Xử lý tác nghiệp] Kiểm tra trường Tình hình khách hàng → Hệ thống tự động trimspace đầu cuối — *TC 1063, row 1064*
51. [Xử lý tác nghiệp] Kiểm tra trường Tình hình khách hàng → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thông tin] — *TC 1064, row 1065*
52. [Xử lý tác nghiệp] Kiểm tra trường Mục đích phát hành L/C → Hiển thị các giá trị: 1.Hợp pháp và phù hợp với mục đích phát hành L/… — *TC 1065, row 1066*
53. [Xử lý tác nghiệp] Kiểm tra trường Mục đích phát hành L/C → Hiển thị MSG "Vui lòng chọn" + [Trường thông tin] — *TC 1066, row 1067*
54. [Xử lý tác nghiệp] Kiểm tra trường Khả năng thực hiện điều kiện tín dụng bị vi phạm trong thời gian hiệu lực của GHTD → Hiển thị các giá trị: 1.Có 2.… — *TC 1067, row 1068*
55. [Xử lý tác nghiệp] Kiểm tra trường Khả năng thực hiện điều kiện tín dụng bị vi phạm trong thời gian hiệu lực của GHTD → Hiển thị MSG "Vui lòng chọn" … — *TC 1068, row 1069*
56. [Xử lý tác nghiệp] Bảng chỉ thị thu phí – Kiểm tra hiển thị → Mặc định hiển thị: Tên bảng: Chỉ thị thu phí Nút: Thêm loại phí — *TC 1069, row 1070*
57. [Xử lý tác nghiệp] Bảng chỉ thị thu phí – Kiểm tra validate khi bỏ trống trường bắt buộc → Hiển thị MSG "Vui lòng liệt kê các loại phí" — *TC 1070, row 1071*
58. [Xử lý tác nghiệp] Thêm loại phí – Kiểm tra chức năng → 1. Cho phép người dùng thêm 1 dòng thông tin 2. Thêm 1 dòng thành côn… — *TC 1071, row 1072*
59. [Xử lý tác nghiệp] Xóa – Kiểm tra chức năng → 1. Cho phép người dùng xóa 1 dòng thông tin 2. Xóa 1 dòng thành công … — *TC 1072, row 1073*
60. [Xử lý tác nghiệp] STT – Kiểm tra hiển thị → STT tự động tăng giảm tuần tự khi thêm/xóa dòng phí STT không bị nhảy… — *TC 1073, row 1074*
61. [Xử lý tác nghiệp] Kiểm tra trường Loại phí → 1. Hiển thị placeholder “Nhập thông tin” 2. Giá trị = rỗng — *TC 1074, row 1075*
62. [Xử lý tác nghiệp] Kiểm tra trường Loại phí → Cho phép nhập số nguyên, số thập phân, giá trị text và các ký tự dặc … — *TC 1075, row 1076*
63. [Xử lý tác nghiệp] Kiểm tra trường Loại phí → Không cho phép nhập/paste vượt quá 255 ký tự Hệ thống tự động cắt nội… — *TC 1076, row 1077*
64. [Xử lý tác nghiệp] Kiểm tra trường Loại phí → Hệ thống tự động trimspace đầu cuối — *TC 1077, row 1078*
65. [Xử lý tác nghiệp] Kiểm tra trường Loại phí → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thông tin] — *TC 1078, row 1079*
66. [Xử lý tác nghiệp] Kiểm tra trường Phần giá trị tính phí → 1. Hiển thị placeholder “Nhập thông tin” 2. Giá trị = rỗng — *TC 1079, row 1080*
67. [Xử lý tác nghiệp] Kiểm tra trường Phần giá trị tính phí → Cho phép nhập số nguyên, số thập phân — *TC 1080, row 1081*
68. [Xử lý tác nghiệp] Kiểm tra trường Phần giá trị tính phí → Không cho phép nhập/paste vượt quá 18 ký tự phần nguyên và 2 ký tự ph… — *TC 1081, row 1082*
69. [Xử lý tác nghiệp] Kiểm tra trường Phần giá trị tính phí → Hệ thống tự động trimspace đầu cuối — *TC 1082, row 1083*
70. [Xử lý tác nghiệp] Kiểm tra trường Phần giá trị tính phí → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thông tin] — *TC 1083, row 1084*
71. [Xử lý tác nghiệp] Kiểm tra trường Mức phí áp dụng (tỷ lệ %) → 1. Hiển thị placeholder “Nhập thông tin” 2. Giá trị = rỗng — *TC 1084, row 1085*
72. [Xử lý tác nghiệp] Kiểm tra trường Mức phí áp dụng (tỷ lệ %) → Cho phép nhập số nguyên, số thập phân — *TC 1085, row 1086*
73. [Xử lý tác nghiệp] Kiểm tra trường Mức phí áp dụng (tỷ lệ %) → Không cho phép nhập/paste vượt quá 3 ký tự phần nguyên và 2 ký tự phầ… — *TC 1086, row 1087*
74. [Xử lý tác nghiệp] Kiểm tra trường Mức phí áp dụng (tỷ lệ %) → Hệ thống tự động trimspace đầu cuối — *TC 1087, row 1088*
75. [Xử lý tác nghiệp] Kiểm tra trường Mức phí áp dụng (tỷ lệ %) → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thông tin] — *TC 1088, row 1089*
76. [Xử lý tác nghiệp] Kiểm tra trường Số phí tối thiểu → 1. Hiển thị placeholder “Nhập thông tin” 2. Giá trị = rỗng — *TC 1089, row 1090*
77. [Xử lý tác nghiệp] Kiểm tra trường Số phí tối thiểu → Cho phép nhập số nguyên, số thập phân — *TC 1090, row 1091*
78. [Xử lý tác nghiệp] Kiểm tra trường Số phí tối thiểu → Không cho phép nhập/paste vượt quá 18 ký tự phần nguyên và 2 ký tự ph… — *TC 1091, row 1092*
79. [Xử lý tác nghiệp] Kiểm tra trường Số phí tối thiểu → Hệ thống tự động trimspace đầu cuối — *TC 1092, row 1093*
80. [Xử lý tác nghiệp] Kiểm tra trường Số phí tối thiểu → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thông tin] — *TC 1093, row 1094*
81. [Xử lý tác nghiệp] Kiểm tra trường Số phí tối đa → 1. Hiển thị placeholder “Nhập thông tin” 2. Giá trị = rỗng — *TC 1094, row 1095*
82. [Xử lý tác nghiệp] Kiểm tra trường Số phí tối đa → Cho phép nhập số nguyên, số thập phân — *TC 1095, row 1096*
83. [Xử lý tác nghiệp] Kiểm tra trường Số phí tối đa → Không cho phép nhập/paste vượt quá 18 ký tự phần nguyên và 2 ký tự ph… — *TC 1096, row 1097*
84. [Xử lý tác nghiệp] Kiểm tra trường Số phí tối đa → Hệ thống tự động trimspace đầu cuối — *TC 1097, row 1098*
85. [Xử lý tác nghiệp] Kiểm tra trường Số phí tối đa → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thông tin] — *TC 1098, row 1099*
86. [Xử lý tác nghiệp] Kiểm tra trường Số tiền thu phí → 1. Hiển thị placeholder “Nhập thông tin” 2. Giá trị = rỗng — *TC 1099, row 1100*
87. [Xử lý tác nghiệp] Kiểm tra trường Số tiền thu phí → Cho phép nhập số nguyên, số thập phân — *TC 1100, row 1101*
88. [Xử lý tác nghiệp] Kiểm tra trường Số tiền thu phí → Không cho phép nhập/paste vượt quá 18 ký tự phần nguyên và 2 ký tự ph… — *TC 1101, row 1102*
89. [Xử lý tác nghiệp] Kiểm tra trường Số tiền thu phí → Hệ thống tự động trimspace đầu cuối — *TC 1102, row 1103*
90. [Xử lý tác nghiệp] Kiểm tra trường Số tiền thu phí → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thông tin] — *TC 1103, row 1104*
91. [Xử lý tác nghiệp] Kiểm tra trường Loại tiền → 1. Hiển thị danh sách các tài khoản tiền gửi của KH có trạng thái act… — *TC 1104, row 1105*
92. [Xử lý tác nghiệp] Kiểm tra trường Loại tiền → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thông tin] — *TC 1105, row 1106*
93. [Xử lý tác nghiệp] Kiểm tra trường Thời điểm thu phí → 1. Hiển thị placeholder “Nhập thông tin” 2. Giá trị = rỗng — *TC 1106, row 1107*
94. [Xử lý tác nghiệp] Kiểm tra trường Thời điểm thu phí → Cho phép nhập số nguyên, số thập phân, giá trị text và các ký tự dặc … — *TC 1107, row 1108*
95. [Xử lý tác nghiệp] Kiểm tra trường Thời điểm thu phí → Không cho phép nhập/paste vượt quá 500 ký tự Hệ thống tự động cắt nội… — *TC 1108, row 1109*
96. [Xử lý tác nghiệp] Kiểm tra trường Thời điểm thu phí → Hệ thống tự động trimspace đầu cuối — *TC 1109, row 1110*
97. [Xử lý tác nghiệp] Kiểm tra trường Thời điểm thu phí → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thông tin] — *TC 1110, row 1111*
98. [Xử lý tác nghiệp] Kiểm tra trường Ghi chú → 1. Hiển thị placeholder “Nhập thông tin” 2. Giá trị = rỗng — *TC 1111, row 1112*
99. [Xử lý tác nghiệp] Kiểm tra trường Ghi chú → Cho phép nhập số nguyên, số thập phân, giá trị text và các ký tự dặc … — *TC 1112, row 1113*
100. [Xử lý tác nghiệp] Kiểm tra trường Ghi chú → Không cho phép nhập/paste vượt quá 255 ký tự Hệ thống tự động cắt nội… — *TC 1113, row 1114*
101. [Xử lý tác nghiệp] Kiểm tra trường Ghi chú → Hệ thống tự động trimspace đầu cuối — *TC 1114, row 1115*
102. [Xử lý tác nghiệp] Kiểm tra trường Tài khoản thu phí → 1. Hiển thị danh sách các tài khoản tiền gửi của KH có trạng thái act… — *TC 1115, row 1116*
103. [Xử lý tác nghiệp] Kiểm tra trường Tài khoản thu phí → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thông tin] — *TC 1116, row 1117*
104. [Xử lý tác nghiệp] Số dư khả dụng – Kiểm tra hiển thị → Hiển thị đúng số dư khả dụng còn lại của tài khoản mà CA đã chọn Hiển… — *TC 1117, row 1118*
105. [Xử lý tác nghiệp] Kiểm tra trường Đề xuất của cán bộ thẩm định → Cho phép chọn 1 trong các giá trị: 1. Điều kiện khách hàng đã được đá… — *TC 1118, row 1119*
106. [Xử lý tác nghiệp] Kiểm tra trường Đề xuất của cán bộ thẩm định → Hiển thị MSG "Vui lòng chọn" + [Trường thông tin] — *TC 1119, row 1120*
107. [Xử lý tác nghiệp] Kiểm tra trường Đề xuất của cán bộ thẩm định → 1. Hiển thị placeholder “Nhập thông tin” 2. Giá trị = rỗng Trường bắt… — *TC 1120, row 1121*
108. [Xử lý tác nghiệp] Kiểm tra trường Đề xuất của cán bộ thẩm định → Cho phép nhập số nguyên, số thập phân, giá trị text và các ký tự dặc … — *TC 1121, row 1122*
109. [Xử lý tác nghiệp] Kiểm tra trường Đề xuất của cán bộ thẩm định → Không cho phép nhập/paste vượt quá 3000 ký tự Hệ thống tự động cắt nộ… — *TC 1122, row 1123*
110. [Xử lý tác nghiệp] Kiểm tra trường Đề xuất của cán bộ thẩm định → Hệ thống tự động trimspace đầu cuối — *TC 1123, row 1124*
111. [Xử lý tác nghiệp] Kiểm tra trường Đề xuất của cán bộ thẩm định → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thông tin] — *TC 1124, row 1125*
112. [Xử lý tác nghiệp] Bảng Hồ sơ đính kèm – Kiểm tra hiển thị → Mặc định hiển thị: Tên bảng: Hồ sơ đính kèm Nút: Thêm hồ sơ Có sẵn 3 … — *TC 1125, row 1126*
113. [Xử lý tác nghiệp] Thêm hồ sơ – Kiểm tra chức năng → 1. Cho phép người dùng thêm 1 dòng thông tin 2. Thêm 1 dòng thành côn… — *TC 1126, row 1127*
114. [Xử lý tác nghiệp] Xóa – Kiểm tra chức năng → 1. Cho phép người dùng xóa 1 dòng thông tin 2. Xóa 1 dòng thành công … — *TC 1127, row 1128*
115. [Xử lý tác nghiệp] STT – Kiểm tra hiển thị → STT tự động tăng giảm tuần tự khi thêm/xóa dòng phí STT không bị nhảy… — *TC 1128, row 1129*
116. [Xử lý tác nghiệp] Tên tài liệu – Kiểm tra hiển thị → Tên file tài liệu tự động hiển thị theo file đã tải lên Không cho sửa… — *TC 1129, row 1130*
117. [Xử lý tác nghiệp] Kiểm tra trường Loại tài liệu → 1. Hiển thị placeholder “Nhập thông tin” 2. Giá trị = rỗng Trường bắt… — *TC 1130, row 1131*
118. [Xử lý tác nghiệp] Kiểm tra trường Loại tài liệu → Cho phép nhập số nguyên, số thập phân, giá trị text và các ký tự dặc … — *TC 1131, row 1132*
119. [Xử lý tác nghiệp] Kiểm tra trường Loại tài liệu → Không cho phép nhập/paste vượt quá 255 ký tự Hệ thống tự động cắt nội… — *TC 1132, row 1133*
120. [Xử lý tác nghiệp] Kiểm tra trường Loại tài liệu → Hệ thống tự động trimspace đầu cuối — *TC 1133, row 1134*
121. [Xử lý tác nghiệp] Kiểm tra trường Loại tài liệu → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thông tin] — *TC 1134, row 1135*
122. [Xử lý tác nghiệp] Kiểm tra trường Hình thức → Cho phép chọn 1 trong các giá trị: 1.Hồ sơ ký số 2. Hồ sơ không ký số — *TC 1135, row 1136*
123. [Xử lý tác nghiệp] Kiểm tra trường Hình thức → Hiển thị MSG "Vui lòng chọn" + [Trường thông tin] — *TC 1136, row 1137*
124. [Xử lý tác nghiệp] Tải lên – Kiểm tra các trường hợp tải file đính kèm → 1. Cho phép người dùng tải hồ sơ từ máy cá nhân, có thể chọn từ thư m… — *TC 1137, row 1138*
125. [Xử lý tác nghiệp] Tải lên – Kiểm tra chức năng → Upload file thành công File hiển thị trong danh sách đính kèm — *TC 1138, row 1139*
126. [Xử lý tác nghiệp] Tải lên – Kiểm tra các trường hợp tải file đính kèm → 1. Cho phép người dùng tải hồ sơ từ máy cá nhân, có thể chọn từ thư m… — *TC 1139, row 1140*
127. [Xử lý tác nghiệp] Tải lên – Kiểm tra các trường hợp tải file đính kèm → 1. Cho phép người dùng tải hồ sơ từ máy cá nhân, có thể chọn từ thư m… — *TC 1140, row 1141*
128. [Xử lý tác nghiệp] Tải lên – Kiểm tra các trường hợp tải file đính kèm → 1. Cho phép người dùng tải hồ sơ từ máy cá nhân, có thể chọn từ thư m… — *TC 1141, row 1142*
129. [Xử lý tác nghiệp] Tải lên – Kiểm tra các trường hợp tải file đính kèm → 1. Cho phép người dùng tải hồ sơ từ máy cá nhân, có thể chọn từ thư m… — *TC 1142, row 1143*
130. [Xử lý tác nghiệp] Tải lên – Kiểm tra các trường hợp tải file đính kèm → 1. Cho phép người dùng tải hồ sơ từ máy cá nhân, có thể chọn từ thư m… — *TC 1143, row 1144*
131. [Xử lý tác nghiệp] Tải lên – Kiểm tra validate định dạng file không hợp lệ → Nếu sai định dạng hệ thống hiển thị MSG: “Định dạng file không hợp lệ… — *TC 1144, row 1145*
132. [Xử lý tác nghiệp] Tải lên – Kiểm tra validate tên file chứa ký tự đặc biệt → Hiển thị MSG "Upload file thất bại _ Tên file không hợp lệ _ Ký tự đặ… — *TC 1145, row 1146*
133. [Xử lý tác nghiệp] Tải lên – Kiểm tra validate dung lượng tải lên → Upload file thành công File hiển thị trong danh sách đính kèm — *TC 1146, row 1147*
134. [Xử lý tác nghiệp] Tải lên – Kiểm tra validate dung lượng tải lên → Hiển thị MSG "Upload file thật bại_File đẩy lên không được quá 100MB" — *TC 1147, row 1148*
135. [Xử lý tác nghiệp] Tải lên – Kiểm tra validate dung lượng tải lên → Hiển thị MSG "Upload file thật bại_File đẩy lên không được quá 100MB" — *TC 1148, row 1149*
136. [Xử lý tác nghiệp] Tải lên – Kiểm tra validate dung lượng tải lên → Hiển thị MSG "Upload file thật bại_Tổng dung lượng file tải lên không… — *TC 1149, row 1150*
137. [Xử lý tác nghiệp] Tải lên – Kiểm tra validate dung lượng tải lên → Upload thất bại_File không hợp lệ — *TC 1150, row 1151*
138. [Xử lý tác nghiệp] Tải lên – Kiểm tra chức năng → Upload file thành công File hiển thị trong danh sách đính kèm — *TC 1151, row 1152*
139. [Xử lý tác nghiệp] Tải lên – Kiểm tra nội dung hiển thi → Hiển thị đúng nội dung gốc file tải lên — *TC 1152, row 1153*
140. [Xử lý tác nghiệp] Xóa file đã upload. – Kiểm tra chức năng → Cho phép xóa bản ghi đính kèm — *TC 1153, row 1154*
141. [Xử lý tác nghiệp] Tải lên – Kiểm tra chức năng → Upload thành công — *TC 1154, row 1155*
142. [Xử lý - Gửi duyệt] Lưu – Kiểm tra hoạt động → 1. Hệ thống lưu thông tin nhập liệu người dùng đã khai báo 2. không y… — *TC 1155, row 1156*
143. [Xử lý - Gửi duyệt] Gửi duyệt – Kiểm tra khi user thực hiện Gửi duyệt → 1. Validate đầy đủ trường bắt buộc → lỗi thì highlight field đỏ + MSG… — *TC 1156, row 1157*
144. [Xử lý - Gửi duyệt] Đóng – Kiểm tra hoạt động → 1. Nếu đã nhập phần B: Đánh giá của ngân hàng , hiển thị popup xác nh… — *TC 1157, row 1158*
145. [Xử lý - Gửi duyệt] Tích hợp – Kiểm tra nhấn nút Gửi duyệt → Hệ thống call API EMAIL service gửi thông báo EMAIL 03 tới người dùng… — *TC 1158, row 1159*
146. [Xử lý - Gửi duyệt] Tích hợp – Kiểm tra đẩy thông tin file lên ECM tại folder Temp → Hệ thống call API tới ECM để đẩy danh sách file của người dùng l… — *TC 1159, row 1160*
147. [Xử lý - Gửi duyệt] Popup lưu nháp – Kiểm tra hoạt động → Hiển thị popup Xác nhận đóng màn hình user input thông tin: ""Có nội … — *TC 1160, row 1161*

#### B04 · CA – Gửi duyệt / Trả lại khách hàng / Từ chối (9)

1. [Xử lý - Trả lại] Nội dung (chọn nguồn thanh toán là: Khác) – Kiểm tra user thực hiện → Cán bộ CA đã thực hiện tiếp nhận giao dịch hoặc cán bộ được p… — *TC 1161, row 1162*
2. [Xử lý - Trả lại] Tình hình khách hàng – Kiểm tra khi nhấn nút → - Hệ thống mở pop-up nội dung Trả lại - Nhập nội dung Lý do trả lại m… — *TC 1162, row 1163*
3. [Xử lý - Trả lại] Popup thông báo Trả lại thành công – Kiểm tra hiển thị → - Hệ thống show MSG "Đã trả lại thành công Bạn có thể xem trạng thái … — *TC 1163, row 1164*
4. [Xử lý - Trả lại] Tích hợp – Kiểm tra Thông báo + Nội dung email → - Gọi API tới hệ thống Email Service để gửi email tới người dùng Make… — *TC 1164, row 1165*
5. [Xử lý - Trả lại] Popup thông báo Trả lại thất bại – Kiểm tra hiển thị → - Hiển thị MSG "Trả lại giao dịch thất bại" - Đóng popup hiện tại — *TC 1165, row 1166*
6. [Xử lý - Từ chối] STT (Bảng chỉ thị thu phí) – Kiểm tra user thực hiện → Cán bộ CA đã thực hiện tiếp nhận giao dịch hoặc cán bộ CA được phân c… — *TC 1166, row 1167*
7. [Xử lý - Từ chối] Loại phí (Bảng chỉ thị thu phí) – Kiểm tra khi nhấn nút → - Hệ thống mở popup nhập nội dung Từ chối - Nhập nội dung phê duyệt m… — *TC 1167, row 1168*
8. [Xử lý - Từ chối] Số tiền tính phí (Bảng chỉ thị thu phí) – Từ chối giao dịch thành công → 1. Hệ thống show MSG:Đã từ chối thành công - Bạn có thể xe… — *TC 1168, row 1169*
9. [Xử lý - Từ chối] Tích hợp – Kiểm tra Thông báo + Nội dung email → Gọi API tới hệ thống Email Service để gửi email tới người dùng Maker … — *TC 1169, row 1170*

#### B05 · CA – Xem TBTN, tải hồ sơ khách hàng (48)

1. [CA_Xem TBTN] Xem file tác nghiệp – Kiểm tra nhấn nút → Hiển thị 2 file: (1) File TBTN (.pdf) (2) File YCXL giao dịch (.doc) — *TC 1170, row 1171*
2. [CA_Xem TBTN] File TBTN (.pdf) – Kiểm tra nhấn nút → 1. Hệ thống mở màn hình xem chi tiết file theo định dạng đã chọn với … — *TC 1171, row 1172*
3. [CA_Xem TBTN] File YCXL giao dịch (.doc) – Kiểm tra nhấn nút → - Hệ thống mở màn hình view file và cho phép tải xuống và có tên fiel… — *TC 1172, row 1173*
4. [CA_Xem TBTN] Tên CBTĐ – Kiểm tra thông tin gen file → Hiển thị thông tin user CA đang login: [Full_name]. BO_User db Accces… — *TC 1173, row 1174*
5. [CA_Xem TBTN] Mã cán bộ – Kiểm tra thông tin gen file → Hiển thị thông tin user CA đang login: [User_code]. BO_User db Access… — *TC 1174, row 1175*
6. [CA_Xem TBTN] Chi nhánh VCB – Kiểm tra thông tin gen file → Hiển thị thông tin user CA đang login: [BRANCH_NAME_VN]. CMN_BRANCH D… — *TC 1175, row 1176*
7. [CA_Xem TBTN] Mã Chi nhánh – Kiểm tra thông tin gen file → Hiển thị thông tin user CA đang login: [Branch_Code]. BO_User db Acce… — *TC 1176, row 1177*
8. [CA_Xem TBTN] Ngày lập – Kiểm tra thông tin gen file → Ghi nhận thời gian khi user nhấn Lưu/Gửi duyệt Format: DD/MM/YYYY — *TC 1177, row 1178*
9. [CA_Xem TBTN] Giờ – Kiểm tra thông tin gen file → Ghi nhận thời gian khi user nhấn Lưu/Gửi duyệt Format: HH:MM — *TC 1178, row 1179*
10. [CA_Xem TBTN] Loại giao dịch – Kiểm tra thông tin gen file → Mặc định = Đề nghị phát hành LC — *TC 1179, row 1180*
11. [CA_Xem TBTN] Tên Khách hàng – Kiểm tra thông tin gen file → Hiển thị đúngtrường Tên khách hàng từ FO gửi sang — *TC 1180, row 1181*
12. [CA_Xem TBTN] CIF – Kiểm tra thông tin gen file → Hiển thị CIFno của Khách hàng — *TC 1181, row 1182*
13. [CA_Xem TBTN] Phân hạng Khách hàng – Kiểm tra thông tin gen file → Hiển thị theo trường: [GUARANTEE_CIF_CLASSIFICATION]. EG_GUARANTEE_IS… — *TC 1182, row 1183*
14. [CA_Xem TBTN] Giấy đề nghị mở L/C, điều chỉnh L/C – Kiểm tra thông tin gen file → Hiển thị mã giao dịch trên FO gửi sang — *TC 1183, row 1184*
15. [CA_Xem TBTN] Ngày – Kiểm tra thông tin gen file → Hiển thị ngày giao dịch được đẩy sang BO — *TC 1184, row 1185*
16. [CA_Xem TBTN] Số tiền đề nghị tài trợ – Kiểm tra thông tin gen file → Hiển thị đúng dữ liệu được nối chuỗi của các giá trị gồm: + Giá trị L… — *TC 1185, row 1186*
17. [CA_Xem TBTN] Thời hạn cấp tín dụng của L/C – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CA Chọn hoặc/và Nhập — *TC 1186, row 1187*
18. [CA_Xem TBTN] Mục đích phát hành L/C – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CA Chọn hoặc/và Nhập — *TC 1187, row 1188*
19. [CA_Xem TBTN] HĐTD theo hạn mức số – Kiểm tra thông tin gen file → Hiển thị đúng số HĐTD lấy từ đề nghị do FO gửi sang — *TC 1188, row 1189*
20. [CA_Xem TBTN] Ngày – Kiểm tra thông tin gen file → Hiển thị đúng ngày bắt đầu hiệu lực gắn với số HĐTD lấy từ đề nghị do… — *TC 1189, row 1190*
21. [CA_Xem TBTN] Ký quỹ – Kiểm tra thông tin gen file → Hiển thị tick ở checkbox ở ô "Có ký quỹ" nếu CA có chọn hoặc/và Nhập — *TC 1190, row 1191*
22. [CA_Xem TBTN] Tỷ lệ ký quỹ – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CA Chọn hoặc/và Nhập — *TC 1191, row 1192*
23. [CA_Xem TBTN] Tài khoản trích tiền ký quỹ – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CA Chọn hoặc/và Nhập — *TC 1192, row 1193*
24. [CA_Xem TBTN] Nguồn thanh toán L/C khi đến hạn – Kiểm tra thông tin gen file → Hiển thị tick ở checkbox ở đúng ô tương ứng giá trị CA có chọn hoặc/v… — *TC 1193, row 1194*
25. [CA_Xem TBTN] Tài khoản (chọn nguồn thanh toán là: Tiền gửi tại VCB) – Kiểm tra thông tin gen file → Hiển thị đúng số tài khoản cán bộ CA Chọn hoặc/v… — *TC 1194, row 1195*
26. [CA_Xem TBTN] Tài khoản (chọn nguồn thanh toán là: vay VCB) – Kiểm tra thông tin gen file → Hiển thị đúng số tài khoản cán bộ CA Chọn hoặc/và Nhập tư… — *TC 1195, row 1196*
27. [CA_Xem TBTN] Nội dung (chọn nguồn thanh toán là: Khác) – Kiểm tra thông tin gen file → Hiển thị đúng số tài khoản cán bộ CA Chọn hoặc/và Nhập tương … — *TC 1196, row 1197*
28. [CA_Xem TBTN] Tình hình khách hàng – Kiểm tra thông tin gen file → Hiển thị tick ở checkbox ở đúng ô tương ứng giá trị CA có chọn hoặc/v… — *TC 1197, row 1198*
29. [CA_Xem TBTN] Nội dung (Chọn tình hình khách hàng = 3) – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CA Chọn hoặc/và Nhập, hiển thị p… — *TC 1198, row 1199*
30. [CA_Xem TBTN] Mục đích phát hành L/C – Kiểm tra thông tin gen file → Hiển thị tick ở checkbox ở đúng ô tương ứng giá trị CA có chọn hoặc/v… — *TC 1199, row 1200*
31. [CA_Xem TBTN] Khả năng thực hiện điều kiện tín dụng – Kiểm tra thông tin gen file → Hiển thị tick ở checkbox ở đúng ô tương ứng giá trị CA có chọn ho… — *TC 1200, row 1201*
32. [CA_Xem TBTN] STT (Bảng chỉ thị thu phí) – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CA Chọn hoặc/và Nhập — *TC 1201, row 1202*
33. [CA_Xem TBTN] Loại phí (Bảng chỉ thị thu phí) – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CA Chọn hoặc/và Nhập — *TC 1202, row 1203*
34. [CA_Xem TBTN] Số tiền tính phí (Bảng chỉ thị thu phí) – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CA Chọn hoặc/và Nhập — *TC 1203, row 1204*
35. [CA_Xem TBTN] Loại tiền (Bảng chỉ thị thu phí) – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CA Chọn hoặc/và Nhập — *TC 1204, row 1205*
36. [CA_Xem TBTN] Mức phí áp dụng (Bảng chỉ thị thu phí) – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CA Chọn hoặc/và Nhập — *TC 1205, row 1206*
37. [CA_Xem TBTN] Số phí tối thiểu (Bảng chỉ thị thu phí) – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CA Chọn hoặc/và Nhập — *TC 1206, row 1207*
38. [CA_Xem TBTN] Số phí tối đa (Bảng chỉ thị thu phí) – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CA Chọn hoặc/và Nhập — *TC 1207, row 1208*
39. [CA_Xem TBTN] Thời điểm thu phí (Bảng chỉ thị thu phí) – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CA Chọn hoặc/và Nhập — *TC 1208, row 1209*
40. [CA_Xem TBTN] Ghi chú (Bảng chỉ thị thu phí) – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CA Chọn hoặc/và Nhập — *TC 1209, row 1210*
41. [CA_Xem TBTN] Tài khoản trích tiền thu phí – Kiểm tra thông tin gen file → Hiển thị đúng số tài khoản cán bộ CA Chọn hoặc/và Nhập — *TC 1210, row 1211*
42. [CA_Xem TBTN] Số dư khả dụng – Kiểm tra thông tin gen file → Hiển thị đúng số dư gắn với tài khoản cán bộ CA Chọn hoặc/và Nhập Hiể… — *TC 1211, row 1212*
43. [CA_Xem TBTN] Loại tài liệu (bảng hồ sơ đình kèm) – Kiểm tra thông tin gen file → Hiển thị đúng loại tài liệu Khách hàng gửi sang — *TC 1212, row 1213*
44. [CA_Xem TBTN] Tên tài liệu (bảng hồ sơ đình kèm) – Kiểm tra thông tin gen file → Hiển thị đúng tên tài liệu từ FO gửi sang — *TC 1213, row 1214*
45. [CA_Xem TBTN] Hình thức (bảng hồ sơ đình kèm) – Kiểm tra thông tin gen file → Hiển thị đúng hình thức: Hồ sơ có ký số hoặc Hồ sơ không có ký số trê… — *TC 1214, row 1215*
46. [CA_Xem TBTN] Kết luận – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CA Chọn hoặc/và Nhập để từ đó hệ thống … — *TC 1215, row 1216*
47. [CA_Xem TBTN] CBTĐ – Kiểm tra thông tin gen file → Hiển thị đúng họ và tên cán bộ CA thực hiện gửi duyệt và ghi nhận thờ… — *TC 1216, row 1217*
48. [Tải hồ sơ KH] Tải hồ sơ khách hàng – Kiểm tra khi nhấn nút → - Hệ thống cho phép tải xuống các tài liệu khách hàng - Tên file: HSK… — *TC 1217, row 1218*

#### B06 · CA lead – Phê duyệt, Phê duyệt ĐXTC, Trả lại, Phân công lại, Xem TBTN (24)

1. [Danh sách (Mới bổ sung)] Lưới chức năng – Kiểm tra hiển thị danh sách theo phân quyền user → Chỉ thấy các giao dịch phát hành LC thuộc phạm vi phân … — *TC 1218, row 1219*
2. [Danh sách (Mới bổ sung)] Lưới chức năng – Kiểm tra counter tab Tất cả/Cần xử lý/Đang theo dõi/Đã hoàn thành → 1. Số lượng Counter = số bản ghi của t… — *TC 1219, row 1220*
3. [Phê duyệt] Kiểm tra user thực hiện → User thuộc SA có quyền phê duyệt Mặc định hiển thị toàn bộ GD "Đề ngh… — *TC 1220, row 1221*
4. [Phê duyệt] 5. Thời hạn duy trì hạn mức – Kiểm tra khi user thực hiện phê duyệt → 1. Hệ thống thực hiện phê duyệt giao dịch thành công, hiển thị thôn… — *TC 1221, row 1222*
5. [Phê duyệt ĐXTC] Gửi duyệt – Kiểm tra hiển thị nút → Hiển thị 2 lựa chọn: (1) Duyệt đề xuất (2) Gửi duyệt BGĐ — *TC 1222, row 1223*
6. [Phê duyệt ĐXTC] Duyệt đề xuất – Kiểm tra xác thực thành công khi chọn duyệt đề xuất → 1. Hệ thống thực hiện phê duyệt giao dịch thành công: "Đã duyệ… — *TC 1223, row 1224*
7. [Phê duyệt ĐXTC] Gửi duyệt BGĐ – Kiểm tra xác thực thành công khi chọn gửi duyệt BGĐ → 1. Hệ thống thực hiện phê duyệt giao dịch thành công: "Đã duyệ… — *TC 1224, row 1225*
8. [Trả lại] Kiểm tra trường Ô nhập thông tin – Kiểm tra user thực hiện → Lãnh đạo thẩm định có quyền thao tác — *TC 1225, row 1226*
9. [Trả lại] Trả lại – Kiểm tra khi nhấn nút → - Hệ thống mở opup Nhập nội dung Lý do Trả lại → Cho phép nhập tối đa… — *TC 1226, row 1227*
10. [Trả lại] Kiểm tra trường Ô nhập thông tin – Kiểm tra popup Trả lại giao dịch thành công → - Hệ thống show MSG: "Đã trả lại thành công - Bạn có thể x… — *TC 1227, row 1228*
11. [Trả lại] Đóng – Kiểm tra chức năng đóng popup trả lại → Đóng popup hiện tại và quay lại màn hình trước đó — *TC 1228, row 1229*
12. [Phân công lại] Kiểm tra trường Ô nhập thông tin – Kiểm tra user thực hiện → SA có quyền thao tác — *TC 1229, row 1230*
13. [Phân công lại] Phân công lại – Kiểm tra khi nhấn nút → Hệ thống mở pop-up Phân công lại cán bộ: - Chọn cán bộ — *TC 1230, row 1231*
14. [Phân công lại] Kiểm tra trường Chọn cán bộ → - Các giá trị hiển thị tại droplist: Hiển thị toàn bộ cán bộ CA còn h… — *TC 1231, row 1232*
15. [Phân công lại] Kiểm tra trường Ô nhập thông tin – Kiểm trả Phân công lại thành công → 1. Hiển thị màn hình thông báo thành công 2. Hệ thống tạo tác … — *TC 1232, row 1233*
16. [Phân công lại] Đóng – Kiểm tra chức năng đóng popup Phân công lại → Đóng popup hiện tại và quay lại màn hình trước đó — *TC 1233, row 1234*
17. [Xem TBTN] File TBTN (.pdf) – Kiểm tra nhấn nút → 1. Hệ thống mở màn hình xem chi tiết file theo định dạng đã chọn với … — *TC 1234, row 1235*
18. [Xem TBTN] File YCXL giao dịch (.doc) – Kiểm tra nhấn nút → - Hệ thống mở màn hình view file và cho phép tải xuống và có tên fiel… — *TC 1235, row 1236*
19. [Xem TBTN] QLTĐ/Lãnh đạo PKH – Kiểm tra thông tin gen file → Hiển thị đúng họ và tên lãnh đạo CA thực hiện phê duyệt và ghi nhận t… — *TC 1236, row 1237*
20. [Tải hồ sơ KH] Tải hồ sơ khách hàng – Kiểm tra khi nhấn nút → - Hệ thống cho phép tải xuống các tài liệu khách hàng - Tên file: HSK… — *TC 1237, row 1238*
21. [Xem chi tiết] Điện phát hành LC – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị các trường thông tin: - Số tham chiếu LC - label (số trả ra … — *TC 1238, row 1239*
22. [Xem chi tiết] Số tham chiếu LC – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị dữ liệu master ref (TI) trả về lấy thông tin tại trường Mast… — *TC 1239, row 1240*
23. [Xem chi tiết] File Thông báo thu phí – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị file Thông báo thu phí — *TC 1240, row 1241*
24. [Xem chi tiết] File Điện phát hành LC – Kiểm tra thông tin tab Điện phát hành L/C → Điều kiện: Trong Q2: có event = , step = Authorise , status = com… — *TC 1241, row 1242*

#### B07 · CRC – Danh sách, tiếp nhận, xử lý tác nghiệp (57)

1. [Danh sách] Kiểm tra trường Checkbox khi chọn mục 10 = 2 – Kiểm tra quyền truy cập → Chỉ thấy các giao dịch thuộc phạm vi phân quyền của user đang đă… — *TC 1242, row 1243*
2. [Danh sách (Mới bổ sung)] Lưới chức năng – Kiểm tra counter tab Tất cả/Cần xử lý/Đang theo dõi/Đã hoàn thành → 1. Số lượng Counter = số bản ghi của t… — *TC 1243, row 1244*
3. [Xem chi tiết] Kiểm tra trường Checkbox khi chọn mục 10 = 2 – Kiểm tra thông tin hiển thị trên màn hình xem chi tiết → Hiển thị dữ liệu: 1. Các trườn… — *TC 1244, row 1245*
4. [Xem chi tiết] Lịch sử giao dịch – Kiểm tra chức năng khi nhấn nút Kiểm tra các hành động lưu lại lịch sử → Hệ thống mở tab xem chi tiết thông tin gh… — *TC 1245, row 1246*
5. [Tiếp nhận] Tiếp nhận – Kiểm tra hiển thị Button → Cán bộ CRC thuộc chi nhánh phát hành trên thông tin đề nghị của KH gử… — *TC 1246, row 1247*
6. [Tiếp nhận] Tiếp nhận – Kiểm tra khi nhấn nút → 1. Nhận giao dịch về chân user CRC đang tiếp nhận, tại màn hình xem c… — *TC 1247, row 1248*
7. [Tiếp nhận] Tiếp nhận – Kiểm tra khi nhiều user cùng thao tác Tiếp nhận → User nào thực hiện Tiếp nhận trước thì thực hiện thành công, user tiế… — *TC 1248, row 1249*
8. [Tiếp nhận] Tích hợp – Kiểm tra khi nhấn Tiếp nhận hệ thống kiểm tra CKS trên file → Hệ thống gọi API tới hệ thống CA để kiểm tra thông tin CKS trên … — *TC 1249, row 1250*
9. [Xử lý tác nghiệp] Kiểm tra trường Ô nhập thông tin (Mục 11 chọn giá trị = 2) – Kiểm tra hiển thị → Hiển thị dữ liệu: 1. Các trường thông tin: hiển t… — *TC 1250, row 1251*
10. [Xử lý tác nghiệp] Kiểm tra trường 1. GHTD ngắn hạn → Hiển thị 2 giá trị: 1.Còn hiệu lực, đến ngày ... <đến ngày tự động lấ… — *TC 1251, row 1252*
11. [Xử lý tác nghiệp] Kiểm tra trường 2. GHTD trung dài hạn → Hiển thị 2 giá trị: 1. Chưa quá hạn rà soát 2. Quá hạn rà soát — *TC 1252, row 1253*
12. [Xử lý tác nghiệp] Kiểm tra trường 3. Hạn mức của HĐTD → 1. Khách hàng còn đủ hạn mức để thực hiện phát hành L/C 2. Khách hàng… — *TC 1253, row 1254*
13. [Xử lý tác nghiệp] Kiểm tra trường 3. Hạn mức của HĐTD → 1. Hiển thị thêm trường cho chọn tháng/năm thuộc năm hiện tại 2. Giá … — *TC 1254, row 1255*
14. [Xử lý tác nghiệp] Kiểm tra trường 4. Hạn mức còn được sử dụng → Hiển thị giá trị theo API trả ra và cho phép sửa — *TC 1255, row 1256*
15. [Xử lý tác nghiệp] 5. Thời hạn duy trì hạn mức – Kiểm tra hiển thị → Hiển thị giá trị theo API trả ra — *TC 1256, row 1257*
16. [Xử lý tác nghiệp] Kiểm tra trường 6. Kiểm tra tính đầy đủ, hợp lệ của Hồ sơ → Hiển thị 2 giá trị: 1. Hồ sơ đã đầy đủ, hợp lệ. 2. Hồ sơ chưa đầy đủ,… — *TC 1257, row 1258*
17. [Xử lý tác nghiệp] Kiểm tra trường 6. Kiểm tra tính đầy đủ, hợp lệ của Hồ sơ → Hiển thị placeholder “Nội dung” Giá trị = rỗng Trường bắt buộc — *TC 1258, row 1259*
18. [Xử lý tác nghiệp] Kiểm tra trường 6. Kiểm tra tính đầy đủ, hợp lệ của Hồ sơ → Cho phép nhập số nguyên, số thập phân, giá trị text và các ký tự dặc … — *TC 1259, row 1260*
19. [Xử lý tác nghiệp] Kiểm tra trường 6. Kiểm tra tính đầy đủ, hợp lệ của Hồ sơ → Không cho phép nhập/paste vượt quá 3000 ký tự Hệ thống tự động cắt nộ… — *TC 1260, row 1261*
20. [Xử lý tác nghiệp] Kiểm tra trường 6. Kiểm tra tính đầy đủ, hợp lệ của Hồ sơ → Hệ thống tự động trimspace đầu cuối — *TC 1261, row 1262*
21. [Xử lý tác nghiệp] Kiểm tra trường 6. Kiểm tra tính đầy đủ, hợp lệ của Hồ sơ → Hiển thị MSG "Vui lòng nhập nội dung" — *TC 1262, row 1263*
22. [Xử lý tác nghiệp] Kiểm tra trường 7. Kiểm tra sự phù hợp với mục đích cấp tín dụng và các điều kiện cấp tín dụng đã được phê duyệt và/hoặc HĐTD đã k… — *TC 1263, row 1264*
23. [Xử lý tác nghiệp] Kiểm tra trường 7. Kiểm tra sự phù hợp với mục đích cấp tín dụng và các điều kiện cấp tín dụng đã được phê duyệt và/hoặc HĐTD đã k… — *TC 1264, row 1265*
24. [Xử lý tác nghiệp] Kiểm tra trường 7. Kiểm tra sự phù hợp với mục đích cấp tín dụng và các điều kiện cấp tín dụng đã được phê duyệt và/hoặc HĐTD đã k… — *TC 1265, row 1266*
25. [Xử lý tác nghiệp] Kiểm tra trường 7. Kiểm tra sự phù hợp với mục đích cấp tín dụng và các điều kiện cấp tín dụng đã được phê duyệt và/hoặc HĐTD đã k… — *TC 1266, row 1267*
26. [Xử lý tác nghiệp] Kiểm tra trường 7. Kiểm tra sự phù hợp với mục đích cấp tín dụng và các điều kiện cấp tín dụng đã được phê duyệt và/hoặc HĐTD đã k… — *TC 1267, row 1268*
27. [Xử lý tác nghiệp] Kiểm tra trường 7. Kiểm tra sự phù hợp với mục đích cấp tín dụng và các điều kiện cấp tín dụng đã được phê duyệt và/hoặc HĐTD đã k… — *TC 1268, row 1269*
28. [Xử lý tác nghiệp] Kiểm tra trường 8.Kiểm tra tình trạng nợ của khách hàng → Hiển thị 3 giá trị: 1. Khách hàng hiện có nợ gốc và/hoặc lãi tiền vay… — *TC 1269, row 1270*
29. [Xử lý tác nghiệp] Kiểm tra trường 9. Kiểm tra việc đáp ứng tỷ lệ bảo đảm tối thiểu → Hiển thị 2 giá trị: 1. Đáp ứng 2. Không đáp ứng — *TC 1270, row 1271*
30. [Xử lý tác nghiệp] Kiểm tra trường 10. Kiểm tra tính tuân thủ các điều kiện tín dụng trọng yếu/điều kiện tín dụng khác và việc kiểm tra sử dụng vốn v… — *TC 1271, row 1272*
31. [Xử lý tác nghiệp] Kiểm tra trường 10. Kiểm tra tính tuân thủ các điều kiện tín dụng trọng yếu/điều kiện tín dụng khác và việc kiểm tra sử dụng vốn v… — *TC 1272, row 1273*
32. [Xử lý tác nghiệp] Kiểm tra trường 10. Kiểm tra tính tuân thủ các điều kiện tín dụng trọng yếu/điều kiện tín dụng khác và việc kiểm tra sử dụng vốn v… — *TC 1273, row 1274*
33. [Xử lý tác nghiệp] Kiểm tra trường 10. Kiểm tra tính tuân thủ các điều kiện tín dụng trọng yếu/điều kiện tín dụng khác và việc kiểm tra sử dụng vốn v… — *TC 1274, row 1275*
34. [Xử lý tác nghiệp] Kiểm tra trường 10. Kiểm tra tính tuân thủ các điều kiện tín dụng trọng yếu/điều kiện tín dụng khác và việc kiểm tra sử dụng vốn v… — *TC 1275, row 1276*
35. [Xử lý tác nghiệp] Kiểm tra trường 10. Kiểm tra tính tuân thủ các điều kiện tín dụng trọng yếu/điều kiện tín dụng khác và việc kiểm tra sử dụng vốn v… — *TC 1276, row 1277*
36. [Xử lý tác nghiệp] Kiểm tra trường 10. Kiểm tra tính tuân thủ các điều kiện tín dụng trọng yếu/điều kiện tín dụng khác và việc kiểm tra sử dụng vốn v… — *TC 1277, row 1278*
37. [Xử lý tác nghiệp] Kiểm tra trường 10. Kiểm tra tính tuân thủ các điều kiện tín dụng trọng yếu/điều kiện tín dụng khác và việc kiểm tra sử dụng vốn v… — *TC 1278, row 1279*
38. [Xử lý tác nghiệp] Kiểm tra trường 10. Kiểm tra tính tuân thủ các điều kiện tín dụng trọng yếu/điều kiện tín dụng khác và việc kiểm tra sử dụng vốn v… — *TC 1279, row 1280*
39. [Xử lý tác nghiệp] Kiểm tra trường 10. Kiểm tra tính tuân thủ các điều kiện tín dụng trọng yếu/điều kiện tín dụng khác và việc kiểm tra sử dụng vốn v… — *TC 1280, row 1281*
40. [Xử lý tác nghiệp] Kiểm tra trường 11. Giao dịch TTTM thuộc thẩm quyền phê duyệt của Lãnh đạo chi nhánh/GĐ KH?? → Hiển thị 2 giá trị: (1) Không (2) C… — *TC 1281, row 1282*
41. [Xử lý tác nghiệp] Kiểm tra trường 11. Giao dịch TTTM thuộc thẩm quyền phê duyệt của Lãnh đạo chi nhánh/GĐ KH?? → Hiển thị placeholder “Nhập lý do” G… — *TC 1282, row 1283*
42. [Xử lý tác nghiệp] Kiểm tra trường 11. Giao dịch TTTM thuộc thẩm quyền phê duyệt của Lãnh đạo chi nhánh/GĐ KH?? → Cho phép nhập số nguyên, số thập ph… — *TC 1283, row 1284*
43. [Xử lý tác nghiệp] Kiểm tra trường 11. Giao dịch TTTM thuộc thẩm quyền phê duyệt của Lãnh đạo chi nhánh/GĐ KH?? → Không cho phép nhập/paste vượt quá … — *TC 1284, row 1285*
44. [Xử lý tác nghiệp] Kiểm tra trường 11. Giao dịch TTTM thuộc thẩm quyền phê duyệt của Lãnh đạo chi nhánh/GĐ KH?? → Hệ thống tự động trimspace đầu cuối — *TC 1285, row 1286*
45. [Xử lý tác nghiệp] Kiểm tra trường 11. Giao dịch TTTM thuộc thẩm quyền phê duyệt của Lãnh đạo chi nhánh/GĐ KH?? → Hiển thị MSG "Vui lòng nhập nội dun… — *TC 1286, row 1287*
46. [Xử lý tác nghiệp] Kiểm tra trường 12. Kết luận → Hiển thị 2 giá trị: 1. Hồ sơ không đủ điều kiện để thực hiện giao dịc… — *TC 1287, row 1288*
47. [Xử lý tác nghiệp] Kiểm tra trường 12. Kết luận → Hiển thị placeholder “Nhập lý do” Giá trị = rỗng Trường bắt buộc — *TC 1288, row 1289*
48. [Xử lý tác nghiệp] Kiểm tra trường 12. Kết luận → Cho phép nhập số nguyên, số thập phân, giá trị text và các ký tự dặc … — *TC 1289, row 1290*
49. [Xử lý tác nghiệp] Kiểm tra trường 12. Kết luận → Không cho phép nhập/paste vượt quá 3000 ký tự Hệ thống tự động cắt nộ… — *TC 1290, row 1291*
50. [Xử lý tác nghiệp] Kiểm tra trường 12. Kết luận → Hệ thống tự động trimspace đầu cuối — *TC 1291, row 1292*
51. [Xử lý tác nghiệp] Kiểm tra trường 12. Kết luận → Hiển thị MSG "Vui lòng nhập nội dung" — *TC 1292, row 1293*
52. [Xử lý tác nghiệp] Kiểm tra trường 13. Kết luận và đề xuất của bộ phận CRC → Hiển thị 3 giá trị: 1. Đồng ý thực hiện giao dịch TTTM và giao dịch T… — *TC 1293, row 1294*
53. [Xử lý tác nghiệp] Kiểm tra trường 13. Kết luận và đề xuất của bộ phận CRC → Hiển thị placeholder “Nhập lý do” Giá trị = rỗng Trường bắt buộc — *TC 1294, row 1295*
54. [Xử lý tác nghiệp] Kiểm tra trường 13. Kết luận và đề xuất của bộ phận CRC → Cho phép nhập số nguyên, số thập phân, giá trị text và các ký tự dặc … — *TC 1295, row 1296*
55. [Xử lý tác nghiệp] Kiểm tra trường 13. Kết luận và đề xuất của bộ phận CRC → Không cho phép nhập/paste vượt quá 3000 ký tự Hệ thống tự động cắt nộ… — *TC 1296, row 1297*
56. [Xử lý tác nghiệp] Kiểm tra trường 13. Kết luận và đề xuất của bộ phận CRC → Hệ thống tự động trimspace đầu cuối — *TC 1297, row 1298*
57. [Xử lý tác nghiệp] Kiểm tra trường 13. Kết luận và đề xuất của bộ phận CRC → Hiển thị MSG "Vui lòng nhập nội dung" — *TC 1298, row 1299*

#### B08 · CRC – Yêu cầu xử lý giao dịch (YCXL) (85)

1. [Yêu cầu xử lý giao dịch] Số hợp đồng tín dụng – Kiểm tra hiển thị → Hiển thị giá trị theo API trả ra từ GLIMS — *TC 1299, row 1300*
2. [Yêu cầu xử lý giao dịch] Trị giá giao dịch – Kiểm tra hiển thị → Hiển thị giá trị theo dữ liệu người dùng FO đã nhập khi tạo giao dịch… — *TC 1300, row 1301*
3. [Yêu cầu xử lý giao dịch] Kiểm tra trường Thông tin khác → Hiển thị placeholder “Nhập lý do” Giá trị = rỗng Trường không bắt buộc — *TC 1301, row 1302*
4. [Yêu cầu xử lý giao dịch] Kiểm tra trường Thông tin khác → Cho phép nhập số nguyên, số thập phân, giá trị text và các ký tự dặc … — *TC 1302, row 1303*
5. [Yêu cầu xử lý giao dịch] Kiểm tra trường Thông tin khác → Không cho phép nhập/paste vượt quá 3000 ký tự Hệ thống tự động cắt nộ… — *TC 1303, row 1304*
6. [Yêu cầu xử lý giao dịch] Kiểm tra trường Thông tin khác → Hệ thống tự động trimspace đầu cuối — *TC 1304, row 1305*
7. [Yêu cầu xử lý giao dịch] LC bên mua – Kiểm tra hiển thị → Hiển thị giá trị cố định "phát hành LC" — *TC 1305, row 1306*
8. [Yêu cầu xử lý giao dịch] Kiểm tra trường Khách hàng thuộc danh mục check limit với Glims → Hiển thị giá trị theo API trả ra từ GLIMS rơi vào 1 trong… — *TC 1306, row 1307*
9. [Yêu cầu xử lý giao dịch] Số creditline (CBS ref) – Kiểm tra hiển thị → Hiển thị giá trị theo API trả ra từ GLIMS — *TC 1307, row 1308*
10. [Yêu cầu xử lý giao dịch] Kiểm tra trường Chỉ thị thu phí, lãi → Hiển thị 2 giá trị: 1. Thu lãi UPAS/UPAS PLUS ngay từ tài khoản số <K… — *TC 1308, row 1309*
11. [Yêu cầu xử lý giao dịch] Kiểm tra trường Chỉ thị thu phí, lãi → Hiển thị placeholder “Chọn số tài khoản” Giá trị = rỗng Trường bắt bu… — *TC 1309, row 1310*
12. [Yêu cầu xử lý giao dịch] Kiểm tra trường Chỉ thị thu phí, lãi → Hiển thị 2 giá trị: 1. Không thực hiện giao dịch nếu tài khoản không … — *TC 1310, row 1311*
13. [Yêu cầu xử lý giao dịch] Bảng chỉ thị thu phí – Kiểm tra hiển thị → Mặc định hiển thị: Tên bảng: Chỉ thị thu phí Nút: Thêm loại phí — *TC 1311, row 1312*
14. [Yêu cầu xử lý giao dịch] Bảng chỉ thị thu phí – Kiểm tra validate khi bỏ trống trường bắt buộc → Hiển thị MSG "Vui lòng liệt kê các loại phí" — *TC 1312, row 1313*
15. [Yêu cầu xử lý giao dịch] Thêm loại phí – Kiểm tra chức năng → 1. Cho phép người dùng thêm 1 dòng thông tin 2. Thêm 1 dòng thành côn… — *TC 1313, row 1314*
16. [Yêu cầu xử lý giao dịch] Xóa – Kiểm tra chức năng → 1. Cho phép người dùng xóa 1 dòng thông tin 2. Xóa 1 dòng thành công … — *TC 1314, row 1315*
17. [Yêu cầu xử lý giao dịch] STT – Kiểm tra hiển thị → STT tự động tăng giảm tuần tự khi thêm/xóa dòng phí STT không bị nhảy… — *TC 1315, row 1316*
18. [Yêu cầu xử lý giao dịch] Kiểm tra trường Loại phí → 1. Hiển thị placeholder “Nhập thông tin” 2. Giá trị = rỗng — *TC 1316, row 1317*
19. [Yêu cầu xử lý giao dịch] Kiểm tra trường Loại phí → Cho phép nhập số nguyên, số thập phân, giá trị text và các ký tự dặc … — *TC 1317, row 1318*
20. [Yêu cầu xử lý giao dịch] Kiểm tra trường Loại phí → Không cho phép nhập/paste vượt quá 255 ký tự Hệ thống tự động cắt nội… — *TC 1318, row 1319*
21. [Yêu cầu xử lý giao dịch] Kiểm tra trường Loại phí → Hệ thống tự động trimspace đầu cuối — *TC 1319, row 1320*
22. [Yêu cầu xử lý giao dịch] Kiểm tra trường Loại phí → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thông tin] — *TC 1320, row 1321*
23. [Yêu cầu xử lý giao dịch] Kiểm tra trường Phần giá trị tính phí → 1. Hiển thị placeholder “Nhập thông tin” 2. Giá trị = rỗng — *TC 1321, row 1322*
24. [Yêu cầu xử lý giao dịch] Kiểm tra trường Phần giá trị tính phí → Cho phép nhập số nguyên, số thập phân — *TC 1322, row 1323*
25. [Yêu cầu xử lý giao dịch] Kiểm tra trường Phần giá trị tính phí → Không cho phép nhập/paste vượt quá 18 ký tự phần nguyên và 2 ký tự ph… — *TC 1323, row 1324*
26. [Yêu cầu xử lý giao dịch] Kiểm tra trường Phần giá trị tính phí → Hệ thống tự động trimspace đầu cuối — *TC 1324, row 1325*
27. [Yêu cầu xử lý giao dịch] Kiểm tra trường Phần giá trị tính phí → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thông tin] — *TC 1325, row 1326*
28. [Yêu cầu xử lý giao dịch] Kiểm tra trường Mức phí áp dụng (tỷ lệ %) → 1. Hiển thị placeholder “Nhập thông tin” 2. Giá trị = rỗng — *TC 1326, row 1327*
29. [Yêu cầu xử lý giao dịch] Kiểm tra trường Mức phí áp dụng (tỷ lệ %) → Cho phép nhập số nguyên, số thập phân — *TC 1327, row 1328*
30. [Yêu cầu xử lý giao dịch] Kiểm tra trường Mức phí áp dụng (tỷ lệ %) → Không cho phép nhập/paste vượt quá 3 ký tự phần nguyên và 2 ký tự phầ… — *TC 1328, row 1329*
31. [Yêu cầu xử lý giao dịch] Kiểm tra trường Mức phí áp dụng (tỷ lệ %) → Hệ thống tự động trimspace đầu cuối — *TC 1329, row 1330*
32. [Yêu cầu xử lý giao dịch] Kiểm tra trường Mức phí áp dụng (tỷ lệ %) → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thông tin] — *TC 1330, row 1331*
33. [Yêu cầu xử lý giao dịch] Kiểm tra trường Số phí tối thiểu → 1. Hiển thị placeholder “Nhập thông tin” 2. Giá trị = rỗng — *TC 1331, row 1332*
34. [Yêu cầu xử lý giao dịch] Kiểm tra trường Số phí tối thiểu → Cho phép nhập số nguyên, số thập phân — *TC 1332, row 1333*
35. [Yêu cầu xử lý giao dịch] Kiểm tra trường Số phí tối thiểu → Không cho phép nhập/paste vượt quá 18 ký tự phần nguyên và 2 ký tự ph… — *TC 1333, row 1334*
36. [Yêu cầu xử lý giao dịch] Kiểm tra trường Số phí tối thiểu → Hệ thống tự động trimspace đầu cuối — *TC 1334, row 1335*
37. [Yêu cầu xử lý giao dịch] Kiểm tra trường Số phí tối thiểu → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thông tin] — *TC 1335, row 1336*
38. [Yêu cầu xử lý giao dịch] Kiểm tra trường Số phí tối đa → 1. Hiển thị placeholder “Nhập thông tin” 2. Giá trị = rỗng — *TC 1336, row 1337*
39. [Yêu cầu xử lý giao dịch] Kiểm tra trường Số phí tối đa → Cho phép nhập số nguyên, số thập phân — *TC 1337, row 1338*
40. [Yêu cầu xử lý giao dịch] Kiểm tra trường Số phí tối đa → Không cho phép nhập/paste vượt quá 18 ký tự phần nguyên và 2 ký tự ph… — *TC 1338, row 1339*
41. [Yêu cầu xử lý giao dịch] Kiểm tra trường Số phí tối đa → Hệ thống tự động trimspace đầu cuối — *TC 1339, row 1340*
42. [Yêu cầu xử lý giao dịch] Kiểm tra trường Số phí tối đa → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thông tin] — *TC 1340, row 1341*
43. [Yêu cầu xử lý giao dịch] Kiểm tra trường Số tiền thu phí → 1. Hiển thị placeholder “Nhập thông tin” 2. Giá trị = rỗng — *TC 1341, row 1342*
44. [Yêu cầu xử lý giao dịch] Kiểm tra trường Số tiền thu phí → Cho phép nhập số nguyên, số thập phân — *TC 1342, row 1343*
45. [Yêu cầu xử lý giao dịch] Kiểm tra trường Số tiền thu phí → Không cho phép nhập/paste vượt quá 18 ký tự phần nguyên và 2 ký tự ph… — *TC 1343, row 1344*
46. [Yêu cầu xử lý giao dịch] Kiểm tra trường Số tiền thu phí → Hệ thống tự động trimspace đầu cuối — *TC 1344, row 1345*
47. [Yêu cầu xử lý giao dịch] Kiểm tra trường Số tiền thu phí → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thông tin] — *TC 1345, row 1346*
48. [Yêu cầu xử lý giao dịch] Kiểm tra trường Loại tiền → 1. Hiển thị danh sách các tài khoản tiền gửi của KH có trạng thái act… — *TC 1346, row 1347*
49. [Yêu cầu xử lý giao dịch] Kiểm tra trường Loại tiền → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thông tin] — *TC 1347, row 1348*
50. [Yêu cầu xử lý giao dịch] Kiểm tra trường Thời điểm thu phí → 1. Hiển thị placeholder “Nhập thông tin” 2. Giá trị = rỗng — *TC 1348, row 1349*
51. [Yêu cầu xử lý giao dịch] Kiểm tra trường Thời điểm thu phí → Cho phép nhập số nguyên, số thập phân, giá trị text và các ký tự dặc … — *TC 1349, row 1350*
52. [Yêu cầu xử lý giao dịch] Kiểm tra trường Thời điểm thu phí → Không cho phép nhập/paste vượt quá 500 ký tự Hệ thống tự động cắt nội… — *TC 1350, row 1351*
53. [Yêu cầu xử lý giao dịch] Kiểm tra trường Thời điểm thu phí → Hệ thống tự động trimspace đầu cuối — *TC 1351, row 1352*
54. [Yêu cầu xử lý giao dịch] Kiểm tra trường Thời điểm thu phí → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thông tin] — *TC 1352, row 1353*
55. [Yêu cầu xử lý giao dịch] Kiểm tra trường Ghi chú → 1. Hiển thị placeholder “Nhập thông tin” 2. Giá trị = rỗng — *TC 1353, row 1354*
56. [Yêu cầu xử lý giao dịch] Kiểm tra trường Ghi chú → Cho phép nhập số nguyên, số thập phân, giá trị text và các ký tự dặc … — *TC 1354, row 1355*
57. [Yêu cầu xử lý giao dịch] Kiểm tra trường Ghi chú → Không cho phép nhập/paste vượt quá 255 ký tự Hệ thống tự động cắt nội… — *TC 1355, row 1356*
58. [Yêu cầu xử lý giao dịch] Kiểm tra trường Ghi chú → Hệ thống tự động trimspace đầu cuối — *TC 1356, row 1357*
59. [Yêu cầu xử lý giao dịch] Kiểm tra trường 11. Hoạt động kinh doanh → Hiển thị giá trị: (1) Chuyển khẩu (2) Tạm nhập, tái xuất (3) Không Tr… — *TC 1357, row 1358*
60. [Yêu cầu xử lý giao dịch] Tải lên – Kiểm tra các trường hợp tải file đính kèm → 1. Cho phép người dùng tải hồ sơ từ máy cá nhân, có thể chọn từ thư m… — *TC 1358, row 1359*
61. [Yêu cầu xử lý giao dịch] Tải lên – Kiểm tra chức năng → Upload file thành công File hiển thị trong danh sách đính kèm — *TC 1359, row 1360*
62. [Yêu cầu xử lý giao dịch] Tải lên – Kiểm tra các trường hợp tải file đính kèm → 1. Cho phép người dùng tải hồ sơ từ máy cá nhân, có thể chọn từ thư m… — *TC 1360, row 1361*
63. [Yêu cầu xử lý giao dịch] Tải lên – Kiểm tra các trường hợp tải file đính kèm → 1. Cho phép người dùng tải hồ sơ từ máy cá nhân, có thể chọn từ thư m… — *TC 1361, row 1362*
64. [Yêu cầu xử lý giao dịch] Tải lên – Kiểm tra các trường hợp tải file đính kèm → 1. Cho phép người dùng tải hồ sơ từ máy cá nhân, có thể chọn từ thư m… — *TC 1362, row 1363*
65. [Yêu cầu xử lý giao dịch] Tải lên – Kiểm tra các trường hợp tải file đính kèm → 1. Cho phép người dùng tải hồ sơ từ máy cá nhân, có thể chọn từ thư m… — *TC 1363, row 1364*
66. [Yêu cầu xử lý giao dịch] Tải lên – Kiểm tra các trường hợp tải file đính kèm → 1. Cho phép người dùng tải hồ sơ từ máy cá nhân, có thể chọn từ thư m… — *TC 1364, row 1365*
67. [Yêu cầu xử lý giao dịch] Tải lên – Kiểm tra validate định dạng file không hợp lệ → Nếu sai định dạng hệ thống hiển thị MSG: “Định dạng file không hợ… — *TC 1365, row 1366*
68. [Yêu cầu xử lý giao dịch] Tải lên – Kiểm tra validate tên file chứa ký tự đặc biệt → Hiển thị MSG "Upload file thất bại _ Tên file không hợp lệ _ Ký … — *TC 1366, row 1367*
69. [Yêu cầu xử lý giao dịch] Tải lên – Kiểm tra validate dung lượng tải lên → Upload file thành công File hiển thị trong danh sách đính kèm — *TC 1367, row 1368*
70. [Yêu cầu xử lý giao dịch] Tải lên – Kiểm tra validate dung lượng tải lên → Hiển thị MSG "Upload file thật bại_File đẩy lên không được quá 100MB" — *TC 1368, row 1369*
71. [Yêu cầu xử lý giao dịch] Tải lên – Kiểm tra validate dung lượng tải lên → Hiển thị MSG "Upload file thật bại_File đẩy lên không được quá 100MB" — *TC 1369, row 1370*
72. [Yêu cầu xử lý giao dịch] Tải lên – Kiểm tra validate dung lượng tải lên → Hiển thị MSG "Upload file thật bại_Tổng dung lượng file tải lên không… — *TC 1370, row 1371*
73. [Yêu cầu xử lý giao dịch] Tải lên – Kiểm tra validate dung lượng tải lên → Upload thất bại_File không hợp lệ — *TC 1371, row 1372*
74. [Yêu cầu xử lý giao dịch] Tải lên – Kiểm tra validate dung lượng tải lên → Upload thất bại_File không hợp lệ — *TC 1372, row 1373*
75. [Yêu cầu xử lý giao dịch] Tải lên – Kiểm tra chức năng → Upload file thành công File hiển thị trong danh sách đính kèm — *TC 1373, row 1374*
76. [Yêu cầu xử lý giao dịch] Tải lên – Kiểm tra nội dung hiển thi → Hiển thị đúng nội dung gốc file tải lên — *TC 1374, row 1375*
77. [Yêu cầu xử lý giao dịch] Xóa file đã upload. – Kiểm tra chức năng → Cho phép xóa bản ghi đính kèm — *TC 1375, row 1376*
78. [Xử lý - Gửi duyệt] Lưu – Kiểm tra hoạt động → - Hệ thống lưu thông tin nhập liệu người dùng đã khai báo - Hệ thống … — *TC 1376, row 1377*
79. [Xử lý - Gửi duyệt] Lưu – Kiểm tra hoạt động → Hiển thị MSG "Lưu nháp thành công" Giữ thông tin các option đã tick c… — *TC 1377, row 1378*
80. [Xử lý - Gửi duyệt] Lưu – Kiểm tra hoạt động → Hiển thị màn view đầy đủ thông tin đánh giá CRC đã tick/nhập Trạng th… — *TC 1378, row 1379*
81. [Xử lý - Gửi duyệt] Đóng – Kiểm tra hoạt động → Hiển thị popup xác nhận — *TC 1379, row 1380*
82. [Xử lý - Gửi duyệt] Đóng – Kiểm tra hoạt động → Đóng màn hình hiện tại, quay về màn hình quản lý danh sách — *TC 1380, row 1381*
83. [Xử lý - Gửi duyệt] Kiểm tra CKS – Xem thông tin CKS trả ra → Hiển thị màn hình kết quả thông tin xác thực CKS trả ra từ CA qua API… — *TC 1381, row 1382*
84. [Xử lý - Gửi duyệt] Gửi duyệt – Kiểm tra khi NSD thực hiện gửi duyệt → 1. Hệ thống thực hiện phê duyệt giao dịch thành công, hiển thị thông … — *TC 1382, row 1383*
85. [Xử lý - Gửi duyệt] Gửi duyệt – Kiểm tra khi NSD thực hiện gửi duyệt → Đóng - Mở popup xác nhận gửi duyệt — *TC 1383, row 1384*

#### B09 · CRC – Gửi duyệt / Trả lại / Xem file tác nghiệp (32)

1. [Xử lý - Gửi duyệt] Popup lưu nháp – Kiểm tra hoạt động → Hiển thị popup Xác nhận đóng màn hình user input thông tin: ""Có nội … — *TC 1384, row 1385*
2. [Xử lý - Trả lại] Lịch sử giao dịch – Kiểm tra user thực hiện → Cán bộ CRC đã thực hiện tiếp nhận giao dịch hoặc cán bộ CRC được phân… — *TC 1385, row 1386*
3. [Xử lý - Trả lại] Trả lại – Kiểm tra khi nhấn nút → - Hệ thống mở popup nhập nội dung lý do Trả lại - Người dùng nhập thô… — *TC 1386, row 1387*
4. [Xử lý - Trả lại] Popup trả lại – Trả lại giao dịch thành công → - Hệ thống show msg "Đã trả lại thành công. Bạn có thể xem trạng thái… — *TC 1387, row 1388*
5. [Xử lý - Trả lại] Popup trả lại – Kiểm tra validate bỏ trống Nhập lý do trả lại → Hiển thị MSG "Vui lòng nhập thông tin lý do trả lại" — *TC 1388, row 1389*
6. [Xử lý - Trả lại] Không – Kiểm tra chức năng → Đóng pop-up, quay lại màn hình Xử lý - Gửi duyệt — *TC 1389, row 1390*
7. [CRC_xem File tác nghiệp] Xem file tác nghiệp – Kiểm tra nhấn nút → Hiển thị 2 file: (1) File TBTN (.pdf) (2) File YCXL giao dịch (.doc) — *TC 1390, row 1391*
8. [CRC_xem File tác nghiệp] File TBTN (.pdf) – Kiểm tra nhấn nút → 1. Hệ thống mở màn hình xem chi tiết file theo định dạng đã chọn với … — *TC 1391, row 1392*
9. [CRC_xem File tác nghiệp] File YCXL giao dịch (.doc) – Kiểm tra nhấn nút → - Hệ thống mở màn hình view file và cho phép tải xuống và có tên fiel… — *TC 1392, row 1393*
10. [CRC_xem File tác nghiệp] IV. KIỂM TRA CỦA BỘ PHẬN CRC – Kiểm tra thông tin gen file → Hiển thị đúng tên tiêu đề - thông tin được gen khi CB CRC nhấn… — *TC 1393, row 1394*
11. [CRC_xem File tác nghiệp] 1. Đã nhận thông báo này kèm các tài liệu nêu tại mục III lúc […] – Kiểm tra thông tin gen file → Thời gian = Thời gian lãn… — *TC 1394, row 1395*
12. [CRC_xem File tác nghiệp] 2.1. Hiệu lực của GHTD – Kiểm tra thông tin gen file → Hiển thị tích đúng với thông tin GLIMS trả ra tại: - GHTD nh (ngắn h… — *TC 1395, row 1396*
13. [CRC_xem File tác nghiệp] 2.2. Hạn mức của HĐTD – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CRC Chọn hoặc/và nhập — *TC 1396, row 1397*
14. [CRC_xem File tác nghiệp] Hạn mức còn được sử dụng – Kiểm tra thông tin gen file → Hiển thị giá trị theo API trả ra và hoặc CRC nhập — *TC 1397, row 1398*
15. [CRC_xem File tác nghiệp] Thời hạn duy trì hạn mức – Kiểm tra thông tin gen file → Hiển thị giá trị theo API trả ra — *TC 1398, row 1399*
16. [CRC_xem File tác nghiệp] 3. Kiểm tra tính đầy đủ, hợp lệ của Hồ sơ – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CRC Chọn hoặc/và nh… — *TC 1399, row 1400*
17. [CRC_xem File tác nghiệp] 4. Kiểm tra sự phù hợp với mục đích cấp tín dụng và các điều kiện cấp tín dụng đã được phê duyệt và/hoặc HĐTD đã ký – Kiểm … — *TC 1400, row 1401*
18. [CRC_xem File tác nghiệp] 5.Kiểm tra tình trạng nợ của khách hàng – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CRC Chọn hoặc/và nhập — *TC 1401, row 1402*
19. [CRC_xem File tác nghiệp] 6. Kiểm tra việc đáp ứng tỷ lệ bảo đảm tối thiểu – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CRC Chọn hoặ… — *TC 1402, row 1403*
20. [CRC_xem File tác nghiệp] 7. Kiểm tra tính tuân thủ – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CRC Chọn hoặc/và nhập Cán bộ chọn/n… — *TC 1403, row 1404*
21. [CRC_xem File tác nghiệp] 8. Kết luận – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CRC Chọn hoặc/và nhập — *TC 1404, row 1405*
22. [CRC_xem File tác nghiệp] 9. Giao dịch TTTM thuộc thẩm quyền phê duyệt của Lãnh đạo chi nhánh/GĐ KH? – Kiểm tra thông tin gen file → Hiển thị đúng nộ… — *TC 1405, row 1406*
23. [CRC_xem File tác nghiệp] 10. Kết luận và đề xuất của BP CRC – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CRC Chọn hoặc/và nhập — *TC 1406, row 1407*
24. [CRC_xem File tác nghiệp] Cán bộ CRC – Kiểm tra thông tin gen file → Hiển thị đúng họ và tên Cán bộ CRC thực hiện gửi duyệt và ghi nhận th… — *TC 1407, row 1408*
25. [CRC_xem File tác nghiệp] VI. TÁC NGHIỆP CỦA BỘ PHẬN CRC – Kiểm tra thông tin gen file → Hiển thị đúng tên tiêu đề - data mục V được gen khi hệ thống… — *TC 1408, row 1409*
26. [CRC_xem File tác nghiệp] Đã nhận Thông báo này và hồ sơ kèm theo lúc – Kiểm tra thông tin gen file → - Hiển thị thời gian của Cấp thẩm quyền tại mục… — *TC 1409, row 1410*
27. [CRC_xem File tác nghiệp] Đã khoanh giữ tiền ký quỹ trên hệ thống theo chỉ thị. Tài khoản ký quỹ – Kiểm tra thông tin gen file → Hiển thị số tài khoả… — *TC 1410, row 1411*
28. [CRC_xem File tác nghiệp] Đã lập Yêu cầu xử lý giao dịch TTTM gửi Trung tâm TTTM kèm hình ảnh hồ sơ lúc – Kiểm tra thông tin gen file → Tick vào mục … — *TC 1411, row 1412*
29. [CRC_xem File tác nghiệp] Đã in nội dung điện SWIFT mở L/C theo kết quả xử lý của Trung tâm TTTM – Kiểm tra thông tin gen file → Chỉ tick chọn sau kh… — *TC 1412, row 1413*
30. [CRC_xem File tác nghiệp] Mã Cán bộ CRC trên VCBTI – Kiểm tra thông tin gen file → User maker event phát hành LC (Phát hành LC tại CN) hoặc User make… — *TC 1413, row 1414*
31. [CRC_xem File tác nghiệp] Mã Lãnh đạo CRC trên VCBTI – Kiểm tra thông tin gen file → User checker (event phát hành LC, step: Authorise, status: Compl… — *TC 1414, row 1415*
32. [Tải hồ sơ KH] Tải hồ sơ khách hàng – Kiểm tra khi nhấn nút → - Hệ thống cho phép tải xuống các tài liệu khách hàng - Tên file: HSK… — *TC 1415, row 1416*

#### B10 · CRC lead – Phê duyệt, Phê duyệt ĐXTC, Trả lại, Phân công lại, Xem file (37)

1. [Danh sách] File Thông báo thu phí – Kiểm tra thông tin tab Điện phát hành L/C → Mặc định hiển thị toàn bộ GD gửi tới CN theo HĐHMPHLC 0. Tất cả = Tấ… — *TC 1416, row 1417*
2. [Danh sách] File Điện phát hành LC – Kiểm tra counter tab Tất cả/Cần xử lý/Đang theo dõi/Đã hoàn thành → 1. Số lượng Counter = số bản ghi của từng ta… — *TC 1417, row 1418*
3. [Xem chi tiết] Kiểm tra thông tin hiển thị trên màn hình → Hiển thị dữ liệu: 1. Các trường thông tin: Hiển thị đúng các trường t… — *TC 1418, row 1419*
4. [Xem chi tiết] Lưới chức năng – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị các trường thông tin: - Số tham chiếu LC - label (số trả ra … — *TC 1419, row 1420*
5. [Xem chi tiết] Lịch sử giao dịch – Kiểm tra chức năng khi người dùng click vào → Hiển thị popup có các trường thông tin và hiển thị giá trị tương ứng… — *TC 1420, row 1421*
6. [Xem chi tiết] Lịch sử giao dịch – Kiểm tra các hành động lưu lại lịch sử → Khi người dùng thực hiện các chức năng dưới đây: 1. FO duyệt cuối (tr… — *TC 1421, row 1422*
7. [Phê duyệt] Phê duyệt – Kiểm tra hiển thị nút → Hiển thị nút Phê duyệt — *TC 1422, row 1423*
8. [Phê duyệt] Popup – Kiểm tra khi nhấn nút Phê duyệt → 1. Hệ thống thực hiện phê duyệt giao dịch thành công: hiển thị thông … — *TC 1423, row 1424*
9. [Phê duyệt] Duyệt và Gửi duyệt – Kiểm tra hiển thị nút → Hiển thị nút <Duyệt và Gửi duyệt> — *TC 1424, row 1425*
10. [Phê duyệt] Popup – Kiểm tra khi nhấn nút Phê duyệt → 1. Hệ thống thực hiện phê duyệt giao dịch thành công: hiển thị thông … — *TC 1425, row 1426*
11. [Phê duyệt ĐXTC] Phê duyệt – Kiểm tra hiển thị nút → Hiển thị nút Phê duyệt — *TC 1426, row 1427*
12. [Phê duyệt ĐXTC] Popup – Kiểm tra khi nhấn nút Phê duyệt → 1. Hệ thống thực hiện phê duyệt giao dịch thành công: hiển thị thông … — *TC 1427, row 1428*
13. [Phê duyệt ĐXTC] Duyệt và Gửi duyệt – Kiểm tra hiển thị nút → Hiển thị nút <Duyệt và Gửi duyệt> — *TC 1428, row 1429*
14. [Phê duyệt ĐXTC] Popup – Kiểm tra khi nhấn nút Duyệt và Gửi duyệt → 1. Hệ thống thực hiện phê duyệt giao dịch thành công: hiển thị thông … — *TC 1429, row 1430*
15. [Trả lại] Kiểm tra user thực hiện → User thuộc LĐ CRC và có quyền phê duyệt — *TC 1430, row 1431*
16. [Trả lại] Trả lại – Kiểm tra khi nhấn nút → - Hệ thống mở popup Nhập nội dung Lý do Trả lại → Cho phép nhập tối đ… — *TC 1431, row 1432*
17. [Trả lại] Trả lại giao dịch thành công → 1. Hệ thống show msg "Đã trả lại thành công. Bạn có thể xem trạng thá… — *TC 1432, row 1433*
18. [Trả lại] Trả lại giao dịch thành công → 1. Hệ thống show msg "Đã trả lại thành công. Bạn có thể xem trạng thá… — *TC 1433, row 1434*
19. [Trả lại] Trả lại giao dịch thất bại → Đóng pop-up hiện tại — *TC 1434, row 1435*
20. [Phân công lại] Xem file tác nghiệp – Kiểm tra user thực hiện → User thuộc LĐ CRC và có quyền phê duyệt — *TC 1435, row 1436*
21. [Phân công lại] Phân công lại – Kiểm tra khi nhấn nút → Hệ thống mở pop-up Phân công lại cán bộ: - Chọn cán bộ — *TC 1436, row 1437*
22. [Phân công lại] Kiểm tra trường Chọn cán bộ → - Các giá trị hiển thị tại droplist: Hiển thị toàn bộ cán bộ CRC còn … — *TC 1437, row 1438*
23. [Phân công lại] Cấp Thẩm quyền – Kiểm tra Phân công lại thành công → 1. Hiển thị màn hình thông báo thành công 2. Hệ thống tạo tác vụ xử l… — *TC 1438, row 1439*
24. [Phân công lại] Đóng – Kiểm tra chức năng đóng popup Phân công lại → Đóng popup hiện tại và quay lại màn hình trước đó — *TC 1439, row 1440*
25. [Xem file tác nghiệp] Xem file tác nghiệp – Kiểm tra nhấn nút → Hiển thị 2 file: (1) File TBTN (.pdf) (2) File YCXL giao dịch (.doc) — *TC 1440, row 1441*
26. [Xem file tác nghiệp] File TBTN (.pdf) – Kiểm tra nhấn nút → 1. Hệ thống mở màn hình xem chi tiết file theo định dạng đã chọn với … — *TC 1441, row 1442*
27. [Xem file tác nghiệp] File YCXL giao dịch (.doc) – Kiểm tra nhấn nút → - Hệ thống mở màn hình view file và cho phép tải xuống và có tên fiel… — *TC 1442, row 1443*
28. [Xem file tác nghiệp] File YCXL giao dịch (.doc) – Kiểm tra nhấn nút → - Hệ thống mở màn hình view file và cho phép tải xuống và có tên fiel… — *TC 1443, row 1444*
29. [Xem file tác nghiệp] Lãnh đạo CRC – Kiểm tra thông tin gen file → - Hiển thị đúng họ và tên lãnh đạo CRC thực hiện phê duyệt đang login… — *TC 1444, row 1445*
30. [LD CRC_Xem file tác nghiệp] V. PHÊ DUYỆT CỦA CẤP THẨM QUYỀN – Kiểm tra thông tin gen file → Hệ thống hiển thị nội dung = thông tin lãnh đạo CRC khi … — *TC 1445, row 1446*
31. [Xem file YCXL] Yêu cầu xử lý giao dịch – Kiểm tra thời điểm gen → Hệ thống gen file Yêu cầu xử lý giao dịch với nội dung các trường thô… — *TC 1446, row 1447*
32. [Xem file YCXL] Yêu cầu xử lý giao dịch – Kiểm tra TH hiển thị nội dung mục V. TÁC NGHIỆP CỦA BỘ PHẬN CRC → Chưa hiển thị nội dung mục này — *TC 1447, row 1448*
33. [Tải hồ sơ KH] Tải hồ sơ khách hàng – Kiểm tra khi nhấn nút → - Hệ thống cho phép tải xuống các tài liệu khách hàng - Tên file: HSK… — *TC 1448, row 1449*
34. [Xem chi tiết] Kết quả xử lý giao dịch – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị các trường thông tin: - Số tham chiếu LC - label (số tr… — *TC 1449, row 1450*
35. [Xem chi tiết] Số tham chiếu LC – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị dữ liệu master ref (TI) trả về lấy thông tin tại trường Mast… — *TC 1450, row 1451*
36. [Xem chi tiết] File Thông báo thu phí – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị file Thông báo thu phí — *TC 1451, row 1452*
37. [Xem chi tiết] File Điện phát hành LC – Kiểm tra thông tin tab Điện phát hành L/C → Điều kiện: Trong Q2: có event = , step = Authorise , status = com… — *TC 1452, row 1453*

#### B13 · CRC – Giao dịch trạng thái Đã phát hành điện LC (32)

1. [Danh sách] Kiểm tra quyền truy cập → Chỉ thấy các giao dịch thuộc phạm vi phân quyền của user đang đăng nh… — *TC 1487, row 1488*
2. [Danh sách (Mới bổ sung)] Lưới chức năng – Kiểm tra counter tab Tất cả/Cần xử lý/Đang theo dõi/Đã hoàn thành → 1. Số lượng Counter = số bản ghi của t… — *TC 1488, row 1489*
3. [Xem chi tiết] Lịch sử giao dịch – Kiểm tra thông tin hiển thị trên màn hình xem chi tiết → Hiển thị dữ liệu: 1. Các trường thông tin: hiển thị đúng … — *TC 1489, row 1490*
4. [Xem chi tiết] Lịch sử giao dịch – Kiểm tra chức năng khi nhấn nút Kiểm tra các hành động lưu lại lịch sử → Hệ thống mở tab xem chi tiết thông tin gh… — *TC 1490, row 1491*
5. [Xử lý tác nghiệp] Kiểm tra trường Giao dịch TTTM thuộc thẩm quyền phê duyệt của Lãnh đạo chi nhánh/GĐ KH?? → Hiển thị 2 giá trị: (1) Không (2) Có — *TC 1491, row 1492*
6. [Xử lý - Gửi duyệt] Gửi duyệt – Kiểm tra khi NSD thực hiện gửi duyệt → 1. Hệ thống thực hiện phê duyệt giao dịch thành công, hiển thị thông … — *TC 1492, row 1493*
7. [Xử lý - Gửi duyệt] Gửi duyệt – Kiểm tra khi NSD thực hiện gửi duyệt → Đóng - Mở popup xác nhận gửi duyệt — *TC 1493, row 1494*
8. [CRC_xem File tác nghiệp] Xem file tác nghiệp – Kiểm tra nhấn nút → Hiển thị 2 file: (1) File TBTN (.pdf) (2) File YCXL giao dịch (.doc) — *TC 1494, row 1495*
9. [CRC_xem File tác nghiệp] File TBTN (.pdf) – Kiểm tra nhấn nút → 1. Hệ thống mở màn hình xem chi tiết file theo định dạng đã chọn với … — *TC 1495, row 1496*
10. [CRC_xem File tác nghiệp] File YCXL giao dịch (.doc) – Kiểm tra nhấn nút → - Hệ thống mở màn hình view file và cho phép tải xuống và có tên fiel… — *TC 1496, row 1497*
11. [CRC_xem File tác nghiệp] IV. KIỂM TRA CỦA BỘ PHẬN CRC – Kiểm tra thông tin gen file → Hiển thị đúng tên tiêu đề - thông tin được gen khi CB CRC nhấn… — *TC 1497, row 1498*
12. [CRC_xem File tác nghiệp] 1. Đã nhận thông báo này kèm các tài liệu nêu tại mục III lúc […] – Kiểm tra thông tin gen file → Thời gian = Thời gian lãn… — *TC 1498, row 1499*
13. [CRC_xem File tác nghiệp] 2.1. Hiệu lực của GHTD – Kiểm tra thông tin gen file → Hiển thị tích đúng với thông tin GLIMS trả ra tại: - GHTD nh (ngắn h… — *TC 1499, row 1500*
14. [CRC_xem File tác nghiệp] 2.2. Hạn mức của HĐTD – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CRC Chọn hoặc/và nhập — *TC 1500, row 1501*
15. [CRC_xem File tác nghiệp] Hạn mức còn được sử dụng – Kiểm tra thông tin gen file → Hiển thị giá trị theo API trả ra và hoặc CRC nhập — *TC 1501, row 1502*
16. [CRC_xem File tác nghiệp] Thời hạn duy trì hạn mức – Kiểm tra thông tin gen file → Hiển thị giá trị theo API trả ra — *TC 1502, row 1503*
17. [CRC_xem File tác nghiệp] 3. Kiểm tra tính đầy đủ, hợp lệ của Hồ sơ – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CRC Chọn hoặc/và nh… — *TC 1503, row 1504*
18. [CRC_xem File tác nghiệp] 4. Kiểm tra sự phù hợp với mục đích cấp tín dụng và các điều kiện cấp tín dụng đã được phê duyệt và/hoặc HĐTD đã ký – Kiểm … — *TC 1504, row 1505*
19. [CRC_xem File tác nghiệp] 5.Kiểm tra tình trạng nợ của khách hàng – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CRC Chọn hoặc/và nhập — *TC 1505, row 1506*
20. [CRC_xem File tác nghiệp] 6. Kiểm tra việc đáp ứng tỷ lệ bảo đảm tối thiểu – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CRC Chọn hoặ… — *TC 1506, row 1507*
21. [CRC_xem File tác nghiệp] 7. Kiểm tra tính tuân thủ – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CRC Chọn hoặc/và nhập Cán bộ chọn/n… — *TC 1507, row 1508*
22. [CRC_xem File tác nghiệp] 8. Kết luận – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CRC Chọn hoặc/và nhập — *TC 1508, row 1509*
23. [CRC_xem File tác nghiệp] 9. Giao dịch TTTM thuộc thẩm quyền phê duyệt của Lãnh đạo chi nhánh/GĐ KH? – Kiểm tra thông tin gen file → Hiển thị đúng nộ… — *TC 1509, row 1510*
24. [CRC_xem File tác nghiệp] 10. Kết luận và đề xuất của BP CRC – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CRC Chọn hoặc/và nhập — *TC 1510, row 1511*
25. [CRC_xem File tác nghiệp] Cán bộ CRC – Kiểm tra thông tin gen file → Hiển thị đúng họ và tên Cán bộ CRC thực hiện gửi duyệt và ghi nhận th… — *TC 1511, row 1512*
26. [CRC_xem File tác nghiệp] VI. TÁC NGHIỆP CỦA BỘ PHẬN CRC – Kiểm tra thông tin gen file → Hiển thị đúng tên tiêu đề - data mục V được gen khi hệ thống… — *TC 1512, row 1513*
27. [CRC_xem File tác nghiệp] Đã nhận Thông báo này và hồ sơ kèm theo lúc – Kiểm tra thông tin gen file → - Hiển thị thời gian của Cấp thẩm quyền tại mục… — *TC 1513, row 1514*
28. [CRC_xem File tác nghiệp] Đã khoanh giữ tiền ký quỹ trên hệ thống theo chỉ thị. Tài khoản ký quỹ – Kiểm tra thông tin gen file → Hiển thị số tài khoả… — *TC 1514, row 1515*
29. [CRC_xem File tác nghiệp] Đã lập Yêu cầu xử lý giao dịch TTTM gửi Trung tâm TTTM kèm hình ảnh hồ sơ lúc – Kiểm tra thông tin gen file → Tick vào mục … — *TC 1515, row 1516*
30. [CRC_xem File tác nghiệp] Đã in nội dung điện SWIFT mở L/C theo kết quả xử lý của Trung tâm TTTM – Kiểm tra thông tin gen file → Chỉ tick chọn sau kh… — *TC 1516, row 1517*
31. [CRC_xem File tác nghiệp] Mã Cán bộ CRC trên VCBTI – Kiểm tra thông tin gen file → User maker event phát hành LC (Phát hành LC tại CN) hoặc User make… — *TC 1517, row 1518*
32. [CRC_xem File tác nghiệp] Mã Lãnh đạo CRC trên VCBTI – Kiểm tra thông tin gen file → User checker (event phát hành LC, step: Authorise, status: Compl… — *TC 1518, row 1519*

#### B14 · CRC lead – Chờ ký số điện LC: Phê duyệt & Ký số (không thuộc thẩm quyền BGĐ CN) (23)

1. [Danh sách] File YCXL giao dịch (.doc) – Kiểm tra nhấn nút → Mặc định hiển thị toàn bộ GD gửi tới CN theo HĐHMPHLC 0. Tất cả = Tất… — *TC 1519, row 1520*
2. [Danh sách] File YCXL giao dịch (.doc) – Kiểm tra counter tab Tất cả/Cần xử lý/Đang theo dõi/Đã hoàn thành → 1. Số lượng Counter = số bản ghi của từn… — *TC 1520, row 1521*
3. [Xem chi tiết] Lãnh đạo CRC – Kiểm tra thông tin hiển thị trên màn hình → Hiển thị dữ liệu: 1. Các trường thông tin: Hiển thị đúng các trường t… — *TC 1521, row 1522*
4. [Xem chi tiết] V. PHÊ DUYỆT CỦA CẤP THẨM QUYỀN – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị các trường thông tin: - Số tham chiếu LC - labe… — *TC 1522, row 1523*
5. [Xem chi tiết] Lịch sử giao dịch – Kiểm tra chức năng khi người dùng click vào → Hiển thị popup có các trường thông tin và hiển thị giá trị tương ứng… — *TC 1523, row 1524*
6. [Xem chi tiết] Lịch sử giao dịch – Kiểm tra các hành động lưu lại lịch sử → Khi người dùng thực hiện các chức năng dưới đây: 1. FO duyệt cuối (tr… — *TC 1524, row 1525*
7. [Phê duyệt] Phê duyệt – Kiểm tra hiển thị nút → Hiển thị nút <Phê duyệt> — *TC 1525, row 1526*
8. [Phê duyệt] Popup – Kiểm tra khi nhấn nút Phê duyệt → - Hiển thị màn hình chức năng ký số cá nhân, xem chi tiết có nút <Ký … — *TC 1526, row 1527*
9. [Phê duyệt] Duyệt và Gửi duyệt – Kiểm tra hiển thị nút → Hiển thị nút <Duyệt và Gửi duyệt> — *TC 1527, row 1528*
10. [Phê duyệt] Popup – Kiểm tra khi nhấn nút Phê duyệt → 1. Hệ thống thực hiện phê duyệt giao dịch thành công: hiển thị thông … — *TC 1528, row 1529*
11. [Xem file tác nghiệp] Xem file tác nghiệp – Kiểm tra nhấn nút → Hiển thị 2 file: (1) File TBTN (.pdf) (2) File YCXL giao dịch (.doc) — *TC 1529, row 1530*
12. [Xem file tác nghiệp] File TBTN (.pdf) – Kiểm tra nhấn nút → 1. Hệ thống mở màn hình xem chi tiết file theo định dạng đã chọn với … — *TC 1530, row 1531*
13. [Xem file tác nghiệp] File YCXL giao dịch (.doc) – Kiểm tra nhấn nút → - Hệ thống mở màn hình view file và cho phép tải xuống và có tên fiel… — *TC 1531, row 1532*
14. [Xem file tác nghiệp] File YCXL giao dịch (.doc) – Kiểm tra nhấn nút → - Hệ thống mở màn hình view file và cho phép tải xuống và có tên fiel… — *TC 1532, row 1533*
15. [Xem file tác nghiệp] Lãnh đạo CRC – Kiểm tra thông tin gen file → - Hiển thị đúng họ và tên lãnh đạo CRC thực hiện phê duyệt đang login… — *TC 1533, row 1534*
16. [LD CRC_Xem file tác nghiệp] V. PHÊ DUYỆT CỦA CẤP THẨM QUYỀN – Kiểm tra thông tin gen file → Hệ thống hiển thị nội dung = thông tin lãnh đạo CRC khi … — *TC 1534, row 1535*
17. [Xem file YCXL] Yêu cầu xử lý giao dịch – Kiểm tra thời điểm gen → Hệ thống gen file Yêu cầu xử lý giao dịch với nội dung các trường thô… — *TC 1535, row 1536*
18. [Xem file YCXL] Yêu cầu xử lý giao dịch – Kiểm tra TH hiển thị nội dung mục V. TÁC NGHIỆP CỦA BỘ PHẬN CRC → Chưa hiển thị nội dung mục này — *TC 1536, row 1537*
19. [Tải hồ sơ KH] Tải hồ sơ khách hàng – Kiểm tra khi nhấn nút → - Hệ thống cho phép tải xuống các tài liệu khách hàng - Tên file: HSK… — *TC 1537, row 1538*
20. [Ký số cá nhân điện phát hành LC] Ký số cá nhân – Kiểm tra khi nhấn nút → - Hiển thị khung preview văn bản, cho phép người dùng xem lại nội dun… — *TC 1538, row 1539*
21. [Ký số cá nhân điện phát hành LC] Ký số online – Kiểm tra khi nhấn nút → 1. Hệ thống ETL từ AVS sang EG để kiểm tra thông tin banker user gắn … — *TC 1539, row 1540*
22. [Ký số cá nhân điện phát hành LC] Ký số USB – Kiểm tra khi nhấn nút → 1. Người dùng thao tác ký số thành công, hiển thị màn hình thông báo … — *TC 1540, row 1541*
23. [Ký số pháp nhân điện phát hành LC] Chọn tệp tin – Kiểm tra chức năng Ký số pháp nhân → - Hệ thống call API ký số pháp nhân tự động trên BO. Hệ thống… — *TC 1541, row 1542*

## Happy case 2 – Như HC1 nhưng bị trả lại ở 1 cấp → chỉnh sửa, gửi lại → Hoàn thành

- E2E: **TC 33, row 34** — Luồng (1) – Đề xuất phê duyệt - Không cần thẩm quyền BGĐ CN – CA trả lại Doanh nghiệp → FO chỉnh sửa, gửi lại – LC được phát hành
- Biến thể: TC 34, row 35 — Luồng (1) – Đề xuất phê duyệt - Không cần thẩm quyền BGĐ CN – CA lead trả lại (1) → CA chỉnh sửa, gửi lại – LC được phát hành
- Biến thể: TC 35, row 36 — Luồng (1) – Đề xuất phê duyệt - Không cần thẩm quyền BGĐ CN – CRC trả lại (1) CA → CA chỉnh sửa, gửi lại – LC được phát hành
- Biến thể: TC 36, row 37 — Luồng (1) – Đề xuất phê duyệt - Không cần thẩm quyền BGĐ CN – CRC lead trả lại (1) → CRC chỉnh sửa, gửi lại – LC được phát hành
- Biến thể: TC 37, row 38 — Luồng (1) – Đề xuất phê duyệt - Không cần thẩm quyền BGĐ CN – TI trả lại CRC → CRC chỉnh sửa, gửi lại – LC được phát hành

*Không có edge case riêng – dùng chung edge case của các happy case trên.*

## Happy case 3 – Đề xuất phê duyệt, CÓ thẩm quyền BGĐ CN: … → BGĐ CN duyệt & ký số điện → TI → Hoàn thành

- E2E: **TC 18, row 19** — Luồng (1) – Đề xuất phê duyệt - Có thẩm quyền BGĐ CN – FO yêu cầu điện phát hành bản không ký số – FO không chọn giao dịch chuyển khẩu/tạm nhập tái xuất → Hoàn thành
- Biến thể: TC 19, row 20 — Luồng (1) – Đề xuất phê duyệt - Có thẩm quyền BGĐ CN – FO yêu cầu bản điện tử có ký số – BGĐ CN ký – FO không chọn giao dịch chuyển khẩu/tạm nhập tái xuất → Hoàn thành
- Biến thể: TC 20, row 21 — Luồng (1) – Đề xuất phê duyệt - Có thẩm quyền BGĐ CN – FO yêu cầu điện phát hành bản không ký số – FO có chọn giao dịch chuyển khẩu/tạm nhập tái xuất → Hoàn thành - Chờ bổ sung hồ sơ
- Biến thể: TC 21, row 22 — Luồng (1) – Đề xuất phê duyệt - Có thẩm quyền BGĐ CN – FO yêu cầu bản điện tử có ký số – BGĐ CN ký – FO có chọn giao dịch chuyển khẩu/tạm nhập tái xuất → Hoàn thành - Chờ bổ sung hồ sơ
- Biến thể: TC 22, row 23 — Luồng (1) – Đề xuất phê duyệt - Có thẩm quyền BGĐ CN – BGĐ CN trả lại (1) CRC → CRC chỉnh sửa, gửi lại – LC được phát hành

### Edge cases

#### B11 · BGĐ CN – Phê duyệt, Trả lại, Xem file (28)

1. [Danh sách] Lưới chức năng – Kiểm tra quyền truy cập → Mặc định hiển thị toàn bộ GD "Đề nghị phát hành LC" gửi tới CN theo Đ… — *TC 1453, row 1454*
2. [Danh sách] Lưới chức năng – Kiểm tra counter tab Tất cả/Cần xử lý/Đang theo dõi/Đã hoàn thành → 1. Số lượng Counter = số bản ghi của từng tab 2. Số … — *TC 1454, row 1455*
3. [Phê duyệt] Lịch sử giao dịch – Kiểm tra user thực hiện → User thuộc BGĐ CN và có quyền phê duyệt — *TC 1455, row 1456*
4. [Phê duyệt] Popup – Kiểm tra khi nhấn nút Phê duyệt → 1. Hệ thống thực hiện phê duyệt giao dịch thành công: hiển thị thông … — *TC 1456, row 1457*
5. [Phê duyệt ĐXTC] Popup – Kiểm tra khi nhấn nút Phê duyệt → 1. Hệ thống thực hiện phê duyệt giao dịch thành công: hiển thị thông … — *TC 1457, row 1458*
6. [Phê duyệt ĐXTC] Popup – Kiểm tra khi nhấn nút Phê duyệt → 1. Hệ thống thực hiện phê duyệt giao dịch thành công: hiển thị thông … — *TC 1458, row 1459*
7. [Trả lại] Xem file tác nghiệp – Kiểm tra user thực hiện → user thuộc BGD CN và có quyền phê duyệt — *TC 1459, row 1460*
8. [Trả lại] Trả lại – Kiểm tra khi nhấn nút → - Cho phép nhập tối đa 2000 ký tự → Trường bắt buộc nhập - Nếu không … — *TC 1460, row 1461*
9. [Trả lại] Kiểm tra trường Ô nhập thông tin → Hiển thị placeholder “Lý do trả lại” Giá trị = rỗng Trường bắt buộc — *TC 1461, row 1462*
10. [Trả lại] Kiểm tra trường Ô nhập thông tin → Cho phép nhập số nguyên, số thập phân, giá trị text và các ký tự dặc … — *TC 1462, row 1463*
11. [Trả lại] Kiểm tra trường Ô nhập thông tin → Không cho phép nhập/paste vượt quá 2000 ký tự Hệ thống tự động cắt nộ… — *TC 1463, row 1464*
12. [Trả lại] Kiểm tra trường Ô nhập thông tin → Hệ thống tự động trimspace đầu cuối — *TC 1464, row 1465*
13. [Trả lại] Kiểm tra trường Ô nhập thông tin → Hiển thị "Vui lòng nhập thông tin Lý do trả lại" — *TC 1465, row 1466*
14. [Trả lại] Hạn mức còn được sử dụng – Trả lại giao dịch thành công → 1. Hệ thống show msg "Đã trả lại thành công. Bạn có thể xem trạng thá… — *TC 1466, row 1467*
15. [Trả lại] Thời hạn duy trì hạn mức – Trả lại giao dịch thành công → 1. Hệ thống show msg "Đã trả lại thành công. Bạn có thể xem trạng thá… — *TC 1467, row 1468*
16. [Trả lại] 3. Kiểm tra tính đầy đủ, hợp lệ của Hồ sơ – Trả lại giao dịch thành công → 1. Hệ thống show msg "Đã trả lại thành công. Bạn có thể xem trạn… — *TC 1468, row 1469*
17. [Trả lại] 4. Kiểm tra sự phù hợp với mục đích cấp tín dụng và các điều kiện cấp tín dụng đã được phê duyệt và/hoặc HĐTD đã ký – Trả lại giao dịch thấ… — *TC 1469, row 1470*
18. [Xem file tác nghiệp] Xem file tác nghiệp – Kiểm tra nhấn nút → Hiển thị 2 file: (1) File TBTN (.pdf) (2) File YCXL giao dịch (.doc) — *TC 1470, row 1471*
19. [Xem file tác nghiệp] File TBTN (.pdf) – Kiểm tra nhấn nút → 1. Hệ thống mở màn hình xem chi tiết file theo định dạng đã chọn với … — *TC 1471, row 1472*
20. [Xem file tác nghiệp] File YCXL giao dịch (.doc) – Kiểm tra nhấn nút → - Hệ thống mở màn hình view file và cho phép tải xuống và có tên fiel… — *TC 1472, row 1473*
21. [Xem file tác nghiệp] Cấp Thẩm quyền – Kiểm tra thông tin gen file → - Hiển thị đúng họ và tên BGĐ CN thực hiện phê duyệt đang login:[Full… — *TC 1473, row 1474*
22. [BGD CN_Xem file tác nghiệp] V. PHÊ DUYỆT CỦA CẤP THẨM QUYỀN – Kiểm tra thông tin gen file → Hệ thống hiển thị nội dung mục V. = thông tin lãnh đạo C… — *TC 1474, row 1475*
23. [Xem file tác nghiệp] Yêu cầu xử lý giao dịch – Kiểm tra thời điểm gen → Hệ thống gen file Yêu cầu xử lý giao dịch với nội dung các trường thô… — *TC 1475, row 1476*
24. [Tải hồ sơ KH] Tải hồ sơ khách hàng – Kiểm tra khi nhấn nút → - Hệ thống cho phép tải xuống các tài liệu khách hàng - Tên file: HSK… — *TC 1476, row 1477*
25. [Xem chi tiết] Kết quả xử lý giao dịch – Kiểm tra thông tin tab Điện phát hành LC → Hiển thị các trường thông tin: - Số tham chiếu LC - label (số trả… — *TC 1477, row 1478*
26. [Xem chi tiết] Số tham chiếu LC – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị dữ liệu master ref (TI) trả về lấy thông tin tại trường Mast… — *TC 1478, row 1479*
27. [Xem chi tiết] File Thông báo thu phí – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị file Thông báo thu phí — *TC 1479, row 1480*
28. [Xem chi tiết] File Điện phát hành LC – Kiểm tra thông tin tab Điện phát hành L/C → Điều kiện: Trong Q2: có event = , step = Authorise , status = com… — *TC 1480, row 1481*

#### B12 · BGĐ CN – Phê duyệt & Ký số Điện phát hành LC (6)

1. [Phê duyệt Điện phát hành LC] Đã in nội dung điện SWIFT mở L/C theo kết quả xử lý của Trung tâm TTTM – Kiểm tra user thực hiện → User thuộc BGD CN và… — *TC 1481, row 1482*
2. [Ký số cá nhân Điện phát hành LC] Ký số cá nhân – Kiểm tra khi nhấn nút → - Hiển thị khung preview văn bản, cho phép người dùng xem lại nội dun… — *TC 1482, row 1483*
3. [Ký số cá nhân Điện phát hành LC] Ký số cá nhân – Kiểm tra nội dung preview → Hiển thị đúng thông tin/Nội dung Điện phát hành LC TI trả về Cho phép… — *TC 1483, row 1484*
4. [Ký số cá nhân Điện phát hành LC] Ký số online – Kiểm tra khi nhấn nút → 1. Hệ thống ETL từ AVS sang EG để kiểm tra thông tin banker user gắn … — *TC 1484, row 1485*
5. [Ký số cá nhân Điện phát hành LC] Ký số USB – Kiểm tra khi nhấn nút → 1. Người dùng thao tác ký số thành công, hiển thị màn hình thông báo … — *TC 1485, row 1486*
6. [Ký số pháp nhân Điện phát hành LC] Kiểm tra chức năng Ký số pháp nhân → - Hệ thống call API ký số pháp nhân tự động trên BO. Hệ thống tự động… — *TC 1486, row 1487*

#### B15 · BGĐ CN – Chờ ký số điện LC: Phê duyệt & Ký số (thuộc thẩm quyền BGĐ CN) (23)

1. [Danh sách] Chọn tệp tin – Kiểm tra các trường hợp tải file đính kèm của khách hàng → Mặc định hiển thị toàn bộ GD gửi tới CN theo HĐHMPHLC 0. Tất cả… — *TC 1542, row 1543*
2. [Danh sách] Chọn tệp tin – Kiểm tra counter tab Tất cả/Cần xử lý/Đang theo dõi/Đã hoàn thành → 1. Số lượng Counter = số bản ghi của từng tab 2. Số lư… — *TC 1543, row 1544*
3. [Xem chi tiết] Chọn tệp tin – Kiểm tra thông tin hiển thị trên màn hình → Hiển thị dữ liệu: 1. Các trường thông tin: Hiển thị đúng các trường t… — *TC 1544, row 1545*
4. [Xem chi tiết] Chọn tệp tin – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị các trường thông tin: - Số tham chiếu LC - label (số trả ra … — *TC 1545, row 1546*
5. [Xem chi tiết] Lịch sử giao dịch – Kiểm tra chức năng khi người dùng click vào → Hiển thị popup có các trường thông tin và hiển thị giá trị tương ứng… — *TC 1546, row 1547*
6. [Xem chi tiết] Lịch sử giao dịch – Kiểm tra các hành động lưu lại lịch sử → Khi người dùng thực hiện các chức năng dưới đây: 1. FO duyệt cuối (tr… — *TC 1547, row 1548*
7. [Phê duyệt] Phê duyệt – Kiểm tra hiển thị nút → Hiển thị nút <Phê duyệt> — *TC 1548, row 1549*
8. [Phê duyệt] Popup – Kiểm tra khi nhấn nút Phê duyệt → - Hiển thị màn hình chức năng ký số cá nhân, xem chi tiết có nút <Ký … — *TC 1549, row 1550*
9. [Phê duyệt] Duyệt và Gửi duyệt – Kiểm tra hiển thị nút → Hiển thị nút <Duyệt và Gửi duyệt> — *TC 1550, row 1551*
10. [Phê duyệt] Popup – Kiểm tra khi nhấn nút Phê duyệt → 1. Hệ thống thực hiện phê duyệt giao dịch thành công: hiển thị thông … — *TC 1551, row 1552*
11. [Xem file tác nghiệp] Xem file tác nghiệp – Kiểm tra nhấn nút → Hiển thị 2 file: (1) File TBTN (.pdf) (2) File YCXL giao dịch (.doc) — *TC 1552, row 1553*
12. [Xem file tác nghiệp] File TBTN (.pdf) – Kiểm tra nhấn nút → 1. Hệ thống mở màn hình xem chi tiết file theo định dạng đã chọn với … — *TC 1553, row 1554*
13. [Xem file tác nghiệp] File YCXL giao dịch (.doc) – Kiểm tra nhấn nút → - Hệ thống mở màn hình view file và cho phép tải xuống và có tên fiel… — *TC 1554, row 1555*
14. [Xem file tác nghiệp] File YCXL giao dịch (.doc) – Kiểm tra nhấn nút → - Hệ thống mở màn hình view file và cho phép tải xuống và có tên fiel… — *TC 1555, row 1556*
15. [Xem file tác nghiệp] Lãnh đạo CRC – Kiểm tra thông tin gen file → - Hiển thị đúng họ và tên lãnh đạo CRC thực hiện phê duyệt đang login… — *TC 1556, row 1557*
16. [LD CRC_Xem file tác nghiệp] V. PHÊ DUYỆT CỦA CẤP THẨM QUYỀN – Kiểm tra thông tin gen file → Hệ thống hiển thị nội dung = thông tin lãnh đạo CRC khi … — *TC 1557, row 1558*
17. [Xem file YCXL] Yêu cầu xử lý giao dịch – Kiểm tra thời điểm gen → Hệ thống gen file Yêu cầu xử lý giao dịch với nội dung các trường thô… — *TC 1558, row 1559*
18. [Xem file YCXL] Yêu cầu xử lý giao dịch – Kiểm tra TH hiển thị nội dung mục V. TÁC NGHIỆP CỦA BỘ PHẬN CRC → Chưa hiển thị nội dung mục này — *TC 1559, row 1560*
19. [Tải hồ sơ KH] Tải hồ sơ khách hàng – Kiểm tra khi nhấn nút → - Hệ thống cho phép tải xuống các tài liệu khách hàng - Tên file: HSK… — *TC 1560, row 1561*
20. [Ký số cá nhân điện phát hành LC] Ký số cá nhân – Kiểm tra khi nhấn nút → - Hiển thị khung preview văn bản, cho phép người dùng xem lại nội dun… — *TC 1561, row 1562*
21. [Ký số cá nhân điện phát hành LC] Ký số online – Kiểm tra khi nhấn nút → 1. Hệ thống ETL từ AVS sang EG để kiểm tra thông tin banker user gắn … — *TC 1562, row 1563*
22. [Ký số cá nhân điện phát hành LC] Ký số USB – Kiểm tra khi nhấn nút → 1. Người dùng thao tác ký số thành công, hiển thị màn hình thông báo … — *TC 1563, row 1564*
23. [Ký số pháp nhân điện phát hành LC] Xác nhận bổ sung – Kiểm tra chức năng Ký số pháp nhân → - Hệ thống call API ký số pháp nhân tự động trên BO. Hệ t… — *TC 1564, row 1565*

## Happy case 4 – Đề xuất từ chối, KHÔNG cần thẩm quyền BGĐ CN (lãnh đạo trả lại / duyệt đề xuất từ chối)

- E2E: **TC 54, row 55** — Luồng (2) – Đề xuất từ chối - Không cần thẩm quyền BGĐ CN – CA lead trả lại (2) → CA chỉnh sửa, gửi lại đề xuất (1) – LC được phát hành
- Biến thể: TC 55, row 56 — Luồng (2) – Đề xuất từ chối - Không cần thẩm quyền BGĐ CN – CRC lead trả lại (2) → CRC chỉnh sửa, gửi lại đề xuất (1) – LC được phát hành
- Biến thể: TC 56, row 57 — Luồng (2) – Đề xuất từ chối - Không cần thẩm quyền BGĐ CN – CA lead trả lại (2) → CA chỉnh sửa, gửi lại đề xuất từ chối (2) – Đề xuất từ chối được gửi lại và phê duyệt
- Biến thể: TC 57, row 58 — Luồng (2) – Đề xuất từ chối - Không cần thẩm quyền BGĐ CN – CRC lead trả lại (2) → CRC chỉnh sửa, gửi lại đề xuất từ chối (2) – Đề xuất từ chối được gửi lại và phê duyệt
- Biến thể: TC 58, row 59 — Luồng (2) – Đề xuất từ chối - Không cần thẩm quyền BGĐ CN – CA lead phê duyệt (2), không thuộc thẩm quyền BGĐ CN → quay lại CA, CA chỉnh sửa và gửi duyệt lại – Giao dịch quay lại CA, được chỉnh sửa v…
- Biến thể: TC 59, row 60 — Luồng (2) – Đề xuất từ chối - Không cần thẩm quyền BGĐ CN – CA lead phê duyệt (2), không thuộc thẩm quyền BGĐ CN → quay lại CA, CA trả lại Doanh nghiệp → FO sửa, gửi lại – Giao dịch được FO sửa và gử…
- Biến thể: TC 60, row 61 — Luồng (2) – Đề xuất từ chối - Không cần thẩm quyền BGĐ CN – CRC lead phê duyệt (2), không thuộc thẩm quyền BGĐ CN → quay lại CA, CA chỉnh sửa và gửi duyệt lại – Giao dịch quay lại CA, được chỉnh sửa …
- Biến thể: TC 61, row 62 — Luồng (2) – Đề xuất từ chối - Không cần thẩm quyền BGĐ CN – CRC lead phê duyệt (2), không thuộc thẩm quyền BGĐ CN → quay lại CA, CA trả lại Doanh nghiệp → FO sửa, gửi lại – Giao dịch được FO sửa và g…

*Không có edge case riêng – dùng chung edge case của các happy case trên.*

## Happy case 5 – Đề xuất từ chối, CÓ thẩm quyền BGĐ CN

- E2E: **TC 42, row 43** — Luồng (2) – Đề xuất từ chối - Có thẩm quyền BGĐ CN – BGĐ CN trả lại (2) đề xuất của CA → CA chỉnh sửa, gửi lại đề xuất (1) – LC được phát hành
- Biến thể: TC 43, row 44 — Luồng (2) – Đề xuất từ chối - Có thẩm quyền BGĐ CN – BGĐ CN trả lại (2) đề xuất của CRC → CRC chỉnh sửa, gửi lại đề xuất (1) – LC được phát hành
- Biến thể: TC 44, row 45 — Luồng (2) – Đề xuất từ chối - Có thẩm quyền BGĐ CN – BGĐ CN trả lại (2) đề xuất của CA → CA chỉnh sửa, gửi lại đề xuất từ chối (2) – Đề xuất từ chối được gửi lại tới BGĐ CN
- Biến thể: TC 45, row 46 — Luồng (2) – Đề xuất từ chối - Có thẩm quyền BGĐ CN – BGĐ CN trả lại (2) đề xuất của CRC → CRC chỉnh sửa, gửi lại đề xuất từ chối (2) – Đề xuất từ chối được gửi lại tới BGĐ CN
- Biến thể: TC 46, row 47 — Luồng (2) – Đề xuất từ chối - Có thẩm quyền BGĐ CN – CA lead gửi BGĐ CN, BGĐ CN phê duyệt (2) → quay lại CA, CA chỉnh sửa và gửi duyệt lại – Giao dịch quay lại CA, được chỉnh sửa và gửi duyệt lại
- Biến thể: TC 47, row 48 — Luồng (2) – Đề xuất từ chối - Có thẩm quyền BGĐ CN – CA lead gửi BGĐ CN, BGĐ CN phê duyệt (2) → quay lại CA, CA trả lại Doanh nghiệp → FO sửa, gửi lại – Giao dịch được FO sửa và gửi lại BO
- Biến thể: TC 48, row 49 — Luồng (2) – Đề xuất từ chối - Có thẩm quyền BGĐ CN – CRC lead phê duyệt (2), thuộc thẩm quyền BGĐ CN → BGĐ CN phê duyệt (2) → quay lại CA, CA chỉnh sửa và gửi duyệt lại – Giao dịch quay lại CA, được …
- Biến thể: TC 49, row 50 — Luồng (2) – Đề xuất từ chối - Có thẩm quyền BGĐ CN – CRC lead phê duyệt (2), thuộc thẩm quyền BGĐ CN → BGĐ CN phê duyệt (2) → quay lại CA, CA trả lại Doanh nghiệp → FO sửa, gửi lại – Giao dịch được F…

*Không có edge case riêng – dùng chung edge case của các happy case trên.*

## Happy case 6 – Sau phát hành: Hoàn thành – Chờ bổ sung hồ sơ → Hồ sơ hậu kiểm → Xác nhận hoàn thành

- *Không có TC E2E trong file gốc cho luồng này.*

### Edge cases

#### B16 · Hậu kiểm – Hoàn thành, chờ bổ sung hồ sơ (16)

1. [Danh sách] Tích hợp – Kiểm tra đẩy thông tin file lên ECM tại folder Temp → Mặc định hiển thị toàn bộ GD gửi tới CN theo HĐHMPHLC 0. Tất cả = Tất… — *TC 1565, row 1566*
2. [Danh sách] Xác nhận hoàn thành – Kiểm tra counter tab Tất cả/Cần xử lý/Đang theo dõi/Đã hoàn thành → 1. Số lượng Counter = số bản ghi của từng tab 2… — *TC 1566, row 1567*
3. [Xem chi tiết] Xác nhận hoàn thành – Kiểm tra thông tin hiển thị trên màn hình → Hiển thị dữ liệu: 1. Các trường thông tin: Hiển thị đúng các trường … — *TC 1567, row 1568*
4. [Xem chi tiết] Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị các trường thông tin: - Số tham chiếu LC - label (số trả ra … — *TC 1568, row 1569*
5. [Xem chi tiết] Kiểm tra thông tin tab Hồ sơ hậu kiểm → Hiển thị các trường thông tin: - Danh mục bổ sung lần - label: Hiển t… — *TC 1569, row 1570*
6. [Xem chi tiết] Lịch sử giao dịch – Kiểm tra chức năng khi người dùng click vào → Hiển thị popup có các trường thông tin và hiển thị giá trị tương ứng… — *TC 1570, row 1571*
7. [Xem chi tiết] Lịch sử giao dịch – Kiểm tra các hành động lưu lại lịch sử → Khi người dùng thực hiện các chức năng dưới đây: 1. FO duyệt cuối (tr… — *TC 1571, row 1572*
8. [Hồ sơ hậu kiểm] Kiểm tra trường Loại hồ sơ → 1. Hiển thị danh mục các loại tài liệu được cấu hình trong hệ thống t… — *TC 1572, row 1573*
9. [Hồ sơ hậu kiểm] Kiểm tra trường Loại hồ sơ → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thông tin] — *TC 1573, row 1574*
10. [Hồ sơ hậu kiểm] Kiểm tra trường Hình thức → Cho phép chọn 1 trong các giá trị: 1. Ký số 2. Không ký số — *TC 1574, row 1575*
11. [Hồ sơ hậu kiểm] Kiểm tra trường Hình thức → Hiển thị MSG "Vui lòng chọn" + [Trường thông tin] — *TC 1575, row 1576*
12. [Xác nhận bổ sung theo lượt] Xác nhận bổ sung – Kiểm tra khi nhấn <Xác nhận bổ sung> → 1. Lưu thông tin hồ sơ upload, hiển thị lên màn hình theo dạng… — *TC 1576, row 1577*
13. [Xác nhận bổ sung theo lượt] Xác nhận bổ sung – Kiểm tra validate khi bỏ trống trường bắt buộc → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thôn… — *TC 1577, row 1578*
14. [Xác nhận bổ sung theo lượt] Tích hợp – Kiểm tra đẩy thông tin file lên ECM tại folder Temp → Hệ thống call API tới ECM để đẩy danh sách file của ngư… — *TC 1578, row 1579*
15. [Xác nhận hoàn thành] Xác nhận hoàn thành – Kiểm tra khi nhấn <Xác nhận hoàn thành> → 1. Lưu thông tin hồ sơ upload, hiển thị lên màn hình theo dạng … — *TC 1579, row 1580*
16. [Xác nhận hoàn thành] Xác nhận hoàn thành – Kiểm tra validate khi bỏ trống trường bắt buộc → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thông ti… — *TC 1580, row 1581*

## Luồng lỗi E2E (LC không được phát hành / lỗi tích hợp)

1. Luồng (1) – Đề xuất phê duyệt - Có thẩm quyền BGĐ CN – CA từ chối – LC không được phát hành — *TC 23, row 24*
2. Luồng (1) – Đề xuất phê duyệt - Có thẩm quyền BGĐ CN – CA trả lại → Doanh nghiệp hủy đề nghị – LC không được phát hành — *TC 24, row 25*
3. Luồng (1) – Đề xuất phê duyệt - Có thẩm quyền BGĐ CN – CA trả lại → FO Reviewer/Approver từ chối – LC không được phát hành — *TC 25, row 26*
4. Luồng (1) – Đề xuất phê duyệt - Có thẩm quyền BGĐ CN – BGĐ CN phê duyệt → đẩy sang TI lỗi tích hợp – Trạng thái giữ nguyên – cho phép phê duyệt lại — *TC 26, row 27*
5. Luồng (1) – Đề xuất phê duyệt - Không cần thẩm quyền BGĐ CN – CA từ chối – LC không được phát hành — *TC 38, row 39*
6. Luồng (1) – Đề xuất phê duyệt - Không cần thẩm quyền BGĐ CN – CA trả lại → Doanh nghiệp hủy đề nghị – LC không được phát hành — *TC 39, row 40*
7. Luồng (1) – Đề xuất phê duyệt - Không cần thẩm quyền BGĐ CN – CA trả lại → FO Reviewer/Approver từ chối – LC không được phát hành — *TC 40, row 41*
8. Luồng (1) – Đề xuất phê duyệt - Không cần thẩm quyền BGĐ CN – CRC lead phê duyệt (không thuộc thẩm quyền BGĐ CN) → đẩy sang TI lỗi tích hợp – Trạng thái giữ nguyên – cho phép phê duyệt lại — *TC 41, row 42*
9. Luồng (2) – Đề xuất từ chối - Có thẩm quyền BGĐ CN – CA lead gửi BGĐ CN, BGĐ CN phê duyệt (2) → CA từ chối – LC không được phát hành — *TC 50, row 51*
10. Luồng (2) – Đề xuất từ chối - Có thẩm quyền BGĐ CN – CRC lead phê duyệt (2), thuộc thẩm quyền BGĐ CN → BGĐ CN phê duyệt (2) → CA từ chối – LC không được phát hành — *TC 51, row 52*
11. Luồng (2) – Đề xuất từ chối - Có thẩm quyền BGĐ CN – CA lead gửi BGĐ CN, BGĐ CN phê duyệt (2) → quay lại CA, CA trả lại Doanh nghiệp → Doanh nghiệp hủy đề nghị – LC không được phát hành — *TC 52, row 53*
12. Luồng (2) – Đề xuất từ chối - Có thẩm quyền BGĐ CN – CRC lead phê duyệt (2), thuộc thẩm quyền BGĐ CN → BGĐ CN phê duyệt (2) → quay lại CA, CA trả lại Doanh nghiệp → Doanh nghiệp hủy đề nghị – LC khôn… — *TC 53, row 54*
13. Luồng (2) – Đề xuất từ chối - Không cần thẩm quyền BGĐ CN – CA lead phê duyệt (2), không thuộc thẩm quyền BGĐ CN → CA từ chối – LC không được phát hành — *TC 62, row 63*
14. Luồng (2) – Đề xuất từ chối - Không cần thẩm quyền BGĐ CN – CRC lead phê duyệt (2), không thuộc thẩm quyền BGĐ CN → CA từ chối – LC không được phát hành — *TC 63, row 64*
15. Luồng (2) – Đề xuất từ chối - Không cần thẩm quyền BGĐ CN – CA lead phê duyệt (2), không thuộc thẩm quyền BGĐ CN → quay lại CA, CA trả lại Doanh nghiệp → Doanh nghiệp hủy đề nghị – LC không được phát… — *TC 64, row 65*
16. Luồng (2) – Đề xuất từ chối - Không cần thẩm quyền BGĐ CN – CRC lead phê duyệt (2), không thuộc thẩm quyền BGĐ CN → quay lại CA, CA trả lại Doanh nghiệp → Doanh nghiệp hủy đề nghị – LC không được phá… — *TC 65, row 66*

