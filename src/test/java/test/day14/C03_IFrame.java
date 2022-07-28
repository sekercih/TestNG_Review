package test.day14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C03_IFrame {
//todo
   /*
    https://the-internet.herokuapp.com/iframe adresine gidin.
    Bir metod olusturun: iframeTest
	“An IFrame containing….” textinin erisilebilir oldugunu test edin ve	konsolda  yazdirin.
    Text Box’a “Merhaba Dunya!” yazin.
            TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur  oldugunu dogrulayin ve
    konsolda yazdirin */
WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/iframe");

    }
    @Test
    public void iframeTest(){
       WebElement iFrame=driver.findElement(By.tagName("h3"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(iFrame.isEnabled(),"İframe yazısı görünmüyor");
        System.out.println("iFrame = " + iFrame.getText());

        //*Text Box’a “Merhaba Dunya!” yazin.
WebElement iframe=driver.findElement(By.id("mce_0_ifr"));
driver.switchTo().frame(iframe);

WebElement here=driver.findElement(By.tagName("p"));
here.clear();
here.sendKeys("Guidersoftun çalışkan öğrencileri..");
driver.switchTo().parentFrame();
//driver.switchTo().defaultContent();

        softAssert.assertAll();

//*   TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur  oldugunu dogrulayin ve konsolda yazdirin */
WebElement elementSelenium=driver.findElement(By.xpath("(//a)[3]"));
softAssert.assertTrue(elementSelenium.isDisplayed(),"Elemental Selenium yok");
        System.out.println(driver.findElement(By.xpath("//*[text()=\"Elemental Selenium\"]")).getText());
    }

}

