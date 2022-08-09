package test.day21;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;

import java.io.IOException;

public class C04_SatirSayisi01 {
    @Test
    public void test01() throws IOException {
        //ulkeler excelindeki Sayfa1 ve Sayfa2 deki satir sayilari
        // ve kullanılan satir sayilarini bulun
        String path="src/test/java/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(fis);

        int sayfa1SatirSayisi=workbook.getSheet("Sayfa1").getLastRowNum();// index ile calisir
        int sayfa1FizikiKullanilanSatirSayisi=workbook.getSheet("sayfa1").getPhysicalNumberOfRows();//index ile degil sayma sayısıyla gelir

        System.out.println("1.sayfa satir sayisi : "+sayfa1SatirSayisi);
        System.out.println("1.sayfa fiziki kullanılan satir sayisi: " +sayfa1FizikiKullanilanSatirSayisi);

        int sayfa2SatirSayisi=workbook.getSheet("Sayfa2").getLastRowNum();// index ile calisir
        int sayfa2FizikiKullanilanSatirSayisi=workbook.getSheet("sayfa2").getPhysicalNumberOfRows();//index ile degil sayma sayısıyla gelir

        System.out.println("2.sayfa satir sayisi : "+sayfa2SatirSayisi);
        System.out.println("2.sayfa fiziki kullanılan satir sayisi: " +sayfa2FizikiKullanilanSatirSayisi);



    }

}
