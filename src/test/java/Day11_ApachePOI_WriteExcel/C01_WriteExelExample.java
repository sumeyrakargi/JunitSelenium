package Day11_ApachePOI_WriteExcel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C01_WriteExelExample {

    @Test
    public void testwriteExel() throws IOException {

        //Dosyanın path i belirlendi
        String path="src/test/java/resources/excelfile (1).xlsx";
        //Dosya açıldı
        FileInputStream fis=new FileInputStream(path);
        //Dosya bir workbook haline getirildi
        Workbook wb= WorkbookFactory.create(fis);
        //Sheet oluşturuldu
        Sheet sheet2=wb.getSheetAt(1);
        //ilk satıra gittik
        Row row1=sheet2.getRow(0);
        //ilk satırın 3. hücresi oluşturuldu
        Cell rowccell3=row1.createCell(4);
        //Hücreye değer ataması yapıldı
        rowccell3.setCellValue("POPULATION");
        //Method chain ile data ekleme/değiştirme methodu
        sheet2.getRow(1).getCell(4).setCellValue("Rusya'nın populasyonu");
        sheet2.getRow(2).getCell(4).setCellValue("Cin'ın populasyonu");
        sheet2.getRow(3).getCell(4).setCellValue("ABD'nın populasyonu");
        //Exel dosyasına yazma işlemi yapıldı
        FileOutputStream fos=new FileOutputStream(path);
        wb.write(fos);
        //Dosyalar kapatıldı
        fis.close();
        fos.close();
    }
}
