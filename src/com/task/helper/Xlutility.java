package com.task.helper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.IndexedColors;
public class Xlutility {
	FileInputStream fi;
	HSSFWorkbook wb;
	HSSFSheet ws;
	HSSFRow row;
	HSSFCell cell;
	FileOutputStream fo;
	
	

	public int getRowCount(String xlfile, String sheetname) throws Exception {
		fi = new FileInputStream(xlfile);
		wb = new HSSFWorkbook(fi);
		ws = wb.getSheet(sheetname);
		int rc = ws.getLastRowNum();
		return rc;
	}

	public int getCellCount(String xlfile, String sheetname, int rownum)
			throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new HSSFWorkbook(fi);
		ws = wb.getSheet(sheetname);
		row = ws.getRow(rownum);
		int cc = row.getLastCellNum();
		return cc;
	}

	public String getCellData(String xlfile, String sheetname, int rownum,
			int clnum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new HSSFWorkbook(fi);
		ws = wb.getSheet(sheetname);
		row = ws.getRow(rownum);
		cell = row.getCell(clnum);
		String data = cell.getStringCellValue();
		return data;
	}

	public String getCellNumData(String xlfile, String sheetname, int rownum,
			int clnum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new HSSFWorkbook(fi);
		ws = wb.getSheet(sheetname);
		row = ws.getRow(rownum);
		cell = row.getCell(clnum);
		long data = (long) cell.getNumericCellValue();
		String numericdata = Long.toString(data);
		return numericdata;

	}

	public void SetCellData(String ipxlfile, String opxlfile, String sheetname,
			int rownum, int clnum, String data) throws IOException

	{
		fi = new FileInputStream(ipxlfile);
		wb = new HSSFWorkbook(fi);
		ws = wb.getSheet(sheetname);
		row = ws.createRow(rownum);
		cell = row.createCell(clnum);
		cell.setCellValue(data);
		fo = new FileOutputStream(opxlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}

	public void FillGreencolour(String ipxlfile, String opxlfile,
			String sheetname, int rownum, int clnum) throws IOException {
		fi = new FileInputStream(ipxlfile);
		wb = new HSSFWorkbook(fi);
		ws = wb.getSheet(sheetname);
		row = ws.createRow(rownum);
		cell = row.createCell(clnum);

		HSSFCellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		// style.setFillPattern(CellStyle.SOLID_FOREG
		cell.setCellStyle(style);

		fo = new FileOutputStream(opxlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();

	}

	public void FillRedcolour(String ipxlfile, String opxlfile,
			String sheetname, int rownum, int clnum) throws IOException {
		fi = new FileInputStream(ipxlfile);
		wb = new HSSFWorkbook(fi);
		ws = wb.getSheet(sheetname);
		row = ws.createRow(rownum);
		cell = row.createCell(clnum);
		HSSFCellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		// style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		cell.setCellStyle(style);

		fo = new FileOutputStream(opxlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();

	}

	public void readExcel() throws IOException {
		String Input_excel = "D:\\datain\\sss.xls";

		FileInputStream fi = new FileInputStream(Input_excel);
		HSSFWorkbook wb = new HSSFWorkbook(fi);
		HSSFSheet ws = wb.getSheet("sheet1");
		HSSFRow row = ws.getRow(0);
		HSSFCell col = row.getCell(0);
	}

	public String readExcel1(int r, int c) throws IOException,
			InterruptedException {
		//fi = new FileInputStream("D:\\outpput\\abc.xls");
		//wb = new HSSFWorkbook(fi);
		//ws = wb.getSheet("Sheet1");
		String data = ws.getRow(r).getCell(c).getStringCellValue();
		//System.out.println("print" + data);
		return data;

	}

	public String readExcel12(int r, int c) throws IOException,InterruptedException {
           String data1="";
          try{
                data1 = ws.getRow(r).getCell(c).getStringCellValue().toString();
             }catch(Exception e){
	                int i = (int) ws.getRow(r).getCell(c).getNumericCellValue();
	         data1=i+"";
                  }
        return data1;

}


	public void readValue(String user, String pass) throws Exception {

		//page = new LoginPage();
		//page.login(user, pass);
	}

	public void addUser() throws Exception, InterruptedException, IOException {
		System.out.println("HELLOWORLD");
		// User use=new User();
		//User.user();
		System.out.println("HELLOWORLD");
	}
	public static void waittime() {
		try {
			Thread.sleep(1500);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/*
	 * public void FillSuccess(int rownum,int clnum) throws IOException { fi=new
	 * FileInputStream("D:\\outpput\\ddd.xls"); wb=new HSSFWorkbook(fi);
	 * ws=wb.getSheet("sheet1"); row=ws.createRow(rownum);
	 * cell=row.createCell(clnum); //HSSFCellStyle style=wb.createCellStyle();
	 * //style.setFillForegroundColor(IndexedColors.RED.getIndex()); //
	 * style.setFillPattern(CellStyle.SOLID_FOREGROUND);
	 * cell.setCellValue("success");
	 */

	// fo=new FileOutputStream("D:\\outpput\\ddd.xls");
	// wb.write(fo);
	// wb.close();
	// fi.close();
	// fo.close();

}
