package test.day15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Set;

public class C02_WindowHandle01 {
    //todo
    // ● https://the-internet.herokuapp.com/windows adresine gidin.
    // ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    // ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    // ● Click Here butonuna basın.
    // ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    // ● Sayfadaki textin “New Window” olduğunu doğrulayın.
    // ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void WindowHandle2() {
        driver.get("https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        SoftAssert softassert = new SoftAssert();
        String actualText = driver.findElement(By.tagName("h3")).getText();
        String expectedText = "Opening a new window";
        System.out.println(actualText);
        softassert.assertEquals(actualText, expectedText, "eşleşmedi");
        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        softassert.assertEquals(driver.getTitle(), "The Internet", "title eşleşmedi");
        //● Click Here butonuna basın.
        String windowsHandleDegeri1 = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        String windowsHandleDegeri2 = "";
        for (String each : windowHandles
        ) {
            if (!each.equals(windowsHandleDegeri1))
                windowsHandleDegeri2 = each;
        }
        System.out.println(windowHandles);
        System.out.println(windowsHandleDegeri2);
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        driver.switchTo().window(windowsHandleDegeri2);
        String actualText2 = driver.findElement(By.tagName("h3")).getText();
        String expectedText2 = "New Window";
        softassert.assertEquals(actualText2, expectedText2, "yeni sayfa texti new window değil");
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(windowsHandleDegeri1);
        softassert.assertEquals(driver.getTitle(), "The Internet", "Title The Internet değil");
        softassert.assertAll();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}