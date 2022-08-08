package test.day20;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class C02_JsExecutorScrollViewIn01 extends TestBase {
    //1- Yeni bir class olusturun : ScroolInto
    //2- /movita.com gidin
    //3- 2 farkli test method’u olusturarak actions clasi ve Js Executor kullanarak asagidaki 
    //4- istediginiz çözüm sayfasi acildigini test edin

    @Test
    public void  scroolAction() throws InterruptedException {

        driver.get("https://movita.com.tr/");
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)


                .perform();
        driver.findElement(By.xpath("(//h2)[3]"));

        System.out.println("driver.findElement(By.xpath(\"(//h2)[3]\")) = " + driver.findElement(By.xpath("(//h2)[3]")).getText());

        Thread.sleep(3000);
    }

    @Test
    public  void  scroolJsExecutor() throws InterruptedException {

        driver.get("https://movita.com.tr/");
        //driver.navigate().refresh();  //sayfa yeniler yukari cikar

        // 1.adim JsExecutor objesi olustur ve driver'i cast et
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        // 2.adim calisacagimiz web elementi locate edelim
        WebElement cozumler= driver.findElement(By.xpath("(//div[@class=\"container clearfix\"])[5]"));
        // 3.adim ilgili script ve argument ile jse.executeScript() calistir
        jse.executeScript("arguments[0].scrollIntoView(true);",cozumler);
        Thread.sleep(3000);
        jse.executeScript("arguments[0].click();",cozumler);

        //* 4. adım cozumlerin ismlerini alalım.
        System.out.println("driver.findElement(By.id(\"portfolio\")).getText() =" +
                " " + driver.findElement(By.id("portfolio")).getText());

//        List<WebElement> cozumText= driver.findElements(By.id("portfolio"));
//        for (WebElement each:cozumText) {
//            System.out.println("each.getText() = " + each.getText());
//
//        }


        Thread.sleep(3000);

    }



}

