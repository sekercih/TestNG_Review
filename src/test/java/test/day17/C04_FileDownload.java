package test.day17;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {
    //todo
    // 1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
    // 2. Iki tane metod oluşturun : isExist( ) ve downloadTest( )
    // 3. downloadTest ( ) metodunun icinde aşağıdaki testi yapalim:
    // - https://the-internet.herokuapp.com/download adresine gidelim.
    // - test.txt dosyasını indirelim
    // 4. Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim

    @Test
    public void isExist() {
        String dosyaTxt = System.getProperty("user.home") + "\\Downloads\\test (1).txt";
        System.out.println("dosyaTxt = " + dosyaTxt);
        Assert.assertTrue(Files.exists(Paths.get(dosyaTxt)));

    }

    @Test
    public void downloadTest() {

        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//a[text()=\"test.txt\"]")).click();

    }
}
