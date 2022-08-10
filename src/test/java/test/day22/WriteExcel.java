package test.day22;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {
    @Test
    public void test01() throws IOException {
        String path="src/test/java/resources/veriler.xlsx";
        FileInputStream fis=new FileInputStream(path);

        //* Exceli okutalım
        Workbook workbook= WorkbookFactory.create(fis);
        FileOutputStream fos =new FileOutputStream(path);

        //* çalışma Sayfasını secelim

        Sheet sheet=workbook.getSheetAt(0);

        sheet.getRow(0).createCell(3).setCellValue("Yorumlar");
        sheet.getRow(1).createCell(3).setCellValue("100");
        sheet.getRow(2).createCell(3).setCellValue("50");
        sheet.getRow(3).createCell(3).setCellValue("25");



            //* Excelde satır silmek
//        Row silinecekSatir=sheet.getRow(3);
//        sheet.removeRow(silinecekSatir);//* fındık

        //*excelde hücre Silmek

        Cell silinecekHucre=sheet.getRow(0).getCell(2);
        sheet.getRow(0).removeCell(silinecekHucre);

        workbook.write(fos);
        workbook.close();
        fos.close();
        fis.close();

    }
}
