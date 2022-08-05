package test.day19;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_Screenshot extends TestBase {
    //todo
    // amazon anasayfaya gidin
    // amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
    // Iphone icin arama yapin
    // sonucun Iphone icerdigini test edin ve ilk urunun goruntusunu alin

    @Test
    public void testScreen() throws IOException {
        //*// amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //*// amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
        //! 1. Adım önce bir obje oluşturmalıyız
        TakesScreenshot screen= (TakesScreenshot) driver;
        //! 2. adım kaydedeceğimiz dosyayı oluşturalım
        File dosya=new File("TScreen/tumsayfa1.png");
        //! 3. adım geçici dosya oluşturup screenshot ile screen alalım
        File geciciDosya=screen.getScreenshotAs(OutputType.FILE);
        //! 4. adım gecicideki dosyayı asıl yerine alacağız.
        FileUtils.copyFile(geciciDosya,dosya);

        //*/ Iphone icin arama yapin
        WebElement arama=driver.findElement(By.id("twotabsearchtextbox"));
        arama.sendKeys("Iphone"+ Keys.ENTER);

        WebElement sonucScreen=driver.findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]"));
        String resultText=sonucScreen.getText();
        System.out.println("resultText = " + resultText);
        Assert.assertTrue(resultText.contains("Iphone"));

        File webelemnts=new File("TScreen1/webelement1.jpeg");
        File geciciScreen=sonucScreen.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciScreen,webelemnts);


}}
