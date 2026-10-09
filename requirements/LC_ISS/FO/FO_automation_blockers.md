# FO – Test case khó automation (OTP, Ký số, …)

Nguồn: `VCB_TradeFlat_Testcase_SIT_LC_ISS_Phat Hanh v1.1 (1).xlsx`, sheet `Tinh chỉnh`. **Row** = số dòng trong Excel (= TC + 1).

Một TC có thể xuất hiện ở nhiều nhóm (ví dụ E2E vừa cần OTP vừa cần ký số).

## Tóm tắt

| Nhóm | Số TC | Mức độ |
|---|---|---|
| 1. OTP / 2FA | 33 | 🔴 Chặn toàn bộ E2E |
| 2. Ký số cá nhân / pháp nhân | 27 | 🔴 Chặn toàn bộ E2E; USB token = manual |
| 3. Phụ thuộc trạng thái | ~75 | 🟠 Cần seed dữ liệu |
| 4. Lỗi API / hệ thống ngoài | 8 | 🟠 Cần mock hoặc test tay |
| 5. Email | 10 | 🟡 Cần mailbox test |
| 6. Log | 21 | 🟡 Cần quyền DB / log |
| 7. Hạn mức | 10 | 🟡 Cần dữ liệu đúng trạng thái |

## 1. OTP / 2FA

Kế toán phó / Kế toán trưởng phải xác thực 2FA khi Phê duyệt; Từ chối và Xóa cũng gọi popup Xác thực.

| # | TC | Row | Screen | Summary | Note |
|---|---|---|---|---|---|
| 1 | 1 | 2 | Tạo đề nghị phát hành | Luồng happy case 1 cấp duyệt không ký số pháp nhân | E2E – bước duyệt cần 2FA |
| 2 | 2 | 3 | Tạo đề nghị phát hành | Luồng happy case 1 cấp duyệt có ký số pháp nhân | E2E – bước duyệt cần 2FA |
| 3 | 3 | 4 | Tạo đề nghị phát hành | Luồng happy case 2 cấp duyệt không có ký số pháp nhân | E2E – bước duyệt cần 2FA |
| 4 | 4 | 5 | Tạo đề nghị phát hành | Luồng happy case 2 cấp duyệt có ký số pháp nhân | E2E – bước duyệt cần 2FA |
| 5 | 5 | 6 | Tạo đề nghị phát hành | Luồng lưu nháp rồi phát hành 1 cấp duyệt có ký số pháp nhân | E2E – bước duyệt cần 2FA |
| 6 | 6 | 7 | Tạo đề nghị phát hành | Luồng lưu nháp rồi phát hành 2 cấp duyệt có ký số pháp nhân | E2E – bước duyệt cần 2FA |
| 7 | 7 | 8 | Tạo đề nghị phát hành | Luồng lưu nháp rồi phát hành 1 cấp duyệt không có ký số pháp nhân | E2E – bước duyệt cần 2FA |
| 8 | 8 | 9 | Tạo đề nghị phát hành | Luồng lưu nháp rồi phát hành 2 cấp duyệt không có ký số pháp nhân | E2E – bước duyệt cần 2FA |
| 9 | 11 | 12 | Tạo đề nghị phát hành | Từ chối tại Chủ tài khoản | E2E – bước duyệt cần 2FA |
| 10 | 12 | 13 | Tạo đề nghị phát hành | Kiểm tra bước Ký số pháp nhân KHÔNG có tùy chọn Từ chối | E2E – bước duyệt cần 2FA |
| 11 | 14 | 15 | Tạo đề nghị phát hành | Yêu cầu chỉnh sửa rồi phát hành thành công luồng duyệt 1 cấp không ký số pháp nhân | E2E – bước duyệt cần 2FA |
| 12 | 15 | 16 | Tạo đề nghị phát hành | Yêu cầu chỉnh sửa rồi phát hành thành công luồng duyệt 1 cấp có ký số pháp nhân | E2E – bước duyệt cần 2FA |
| 13 | 16 | 17 | Tạo đề nghị phát hành | Yêu cầu chỉnh sửa rồi phát hành thành công luồng duyệt 2 cấp không ký số pháp nhân | E2E – bước duyệt cần 2FA |
| 14 | 17 | 18 | Tạo đề nghị phát hành | Yêu cầu chỉnh sửa rồi phát hành thành công luồng duyệt 2 cấp có ký số pháp nhân | E2E – bước duyệt cần 2FA |
| 15 | 601 | 602 | Phê duyệt | Kiểm tra luồng chính: Tổng Số tiền LC trong ngày của user <= Hạn mức phê duyệt của user thì hệ thống cho phép thực hiện phê duyệt | Phê duyệt |
| 16 | 603 | 604 | Phê duyệt | Kiểm tra khi NSD chọn <Phê duyệt> hệ thống hiển thị popup Xác thực và gọi API tới hệ thống 2FA để lấy danh sách phương thức xác thực khả dụng của người dùng (SMS OTP, Soft OTP) | Phê duyệt |
| 17 | 604 | 605 | Phê duyệt | Kiểm tra luồng chính: NSD nhập đúng mã xác thực trong thời gian hiệu lực OTP, chọn <Xác nhận> thì hệ thống xác thực thành công, hiển thị màn hình thông báo thành công và cập nhật trạng thái giao dịch | Phê duyệt |
| 18 | 605 | 606 | Phê duyệt | Kiểm tra ngoại lệ: NSD nhập sai mã OTP vượt quá số lần nhập sai tối đa cho phép thì hệ thống từ chối xác thực và không ghi nhận phê duyệt | Phê duyệt |
| 19 | 606 | 607 | Phê duyệt | Kiểm tra ngoại lệ: NSD chọn <Đóng> tại popup Xác thực OTP | Phê duyệt |
| 20 | 607 | 608 | Phê duyệt | Kiểm tra ngoại lệ: NSD chọn <Đóng> tại popup Xác thực thì hệ thống đóng popup và không ghi nhận phê duyệt | Phê duyệt |
| 21 | 608 | 609 | Phê duyệt | Kiểm tra luồng chính TH1: DN có nhiều cấp duyệt không theo thứ tự - sau khi phê duyệt thành công, hệ thống gọi API Admin Portal để lấy cấp phê duyệt tiếp theo cùng danh sách user và hạn mức tương ứng, cập nhật trạng thái Chờ duyệt cấp tiếp theo | Phê duyệt |
| 22 | 609 | 610 | Phê duyệt | Kiểm tra luồng chính TH2: DN có nhiều cấp duyệt phải tuân theo thứ tự - sau khi phê duyệt thành công, hệ thống xác định đúng user/cấp phê duyệt kế tiếp theo đúng thứ tự đã cấu hình | Phê duyệt |
| 23 | 610 | 611 | Phê duyệt | Kiểm tra luồng chính TH3: DN chỉ có 1 cấp duyệt - sau khi phê duyệt thành công, giao dịch hoàn tất quy trình phê duyệt (không còn cấp tiếp theo) | Phê duyệt |
| 24 | 612 | 613 | Phê duyệt | Kiểm tra hệ thống lưu log giao dịch sau mỗi lần phê duyệt thành công với đầy đủ thông tin mã giao dịch, user thực hiện, thời gian và hành động | Phê duyệt |
| 25 | 613 | 614 | Phê duyệt | Kiểm tra ngoại lệ: khi gọi API tới Admin Portal/2FA bị lỗi (timeout, lỗi hệ thống, response lỗi), hệ thống ghi log đầy đủ thông tin request/response và không cập nhật sai trạng thái giao dịch | Phê duyệt |
| 26 | 614 | 615 | Phê duyệt | Kiểm tra bắt buộc nhập trường "Hình thức nhận mã giao dịch OTP" | Phê duyệt |
| 27 | 615 | 616 | Phê duyệt | Kiểm tra chọn giá trị hợp lệ cho trường "Hình thức nhận mã giao dịch OTP" | Phê duyệt |
| 28 | 616 | 617 | Phê duyệt | Kiểm tra bắt buộc nhập trường "Nhập mã giao dịch OTP" | Phê duyệt |
| 29 | 627 | 628 | Từ chối | Kiểm tra hệ thống hiển thị popup Xác thực khi NSD đủ điều kiện chọn <Từ chối> | Từ chối – popup Xác thực |
| 30 | 628 | 629 | Từ chối | Kiểm tra chức năng đóng popup Xác thực khi NSD chọn <Đóng>, không thực hiện Từ chối | Từ chối – popup Xác thực |
| 31 | 629 | 630 | Từ chối | Kiểm tra hệ thống gửi EMAIL01 tới đúng user maker đã tạo giao dịch sau khi Từ chối thành công | Từ chối – popup Xác thực |
| 32 | 631 | 632 | Từ chối | Kiểm tra hệ thống lưu log khi call API tới Admin Portal (đóng luồng) bị lỗi trong quá trình Từ chối | Từ chối – popup Xác thực |
| 33 | 555 | 556 | Xóa đề nghị | Kiểm tra luồng chính: NSD có đủ quyền xóa thành công đề nghị Phát hành LC đang ở trạng thái Bản nháp. | Xóa – gọi 2FA |

## 2. Ký số (cá nhân / pháp nhân)

Chủ tài khoản ký số cá nhân; biến thể có PN cần thêm người ký pháp nhân. **USB token** gần như chắc chắn phải test tay.

| # | TC | Row | Screen | Summary | Note |
|---|---|---|---|---|---|
| 1 | 1 | 2 | Tạo đề nghị phát hành | Luồng happy case 1 cấp duyệt không ký số pháp nhân | E2E – bước ký số |
| 2 | 2 | 3 | Tạo đề nghị phát hành | Luồng happy case 1 cấp duyệt có ký số pháp nhân | E2E – bước ký số |
| 3 | 3 | 4 | Tạo đề nghị phát hành | Luồng happy case 2 cấp duyệt không có ký số pháp nhân | E2E – bước ký số |
| 4 | 4 | 5 | Tạo đề nghị phát hành | Luồng happy case 2 cấp duyệt có ký số pháp nhân | E2E – bước ký số |
| 5 | 5 | 6 | Tạo đề nghị phát hành | Luồng lưu nháp rồi phát hành 1 cấp duyệt có ký số pháp nhân | E2E – bước ký số |
| 6 | 6 | 7 | Tạo đề nghị phát hành | Luồng lưu nháp rồi phát hành 2 cấp duyệt có ký số pháp nhân | E2E – bước ký số |
| 7 | 7 | 8 | Tạo đề nghị phát hành | Luồng lưu nháp rồi phát hành 1 cấp duyệt không có ký số pháp nhân | E2E – bước ký số |
| 8 | 8 | 9 | Tạo đề nghị phát hành | Luồng lưu nháp rồi phát hành 2 cấp duyệt không có ký số pháp nhân | E2E – bước ký số |
| 9 | 12 | 13 | Tạo đề nghị phát hành | Kiểm tra bước Ký số pháp nhân KHÔNG có tùy chọn Từ chối | E2E – bước ký số |
| 10 | 14 | 15 | Tạo đề nghị phát hành | Yêu cầu chỉnh sửa rồi phát hành thành công luồng duyệt 1 cấp không ký số pháp nhân | E2E – bước ký số |
| 11 | 15 | 16 | Tạo đề nghị phát hành | Yêu cầu chỉnh sửa rồi phát hành thành công luồng duyệt 1 cấp có ký số pháp nhân | E2E – bước ký số |
| 12 | 16 | 17 | Tạo đề nghị phát hành | Yêu cầu chỉnh sửa rồi phát hành thành công luồng duyệt 2 cấp không ký số pháp nhân | E2E – bước ký số |
| 13 | 17 | 18 | Tạo đề nghị phát hành | Yêu cầu chỉnh sửa rồi phát hành thành công luồng duyệt 2 cấp có ký số pháp nhân | E2E – bước ký số |
| 14 | 638 | 639 | Ký số cá nhân | Kiểm tra luồng chính ký số cá nhân thành công (Online) khi approveLegal = true, giao dịch phải chuyển tiếp sang chờ ký số pháp nhân | Ký số cá nhân Online |
| 15 | 639 | 640 | Ký số cá nhân | Kiểm tra luồng ký số cá nhân thành công khi approveLegal = false, doanh nghiệp không cần ký số pháp nhân, giao dịch được gửi thẳng sang BO | Ký số cá nhân Online |
| 16 | 641 | 642 | Ký số cá nhân | Kiểm tra hệ thống trả về danh sách nhà cung cấp CKS theo CIF khi user đã đăng ký CKS và nhấn Ký số Online | Ký số cá nhân Online |
| 17 | 642 | 643 | Ký số cá nhân | Kiểm tra luồng ký số cá nhân thành công bằng hình thức Ký số USB token | **USB token – manual** |
| 18 | 640 | 641 | Ký số cá nhân | Kiểm tra thông báo khi user chưa đăng ký chữ ký số (CKS) thực hiện ký số Online | Cần user chưa đăng ký CKS |
| 19 | 643 | 644 | Ký số cá nhân | Kiểm tra xử lý khi call API ký số (Online hoặc USB token) tới hệ thống ký số/Admin Portal bị lỗi | Cần giả lập lỗi API ký số |
| 20 | 655 | 656 | Ký số pháp nhân | Kiểm tra hệ thống trả về danh sách nhà cung cấp CKS theo CIF và xử lý ký số pháp nhân thành công khi user đã đăng ký CKS và chọn Ký số Online | Ký số pháp nhân Online |
| 21 | 657 | 658 | Ký số pháp nhân | Kiểm tra luồng chính đầy đủ khi ký số pháp nhân thành công: hiển thị thông báo thành công, chuyển trạng thái giao dịch, đẩy giao dịch sang BO, gửi EMAIL03 và lưu log giao dịch | Ký số pháp nhân Online |
| 22 | 656 | 657 | Ký số pháp nhân | Kiểm tra luồng ký số pháp nhân thành công bằng hình thức Ký số USB token | **USB token – manual** |
| 23 | 654 | 655 | Ký số pháp nhân | Kiểm tra thông báo MSG15 khi user thực hiện Ký số Online nhưng chưa đăng ký CKS trên Admin portal | Cần user chưa đăng ký CKS (MSG15) |
| 24 | 658 | 659 | Ký số pháp nhân | Kiểm tra xử lý và lưu log khi call API (lấy danh sách CKS theo DN, gọi Admin portal khi ký số Online/USB token, hoặc đẩy giao dịch sang BO) bị lỗi | Cần giả lập lỗi API |
| 25 | 659 | 660 | Ký số pháp nhân | Kiểm tra chức năng nút <Đóng> trên màn hình xem đề nghị ký số pháp nhân | Dễ, nhưng cần bản ghi ở trạng thái Chờ ký số |
| 26 | 662 | 663 | Ký số pháp nhân | Kiểm tra chức năng nút "Xác nhận" tại màn hình Ký số cá nhân | Dễ, nhưng cần bản ghi ở trạng thái Chờ ký số |
| 27 | 136 | 137 | Xem chi tiết | Kiểm tra nút <Ký số cá nhân> hiển thị và mở màn hình ký số cá nhân khi hồ sơ có trạng thái = Chờ duyệt cấp tiếp theo | Cần bản ghi ở trạng thái Chờ duyệt cấp tiếp theo |

## 3. Phụ thuộc trạng thái (cascading)

Các TC này tự bản thân không khó, nhưng cần bản ghi **đã đi qua** OTP / ký số / BO phát hành. Nếu OTP & ký số không automate được → cần seed dữ liệu sẵn ở từng trạng thái (API/DB) hoặc chuẩn bị tay trước mỗi lần chạy.

- Màn hình Ký số cá nhân / pháp nhân: TC 636–663 (cần bản ghi Chờ duyệt cấp tiếp theo / Chờ ký số pháp nhân)
- Sau phát hành – Bổ sung hồ sơ & hậu kiểm: 47 TC (TC 664–688, 776–797), cần BO đã phát hành LC
- Từ chối tại Chủ tài khoản (TC 11), Ký số pháp nhân không có nút Từ chối (TC 12): cần bản ghi đã được duyệt

## 4. Lỗi API / hệ thống ngoài (cần giả lập lỗi)

| # | TC | Row | Screen | Summary | Note |
|---|---|---|---|---|---|
| 1 | 172 | 173 | Thêm mới | Verify khi các trường hợp call API (Admin Portal/GLIMS/CORE/ECM...) bị lỗi, hệ thống lưu log lỗi gồm request, response, thời gian gọi, thời gian nhận response, endpoint. | Timeout / lỗi Admin Portal, 2FA, GLIMS, Core, ký số → mock hoặc test tay |
| 2 | 548 | 549 | Chỉnh sửa | Verify khi các trường hợp gọi API (ví dụ API xác thực phân quyền tới BO Admin Portal) bị lỗi, hệ thống lưu log đầy đủ thông tin liên quan đến lần gọi API đó. | Timeout / lỗi Admin Portal, 2FA, GLIMS, Core, ký số → mock hoặc test tay |
| 3 | 563 | 564 | Xóa đề nghị | Kiểm tra hệ thống xử lý khi API xác thực phân quyền từ BO Admin Portal không phản hồi/lỗi tại thời điểm đăng nhập, ảnh hưởng tới khả năng thao tác Xóa đề nghị. | Timeout / lỗi Admin Portal, 2FA, GLIMS, Core, ký số → mock hoặc test tay |
| 4 | 577 | 578 | Hủy đề nghị | Kiểm tra hệ thống ghi log khi call API lấy thông tin phân quyền tới BO Admin Portal bị lỗi. | Timeout / lỗi Admin Portal, 2FA, GLIMS, Core, ký số → mock hoặc test tay |
| 5 | 613 | 614 | Phê duyệt | Kiểm tra ngoại lệ: khi gọi API tới Admin Portal/2FA bị lỗi (timeout, lỗi hệ thống, response lỗi), hệ thống ghi log đầy đủ thông tin request/response và không cập nhật sai trạng thái giao dịch | Timeout / lỗi Admin Portal, 2FA, GLIMS, Core, ký số → mock hoặc test tay |
| 6 | 631 | 632 | Từ chối | Kiểm tra hệ thống lưu log khi call API tới Admin Portal (đóng luồng) bị lỗi trong quá trình Từ chối | Timeout / lỗi Admin Portal, 2FA, GLIMS, Core, ký số → mock hoặc test tay |
| 7 | 643 | 644 | Ký số cá nhân | Kiểm tra xử lý khi call API ký số (Online hoặc USB token) tới hệ thống ký số/Admin Portal bị lỗi | Timeout / lỗi Admin Portal, 2FA, GLIMS, Core, ký số → mock hoặc test tay |
| 8 | 658 | 659 | Ký số pháp nhân | Kiểm tra xử lý và lưu log khi call API (lấy danh sách CKS theo DN, gọi Admin portal khi ký số Online/USB token, hoặc đẩy giao dịch sang BO) bị lỗi | Timeout / lỗi Admin Portal, 2FA, GLIMS, Core, ký số → mock hoặc test tay |

## 5. Kiểm tra email

| # | TC | Row | Screen | Summary | Note |
|---|---|---|---|---|---|
| 1 | 168 | 169 | Thêm mới | Verify sau khi Gửi duyệt thành công, hệ thống call API tới Admin Portal để xin chỉ thị luồng trả ra cấp phê duyệt tiếp theo, danh sách các user tương ứng và hạn mức, đồng thời gửi thông báo Noti1, EMAIL1 tới người dùng có quyền phê duyệt bản ghi. | Cần truy cập hộp mail test (IMAP / mail API) |
| 2 | 561 | 562 | Xóa đề nghị | Kiểm tra hệ thống gửi email thông báo sau khi xóa đề nghị thành công | Cần truy cập hộp mail test (IMAP / mail API) |
| 3 | 611 | 612 | Phê duyệt | Kiểm tra sau khi phê duyệt thành công, hệ thống gửi EMAIL01 tới đúng người dùng có quyền phê duyệt bản ghi ở cấp tiếp theo | Cần truy cập hộp mail test (IMAP / mail API) |
| 4 | 622 | 623 | Từ chối | Kiểm tra luồng chính: NSD đủ quyền và trong hạn mức thực hiện Từ chối thành công giao dịch có TT = Chờ duyệt cấp tiếp theo | Cần truy cập hộp mail test (IMAP / mail API) |
| 5 | 628 | 629 | Từ chối | Kiểm tra chức năng đóng popup Xác thực khi NSD chọn <Đóng>, không thực hiện Từ chối | Cần truy cập hộp mail test (IMAP / mail API) |
| 6 | 629 | 630 | Từ chối | Kiểm tra hệ thống gửi EMAIL01 tới đúng user maker đã tạo giao dịch sau khi Từ chối thành công | Cần truy cập hộp mail test (IMAP / mail API) |
| 7 | 638 | 639 | Ký số cá nhân | Kiểm tra luồng chính ký số cá nhân thành công (Online) khi approveLegal = true, giao dịch phải chuyển tiếp sang chờ ký số pháp nhân | Cần truy cập hộp mail test (IMAP / mail API) |
| 8 | 657 | 658 | Ký số pháp nhân | Kiểm tra luồng chính đầy đủ khi ký số pháp nhân thành công: hiển thị thông báo thành công, chuyển trạng thái giao dịch, đẩy giao dịch sang BO, gửi EMAIL03 và lưu log giao dịch | Cần truy cập hộp mail test (IMAP / mail API) |
| 9 | 683 | 684 | Bổ sung hồ sơ sau phát hành | Kiểm tra chức năng "Xác nhận bổ sung" chốt danh sách thành "Danh mục bổ sung hồ sơ lần 1" (chỉ xem) và gửi email thông báo | Cần truy cập hộp mail test (IMAP / mail API) |
| 10 | 720 | 721 | Thêm mới | Kiểm tra bắt buộc chọn trường "Đơn vị Days/Months/Years" khi chọn giá trị 3 của Kỳ hạn thanh toán (Mandatory) | Cần truy cập hộp mail test (IMAP / mail API) |

## 6. Kiểm tra log

| # | TC | Row | Screen | Summary | Note |
|---|---|---|---|---|---|
| 1 | 171 | 172 | Thêm mới | Verify sau khi Gửi duyệt thành công, hệ thống lưu log giao dịch gồm mã giao dịch, user, thời gian, hành động = "Gửi duyệt". | Không thấy trên UI – cần quyền DB / log |
| 2 | 172 | 173 | Thêm mới | Verify khi các trường hợp call API (Admin Portal/GLIMS/CORE/ECM...) bị lỗi, hệ thống lưu log lỗi gồm request, response, thời gian gọi, thời gian nhận response, endpoint. | Không thấy trên UI – cần quyền DB / log |
| 3 | 175 | 176 | Thêm mới | Verify luồng chính khi user chọn "Lưu nháp": hệ thống lưu bản ghi, hiển thị MSG5, tự động sinh mã đề nghị duy nhất, trạng thái = "Bản nháp", chuyển màn hình danh sách và lưu log hành động Lưu nháp. | Không thấy trên UI – cần quyền DB / log |
| 4 | 547 | 548 | Chỉnh sửa | Verify hệ thống lưu log giao dịch (mã giao dịch, user, thời gian, hành động = "Chỉnh sửa") khi thao tác chỉnh sửa đề nghị Phát hành LC hoàn tất. | Không thấy trên UI – cần quyền DB / log |
| 5 | 548 | 549 | Chỉnh sửa | Verify khi các trường hợp gọi API (ví dụ API xác thực phân quyền tới BO Admin Portal) bị lỗi, hệ thống lưu log đầy đủ thông tin liên quan đến lần gọi API đó. | Không thấy trên UI – cần quyền DB / log |
| 6 | 570 | 571 | Hủy đề nghị | Kiểm tra luồng chính: NSD được phân quyền thực hiện Hủy đề nghị thành công đối với giao dịch đang ở trạng thái hợp lệ (Yêu cầu bổ sung), không bị khóa, không bị gửi duyệt bởi user khác. | Không thấy trên UI – cần quyền DB / log |
| 7 | 577 | 578 | Hủy đề nghị | Kiểm tra hệ thống ghi log khi call API lấy thông tin phân quyền tới BO Admin Portal bị lỗi. | Không thấy trên UI – cần quyền DB / log |
| 8 | 579 | 580 | Hủy đề nghị | Kiểm tra log giao dịch được lưu đầy đủ và chính xác thông tin sau khi thực hiện Hủy đề nghị thành công. | Không thấy trên UI – cần quyền DB / log |
| 9 | 591 | 592 | Sao chép | Kiểm tra hệ thống lưu log khi Sao chép giao dịch thành công, bao gồm ID gốc, ID mới, user thực hiện và thời gian thực hiện | Không thấy trên UI – cần quyền DB / log |
| 10 | 612 | 613 | Phê duyệt | Kiểm tra hệ thống lưu log giao dịch sau mỗi lần phê duyệt thành công với đầy đủ thông tin mã giao dịch, user thực hiện, thời gian và hành động | Không thấy trên UI – cần quyền DB / log |
| 11 | 613 | 614 | Phê duyệt | Kiểm tra ngoại lệ: khi gọi API tới Admin Portal/2FA bị lỗi (timeout, lỗi hệ thống, response lỗi), hệ thống ghi log đầy đủ thông tin request/response và không cập nhật sai trạng thái giao dịch | Không thấy trên UI – cần quyền DB / log |
| 12 | 628 | 629 | Từ chối | Kiểm tra chức năng đóng popup Xác thực khi NSD chọn <Đóng>, không thực hiện Từ chối | Không thấy trên UI – cần quyền DB / log |
| 13 | 630 | 631 | Từ chối | Kiểm tra hệ thống lưu đầy đủ và chính xác log giao dịch sau khi thực hiện Từ chối thành công | Không thấy trên UI – cần quyền DB / log |
| 14 | 631 | 632 | Từ chối | Kiểm tra hệ thống lưu log khi call API tới Admin Portal (đóng luồng) bị lỗi trong quá trình Từ chối | Không thấy trên UI – cần quyền DB / log |
| 15 | 638 | 639 | Ký số cá nhân | Kiểm tra luồng chính ký số cá nhân thành công (Online) khi approveLegal = true, giao dịch phải chuyển tiếp sang chờ ký số pháp nhân | Không thấy trên UI – cần quyền DB / log |
| 16 | 639 | 640 | Ký số cá nhân | Kiểm tra luồng ký số cá nhân thành công khi approveLegal = false, doanh nghiệp không cần ký số pháp nhân, giao dịch được gửi thẳng sang BO | Không thấy trên UI – cần quyền DB / log |
| 17 | 642 | 643 | Ký số cá nhân | Kiểm tra luồng ký số cá nhân thành công bằng hình thức Ký số USB token | Không thấy trên UI – cần quyền DB / log |
| 18 | 643 | 644 | Ký số cá nhân | Kiểm tra xử lý khi call API ký số (Online hoặc USB token) tới hệ thống ký số/Admin Portal bị lỗi | Không thấy trên UI – cần quyền DB / log |
| 19 | 657 | 658 | Ký số pháp nhân | Kiểm tra luồng chính đầy đủ khi ký số pháp nhân thành công: hiển thị thông báo thành công, chuyển trạng thái giao dịch, đẩy giao dịch sang BO, gửi EMAIL03 và lưu log giao dịch | Không thấy trên UI – cần quyền DB / log |
| 20 | 658 | 659 | Ký số pháp nhân | Kiểm tra xử lý và lưu log khi call API (lấy danh sách CKS theo DN, gọi Admin portal khi ký số Online/USB token, hoặc đẩy giao dịch sang BO) bị lỗi | Không thấy trên UI – cần quyền DB / log |
| 21 | 720 | 721 | Thêm mới | Kiểm tra bắt buộc chọn trường "Đơn vị Days/Months/Years" khi chọn giá trị 3 của Kỳ hạn thanh toán (Mandatory) | Không thấy trên UI – cần quyền DB / log |

## 7. Hạn mức trong ngày / hạn mức phê duyệt

| # | TC | Row | Screen | Summary | Note |
|---|---|---|---|---|---|
| 1 | 176 | 177 | Thêm mới | Verify khi user DN nhấn "Gửi duyệt", hệ thống tự động cập nhật (cộng) số tiền LC vào trường Hạn mức sử dụng trong ngày lưu tại DB. | Cần user + dữ liệu ở đúng trạng thái hạn mức; reset theo ngày |
| 2 | 177 | 178 | Thêm mới | Verify khi đề nghị LC bị Từ chối (DN từ chối/NH từ chối), hệ thống tự động cập nhật (trừ) số tiền LC khỏi trường Hạn mức sử dụng trong ngày. | Cần user + dữ liệu ở đúng trạng thái hạn mức; reset theo ngày |
| 3 | 178 | 179 | Thêm mới | Verify khi user DN chỉnh sửa đề nghị phát hành LC (ĐNPH) làm tăng số tiền LC, hệ thống tự động cập nhật (cộng) phần chênh lệch tăng vào trường Hạn mức sử dụng trong ngày. | Cần user + dữ liệu ở đúng trạng thái hạn mức; reset theo ngày |
| 4 | 179 | 180 | Thêm mới | Verify khi Hạn mức sử dụng trong ngày (sau khi cộng số tiền LC) <= Hạn mức trong ngày [dailyLimit] do Admin Portal trả về, hệ thống cho phép user thực hiện tiếp giao dịch. | Cần user + dữ liệu ở đúng trạng thái hạn mức; reset theo ngày |
| 5 | 180 | 181 | Thêm mới | Verify khi Hạn mức sử dụng trong ngày (sau khi cộng số tiền LC) > Hạn mức trong ngày [dailyLimit] do Admin Portal trả về, hệ thống hiển thị MSG14 và không cho phép tiếp tục giao dịch. | Cần user + dữ liệu ở đúng trạng thái hạn mức; reset theo ngày |
| 6 | 600 | 601 | Phê duyệt | Kiểm tra khi đăng nhập thành công hệ thống gọi API tới BO Admin Portal để lấy đầy đủ thông tin phân quyền của user (CIF, cây phân quyền 4 tầng, roleName, hạn mức phê duyệt) phục vụ chức năng phê duyệt | Cần user + dữ liệu ở đúng trạng thái hạn mức; reset theo ngày |
| 7 | 601 | 602 | Phê duyệt | Kiểm tra luồng chính: Tổng Số tiền LC trong ngày của user <= Hạn mức phê duyệt của user thì hệ thống cho phép thực hiện phê duyệt | Cần user + dữ liệu ở đúng trạng thái hạn mức; reset theo ngày |
| 8 | 602 | 603 | Phê duyệt | Kiểm tra ngoại lệ: Tổng Số tiền LC trong ngày của user vượt quá Hạn mức phê duyệt được cấp thì hệ thống chặn phê duyệt và hiển thị thông báo MSG14 | Cần user + dữ liệu ở đúng trạng thái hạn mức; reset theo ngày |
| 9 | 623 | 624 | Từ chối | Kiểm tra hệ thống gọi API tới BO Admin Portal để lấy thông tin phân quyền (CIF, cây phân quyền, roleName, hạn mức phê duyệt) khi NSD đăng nhập, phục vụ chức năng Từ chối | Cần user + dữ liệu ở đúng trạng thái hạn mức; reset theo ngày |
| 10 | 625 | 626 | Từ chối | Kiểm tra hệ thống ngăn thực hiện Từ chối khi Tổng Số tiền LC trong ngày của user vượt Hạn mức phê duyệt | Cần user + dữ liệu ở đúng trạng thái hạn mức; reset theo ngày |

## Câu hỏi cần VCB trả lời

- [ ] **OTP trên SIT**: có OTP cố định / bypass / API đọc OTP không? → nếu có, gần như toàn bộ nhóm 1 automate được.
- [ ] **Ký số Online trên SIT**: có nhà cung cấp CKS test tự động chấp nhận không? → nếu có, TC 638, 639, 641, 655, 657 automate được. USB token (642, 656) vẫn manual.
- [ ] **User test đặc biệt**: user chưa đăng ký CKS (640, 654), user có hạn mức phê duyệt biết trước.
- [ ] **Seed dữ liệu**: tạo bản ghi ở trạng thái bất kỳ bằng API/DB được không? → giải quyết nhóm 3.
- [ ] **Mailbox test & quyền đọc log/DB** cho nhóm 5, 6.

## Đề xuất thứ tự

1. Làm trước phần **không phụ thuộc** OTP/ký số: Maker tạo đề nghị đến "Chờ duyệt", validate màn Thêm mới (~460 TC), Danh sách, Lưu nháp, Chỉnh sửa, Hủy/Xóa bản nháp, Sao chép, Template.
2. Song song hỏi VCB các câu trên.
3. Sau khi có câu trả lời → quyết định automate E2E hay chuyển manual / seed dữ liệu.
