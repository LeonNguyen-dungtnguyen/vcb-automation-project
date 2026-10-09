# Bước gộp (composite steps) trong cột Action

Nguồn: `VCB_TradeFlat_Testcase_SIT_LC_ISS_Phat Hanh v1.1 (1).xlsx`, cột **Action** của toàn bộ 1.580 TC (FO + BO).

- Tách được **3860 dòng step**; **1772** dòng chứa ít nhất 1 bước gộp, phần còn lại là thao tác đơn (Kiểm tra hiển thị, Click nút X, Nhập…).
- Quy về **24 bước gộp**: 10 FO · 11 BO · 3 dùng chung. Mỗi bước gộp → 1 keyword Katalon dùng lại.
- Phân loại theo từ khóa → số liệu là **ước lượng**; 1 dòng có thể chứa nhiều bước gộp (VD: *Maker login, thêm mới bản ghi, nhập liệu đầy đủ, đẩy lên cấp duyệt*).

## Tóm tắt

| # | Phía | Bước gộp | Số dòng | Số TC | Số cách viết |
|---|---|---|---|---|---|
| 1 | FO | Login FO theo vai trò (Maker / KT phó / KT trưởng / Chủ TK / Người ký PN) | 179 | 133 | 124 |
| 2 | FO | Thêm mới đề nghị LC + nhập liệu đầy đủ (wizard nhiều step) | 18 | 18 | 9 |
| 3 | FO | Lưu nháp | 64 | 60 | 11 |
| 4 | FO | Gửi duyệt / đẩy lên cấp duyệt / gửi lại | 311 | 303 | 204 |
| 5 | FO | Phê duyệt + xác thực 2FA (OTP) | 38 | 25 | 26 |
| 6 | FO | Ký số cá nhân | 23 | 23 | 17 |
| 7 | FO | Ký số pháp nhân | 36 | 22 | 31 |
| 8 | FO | Trả lại / Từ chối (nhập lý do, xác nhận) | 43 | 36 | 37 |
| 9 | FO | Hủy / Xóa đề nghị | 33 | 27 | 26 |
| 10 | FO | Mở lại & chỉnh sửa bản ghi | 44 | 31 | 35 |
| 11 | BO | Tiền đề: đề nghị FO đã gửi sang BO (Chờ tiếp nhận) | 46 | 46 | 2 |
| 12 | BO | Login BO theo vai trò (CA / CA lead / CRC / CRC lead / BGĐ CN) | 72 | 67 | 7 |
| 13 | BO | Truy vấn / mở giao dịch theo trạng thái | 493 | 425 | 15 |
| 14 | BO | CA tiếp nhận | 140 | 62 | 15 |
| 15 | BO | Nhập thông tin xử lý tác nghiệp (CA/CRC) + chọn đề xuất (1) duyệt / (2) từ chối | 92 | 42 | 9 |
| 16 | BO | Lưu / Gửi duyệt | 182 | 125 | 23 |
| 17 | BO | Lãnh đạo phê duyệt (CA lead / CRC lead / BGĐ CN, theo thẩm quyền) | 199 | 68 | 32 |
| 18 | BO | Trả lại / Từ chối | 133 | 55 | 38 |
| 19 | BO | Phân công lại | 4 | 4 | 1 |
| 20 | BO | Ký số điện phát hành LC | 49 | 30 | 16 |
| 21 | BO | TI trả kết quả / đẩy sang TI | 26 | 23 | 9 |
| 22 | Chung | Upload tài liệu (popup Thêm tài liệu) | 107 | 74 | 26 |
| 23 | Chung | Tìm kiếm / bộ lọc | 82 | 59 | 45 |
| 24 | Chung | Xem / tải file (TBTN, tác nghiệp, YCXL, hồ sơ KH) | 61 | 35 | 6 |

## Nhận xét

- **Ít bước gộp nhưng viết rất không thống nhất** (Login FO ~124 cách, Gửi duyệt ~200 cách) → chuẩn hóa thành keyword, map các cách viết về cùng 1 keyword.
- **Nặng nhất:** *Thêm mới đề nghị LC + nhập liệu đầy đủ* – chỉ ghi rõ ở ít TC nhưng ẩn trong mọi E2E FO và mọi TC BO; bên trong là wizard nhiều step, hàng trăm trường.
- **Dùng nhiều nhất:** *Truy vấn / mở giao dịch theo trạng thái* (BO) – đơn giản nhưng cần bản ghi ở đúng trạng thái.
- **Bước ẩn:** ~320 dòng chỉ ghi `Pre:` và rất nhiều TC chỉ ghi "Kiểm tra hiển thị" – bước dẫn tới màn hình (login, vào Thêm mới, tới step X) không được viết ra nhưng keyword vẫn phải làm.
- Số TC của *FO · Gửi duyệt* bị thổi lên vì gồm cả các TC "kiểm tra nút Gửi duyệt".

## Bước tiếp theo

- [ ] Tách từng bước gộp thành step con thật (màn hình / nút / trường), bắt đầu từ *Thêm mới đề nghị LC*.
- [ ] Đặt tên keyword Katalon cho 24 bước gộp.

## 1. [FO] Login FO theo vai trò (Maker / KT phó / KT trưởng / Chủ TK / Người ký PN)

**179 dòng · 133 TC · 124 cách viết**

Cách viết phổ biến:

- 15× `Đăng nhập hệ thống bằng user có quyền xem chi tiết.`
- 6× `User Kế toán trưởng login, thực hiện xác thực 2FA và Phê duyệt.`
- 6× `User Maker login hệ thống FO, thêm mới bản ghi phát hành LC, nhập liệu đầy đủ, đẩy giao dịch lên cấp duyệt → "Chờ duyệt".`
- 6× `NSD đăng nhập thành công vào hệ thống.`
- 5× `User Maker login hệ thống FO, thêm mới bản ghi phát hành LC, nhập liệu đầy đủ.`

TC: 1–17, 66–78, 115, 117–137, 154–155, 160, 196, 511, 525, 541–548, 553–554, 559, 562–563, 568–573, 575–577, 583–589, 591–593, 597–605, 612–613, 619–620, 623–628, 636–643, 649–659, 664–665, 720, 760–761

## 2. [FO] Thêm mới đề nghị LC + nhập liệu đầy đủ (wizard nhiều step)

**18 dòng · 18 TC · 9 cách viết**

Cách viết phổ biến:

- 6× `User Maker login hệ thống FO, thêm mới bản ghi phát hành LC, nhập liệu đầy đủ, đẩy giao dịch lên cấp duyệt → "Chờ duyệt".`
- 5× `User Maker login hệ thống FO, thêm mới bản ghi phát hành LC, nhập liệu đầy đủ.`
- 1× `Thêm mới 1 bản ghi phát hành LC, nhập liệu các trường thông tin bắt buộc (cấu hình 1 cấp duyệt 2FA, không ký số pháp nhân).`
- 1× `Thêm mới 1 bản ghi phát hành LC, nhập liệu đầy đủ (cấu hình 1 cấp duyệt 2FA, có ký số pháp nhân).`
- 1× `User Maker login hệ thống FO, thêm mới bản ghi phát hành LC, nhập liệu đầy đủ (cấu hình 2 cấp duyệt 2FA, không ký số pháp nhân).`

TC: 1–17, 166

## 3. [FO] Lưu nháp

**64 dòng · 60 TC · 11 cách viết**

Cách viết phổ biến:

- 28× `Thực hiện lưu nháp/gửi duyệt.`
- 18× `Thực hiện Lưu nháp/Gửi duyệt.`
- 5× `Maker thực hiện <Lưu nháp>.`
- 3× `Maker mở lại bản ghi vừa lưu nháp, đẩy giao dịch lên cấp duyệt → bản ghi chuyển "Chờ duyệt".`
- 3× `Tại màn hình, nhấn nút "Lưu nháp" và quan sát kết quả xử lý.`

TC: 5–9, 121, 156, 165, 175, 181–184, 187, 189, 191–194, 197, 199–200, 202–206, 208–214, 217–218, 221–223, 225–232, 381, 396, 400, 402, 407, 412, 433, 495, 497, 533, 537, 551, 711

## 4. [FO] Gửi duyệt / đẩy lên cấp duyệt / gửi lại

**311 dòng · 303 TC · 204 cách viết**

Cách viết phổ biến:

- 28× `Thực hiện lưu nháp/gửi duyệt.`
- 24× `Thực hiện Lưu/Gửi duyệt.`
- 18× `Thực hiện Lưu nháp/Gửi duyệt.`
- 6× `User Maker login hệ thống FO, thêm mới bản ghi phát hành LC, nhập liệu đầy đủ, đẩy giao dịch lên cấp duyệt → "Chờ duyệt".`
- 5× `Để trống, thực hiện Lưu/Gửi duyệt.`

TC: 1–8, 10–17, 80, 82–83, 85–90, 94, 104–106, 116, 139, 156, 165–171, 175–184, 187, 189, 191–194, 197–206, 208–214, 217–218, 221–223, 225–233, 235–236, 238–247, 249, 251, 253–254, 257–258, 260, 262–265, 268, 270–271, 273–274, 276–277, 279–280, 282–294, 296–303, 305–307, 309–313, 317, 319, 321–323, 325, 327, 329, 331–332, 334–335, 337–338, 340, 342, 344–345, 348–349, 351–356, 358–359, 362, 364–367, 369–370, 372–373, 377–379, 381, 383–384, 386–393, 396, 400–404, 406–410, 412, 416–417, 419, 421, 423, 425, 427, 429, 431, 433, 436–439, 441–445, 447, 450–451, 453–455, 458, 462, 464, 469, 471–475, 477, 480–481, 483, 485–492, 494–495, 497, 500–504, 540, 552, 555–558, 570–571, 614–616, 632–633, 646, 660–661, 663, 691, 693, 695–696, 705, 707, 711, 719, 722–724, 726, 729, 734, 736–737, 739, 741, 754, 756, 758, 768

## 5. [FO] Phê duyệt + xác thực 2FA (OTP)

**38 dòng · 25 TC · 26 cách viết**

Cách viết phổ biến:

- 6× `User Kế toán trưởng login, thực hiện xác thực 2FA và Phê duyệt.`
- 4× `User Kế toán trưởng thực hiện xác thực 2FA và Phê duyệt.`
- 2× `User Kế toán trưởng login hệ thống FO, thực hiện xác thực 2FA và Phê duyệt.`
- 2× `User Kế toán phó login, thực hiện xác thực 2FA và Phê duyệt → bản ghi chuyển trạng thái "Chờ duyệt cấp tiếp theo".`
- 2× `User Kế toán phó thực hiện xác thực 2FA và Phê duyệt → bản ghi chuyển "Chờ duyệt cấp tiếp theo".`

TC: 1–8, 11–12, 14–17, 555, 604–605, 608–610, 612–616

## 6. [FO] Ký số cá nhân

**23 dòng · 23 TC · 17 cách viết**

Cách viết phổ biến:

- 4× `User Chủ tài khoản login, thực hiện Ký số thành công.`
- 2× `User Chủ tài khoản thực hiện Ký số thành công.`
- 2× `User Chủ tài khoản thực hiện Ký số thành công → "Chờ ký số pháp nhân".`
- 2× `Đăng nhập hệ thống với user được phân quyền (Maker/Checker/Viewer được phân quyền chức năng Phát hành LC), truy cập theo đường dẫn menu tương ứng chức năng "Ký `
- 1× `User Chủ tài khoản login hệ thống FO, thực hiện Ký số thành công.`

TC: 1–8, 12, 14–17, 121, 136, 153, 575, 636–639, 642, 644

## 7. [FO] Ký số pháp nhân

**36 dòng · 22 TC · 31 cách viết**

Cách viết phổ biến:

- 3× `NSD mở giao dịch tại màn hình Ký số pháp nhân.`
- 2× `Người dùng có thẩm quyền Ký số pháp nhân login, thực hiện ký số pháp nhân thành công.`
- 2× `User Chủ tài khoản thực hiện Ký số thành công → "Chờ ký số pháp nhân".`
- 2× `NSD đã đăng nhập, đang xử lý giao dịch có TT = Chờ ký số pháp nhân; DN của giao dịch có (các) user đã đăng ký CKS pháp nhân`
- 1× `Thêm mới 1 bản ghi phát hành LC, nhập liệu các trường thông tin bắt buộc (cấu hình 1 cấp duyệt 2FA, không ký số pháp nhân).`

TC: 1–6, 12, 15, 17, 121, 591, 649–659

## 8. [FO] Trả lại / Từ chối (nhập lý do, xác nhận)

**43 dòng · 36 TC · 37 cách viết**

Cách viết phổ biến:

- 2× `User Kế toán trưởng login, chọn <Trả lại>, nhập ý kiến, xác nhận → bản ghi chuyển "Yêu cầu chỉnh sửa".`
- 2× `User Kế toán phó login, chọn <Trả lại>, nhập ý kiến, xác nhận → bản ghi chuyển "Yêu cầu chỉnh sửa".`
- 2× `Thực hiện thao tác Từ chối (DN từ chối) hoặc NH từ chối đối với đề nghị LC.`
- 2× `Quan sát trường [Lý do từ chối] trên màn hình.`
- 2× `Tại màn hình, nhấn nút "Từ chối" và quan sát kết quả xử lý.`

TC: 10–11, 13–17, 116, 118–121, 125, 130, 134, 145, 152, 177, 562, 599, 619–621, 623, 625–633, 635, 666, 720

## 9. [FO] Hủy / Xóa đề nghị

**33 dòng · 27 TC · 26 cách viết**

Cách viết phổ biến:

- 2× `[Điều kiện tiền đề] NSD đã đăng nhập, đủ phân quyền; đang ở popup xác nhận Hủy giao dịch (đã thực hiện thao tác chọn <Hủy đề nghị> trên một giao dịch hợp lệ).`
- 2× `Từ màn hình chi tiết giao dịch có TT = Yêu cầu bổ sung, chọn <Hủy đề nghị> để mở popup xác nhận.`
- 2× `[Điều kiện tiền đề] NSD đủ điều kiện và đã thực hiện Hủy đề nghị thành công đối với giao dịch có liên kết dữ liệu sang BO.`
- 2× `Thực hiện luồng Hủy đề nghị thành công (chọn <Hủy đề nghị> > popup xác nhận > chọn <Có>) trên giao dịch có bản ghi tương ứng ở BO.`
- 2× `Chọn chức năng <Xóa đề nghị>.`

TC: 9, 13, 121, 126, 147, 511, 517, 553–554, 556–561, 563–564, 568–574, 576, 578–579

## 10. [FO] Mở lại & chỉnh sửa bản ghi

**44 dòng · 31 TC · 35 cách viết**

Cách viết phổ biến:

- 3× `Maker mở lại bản ghi vừa lưu nháp, đẩy giao dịch lên cấp duyệt → bản ghi chuyển "Chờ duyệt".`
- 3× `User Maker chỉnh sửa thông tin, gửi lại bản ghi → "Chờ duyệt".`
- 2× `User Kế toán trưởng login, chọn <Trả lại>, nhập ý kiến, xác nhận → bản ghi chuyển "Yêu cầu chỉnh sửa".`
- 2× `User Kế toán phó login, chọn <Trả lại>, nhập ý kiến, xác nhận → bản ghi chuyển "Yêu cầu chỉnh sửa".`
- 2× `Quan sát nút <Chỉnh sửa> và chọn <Chỉnh sửa>.`

TC: 5–9, 13–17, 121, 123–124, 149, 178, 256, 267, 522, 541–548, 677, 684, 738, 769–770

## 11. [BO] Tiền đề: đề nghị FO đã gửi sang BO (Chờ tiếp nhận)

**46 dòng · 46 TC · 2 cách viết**

Cách viết phổ biến:

- 45× `Giao dịch đề nghị phát hành LC đã được FO gửi sang BO, TT trên BO = Chờ tiếp nhận`
- 1× `Truy vấn giao dịch/ Nhấn hyperlink (TT=Chờ tiếp nhận)`

TC: 18–37, 41–65, 1012

## 12. [BO] Login BO theo vai trò (CA / CA lead / CRC / CRC lead / BGĐ CN)

**72 dòng · 67 TC · 7 cách viết**

Cách viết phổ biến:

- 50× `CA đăng nhập BO → Danh sách (tab Cần xử lý) → chọn giao dịch → nhấn <Tiếp nhận>`
- 12× `Đăng nhập thành công hệ thống`
- 6× `ĐK: "Đăng nhập thành công`
- 1× `User đăng nhập vào hệ thống`
- 1× `Login hệ thống tứ 2 user trở lên`

TC: 18–37, 41–65, 799–800, 867–868, 1012, 1218–1219, 1242–1243, 1248, 1416–1417, 1453–1454, 1487–1488, 1519–1520, 1542–1543, 1565–1566

## 13. [BO] Truy vấn / mở giao dịch theo trạng thái

**493 dòng · 425 TC · 15 cách viết**

Cách viết phổ biến:

- 294× `Truy vấn giao dịch/ Nhấn hyperlink (TT= CBTĐ xử lý)`
- 50× `CA đăng nhập BO → Danh sách (tab Cần xử lý) → chọn giao dịch → nhấn <Tiếp nhận>`
- 36× `Chọn Xem chi tiết giao dịch có TT = "CB QLN xử lý`
- 33× `CA lead mở giao dịch (TT = QLTĐ phê duyệt) → nhấn <Phê duyệt>`
- 26× `Click TT = CB QLN xử lý`

TC: 18–37, 41–65, 873–877, 880–992, 998–1004, 1012, 1014–1136, 1251–1357, 1445–1447, 1491, 1525, 1527, 1534–1536, 1538, 1548, 1550, 1557–1559, 1561, 1572–1577, 1579–1580

## 14. [BO] CA tiếp nhận

**140 dòng · 62 TC · 15 cách viết**

Cách viết phổ biến:

- 50× `CA đăng nhập BO → Danh sách (tab Cần xử lý) → chọn giao dịch → nhấn <Tiếp nhận>`
- 45× `Giao dịch đề nghị phát hành LC đã được FO gửi sang BO, TT trên BO = Chờ tiếp nhận`
- 21× `CRC tiếp nhận/mở giao dịch (TT = CB QLN xử lý), nhập thông tin xử lý, chọn đề xuất phê duyệt (1) → nhấn <Gửi duyệt>`
- 5× `ĐK: Cán bộ CRC đã thực hiện tiếp nhận giao dịch`
- 4× `CRC tiếp nhận điện, chọn BGĐ CN ký → CRC lead phê duyệt → BGĐ CN ký số cá nhân điện phát hành LC`

TC: 18–37, 41–65, 1011–1013, 1247–1249, 1376–1380, 1525, 1527, 1538, 1548, 1550, 1561

## 15. [BO] Nhập thông tin xử lý tác nghiệp (CA/CRC) + chọn đề xuất (1) duyệt / (2) từ chối

**92 dòng · 42 TC · 9 cách viết**

Cách viết phổ biến:

- 30× `CA nhập thông tin xử lý, chọn đề xuất phê duyệt (1) → nhấn <Gửi duyệt>`
- 21× `CRC tiếp nhận/mở giao dịch (TT = CB QLN xử lý), nhập thông tin xử lý, chọn đề xuất phê duyệt (1) → nhấn <Gửi duyệt>`
- 12× `CA nhập thông tin xử lý, chọn đề xuất từ chối (2) → nhấn <Gửi duyệt>`
- 12× `CRC nhập thông tin xử lý, chọn đề xuất từ chối (2) → nhấn <Gửi duyệt>`
- 5× `CRC chỉnh sửa thông tin xử lý theo lý do trả lại, chọn đề xuất phê duyệt (1) → nhấn <Gửi duyệt>`

TC: 18–22, 26–37, 41–65

## 16. [BO] Lưu / Gửi duyệt

**182 dòng · 125 TC · 23 cách viết**

Cách viết phổ biến:

- 39× `Tại MH xử lý - Gửi duyệt`
- 30× `CA nhập thông tin xử lý, chọn đề xuất phê duyệt (1) → nhấn <Gửi duyệt>`
- 21× `CRC tiếp nhận/mở giao dịch (TT = CB QLN xử lý), nhập thông tin xử lý, chọn đề xuất phê duyệt (1) → nhấn <Gửi duyệt>`
- 15× `ĐK: Giao dịch đã được cán bộ CRC xử lý hoặc Gửi duyệt`
- 12× `CA nhập thông tin xử lý, chọn đề xuất từ chối (2) → nhấn <Gửi duyệt>`

TC: 18–22, 26–37, 41–65, 1137–1152, 1154, 1156, 1170–1172, 1222, 1234–1235, 1262, 1268, 1280, 1286, 1292, 1298, 1358–1374, 1376–1380, 1382–1383, 1390–1392, 1423, 1425, 1427, 1429, 1432–1433, 1440–1443, 1457, 1492–1496, 1527, 1529–1532, 1550, 1552–1555

## 17. [BO] Lãnh đạo phê duyệt (CA lead / CRC lead / BGĐ CN, theo thẩm quyền)

**199 dòng · 68 TC · 32 cách viết**

Cách viết phổ biến:

- 33× `CA lead mở giao dịch (TT = QLTĐ phê duyệt) → nhấn <Phê duyệt>`
- 30× `CA nhập thông tin xử lý, chọn đề xuất phê duyệt (1) → nhấn <Gửi duyệt>`
- 21× `CRC tiếp nhận/mở giao dịch (TT = CB QLN xử lý), nhập thông tin xử lý, chọn đề xuất phê duyệt (1) → nhấn <Gửi duyệt>`
- 16× `CRC lead phê duyệt (1) – giao dịch không thuộc thẩm quyền BGĐ CN`
- 8× `BGĐ CN phê duyệt đề xuất từ chối (2)`

TC: 18–22, 26–37, 41–65, 1158, 1221, 1416, 1445–1447, 1453, 1456–1458, 1474–1475, 1525–1526, 1528, 1534–1536, 1538, 1548–1549, 1551, 1557–1559, 1561

## 18. [BO] Trả lại / Từ chối

**133 dòng · 55 TC · 38 cách viết**

Cách viết phổ biến:

- 12× `CA nhập thông tin xử lý, chọn đề xuất từ chối (2) → nhấn <Gửi duyệt>`
- 12× `CRC nhập thông tin xử lý, chọn đề xuất từ chối (2) → nhấn <Gửi duyệt>`
- 11× `CA nhấn <Trả lại>, nhập Lý do trả lại (bắt buộc, tối đa 2000 ký tự) → xác nhận`
- 8× `BGĐ CN phê duyệt đề xuất từ chối (2)`
- 7× `CA lead phê duyệt đề xuất từ chối và chọn gửi duyệt BGĐ CN (thuộc thẩm quyền BGĐ CN)`

TC: 22–25, 33–37, 42–65, 1162–1165, 1167–1169, 1226–1227, 1386–1387, 1431–1433, 1460–1463, 1465–1468

## 19. [BO] Phân công lại

**4 dòng · 4 TC · 1 cách viết**

Cách viết phổ biến:

- 4× `Nhấn <Phân công lại>`

TC: 1230, 1232, 1436, 1438

## 20. [BO] Ký số điện phát hành LC

**49 dòng · 30 TC · 16 cách viết**

Cách viết phổ biến:

- 6× `Hệ thống TI (ngoại vi) trả kết quả điện phát hành MT700 về BO (FO yêu cầu điện phát hành là bản điện tử có ký số)`
- 6× `Hệ thống tự động gọi API ký số pháp nhân → FO Maker nhận file điện có chữ ký số của NH`
- 5× `FO sửa giao dịch → đẩy duyệt → ký số cá nhân và ký số pháp nhân → gửi lại CA ở BO`
- 4× `Hệ thống TI (ngoại vi) trả kết quả điện phát hành MT700 về BO (FO yêu cầu điện phát hành là bản không ký số)`
- 4× `CRC tiếp nhận điện, chọn BGĐ CN ký → CRC lead phê duyệt → BGĐ CN ký số cá nhân điện phát hành LC`

TC: 18–21, 27–33, 47, 49, 59, 61, 829, 1482, 1484–1486, 1519, 1538–1542, 1561–1564

## 21. [BO] TI trả kết quả / đẩy sang TI

**26 dòng · 23 TC · 9 cách viết**

Cách viết phổ biến:

- 10× `Hệ thống TI (ngoại vi) trả kết quả điện phát hành MT700 về BO`
- 6× `Hệ thống TI (ngoại vi) trả kết quả điện phát hành MT700 về BO (FO yêu cầu điện phát hành là bản điện tử có ký số)`
- 4× `Hệ thống TI (ngoại vi) trả kết quả điện phát hành MT700 về BO (FO yêu cầu điện phát hành là bản không ký số)`
- 1× `BGĐ CN phê duyệt (1); hệ thống đẩy giao dịch sang TI, tích hợp BO → TI bị lỗi`
- 1× `BGĐ CN thực hiện lại <Phê duyệt> (tích hợp BO → TI đã hoạt động bình thường)`

TC: 18–22, 26–37, 41–43, 54–55, 1009

## 22. [Chung] Upload tài liệu (popup Thêm tài liệu)

**107 dòng · 74 TC · 26 cách viết**

Cách viết phổ biến:

- 34× `Click nút <Tải lên>`
- 17× `Click nút <Chọn tệp>`
- 8× `Popup "Thêm tài liệu" đang mở.`
- 6× `Kéo thả file hợp lệ vào button <Tải lên>`
- 5× `Popup Thêm tài liệu đang mở.`

TC: 507, 515, 518–519, 524, 526–527, 529–532, 670–674, 686, 755, 777–785, 787–793, 795, 1129, 1137–1152, 1154, 1358–1374, 1576–1577, 1579–1580

## 23. [Chung] Tìm kiếm / bộ lọc

**82 dòng · 59 TC · 45 cách viết**

Cách viết phổ biến:

- 12× `Nhập dữ liệu tìm kiếm`
- 10× `Nhấn <Tìm kiếm>`
- 10× `Nhấn tìm kiếm`
- 3× `Nhấn <Áp dụng>.`
- 3× `User đang ở màn hình Danh sách và tìm kiếm giao dịch (khung tìm kiếm/bộ lọc nâng cao).`

TC: 67–68, 70–78, 80, 91–92, 107–114, 230–231, 308, 484, 487–490, 564, 708, 765–766, 819, 832–835, 837–838, 840–841, 843–844, 846–847, 849–850, 852, 854–856, 858–859, 861–862, 864, 866

## 24. [Chung] Xem / tải file (TBTN, tác nghiệp, YCXL, hồ sơ KH)

**61 dòng · 35 TC · 6 cách viết**

Cách viết phổ biến:

- 26× `Nhấn <Xem file tác nghiệp>`
- 11× `Chọn File YCXL giao dịch (.doc)`
- 8× `Chọn File TBTN (.pdf)`
- 7× `Chọn định dạng xem file (.doc hoặc .pdf)`
- 7× `Nhấn <Tải hồ sơ khách hàng>`

TC: 1159, 1170–1172, 1217, 1234–1235, 1237, 1390–1392, 1415, 1440–1443, 1448, 1470–1472, 1476, 1494–1496, 1529–1532, 1537, 1552–1555, 1560, 1578

