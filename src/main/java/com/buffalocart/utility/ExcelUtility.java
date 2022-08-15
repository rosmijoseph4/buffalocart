package com.buffalocart.utility;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtility {
    public String readSingleData(int i, int j,String sheetname)  {
        String filepath = System.getProperty("user.dir") + "\\src\\main\\resources\\loginpage.xlsx\\";
        File file = new File(filepath);
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        XSSFSheet sheet = wb.getSheet(sheetname);
        Row r = sheet.getRow(i);
        Cell c = r.getCell(j);
        DataFormatter formatter = new DataFormatter();
        String value = formatter.formatCellValue(sheet.getRow(i).getCell(j));
        return value;
    }
    public Object[][] readDataFromExcel(String filePath, String sheetName)  {
        FileInputStream file = null;
        try {
            file = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        XSSFSheet sheet = workbook.getSheet(sheetName);
        int noOfRows = sheet.getLastRowNum();
        int noOfColumns = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[noOfRows][noOfColumns];
        for (int i = 1; i <=noOfRows; i++) {
            for (int j = 0; j < noOfColumns; j++) {
                DataFormatter formatter = new DataFormatter();
                data[i-1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));
            }
            System.out.println();
        }
        try {
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
    public static String readStringData(int i, int j, String sheetname) {
        String filepath = System.getProperty("user.dir") + "\\src\\main\\resources\\loginpage.xlsx\\";
        int rowTotal;
        FileInputStream f = null;
        try {
            f = new FileInputStream(filepath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        XSSFWorkbook w = null;
        try {
            w = new XSSFWorkbook(f);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        XSSFSheet s = w.getSheet(sheetname);
        Row r = s.getRow(i);
        Cell c = r.getCell(j);

        return c.getStringCellValue();

    }
    public List<String> getExcelAsArrayList(String sheetName){
        String filepath = System.getProperty("user.dir") + "\\src\\main\\resources\\loginpage.xlsx";
        FileInputStream file = null;
        try {
            file = new FileInputStream(filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        XSSFSheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum();
        int cellCount = sheet.getRow(0).getLastCellNum();
        List<String> values=new ArrayList<String>();
        for (int i = 0; i <= rowCount; i++) {
            Row r = sheet.getRow(i);
            for (int j = 0; j < cellCount; j++) {
                Cell c = r.getCell(j);
                DataFormatter formatter = new DataFormatter();
                values.add (formatter.formatCellValue(sheet.getRow(i).getCell(j)));
            }

        }
        return values;
    }

}
