package test.day20;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class C02_JsExecutorScrollViewIn extends TestBase {
    //! https://www.softwaretestingmaterial.com/javascriptexecutor-selenium-webdriver/ jsExecuter komutları ilgili örnek sayfası.

    //todo
    // 1- Yeni bir class olusturun : ScroolInto
    // 2- /movita.com gidin
    // 3- 2 farkli test method’u olusturarak actions clasi ve Js Executor kullanarak asagidaki
    // 4- istediginiz çözüm sayfasi acildigini test edin

    @Test
    public void actionsclass() throws InterruptedException {
        driver.get("https://www.movita.com.tr/");
        WebElement cozum=driver.findElement(By.xpath("//strong[text()=\"tıklayınız\"]"));
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)

                .sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(10000);
        cozum.click();


    }
    @Test
    public void  jsExecutor() throws InterruptedException {
        driver.get("https://www.movita.com.tr/");

        //* 1 adım
        JavascriptExecutor executor= (JavascriptExecutor) driver;

        //*  2.adım
        WebElement cozum=driver.findElement(By.xpath("//strong[text()=\"tıklayınız\"]"));

        //* 3. adım da
        executor.executeScript("arguments[0].scrollIntoView(true)",cozum);
        Thread.sleep(3000);

        executor.executeScript("arguments[0].click()",cozum);


        //*// 4- istediginiz çözüm sayfasi acildigini test edin
        List <WebElement> cozumText=driver.findElements(By.tagName("h3"));
        System.out.println("cozumText.size() = " + cozumText.size());

        for (WebElement each:cozumText) {
            System.out.println("each.getText() = " + each.getText());
        }
        Assert.assertTrue(cozumText.size()==4);

    }
}
