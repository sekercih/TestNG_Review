package test.day20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class C03_Webtables extends TestBase {
    //todo
    // https://editor.datatables.net/ gidelim
    //  /*     table() metodu oluşturun
    // ○ Tüm table body’sinin boyutunu(size) bulun. /tbody
    // ○ Table’daki başlıkları(headers) konsolda yazdırın.
    // ● printRows() metodu oluşturun //tr
    // ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
    // ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
    // ○ 4.satirdaki(row) elementleri konsolda yazdırın.
    // ● printCells() metodu oluşturun //td
    // ○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.
    // ○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
    // ● printColumns() metodu oluşturun
    // ○ table body’sinde bulunan toplam sutun(column) sayısını bulun.
    // ○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
    // ○ 5.column daki elementleri konsolda yazdırın.*/
    @Test
    public void  table() throws InterruptedException {
        driver.get("https://editor.datatables.net/");
        Thread.sleep(5000);
        //*// ○ Tüm table body’sinin boyutunu(size) bulun. /tbody
      List<WebElement> tbody=driver.findElements(By.xpath("//tbody//td"));
        System.out.println("tbody.size() = " + tbody.size()); //?60

      //* // ○ Table’daki başlıkları(headers) konsolda yazdırın.
       List <WebElement> baslik=driver.findElements(By.xpath("//thead//th"));
        for (WebElement bas:baslik ) {
            System.out.println("bas.getText() = " + bas.getText());
        }

    }
    @Test
    public void printRows() throws InterruptedException {
        driver.get("https://editor.datatables.net/");
        Thread.sleep(5000);

        // *○ table bulunan toplam satir(row) sayısını bulun.
        List<WebElement> table=driver.findElements(By.xpath("//table//tr"));
        System.out.println("table.size() = " + table.size());

        // *   // ○ Table  bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement tableRow:table) {
            System.out.println("tableRow.getText() = " + tableRow.getText());
        }
        //  *  // ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        WebElement row4=driver.findElement(By.xpath("//table//tr[4]"));
        System.out.println("row4.getText() = " + row4.getText());
    }
    @Test
    public void printCells() throws InterruptedException {
        driver.get("https://editor.datatables.net/");
        Thread.sleep(5000);

        //* // ○ table  bulunan toplam hücre(cell) sayısını bulun.
        List<WebElement> cell=driver.findElements(By.xpath("//table//td"));
        System.out.println("cell.size() = " + cell.size());

        // *   // ○ Table bulunan hücreleri(cells) konsolda yazdırın.
        for (WebElement hucreSayisi:cell) {
            System.out.println("hucreSayisi.getText() = " + hucreSayisi.getText());
        }
    }
    @Test
    public void printColumns() throws InterruptedException {
        driver.get("https://editor.datatables.net/");
        Thread.sleep(5000);
        //*// ○ table body’sinde bulunan toplam sutun(column) sayısını bulun.
        List <WebElement> column=driver.findElements(By.xpath("//tr[6]//td"));
        System.out.println("column.size() = " + column.size());

        //*    // ○ Table body’sinde bulunan sutunlardaki "office" kısmını(column) konsolda yazdırın.

        List<WebElement>office=driver.findElements(By.xpath("//tbody//td[4]"));
        for (WebElement officeColumn:office) {
            System.out.println("officeColumn.getText() = " + officeColumn.getText());
        }
        // *   // ○ 6.column daki elementleri konsolda yazdırın.*/

    }

}
