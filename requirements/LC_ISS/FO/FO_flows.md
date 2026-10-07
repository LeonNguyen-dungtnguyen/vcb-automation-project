# FO – Phát hành LC: bản đồ luồng & edge case

> Sinh tự động bởi `build_fo_mapping.py` từ `VCB_TradeFlat_Testcase_SIT_LC_ISS_Phat Hanh v1.1 (1).xlsx`. **Không sửa tay** – sửa script rồi chạy lại.
> Chi tiết từng TC (Action/Expected) và theo dõi tiến độ automation: `FO_tc_mapping.xlsx`.

**Tổng FO: 749 TC** — E2E: 17 · Edge case: 732 · Chưa phân loại: 0

## 1. Vai trò & trạng thái

| Vai trò | Dùng ở bước |
|---|---|
| Maker | Tạo mới, Lưu nháp, Gửi duyệt, Chỉnh sửa, Hủy |
| Kế toán phó | Duyệt cấp 1 (luồng 2 cấp), 2FA |
| Kế toán trưởng | Duyệt (cấp cuối), 2FA, Trả lại, Từ chối |
| Chủ tài khoản | Ký số cá nhân, Từ chối |
| Người ký pháp nhân | Ký số pháp nhân (không có Từ chối) |

```
Khởi tạo phát hành ─(Lưu nháp)→ Bản nháp ─(Gửi duyệt)→ Chờ duyệt
Chờ duyệt ─(KT phó duyệt, luồng 2 cấp)→ Chờ duyệt cấp tiếp theo ─(KT trưởng duyệt)→ Chờ duyệt (1 cấp) / Chờ duyệt cấp tiếp theo (2 cấp)
         ─(Chủ TK ký số)→ [Chờ ký số pháp nhân ─(ký PN)→] Đã gửi ngân hàng  ⇒ chuyển sang BO
Nhánh lỗi: Trả lại → Yêu cầu chỉnh sửa · KT trưởng từ chối → Đã hủy · Chủ TK từ chối → Từ chối · Maker hủy → Đã hủy
```

## 2. Luồng happy (E2E)

Mỗi luồng có 4 biến thể: số cấp duyệt (1 | 2) × ký số pháp nhân (không | có).

| Flow | Mô tả | 1 cấp, không PN | 1 cấp, có PN | 2 cấp, không PN | 2 cấp, có PN |
|---|---|---|---|---|---|
| **HF-01** | Tạo mới → Gửi duyệt → Duyệt → Ký số → Đã gửi ngân hàng | TC1 | TC2 | TC3 | TC4 |
| **HF-02** | Tạo mới → Lưu nháp → Mở lại, Gửi duyệt → Duyệt → Ký số → Đã gửi ngân hàng | TC7 | TC5 | TC8 | TC6 |
| **HF-03** | Tạo mới → Gửi duyệt → Trả lại (Yêu cầu chỉnh sửa) → Maker sửa, gửi lại → Duyệt → Ký số → Đã gửi ngân hàng | TC14 | TC15 | TC16 | TC17 |

**Luồng lỗi (E2E):**

- TC9 – Hủy giao dịch từ bản nháp → Đã hủy
- TC13 – Trả lại → Maker hủy → Đã hủy
- TC10 – Từ chối tại Kế toán trưởng → Đã hủy
- TC11 – Từ chối tại Chủ tài khoản → Từ chối
- TC12 – Bước Ký số pháp nhân KHÔNG có nút Từ chối

## 3. Edge case theo từng bước của luồng

Thứ tự bước theo đúng trình tự người dùng đi trong luồng happy. Cột *Ưu tiên* = số TC Critical/Highest · High.

### Bước chính của luồng happy

| Step | Bước | Áp dụng | Số TC | Ưu tiên | TC No |
|---|---|---|---|---|---|
| S01 | Danh sách & tìm kiếm giao dịch | HF-01/02/03 | 49 | 0 · 7 | 66–114 |
| S02 | Thêm mới – quyền truy cập, điều hướng wizard, tích hợp CIF/GLIMS/Core, hạn mức ngày, Gửi duyệt/Lưu nháp | HF-01/02/03 | 27 | 0 · 17 | 154–180 |
| S03 | Thêm mới – rule chung các trường (khoảng trắng, bắt buộc, độ dài, mặc định) | HF-01/02/03 | 52 | 0 · 12 | 181–232 |
| S04 | Thêm mới – Thông tin khách hàng | HF-01/02/03 | 14 | 0 · 6 | 233–246 |
| S05 | Thêm mới – Thông tin LC: loại LC, BIC, ngày, ngân hàng, bên phát hành, người hưởng | HF-01/02/03 | 75 | 0 · 28 | 247–321 |
| S06 | Thêm mới – Giá trị LC, dung sai, nơi có giá trị | HF-01/02/03 | 10 | 0 · 4 | 322–331 |
| S07 | Thêm mới – Phương thức thanh toán, hối phiếu, kỳ hạn | HF-01/02/03 | 20 | 0 · 7 | 332–351 |
| S08 | Thêm mới – Giao hàng & hàng hoá | HF-01/02/03 | 36 | 0 · 10 | 352–387 |
| S09 | Thêm mới – Điều khoản bổ sung | HF-01/02/03 | 16 | 0 · 7 | 388–403 |
| S10 | Thêm mới – Phí & thời hạn xuất trình chứng từ | HF-01/02/03 | 38 | 0 · 13 | 404–441 |
| S11 | Thêm mới – Thông tin khác, nguồn tiền, lãi suất, phương thức trả nợ | HF-01/02/03 | 61 | 0 · 25 | 442–502 |
| S12 | Thêm mới – Chứng từ yêu cầu (Documents required) | HF-01/02/03 | 19 | 0 · 14 | 689–707 |
| S13 | Thêm mới – Additional conditions, LC xác nhận/chuyển nhượng, phí discounting | HF-01/02/03 | 38 | 0 · 13 | 708–745 |
| S14 | Thêm mới – Cam kết bổ sung chứng từ (tạm nhập tái xuất / chuyển khẩu / trả trước) | HF-01/02/03 | 19 | 0 · 10 | 746–759, 771–775 |
| S15 | Thêm mới – Điều khoản & điều kiện, Hồ sơ đính kèm (upload) | HF-01/02/03 | 30 | 0 · 11 | 503–532 |
| S16 | Thêm mới – Nút Lưu nháp / Tiếp tục / Quay lại / Lưu template / Gửi duyệt | HF-01/02/03 | 8 | 0 · 0 | 533–540 |
| S17 | Chỉnh sửa (bản nháp / Yêu cầu chỉnh sửa) | HF-02, HF-03 | 12 | 0 · 5 | 541–552 |
| S18 | Xem chi tiết | HF-01/02/03 | 39 | 0 · 13 | 115–153 |
| S19 | Phê duyệt (Kế toán phó / Kế toán trưởng, 2FA) | HF-01/02/03 | 22 | 0 · 12 | 597–618 |
| S20 | Ký số cá nhân (Chủ tài khoản) | HF-01/02/03 | 13 | 0 · 8 | 636–648 |
| S21 | Ký số pháp nhân | HF-01/02/03 (biến thể có ký số PN) | 15 | 0 · 12 | 649–663 |

### Nhánh lỗi

| Step | Bước | Áp dụng | Số TC | Ưu tiên | TC No |
|---|---|---|---|---|---|
| N01 | Từ chối | Luồng lỗi | 17 | 0 · 10 | 619–635 |
| N02 | Hủy đề nghị | Luồng lỗi | 15 | 0 · 8 | 568–582 |
| N03 | Xóa đề nghị | Luồng lỗi | 15 | 0 · 8 | 553–567 |

### Tiện ích

| Step | Bước | Áp dụng | Số TC | Ưu tiên | TC No |
|---|---|---|---|---|---|
| U01 | Sao chép đề nghị | Tiện ích | 14 | 0 · 7 | 583–596 |
| U02 | Quản lý template | Tiện ích | 11 | 0 · 6 | 760–770 |

### Sau phát hành (phụ thuộc BO)

| Step | Bước | Áp dụng | Số TC | Ưu tiên | TC No |
|---|---|---|---|---|---|
| P01 | Bổ sung hồ sơ sau phát hành | Sau phát hành (cần BO phát hành xong) | 25 | 0 · 10 | 664–688 |
| P02 | Dialog – Nhập thông tin hồ sơ hậu kiểm | Sau phát hành (cần BO phát hành xong) | 22 | 0 · 1 | 776–797 |

## 4. Thứ tự triển khai đề xuất

1. **HF-01, biến thể 1 cấp không ký số PN (TC1)** – xương sống, dựng sẵn keyword cho login theo vai trò, tạo LC tối thiểu, gửi duyệt, phê duyệt 2FA, ký số.
2. Mở rộng 3 biến thể còn lại của HF-01 (TC2–4) → chỉ thêm bước duyệt cấp 2 và ký số PN.
3. HF-02 (S16 Lưu nháp + S17 Chỉnh sửa) và HF-03 (Trả lại).
4. Luồng lỗi E2E (TC9–13).
5. Edge case: ưu tiên S02, S16, S19–S21 (hành vi luồng), sau đó đến các section field S03–S15 (data-driven, 1 test case Katalon + Data File cho mỗi section).
6. P01–P02 làm sau khi có luồng BO phát hành.

## 5. Câu hỏi mở / cần xác nhận

- [ ] Ký số cá nhân/pháp nhân trên SIT dùng gì (USB token, HSM, mock)? Có automate được không?
- [ ] 2FA trên SIT: OTP cố định / bypass / phải lấy từ SMS-email?
- [ ] Bộ user test cho từng vai trò (Maker, KT phó, KT trưởng, Chủ TK, Người ký PN) + cấu hình 1 cấp / 2 cấp / có-không ký số PN.
- [ ] Dữ liệu tích hợp (CIF, hợp đồng hạn mức GLIMS, Core) cho S02 có ổn định trên SIT không?
- [ ] Ý nghĩa Note = "Phục hồi" trong file gốc (còn trong phạm vi test không?).
- [ ] Ranh giới section S03–S15 được suy ra theo thứ tự TC + tên trường, chưa đối chiếu SRS – cần review.
