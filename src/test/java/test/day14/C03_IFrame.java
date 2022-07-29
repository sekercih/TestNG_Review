package test.day14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C03_IFrame {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        /*  https://the-internet.herokuapp.com/iframe adresine gidin.
    Bir metod olusturun: iframeTest
    “An IFrame containing….” textinin erisilebilir oldugunu test edin ve    konsolda  yazdirin.
    Text Box’a “Merhaba Dunya!” yazin.
            TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur  oldugunu dogrulayin ve
    konsolda yazdirin */
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      //  driver.get("https://the-internet.herokuapp.com/iframe");

    }
    @Test
    public void iframeTest(){
        WebElement contain=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(contain.isEnabled());
        System.out.println(contain.getText());

        WebElement iframe=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);

        WebElement textBox=driver.findElement(By.tagName("p"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dünya");
        driver.switchTo().defaultContent();

        WebElement element=driver.findElement(By.xpath("//a[text()=\"Elemental Selenium\"]"));
        Assert.assertTrue(element.isDisplayed());
        System.out.println("element.getText() = " + element.getText());

        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());


    }



    @AfterMethod
    public void tearDown(){
        //driver.close();
    }

}
