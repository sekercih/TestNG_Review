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
import java.util.HashSet;
import java.util.Set;

public class C02_WindowHandle {

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
    public void windowHandle() throws InterruptedException {

       //* ● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String open=driver.getWindowHandle();
        System.out.println("open = " + open);
        //* ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String newWindow=driver.findElement(By.tagName("h3")).getText();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(newWindow,"Opening a new window","Opening a new window doğrulanmadı");

       //* ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String titleThe=driver.getTitle();
        softAssert.assertEquals(titleThe,"The Internet","The Internet yoktur");
Thread.sleep(5000);
        //* ● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        Set<String>handelslar=driver.getWindowHandles();
        String newTab="";
        for (String each:handelslar) {
            if (!each.equals(open)){
                newTab=each;
            }
            System.out.println("each = " + each);
        }
        driver.switchTo().window(newTab);

        System.out.println("driver.getWindowHandles().toString()"+driver.getWindowHandles().toString());
        String clicnewWindow=driver.getWindowHandle();
        System.out.println("clicnewWindow = " + clicnewWindow);



        // ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Thread.sleep(5000);

        driver.switchTo().window(clicnewWindow);
        String titleNew=driver.getTitle();
        softAssert.assertTrue(titleNew.contains("New Window"),"New Window yoktur.");
        // ● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String actualnewwindowText=driver.findElement(By.tagName("h3")).getText();
        String expectedNewWindoText="New Window";
       softAssert.assertEquals(actualnewwindowText,expectedNewWindoText,"New Window içermiyor.");

        // ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

        driver.switchTo().window(open);
softAssert.assertEquals(driver.getTitle(),"The Internet","The Internet title bulunamadı.");




softAssert.assertAll();
    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}
