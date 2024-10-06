package ddtExcel;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {
    public static FileInputStream fis;
    public static FileOutputStream fos;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static XSSFCellStyle cellStyle;

    public static int getRowCount(String xlFile, String xlSheet) throws IOException {
        fis = new FileInputStream(xlFile);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(xlSheet);
        int rowCount = sheet.getLastRowNum();
        workbook.close();
        fis.close();
        return rowCount;
    }

    public static int getCellCount(String xlFile, String xlSheet, int rownum) throws IOException {
        fis = new FileInputStream(xlFile);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(xlSheet);
        row = sheet.getRow(rownum);
        int cellCount = row.getLastCellNum();
        workbook.close();
        fis.close();
        return cellCount;
    }

    public static String getCellData(String xlFile, String xlSheet, int rownum, int cellnum) throws IOException {
        fis = new FileInputStream(xlFile);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(xlSheet);
        row = sheet.getRow(rownum);
        cell = row.getCell(cellnum);
        String data;

        try {
            DataFormatter formatter = new DataFormatter();
            data = formatter.formatCellValue(cell);
            // Returns formatted value of a cell as a String regardless of a celltype
        } catch (Exception e) {
            data = "";
        }

        workbook.close();
        fis.close();
        return data;

    }

    public static void setCellData(String xlFile, String xlSheet, int rownum, int cellnum, String data) throws IOException {
        fis = new FileInputStream(xlFile);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(xlSheet);
        row = sheet.getRow(rownum);
        cell = row.createCell(cellnum);
        cell.setCellValue(data);
        fos = new FileOutputStream(xlFile);
        workbook.write(fos);
        workbook.close();
        fis.close();
        fos.close();


    }

    public static void fillGreenColor(String xlFile, String xlSheet, int rownum, int cellnum ) throws IOException {
        fis = new FileInputStream(xlFile);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(xlSheet);
        row = sheet.getRow(rownum);
        cell = row.createCell(cellnum);
        cellStyle = workbook.createCellStyle();
        cellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(cellStyle);
        fos = new FileOutputStream(xlFile);
        workbook.write(fos);
        workbook.close();
        fis.close();
        fos.close();

    }

    public static void fillRedColor(String xlFile, String xlSheet, int rownum, int cellnum ) throws IOException {
        fis = new FileInputStream(xlFile);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(xlSheet);
        row = sheet.getRow(rownum);
        cell = row.createCell(cellnum);
        cellStyle = workbook.createCellStyle();
        cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(cellStyle);
        fos = new FileOutputStream(xlFile);
        workbook.write(fos);
        workbook.close();
        fis.close();
        fos.close();

    }
}


