package test.day12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_DependsOnMethods {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    //todo
    //	2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin
    //	arama yapin ve aramanizin gerceklestigini Test edin
    // //	3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin $14.99 oldugunu test edin
@Test
    public void logoTest(){
        driver.get("https://www.amazon.com");
    WebElement logoelement=driver.findElement(By.id("nav-logo"));
    Assert.assertTrue(logoelement.isDisplayed());
    }
   // 1.Test basarili ise search Box’i kullanarak “Nutella” icin
    @Test(dependsOnMethods ="logoTest" )
    public void aramaTesti(){
        WebElement aramaBar=driver.findElement(By.id("twotabsearchtextbox"));
        aramaBar.sendKeys("Nutella"+ Keys.ENTER);
        String actualTitle= driver.getTitle();
        String arananKelime="Nutella";

        Assert.assertTrue(actualTitle.contains(arananKelime),"Nutella bulunamadı");

    }
//!    3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin $14.99 oldugunu test edin
@Test(dependsOnMethods = "aramaTesti")
    public void fiyatTesti(){
        driver.findElement(By.xpath("(//h2[@class=\"a-size-mini a-spacing-none a-color-base s-line-clamp-3\"])[5]")).click();
        WebElement fiyat=driver.findElement(By.xpath("//span[@class=\"a-size-base a-color-price\"]"));
        String fiyatBilgisi=fiyat.getText();
        String arananfiyat="$14.99";

        Assert.assertTrue(fiyatBilgisi.contains(arananfiyat),"fiyat değişmiş");
    }
}
