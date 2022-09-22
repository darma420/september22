package com.task.testcase;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class XlutilityClass {
	FileInputStream fis;
	HSSFWorkbook  hwb;
	HSSFSheet hws;
	HSSFRow row;
	HSSFCell cell;
	FileOutputStream fos;
	
	public int getRowCount(String file,String Shetname ) throws Exception{
		fis=new FileInputStream(file);
		hwb=new HSSFWorkbook(fis);
		hws=hwb.getSheet(Shetname);
		int num=hws.getLastRowNum();
		return num;
	}
	public int getCellCount(String file,String Shetname,int rownum ) throws Exception{
		fis=new FileInputStream(file);
		hwb=new HSSFWorkbook(fis);
		hws=hwb.getSheet(Shetname);
		row=hws.getRow(rownum);
		int cellNum=row.getLastCellNum();
		return cellNum;
	}

}
