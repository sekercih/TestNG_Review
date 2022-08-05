package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

public class TestBase {
    // abstract yaparak bu class'dan obje olusturulmasinin onune geceriz
    protected WebDriver driver;
    // biz test base class'i sadece extends ile inherit ederek kullanacagiz
    // dolayisiyla olusturdugumuz driver variable'i icin protected access modifier'i seciyoruz


    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public void tearDown() throws InterruptedException {

        driver.quit();
    }
public void screenShot() throws IOException {
     TakesScreenshot screen = (TakesScreenshot) driver;
    String day=new SimpleDateFormat("yyMMddhhmmss").format(new Date());
    File tumSayfa=new File("TScreenshot/tumsayfa"+day+".png");
    File geciciSayfa=screen.getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(geciciSayfa,tumSayfa);
}

}

