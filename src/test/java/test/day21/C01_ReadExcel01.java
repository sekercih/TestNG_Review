package test.day21;

import com.google.common.collect.*;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel01 {

    @Test
    public void test01() throws IOException {


            String path = "src/test/java/resources/ulkeler.xlsx";
            FileInputStream fis=new FileInputStream(path);
            //todo
            // Biz FIS ile okudugumuz excel dosyasini projemiz icerisinde kullanabilmek icin
            // Apachi POI depency yardimi ile bir Workbook olusturduk
            // Bu workbook bizim projemizin icerisinde ulkeler excel'inin bir kopyasini kullanmamizi sagliyor
            // Excel'in yapisi geregi bir hucreye(Cell) ulasabilmek icin workbooktan baslayarak
            // sirasiyla sheet, row ve cell objeleri olusturmamiz gerekiyor

            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet("Sayfa1");
            Row row = sheet.getRow(4);
            Cell cell=row.getCell(2);

            System.out.println(cell);

            //*indexi 4 olan satirdaki, index'i 2 olan hucrenin Andorra oldugunu test ediniz
            String expectedData="Andorra";
            //* Assert.assertEquals(cell.toString(),expectedData);-> cell.toString() ->String veriyor
            Assert.assertEquals(cell.getStringCellValue(),expectedData);

            //*5.indexdeki satirin, 3indexdeki hucre bilgisini yazdiralim
            row=sheet.getRow(5);
            cell=row.getCell(3);
            System.out.println("cell = " + cell);




        }
}