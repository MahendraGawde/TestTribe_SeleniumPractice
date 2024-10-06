package ddtExcel;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteDataIntoExcel {
    public static void main(String[] args) throws IOException {
        FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "/testdata/myfile.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Data");

        XSSFRow row1 = sheet.createRow(0);
        row1.createCell(0).setCellValue("Java");
        row1.createCell(1).setCellValue("Version");
        row1.createCell(2).setCellValue(19.0);

        XSSFRow row2 = sheet.createRow(1);
        row2.createCell(0).setCellValue("Python");
        row2.createCell(1).setCellValue("Version");
        row2.createCell(2).setCellValue(3.0);

        XSSFRow row3 = sheet.createRow(2);
        row3.createCell(0).setCellValue("JavaScript");
        row3.createCell(1).setCellValue("Version");
        row3.createCell(2).setCellValue(5.0);

        workbook.write(file);
        workbook.close();
        file.close();
        System.out.println("File created");
    }
}
