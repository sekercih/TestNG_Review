package test.day14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Scanner;

public class C02_BasicAuthentication {
    //todo
    // 1-
    // 2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
    // 3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
    //    Html komutu : https://username:password@URL
    //    Username     : admin
    //    password      : admin
    // 4- Basarili sekilde sayfaya girildigini dogrulayin
    WebDriver driver;

    @BeforeClass
    @Test
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       // driver.get("https://the-internet.herokuapp.com/basic_auth");
    }
    @Test
    public void basicAuthentication(){
        //todo Html komutu : https://username:password@URL
        //    //    Username     : admin
        //    //    password      : admin
        //    // 4- Basarili sekilde sayfaya girildigini dogrulayin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        WebElement basarili=driver.findElement(By.tagName("p"));
        Assert.assertTrue(basarili.isDisplayed());


    }
}
