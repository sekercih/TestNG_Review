package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class  TestBase01 {

    protected WebDriver driver;
    @BeforeClass
    public void setup(){
        // abstract yaparak bu class'dan obje olusturulmasinin onune geceriz

        // biz test base class'i sadece extends ile inherit ederek kullanacagiz
        // dolayisiyla olusturdugumuz driver variable'i icin protected access modifier'i seciyoruz



            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }


    @AfterClass
    public void tearDown(){
        //driver.quit();
    }
}
