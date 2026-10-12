package com.vcb.lc.model

import static com.kms.katalon.core.testdata.TestDataFactory.findTestData

import com.kms.katalon.core.testdata.TestData

/**
 * Field values of one LC request, grouped by wizard section (section → field → value).
 * Data File columns are named "<section>.<field>", e.g. "giaTriLc.soTien".
 */
public class LcRequestData {
	Map<String, Map<String, String>> sections = [:]

	/** Mã đề nghị, filled by the keyword that saves or submits the request. */
	String requestCode

	static LcRequestData fromDataFile(String dataFileId, int row) {
		TestData testData = findTestData(dataFileId)
		LcRequestData data = new LcRequestData()
		testData.getColumnNames().each { String column ->
			int dot = column.indexOf('.')
			if (dot < 0) {
				throw new IllegalArgumentException("Column '${column}' of ${dataFileId} must be named <section>.<field>")
			}
			data.put(column.substring(0, dot), column.substring(dot + 1), testData.getValue(column, row))
		}
		return data
	}

	void put(String section, String field, String value) {
		sections.get(section, [:]).put(field, value)
	}

	String get(String section, String field) {
		return sections[section]?.get(field)
	}

	Map<String, String> section(String section) {
		return sections[section] ?: [:]
	}
}
