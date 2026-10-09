# BO – Test case khó automation

Nguồn: `VCB_TradeFlat_Testcase_SIT_LC_ISS_Phat Hanh v1.1 (1).xlsx`, sheet `Tinh chỉnh`. **Row** = số dòng trong Excel.

Mỗi TC chỉ nằm ở **1 nhóm** (nhóm khó nhất). BO không có OTP/2FA.

## ⚠ Điều kiện tiên quyết cho TOÀN BỘ BO

Mọi TC BO cần đề nghị FO đã ở trạng thái **Đã gửi ngân hàng**, tức là FO đã qua **OTP + ký số**. Nếu FO không automate được bước đó → BO cần seed dữ liệu (API/DB) hoặc chuẩn bị tay trước mỗi lần chạy. Các luồng E2E BO (TC 18–65) đều đi qua ký số điện phát hành và TI.

## Tóm tắt

| Nhóm | Số TC | Mức độ |
|---|---|---|
| Ký số cá nhân / pháp nhân điện phát hành LC | 15 | 🔴 Chặn bước cuối của mọi luồng phát hành; USB token = manual |
| Tích hợp TI (đẩy sang TI, dữ liệu TI trả về) | 26 | 🔴 Cần TI SIT hoạt động / mock |
| Phụ thuộc trạng thái sau ký số / TI (Đã phát hành điện LC, Hoàn thành – Chờ bổ sung) | 48 | 🟠 Cần seed dữ liệu |
| Kiểm tra email | 21 | 🟡 Cần mailbox test |
| Đối chiếu dữ liệu DB (CMN_*, EG_EVENT_LOG, MasterRef…) | 9 | 🟡 Cần quyền đọc DB |
| Nội dung file sinh ra (TBTN, file tác nghiệp, YCXL – .doc/.pdf) | 91 | 🟡 Cần tải và đọc file (parse doc/pdf) |
| **Tổng** | **210** / 783 TC BO (không tính E2E) | |

## Ký số cá nhân / pháp nhân điện phát hành LC (15)

| # | TC | Row | Bước | Summary |
|---|---|---|---|---|
| 1 | 1482 | 1483 | B12 | [Ký số cá nhân Điện phát hành LC] Ký số cá nhân – Kiểm tra khi nhấn nút → - Hiển thị khung preview văn bản, cho phép người dùng xem lại nội dun… |
| 2 | 1483 | 1484 | B12 | [Ký số cá nhân Điện phát hành LC] Ký số cá nhân – Kiểm tra nội dung preview → Hiển thị đúng thông tin/Nội dung Điện phát hành LC TI trả về Cho phép… |
| 3 | 1484 | 1485 | B12 | [Ký số cá nhân Điện phát hành LC] Ký số online – Kiểm tra khi nhấn nút → 1. Hệ thống ETL từ AVS sang EG để kiểm tra thông tin banker user gắn … |
| 4 | 1485 | 1486 | B12 | [Ký số cá nhân Điện phát hành LC] Ký số USB – Kiểm tra khi nhấn nút → 1. Người dùng thao tác ký số thành công, hiển thị màn hình thông báo … |
| 5 | 1486 | 1487 | B12 | [Ký số pháp nhân Điện phát hành LC] Kiểm tra chức năng Ký số pháp nhân → - Hệ thống call API ký số pháp nhân tự động trên BO. Hệ thống tự động… |
| 6 | 1526 | 1527 | B14 | [Phê duyệt] Popup – Kiểm tra khi nhấn nút Phê duyệt → - Hiển thị màn hình chức năng ký số cá nhân, xem chi tiết có nút <Ký … |
| 7 | 1538 | 1539 | B14 | [Ký số cá nhân điện phát hành LC] Ký số cá nhân – Kiểm tra khi nhấn nút → - Hiển thị khung preview văn bản, cho phép người dùng xem lại nội dun… |
| 8 | 1539 | 1540 | B14 | [Ký số cá nhân điện phát hành LC] Ký số online – Kiểm tra khi nhấn nút → 1. Hệ thống ETL từ AVS sang EG để kiểm tra thông tin banker user gắn … |
| 9 | 1540 | 1541 | B14 | [Ký số cá nhân điện phát hành LC] Ký số USB – Kiểm tra khi nhấn nút → 1. Người dùng thao tác ký số thành công, hiển thị màn hình thông báo … |
| 10 | 1541 | 1542 | B14 | [Ký số pháp nhân điện phát hành LC] Chọn tệp tin – Kiểm tra chức năng Ký số pháp nhân → - Hệ thống call API ký số pháp nhân tự động trên BO. Hệ thống… |
| 11 | 1549 | 1550 | B15 | [Phê duyệt] Popup – Kiểm tra khi nhấn nút Phê duyệt → - Hiển thị màn hình chức năng ký số cá nhân, xem chi tiết có nút <Ký … |
| 12 | 1561 | 1562 | B15 | [Ký số cá nhân điện phát hành LC] Ký số cá nhân – Kiểm tra khi nhấn nút → - Hiển thị khung preview văn bản, cho phép người dùng xem lại nội dun… |
| 13 | 1562 | 1563 | B15 | [Ký số cá nhân điện phát hành LC] Ký số online – Kiểm tra khi nhấn nút → 1. Hệ thống ETL từ AVS sang EG để kiểm tra thông tin banker user gắn … |
| 14 | 1563 | 1564 | B15 | [Ký số cá nhân điện phát hành LC] Ký số USB – Kiểm tra khi nhấn nút → 1. Người dùng thao tác ký số thành công, hiển thị màn hình thông báo … |
| 15 | 1564 | 1565 | B15 | [Ký số pháp nhân điện phát hành LC] Xác nhận bổ sung – Kiểm tra chức năng Ký số pháp nhân → - Hệ thống call API ký số pháp nhân tự động trên BO. Hệ t… |

## Tích hợp TI (đẩy sang TI, dữ liệu TI trả về) (26)

| # | TC | Row | Bước | Summary |
|---|---|---|---|---|
| 1 | 810 | 811 | B01 | [List] Quan sát cột Số L/C – Kiểm tra dữ liệu hiển thị → Hiển thị chính xác thông tin số L/C do TI trả ra khi đề nghị đã lấy đ… |
| 2 | 817 | 818 | B01 | [List] Quan sát cột Ngày phát hành – Kiểm tra dữ liệu hiển thị → Hiển thị chính xác thông tin ngày phát hành L/C do TI trả ra khi đề n… |
| 3 | 818 | 819 | B01 | [List] Quan sát cột Ngày hết hiệu lực – Kiểm tra dữ liệu hiển thị → Hiển thị chính xác thông tin ngày hết hiệu lực L/C do TI trả ra khi đ… |
| 4 | 827 | 828 | B01 | [Xem chi tiết] Kết quả xử lý giao dịch – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị các trường thông tin: - Số tham chiếu LC - label (số tr… |
| 5 | 828 | 829 | B01 | [Xem chi tiết] Số tham chiếu LC – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị dữ liệu master ref (TI) trả về lấy thông tin tại trường ti-e… |
| 6 | 870 | 871 | B02 | [Xem chi tiết] Yêu cầu chữ ký số trên điện LC – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị các trường thông tin: - Số tham chiếu LC - label… |
| 7 | 1005 | 1006 | B02 | [Xem chi tiết] Kết quả xử lý giao dịch – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị các trường thông tin: - Số tham chiếu LC - label (số tr… |
| 8 | 1006 | 1007 | B02 | [Xem chi tiết] Số tham chiếu LC – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị dữ liệu master ref (TI) trả về lấy thông tin tại trường Mast… |
| 9 | 1238 | 1239 | B06 | [Xem chi tiết] Điện phát hành LC – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị các trường thông tin: - Số tham chiếu LC - label (số trả ra … |
| 10 | 1239 | 1240 | B06 | [Xem chi tiết] Số tham chiếu LC – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị dữ liệu master ref (TI) trả về lấy thông tin tại trường Mast… |
| 11 | 1408 | 1409 | B09 | [CRC_xem File tác nghiệp] VI. TÁC NGHIỆP CỦA BỘ PHẬN CRC – Kiểm tra thông tin gen file → Hiển thị đúng tên tiêu đề - data mục V được gen khi hệ thống… |
| 12 | 1411 | 1412 | B09 | [CRC_xem File tác nghiệp] Đã lập Yêu cầu xử lý giao dịch TTTM gửi Trung tâm TTTM kèm hình ảnh hồ sơ lúc – Kiểm tra thông tin gen file → Tick vào mục … |
| 13 | 1412 | 1413 | B09 | [CRC_xem File tác nghiệp] Đã in nội dung điện SWIFT mở L/C theo kết quả xử lý của Trung tâm TTTM – Kiểm tra thông tin gen file → Chỉ tick chọn sau kh… |
| 14 | 1413 | 1414 | B09 | [CRC_xem File tác nghiệp] Mã Cán bộ CRC trên VCBTI – Kiểm tra thông tin gen file → User maker event phát hành LC (Phát hành LC tại CN) hoặc User make… |
| 15 | 1414 | 1415 | B09 | [CRC_xem File tác nghiệp] Mã Lãnh đạo CRC trên VCBTI – Kiểm tra thông tin gen file → User checker (event phát hành LC, step: Authorise, status: Compl… |
| 16 | 1419 | 1420 | B10 | [Xem chi tiết] Lưới chức năng – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị các trường thông tin: - Số tham chiếu LC - label (số trả ra … |
| 17 | 1425 | 1426 | B10 | [Phê duyệt] Popup – Kiểm tra khi nhấn nút Phê duyệt → 1. Hệ thống thực hiện phê duyệt giao dịch thành công: hiển thị thông … |
| 18 | 1449 | 1450 | B10 | [Xem chi tiết] Kết quả xử lý giao dịch – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị các trường thông tin: - Số tham chiếu LC - label (số tr… |
| 19 | 1450 | 1451 | B10 | [Xem chi tiết] Số tham chiếu LC – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị dữ liệu master ref (TI) trả về lấy thông tin tại trường Mast… |
| 20 | 1456 | 1457 | B11 | [Phê duyệt] Popup – Kiểm tra khi nhấn nút Phê duyệt → 1. Hệ thống thực hiện phê duyệt giao dịch thành công: hiển thị thông … |
| 21 | 1477 | 1478 | B11 | [Xem chi tiết] Kết quả xử lý giao dịch – Kiểm tra thông tin tab Điện phát hành LC → Hiển thị các trường thông tin: - Số tham chiếu LC - label (số trả… |
| 22 | 1478 | 1479 | B11 | [Xem chi tiết] Số tham chiếu LC – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị dữ liệu master ref (TI) trả về lấy thông tin tại trường Mast… |
| 23 | 1522 | 1523 | B14 | [Xem chi tiết] V. PHÊ DUYỆT CỦA CẤP THẨM QUYỀN – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị các trường thông tin: - Số tham chiếu LC - labe… |
| 24 | 1528 | 1529 | B14 | [Phê duyệt] Popup – Kiểm tra khi nhấn nút Phê duyệt → 1. Hệ thống thực hiện phê duyệt giao dịch thành công: hiển thị thông … |
| 25 | 1545 | 1546 | B15 | [Xem chi tiết] Chọn tệp tin – Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị các trường thông tin: - Số tham chiếu LC - label (số trả ra … |
| 26 | 1551 | 1552 | B15 | [Phê duyệt] Popup – Kiểm tra khi nhấn nút Phê duyệt → 1. Hệ thống thực hiện phê duyệt giao dịch thành công: hiển thị thông … |

## Phụ thuộc trạng thái sau ký số / TI (Đã phát hành điện LC, Hoàn thành – Chờ bổ sung) (48)

| # | TC | Row | Bước | Summary |
|---|---|---|---|---|
| 1 | 1487 | 1488 | B13 | [Danh sách] Kiểm tra quyền truy cập → Chỉ thấy các giao dịch thuộc phạm vi phân quyền của user đang đăng nh… |
| 2 | 1488 | 1489 | B13 | [Danh sách (Mới bổ sung)] Lưới chức năng – Kiểm tra counter tab Tất cả/Cần xử lý/Đang theo dõi/Đã hoàn thành → 1. Số lượng Counter = số bản ghi của t… |
| 3 | 1489 | 1490 | B13 | [Xem chi tiết] Lịch sử giao dịch – Kiểm tra thông tin hiển thị trên màn hình xem chi tiết → Hiển thị dữ liệu: 1. Các trường thông tin: hiển thị đúng … |
| 4 | 1490 | 1491 | B13 | [Xem chi tiết] Lịch sử giao dịch – Kiểm tra chức năng khi nhấn nút Kiểm tra các hành động lưu lại lịch sử → Hệ thống mở tab xem chi tiết thông tin gh… |
| 5 | 1491 | 1492 | B13 | [Xử lý tác nghiệp] Kiểm tra trường Giao dịch TTTM thuộc thẩm quyền phê duyệt của Lãnh đạo chi nhánh/GĐ KH?? → Hiển thị 2 giá trị: (1) Không (2) Có |
| 6 | 1492 | 1493 | B13 | [Xử lý - Gửi duyệt] Gửi duyệt – Kiểm tra khi NSD thực hiện gửi duyệt → 1. Hệ thống thực hiện phê duyệt giao dịch thành công, hiển thị thông … |
| 7 | 1493 | 1494 | B13 | [Xử lý - Gửi duyệt] Gửi duyệt – Kiểm tra khi NSD thực hiện gửi duyệt → Đóng - Mở popup xác nhận gửi duyệt |
| 8 | 1494 | 1495 | B13 | [CRC_xem File tác nghiệp] Xem file tác nghiệp – Kiểm tra nhấn nút → Hiển thị 2 file: (1) File TBTN (.pdf) (2) File YCXL giao dịch (.doc) |
| 9 | 1495 | 1496 | B13 | [CRC_xem File tác nghiệp] File TBTN (.pdf) – Kiểm tra nhấn nút → 1. Hệ thống mở màn hình xem chi tiết file theo định dạng đã chọn với … |
| 10 | 1496 | 1497 | B13 | [CRC_xem File tác nghiệp] File YCXL giao dịch (.doc) – Kiểm tra nhấn nút → - Hệ thống mở màn hình view file và cho phép tải xuống và có tên fiel… |
| 11 | 1497 | 1498 | B13 | [CRC_xem File tác nghiệp] IV. KIỂM TRA CỦA BỘ PHẬN CRC – Kiểm tra thông tin gen file → Hiển thị đúng tên tiêu đề - thông tin được gen khi CB CRC nhấn… |
| 12 | 1498 | 1499 | B13 | [CRC_xem File tác nghiệp] 1. Đã nhận thông báo này kèm các tài liệu nêu tại mục III lúc […] – Kiểm tra thông tin gen file → Thời gian = Thời gian lãn… |
| 13 | 1499 | 1500 | B13 | [CRC_xem File tác nghiệp] 2.1. Hiệu lực của GHTD – Kiểm tra thông tin gen file → Hiển thị tích đúng với thông tin GLIMS trả ra tại: - GHTD nh (ngắn h… |
| 14 | 1500 | 1501 | B13 | [CRC_xem File tác nghiệp] 2.2. Hạn mức của HĐTD – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CRC Chọn hoặc/và nhập |
| 15 | 1501 | 1502 | B13 | [CRC_xem File tác nghiệp] Hạn mức còn được sử dụng – Kiểm tra thông tin gen file → Hiển thị giá trị theo API trả ra và hoặc CRC nhập |
| 16 | 1502 | 1503 | B13 | [CRC_xem File tác nghiệp] Thời hạn duy trì hạn mức – Kiểm tra thông tin gen file → Hiển thị giá trị theo API trả ra |
| 17 | 1503 | 1504 | B13 | [CRC_xem File tác nghiệp] 3. Kiểm tra tính đầy đủ, hợp lệ của Hồ sơ – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CRC Chọn hoặc/và nh… |
| 18 | 1504 | 1505 | B13 | [CRC_xem File tác nghiệp] 4. Kiểm tra sự phù hợp với mục đích cấp tín dụng và các điều kiện cấp tín dụng đã được phê duyệt và/hoặc HĐTD đã ký – Kiểm … |
| 19 | 1505 | 1506 | B13 | [CRC_xem File tác nghiệp] 5.Kiểm tra tình trạng nợ của khách hàng – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CRC Chọn hoặc/và nhập |
| 20 | 1506 | 1507 | B13 | [CRC_xem File tác nghiệp] 6. Kiểm tra việc đáp ứng tỷ lệ bảo đảm tối thiểu – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CRC Chọn hoặ… |
| 21 | 1507 | 1508 | B13 | [CRC_xem File tác nghiệp] 7. Kiểm tra tính tuân thủ – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CRC Chọn hoặc/và nhập Cán bộ chọn/n… |
| 22 | 1508 | 1509 | B13 | [CRC_xem File tác nghiệp] 8. Kết luận – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CRC Chọn hoặc/và nhập |
| 23 | 1509 | 1510 | B13 | [CRC_xem File tác nghiệp] 9. Giao dịch TTTM thuộc thẩm quyền phê duyệt của Lãnh đạo chi nhánh/GĐ KH? – Kiểm tra thông tin gen file → Hiển thị đúng nộ… |
| 24 | 1510 | 1511 | B13 | [CRC_xem File tác nghiệp] 10. Kết luận và đề xuất của BP CRC – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CRC Chọn hoặc/và nhập |
| 25 | 1511 | 1512 | B13 | [CRC_xem File tác nghiệp] Cán bộ CRC – Kiểm tra thông tin gen file → Hiển thị đúng họ và tên Cán bộ CRC thực hiện gửi duyệt và ghi nhận th… |
| 26 | 1512 | 1513 | B13 | [CRC_xem File tác nghiệp] VI. TÁC NGHIỆP CỦA BỘ PHẬN CRC – Kiểm tra thông tin gen file → Hiển thị đúng tên tiêu đề - data mục V được gen khi hệ thống… |
| 27 | 1513 | 1514 | B13 | [CRC_xem File tác nghiệp] Đã nhận Thông báo này và hồ sơ kèm theo lúc – Kiểm tra thông tin gen file → - Hiển thị thời gian của Cấp thẩm quyền tại mục… |
| 28 | 1514 | 1515 | B13 | [CRC_xem File tác nghiệp] Đã khoanh giữ tiền ký quỹ trên hệ thống theo chỉ thị. Tài khoản ký quỹ – Kiểm tra thông tin gen file → Hiển thị số tài khoả… |
| 29 | 1515 | 1516 | B13 | [CRC_xem File tác nghiệp] Đã lập Yêu cầu xử lý giao dịch TTTM gửi Trung tâm TTTM kèm hình ảnh hồ sơ lúc – Kiểm tra thông tin gen file → Tick vào mục … |
| 30 | 1516 | 1517 | B13 | [CRC_xem File tác nghiệp] Đã in nội dung điện SWIFT mở L/C theo kết quả xử lý của Trung tâm TTTM – Kiểm tra thông tin gen file → Chỉ tick chọn sau kh… |
| 31 | 1517 | 1518 | B13 | [CRC_xem File tác nghiệp] Mã Cán bộ CRC trên VCBTI – Kiểm tra thông tin gen file → User maker event phát hành LC (Phát hành LC tại CN) hoặc User make… |
| 32 | 1518 | 1519 | B13 | [CRC_xem File tác nghiệp] Mã Lãnh đạo CRC trên VCBTI – Kiểm tra thông tin gen file → User checker (event phát hành LC, step: Authorise, status: Compl… |
| 33 | 1565 | 1566 | B16 | [Danh sách] Tích hợp – Kiểm tra đẩy thông tin file lên ECM tại folder Temp → Mặc định hiển thị toàn bộ GD gửi tới CN theo HĐHMPHLC 0. Tất cả = Tất… |
| 34 | 1566 | 1567 | B16 | [Danh sách] Xác nhận hoàn thành – Kiểm tra counter tab Tất cả/Cần xử lý/Đang theo dõi/Đã hoàn thành → 1. Số lượng Counter = số bản ghi của từng tab 2… |
| 35 | 1567 | 1568 | B16 | [Xem chi tiết] Xác nhận hoàn thành – Kiểm tra thông tin hiển thị trên màn hình → Hiển thị dữ liệu: 1. Các trường thông tin: Hiển thị đúng các trường … |
| 36 | 1568 | 1569 | B16 | [Xem chi tiết] Kiểm tra thông tin tab Điện phát hành L/C → Hiển thị các trường thông tin: - Số tham chiếu LC - label (số trả ra … |
| 37 | 1569 | 1570 | B16 | [Xem chi tiết] Kiểm tra thông tin tab Hồ sơ hậu kiểm → Hiển thị các trường thông tin: - Danh mục bổ sung lần - label: Hiển t… |
| 38 | 1570 | 1571 | B16 | [Xem chi tiết] Lịch sử giao dịch – Kiểm tra chức năng khi người dùng click vào → Hiển thị popup có các trường thông tin và hiển thị giá trị tương ứng… |
| 39 | 1571 | 1572 | B16 | [Xem chi tiết] Lịch sử giao dịch – Kiểm tra các hành động lưu lại lịch sử → Khi người dùng thực hiện các chức năng dưới đây: 1. FO duyệt cuối (tr… |
| 40 | 1572 | 1573 | B16 | [Hồ sơ hậu kiểm] Kiểm tra trường Loại hồ sơ → 1. Hiển thị danh mục các loại tài liệu được cấu hình trong hệ thống t… |
| 41 | 1573 | 1574 | B16 | [Hồ sơ hậu kiểm] Kiểm tra trường Loại hồ sơ → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thông tin] |
| 42 | 1574 | 1575 | B16 | [Hồ sơ hậu kiểm] Kiểm tra trường Hình thức → Cho phép chọn 1 trong các giá trị: 1. Ký số 2. Không ký số |
| 43 | 1575 | 1576 | B16 | [Hồ sơ hậu kiểm] Kiểm tra trường Hình thức → Hiển thị MSG "Vui lòng chọn" + [Trường thông tin] |
| 44 | 1576 | 1577 | B16 | [Xác nhận bổ sung theo lượt] Xác nhận bổ sung – Kiểm tra khi nhấn <Xác nhận bổ sung> → 1. Lưu thông tin hồ sơ upload, hiển thị lên màn hình theo dạng… |
| 45 | 1577 | 1578 | B16 | [Xác nhận bổ sung theo lượt] Xác nhận bổ sung – Kiểm tra validate khi bỏ trống trường bắt buộc → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thôn… |
| 46 | 1578 | 1579 | B16 | [Xác nhận bổ sung theo lượt] Tích hợp – Kiểm tra đẩy thông tin file lên ECM tại folder Temp → Hệ thống call API tới ECM để đẩy danh sách file của ngư… |
| 47 | 1579 | 1580 | B16 | [Xác nhận hoàn thành] Xác nhận hoàn thành – Kiểm tra khi nhấn <Xác nhận hoàn thành> → 1. Lưu thông tin hồ sơ upload, hiển thị lên màn hình theo dạng … |
| 48 | 1580 | 1581 | B16 | [Xác nhận hoàn thành] Xác nhận hoàn thành – Kiểm tra validate khi bỏ trống trường bắt buộc → Hiển thị MSG "Vui lòng nhập nội dung" + [Trường thông ti… |

## Kiểm tra email (21)

| # | TC | Row | Bước | Summary |
|---|---|---|---|---|
| 1 | 1158 | 1159 | B03 | [Xử lý - Gửi duyệt] Tích hợp – Kiểm tra nhấn nút Gửi duyệt → Hệ thống call API EMAIL service gửi thông báo EMAIL 03 tới người dùng… |
| 2 | 1164 | 1165 | B04 | [Xử lý - Trả lại] Tích hợp – Kiểm tra Thông báo + Nội dung email → - Gọi API tới hệ thống Email Service để gửi email tới người dùng Make… |
| 3 | 1169 | 1170 | B04 | [Xử lý - Từ chối] Tích hợp – Kiểm tra Thông báo + Nội dung email → Gọi API tới hệ thống Email Service để gửi email tới người dùng Maker … |
| 4 | 1221 | 1222 | B06 | [Phê duyệt] 5. Thời hạn duy trì hạn mức – Kiểm tra khi user thực hiện phê duyệt → 1. Hệ thống thực hiện phê duyệt giao dịch thành công, hiển thị thôn… |
| 5 | 1223 | 1224 | B06 | [Phê duyệt ĐXTC] Duyệt đề xuất – Kiểm tra xác thực thành công khi chọn duyệt đề xuất → 1. Hệ thống thực hiện phê duyệt giao dịch thành công: "Đã duyệ… |
| 6 | 1224 | 1225 | B06 | [Phê duyệt ĐXTC] Gửi duyệt BGĐ – Kiểm tra xác thực thành công khi chọn gửi duyệt BGĐ → 1. Hệ thống thực hiện phê duyệt giao dịch thành công: "Đã duyệ… |
| 7 | 1227 | 1228 | B06 | [Trả lại] Kiểm tra trường Ô nhập thông tin – Kiểm tra popup Trả lại giao dịch thành công → - Hệ thống show MSG: "Đã trả lại thành công - Bạn có thể x… |
| 8 | 1232 | 1233 | B06 | [Phân công lại] Kiểm tra trường Ô nhập thông tin – Kiểm trả Phân công lại thành công → 1. Hiển thị màn hình thông báo thành công 2. Hệ thống tạo tác … |
| 9 | 1382 | 1383 | B08 | [Xử lý - Gửi duyệt] Gửi duyệt – Kiểm tra khi NSD thực hiện gửi duyệt → 1. Hệ thống thực hiện phê duyệt giao dịch thành công, hiển thị thông … |
| 10 | 1387 | 1388 | B09 | [Xử lý - Trả lại] Popup trả lại – Trả lại giao dịch thành công → - Hệ thống show msg "Đã trả lại thành công. Bạn có thể xem trạng thái… |
| 11 | 1423 | 1424 | B10 | [Phê duyệt] Popup – Kiểm tra khi nhấn nút Phê duyệt → 1. Hệ thống thực hiện phê duyệt giao dịch thành công: hiển thị thông … |
| 12 | 1427 | 1428 | B10 | [Phê duyệt ĐXTC] Popup – Kiểm tra khi nhấn nút Phê duyệt → 1. Hệ thống thực hiện phê duyệt giao dịch thành công: hiển thị thông … |
| 13 | 1429 | 1430 | B10 | [Phê duyệt ĐXTC] Popup – Kiểm tra khi nhấn nút Duyệt và Gửi duyệt → 1. Hệ thống thực hiện phê duyệt giao dịch thành công: hiển thị thông … |
| 14 | 1432 | 1433 | B10 | [Trả lại] Trả lại giao dịch thành công → 1. Hệ thống show msg "Đã trả lại thành công. Bạn có thể xem trạng thá… |
| 15 | 1433 | 1434 | B10 | [Trả lại] Trả lại giao dịch thành công → 1. Hệ thống show msg "Đã trả lại thành công. Bạn có thể xem trạng thá… |
| 16 | 1438 | 1439 | B10 | [Phân công lại] Cấp Thẩm quyền – Kiểm tra Phân công lại thành công → 1. Hiển thị màn hình thông báo thành công 2. Hệ thống tạo tác vụ xử l… |
| 17 | 1457 | 1458 | B11 | [Phê duyệt ĐXTC] Popup – Kiểm tra khi nhấn nút Phê duyệt → 1. Hệ thống thực hiện phê duyệt giao dịch thành công: hiển thị thông … |
| 18 | 1458 | 1459 | B11 | [Phê duyệt ĐXTC] Popup – Kiểm tra khi nhấn nút Phê duyệt → 1. Hệ thống thực hiện phê duyệt giao dịch thành công: hiển thị thông … |
| 19 | 1466 | 1467 | B11 | [Trả lại] Hạn mức còn được sử dụng – Trả lại giao dịch thành công → 1. Hệ thống show msg "Đã trả lại thành công. Bạn có thể xem trạng thá… |
| 20 | 1467 | 1468 | B11 | [Trả lại] Thời hạn duy trì hạn mức – Trả lại giao dịch thành công → 1. Hệ thống show msg "Đã trả lại thành công. Bạn có thể xem trạng thá… |
| 21 | 1468 | 1469 | B11 | [Trả lại] 3. Kiểm tra tính đầy đủ, hợp lệ của Hồ sơ – Trả lại giao dịch thành công → 1. Hệ thống show msg "Đã trả lại thành công. Bạn có thể xem trạn… |

## Đối chiếu dữ liệu DB (CMN_*, EG_EVENT_LOG, MasterRef…) (9)

| # | TC | Row | Bước | Summary |
|---|---|---|---|---|
| 1 | 1173 | 1174 | B05 | [CA_Xem TBTN] Tên CBTĐ – Kiểm tra thông tin gen file → Hiển thị thông tin user CA đang login: [Full_name]. BO_User db Accces… |
| 2 | 1174 | 1175 | B05 | [CA_Xem TBTN] Mã cán bộ – Kiểm tra thông tin gen file → Hiển thị thông tin user CA đang login: [User_code]. BO_User db Access… |
| 3 | 1175 | 1176 | B05 | [CA_Xem TBTN] Chi nhánh VCB – Kiểm tra thông tin gen file → Hiển thị thông tin user CA đang login: [BRANCH_NAME_VN]. CMN_BRANCH D… |
| 4 | 1176 | 1177 | B05 | [CA_Xem TBTN] Mã Chi nhánh – Kiểm tra thông tin gen file → Hiển thị thông tin user CA đang login: [Branch_Code]. BO_User db Acce… |
| 5 | 1182 | 1183 | B05 | [CA_Xem TBTN] Phân hạng Khách hàng – Kiểm tra thông tin gen file → Hiển thị theo trường: [GUARANTEE_CIF_CLASSIFICATION]. EG_GUARANTEE_IS… |
| 6 | 1444 | 1445 | B10 | [Xem file tác nghiệp] Lãnh đạo CRC – Kiểm tra thông tin gen file → - Hiển thị đúng họ và tên lãnh đạo CRC thực hiện phê duyệt đang login… |
| 7 | 1473 | 1474 | B11 | [Xem file tác nghiệp] Cấp Thẩm quyền – Kiểm tra thông tin gen file → - Hiển thị đúng họ và tên BGĐ CN thực hiện phê duyệt đang login:[Full… |
| 8 | 1533 | 1534 | B14 | [Xem file tác nghiệp] Lãnh đạo CRC – Kiểm tra thông tin gen file → - Hiển thị đúng họ và tên lãnh đạo CRC thực hiện phê duyệt đang login… |
| 9 | 1556 | 1557 | B15 | [Xem file tác nghiệp] Lãnh đạo CRC – Kiểm tra thông tin gen file → - Hiển thị đúng họ và tên lãnh đạo CRC thực hiện phê duyệt đang login… |

## Nội dung file sinh ra (TBTN, file tác nghiệp, YCXL – .doc/.pdf) (91)

| # | TC | Row | Bước | Summary |
|---|---|---|---|---|
| 1 | 1170 | 1171 | B05 | [CA_Xem TBTN] Xem file tác nghiệp – Kiểm tra nhấn nút → Hiển thị 2 file: (1) File TBTN (.pdf) (2) File YCXL giao dịch (.doc) |
| 2 | 1171 | 1172 | B05 | [CA_Xem TBTN] File TBTN (.pdf) – Kiểm tra nhấn nút → 1. Hệ thống mở màn hình xem chi tiết file theo định dạng đã chọn với … |
| 3 | 1172 | 1173 | B05 | [CA_Xem TBTN] File YCXL giao dịch (.doc) – Kiểm tra nhấn nút → - Hệ thống mở màn hình view file và cho phép tải xuống và có tên fiel… |
| 4 | 1177 | 1178 | B05 | [CA_Xem TBTN] Ngày lập – Kiểm tra thông tin gen file → Ghi nhận thời gian khi user nhấn Lưu/Gửi duyệt Format: DD/MM/YYYY |
| 5 | 1178 | 1179 | B05 | [CA_Xem TBTN] Giờ – Kiểm tra thông tin gen file → Ghi nhận thời gian khi user nhấn Lưu/Gửi duyệt Format: HH:MM |
| 6 | 1179 | 1180 | B05 | [CA_Xem TBTN] Loại giao dịch – Kiểm tra thông tin gen file → Mặc định = Đề nghị phát hành LC |
| 7 | 1180 | 1181 | B05 | [CA_Xem TBTN] Tên Khách hàng – Kiểm tra thông tin gen file → Hiển thị đúngtrường Tên khách hàng từ FO gửi sang |
| 8 | 1181 | 1182 | B05 | [CA_Xem TBTN] CIF – Kiểm tra thông tin gen file → Hiển thị CIFno của Khách hàng |
| 9 | 1183 | 1184 | B05 | [CA_Xem TBTN] Giấy đề nghị mở L/C, điều chỉnh L/C – Kiểm tra thông tin gen file → Hiển thị mã giao dịch trên FO gửi sang |
| 10 | 1184 | 1185 | B05 | [CA_Xem TBTN] Ngày – Kiểm tra thông tin gen file → Hiển thị ngày giao dịch được đẩy sang BO |
| 11 | 1185 | 1186 | B05 | [CA_Xem TBTN] Số tiền đề nghị tài trợ – Kiểm tra thông tin gen file → Hiển thị đúng dữ liệu được nối chuỗi của các giá trị gồm: + Giá trị L… |
| 12 | 1186 | 1187 | B05 | [CA_Xem TBTN] Thời hạn cấp tín dụng của L/C – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CA Chọn hoặc/và Nhập |
| 13 | 1187 | 1188 | B05 | [CA_Xem TBTN] Mục đích phát hành L/C – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CA Chọn hoặc/và Nhập |
| 14 | 1188 | 1189 | B05 | [CA_Xem TBTN] HĐTD theo hạn mức số – Kiểm tra thông tin gen file → Hiển thị đúng số HĐTD lấy từ đề nghị do FO gửi sang |
| 15 | 1189 | 1190 | B05 | [CA_Xem TBTN] Ngày – Kiểm tra thông tin gen file → Hiển thị đúng ngày bắt đầu hiệu lực gắn với số HĐTD lấy từ đề nghị do… |
| 16 | 1190 | 1191 | B05 | [CA_Xem TBTN] Ký quỹ – Kiểm tra thông tin gen file → Hiển thị tick ở checkbox ở ô "Có ký quỹ" nếu CA có chọn hoặc/và Nhập |
| 17 | 1191 | 1192 | B05 | [CA_Xem TBTN] Tỷ lệ ký quỹ – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CA Chọn hoặc/và Nhập |
| 18 | 1192 | 1193 | B05 | [CA_Xem TBTN] Tài khoản trích tiền ký quỹ – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CA Chọn hoặc/và Nhập |
| 19 | 1193 | 1194 | B05 | [CA_Xem TBTN] Nguồn thanh toán L/C khi đến hạn – Kiểm tra thông tin gen file → Hiển thị tick ở checkbox ở đúng ô tương ứng giá trị CA có chọn hoặc/v… |
| 20 | 1194 | 1195 | B05 | [CA_Xem TBTN] Tài khoản (chọn nguồn thanh toán là: Tiền gửi tại VCB) – Kiểm tra thông tin gen file → Hiển thị đúng số tài khoản cán bộ CA Chọn hoặc/v… |
| 21 | 1195 | 1196 | B05 | [CA_Xem TBTN] Tài khoản (chọn nguồn thanh toán là: vay VCB) – Kiểm tra thông tin gen file → Hiển thị đúng số tài khoản cán bộ CA Chọn hoặc/và Nhập tư… |
| 22 | 1196 | 1197 | B05 | [CA_Xem TBTN] Nội dung (chọn nguồn thanh toán là: Khác) – Kiểm tra thông tin gen file → Hiển thị đúng số tài khoản cán bộ CA Chọn hoặc/và Nhập tương … |
| 23 | 1197 | 1198 | B05 | [CA_Xem TBTN] Tình hình khách hàng – Kiểm tra thông tin gen file → Hiển thị tick ở checkbox ở đúng ô tương ứng giá trị CA có chọn hoặc/v… |
| 24 | 1198 | 1199 | B05 | [CA_Xem TBTN] Nội dung (Chọn tình hình khách hàng = 3) – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CA Chọn hoặc/và Nhập, hiển thị p… |
| 25 | 1199 | 1200 | B05 | [CA_Xem TBTN] Mục đích phát hành L/C – Kiểm tra thông tin gen file → Hiển thị tick ở checkbox ở đúng ô tương ứng giá trị CA có chọn hoặc/v… |
| 26 | 1200 | 1201 | B05 | [CA_Xem TBTN] Khả năng thực hiện điều kiện tín dụng – Kiểm tra thông tin gen file → Hiển thị tick ở checkbox ở đúng ô tương ứng giá trị CA có chọn ho… |
| 27 | 1201 | 1202 | B05 | [CA_Xem TBTN] STT (Bảng chỉ thị thu phí) – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CA Chọn hoặc/và Nhập |
| 28 | 1202 | 1203 | B05 | [CA_Xem TBTN] Loại phí (Bảng chỉ thị thu phí) – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CA Chọn hoặc/và Nhập |
| 29 | 1203 | 1204 | B05 | [CA_Xem TBTN] Số tiền tính phí (Bảng chỉ thị thu phí) – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CA Chọn hoặc/và Nhập |
| 30 | 1204 | 1205 | B05 | [CA_Xem TBTN] Loại tiền (Bảng chỉ thị thu phí) – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CA Chọn hoặc/và Nhập |
| 31 | 1205 | 1206 | B05 | [CA_Xem TBTN] Mức phí áp dụng (Bảng chỉ thị thu phí) – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CA Chọn hoặc/và Nhập |
| 32 | 1206 | 1207 | B05 | [CA_Xem TBTN] Số phí tối thiểu (Bảng chỉ thị thu phí) – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CA Chọn hoặc/và Nhập |
| 33 | 1207 | 1208 | B05 | [CA_Xem TBTN] Số phí tối đa (Bảng chỉ thị thu phí) – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CA Chọn hoặc/và Nhập |
| 34 | 1208 | 1209 | B05 | [CA_Xem TBTN] Thời điểm thu phí (Bảng chỉ thị thu phí) – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CA Chọn hoặc/và Nhập |
| 35 | 1209 | 1210 | B05 | [CA_Xem TBTN] Ghi chú (Bảng chỉ thị thu phí) – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CA Chọn hoặc/và Nhập |
| 36 | 1210 | 1211 | B05 | [CA_Xem TBTN] Tài khoản trích tiền thu phí – Kiểm tra thông tin gen file → Hiển thị đúng số tài khoản cán bộ CA Chọn hoặc/và Nhập |
| 37 | 1211 | 1212 | B05 | [CA_Xem TBTN] Số dư khả dụng – Kiểm tra thông tin gen file → Hiển thị đúng số dư gắn với tài khoản cán bộ CA Chọn hoặc/và Nhập Hiể… |
| 38 | 1212 | 1213 | B05 | [CA_Xem TBTN] Loại tài liệu (bảng hồ sơ đình kèm) – Kiểm tra thông tin gen file → Hiển thị đúng loại tài liệu Khách hàng gửi sang |
| 39 | 1213 | 1214 | B05 | [CA_Xem TBTN] Tên tài liệu (bảng hồ sơ đình kèm) – Kiểm tra thông tin gen file → Hiển thị đúng tên tài liệu từ FO gửi sang |
| 40 | 1214 | 1215 | B05 | [CA_Xem TBTN] Hình thức (bảng hồ sơ đình kèm) – Kiểm tra thông tin gen file → Hiển thị đúng hình thức: Hồ sơ có ký số hoặc Hồ sơ không có ký số trê… |
| 41 | 1215 | 1216 | B05 | [CA_Xem TBTN] Kết luận – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CA Chọn hoặc/và Nhập để từ đó hệ thống … |
| 42 | 1216 | 1217 | B05 | [CA_Xem TBTN] CBTĐ – Kiểm tra thông tin gen file → Hiển thị đúng họ và tên cán bộ CA thực hiện gửi duyệt và ghi nhận thờ… |
| 43 | 1234 | 1235 | B06 | [Xem TBTN] File TBTN (.pdf) – Kiểm tra nhấn nút → 1. Hệ thống mở màn hình xem chi tiết file theo định dạng đã chọn với … |
| 44 | 1235 | 1236 | B06 | [Xem TBTN] File YCXL giao dịch (.doc) – Kiểm tra nhấn nút → - Hệ thống mở màn hình view file và cho phép tải xuống và có tên fiel… |
| 45 | 1236 | 1237 | B06 | [Xem TBTN] QLTĐ/Lãnh đạo PKH – Kiểm tra thông tin gen file → Hiển thị đúng họ và tên lãnh đạo CA thực hiện phê duyệt và ghi nhận t… |
| 46 | 1390 | 1391 | B09 | [CRC_xem File tác nghiệp] Xem file tác nghiệp – Kiểm tra nhấn nút → Hiển thị 2 file: (1) File TBTN (.pdf) (2) File YCXL giao dịch (.doc) |
| 47 | 1391 | 1392 | B09 | [CRC_xem File tác nghiệp] File TBTN (.pdf) – Kiểm tra nhấn nút → 1. Hệ thống mở màn hình xem chi tiết file theo định dạng đã chọn với … |
| 48 | 1392 | 1393 | B09 | [CRC_xem File tác nghiệp] File YCXL giao dịch (.doc) – Kiểm tra nhấn nút → - Hệ thống mở màn hình view file và cho phép tải xuống và có tên fiel… |
| 49 | 1393 | 1394 | B09 | [CRC_xem File tác nghiệp] IV. KIỂM TRA CỦA BỘ PHẬN CRC – Kiểm tra thông tin gen file → Hiển thị đúng tên tiêu đề - thông tin được gen khi CB CRC nhấn… |
| 50 | 1394 | 1395 | B09 | [CRC_xem File tác nghiệp] 1. Đã nhận thông báo này kèm các tài liệu nêu tại mục III lúc […] – Kiểm tra thông tin gen file → Thời gian = Thời gian lãn… |
| 51 | 1395 | 1396 | B09 | [CRC_xem File tác nghiệp] 2.1. Hiệu lực của GHTD – Kiểm tra thông tin gen file → Hiển thị tích đúng với thông tin GLIMS trả ra tại: - GHTD nh (ngắn h… |
| 52 | 1396 | 1397 | B09 | [CRC_xem File tác nghiệp] 2.2. Hạn mức của HĐTD – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CRC Chọn hoặc/và nhập |
| 53 | 1397 | 1398 | B09 | [CRC_xem File tác nghiệp] Hạn mức còn được sử dụng – Kiểm tra thông tin gen file → Hiển thị giá trị theo API trả ra và hoặc CRC nhập |
| 54 | 1398 | 1399 | B09 | [CRC_xem File tác nghiệp] Thời hạn duy trì hạn mức – Kiểm tra thông tin gen file → Hiển thị giá trị theo API trả ra |
| 55 | 1399 | 1400 | B09 | [CRC_xem File tác nghiệp] 3. Kiểm tra tính đầy đủ, hợp lệ của Hồ sơ – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CRC Chọn hoặc/và nh… |
| 56 | 1400 | 1401 | B09 | [CRC_xem File tác nghiệp] 4. Kiểm tra sự phù hợp với mục đích cấp tín dụng và các điều kiện cấp tín dụng đã được phê duyệt và/hoặc HĐTD đã ký – Kiểm … |
| 57 | 1401 | 1402 | B09 | [CRC_xem File tác nghiệp] 5.Kiểm tra tình trạng nợ của khách hàng – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CRC Chọn hoặc/và nhập |
| 58 | 1402 | 1403 | B09 | [CRC_xem File tác nghiệp] 6. Kiểm tra việc đáp ứng tỷ lệ bảo đảm tối thiểu – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CRC Chọn hoặ… |
| 59 | 1403 | 1404 | B09 | [CRC_xem File tác nghiệp] 7. Kiểm tra tính tuân thủ – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CRC Chọn hoặc/và nhập Cán bộ chọn/n… |
| 60 | 1404 | 1405 | B09 | [CRC_xem File tác nghiệp] 8. Kết luận – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CRC Chọn hoặc/và nhập |
| 61 | 1405 | 1406 | B09 | [CRC_xem File tác nghiệp] 9. Giao dịch TTTM thuộc thẩm quyền phê duyệt của Lãnh đạo chi nhánh/GĐ KH? – Kiểm tra thông tin gen file → Hiển thị đúng nộ… |
| 62 | 1406 | 1407 | B09 | [CRC_xem File tác nghiệp] 10. Kết luận và đề xuất của BP CRC – Kiểm tra thông tin gen file → Hiển thị đúng nội dung cán bộ CRC Chọn hoặc/và nhập |
| 63 | 1407 | 1408 | B09 | [CRC_xem File tác nghiệp] Cán bộ CRC – Kiểm tra thông tin gen file → Hiển thị đúng họ và tên Cán bộ CRC thực hiện gửi duyệt và ghi nhận th… |
| 64 | 1409 | 1410 | B09 | [CRC_xem File tác nghiệp] Đã nhận Thông báo này và hồ sơ kèm theo lúc – Kiểm tra thông tin gen file → - Hiển thị thời gian của Cấp thẩm quyền tại mục… |
| 65 | 1410 | 1411 | B09 | [CRC_xem File tác nghiệp] Đã khoanh giữ tiền ký quỹ trên hệ thống theo chỉ thị. Tài khoản ký quỹ – Kiểm tra thông tin gen file → Hiển thị số tài khoả… |
| 66 | 1440 | 1441 | B10 | [Xem file tác nghiệp] Xem file tác nghiệp – Kiểm tra nhấn nút → Hiển thị 2 file: (1) File TBTN (.pdf) (2) File YCXL giao dịch (.doc) |
| 67 | 1441 | 1442 | B10 | [Xem file tác nghiệp] File TBTN (.pdf) – Kiểm tra nhấn nút → 1. Hệ thống mở màn hình xem chi tiết file theo định dạng đã chọn với … |
| 68 | 1442 | 1443 | B10 | [Xem file tác nghiệp] File YCXL giao dịch (.doc) – Kiểm tra nhấn nút → - Hệ thống mở màn hình view file và cho phép tải xuống và có tên fiel… |
| 69 | 1443 | 1444 | B10 | [Xem file tác nghiệp] File YCXL giao dịch (.doc) – Kiểm tra nhấn nút → - Hệ thống mở màn hình view file và cho phép tải xuống và có tên fiel… |
| 70 | 1445 | 1446 | B10 | [LD CRC_Xem file tác nghiệp] V. PHÊ DUYỆT CỦA CẤP THẨM QUYỀN – Kiểm tra thông tin gen file → Hệ thống hiển thị nội dung = thông tin lãnh đạo CRC khi … |
| 71 | 1446 | 1447 | B10 | [Xem file YCXL] Yêu cầu xử lý giao dịch – Kiểm tra thời điểm gen → Hệ thống gen file Yêu cầu xử lý giao dịch với nội dung các trường thô… |
| 72 | 1447 | 1448 | B10 | [Xem file YCXL] Yêu cầu xử lý giao dịch – Kiểm tra TH hiển thị nội dung mục V. TÁC NGHIỆP CỦA BỘ PHẬN CRC → Chưa hiển thị nội dung mục này |
| 73 | 1470 | 1471 | B11 | [Xem file tác nghiệp] Xem file tác nghiệp – Kiểm tra nhấn nút → Hiển thị 2 file: (1) File TBTN (.pdf) (2) File YCXL giao dịch (.doc) |
| 74 | 1471 | 1472 | B11 | [Xem file tác nghiệp] File TBTN (.pdf) – Kiểm tra nhấn nút → 1. Hệ thống mở màn hình xem chi tiết file theo định dạng đã chọn với … |
| 75 | 1472 | 1473 | B11 | [Xem file tác nghiệp] File YCXL giao dịch (.doc) – Kiểm tra nhấn nút → - Hệ thống mở màn hình view file và cho phép tải xuống và có tên fiel… |
| 76 | 1474 | 1475 | B11 | [BGD CN_Xem file tác nghiệp] V. PHÊ DUYỆT CỦA CẤP THẨM QUYỀN – Kiểm tra thông tin gen file → Hệ thống hiển thị nội dung mục V. = thông tin lãnh đạo C… |
| 77 | 1475 | 1476 | B11 | [Xem file tác nghiệp] Yêu cầu xử lý giao dịch – Kiểm tra thời điểm gen → Hệ thống gen file Yêu cầu xử lý giao dịch với nội dung các trường thô… |
| 78 | 1529 | 1530 | B14 | [Xem file tác nghiệp] Xem file tác nghiệp – Kiểm tra nhấn nút → Hiển thị 2 file: (1) File TBTN (.pdf) (2) File YCXL giao dịch (.doc) |
| 79 | 1530 | 1531 | B14 | [Xem file tác nghiệp] File TBTN (.pdf) – Kiểm tra nhấn nút → 1. Hệ thống mở màn hình xem chi tiết file theo định dạng đã chọn với … |
| 80 | 1531 | 1532 | B14 | [Xem file tác nghiệp] File YCXL giao dịch (.doc) – Kiểm tra nhấn nút → - Hệ thống mở màn hình view file và cho phép tải xuống và có tên fiel… |
| 81 | 1532 | 1533 | B14 | [Xem file tác nghiệp] File YCXL giao dịch (.doc) – Kiểm tra nhấn nút → - Hệ thống mở màn hình view file và cho phép tải xuống và có tên fiel… |
| 82 | 1534 | 1535 | B14 | [LD CRC_Xem file tác nghiệp] V. PHÊ DUYỆT CỦA CẤP THẨM QUYỀN – Kiểm tra thông tin gen file → Hệ thống hiển thị nội dung = thông tin lãnh đạo CRC khi … |
| 83 | 1535 | 1536 | B14 | [Xem file YCXL] Yêu cầu xử lý giao dịch – Kiểm tra thời điểm gen → Hệ thống gen file Yêu cầu xử lý giao dịch với nội dung các trường thô… |
| 84 | 1536 | 1537 | B14 | [Xem file YCXL] Yêu cầu xử lý giao dịch – Kiểm tra TH hiển thị nội dung mục V. TÁC NGHIỆP CỦA BỘ PHẬN CRC → Chưa hiển thị nội dung mục này |
| 85 | 1552 | 1553 | B15 | [Xem file tác nghiệp] Xem file tác nghiệp – Kiểm tra nhấn nút → Hiển thị 2 file: (1) File TBTN (.pdf) (2) File YCXL giao dịch (.doc) |
| 86 | 1553 | 1554 | B15 | [Xem file tác nghiệp] File TBTN (.pdf) – Kiểm tra nhấn nút → 1. Hệ thống mở màn hình xem chi tiết file theo định dạng đã chọn với … |
| 87 | 1554 | 1555 | B15 | [Xem file tác nghiệp] File YCXL giao dịch (.doc) – Kiểm tra nhấn nút → - Hệ thống mở màn hình view file và cho phép tải xuống và có tên fiel… |
| 88 | 1555 | 1556 | B15 | [Xem file tác nghiệp] File YCXL giao dịch (.doc) – Kiểm tra nhấn nút → - Hệ thống mở màn hình view file và cho phép tải xuống và có tên fiel… |
| 89 | 1557 | 1558 | B15 | [LD CRC_Xem file tác nghiệp] V. PHÊ DUYỆT CỦA CẤP THẨM QUYỀN – Kiểm tra thông tin gen file → Hệ thống hiển thị nội dung = thông tin lãnh đạo CRC khi … |
| 90 | 1558 | 1559 | B15 | [Xem file YCXL] Yêu cầu xử lý giao dịch – Kiểm tra thời điểm gen → Hệ thống gen file Yêu cầu xử lý giao dịch với nội dung các trường thô… |
| 91 | 1559 | 1560 | B15 | [Xem file YCXL] Yêu cầu xử lý giao dịch – Kiểm tra TH hiển thị nội dung mục V. TÁC NGHIỆP CỦA BỘ PHẬN CRC → Chưa hiển thị nội dung mục này |

## Câu hỏi cần VCB trả lời

- [ ] **Seed dữ liệu**: tạo đề nghị ở trạng thái *Đã gửi ngân hàng* (và các trạng thái BO sau) bằng API/DB được không?
- [ ] **Ký số điện phát hành trên SIT**: Ký số từ xa có CKS test tự động chấp nhận không? USB token chắc chắn manual.
- [ ] **TI SIT**: có hoạt động ổn định không, có mock trả số tham chiếu / điện phát hành không?
- [ ] **User test BO** cho từng vai trò: CA, CA lead, CRC, CRC lead, BGĐ CN (+ user chưa đăng ký CKS).
- [ ] **Mailbox test & quyền đọc DB**.

