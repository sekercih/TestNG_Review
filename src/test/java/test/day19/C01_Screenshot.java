package test.day19;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C01_Screenshot extends TestBase {
//todo
// amazon anasayfaya gidin
// amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
// Nutella icin arama yapin
// sonucun Nutella icerdigini test edin ve ilk urunun goruntusunu alin
    @Test
    public void testScreen() throws IOException {
        //*// amazon anasayfaya gidin
        driver.get("https://www.n11.com");
       //*// amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
        //! 1. Adım önce bir obje oluşturmalıyız
        TakesScreenshot screen= (TakesScreenshot) driver;
        //! 2. adım kaydedeceğimiz dosyayı oluşturalım
        File dosya=new File("TScreen/tumsayfa1.png");
        //! 3. adım geçici dosya oluşturup screenshot ile screen alalım
        File geciciDosya=screen.getScreenshotAs(OutputType.FILE);
        //! 4. adım gecicideki dosyayı asıl yerine alacağız.
        FileUtils.copyFile(geciciDosya,dosya);


        //*Nutella icin arama yapin
     //   WebElement arama=driver.findElement(By.id("twotabsearchtextbox"));
       // arama.sendKeys("Iphone"+ Keys.ENTER);

    }
}
