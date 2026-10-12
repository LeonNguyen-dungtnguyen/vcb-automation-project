package com.vcb.lc.enums

/**
 * Format offered when viewing a file.
 */
public enum FileFormat {
	DOC('.doc'),
	PDF('.pdf')

	final String label

	FileFormat(String label) {
		this.label = label
	}
}
