package test.day19;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_ScreenshotWebelement extends TestBase {
    @Test
    public void amazonss() throws IOException {
        // amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");
        // nutella icin arama yapalim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        // sonuclarin nutella icerdigini test edelim
        WebElement sonucYazisiElementi = driver.findElement(By.xpath("//div[@class='sg-col-inner']"));
        String sonucSayisiStr = sonucYazisiElementi.getText();
        Assert.assertTrue(sonucSayisiStr.contains("Nutella"));
        // testin calistiginin ispati icin sonuc yazisi Ebelementinin screenshot'ini alalim
        // tum sayfa screenshot icin 4 adim gerekli,webElement icin 3 adim yeterli,Takescreenshot gerek yok
        File webelementSS = new File("Tscreenschot/webelement"); //sonuna .jpn falan yapmadik webelemet alt olarak kayit edilsin istedik
        File geciciSS = sonucYazisiElementi.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciSS, webelementSS);
    }
}
