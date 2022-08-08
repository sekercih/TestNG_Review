package test.day20;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;
public class C01_JsExecuterClick01 extends TestBase {
//! burdan inceleyelim https://www.softwaretestingmaterial.com/javascriptexecutor-selenium-webdriver/
//amazon anasayfaya gidip
//sell linkine JSExecuter ile tiklayin
//ilgil sayfaya gittigimizi test edelim

    @Test
    public void  test01() throws InterruptedException {
        driver.get("https://www.amazon.com");

        //1.adim JsExecutor objesi olusturalim ve driver' cast edelim
        JavascriptExecutor jse=(JavascriptExecutor) driver;

        //2.adim locate

        WebElement sellelement= driver.findElement(By.xpath("//a[normalize-space()='Sell'] "));

        //3.adim
        jse.executeScript("arguments[0].click;",sellelement);
        Thread.sleep(3000);

    }

}

