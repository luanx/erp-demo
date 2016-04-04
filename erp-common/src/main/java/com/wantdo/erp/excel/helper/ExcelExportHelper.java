package com.wantdo.erp.excel.helper;

import com.google.common.collect.Maps;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Date : 2015-8-24
 * @From : stat
 * @Author : luanx@wantdo.com
 */
public class ExcelExportHelper {

	// 设置cell编码解决中文高位字节截断
	// private static short XLS_ENCODING = HSSFWorkbook.ENCODING_UTF_16;
	public static final int MAX_ROW = 65535;
	
	private Workbook workbook;
	
	private List<Sheet> sheets = new ArrayList<Sheet>(1);

	private Sheet sheet;

	private Row row;
	
	private CellStyles cellStyles;
	
	private int rowIndex = 0;

	private Map<Sheet, Integer> mapRowIndex = Maps.newHashMap();
	
	public enum ExcelType {
		XLS("xls"),
		XLSX("xlsx");
		
		private final String type;

		ExcelType(String type) {
			this.type = type;
		}

		public String getType() {
			return this.type;
		}
	}
	
	public ExcelExportHelper() {
		this.workbook = new HSSFWorkbook();
		this.sheet = workbook.createSheet();
		this.sheets.add(sheet);
		cellStyles = new DefaultCellStyles(workbook);
	}

	public ExcelExportHelper(List<String> sheetList) {
		this.workbook = new HSSFWorkbook();
		for(int i=0; i<sheetList.size(); i++){
			Sheet newSheet = workbook.createSheet();
			workbook.setSheetName(i, sheetList.get(i));
			this.sheets.add(newSheet);
		}
		cellStyles = new DefaultCellStyles(workbook);
	}


	
	public ExcelExportHelper(ExcelType excelType) {
		switch (excelType) {
		case XLS:
			this.workbook = new HSSFWorkbook();
			break;
		case XLSX:
			this.workbook = new XSSFWorkbook();
			break;
		default:
			this.workbook = new HSSFWorkbook();
			break;
		}
		
		this.sheet = workbook.createSheet();
		this.sheets.add(sheet);
	}

	public ExcelExportHelper(String file) {
		try {
			InputStream input = new FileInputStream(file);
			
			int end = file.lastIndexOf(".");
			String ext = file.substring(end+1);
			
			if (ext.equalsIgnoreCase(ExcelType.XLS.getType())) {
				POIFSFileSystem fs = new POIFSFileSystem(input);
				this.workbook = new HSSFWorkbook(fs);
			} else if (ext.equalsIgnoreCase(ExcelType.XLSX.getType())) {
				this.workbook = new XSSFWorkbook(input);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.sheet = workbook.createSheet();
		this.sheets.add(sheet);
	}

	/**
	 * 导出Excel文件
	 *
	 */
	public void export(String xlsFileName) throws RuntimeException {
		try {
			export(new FileOutputStream(xlsFileName));
		} catch (FileNotFoundException e) {
			throw new RuntimeException("生成导出Excel文件出错!", e);
		}
	}

	public void export(OutputStream os) throws RuntimeException {
		try {
			workbook.write(os);
			os.flush();
		} catch (FileNotFoundException e) {
			throw new RuntimeException("生成导出Excel文件出错!", e);
		} catch (IOException e) {
			throw new RuntimeException("写入Excel文件出错!", e);
		} finally {
			try {
				if (os != null)
					os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void setCell(int index, String value, CellStyle cellStyle) {
		Cell cell = this.row.createCell(index);
		cell.setCellValue(value);
		if (cellStyle != null) {
			cell.setCellStyle(cellStyle);
		}
	}
	
	public void setCell(int index, String value) {
		if (cellStyles != null) {
			setCell(index, value, cellStyles.getStringStyle());
		} else {
			setCell(index, value, null);
		}
	}
	
	public void setCell(int index, Date value, CellStyle cellStyle) {
		Cell cell = this.row.createCell(index);
		cell.setCellValue(value);
		if (cellStyle != null) {
			cell.setCellStyle(cellStyle);
		}
	}
	
	public void setCell(int index, Date value) {
		if (cellStyles != null) {
			setCell(index, value, cellStyles.getDateStyle());
		} else {
			setCell(index, value, null);
		}
	}
	
	public void setCell(int index, int value, CellStyle cellStyle) {
		Cell cell = this.row.createCell(index);
		cell.setCellValue(value);
		if (cellStyle != null) {
			cell.setCellStyle(cellStyle);
		}
	}
	
	public void setCell(int index, int value) {
		if (cellStyles != null) {
			setCell(index, value, cellStyles.getStringStyle());
		} else {
			setCell(index, value, null);
		}
	}
	
	public void setCell(int index, double value, CellStyle cellStyle) {
		Cell cell = this.row.createCell(index);
		cell.setCellValue(value);
		if (cellStyle != null) {
			cell.setCellStyle(cellStyle);
		}
	}
	
	public void setCell(int index, double value) {
		if (cellStyles != null) {
			setCell(index, value, cellStyles.getNumberStyle());
		} else {
			setCell(index, value, null);
		}
	}
	
	public void setCell(int index, float value, CellStyle cellStyle) {
		Cell cell = this.row.createCell(index);
		cell.setCellValue(value);
		if (cellStyle != null) {
			cell.setCellStyle(cellStyle);
		}
	}
	
	public void setCell(int index, float value) {
		if (cellStyles != null) {
			setCell(index, value, cellStyles.getNumberStyle());
		} else {
			setCell(index, value, null);
		}
	}
	
	public void setCellHeader(int index, String value, CellStyle cellStyle) {
		Cell cell = this.row.createCell(index);
		cell.setCellValue(value);
		if (cellStyle != null) {
			cell.setCellStyle(cellStyle);
		}
	}
	
	public void setCellHeader(int index, String value) {
		if (cellStyles != null) {
			setCellHeader(index, value, cellStyles.getHeaderStyle());
		} else {
			setCell(index, value, null);
		}
	}
	
	public void setCellFormula(int index, String formula, CellStyle cellStyle) {
		Cell cell = this.row.createCell(index);
		cell.setCellFormula(formula);
		if (cellStyle != null) {
			cell.setCellStyle(cellStyle);
		}
	}
	
	public void setCellFormula(int index, String formula) {
		if (cellStyles != null) {
			setCellFormula(index, formula, cellStyles.getFormulaStyle());
		} else {
			setCell(index, formula, null);
		}
	}
	
	/**
	 * 增加一行
	 */
	public void createRow() {
		// 超过MAX_ROW自动创建新的sheet
		if (getRowIndex() > MAX_ROW) {
			this.sheet = workbook.createSheet();
			this.sheets.add(sheet);
			
			rowIndex = 0;
		}
		this.row = this.sheet.createRow(rowIndex++);
	}

	/**
	 * 增加一行
	 */
	public void createRow(Sheet sheetDest) {
		this.sheet = sheetDest;
		Integer currentRowIndex = mapRowIndex.get(sheetDest);
		if (currentRowIndex == null){
			currentRowIndex = 0;
		}
		this.row = sheet.createRow(currentRowIndex++);
		mapRowIndex.put(sheetDest, currentRowIndex);
	}

	/**
	 * 返回 workbook 的值
	 * 
	 * @return workbook
	 */
	public Workbook getWorkbook() {
		return workbook;
	}

	/**
	 * 返回 sheet 的值
	 * 
	 * @return sheet
	 */
	public Sheet getSheet() {
		return sheet;
	}

	/**
	 * 返回 row 的值
	 * 
	 * @return row
	 */
	public Row getRow() {
		return row;
	}

	/**  
	 * 返回 rowIndex 的值   
	 * @return rowIndex  
	 */
	public int getRowIndex() {
		return rowIndex;
	}

	/**
	 * @return the cellStyles
	 */
	public CellStyles getCellStyles() {
		return cellStyles;
	}

	/**
	 * @param cellStyles the cellStyles to set
	 */
	public void setCellStyles(CellStyles cellStyles) {
		this.cellStyles = cellStyles;
	}

	/**
	 * @return the sheets
	 */
	public List<Sheet> getSheets() {
		return sheets;
	}


}
