package test.day20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_Webtables01 extends TestBase {

    public void printData(int row, int column) throws InterruptedException {
//todo
// 1. Bir metod oluşturun: printData(int row, int column);
// a. Satır(row) ve sütun(column) numarasını girdiğinizde,
// printData metodu bu hücredeki(cell) veriyi yazdırmalıdır.
// 2. Baska bir metod daha oluşturun: printDataTest();
// a. Ve bu metodu printData() methodunu cagirmak icin kullanin.
// b. Örnek: printData (3.5); =>
// 3. satır, 5. Sütundaki veriyi yazdırmalıdır.
        //* //tbody[3]//td[5]
        String xpath = "//tbody//tr[" + row + "]//td[" + column + "]";

        WebElement data = driver.findElement(By.xpath(xpath));
        System.out.println("printData = " + data.getText());


    }

    @Test
    public void printDataTest() throws InterruptedException {
        driver.get("https://editor.datatables.net/");
        Thread.sleep(5200);
        printData(2, 3);//Chief Executive Officer (CEO)
        printData(6, 2);//Brielle Williamson
        printData(5, 4);//San Francisco


    }
}
