package com.vcb.lc.support

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.vcb.common.BaseKeyword
import com.vcb.common.WebUIKeyword

import internal.GlobalVariable

/**
 * The ONLY two places where OTP (2FA) and digital signing happen.
 * When SIT defines the mechanism (fixed OTP, bypass, mock, USB token...), change these two methods only;
 * no business keyword needs to change. Open question: requirements/LC_ISS/FO/FO_flows.md §5.
 */
public class SecurityStepHandler extends BaseKeyword {

	/**
	 * Enter the OTP into the 2FA popup field. Caller confirms the popup afterwards.
	 */
	static void enterOtp(TestObject otpField, FailureHandling flowControl = defaultFailureHandling) {
		WebUIKeyword.waitForElementVisible(otpField, GlobalVariable.G_timeoutMedium, flowControl)
		// TODO: obtain the OTP with the SIT mechanism and type it: WebUIKeyword.setText(otpField, otp, flowControl)
		handleError('TODO: SIT OTP (2FA) mechanism is not defined yet (FO_flows.md §5)', flowControl)
	}

	/**
	 * Complete a digital signature (Ký số cá nhân / pháp nhân in FO, ký số điện phát hành in BO)
	 * after the Ký số button has been clicked.
	 */
	static void completeDigitalSignature(String signerRole, FailureHandling flowControl = defaultFailureHandling) {
		info "Digital signature by ${signerRole}"
		// TODO: sign with the SIT mechanism (USB token / HSM / mock) and confirm the signing dialog
		handleError("TODO: SIT digital signing mechanism is not defined yet (signer: ${signerRole})", flowControl)
	}
}
