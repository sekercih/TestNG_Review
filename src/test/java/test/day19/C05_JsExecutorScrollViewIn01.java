package test.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;
public class C05_JsExecutorScrollViewIn01 extends TestBase {
    //1- Yeni bir class olusturun : ScroolInto
    //2- hotelmycamp anasayfasina gidin
    //3- 2 farkli test method’u olusturarak actions clasi ve Js Executor kullanarak asagidaki oda turlerinden ust sira ortadaki odayi tiklayin
    //4- istediginiz oda inceleme sayfasi acildigini test edin

    @Test
    public void  scroolAction() throws InterruptedException {

        driver.get("https://www.hotelmycamp.com");
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)


                .perform();
        driver.findElement(By.xpath("/html/body/section[5]/div/div[2]/div[2]/div/div/p[2]/a")).click();
        Thread.sleep(3000);
    }

    @Test
    public  void  scroolJsExecutor() throws InterruptedException {

        driver.get("https://www.hotelmycamp.com");
        //driver.navigate().refresh();  //sayfa yeniler yukari cikar

        // 1.adim JsExecutor objesi olustur ve driver'i cast et
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        // 2.adim calisacagimiz web elementi locate edelim
        WebElement odaInceleLinki= driver.findElement(By.xpath("/html/body/section[5]/div/div[2]/div[2]/div/div/p[2]/a "));
        // 3.adim ilgili script ve argument ile jse.executeScript() calistir
        jse.executeScript("arguments[0].scrollIntoView(true);",odaInceleLinki);
        Thread.sleep(3000);
        jse.executeScript("arguments[0].click();",odaInceleLinki);

        Thread.sleep(3000);
        driver.close();

    }



}

