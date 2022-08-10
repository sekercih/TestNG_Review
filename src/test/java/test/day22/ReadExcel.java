package test.day22;

import org.apache.poi.ss.usermodel.*;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadExcel {
    @Test
    public void test01() throws IOException {
        String path="src/test/java/resources/veriler.xlsx";

        FileInputStream fis=new FileInputStream(path);

        //* Exceli okumak
        Workbook workbook= WorkbookFactory.create(fis);
//* Sheet (Sayfa seçimi)
        Sheet sheet=workbook.getSheet("Sayfa1");
        //*Sayfadan sonra satır seçimi
        Row row=sheet.getRow(0);
//        Cell cell=row.getCell(0);
//        Cell cell1=row.getCell(1);
//        Cell cell2=row.getCell(2);
//
//        System.out.println("cell.toString() = " + cell.toString());
//        System.out.println("cell.toString() = " + cell1.toString());
//        System.out.println("cell.toString() = " + cell2.toString());
        for (int i=0; i<3; i++) {
            System.out.println("row.getCell(i) = " + row.getCell(i));
        }
        //*icerisinde data olan satır sayısı
        int satirSayisi=sheet.getPhysicalNumberOfRows();
        System.out.println("satirSayisi = " + satirSayisi);

        //** sheet içindeki son satır
         int sonSatir=sheet.getLastRowNum();
        System.out.println("sonSatir = " + sonSatir);

        Scanner scanner=new Scanner(System.in);
        String  harf=scanner.nextLine();

       scanner.close();


fis.close();
workbook.close();
    }
}
