# VCB TradeFlat LC Issuance - Test Cases (Sample: 10 rows)

**Project:** VCB TradeFlat - Letter of Credit Module  
**Module:** FO (Front Office)  
**Environment:** SIT  
**Date:** 2026-10-05  

---

## Overview

Test cases for Letter of Credit (LC) Issuance workflow covering:
- ✅ Happy path scenarios (1 & 2-level approvals)
- ✅ Multi-signature flows (Account holder + Legal representative)
- ✅ Draft save & publish
- ✅ Cancellation & rejection flows

---

## Test Case #1: 1-Level Approval Without Legal Signature

| Property | Value |
|----------|-------|
| **TC ID** | 1 |
| **Type** | FO-E2E |
| **Function** | Verify LC issuance flow |
| **Flow** | Success |
| **Screen** | Create LC Issuance Request |
| **Condition** | 1-level approval, 2FA, no legal signature |
| **Priority** | Critical |
| **Component** | FO |
| **Environment** | SIT |

### Actors
- 1 x Maker (initiator)
- 1 x Accounting Head (approver)
- 1 x Account Owner (signer)

### Steps
1. Maker logs into FO system
2. Create new LC issuance record with required fields (1-level approval, 2FA enabled, no legal signature)
3. Maker submits transaction → Status: "Awaiting Approval"
4. Accounting Head logs in, performs 2FA authentication, approves
5. Account Owner logs in, performs digital signature successfully
6. Observe result

### Expected Result
1. After Maker creation → Status: "Awaiting Approval"
2. After Accounting Head 2FA & approval → Status: "Awaiting Approval"
3. After Account Owner signature → System displays success message, status becomes "Sent to Bank"

---

## Test Case #2: 1-Level Approval With Legal Signature

| Property | Value |
|----------|-------|
| **TC ID** | 2 |
| **Function** | Verify LC issuance with legal signature |
| **Flow** | Success |
| **Condition** | 1-level approval, 2FA, with legal signature |
| **Priority** | Critical |

### Actors
- 1 x Maker
- 1 x Accounting Head
- 1 x Account Owner
- 1 x Legal Representative (legal signer)

### Steps
1. Maker logs in and creates new LC record with complete data (1-level approval, 2FA, legal signature enabled)
2. Maker submits transaction → Status: "Awaiting Approval"
3. Accounting Head logs in, performs 2FA, approves
4. Account Owner logs in, signs digitally → Status: "Awaiting Legal Signature"
5. Legal representative logs in, signs successfully
6. Observe result

### Expected Result
1. After Maker creation → Status: "Awaiting Approval"
2. After Accounting Head approval → Status: "Awaiting Approval"
3. After Account Owner signature → Status: "Awaiting Legal Signature"
4. After Legal representative signature → System displays success, status: "Sent to Bank"

---

## Test Case #3: 2-Level Approval Without Legal Signature

| Property | Value |
|----------|-------|
| **TC ID** | 3 |
| **Function** | Verify 2-level approval workflow |
| **Flow** | Success |
| **Condition** | 2-level approval, 2FA, no legal signature |
| **Priority** | Critical |

### Actors
- 1 x Maker
- 1 x Deputy Accountant
- 1 x Accounting Head
- 1 x Account Owner

### Steps
1. Maker logs in, creates LC record with complete data (2-level approval, 2FA, no legal signature)
2. Maker submits transaction → Status: "Awaiting Approval"
3. Deputy Accountant logs in, performs 2FA, approves → Status: "Awaiting Next Level Approval"
4. Accounting Head logs in, performs 2FA, approves
5. Account Owner logs in, signs digitally
6. Observe result

### Expected Result
1. After Maker creation → Status: "Awaiting Approval"
2. After Deputy Accountant approval (2FA #1) → Status: "Awaiting Next Level Approval"
3. After Accounting Head approval (2FA #2) → Status: "Awaiting Next Level Approval"
4. After Account Owner signature → System displays success, status: "Sent to Bank"

---

## Test Case #4: 2-Level Approval With Legal Signature

| Property | Value |
|----------|-------|
| **TC ID** | 4 |
| **Condition** | 2-level approval, 2FA, with legal signature |
| **Priority** | Critical |

### Steps (Summary)
1. Maker creates LC record (2-level approval, 2FA, legal signature)
2. Deputy Accountant approves (2FA)
3. Accounting Head approves (2FA)
4. Account Owner signs → "Awaiting Legal Signature"
5. Legal representative signs successfully

### Expected Result
Final status: "Sent to Bank"

---

## Test Case #5: Draft Save Then Publish (1-Level + Legal Sig)

| Property | Value |
|----------|-------|
| **TC ID** | 5 |
| **Flow** | Draft → Publish → Success |
| **Priority** | High |

### Key Difference
- Maker can save as draft, then later open and publish
- Workflow continues normally after publish

### Statuses
1. After creation → "Create LC Issuance"
2. After draft save → "Draft"
3. After submit → "Awaiting Approval"
4. After approvals & signatures → "Sent to Bank"

---

## Test Case #6: Draft Save Then Publish (2-Level + Legal Sig)

| Property | Value |
|----------|-------|
| **TC ID** | 6 |
| **Condition** | 2-level approval, draft save, legal signature |
| **Priority** | High |

### Steps (Summary)
1. Maker creates LC, saves as draft
2. Maker reopens draft, publishes → "Awaiting Approval"
3. Deputy Accountant approves
4. Accounting Head approves
5. Account Owner signs → "Awaiting Legal Signature"
6. Legal rep signs

### Expected Result: "Sent to Bank"

---

## Test Case #7: Draft Save Then Publish (1-Level, No Legal Sig)

| Property | Value |
|----------|-------|
| **TC ID** | 7 |
| **Condition** | 1-level approval, draft save, no legal signature |
| **Priority** | High |

### Statuses
1. Maker creation → "Create LC Issuance"
2. Draft save → "Draft"
3. Publish → "Awaiting Approval"
4. Accounting Head approval → "Awaiting Approval"
5. Account Owner signature → "Sent to Bank"

---

## Test Case #8: Draft Save Then Publish (2-Level, No Legal Sig)

| Property | Value |
|----------|-------|
| **TC ID** | 8 |
| **Condition** | 2-level approval, draft save, no legal signature |
| **Priority** | High |

### Expected Flow
Draft → Awaiting Approval → Next Level → Signed → Sent to Bank

---

## Test Case #9: Cancellation from Draft

| Property | Value |
|----------|-------|
| **TC ID** | 9 |
| **Flow** | Cancellation |
| **Priority** | High |

### Steps
1. Maker creates LC, saves as draft
2. Maker opens record, selects "Cancel Request", confirms
3. Observe result

### Expected Result
1. After creation → "Create LC Issuance"
2. After draft save → "Draft"
3. After cancellation → "Cancelled"

---

## Test Case #10: Rejection at Accounting Head Level

| Property | Value |
|----------|-------|
| **TC ID** | 10 |
| **Flow** | Rejection |
| **Condition** | Rejected at Accounting Head level |
| **Priority** | Critical |

### Steps
1. Maker creates LC, submits → "Awaiting Approval"
2. Accounting Head (Checker) logs in, selects "Reject", enters reason, confirms
3. Observe result

### Expected Result
1. After Maker submission → "Awaiting Approval"
2. After Accounting Head rejection → "Cancelled"

---

## Summary

**Total Test Cases Analyzed:** 10 rows  
**Total Project Test Cases:** 1,581  

**Key Features Covered:**
- ✅ Single & multi-level approvals
- ✅ 2FA authentication at each approval level
- ✅ Digital signatures (account holder & legal representative)
- ✅ Draft save & publish workflow
- ✅ Transaction cancellation
- ✅ Approval rejection with reason

**Next Steps:**
- Generate full test specification
- Map to APAC-SDLC workflow
- Create implementation tasks
