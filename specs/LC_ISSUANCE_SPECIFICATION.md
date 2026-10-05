# Specification: VCB TradeFlat LC Issuance Workflow

**Feature:** LC Issuance Request - Single Level Approval  
**Ticket:** LC-001  
**Environment:** SIT (System Integration Testing)  
**Domain:** Trade Finance / Front Office  

---

## What We're Building

A test automation suite for VCB TradeFlat's Letter of Credit (LC) issuance workflow. The first slice covers the **happy path scenario with 1-level approval and 2-factor authentication**.

### Out of Scope (for this slice)
- 2-level approval workflows
- Legal signature scenarios
- Negative test cases (rejection/cancellation)
- Performance/load testing
- API testing (UI-only for first slice)

---

## User Story

**As a** QA automation engineer  
**I want to** verify the LC issuance workflow with 1-level approval  
**So that** I can ensure transaction flow from creation through bank submission works correctly  

---

## Acceptance Criteria

### AC1: Maker can create and submit LC request
- Maker logs into FO system
- Creates new LC issuance record with required fields
- Submission successful → Record status = "Awaiting Approval"

### AC2: Accounting Head can approve with 2FA
- Accounting Head logs in and navigates to pending transactions
- Performs 2FA authentication
- Approval successful → Record status remains "Awaiting Approval" (ready for next signer)

### AC3: Account Owner can sign digitally
- Account Owner logs in
- Performs digital signature on approved LC
- Signature successful → Record status = "Sent to Bank"

### AC4: System shows success notification
- After final signature, system displays success message
- Transaction reference visible
- User can navigate to transaction history

---

## Business Context

**VCB TradeFlat Module:** Letter of Credit Issuance (LC ISS)  
**Business Flow:**
1. Account customer (Maker) initiates LC issuance request through FO
2. Internal approver (Accounting Head) reviews and approves with 2FA
3. Account owner provides digital signature
4. Transaction submitted to bank system

**Key Business Rules:**
- LC must contain complete, valid information before approval
- 2FA required at approval stage (security requirement)
- Digital signature is mandatory before bank submission
- Once submitted, changes require cancellation + new request

---

## Technical Context

**Test Framework:** Katalon Studio  
**Application:** VCB TradeFlat FO (Front Office)  
**Test Data:** 1 Marker account, 1 Accounting Head, 1 Account Owner account  
**Test Environment:** SIT  
**Expected Execution Time:** ~5 minutes per test case  

---

## Test Scenarios (First Slice)

### Scenario 1.1: Happy Path - 1 Level Approval, No Legal Signature

**Preconditions:**
- Test accounts created (Maker, Accounting Head, Account Owner)
- LC module configured for 1-level approval
- 2FA enabled
- No legal signature required

**Test Steps:**

| # | Step | Actor | Expected Behavior |
|---|------|-------|-------------------|
| 1 | Login to FO system | Maker | Homepage displays, no errors |
| 2 | Navigate to "Create LC Issuance" | Maker | Form loads with all required fields |
| 3 | Fill all mandatory fields (LC amount, currency, beneficiary, etc.) | Maker | Form accepts data, validation passes |
| 4 | Submit for approval | Maker | Status changes to "Awaiting Approval" |
| 5 | Logout Maker, login as Accounting Head | Accounting Head | Successfully authenticated |
| 6 | Navigate to pending transactions | Accounting Head | LC request visible in pending list |
| 7 | Open LC request | Accounting Head | Full transaction details displayed |
| 8 | Perform 2FA authentication | Accounting Head | 2FA challenge presented, OTP accepted |
| 9 | Approve transaction | Accounting Head | Status remains "Awaiting Approval" |
| 10 | Logout Accounting Head, login as Account Owner | Account Owner | Successfully authenticated |
| 11 | Navigate to "Sign Transactions" | Account Owner | Approved LC visible in list |
| 12 | Open LC for signing | Account Owner | Signature field ready |
| 13 | Perform digital signature | Account Owner | Signature captured successfully |
| 14 | Confirm signature | Account Owner | Success message displayed, status = "Sent to Bank" |
| 15 | View transaction reference | Account Owner | Reference number generated and visible |

**Expected Outcome:**
- ✅ LC request successfully moves through approval → signature → bank submission
- ✅ All status transitions correct
- ✅ No error messages
- ✅ Success notification displayed

---

## Test Data Requirements

**Maker Account:**
- Username: `maker_lc_001`
- Permissions: Create LC requests
- 2FA enabled: Yes

**Accounting Head Account:**
- Username: `head_accounting_001`
- Permissions: Approve LC up to limit
- 2FA enabled: Yes
- Approval limit: >$100,000 USD

**Account Owner Account:**
- Username: `owner_account_001`
- Permissions: Sign LC requests
- Digital certificate: Valid

**LC Request Data:**
- LC Amount: $50,000 USD
- Beneficiary: Test Beneficiary Corp
- Expiry Date: 6 months from creation
- Instructions: Standard LC terms
- Other required fields: Populated with valid test data

---

## Success Metrics

✅ All 3 actors successfully complete their actions  
✅ All 5 status transitions occur in correct order  
✅ 2FA authentication succeeds  
✅ Digital signature accepted  
✅ No validation errors during submission  
✅ Success message displayed to user  
✅ Audit trail captures all actions  

---

## Dependencies & Risks

**Dependencies:**
- Test environment (SIT) accessible
- Test accounts provisioned
- LC module configured
- 2FA system operational
- Digital signature service available

**Risks:**
- 2FA timeout during test execution
- System clock synchronization issues
- Test data cleanup between runs
- Network latency affecting signature service

**Mitigation:**
- Set generous timeouts in test waits
- Sync system clocks before test run
- Use test data cleanup procedures
- Test network connectivity before execution

---

## Clarification Questions (Pre-Implementation)

**For Business Analyst:**
1. What is the timeout for 2FA OTP? (30 seconds? 1 minute?)
2. Does Account Owner always sign, or only if amount > threshold?
3. After Accounting Head approves, can Maker make changes before signing?
4. Is there a rollback procedure if signature fails?

**For Tech Lead:**
1. How is digital signature verified in test environment?
2. Can we use mock 2FA or must we use production OTP system?
3. What's the maximum number of concurrent LC requests during testing?
4. Are there API endpoints we should test in addition to UI?

---

## Implementation Notes

**Keyword Structure:**
- `LC_Create_Request` - Create new LC, validate form loads
- `LC_Submit_For_Approval` - Submit LC, verify status change
- `LC_Approve_With_2FA` - Login as approver, perform 2FA, approve
- `LC_Sign_Digitally` - Login as signer, perform digital signature
- `LC_Verify_Completion` - Verify success message, status, reference

**Test Data:**
- Store in `Data Files/LC_TestData.xlsx`
- Columns: actor_type, username, password, lc_amount, currency

**Reports Expected:**
- Pass/Fail status for each step
- Screenshots at key transitions
- Execution time
- 2FA response time
- Any error messages

---

## Next Steps

1. ✅ Finalize this specification (this document)
2. ⏳ Tech Lead approves specification
3. ⏳ Create implementation plan
4. ⏳ Break down into 3-5 implementation tasks
5. ⏳ Write Katalon test scripts
6. ⏳ Execute and verify on SIT

---

**Specification Owner:** QA Lead  
**Status:** Ready for Tech Lead Review  
**Last Updated:** 2026-10-05
