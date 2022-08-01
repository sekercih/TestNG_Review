package test.day14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C02_Alerts {

    //todo
    // ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    // ● Bir metod olusturun: acceptAlert
    //        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    //        “You successfully clicked an alert” oldugunu test edin.
    // ● Bir metod olusturun: dismissAlert
    //        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının       “successfuly” icermedigini test edin.
    // ● Bir metod olusturun: sendKeysAlert
    //        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    //        tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
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
    public void acceptAlert() {
        //*        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        // *       “You successfully clicked an alert” oldugunu test edin.

        driver.findElement(By.xpath("//*[@onclick=\"jsAlert()\"]")).click();
        driver.switchTo().alert().accept();
        String acceptAlert = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();
        String expectedcceptAlert = "You successfully clicked an alert";
        softAssert.assertTrue(acceptAlert.contains(expectedcceptAlert),"You successfully clicked an alert” içermiyor." );


    }

    @Test
    public void dismissAlert() {
        //  *      ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        // *       “successfuly” icermedigini test edin.

        driver.findElement(By.xpath("//*[@onclick=\"jsConfirm()\"]")).click();
        driver.switchTo().alert().dismiss();
        String dismissAlert = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();
        String expecteddismis = "successfuly";
      softAssert.assertFalse(dismissAlert.contains(expecteddismis),"successfuly içeriyor.");


    }

    @Test
    public void sendKeysAlert() {
        // *       ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //*        tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("//*[@onclick=\"jsPrompt()\"]")).click();
        driver.switchTo().alert().sendKeys("Hasan Özyer");
        driver.switchTo().alert().accept();
        String sendKeysAlert = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();
        String expecdetSend = "You entered: Hasan Özyer";

       softAssert.assertEquals(sendKeysAlert,expecdetSend,"İsim aynı değil.");

    }
@AfterMethod
    public void tearDown(){
        softAssert.assertAll();
        driver.close();
}

}

