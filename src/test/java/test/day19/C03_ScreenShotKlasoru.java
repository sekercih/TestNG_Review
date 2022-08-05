package test.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.IOException;

public class C03_ScreenShotKlasoru extends TestBase {
    //todo//amazona gidin
    //  //3 farkli test methodu ile java, honey ve elma aratip
    //    //sonuc sayfasini screenshot'i kaydedin
WebElement aramakutusu;
    @Test
    public void javaTest() throws IOException {

        aramakutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu.clear();
        aramakutusu.sendKeys("Java"+ Keys.ENTER);
        screenShot();

    }
    @Test
    public void honeyTest() throws IOException {
        aramakutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu.clear();
        aramakutusu.sendKeys("Honey"+ Keys.ENTER);
        screenShot();
    }
    @Test
    public void elmaTest() throws IOException {
        driver.get("https://www.amazon.com");
        aramakutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu.clear();
        aramakutusu.sendKeys("Elma"+ Keys.ENTER);
        screenShot();
    }
}

