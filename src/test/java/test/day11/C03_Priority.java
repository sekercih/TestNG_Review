package test.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C03_Priority {
    //todo
    // 3 test methodu olusturun
    // 1. amazon ana sayfasina
    // 2. https://github.com/ ana sayfaya
    // 3. facebook ana sayfaya gitsin
    // ve sayfa title'larini yazdirsin

    WebDriver driver;
@BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    //! 1. amazon ana sayfasina
    @Test(priority =4 )
    public void amazonTest(){
        driver.get("https://www.amazon.com");
        System.out.println("driver.getTitle() = " + driver.getTitle());
    }
    //! 2. https://github.com/ ana sayfaya
    @Test(priority = 3)
    public void githubTest(){
        driver.get("https://github.com/");
        System.out.println("driver.getTitle() = " + driver.getTitle());

    }

    //! 3. facebook ana sayfaya gitsin
    @Test(priority = 2)
    public void facebookTest(){
        driver.get("https://www.facebook.com");
        System.out.println("driver.getTitle() = " + driver.getTitle());
    }
    //! 4. yahoo ana sayfaya gitsin
    @Test(priority = 1)
    public void yahooTest(){
        driver.get("https://www.yahoo.com");
        System.out.println("driver.getTitle() = " + driver.getTitle());
    }

@AfterMethod
    public void tearDown(){
    driver.close();
}

}




