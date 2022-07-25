package test.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C03_Priority01 {
    //todo
    // 3 test methodu olusturun
    // 1. amazon ana sayfasina
    // 2. https://github.com/ ana sayfaya
    // 3. facebook ana sayfaya gitsin
    // ve sayfa title'larini yazdirsin


    // priority yazmadigimiz method'larin priority=0 kabul eder
    // priority olmayanlari kendi icinde siralayip olanlarin priority degerlerine uygun siralamada calistirir
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test(priority = 10)
    public void amazonTest(){
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
    }
    @Test (priority = -1)
    public void githubTest(){
        driver.get("https://github.com/");
        System.out.println(driver.getTitle());
    }

    @Test
    public void facebookTest(){
        driver.get("https://www.facebook.com");
        System.out.println(driver.getTitle());
    }

    @Test()
    public void yahooTest(){
        driver.get("https://www.yahoo.com");
        System.out.println(driver.getTitle());
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
