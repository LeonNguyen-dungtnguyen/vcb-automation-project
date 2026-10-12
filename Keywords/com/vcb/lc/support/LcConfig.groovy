package com.vcb.lc.support

import com.vcb.common.BaseKeyword

import internal.GlobalVariable

/**
 * Reads LC settings (URLs, users) from the execution profile by variable name.
 */
public class LcConfig {

	static String get(String variableName) {
		def value = null
		try {
			value = GlobalVariable."${variableName}"
		} catch (MissingPropertyException ignored) {
			// reported below
		}
		if (value == null || value.toString().startsWith('TODO_')) {
			BaseKeyword.handleError("Profile variable ${variableName} is missing or still a TODO placeholder. Run with profile SIT_LC and fill it in.", BaseKeyword.defaultFailureHandling)
		}
		return value?.toString()
	}
}
