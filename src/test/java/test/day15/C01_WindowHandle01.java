package test.day15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class C01_WindowHandle01 {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void handleWindow() throws InterruptedException {
        driver.get("https://www.amazon.com");
        String windowHandleAmazon = driver.getWindowHandle();
        System.out.println("Ilk sayfanın wndowHandle değeri : " + windowHandleAmazon);

        driver.switchTo().newWindow(WindowType.WINDOW);//yeni bir pencere açılır
        driver.get("https://www.bestbuy.com");
        String windowHandleBestBuy = driver.getWindowHandle();
        System.out.println("İkinci sayfanın windowHandle değeri : " + windowHandleBestBuy);
        Set<String> getWindowHandlesSet = driver.getWindowHandles();
        System.out.println(getWindowHandlesSet);
        Thread.sleep(3000);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.facebook.com");
        //amazonun açık olduğu sayfaya geçin ve nutella için arama yapın
        driver.switchTo().window(windowHandleAmazon);
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        //bestbuy acık olan sayfaya geçin title ın bestbuy içerdiğini test edin
        driver.switchTo().window(windowHandleBestBuy);
        Assert.assertTrue(driver.getTitle().contains("Best Buy"), "Aradığınız kelime bulunamadı!!!");
        //facebook açık olduğu pencerede url https://www.facebook.com olduğunu test edin
        getWindowHandlesSet = driver.getWindowHandles();
        //todo
        // bu saru icin su anda set'te 3 window handle degeri var
        // 1. ve 2/ sayfanin window handle degerlerini biliyoruz
        // setimizde olup, ilk iki sayfa olmayan handle degeri 3.sayfamin handle degeri olacaktir
        System.out.println(getWindowHandlesSet);
        String windowHandleFacebook = "";
        for (String each : getWindowHandlesSet
        ) {
            if (!(each.equals(windowHandleAmazon) || each.equals(windowHandleBestBuy)))
                windowHandleFacebook = each;
        }
        System.out.println(getWindowHandlesSet);
        System.out.println(windowHandleFacebook);

        driver.switchTo().window(windowHandleFacebook);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");


        Thread.sleep(3000);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        //driver.quit();
    }
}