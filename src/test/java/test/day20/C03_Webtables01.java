package test.day20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.w3c.dom.stylesheets.LinkStyle;
import utilities.TestBase;

import java.util.List;

public class C03_Webtables01 extends TestBase {
    @Test
    public void table() throws InterruptedException {
        driver.get("https://editor.datatables.net/");
        Thread.sleep(5200);
        //tbody deki dataları konsola yazdırın.
        WebElement tbody= driver.findElement(By.xpath("//tbody"));
        System.out.println("tbody.getText() = " + tbody.getText());
        Thread.sleep(5200);

        // tum table daki body size bulun
        List<WebElement>  table=driver.findElements(By.xpath("//tbody//td"));
        System.out.println("table.size() = " + table.size());


        //tum başlıkları yazdıralım
        List<WebElement>  baslik=driver.findElements(By.xpath("//thead/tr/th"));
        System.out.println("başlik.size() = " + baslik.size());
        for (WebElement bas:baslik) {
            System.out.println("bas.getText() = " + bas.getText());
        }
   /*     table() metodu oluşturun
○ Tüm table body’sinin boyutunu(size) bulun. /tbody
○ Table’daki başlıkları(headers) konsolda yazdırın.
● printRows() metodu oluşturun //tr
○ table body’sinde bulunan toplam satir(row) sayısını bulun.
○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
○ 4.satirdaki(row) elementleri konsolda yazdırın.
● printCells() metodu oluşturun //td
○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.
○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
● printColumns() metodu oluşturun
○ table body’sinde bulunan toplam sutun(column) sayısını bulun.
○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
○ 5.column daki elementleri konsolda yazdırın.*/


    }
    @Test
    public void printRows() throws InterruptedException {
        driver.get("https://editor.datatables.net/");
        Thread.sleep(5200);
        //*○ table body’sinde bulunan toplam satir(row) sayısını bulun.

        System.out.println(" table body =" +
                " " + driver.findElements(By.xpath("//tbody//tr")).size());
        //*○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        List<WebElement> allrows=driver.findElements(By.xpath("//tbody/tr"));

        for (WebElement each:allrows) {
            System.out.println("allrows = " + each.getText());
        }
        //*○ 4.satirdaki(row) elementleri konsolda yazdırın.
        List<WebElement> rows4=driver.findElements(By.xpath("//tr[4]//td"));
        for (WebElement each:rows4) {
            System.out.println("4rows = " + each.getText());
        }
    }
    @Test
    public void printCells() throws InterruptedException {
        driver.get("https://editor.datatables.net/");
        Thread.sleep(5200);
     //*   ○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        System.out.println("hücre(cell) sayısı = " + driver.findElements(By.xpath("//tbody//td")).size());
        //* ○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
        List<WebElement> cell=driver.findElements(By.xpath("//tbody//td"));
        for (WebElement each:cell ) {
            System.out.println("cell = " + each.getText());
        }

    }
    /*● printColumns() metodu oluşturun
○ table body’sinde bulunan toplam sutun(column) sayısını bulun.
○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
○ 5.column daki elementleri konsolda yazdırın.*/
    @Test
    public void printColumns() throws InterruptedException {
        driver.get("https://editor.datatables.net/");
        Thread.sleep(5200);
        List <WebElement> colum=driver.findElements(By.xpath("//tr[3]//td"));
        System.out.println("Sütun sayisi= " + colum.size()+" adettir");

        //* ○  5.column daki elementleri konsolda yazdırın.
        List <WebElement> colum5=driver.findElements(By.xpath("//tbody//td[5]"));
        for (WebElement each:colum5 ) {
            System.out.println("colum5 = " + each.getText());

        }

//!https://www.techlistic.com/p/demo-selenium-practice.html
      //*  burdan biraz konuşalım

    }

}
