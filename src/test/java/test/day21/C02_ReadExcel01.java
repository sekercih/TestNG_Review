package test.day21;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C02_ReadExcel01 {

    @Test
    public void test01() throws IOException {

        // ulkeler excel'inin 3.satirini yazdirin

        String path = "src/test/java/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(fis);
        for (int i = 0; i < 4; i++) {
            System.out.println(workbook.getSheet("Sayfa1").getRow(2).getCell(i).toString());

        }
        System.out.println("**************************************");
        // ilk 20 ulkenin baskentlerinin turkce isimlerini yazdirin
        for (int i = 0; i <= 20; i++) {

            System.out.println(workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString());
        }
    }}