# BO – Test case automate được

Nguồn: `VCB_TradeFlat_Testcase_SIT_LC_ISS_Phat Hanh v1.1 (1).xlsx`, sheet `Tinh chỉnh`. **Row** = số dòng trong Excel.

**573 / 783 TC BO** (không tính E2E) không cần ký số, TI, email, DB, đọc nội dung file sinh ra, và không phụ thuộc trạng thái sau ký số. Phần còn lại xem `BO_automation_blockers.md`.

**Vẫn cần:** đề nghị FO ở trạng thái *Đã gửi ngân hàng* làm dữ liệu đầu vào (seed hoặc chuẩn bị tay), và user cho từng vai trò BO. Các bước sau (CRC, CRC lead, BGĐ CN) cần bản ghi đã qua bước trước – đi được bằng UI vì các bước duyệt BO không cần OTP/ký số.

## Tóm tắt

| Bước | Số TC |
|---|---|
| B01 · Danh sách, phân trang, bộ lọc (chung) | 66 |
| B02 · Xem chi tiết hồ sơ (chung) | 142 |
| B03 · CA – Tiếp nhận & Xử lý tác nghiệp | 146 |
| B04 · CA – Gửi duyệt / Trả lại khách hàng / Từ chối | 7 |
| B05 · CA – Xem TBTN, tải hồ sơ khách hàng | 1 |
| B06 · CA lead – Phê duyệt, Phê duyệt ĐXTC, Trả lại, Phân công lại, Xem TBTN | 14 |
| B07 · CRC – Danh sách, tiếp nhận, xử lý tác nghiệp | 57 |
| B08 · CRC – Yêu cầu xử lý giao dịch (YCXL) | 84 |
| B09 · CRC – Gửi duyệt / Trả lại / Xem file tác nghiệp | 6 |
| B10 · CRC lead – Phê duyệt, Phê duyệt ĐXTC, Trả lại, Phân công lại, Xem file | 19 |
| B11 · BGĐ CN – Phê duyệt, Trả lại, Xem file | 14 |
| B12 · BGĐ CN – Phê duyệt & Ký số Điện phát hành LC | 1 |
| B14 · CRC lead – Chờ ký số điện LC: Phê duyệt & Ký số (không thuộc thẩm quyền BGĐ CN) | 8 |
| B15 · BGĐ CN – Chờ ký số điện LC: Phê duyệt & Ký số (thuộc thẩm quyền BGĐ CN) | 8 |
| **Tổng** | **573** |

## B01 · Danh sách, phân trang, bộ lọc (chung) (66)

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
13. [List] Quan sát cột Số tiền L/C – Kiểm tra dữ liệu hiển thị → - Hiển thị chính xác thông tin số tiền L/C - Căn lề phải - Format: xx… — *TC 811, row 812*
14. [List] Quan sát cột Loại tiền – Kiểm tra dữ liệu hiển thị → Hiển thị chính xác thông tin loại tiền L/C - Format: {VND} - Nối chuỗ… — *TC 812, row 813*
15. [List] Quan sát cột Kênh đề nghị – Kiểm tra dữ liệu hiển thị → Hiển thị đúng Tên kênh đề nghị — *TC 813, row 814*
16. [List] Quan sát cột Kênh đề nghị – Kiểm tra hiển thị khi dữ liệu chứa nội dung dài hơn độ rộng của cột → Hiển thị dấu (...) ở phía cuối, nơi dữ liệu … — *TC 814, row 815*
17. [List] Quan sát cột Kênh đề nghị – Kiểm tra nội dung hiển thị khi hover vào nội dung dài và có dấu (...) → Hiển thị tooltip và đầy đủ nội dung của tr… — *TC 815, row 816*
18. [List] Quan sát cột Ngày đề nghị – Kiểm tra dữ liệu hiển thị → Hiển thị [Ngày đề nghị] là thời gian Khách hàng ký số pháp nhân thành… — *TC 816, row 817*
19. [List] Gõ từ khóa tìm kiếm vào ô tìm kiếm nhanh – Kiểm tra chức năng → Hiển thị danh sách tương ứng — *TC 819, row 820*
20. [List] Column Setting – Kiểm tra chức năng → Hệ thống hiển thị/ẩn các cột theo cấu hình đã lựa chọn - thứ tự và th… — *TC 820, row 821*
21. [List] Nhập/chọn các tiêu chí tìm kiếm ở Filter Table – Kiểm tra chức năng → Hệ thống hiển thị danh sách các bản ghi phù hợp với điều kiện lọc Cho… — *TC 821, row 822*
22. [List] Download Grid – Kiểm tra chức năng → Hệ thống tải xuống file dữ liệu thành công - dữ liệu trong file đầy đ… — *TC 822, row 823*
23. [Phân trang] Kiểm tra trường Row number → Hệ thống tự động hiển thị 10, 20, 30, 50 bản ghi trên danh sách tương… — *TC 823, row 824*
24. [Phân trang] Previous – Kiểm tra hoạt động → Hệ thống hiển thị danh sách trang kế trước — *TC 824, row 825*
25. [Phân trang] Next – Kiểm tra hoạt động → Hệ thống hiển thị danh sách trang tiếp theo — *TC 825, row 826*
26. [Phân trang] Page line – Kiểm tra hoạt động → Hệ thống hiển thị đúng màn hình danh sách trang đã chọn — *TC 826, row 827*
27. [Xem chi tiết] File Điện phát hành LC – Kiểm tra thông tin tab Điện phát hành L/C → Điều kiện: Trong Q2: có event = issue , step = Authorise , status… — *TC 829, row 830*
28. [Xem chi tiết] Lịch sử giao dịch – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị các trường thông tin và hiển thị giá trị tương ứng: - Hành đ… — *TC 830, row 831*
29. [Xem chi tiết] Lịch sử giao dịch – Kiểm tra các hành động lưu lại lịch sử → Khi người dùng thực hiện các chức năng dưới đây 1. FO duyệt cuối (trư… — *TC 831, row 832*
30. [Bộ lọc] Tìm kiếm – Kiểm tra kết quả khi người dùng click vào nút → Hệ thống hiển thị kết quả tìm kiếm chính xác theo điều kiện lọc: - Đi… — *TC 832, row 833*
31. [Bộ lọc] Đặt lại – Kiểm tra kết quả khi người dùng click vào nút → Hệ thống xóa dữ liệu đã nhập tại các trường thông tin > Trả lại màn d… — *TC 833, row 834*
32. [Bộ lọc] Kiểm tra trường Mã đề nghị → - Hiển thị danh sách kết quả tương ứng với điều kiện đã chọn - Hiển t… — *TC 834, row 835*
33. [Bộ lọc] Kiểm tra trường Mã đề nghị → Hệ thống không cho phép nhập khoảng trắng Hệ thống tự động trim khoản… — *TC 835, row 836*
34. [Bộ lọc] Kiểm tra trường Mã đề nghị → Cho phép copy paste Hiển thị dữ liệu đã copy paste — *TC 836, row 837*
35. [Bộ lọc] Kiểm tra trường CIF → - Hiển thị danh sách kết quả tương ứng với điều kiện đã chọn - Hiển t… — *TC 837, row 838*
36. [Bộ lọc] Kiểm tra trường CIF → Hệ thống không cho phép nhập khoảng trắng Hệ thống tự động trim khoản… — *TC 838, row 839*
37. [Bộ lọc] Kiểm tra trường CIF → Cho phép copy paste Hiển thị dữ liệu đã copy paste — *TC 839, row 840*
38. [Bộ lọc] Kiểm tra trường Tên bên đề nghị → - Hiển thị danh sách kết quả tương ứng với điều kiện đã chọn - Hiển t… — *TC 840, row 841*
39. [Bộ lọc] Kiểm tra trường Tên bên đề nghị → Hệ thống không cho phép nhập khoảng trắng Hệ thống tự động trim khoản… — *TC 841, row 842*
40. [Bộ lọc] Kiểm tra trường Tên bên đề nghị → Cho phép copy paste Hiển thị dữ liệu đã copy paste — *TC 842, row 843*
41. [Bộ lọc] Kiểm tra trường Số hợp đồng hạn mức → - Hiển thị danh sách kết quả tương ứng với điều kiện đã chọn - Hiển t… — *TC 843, row 844*
42. [Bộ lọc] Kiểm tra trường Số hợp đồng hạn mức → Hệ thống không cho phép nhập khoảng trắng Hệ thống tự động trim khoản… — *TC 844, row 845*
43. [Bộ lọc] Kiểm tra trường Số hợp đồng hạn mức → Cho phép copy paste Hiển thị dữ liệu đã copy paste — *TC 845, row 846*
44. [Bộ lọc] Kiểm tra trường Người thụ hưởng → - Hiển thị danh sách kết quả tương ứng với điều kiện đã chọn - Hiển t… — *TC 846, row 847*
45. [Bộ lọc] Kiểm tra trường Người thụ hưởng → Hệ thống không cho phép nhập khoảng trắng Hệ thống tự động trim khoản… — *TC 847, row 848*
46. [Bộ lọc] Kiểm tra trường Người thụ hưởng → Cho phép copy paste Hiển thị dữ liệu đã copy paste — *TC 848, row 849*
47. [Bộ lọc] Kiểm tra trường Số L/C → - Hiển thị danh sách kết quả tương ứng với điều kiện đã chọn - Hiển t… — *TC 849, row 850*
48. [Bộ lọc] Kiểm tra trường Số L/C → Hệ thống không cho phép nhập khoảng trắng Hệ thống tự động trim khoản… — *TC 850, row 851*
49. [Bộ lọc] Kiểm tra trường Số L/C → Cho phép copy paste Hiển thị dữ liệu đã copy paste — *TC 851, row 852*
50. [Bộ lọc] Kiểm tra trường Số tiền → Hệ thống không cho phép nhập khoảng trắng Hệ thống tự động trim khoản… — *TC 852, row 853*
51. [Bộ lọc] Kiểm tra trường Số tiền → Cho phép copy paste Hiển thị dữ liệu đã copy paste — *TC 853, row 854*
52. [Bộ lọc] Kiểm tra trường Số tiền → - Chỉ cho phép nhập số và lớn hơn hoặc bằng 0 - Không cho phép nhập k… — *TC 854, row 855*
53. [Bộ lọc] Kiểm tra trường Ngày đề nghị → 1. Hiển thị danh sách kết quả tương ứng với ngày đã chọn 2. Hệ thống … — *TC 855, row 856*
54. [Bộ lọc] Kiểm tra trường Ngày đề nghị → Hệ thống không cho phép nhập khoảng trắng Hệ thống tự động trim khoản… — *TC 856, row 857*
55. [Bộ lọc] Kiểm tra trường Ngày đề nghị → Cho phép copy paste Hiển thị dữ liệu đã copy paste — *TC 857, row 858*
56. [Bộ lọc] Kiểm tra trường Ngày phát hành → 1. Hiển thị danh sách kết quả tương ứng với ngày đã chọn 2. Hệ thống … — *TC 858, row 859*
57. [Bộ lọc] Kiểm tra trường Ngày phát hành → Hệ thống không cho phép nhập khoảng trắng Hệ thống tự động trim khoản… — *TC 859, row 860*
58. [Bộ lọc] Kiểm tra trường Ngày phát hành → Cho phép copy paste Hiển thị dữ liệu đã copy paste — *TC 860, row 861*
59. [Bộ lọc] Kiểm tra trường Ngày hết hạn → 1. Hiển thị danh sách kết quả tương ứng với ngày đã chọn 2. Hệ thống … — *TC 861, row 862*
60. [Bộ lọc] Kiểm tra trường Ngày hết hạn → Hệ thống không cho phép nhập khoảng trắng Hệ thống tự động trim khoản… — *TC 862, row 863*
61. [Bộ lọc] Kiểm tra trường Ngày hết hạn → Cho phép copy paste Hiển thị dữ liệu đã copy paste — *TC 863, row 864*
62. [Bộ lọc] Kiểm tra trường Loại L/C → - Hiển thị danh sách kết quả tương ứng với điều kiện đã chọn - Hiển t… — *TC 864, row 865*
63. [Bộ lọc] Kiểm tra trường Trạng thái → - Hiển thị danh sách Trạng thái: Chờ tiếp nhận, CBTĐ xử lý, QLTĐ phê … — *TC 865, row 866*
64. [Bộ lọc] Kiểm tra trường Trạng thái → - Chỉ cho phép chữ Hoa/thường - Không cho phép nhập khoảng trắng hoặc… — *TC 866, row 867*
65. [List (Mới bổ sung)] Lưới chức năng – Kiểm tra hiển thị danh sách theo phân quyền user → Chỉ thấy các giao dịch phát hành LC thuộc phạm vi phân quyền… — *TC 867, row 868*
66. [List (Mới bổ sung)] Lưới chức năng – Kiểm tra counter tab Tất cả/Cần xử lý/Đang theo dõi/Đã hoàn thành → 1. Số lượng Counter = số bản ghi của từng t… — *TC 868, row 869*

## B02 · Xem chi tiết hồ sơ (chung) (142)

1. [Xem chi tiết] Hình thức phát hành LC – Kiểm tra thông tin hiển thị trên màn hình → Hiển thị dữ liệu: 1. Các trường thông tin: Hiển thị đúng các trườ… — *TC 869, row 870*
2. [Xem chi tiết] Lịch sử giao dịch – Kiểm tra chức năng khi người dùng click vào → Hiển thị popup có các trường thông tin và hiển thị giá trị tương ứng… — *TC 871, row 872*
3. [Xem chi tiết] Lịch sử giao dịch – Kiểm tra các hành động lưu lại lịch sử → Khi người dùng thực hiện các chức năng dưới đây: 1. FO duyệt cuối (tr… — *TC 872, row 873*
4. [Xem chi tiết] Tiêu đề/ Mã GD – Kiểm tra dữ liệu hiển thị → Hiển thị tiêu đề: "Đề nghị phát hành L/C [Mã GD]" — *TC 873, row 874*
5. [Xem chi tiết] Badge trạng thái – Kiểm tra giá trị hiển thị → Hiển thị chính xác trạng thái giao dịch = CBTĐ xử lý — *TC 874, row 875*
6. [Xem chi tiết] Ngày đề nghị – Kiểm tra giá trị hiển thị → Hiển thị ngày FO thao tác ký số thành công ở bước cuối và đẩy sang BO… — *TC 875, row 876*
7. [Xem chi tiết] Người đại diện hợp pháp – Kiểm tra giá trị hiển thị → Hiển thị Tên người dùng FO thao tác ký số thành công ở bước cuối và đ… — *TC 876, row 877*
8. [Xem chi tiết] Hồ sơ bị từ chối – Kiểm tra giá trị hiển thị → ❖ Hiển thị thông tin từ chối với giao dịch có TT = Từ chối ❖ Hiển thị… — *TC 877, row 878*
9. [Xem chi tiết] A. THÔNG TIN ĐỀ NGHỊ PHÁT HÀNH – Kiểm tra dữ liệu hiển thị → Hiển thị đúng tiêu đề: A. THÔNG TIN ĐỀ NGHỊ PHÁT HÀNH — *TC 878, row 879*
10. [Xem chi tiết] Thông tin khách hàng – Kiểm tra dữ liệu hiển thị → Hiển thị đúng tên trường <THÔNG TIN KHÁCH HÀNG> — *TC 879, row 880*
11. [Xem chi tiết] Mã khách hàng – Kiểm tra dữ liệu hiển thị → Hiển thị số CIF của khách hàng — *TC 880, row 881*
12. [Xem chi tiết] Tên công ty – Kiểm tra dữ liệu hiển thị → đây là thông tin khách hàng (theo CIF/hồ sơ KH) từ FO gửi sang — *TC 881, row 882*
13. [Xem chi tiết] Địa chỉ công ty – Kiểm tra dữ liệu hiển thị → đây là thông tin khách hàng (theo CIF/hồ sơ KH) từ FO gửi sang — *TC 882, row 883*
14. [Xem chi tiết] Số DKKD/MST – Kiểm tra chức năng khi click nút → Hiển thị chính xác dữ liệu prefill từ FO (nếu có) — *TC 883, row 884*
15. [Xem chi tiết] Số điện thoại – Kiểm tra chức năng khi click nút → Hiển thị chính xác dữ liệu prefill từ FO (nếu có) — *TC 884, row 885*
16. [Xem chi tiết] Người đại diện – Kiểm tra chức năng khi click nút → Hiển thị chính xác dữ liệu prefill từ FO (nếu có) — *TC 885, row 886*
17. [Xem chi tiết] Chức vụ – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO (nếu có) — *TC 886, row 887*
18. [Xem chi tiết] Văn bản ủy quyền – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO (nếu có) — *TC 887, row 888*
19. [Xem chi tiết] Ngày ủy quyền – Kiểm tra validate trường → Hiển thị chính xác dữ liệu prefill từ FO (nếu có) — *TC 888, row 889*
20. [Xem chi tiết] CCCD/Hộ chiếu – Kiểm tra validate trường → Hiển thị chính xác dữ liệu prefill từ FO (nếu có) — *TC 889, row 890*
21. [Xem chi tiết] Phân hạng khách hàng – Kiểm tra validate trường → Hiển thị chính xác dữ liệu prefill từ FO (nếu có) — *TC 890, row 891*
22. [Xem chi tiết] Hợp đồng hạn mức – Kiểm tra hiển thị → Hiển thị đúng tên trường <Hợp đồng hạn mức> — *TC 891, row 892*
23. [Xem chi tiết] Hợp đồng hạn mức số – Kiểm tra hiển thị → Hiển thị chính xác giá trị theo Số hợp đồng hạn mức đã chọn ở FO — *TC 892, row 893*
24. [Xem chi tiết] Chi nhánh – Kiểm tra hiển thị → Hiển thị chính xác giá trị theo Số hợp đồng hạn mức đã chọn từ FO For… — *TC 893, row 894*
25. [Xem chi tiết] Hạn mức theo HĐ CHM – Kiểm tra hiển thị → Hiển thị chính xác giá trị theo Số hợp đồng hạn mức đã chọn ở FO Hiển… — *TC 894, row 895*
26. [Xem chi tiết] Hạn mức khả dụng – Kiểm tra hiển thị → Hiển thị chính xác giá trị theo Số hợp đồng hạn mức đã chọn ở FO Hiển… — *TC 895, row 896*
27. [Xem chi tiết] Thông tin đề nghị – Kiểm tra hiển thị → Hiển thị đúng tên trường <Thông tin đề nghị> — *TC 896, row 897*
28. [Xem chi tiết] Loại LC – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO: [Giá trị mặc định: Không hủ… — *TC 897, row 898*
29. [Xem chi tiết] Loại sản phẩm L/C – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO: Loại sản phẩm UPAS/UPAS PLU… — *TC 898, row 899*
30. [Xem chi tiết] Ô nhập liệu khi chọn LC khác – Kiểm tra hiển thị → Hiển thị thông tin đã nhập ở FO khi chọn loại sản phẩm L/C là “Khác” — *TC 899, row 900*
31. [Xem chi tiết] Thông tin LC xác nhận – Kiểm tra hiển thị → Hiển thị đúng tên trường <Thông tin LC xác nhận> Thông tin hiển thị k… — *TC 900, row 901*
32. [Xem chi tiết] Ngân hàng xác nhận – Kiểm tra hiển thị → Hiển thị thông tin đã nhập ở FO dạng BIC - Tên ngân hàng — *TC 901, row 902*
33. [Xem chi tiết] Thông tin LC chuyển hượng – Kiểm tra hiển thị → Hiển thị đúng tên trường <Thông tin LC chuyển nhượng> Thông tin hiển … — *TC 902, row 903*
34. [Xem chi tiết] Ngân hàng chuyển nhượng – Kiểm tra hiển thị → Hiển thị thông tin đã nhập ở FO dạng BIC - Tên ngân hàng — *TC 903, row 904*
35. [Xem chi tiết] Hình thức phát hành LC – Kiểm tra hiển thị → Hiển thị thông tin đã nhập ở FO: Mail/SWIFT — *TC 904, row 905*
36. [Xem chi tiết] Yêu cầu chữ ký số trên điện LC – Kiểm tra hiển thị → Hiển thị thông tin đã nhập ở FO: Bản điện tử có/không ký số — *TC 905, row 906*
37. [Xem chi tiết] Ngày hết hạn – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 906, row 907*
38. [Xem chi tiết] Nơi hết hạn – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 907, row 908*
39. [Xem chi tiết] Ngân hàng bên thụ hưởng – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO: "Mã SWIFT/BIC code (nếu FO … — *TC 908, row 909*
40. [Xem chi tiết] Ngân hàng thông báo – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO: "Mã SWIFT/BIC code (nếu FO … — *TC 909, row 910*
41. [Xem chi tiết] Thông tin bên phát hành – Kiểm tra hiển thị → Hiển thị đúng tên trường <Thông tin bên phát hành> — *TC 910, row 911*
42. [Xem chi tiết] Tên Đơn vị phát hành LC – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 911, row 912*
43. [Xem chi tiết] Thông tin bên người hưởng – Kiểm tra hiển thị → Hiển thị đúng tên trường <Thông tin bên người hưởng> — *TC 912, row 913*
44. [Xem chi tiết] Tên người hưởng – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO: Tên + Địa chỉ + Tỉnh/Thành … — *TC 913, row 914*
45. [Xem chi tiết] Số tài khoản – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 914, row 915*
46. [Xem chi tiết] Giá trị LC – Kiểm tra hiển thị → Hiển thị đúng tên trường <Giá trị LC> — *TC 915, row 916*
47. [Xem chi tiết] Giá trị L/C – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO Hiển thị dạng Số tiền - Loại… — *TC 916, row 917*
48. [Xem chi tiết] Số tiền bằng chữ – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO Hiển thị số tiền bằng chữ tư… — *TC 917, row 918*
49. [Xem chi tiết] Dung sai (+) – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 918, row 919*
50. [Xem chi tiết] Dung sai (-) – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 919, row 920*
51. [Xem chi tiết] Thư tín dụng có giá trị tại – Kiểm tra hiển thị → 1. Hiển thị chính xác dữ liệu prefill từ FO 2. Nếu trường này ở FO ch… — *TC 920, row 921*
52. [Xem chi tiết] Thông tin ngân hàng khác – Kiểm tra hiển thị → 1. Hiển thị chính xác dữ liệu prefill từ FO 2. Nếu trưởng “Thư tín dụ… — *TC 921, row 922*
53. [Xem chi tiết] Thông tin “any bank in city” – Kiểm tra hiển thị → 1. Hiển thị chính xác dữ liệu prefill từ FO 2. Nếu trưởng “Thư tín dụ… — *TC 922, row 923*
54. [Xem chi tiết] Phương thức thanh toán của LC – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO: Payment/Acceptance/….. — *TC 923, row 924*
55. [Xem chi tiết] Chỉ thị về Thanh toán hỗn hợp (Mix payment details) – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO: Hiển thị thông tin… — *TC 924, row 925*
56. [Xem chi tiết] Chỉ thị về Thanh toán chiết khấu/trả chậm (Negotiation/ Deferred payment details) – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu pre… — *TC 925, row 926*
57. [Xem chi tiết] Yêu cầu xuất trình hối phiếu – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO: Có/Không — *TC 926, row 927*
58. [Xem chi tiết] Kỳ hạn thanh toán – Kiểm tra hiển thị → 1. Hiển thị chính xác dữ liệu prefill từ FO 2. Trường này nếu ở FO ch… — *TC 927, row 928*
59. [Xem chi tiết] Thông tin về người trả tiền trên Hối phiếu – Kiểm tra hiển thị → 1. Hiển thị chính xác dữ liệu prefill từ FO 2. Trường này nếu ở FO ch… — *TC 928, row 929*
60. [Xem chi tiết] Thông tin giao hàng – Kiểm tra hiển thị → Hiển thị đúng tên trường <Thông tin giao hàng> — *TC 929, row 930*
61. [Xem chi tiết] Nơi nhận hàng / Nơi gửi hàng / Nơi nhận hàng để vận chuyển – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 930, row 931*
62. [Xem chi tiết] Cảng xếp hàng / Sân bay khởi hành – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 931, row 932*
63. [Xem chi tiết] Cảng dỡ hàng / Sân bay đến – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 932, row 933*
64. [Xem chi tiết] Nơi đến cuối cùng / Nơi vận chuyển đến/ Nơi giao hàng – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 933, row 934*
65. [Xem chi tiết] Giao hàng từng phần – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 934, row 935*
66. [Xem chi tiết] Chuyển tải – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 935, row 936*
67. [Xem chi tiết] Ngày giao hàng muộn nhất – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 936, row 937*
68. [Xem chi tiết] Kỳ giao hàng – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 937, row 938*
69. [Xem chi tiết] Điều kiện giao hàng – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 938, row 939*
70. [Xem chi tiết] Điều kiện Incoterms – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 939, row 940*
71. [Xem chi tiết] Quy định vùng địa lý – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 940, row 941*
72. [Xem chi tiết] Mã phân loại hàng hóa – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 941, row 942*
73. [Xem chi tiết] Mô tả chứng từ – Kiểm tra hiển thị → 1. Cụm thông tin này hiển thị toàn bộ các nội dung mà FO đã tick chọn… — *TC 942, row 943*
74. [Xem chi tiết] Điều khoản hóa đơn thương mại – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 943, row 944*
75. [Xem chi tiết] Điều khoản vận đơn – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 944, row 945*
76. [Xem chi tiết] Điều khoản bản gốc số 3 của vận đơn hàng không – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 945, row 946*
77. [Xem chi tiết] Điều khoản giấy chứng nhận kiểm định/giám định do ai cấp – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 946, row 947*
78. [Xem chi tiết] Điều khoản giấy chứng nhận số lượng/chất lượng do ai cấp – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 947, row 948*
79. [Xem chi tiết] Điều khoản về chứng từ bảo hiểm hàng hóa – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 948, row 949*
80. [Xem chi tiết] Điều khoản về giấy chứng nhận xuất xứ – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 949, row 950*
81. [Xem chi tiết] Điều khoản về phiếu đóng gói hàng hóa – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 950, row 951*
82. [Xem chi tiết] Điều khoản chứng thư cam kết của người thụ hưởng – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 951, row 952*
83. [Xem chi tiết] Điều khoản bổ sung – Kiểm tra hiển thị → 1. Cụm thông tin này hiển thị toàn bộ các nội dung mà FO đã tick chọn… — *TC 952, row 953*
84. [Xem chi tiết] Điều khoản thanh toán LC tại đâu, bất kể kỳ hạn – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 953, row 954*
85. [Xem chi tiết] Các điều khoản: sanction clause, all docs issued in English, the amount utilized, due date falls on – Kiểm tra hiển thị → Hiển thị chí… — *TC 954, row 955*
86. [Xem chi tiết] Điều khoản khác – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 955, row 956*
87. [Xem chi tiết] Phí (Đối với loại L/C là LC thường - Regular) – Kiểm tra hiển thị → Hiển thị đúng tên trường <Phí> — *TC 956, row 957*
88. [Xem chi tiết] Phí – Kiểm tra hiển thị → 1. Hiển thị chính xác dữ liệu prefill từ FO 2. Ở trường này nếu FO ch… — *TC 957, row 958*
89. [Xem chi tiết] Ô nhập phí khác – Kiểm tra hiển thị → 1. Hiển thị chính xác dữ liệu prefill từ FO 2. Ở trường “Phí”, nếu FO… — *TC 958, row 959*
90. [Xem chi tiết] Phí (Đối với loại L/C là LC UPAS/UPAS PLUS) – Kiểm tra hiển thị → Hiển thị đúng tên trường <Phí> — *TC 959, row 960*
91. [Xem chi tiết] Các khoản phí và tiền lãi của ngân hàng phát hành L/C do – Kiểm tra hiển thị → Phí (Đối với loại L/C là LC UPAS/UPAS PLUS) — *TC 960, row 961*
92. [Xem chi tiết] Các khoản phí ngân hàng khác (bao gồm cả phí hoàn trả/thanh toán bồi hoàn, nếu có) do – Kiểm tra hiển thị → Phí (Đối với loại L/C là L… — *TC 961, row 962*
93. [Xem chi tiết] Trường hợp LC xác nhận / Có thể xác nhận (Chỉ hiển thị nếu FO chọn L/C Confirmed/May add ở trường Thông tin xác nhận L/C) – Kiểm tra h… — *TC 962, row 963*
94. [Xem chi tiết] Phí xác nhận do – Kiểm tra hiển thị → 1. Hiển thị chính xác dữ liệu prefill từ FO 2. Ở trường "Thông tin xá… — *TC 963, row 964*
95. [Xem chi tiết] Trường hợp LC chuyển nhượng (Chỉ hiển thị nếu FO chọn L/C Transferable ở trường Thông tin xác nhận L/C) – Kiểm tra hiển thị → Hiển thị… — *TC 964, row 965*
96. [Xem chi tiết] Phí chuyển nhượng do – Kiểm tra hiển thị → 1. Hiển thị chính xác dữ liệu prefill từ FO 2. Ở trường "Thông tin xá… — *TC 965, row 966*
97. [Xem chi tiết] Thời hạn xuất trình chứng từ – Kiểm tra hiển thị → Hiển thị đúng tên trường <Thời hạn xuất trình chứng từ> — *TC 966, row 967*
98. [Xem chi tiết] Thời hạn xuất trình chứng từ – Kiểm tra hiển thị → 1. Hiển thị chính xác dữ liệu prefill từ FO 2. Nếu trường này ở FO ng… — *TC 967, row 968*
99. [Xem chi tiết] Chỉ thị với ngân hàng thanh toán/chấp nhận/thương lượng sau khi nhận được – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ … — *TC 968, row 969*
100. [Xem chi tiết] Chỉ thị khác – Kiểm tra hiển thị → Hiển thị đúng tên trường <Chỉ thị khác> — *TC 969, row 970*
101. [Xem chi tiết] Chỉ thị khác – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 970, row 971*
102. [Xem chi tiết] Thông tin giao dịch – Kiểm tra hiển thị → Hiển thị đúng tên trường <Thông tin giao dịch> — *TC 971, row 972*
103. [Xem chi tiết] Số hợp đồng mua bán – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 972, row 973*
104. [Xem chi tiết] Ngày ký hợp đồng – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 973, row 974*
105. [Xem chi tiết] Đây là giao dịch kinh doanh hàng hóa tạm nhập tái xuất – Kiểm tra hiển thị → 1. Hiển thị chính xác dữ liệu prefill từ FO 2. Hiển thị t… — *TC 974, row 975*
106. [Xem chi tiết] Đây là giao dịch kinh doanh hàng hóa chuyển khẩu – Kiểm tra hiển thị → 1. Hiển thị chính xác dữ liệu prefill từ FO 2. Hiển thị tick xa… — *TC 975, row 976*
107. [Xem chi tiết] Khách hàng là Tổ chức kinh tế – Kiểm tra hiển thị → 1. Hiển thị chính xác dữ liệu prefill từ FO 2. Hiển thị Khách hàng là… — *TC 976, row 977*
108. [Xem chi tiết] Khách hàng cam kết cung cấp tờ khai hải quan và/hoặc hoàn tất nghĩa vụ thuế nhà thầu chậm nhất vào – Kiểm tra hiển thị → Hiển thị chín… — *TC 977, row 978*
109. [Xem chi tiết] Phương án sử dụng vốn – Kiểm tra hiển thị → Hiển thị đúng tên trường <Phương án sử dụng vốn> — *TC 978, row 979*
110. [Xem chi tiết] Cụm thông tin phương án sử dụng vốn – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO gồm Tỷ lệ, Số tài khoản, số … — *TC 979, row 980*
111. [Xem chi tiết] Tài khoản thu phí – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 980, row 981*
112. [Xem chi tiết] Phí giao dịch – Hiển thị khi loại LC là LC UPAS/UPAS PLUS – Kiểm tra hiển thị → Hiển thị đúng tên trường <Phí giao dịch> — *TC 981, row 982*
113. [Xem chi tiết] Phí chấp nhận thanh toán – Kiểm tra hiển thị → 1. Hiển thị chính xác dữ liệu prefill từ FO 2. Nếu trường này ở FO ch… — *TC 982, row 983*
114. [Xem chi tiết] Phí trả nợ trước hạn – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 983, row 984*
115. [Xem chi tiết] Phương thức trả nợ gốc và lãi – Kiểm tra hiển thị → Hiển thị đúng tên trường <Phương thức trả nợ gốc và lãi> — *TC 984, row 985*
116. [Xem chi tiết] Phương thức trả nợ gốc – Kiểm tra hiển thị → 1. Hiển thị chính xác dữ liệu prefill từ FO 2. Nếu trường này ở FO ch… — *TC 985, row 986*
117. [Xem chi tiết] Phương thức trả nợ lãi – Kiểm tra hiển thị → 1. Hiển thị chính xác dữ liệu prefill từ FO 2. Nếu trường này ở FO ch… — *TC 986, row 987*
118. [Xem chi tiết] Lãi suất áp dụng – Kiểm tra hiển thị → Hiển thị đúng tên trường <Lãi suất áp dụng> — *TC 987, row 988*
119. [Xem chi tiết] Lãi suất UPAS trong hạn – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 988, row 989*
120. [Xem chi tiết] Lãi suất áp dụng đối với dư nợ gốc quá hạn – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 989, row 990*
121. [Xem chi tiết] Lãi suất áp dụng đối với lãi chậm trả – Kiểm tra hiển thị → Hiển thị chính xác dữ liệu prefill từ FO — *TC 990, row 991*
122. [Xem chi tiết] Cam kết và cam đoan của khách hàng – Kiểm tra hiển thị → Hiển thị đúng tên trường <Cam kết và cam đoan của khách hàng> — *TC 991, row 992*
123. [Xem chi tiết] Cam kết và cam đoan của khách hàng – Kiểm tra hiển thị → Hiển thị dấu tick chọn của người dùng FO đồng ý với điểu khoản điều k… — *TC 992, row 993*
124. [Xem chi tiết] Hồ sơ đính kèm – Kiểm tra khi user thực hiện phê duyệt → Hiển thị đúng tên trường <HỒ SƠ ĐÍNH KÈM> — *TC 993, row 994*
125. [Xem chi tiết] Tab Tất cả – Kiểm tra giá trị hiển thị → 1. Hiển thị số đếm file từ FO đẩy sang = tất cả các file 2. Hiển thị … — *TC 994, row 995*
126. [Xem chi tiết] Tab Hồ sơ có ký số – Kiểm tra giá trị hiển thị → 1. Hiển thị số đếm file từ FO đẩy sang = số file CÓ ký số - danh sách… — *TC 995, row 996*
127. [Xem chi tiết] Tab Hồ sơ không có ký số – Kiểm tra giá trị hiển thị → 1. Hiển thị số đếm file từ FO đẩy sang = số file KHÔNG có ký số - dan… — *TC 996, row 997*
128. [Xem chi tiết] STT – Kiểm tra hiển thị → Tự động tăng dần — *TC 997, row 998*
129. [Xem chi tiết] Tên tài liệu – Kiểm tra dữ liệu hiển thị → Hiển thị giá trị theo FO tương ứng — *TC 998, row 999*
130. [Xem chi tiết] Loại tài liệu – Kiểm tra dữ liệu hiển thị → Hiển thị chính xác giá trị Loại tài liệu tương ứng với hồ sơ FO đính … — *TC 999, row 1000*
131. [Xem chi tiết] Hình thức – Kiểm tra dữ liệu hiển thị → Hiển thị chính xác giá trị hình thức: - Hồ sơ có ký số - Hồ sơ không … — *TC 1000, row 1001*
132. [Xem chi tiết] Ngày – Kiểm tra dữ liệu hiển thị → Hiển thị chính xác ngày cấp phê duyệt cuối tại FO gửi giao dịch qua B… — *TC 1001, row 1002*
133. [Xem chi tiết] Kiểm tra ký số – Kiểm tra chức năng khi click nút → File có ký số: Call API CA để kiểm tra thông tin ký số → Thông tin ký… — *TC 1002, row 1003*
134. [Xem chi tiết] Xem – Kiểm tra chức năng khi click nút → Hiển thị màn hình cho phép người dùng preview file inline — *TC 1003, row 1004*
135. [Xem chi tiết] Tải xuống – Kiểm tra chức năng khi click nút → Cho phép người dùng tải file về máy — *TC 1004, row 1005*
136. [Xem chi tiết] File Thông báo thu phí – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị file Thông báo thu phí — *TC 1007, row 1008*
137. [Xem chi tiết] File Điện phát hành LC – Kiểm tra thông tin tab Điện phát hành L/C → Điều kiện: Trong Q2: có event = , step = Authorise , status = com… — *TC 1008, row 1009*
138. [Xem chi tiết] Kiểm tra các Mã templatecode trả ra từ TI để hiển thị lên các mục Điện phát hành và Thông báo thu phsi → Chỉ lọc lấy các mã code trong… — *TC 1009, row 1010*
139. [Tiếp nhận] Tiếp nhận – Kiểm tra hiển thị button → Cán bộ CA thuộc chi nhánh phát hành trên thông tin Đề nghị phát hành … — *TC 1010, row 1011*
140. [Tiếp nhận] Tiếp nhận – Kiểm tra chức năng khi nhấn Button → 1. Nhận giao dịch về chân user CA đang tiếp nhận, Các cán bộ CA khác … — *TC 1011, row 1012*
141. [Tiếp nhận] Tiếp nhận – Kiểm tra chức năng khi nhiều user cùng thao tác Tiếp nhận → 1. User nào thực hiện tiếp nhận trước thì hiển thị MSG 12: "Tiếp … — *TC 1012, row 1013*
142. [Tiếp nhận] Tích hợp – Kiểm tra khi nhấn <Tiếp nhận> hệ thống kiểm tra CKS trên fie → Hệ thống gọi API tới hệ thống CA để kiểm tra thông tin CKS trên… — *TC 1013, row 1014*

## B03 · CA – Tiếp nhận & Xử lý tác nghiệp (146)

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
145. [Xử lý - Gửi duyệt] Tích hợp – Kiểm tra đẩy thông tin file lên ECM tại folder Temp → Hệ thống call API tới ECM để đẩy danh sách file của người dùng l… — *TC 1159, row 1160*
146. [Xử lý - Gửi duyệt] Popup lưu nháp – Kiểm tra hoạt động → Hiển thị popup Xác nhận đóng màn hình user input thông tin: ""Có nội … — *TC 1160, row 1161*

## B04 · CA – Gửi duyệt / Trả lại khách hàng / Từ chối (7)

1. [Xử lý - Trả lại] Nội dung (chọn nguồn thanh toán là: Khác) – Kiểm tra user thực hiện → Cán bộ CA đã thực hiện tiếp nhận giao dịch hoặc cán bộ được p… — *TC 1161, row 1162*
2. [Xử lý - Trả lại] Tình hình khách hàng – Kiểm tra khi nhấn nút → - Hệ thống mở pop-up nội dung Trả lại - Nhập nội dung Lý do trả lại m… — *TC 1162, row 1163*
3. [Xử lý - Trả lại] Popup thông báo Trả lại thành công – Kiểm tra hiển thị → - Hệ thống show MSG "Đã trả lại thành công Bạn có thể xem trạng thái … — *TC 1163, row 1164*
4. [Xử lý - Trả lại] Popup thông báo Trả lại thất bại – Kiểm tra hiển thị → - Hiển thị MSG "Trả lại giao dịch thất bại" - Đóng popup hiện tại — *TC 1165, row 1166*
5. [Xử lý - Từ chối] STT (Bảng chỉ thị thu phí) – Kiểm tra user thực hiện → Cán bộ CA đã thực hiện tiếp nhận giao dịch hoặc cán bộ CA được phân c… — *TC 1166, row 1167*
6. [Xử lý - Từ chối] Loại phí (Bảng chỉ thị thu phí) – Kiểm tra khi nhấn nút → - Hệ thống mở popup nhập nội dung Từ chối - Nhập nội dung phê duyệt m… — *TC 1167, row 1168*
7. [Xử lý - Từ chối] Số tiền tính phí (Bảng chỉ thị thu phí) – Từ chối giao dịch thành công → 1. Hệ thống show MSG:Đã từ chối thành công - Bạn có thể xe… — *TC 1168, row 1169*

## B05 · CA – Xem TBTN, tải hồ sơ khách hàng (1)

1. [Tải hồ sơ KH] Tải hồ sơ khách hàng – Kiểm tra khi nhấn nút → - Hệ thống cho phép tải xuống các tài liệu khách hàng - Tên file: HSK… — *TC 1217, row 1218*

## B06 · CA lead – Phê duyệt, Phê duyệt ĐXTC, Trả lại, Phân công lại, Xem TBTN (14)

1. [Danh sách (Mới bổ sung)] Lưới chức năng – Kiểm tra hiển thị danh sách theo phân quyền user → Chỉ thấy các giao dịch phát hành LC thuộc phạm vi phân … — *TC 1218, row 1219*
2. [Danh sách (Mới bổ sung)] Lưới chức năng – Kiểm tra counter tab Tất cả/Cần xử lý/Đang theo dõi/Đã hoàn thành → 1. Số lượng Counter = số bản ghi của t… — *TC 1219, row 1220*
3. [Phê duyệt] Kiểm tra user thực hiện → User thuộc SA có quyền phê duyệt Mặc định hiển thị toàn bộ GD "Đề ngh… — *TC 1220, row 1221*
4. [Phê duyệt ĐXTC] Gửi duyệt – Kiểm tra hiển thị nút → Hiển thị 2 lựa chọn: (1) Duyệt đề xuất (2) Gửi duyệt BGĐ — *TC 1222, row 1223*
5. [Trả lại] Kiểm tra trường Ô nhập thông tin – Kiểm tra user thực hiện → Lãnh đạo thẩm định có quyền thao tác — *TC 1225, row 1226*
6. [Trả lại] Trả lại – Kiểm tra khi nhấn nút → - Hệ thống mở opup Nhập nội dung Lý do Trả lại → Cho phép nhập tối đa… — *TC 1226, row 1227*
7. [Trả lại] Đóng – Kiểm tra chức năng đóng popup trả lại → Đóng popup hiện tại và quay lại màn hình trước đó — *TC 1228, row 1229*
8. [Phân công lại] Kiểm tra trường Ô nhập thông tin – Kiểm tra user thực hiện → SA có quyền thao tác — *TC 1229, row 1230*
9. [Phân công lại] Phân công lại – Kiểm tra khi nhấn nút → Hệ thống mở pop-up Phân công lại cán bộ: - Chọn cán bộ — *TC 1230, row 1231*
10. [Phân công lại] Kiểm tra trường Chọn cán bộ → - Các giá trị hiển thị tại droplist: Hiển thị toàn bộ cán bộ CA còn h… — *TC 1231, row 1232*
11. [Phân công lại] Đóng – Kiểm tra chức năng đóng popup Phân công lại → Đóng popup hiện tại và quay lại màn hình trước đó — *TC 1233, row 1234*
12. [Tải hồ sơ KH] Tải hồ sơ khách hàng – Kiểm tra khi nhấn nút → - Hệ thống cho phép tải xuống các tài liệu khách hàng - Tên file: HSK… — *TC 1237, row 1238*
13. [Xem chi tiết] File Thông báo thu phí – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị file Thông báo thu phí — *TC 1240, row 1241*
14. [Xem chi tiết] File Điện phát hành LC – Kiểm tra thông tin tab Điện phát hành L/C → Điều kiện: Trong Q2: có event = , step = Authorise , status = com… — *TC 1241, row 1242*

## B07 · CRC – Danh sách, tiếp nhận, xử lý tác nghiệp (57)

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

## B08 · CRC – Yêu cầu xử lý giao dịch (YCXL) (84)

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
84. [Xử lý - Gửi duyệt] Gửi duyệt – Kiểm tra khi NSD thực hiện gửi duyệt → Đóng - Mở popup xác nhận gửi duyệt — *TC 1383, row 1384*

## B09 · CRC – Gửi duyệt / Trả lại / Xem file tác nghiệp (6)

1. [Xử lý - Gửi duyệt] Popup lưu nháp – Kiểm tra hoạt động → Hiển thị popup Xác nhận đóng màn hình user input thông tin: ""Có nội … — *TC 1384, row 1385*
2. [Xử lý - Trả lại] Lịch sử giao dịch – Kiểm tra user thực hiện → Cán bộ CRC đã thực hiện tiếp nhận giao dịch hoặc cán bộ CRC được phân… — *TC 1385, row 1386*
3. [Xử lý - Trả lại] Trả lại – Kiểm tra khi nhấn nút → - Hệ thống mở popup nhập nội dung lý do Trả lại - Người dùng nhập thô… — *TC 1386, row 1387*
4. [Xử lý - Trả lại] Popup trả lại – Kiểm tra validate bỏ trống Nhập lý do trả lại → Hiển thị MSG "Vui lòng nhập thông tin lý do trả lại" — *TC 1388, row 1389*
5. [Xử lý - Trả lại] Không – Kiểm tra chức năng → Đóng pop-up, quay lại màn hình Xử lý - Gửi duyệt — *TC 1389, row 1390*
6. [Tải hồ sơ KH] Tải hồ sơ khách hàng – Kiểm tra khi nhấn nút → - Hệ thống cho phép tải xuống các tài liệu khách hàng - Tên file: HSK… — *TC 1415, row 1416*

## B10 · CRC lead – Phê duyệt, Phê duyệt ĐXTC, Trả lại, Phân công lại, Xem file (19)

1. [Danh sách] File Thông báo thu phí – Kiểm tra thông tin tab Điện phát hành L/C → Mặc định hiển thị toàn bộ GD gửi tới CN theo HĐHMPHLC 0. Tất cả = Tấ… — *TC 1416, row 1417*
2. [Danh sách] File Điện phát hành LC – Kiểm tra counter tab Tất cả/Cần xử lý/Đang theo dõi/Đã hoàn thành → 1. Số lượng Counter = số bản ghi của từng ta… — *TC 1417, row 1418*
3. [Xem chi tiết] Kiểm tra thông tin hiển thị trên màn hình → Hiển thị dữ liệu: 1. Các trường thông tin: Hiển thị đúng các trường t… — *TC 1418, row 1419*
4. [Xem chi tiết] Lịch sử giao dịch – Kiểm tra chức năng khi người dùng click vào → Hiển thị popup có các trường thông tin và hiển thị giá trị tương ứng… — *TC 1420, row 1421*
5. [Xem chi tiết] Lịch sử giao dịch – Kiểm tra các hành động lưu lại lịch sử → Khi người dùng thực hiện các chức năng dưới đây: 1. FO duyệt cuối (tr… — *TC 1421, row 1422*
6. [Phê duyệt] Phê duyệt – Kiểm tra hiển thị nút → Hiển thị nút Phê duyệt — *TC 1422, row 1423*
7. [Phê duyệt] Duyệt và Gửi duyệt – Kiểm tra hiển thị nút → Hiển thị nút <Duyệt và Gửi duyệt> — *TC 1424, row 1425*
8. [Phê duyệt ĐXTC] Phê duyệt – Kiểm tra hiển thị nút → Hiển thị nút Phê duyệt — *TC 1426, row 1427*
9. [Phê duyệt ĐXTC] Duyệt và Gửi duyệt – Kiểm tra hiển thị nút → Hiển thị nút <Duyệt và Gửi duyệt> — *TC 1428, row 1429*
10. [Trả lại] Kiểm tra user thực hiện → User thuộc LĐ CRC và có quyền phê duyệt — *TC 1430, row 1431*
11. [Trả lại] Trả lại – Kiểm tra khi nhấn nút → - Hệ thống mở popup Nhập nội dung Lý do Trả lại → Cho phép nhập tối đ… — *TC 1431, row 1432*
12. [Trả lại] Trả lại giao dịch thất bại → Đóng pop-up hiện tại — *TC 1434, row 1435*
13. [Phân công lại] Xem file tác nghiệp – Kiểm tra user thực hiện → User thuộc LĐ CRC và có quyền phê duyệt — *TC 1435, row 1436*
14. [Phân công lại] Phân công lại – Kiểm tra khi nhấn nút → Hệ thống mở pop-up Phân công lại cán bộ: - Chọn cán bộ — *TC 1436, row 1437*
15. [Phân công lại] Kiểm tra trường Chọn cán bộ → - Các giá trị hiển thị tại droplist: Hiển thị toàn bộ cán bộ CRC còn … — *TC 1437, row 1438*
16. [Phân công lại] Đóng – Kiểm tra chức năng đóng popup Phân công lại → Đóng popup hiện tại và quay lại màn hình trước đó — *TC 1439, row 1440*
17. [Tải hồ sơ KH] Tải hồ sơ khách hàng – Kiểm tra khi nhấn nút → - Hệ thống cho phép tải xuống các tài liệu khách hàng - Tên file: HSK… — *TC 1448, row 1449*
18. [Xem chi tiết] File Thông báo thu phí – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị file Thông báo thu phí — *TC 1451, row 1452*
19. [Xem chi tiết] File Điện phát hành LC – Kiểm tra thông tin tab Điện phát hành L/C → Điều kiện: Trong Q2: có event = , step = Authorise , status = com… — *TC 1452, row 1453*

## B11 · BGĐ CN – Phê duyệt, Trả lại, Xem file (14)

1. [Danh sách] Lưới chức năng – Kiểm tra quyền truy cập → Mặc định hiển thị toàn bộ GD "Đề nghị phát hành LC" gửi tới CN theo Đ… — *TC 1453, row 1454*
2. [Danh sách] Lưới chức năng – Kiểm tra counter tab Tất cả/Cần xử lý/Đang theo dõi/Đã hoàn thành → 1. Số lượng Counter = số bản ghi của từng tab 2. Số … — *TC 1454, row 1455*
3. [Phê duyệt] Lịch sử giao dịch – Kiểm tra user thực hiện → User thuộc BGĐ CN và có quyền phê duyệt — *TC 1455, row 1456*
4. [Trả lại] Xem file tác nghiệp – Kiểm tra user thực hiện → user thuộc BGD CN và có quyền phê duyệt — *TC 1459, row 1460*
5. [Trả lại] Trả lại – Kiểm tra khi nhấn nút → - Cho phép nhập tối đa 2000 ký tự → Trường bắt buộc nhập - Nếu không … — *TC 1460, row 1461*
6. [Trả lại] Kiểm tra trường Ô nhập thông tin → Hiển thị placeholder “Lý do trả lại” Giá trị = rỗng Trường bắt buộc — *TC 1461, row 1462*
7. [Trả lại] Kiểm tra trường Ô nhập thông tin → Cho phép nhập số nguyên, số thập phân, giá trị text và các ký tự dặc … — *TC 1462, row 1463*
8. [Trả lại] Kiểm tra trường Ô nhập thông tin → Không cho phép nhập/paste vượt quá 2000 ký tự Hệ thống tự động cắt nộ… — *TC 1463, row 1464*
9. [Trả lại] Kiểm tra trường Ô nhập thông tin → Hệ thống tự động trimspace đầu cuối — *TC 1464, row 1465*
10. [Trả lại] Kiểm tra trường Ô nhập thông tin → Hiển thị "Vui lòng nhập thông tin Lý do trả lại" — *TC 1465, row 1466*
11. [Trả lại] 4. Kiểm tra sự phù hợp với mục đích cấp tín dụng và các điều kiện cấp tín dụng đã được phê duyệt và/hoặc HĐTD đã ký – Trả lại giao dịch thấ… — *TC 1469, row 1470*
12. [Tải hồ sơ KH] Tải hồ sơ khách hàng – Kiểm tra khi nhấn nút → - Hệ thống cho phép tải xuống các tài liệu khách hàng - Tên file: HSK… — *TC 1476, row 1477*
13. [Xem chi tiết] File Thông báo thu phí – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị file Thông báo thu phí — *TC 1479, row 1480*
14. [Xem chi tiết] File Điện phát hành LC – Kiểm tra thông tin tab Điện phát hành L/C → Điều kiện: Trong Q2: có event = , step = Authorise , status = com… — *TC 1480, row 1481*

## B12 · BGĐ CN – Phê duyệt & Ký số Điện phát hành LC (1)

1. [Phê duyệt Điện phát hành LC] Đã in nội dung điện SWIFT mở L/C theo kết quả xử lý của Trung tâm TTTM – Kiểm tra user thực hiện → User thuộc BGD CN và… — *TC 1481, row 1482*

## B14 · CRC lead – Chờ ký số điện LC: Phê duyệt & Ký số (không thuộc thẩm quyền BGĐ CN) (8)

1. [Danh sách] File YCXL giao dịch (.doc) – Kiểm tra nhấn nút → Mặc định hiển thị toàn bộ GD gửi tới CN theo HĐHMPHLC 0. Tất cả = Tất… — *TC 1519, row 1520*
2. [Danh sách] File YCXL giao dịch (.doc) – Kiểm tra counter tab Tất cả/Cần xử lý/Đang theo dõi/Đã hoàn thành → 1. Số lượng Counter = số bản ghi của từn… — *TC 1520, row 1521*
3. [Xem chi tiết] Lãnh đạo CRC – Kiểm tra thông tin hiển thị trên màn hình → Hiển thị dữ liệu: 1. Các trường thông tin: Hiển thị đúng các trường t… — *TC 1521, row 1522*
4. [Xem chi tiết] Lịch sử giao dịch – Kiểm tra chức năng khi người dùng click vào → Hiển thị popup có các trường thông tin và hiển thị giá trị tương ứng… — *TC 1523, row 1524*
5. [Xem chi tiết] Lịch sử giao dịch – Kiểm tra các hành động lưu lại lịch sử → Khi người dùng thực hiện các chức năng dưới đây: 1. FO duyệt cuối (tr… — *TC 1524, row 1525*
6. [Phê duyệt] Phê duyệt – Kiểm tra hiển thị nút → Hiển thị nút <Phê duyệt> — *TC 1525, row 1526*
7. [Phê duyệt] Duyệt và Gửi duyệt – Kiểm tra hiển thị nút → Hiển thị nút <Duyệt và Gửi duyệt> — *TC 1527, row 1528*
8. [Tải hồ sơ KH] Tải hồ sơ khách hàng – Kiểm tra khi nhấn nút → - Hệ thống cho phép tải xuống các tài liệu khách hàng - Tên file: HSK… — *TC 1537, row 1538*

## B15 · BGĐ CN – Chờ ký số điện LC: Phê duyệt & Ký số (thuộc thẩm quyền BGĐ CN) (8)

1. [Danh sách] Chọn tệp tin – Kiểm tra các trường hợp tải file đính kèm của khách hàng → Mặc định hiển thị toàn bộ GD gửi tới CN theo HĐHMPHLC 0. Tất cả… — *TC 1542, row 1543*
2. [Danh sách] Chọn tệp tin – Kiểm tra counter tab Tất cả/Cần xử lý/Đang theo dõi/Đã hoàn thành → 1. Số lượng Counter = số bản ghi của từng tab 2. Số lư… — *TC 1543, row 1544*
3. [Xem chi tiết] Chọn tệp tin – Kiểm tra thông tin hiển thị trên màn hình → Hiển thị dữ liệu: 1. Các trường thông tin: Hiển thị đúng các trường t… — *TC 1544, row 1545*
4. [Xem chi tiết] Lịch sử giao dịch – Kiểm tra chức năng khi người dùng click vào → Hiển thị popup có các trường thông tin và hiển thị giá trị tương ứng… — *TC 1546, row 1547*
5. [Xem chi tiết] Lịch sử giao dịch – Kiểm tra các hành động lưu lại lịch sử → Khi người dùng thực hiện các chức năng dưới đây: 1. FO duyệt cuối (tr… — *TC 1547, row 1548*
6. [Phê duyệt] Phê duyệt – Kiểm tra hiển thị nút → Hiển thị nút <Phê duyệt> — *TC 1548, row 1549*
7. [Phê duyệt] Duyệt và Gửi duyệt – Kiểm tra hiển thị nút → Hiển thị nút <Duyệt và Gửi duyệt> — *TC 1550, row 1551*
8. [Tải hồ sơ KH] Tải hồ sơ khách hàng – Kiểm tra khi nhấn nút → - Hệ thống cho phép tải xuống các tài liệu khách hàng - Tên file: HSK… — *TC 1560, row 1561*

