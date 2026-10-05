# Bộ Test Case: Phát Hành Chứng Chỉ Phí (LC) - VCB TradeFlat

**Dự án:** VCB TradeFlat - Lĩnh vực Tài chính Thương mại  
**Module:** FO (Front Office) - Phát Hành LC  
**Môi trường:** SIT  
**Ngày tạo:** 05/10/2026  

---

## Tổng Quan

Bộ test case cho quy trình phát hành Chứng chỉ Phí (Letter of Credit - LC) bao gồm:
- ✅ Luồng thành công (1 cấp duyệt & 2 cấp duyệt)
- ✅ Các quy trình với ký số pháp nhân
- ✅ Lưu nháp rồi phát hành
- ✅ Hủy giao dịch & từ chối

---

## Danh Sách Test Case (10 Mẫu)

### TC #1: Luồng Happy Case 1 Cấp Duyệt - Không Ký Số Pháp Nhân

| Trường | Giá Trị |
|--------|--------|
| **No** | 1 |
| **Type** | FO-E2E |
| **Function** | Kiểm tra luồng |
| **Luồng** | Thành công |
| **Màn hình** | Tạo đề nghị phát hành |
| **Điều kiện 1** | Luồng happy case 1 cấp duyệt không ký số pháp nhân |
| **Priority** | Critical |
| **Component** | FO |
| **Enviroment** | SIT |

#### Dữ liệu Test
- 1 Maker (Người tạo)
- 1 Kế toán trưởng (Người duyệt)
- 1 Chủ tài khoản (Người ký số)

#### Các Bước Thực Hiện
1. User Maker login hệ thống FO.
2. Thêm mới 1 bản ghi phát hành LC, nhập liệu các trường thông tin bắt buộc (cấu hình 1 cấp duyệt 2FA, không ký số pháp nhân).
3. Maker thực hiện đẩy giao dịch lên cấp duyệt → bản ghi chuyển "Chờ duyệt".
4. User Kế toán trưởng login hệ thống FO, thực hiện xác thực 2FA và Phê duyệt.
5. User Chủ tài khoản login hệ thống FO, thực hiện Ký số thành công.
6. Quan sát kết quả.

#### Kết Quả Mong Đợi
1. Maker khởi tạo → Trạng thái: "Chờ duyệt".
2. Kế toán trưởng xác thực 2FA và duyệt xong → Trạng thái: "Chờ duyệt".
3. Chủ tài khoản ký số thành công → Hệ thống hiển thị màn hình thông báo thành công, bản ghi chuyển trạng thái "Đã gửi ngân hàng".

---

### TC #2: Luồng Happy Case 1 Cấp Duyệt - Có Ký Số Pháp Nhân

| Trường | Giá Trị |
|--------|--------|
| **No** | 2 |
| **Type** | FO-E2E |
| **Function** | Kiểm tra luồng |
| **Luồng** | Thành công |
| **Màn hình** | Tạo đề nghị phát hành |
| **Điều kiện 1** | Luồng happy case 1 cấp duyệt có ký số pháp nhân |
| **Priority** | Critical |
| **Component** | FO |
| **Enviroment** | SIT |

#### Dữ liệu Test
- 1 Maker
- 1 Kế toán trưởng
- 1 Chủ tài khoản
- 1 Người ký pháp nhân

#### Các Bước Thực Hiện
1. User Maker login hệ thống FO.
2. Thêm mới 1 bản ghi phát hành LC, nhập liệu đầy đủ (cấu hình 1 cấp duyệt 2FA, có ký số pháp nhân).
3. Maker thực hiện đẩy giao dịch lên cấp duyệt → bản ghi chuyển "Chờ duyệt".
4. User Kế toán trưởng login hệ thống FO, thực hiện xác thực 2FA và Phê duyệt.
5. User Chủ tài khoản login hệ thống FO, thực hiện Ký số thành công → bản ghi chuyển trạng thái "Chờ ký số pháp nhân".
6. User đại diện pháp nhân login hệ thống FO, thực hiện Ký số pháp nhân thành công.
7. Quan sát kết quả.

#### Kết Quả Mong Đợi
1. Maker khởi tạo → Trạng thái: "Chờ duyệt".
2. Kế toán trưởng xác thực 2FA và duyệt xong → Trạng thái: "Chờ duyệt".
3. Chủ tài khoản ký số thành công → Trạng thái: "Chờ ký số pháp nhân".
4. Người đại diện pháp nhân ký số pháp nhân thành công → Hệ thống hiển thị màn hình thông báo thành công, bản ghi chuyển trạng thái "Đã gửi ngân hàng".

---

### TC #3: Luồng Happy Case 2 Cấp Duyệt - Không Ký Số Pháp Nhân

| Trường | Giá Trị |
|--------|--------|
| **No** | 3 |
| **Type** | FO-E2E |
| **Function** | Kiểm tra luồng |
| **Luồng** | Thành công |
| **Màn hình** | Tạo đề nghị phát hành |
| **Điều kiện 1** | Luồng happy case 2 cấp duyệt không có ký số pháp nhân |
| **Priority** | Critical |
| **Component** | FO |
| **Enviroment** | SIT |

#### Dữ liệu Test
- 1 Maker
- 1 Kế toán trưởng
- 1 Kế toán phó
- 1 Chủ tài khoản

#### Các Bước Thực Hiện
1. User Maker login hệ thống FO, thêm mới bản ghi phát hành LC, nhập liệu đầy đủ (cấu hình 2 cấp duyệt 2FA, không ký số pháp nhân).
2. Maker đẩy giao dịch lên cấp duyệt → bản ghi chuyển trạng thái "Chờ duyệt".
3. User Kế toán phó login, thực hiện xác thực 2FA và Phê duyệt → bản ghi chuyển trạng thái "Chờ duyệt cấp tiếp theo".
4. User Kế toán trưởng login, thực hiện xác thực 2FA và Phê duyệt.
5. User Chủ tài khoản login, thực hiện Ký số thành công.
6. Quan sát kết quả.

#### Kết Quả Mong Đợi
1. Maker khởi tạo → Trạng thái: "Chờ duyệt".
2. Kế toán phó xác thực 2FA và duyệt xong (2FA lần 1) → Trạng thái: "Chờ duyệt cấp tiếp theo".
3. Kế toán trưởng xác thực 2FA và duyệt xong (2FA lần 2) → Trạng thái: "Chờ duyệt cấp tiếp theo".
4. Chủ tài khoản ký số thành công → Hệ thống hiển thị màn hình thông báo thành công, bản ghi chuyển trạng thái "Đã gửi ngân hàng".

---

### TC #4: Luồng Happy Case 2 Cấp Duyệt - Có Ký Số Pháp Nhân

| Trường | Giá Trị |
|--------|--------|
| **No** | 4 |
| **Type** | FO-E2E |
| **Luồng** | Thành công |
| **Điều kiện 1** | Luồng happy case 2 cấp duyệt có ký số pháp nhân |
| **Priority** | Critical |

#### Dữ liệu Test
- 1 Maker
- 1 Kế toán trưởng
- 1 Kế toán phó
- 1 Chủ tài khoản
- 1 Người ký pháp nhân

#### Các Bước Thực Hiện
1. User Maker login hệ thống FO, thêm mới bản ghi phát hành LC, nhập liệu đầy đủ (cấu hình 2 cấp duyệt 2FA, có ký số pháp nhân).
2. Maker đẩy giao dịch lên cấp duyệt → bản ghi chuyển trạng thái "Chờ duyệt".
3. User Kế toán phó login, thực hiện xác thực 2FA và Phê duyệt → bản ghi chuyển trạng thái "Chờ duyệt cấp tiếp theo".
4. User Kế toán trưởng login, thực hiện xác thực 2FA và Phê duyệt.
5. User Chủ tài khoản login, thực hiện Ký số thành công → bản ghi chuyển trạng thái "Chờ ký số pháp nhân".
6. Người dùng có thẩm quyền Ký số pháp nhân login, thực hiện ký số pháp nhân thành công.
7. Quan sát kết quả.

#### Kết Quả Mong Đợi
1. Maker khởi tạo → Trạng thái: "Chờ duyệt".
2. Kế toán phó xác thực 2FA và duyệt xong → Trạng thái: "Chờ duyệt cấp tiếp theo".
3. Kế toán trưởng xác thực 2FA và duyệt xong → Trạng thái: "Chờ duyệt cấp tiếp theo".
4. Chủ tài khoản ký số thành công → Trạng thái: "Chờ ký số pháp nhân".
5. Người đại diện pháp nhân ký số pháp nhân thành công → Hệ thống hiển thị màn hình thông báo thành công, bản ghi chuyển trạng thái "Đã gửi ngân hàng".

---

### TC #5: Luồng Lưu Nháp Rồi Phát Hành 1 Cấp Duyệt - Có Ký Số Pháp Nhân

| Trường | Giá Trị |
|--------|--------|
| **No** | 5 |
| **Function** | Kiểm tra luồng |
| **Luồng** | Thành công |
| **Màn hình** | Tạo đề nghị phát hành |
| **Điều kiện 1** | Luồng lưu nháp rồi phát hành 1 cấp duyệt có ký số pháp nhân |
| **Priority** | High |
| **Component** | FO |
| **Enviroment** | SIT |

#### Dữ liệu Test
- 1 Maker
- 1 Kế toán trưởng
- 1 Chủ tài khoản
- 1 Người ký pháp nhân

#### Các Bước Thực Hiện
1. User Maker login hệ thống FO, thêm mới bản ghi phát hành LC, nhập liệu đầy đủ.
2. Maker thực hiện <Lưu nháp>.
3. Maker mở lại bản ghi vừa lưu nháp, đẩy giao dịch lên cấp duyệt → bản ghi chuyển "Chờ duyệt".
4. User Kế toán trưởng login, thực hiện xác thực 2FA và Phê duyệt.
5. User Chủ tài khoản login, thực hiện Ký số thành công.
6. Người dùng có thẩm quyền Ký số pháp nhân login, thực hiện ký số pháp nhân thành công.
7. Quan sát kết quả.

#### Kết Quả Mong Đợi
1. Maker khởi tạo → Trạng thái: "Khởi tạo phát hành".
2. Maker lưu nháp → Trạng thái: "Bản nháp".
3. Maker đẩy giao dịch lên cấp duyệt → Trạng thái: "Chờ duyệt".
4. Kế toán trưởng xác thực 2FA và duyệt xong → Trạng thái: "Chờ duyệt".
5. Chủ tài khoản ký số thành công → Trạng thái: "Chờ ký số pháp nhân".
6. Người đại diện pháp nhân ký số pháp nhân thành công → Hệ thống hiển thị màn hình thông báo thành công, bản ghi chuyển trạng thái "Đã gửi ngân hàng".

---

### TC #6: Luồng Lưu Nháp Rồi Phát Hành 2 Cấp Duyệt - Có Ký Số Pháp Nhân

| Trường | Giá Trị |
|--------|--------|
| **No** | 6 |
| **Type** | FO-E2E |
| **Function** | Kiểm tra luồng |
| **Luồng** | Thành công |
| **Màn hình** | Tạo đề nghị phát hành |
| **Điều kiện 1** | Luồng lưu nháp rồi phát hành 2 cấp duyệt có ký số pháp nhân |
| **Priority** | High |
| **Component** | FO |
| **Enviroment** | SIT |

#### Dữ liệu Test
- 1 Maker
- 1 Kế toán trưởng
- 1 Kế toán phó
- 1 Chủ tài khoản
- 1 Người ký pháp nhân

#### Các Bước Thực Hiện
1. User Maker login hệ thống FO, thêm mới bản ghi phát hành LC, nhập liệu đầy đủ.
2. Maker thực hiện <Lưu nháp>.
3. Maker mở lại bản ghi vừa lưu nháp, đẩy giao dịch lên cấp duyệt → "Chờ duyệt".
4. User Kế toán phó login, xác thực 2FA và Phê duyệt → bản ghi chuyển "Chờ duyệt cấp tiếp theo".
5. User Kế toán trưởng login, xác thực 2FA và Phê duyệt.
6. User Chủ tài khoản login, thực hiện Ký số thành công → "Chờ ký số pháp nhân".
7. Người dùng có thẩm quyền Ký số pháp nhân thực hiện ký số pháp nhân thành công.
8. Quan sát kết quả.

#### Kết Quả Mong Đợi
1. Maker khởi tạo → Trạng thái: "Khởi tạo phát hành".
2. Maker lưu nháp → Trạng thái: "Bản nháp".
3. Maker đẩy giao dịch lên cấp duyệt → Trạng thái: "Chờ duyệt".
4. Kế toán phó xác thực 2FA và duyệt xong → Trạng thái: "Chờ duyệt cấp tiếp theo".
5. Kế toán trưởng xác thực 2FA và duyệt xong → Trạng thái: "Chờ duyệt cấp tiếp theo".
6. Chủ tài khoản ký số thành công → Trạng thái: "Chờ ký số pháp nhân".
7. Người đại diện pháp nhân ký số pháp nhân thành công → Hệ thống hiển thị màn hình thông báo thành công, bản ghi chuyển trạng thái "Đã gửi ngân hàng".

---

### TC #7: Luồng Lưu Nháp Rồi Phát Hành 1 Cấp Duyệt - Không Ký Số Pháp Nhân

| Trường | Giá Trị |
|--------|--------|
| **No** | 7 |
| **Function** | Kiểm tra luồng |
| **Luồng** | Thành công |
| **Màn hình** | Tạo đề nghị phát hành |
| **Điều kiện 1** | Luồng lưu nháp rồi phát hành 1 cấp duyệt không có ký số pháp nhân |
| **Priority** | High |
| **Component** | FO |
| **Enviroment** | SIT |

#### Dữ liệu Test
- 1 Maker
- 1 Kế toán trưởng
- 1 Chủ tài khoản

#### Các Bước Thực Hiện
1. User Maker login hệ thống FO, thêm mới bản ghi phát hành LC, nhập liệu đầy đủ.
2. Maker thực hiện <Lưu nháp>.
3. Maker mở lại bản ghi vừa lưu nháp, đẩy giao dịch lên cấp duyệt → bản ghi chuyển "Chờ duyệt".
4. User Kế toán trưởng login, thực hiện xác thực 2FA và Phê duyệt.
5. User Chủ tài khoản login, thực hiện Ký số thành công.
6. Quan sát kết quả.

#### Kết Quả Mong Đợi
1. Maker khởi tạo → Trạng thái: "Khởi tạo phát hành".
2. Maker lưu nháp → Trạng thái: "Bản nháp".
3. Maker đẩy giao dịch lên cấp duyệt → Trạng thái: "Chờ duyệt".
4. Kế toán trưởng xác thực 2FA và duyệt xong → Trạng thái: "Chờ duyệt".
5. Chủ tài khoản ký số thành công → Hệ thống hiển thị màn hình thông báo thành công, bản ghi chuyển trạng thái "Đã gửi ngân hàng".

---

### TC #8: Luồng Lưu Nháp Rồi Phát Hành 2 Cấp Duyệt - Không Ký Số Pháp Nhân

| Trường | Giá Trị |
|--------|--------|
| **No** | 8 |
| **Function** | Kiểm tra luồng |
| **Luồng** | Thành công |
| **Màn hình** | Tạo đề nghị phát hành |
| **Điều kiện 1** | Luồng lưu nháp rồi phát hành 2 cấp duyệt không có ký số pháp nhân |
| **Priority** | High |
| **Component** | FO |
| **Enviroment** | SIT |

#### Dữ liệu Test
- 1 Maker
- 1 Kế toán trưởng
- 1 Kế toán phó
- 1 Chủ tài khoản

#### Các Bước Thực Hiện
1. User Maker login hệ thống FO, thêm mới bản ghi phát hành LC, nhập liệu đầy đủ.
2. Maker thực hiện <Lưu nháp>.
3. Maker mở lại bản ghi vừa lưu nháp, đẩy giao dịch lên cấp duyệt → bản ghi chuyển "Chờ duyệt".
4. User Kế toán phó login, thực hiện xác thực 2FA và Phê duyệt → bản ghi chuyển "Chờ duyệt cấp tiếp theo".
5. User Kế toán trưởng login, thực hiện xác thực 2FA và Phê duyệt.
6. User Chủ tài khoản login, thực hiện Ký số thành công.
7. Quan sát kết quả.

#### Kết Quả Mong Đợi
1. Maker khởi tạo → Trạng thái: "Khởi tạo phát hành".
2. Maker lưu nháp → Trạng thái: "Bản nháp".
3. Maker đẩy giao dịch lên cấp duyệt → Trạng thái: "Chờ duyệt".
4. Kế toán phó xác thực 2FA và duyệt xong → Trạng thái: "Chờ duyệt cấp tiếp theo".
5. Kế toán trưởng xác thực 2FA và duyệt xong → Trạng thái: "Chờ duyệt cấp tiếp theo".
6. Chủ tài khoản ký số thành công → Hệ thống hiển thị màn hình thông báo thành công, bản ghi chuyển trạng thái "Đã gửi ngân hàng".

---

### TC #9: Hủy Giao Dịch Từ Bản Nháp

| Trường | Giá Trị |
|--------|--------|
| **No** | 9 |
| **Type** | FO-E2E |
| **Function** | Kiểm tra luồng |
| **Luồng** | Huỷ giao dịch |
| **Màn hình** | Tạo đề nghị phát hành |
| **Điều kiện 1** | Hủy giao dịch từ bản nháp |
| **Priority** | High |
| **Component** | FO |
| **Enviroment** | SIT |

#### Dữ liệu Test
- 1 Maker

#### Các Bước Thực Hiện
1. User Maker login hệ thống FO, thêm mới bản ghi phát hành LC, nhập liệu đầy đủ.
2. Maker thực hiện <Lưu nháp>.
3. Maker mở lại bản ghi, chọn chức năng <Hủy đề nghị>, xác nhận hủy.
4. Quan sát kết quả.

#### Kết Quả Mong Đợi
1. Maker khởi tạo → Trạng thái: "Khởi tạo phát hành".
2. Maker lưu nháp → Trạng thái: "Bản nháp".
3. Maker thực hiện hủy đề nghị → Trạng thái: "Đã hủy".

---

### TC #10: Từ Chối Tại Cấp Kế Toán Trưởng

| Trường | Giá Trị |
|--------|--------|
| **No** | 10 |
| **Type** | FO-E2E |
| **Function** | Kiểm tra luồng |
| **Luồng** | Từ chối giao dịch |
| **Màn hình** | Tạo đề nghị phát hành |
| **Điều kiện 1** | Từ chối tại Kế toán trưởng |
| **Priority** | Critical |
| **Component** | FO |
| **Enviroment** | SIT |

#### Dữ liệu Test
- 1 Maker
- 1 Checker (Kế toán trưởng)

#### Các Bước Thực Hiện
1. User Maker login hệ thống FO, thêm mới bản ghi phát hành LC, nhập liệu đầy đủ, đẩy giao dịch lên cấp duyệt → bản ghi chuyển "Chờ duyệt".
2. User Kế toán trưởng (Checker) login, truy cập bản ghi, chọn <Từ chối>, nhập lý do, xác nhận.
3. Quan sát kết quả.

#### Kết Quả Mong Đợi
1. Maker khởi tạo → Trạng thái: "Chờ duyệt".
2. Kế toán trưởng từ chối bản ghi → Trạng thái: "Đã hủy".

---

## Tóm Tắt

**Tổng số test case trong file:** 1.581  
**Đã phân tích:** 10 mẫu  

**Các tính năng chính bao gồm:**
- ✅ Duyệt 1 cấp & 2 cấp
- ✅ Ký số tài khoản & ký số pháp nhân
- ✅ Lưu nháp & phát hành
- ✅ Hủy giao dịch
- ✅ Từ chối duyệt

**Bước tiếp theo:**
- Tạo specification chi tiết
- Ánh xạ vào quy trình APAC-SDLC
- Tạo danh sách tasks triển khai
