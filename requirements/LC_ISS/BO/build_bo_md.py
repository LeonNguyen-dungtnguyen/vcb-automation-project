"""Sinh 3 file BO: BO_happy_cases.md, BO_automation_blockers.md, BO_automatable.md.

    python build_bo_md.py "<file xlsx gốc>"
"""
import re
import sys
from pathlib import Path

import openpyxl

OUT = Path(__file__).resolve().parent

# --- Happy case BO (E2E TC 18–65) --------------------------------------------
# (tiêu đề, TC E2E chính, biến thể, nhóm edge case)
HAPPY = [
    ("Happy case 1 – Đề xuất phê duyệt, KHÔNG cần thẩm quyền BGĐ CN: "
     "CA xử lý → CA lead duyệt → CRC xử lý → CRC lead duyệt & ký số điện → TI → Hoàn thành",
     27, [28, 29, 30, 31, 32], ["B01", "B02", "B03", "B04", "B05", "B06", "B07", "B08", "B09", "B10", "B13", "B14"]),
    ("Happy case 2 – Như HC1 nhưng bị trả lại ở 1 cấp → chỉnh sửa, gửi lại → Hoàn thành",
     33, [34, 35, 36, 37], []),
    ("Happy case 3 – Đề xuất phê duyệt, CÓ thẩm quyền BGĐ CN: … → BGĐ CN duyệt & ký số điện → TI → Hoàn thành",
     18, [19, 20, 21, 22], ["B11", "B12", "B15"]),
    ("Happy case 4 – Đề xuất từ chối, KHÔNG cần thẩm quyền BGĐ CN (lãnh đạo trả lại / duyệt đề xuất từ chối)",
     54, [55, 56, 57, 58, 59, 60, 61], []),
    ("Happy case 5 – Đề xuất từ chối, CÓ thẩm quyền BGĐ CN",
     42, [43, 44, 45, 46, 47, 48, 49], []),
    ("Happy case 6 – Sau phát hành: Hoàn thành – Chờ bổ sung hồ sơ → Hồ sơ hậu kiểm → Xác nhận hoàn thành",
     None, [], ["B16"]),
]
NEGATIVE_E2E = [23, 24, 25, 26, 38, 39, 40, 41, 50, 51, 52, 53, 62, 63, 64, 65]

# Nhóm edge case theo vai trò / bước – theo dải TC No trong file gốc
STEPS = {
    "B01": ("Danh sách, phân trang, bộ lọc (chung)", 798, 868),
    "B02": ("Xem chi tiết hồ sơ (chung)", 869, 1013),
    "B03": ("CA – Tiếp nhận & Xử lý tác nghiệp", 1014, 1160),
    "B04": ("CA – Gửi duyệt / Trả lại khách hàng / Từ chối", 1161, 1169),
    "B05": ("CA – Xem TBTN, tải hồ sơ khách hàng", 1170, 1217),
    "B06": ("CA lead – Phê duyệt, Phê duyệt ĐXTC, Trả lại, Phân công lại, Xem TBTN", 1218, 1241),
    "B07": ("CRC – Danh sách, tiếp nhận, xử lý tác nghiệp", 1242, 1298),
    "B08": ("CRC – Yêu cầu xử lý giao dịch (YCXL)", 1299, 1383),
    "B09": ("CRC – Gửi duyệt / Trả lại / Xem file tác nghiệp", 1384, 1415),
    "B10": ("CRC lead – Phê duyệt, Phê duyệt ĐXTC, Trả lại, Phân công lại, Xem file", 1416, 1452),
    "B11": ("BGĐ CN – Phê duyệt, Trả lại, Xem file", 1453, 1480),
    "B12": ("BGĐ CN – Phê duyệt & Ký số Điện phát hành LC", 1481, 1486),
    "B13": ("CRC – Giao dịch trạng thái Đã phát hành điện LC", 1487, 1518),
    "B14": ("CRC lead – Chờ ký số điện LC: Phê duyệt & Ký số (không thuộc thẩm quyền BGĐ CN)", 1519, 1541),
    "B15": ("BGĐ CN – Chờ ký số điện LC: Phê duyệt & Ký số (thuộc thẩm quyền BGĐ CN)", 1542, 1564),
    "B16": ("Hậu kiểm – Hoàn thành, chờ bổ sung hồ sơ", 1565, 1580),
}

# --- Phân loại khó automation ------------------------------------------------
SIG_RX = r"ký số usb|ký số từ xa|ký số online|\bavs\b|chưa đăng ký cks|màn hình chức năng ký số"
TI_RX = r"đẩy sang ti|sang hệ thống ti|\bti\b"
FILE_FUNC_RX = r"xem tbtn|xem file|file tác nghiệp|file ycxl"
DB_RX = r"\bdb\b|cmn_|eg_event_log|masterref"


def clean(s, n=150):
    s = " ".join(str(s or "").split())
    return s if len(s) <= n else s[: n - 1] + "…"


def load(src):
    ws = openpyxl.load_workbook(src, read_only=True, data_only=True).worksheets[0]
    out = []
    for row_no, r in enumerate(ws.iter_rows(values_only=True), start=1):
        if row_no == 1:
            continue
        r = [("" if c is None else str(c).strip()) for c in r[:18]]
        if not r[1].startswith("BO"):
            continue
        out.append({"no": int(float(r[0])), "row": row_no, "type": r[1], "func": clean(r[2], 40), "screen": r[4],
                    "dk1": r[5], "dk2": r[6], "dk3": r[7], "action": r[10], "expected": r[11]})
    return out


def summarize(t):
    if t["type"] == "BO-E2E":
        return clean(f"{t['dk1']} – {t['dk2']} – {t['dk3']}", 200)
    what = t["dk1"] if t["dk1"] and not t["dk1"].startswith("Điều kiện") else " – ".join(x for x in (t["dk2"], t["dk3"]) if x)
    return clean(f"[{t['func']}] {what} → {clean(t['expected'], 70)}")


def step_of(t):
    for sid, (_, lo, hi) in STEPS.items():
        if lo <= t["no"] <= hi:
            return sid
    return None


def classify_hard(t):
    ae = (t["action"] + " " + t["expected"]).lower()
    if t["func"].lower().startswith("ký số") or re.search(SIG_RX, ae):
        return "SIG"
    if 1487 <= t["no"] <= 1518 or 1565 <= t["no"] <= 1580:
        return "DEP"
    # Lịch sử giao dịch / danh sách trạng thái chỉ nhắc tới TI, không cần TI thật
    if re.search(TI_RX, ae) and "lịch sử" not in t["dk2"].lower() and not t["expected"].startswith("Khi người dùng") \
            and t["no"] not in (808, 865, 1009):
        return "TI"
    if "email" in ae:
        return "EMAIL"
    if re.search(DB_RX, ae):
        return "DB"
    if re.search(FILE_FUNC_RX, t["func"].lower()):
        return "FILE"
    return None


HARD = [
    ("SIG", "Ký số cá nhân / pháp nhân điện phát hành LC",
     "🔴 Chặn bước cuối của mọi luồng phát hành; USB token = manual"),
    ("TI", "Tích hợp TI (đẩy sang TI, dữ liệu TI trả về)", "🔴 Cần TI SIT hoạt động / mock"),
    ("DEP", "Phụ thuộc trạng thái sau ký số / TI (Đã phát hành điện LC, Hoàn thành – Chờ bổ sung)",
     "🟠 Cần seed dữ liệu"),
    ("EMAIL", "Kiểm tra email", "🟡 Cần mailbox test"),
    ("DB", "Đối chiếu dữ liệu DB (CMN_*, EG_EVENT_LOG, MasterRef…)", "🟡 Cần quyền đọc DB"),
    ("FILE", "Nội dung file sinh ra (TBTN, file tác nghiệp, YCXL – .doc/.pdf)",
     "🟡 Cần tải và đọc file (parse doc/pdf)"),
]


def line(i, t, extra=""):
    return f"{i}. {summarize(t)} — *TC {t['no']}, row {t['row']}*{extra}"


def write_happy(tcs, src):
    by_no = {t["no"]: t for t in tcs}
    L = ["# BO – Phát hành LC: Happy case & Edge case\n",
         f"Nguồn: `{src}` (sheet đầu tiên). *row* = số dòng trong Excel.\n",
         "**Điều kiện chung cho mọi TC BO:** cần 1 đề nghị FO ở trạng thái *Đã gửi ngân hàng* "
         "(FO đã qua OTP + ký số) – xem `../FO/FO_automation_blockers.md`.\n",
         "Edge case chỉ liệt kê ở happy case **đầu tiên** đi qua bước đó.\n"]
    used = set()
    for title, e2e, variants, steps in HAPPY:
        L.append(f"## {title}\n")
        if e2e:
            used.add(e2e)
            L.append(f"- E2E: **TC {e2e}, row {by_no[e2e]['row']}** — {summarize(by_no[e2e])}")
            for v in variants:
                used.add(v)
                L.append(f"- Biến thể: TC {v}, row {by_no[v]['row']} — {summarize(by_no[v])}")
        else:
            L.append("- *Không có TC E2E trong file gốc cho luồng này.*")
        L.append("")
        if steps:
            L.append("### Edge cases\n")
            for sid in steps:
                items = [t for t in tcs if t["type"] == "BO" and step_of(t) == sid]
                L.append(f"#### {sid} · {STEPS[sid][0]} ({len(items)})\n")
                for i, t in enumerate(items, 1):
                    used.add(t["no"])
                    L.append(line(i, t))
                L.append("")
        else:
            L.append("*Không có edge case riêng – dùng chung edge case của các happy case trên.*\n")
    L.append("## Luồng lỗi E2E (LC không được phát hành / lỗi tích hợp)\n")
    for i, n in enumerate(NEGATIVE_E2E, 1):
        used.add(n)
        L.append(line(i, by_no[n]))
    L.append("")
    left = [t for t in tcs if t["no"] not in used]
    if left:
        L.append("## ⚠ Chưa phân loại\n")
        L += [line(i, t) for i, t in enumerate(left, 1)]
    (OUT / "BO_happy_cases.md").write_text("\n".join(L) + "\n", encoding="utf-8")
    return len(used), len(left)


def write_blockers(tcs, src):
    bo = [t for t in tcs if t["type"] == "BO"]
    groups = {k: [t for t in bo if classify_hard(t) == k] for k, _, _ in HARD}
    L = ["# BO – Test case khó automation\n",
         f"Nguồn: `{src}`, sheet `Tinh chỉnh`. **Row** = số dòng trong Excel.\n",
         "Mỗi TC chỉ nằm ở **1 nhóm** (nhóm khó nhất). BO không có OTP/2FA.\n",
         "## ⚠ Điều kiện tiên quyết cho TOÀN BỘ BO\n",
         "Mọi TC BO cần đề nghị FO đã ở trạng thái **Đã gửi ngân hàng**, tức là FO đã qua **OTP + ký số**. "
         "Nếu FO không automate được bước đó → BO cần seed dữ liệu (API/DB) hoặc chuẩn bị tay trước mỗi lần chạy. "
         "Các luồng E2E BO (TC 18–65) đều đi qua ký số điện phát hành và TI.\n",
         "## Tóm tắt\n", "| Nhóm | Số TC | Mức độ |\n|---|---|---|"]
    L += [f"| {name} | {len(groups[k])} | {lvl} |" for k, name, lvl in HARD]
    L.append(f"| **Tổng** | **{sum(len(v) for v in groups.values())}** / {len(bo)} TC BO (không tính E2E) | |\n")
    for k, name, lvl in HARD:
        L.append(f"## {name} ({len(groups[k])})\n")
        L.append("| # | TC | Row | Bước | Summary |\n|---|---|---|---|---|")
        for i, t in enumerate(groups[k], 1):
            L.append(f"| {i} | {t['no']} | {t['row']} | {step_of(t)} | {summarize(t).replace('|', '/')} |")
        L.append("")
    L += ["## Câu hỏi cần VCB trả lời\n",
          "- [ ] **Seed dữ liệu**: tạo đề nghị ở trạng thái *Đã gửi ngân hàng* (và các trạng thái BO sau) bằng API/DB được không?",
          "- [ ] **Ký số điện phát hành trên SIT**: Ký số từ xa có CKS test tự động chấp nhận không? USB token chắc chắn manual.",
          "- [ ] **TI SIT**: có hoạt động ổn định không, có mock trả số tham chiếu / điện phát hành không?",
          "- [ ] **User test BO** cho từng vai trò: CA, CA lead, CRC, CRC lead, BGĐ CN (+ user chưa đăng ký CKS).",
          "- [ ] **Mailbox test & quyền đọc DB**.\n"]
    (OUT / "BO_automation_blockers.md").write_text("\n".join(L) + "\n", encoding="utf-8")
    return {t["no"] for v in groups.values() for t in v}


def write_automatable(tcs, src, hard):
    bo = [t for t in tcs if t["type"] == "BO" and t["no"] not in hard]
    L = ["# BO – Test case automate được\n",
         f"Nguồn: `{src}`, sheet `Tinh chỉnh`. **Row** = số dòng trong Excel.\n",
         f"**{len(bo)} / {len([t for t in tcs if t['type'] == 'BO'])} TC BO** (không tính E2E) không cần ký số, TI, email, DB, "
         "đọc nội dung file sinh ra, và không phụ thuộc trạng thái sau ký số. Phần còn lại xem `BO_automation_blockers.md`.\n",
         "**Vẫn cần:** đề nghị FO ở trạng thái *Đã gửi ngân hàng* làm dữ liệu đầu vào (seed hoặc chuẩn bị tay), "
         "và user cho từng vai trò BO. Các bước sau (CRC, CRC lead, BGĐ CN) cần bản ghi đã qua bước trước – "
         "đi được bằng UI vì các bước duyệt BO không cần OTP/ký số.\n",
         "## Tóm tắt\n", "| Bước | Số TC |\n|---|---|"]
    body = []
    for sid, (name, _, _) in STEPS.items():
        items = [t for t in bo if step_of(t) == sid]
        if not items:
            continue
        L.append(f"| {sid} · {name} | {len(items)} |")
        body.append(f"## {sid} · {name} ({len(items)})\n")
        body += [line(i, t) for i, t in enumerate(items, 1)]
        body.append("")
    L.append(f"| **Tổng** | **{len(bo)}** |\n")
    (OUT / "BO_automatable.md").write_text("\n".join(L + body) + "\n", encoding="utf-8")
    return len(bo)


def main():
    src = Path(sys.argv[1])
    tcs = load(src)
    used, left = write_happy(tcs, src.name)
    hard = write_blockers(tcs, src.name)
    able = write_automatable(tcs, src.name, hard)
    print(f"BO TC: {len(tcs)} · happy-md xếp: {used} · chưa phân loại: {left} · khó: {len(hard)} · automate được: {able}")


if __name__ == "__main__":
    main()
