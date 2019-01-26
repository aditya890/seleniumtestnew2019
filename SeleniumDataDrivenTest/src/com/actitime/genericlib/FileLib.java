package com.actitime.genericlib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {

public String getPropertykeyValue(String key)throws IOException {
	FileInputStream fis= new FileInputStream("D:\\eclipse\\New folder\\SeleniumDataDrivenTest\\data\\commonData.properties");
	Properties pobj= new Properties();
	pobj.load(fis);
	String data=pobj.getProperty(key);
	return data;
	}

public String getExcelData(String sheetName,int rowNum,int cellNum)throws  Throwable {
	
	FileInputStream fis=new FileInputStream("D:\\eclipse\\New folder\\SeleniumDataDrivenTest\\data\\testData.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
    Sheet sh=wb.getSheet(sheetName);
    Row row=sh.getRow(rowNum);
    Cell c1=row.getCell(cellNum);
    String data=  c1.getStringCellValue();
    wb.close();
    return data;
	}

public String setExcelData(String sheetName,int rowNum,int cellNum)throws  Throwable {
	
	FileInputStream fis=new FileInputStream("D:\\eclipse\\New folder\\SeleniumDataDrivenTest\\data\\testData.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
    Sheet sh=wb.getSheet(sheetName);
    Row row=sh.getRow(rowNum);
    Cell c1=row.getCell(cellNum);
    String data=  c1.getStringCellValue();
    
    System.out.println(data);
    
    FileOutputStream fos=new FileOutputStream("/SeleniumDataDrivenTest/data/testData.xlsx");
    wb.write(fos);
    wb.close();
    return data;
	}

}
