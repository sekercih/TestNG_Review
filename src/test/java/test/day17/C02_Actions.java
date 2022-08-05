package test.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;
public class C02_Actions extends TestBase {
    //todo
    // Yeni Class olusturun ActionsClassHomeWork
    //    //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
    //    //2- Hover over Me First" kutusunun ustune gelin
    //    //3- Link 1" e tiklayin
    //    //4- Popup mesajini yazdirin
    //    //5- Popup'i tamam diyerek kapatin
    //    //6- “Click and hold" kutusuna basili tutun
    //    //7-“Click and hold" kutusunda cikan yaziyi yazdirin
    //    //8- “Double click me" butonunu cift tiklayin

    @Test
    public void test01() throws InterruptedException {
        //*    //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //*2- Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        WebElement hover=driver.findElement(By.xpath("//button[@class=\"dropbtn\"]"));
        actions.click(hover).perform();
        Thread.sleep(4000);

        //*3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[text()=\"Link 1\"])[1]")).click();
        //*4- Popup mesajini yazdirin
        String popMetin=driver.switchTo().alert().getText();
        System.out.println("poupMetin = " + popMetin);
        //*5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        Thread.sleep(4000);

        //*6- “Click and hold" kutusuna basili tutun
        WebElement hold=driver.findElement(By.id("click-box"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(4000);
        actions.clickAndHold(hold).perform();
        Thread.sleep(4000);

        //*7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println("hold.getText() = " + hold.getText());
        actions.release().perform();
        Thread.sleep(4000);

        //*8- “Double click me" butonunu cift tiklayin
        WebElement doubleClick=driver.findElement(By.tagName("h2"));
        actions.doubleClick(doubleClick).perform();
        Thread.sleep(4000);

    }}
