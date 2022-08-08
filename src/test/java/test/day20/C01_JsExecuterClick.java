package test.day20;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_JsExecuterClick extends TestBase {
    //todo
    // //amazon anasayfaya gidip
    // //sell linkine JSExecuter ile tiklayin
    // //ilgil sayfaya gittigimizi test edelim

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");

        //* 1 adım obje oluşturmak
        JavascriptExecutor jse= (JavascriptExecutor) driver;

        //* 2adım locate almak
        WebElement sell=driver.findElement(By.xpath("//a[text()=\"Sell\"]"));

        //* 3 adım
        jse.executeScript("arguments[0].click();",sell);


    }
}
