package Day11_ApachePOI_WriteExcel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.*;

public class C02_WriteEXcelExample02 {

    @Test
    public void changeExcelData() throws IOException {
        String filePath="src/test/java/resources/excelData.xlsx";
        //Path den file oluşturuyoruz
        File file = new File(filePath);
        //File ı açıyoruz
        FileInputStream fis = new FileInputStream(file);
       //Workbook oluşturuyoruz
        Workbook wb= WorkbookFactory.create(fis);
        //sheet oluşturuyoruz
        Sheet informationData=wb.getSheet("informationData");
       //Total row sayısını buluyoruz
        int totalRowUsed=informationData.getLastRowNum()-informationData.getFirstRowNum();
        System.out.println("Total rows "+totalRowUsed);
        //Yeni row olışturup cell leri oluşturuyor ve değer atıyoruz
        Row row5=informationData.createRow(4);
        row5.createCell(0).setCellValue("Sumeyra");
        row5.createCell(1).setCellValue("Kargı");
        row5.createCell(2).setCellValue("Sumkar@yy.com");
        row5.createCell(3).setCellValue("Female");
        row5.createCell(4).setCellValue("1365485");
        row5.createCell(5).setCellValue("Address");

        FileOutputStream fos=new FileOutputStream(file);
        wb.write(fos);
        fis.close();
        fos.close();
        wb.close();


    }
}
