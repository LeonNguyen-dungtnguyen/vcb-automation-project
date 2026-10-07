"""Sinh FO_happy_cases.md: mỗi happy case FO + danh sách edge case bên dưới.

    python build_fo_happy_md.py "<file xlsx gốc>"
"""
import sys
from pathlib import Path

import openpyxl

OUT = Path(__file__).resolve().parent / "FO_happy_cases.md"

# Happy case: (tiêu đề, TC No E2E, các nhóm edge case gắn với nó)
# Nhóm edge case: (tên bước, rule) – rule là màn hình gốc hoặc dải TC No trong màn "Thêm mới"
HAPPY = [
    ("Happy case 1 – Tạo đề nghị → Gửi duyệt → Kế toán trưởng duyệt → Chủ tài khoản ký số → Đã gửi ngân hàng", 1, [
        ("Danh sách & tìm kiếm giao dịch", {"screen": "Danh sách và tìm kiếm giao dịch"}),
        ("Thêm mới – truy cập, điều hướng các bước, tích hợp CIF/hạn mức, Gửi duyệt", {"range": (154, 180)}),
        ("Thêm mới – rule chung các trường", {"range": (181, 232)}),
        ("Thêm mới – Thông tin khách hàng", {"range": (233, 246)}),
        ("Thêm mới – Thông tin LC, ngân hàng, bên phát hành, người hưởng", {"range": (247, 321)}),
        ("Thêm mới – Giá trị LC, dung sai", {"range": (322, 331)}),
        ("Thêm mới – Phương thức thanh toán, hối phiếu, kỳ hạn", {"range": (332, 351)}),
        ("Thêm mới – Giao hàng & hàng hoá", {"range": (352, 387)}),
        ("Thêm mới – Điều khoản bổ sung", {"range": (388, 403)}),
        ("Thêm mới – Phí & thời hạn xuất trình", {"range": (404, 441)}),
        ("Thêm mới – Thông tin khác, nguồn tiền, lãi suất, trả nợ", {"range": (442, 502)}),
        ("Thêm mới – Điều khoản & điều kiện, Hồ sơ đính kèm", {"range": (503, 532)}),
        ("Thêm mới – Các nút cuối màn hình", {"range": (533, 540)}),
        ("Thêm mới – Chứng từ yêu cầu", {"range": (689, 707)}),
        ("Thêm mới – Additional conditions, LC xác nhận/chuyển nhượng, phí discounting", {"range": (708, 745)}),
        ("Thêm mới – Cam kết bổ sung chứng từ", {"range": (746, 775)}),
        ("Xem chi tiết", {"screen": "Xem chi tiết"}),
        ("Phê duyệt", {"screen": "Phê duyệt"}),
        ("Ký số cá nhân", {"screen": "Ký số cá nhân"}),
    ]),
    ("Happy case 2 – Như Happy case 1 + Ký số pháp nhân", 2, [
        ("Ký số pháp nhân", {"screen": "Ký số pháp nhân"}),
    ]),
    ("Happy case 3 – Duyệt 2 cấp (Kế toán phó → Kế toán trưởng), không ký số pháp nhân", 3, []),
    ("Happy case 4 – Duyệt 2 cấp + Ký số pháp nhân", 4, []),
    ("Happy case 5 – Lưu nháp → mở lại → Gửi duyệt → … → Đã gửi ngân hàng", 7, [
        ("Chỉnh sửa bản nháp", {"screen": "Chỉnh sửa"}),
    ]),
    ("Happy case 6 – Bị Trả lại → Maker chỉnh sửa, gửi lại → … → Đã gửi ngân hàng", 14, []),
]
# Biến thể E2E còn lại (không có edge case riêng)
VARIANTS = {7: [5, 8, 6], 14: [15, 16, 17]}

NOT_HAPPY = [
    ("Luồng lỗi E2E", {"tcs": [9, 10, 11, 12, 13]}),
    ("Từ chối", {"screen": "Từ chối"}),
    ("Hủy đề nghị", {"screen": "Hủy đề nghị"}),
    ("Xóa đề nghị", {"screen": "Xóa đề nghị"}),
    ("Sao chép", {"screen": "Sao chép"}),
    ("Quản lý template", {"screen": "Quản lý template"}),
    ("Bổ sung hồ sơ sau phát hành (cần BO phát hành xong)", {"screen": "Bổ sung hồ sơ sau phát hành"}),
    ("Nhập thông tin hồ sơ hậu kiểm (cần BO phát hành xong)", {"screen": "Dialog - Nhập thông tin hồ sơ hậu kiểm"}),
]


def clean(s, n=160):
    s = " ".join(str(s or "").split())
    return s if len(s) <= n else s[: n - 1] + "…"


def load(src):
    ws = openpyxl.load_workbook(src, read_only=True, data_only=True).worksheets[0]
    out = []
    for row_no, r in enumerate(ws.iter_rows(values_only=True), start=1):
        if row_no == 1:
            continue
        r = [("" if c is None else str(c).strip()) for c in r[:18]]
        try:
            no = int(float(r[0]))
        except ValueError:
            continue
        typ, screen = r[1], r[4]
        if typ.startswith("FO") or (not typ and screen == "Tạo đề nghị phát hành"):
            out.append({"no": no, "row": row_no, "screen": screen, "func": r[2], "dk1": r[5], "summary": r[8]})
    return out


def match(t, rule):
    if "tcs" in rule:
        return t["no"] in rule["tcs"]
    if "screen" in rule:
        return t["screen"] == rule["screen"]
    lo, hi = rule["range"]
    return t["screen"] == "Thêm mới" and lo <= t["no"] <= hi


def summarize(t):
    func, dk1 = clean(t["func"], 60), clean(t["dk1"])
    text = dk1 or func
    # Function là tên trường ngắn → ghép vào để biết edge case thuộc trường nào
    if func and dk1 and not func.lower().startswith(("kiểm tra", "verify")) and func.lower() not in dk1.lower():
        text = f"[{func}] {dk1}"
    return text


def edge_list(L, tcs, groups, used, counter):
    for name, rule in groups:
        items = [t for t in tcs if match(t, rule)]
        if not items:
            continue
        L.append(f"#### {name} ({len(items)})\n")
        for t in items:
            counter[0] += 1
            used.add(t["no"])
            L.append(f"{counter[0]}. {summarize(t)} — *TC {t['no']}, row {t['row']}*")
        L.append("")


def main():
    src = Path(sys.argv[1])
    tcs = load(src)
    by_no = {t["no"]: t for t in tcs}
    used, L = set(), []
    L.append("# FO – Phát hành LC: Happy case & Edge case\n")
    L.append(f"Nguồn: `{src.name}` (sheet đầu tiên). *row* = số dòng trong Excel.\n")
    L.append("Edge case chỉ liệt kê ở happy case **đầu tiên** đi qua bước đó; "
             "happy case sau chỉ liệt kê edge case của bước **mới** mà nó thêm vào.\n")

    for title, e2e_no, groups in HAPPY:
        t = by_no[e2e_no]
        used.add(e2e_no)
        L.append(f"## {title}\n")
        L.append(f"- E2E: **TC {e2e_no}, row {t['row']}** — {clean(t['dk1'])}")
        for v in VARIANTS.get(e2e_no, []):
            used.add(v)
            L.append(f"- Biến thể: TC {v}, row {by_no[v]['row']} — {clean(by_no[v]['dk1'])}")
        L.append("")
        if groups:
            L.append("### Edge cases\n")
            edge_list(L, tcs, groups, used, [0])
        else:
            L.append("*Không có edge case riêng – dùng chung edge case của các happy case trên.*\n")

    L.append("## Ngoài happy case\n")
    edge_list(L, tcs, NOT_HAPPY, used, [0])

    left = [t for t in tcs if t["no"] not in used]
    if left:
        L.append("## ⚠ Chưa phân loại\n")
        L.extend(f"- {summarize(t)} — *TC {t['no']}, row {t['row']}*" for t in left)
    OUT.write_text("\n".join(L) + "\n", encoding="utf-8")
    print(f"FO TC: {len(tcs)} · đã xếp: {len(used)} · chưa phân loại: {len(left)}")


if __name__ == "__main__":
    main()
