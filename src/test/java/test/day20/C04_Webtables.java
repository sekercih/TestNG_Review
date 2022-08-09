package test.day20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_Webtables extends TestBase {
 //todo
//  1. Bir metod oluşturun: printData(int row, int column);
//  a. Satır(row) ve sütun(column) numarasını girdiğinizde,
//  printData metodu bu hücredeki(cell) veriyi yazdırmalıdır.
//  2. Baska bir metod daha oluşturun: printDataTest();
//  a. Ve bu metodu printData() methodunu cagirmak icin kullanin.
//  b. Örnek: printData (3.5); =>
//  3. satır, 5. Sütundaki veriyi yazdırmalıdır.
    //* //tbody[3]//td[5]

    public void printData(int row ,int column){
        //*a. Satır(row) ve sütun(column) numarasını girdiğinizde,
        //*  printData metodu bu hücredeki(cell) veriyi yazdırmalıdır.
       //* //body//tr[6]//td[4]
        String path=" //body//tr["+row+"]//td["+column+"]";
        WebElement data=driver.findElement(By.xpath(path));
        System.out.println("data.getText() = " + data.getText());


    }
    @Test
    public void printDataTest() throws InterruptedException {
        driver.get("https://editor.datatables.net/");
        Thread.sleep(4000);
        printData(2,3);//* Chief Executive Officer (CEO)
        printData(9,4);//*  New York
        printData(6,2);// *  Brielle Williamson
    }


}
