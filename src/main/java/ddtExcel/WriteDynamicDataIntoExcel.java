package ddtExcel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WriteDynamicDataIntoExcel {
    public static void main(String[] args) throws IOException {
        FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "/testdata/dynamic_data.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Data");

        Scanner input = new Scanner(System.in);
        System.out.println("Enter no. of rows: ");
        int noOfRows = input.nextInt();

        System.out.println("Enter no. of cells: ");
        int noOfCells =input.nextInt();

        for (int r = 0; r <= noOfRows; r++) {
            XSSFRow currentRow = sheet.createRow(r);
            for (int c = 0; c < noOfCells ; c++) {
                XSSFCell cell = currentRow.createCell(c);
                cell.setCellValue(input.next());
            }
            
        }
        workbook.write(file);
        input.close();
        workbook.close();
        file.close();
        System.out.println("File is created..");
    }

}
