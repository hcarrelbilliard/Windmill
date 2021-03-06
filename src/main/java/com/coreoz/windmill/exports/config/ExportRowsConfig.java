package com.coreoz.windmill.exports.config;

import com.coreoz.windmill.exports.exporters.csv.CsvExporter;
import com.coreoz.windmill.exports.exporters.csv.ExportCsvConfig;
import com.coreoz.windmill.exports.exporters.excel.ExcelExporter;
import com.coreoz.windmill.exports.exporters.excel.ExportExcelConfig;

public class ExportRowsConfig<T> {

	private final Iterable<T> rows;
	private final ExportMapping<T> mapping;

	public ExportRowsConfig(Iterable<T> rows, ExportMapping<T> mapping) {
		this.mapping = mapping;
		this.rows = rows;
	}

	public CsvExporter<T> asCsv() {
		return asCsv(ExportCsvConfig.builder().build());
	}

	public CsvExporter<T> asCsv(ExportCsvConfig config) {
		return new CsvExporter<>(rows, mapping, config);
	}

	public ExcelExporter<T> asExcel() {
		return asExcel(ExportExcelConfig.newXlsxFile().build());
	}

	public ExcelExporter<T> asExcel(ExportExcelConfig config) {
		return new ExcelExporter<>(rows, mapping, config);
	}

}
