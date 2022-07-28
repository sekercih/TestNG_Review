package test.day14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C02_Alerts {

    //todo
    // ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    // ● Bir metod olusturun: acceptAlert
    //        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının       “You successfully clicked an alert” oldugunu test edin.
    // ● Bir metod olusturun: dismissAlert
    //        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının       “successfuly” icermedigini test edin.
    // ● Bir metod olusturun: sendKeysAlert
    //        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna     tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
    WebDriver driver;
    SoftAssert softAssert;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        softAssert = new SoftAssert();


    }

    @Test
    public void acceptAlert() throws InterruptedException {
        //* ● Bir metod olusturun: acceptAlert
        //* 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        driver.findElement(By.xpath("//button[@onclick=\"jsAlert()\"]")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        //* “You successfully clicked an alert” oldugunu test edin.
        String successfully = driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
        String expectedsucces = "You successfully clicked an alert";
        softAssert.assertEquals(successfully, expectedsucces, "Cliced an alert yok.");


    }

    @Test
    public void dismissAlert() throws InterruptedException {
        //* Bir metod olusturun: dismissAlert
        //*2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        driver.findElement(By.xpath("//*[@onclick=\"jsConfirm()\"]")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
        //* “successfuly” icermedigini test edin.
        String successfully = driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
        String expectedSucces = "successfuly";
        softAssert.assertFalse(successfully.contains(expectedSucces), "successfuly içeriyor");


    }

    @Test
    public void sendKeysAlert() throws InterruptedException {

        // * ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        driver.findElement(By.xpath("//*[@onclick=\"jsPrompt()\"]")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().sendKeys("Merhaba Gencler");
        driver.switchTo().alert().accept();
        // *tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        String actualResult = driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
        String expectedResult = "You entered: Merhaba Gencler";
        softAssert.assertEquals(actualResult, expectedResult, "You entered: Merhaba Gencler: yazısı çıkmadı");

        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}


