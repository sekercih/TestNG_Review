package test.day13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class C02_SoftAssertion {
    //todo
    // Yeni bir Class Olusturun : C03_SoftAssert
    // 1. “http://zero.webappsecurity.com/ Adresine gidin
    // 2. Sign in butonuna basin
    // 3. Login kutusuna “username” yazin
    // 4. Password kutusuna “password” yazin
    // 5. Sign in tusuna basin
    // 6. Only Banking Pay Bills sayfasina gidin
    // 7. “Purchase Foreign Currency” tusuna basin
    // 8. “Currency” drop down menusunden Eurozone’u secin
    // 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
    // //! 10. soft assert kullanarak DropDown listesinde "Switzerland (franc)" oldugunu test edin .
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void test(){

        //? 1. “http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        //? 2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();
        //? 3. Login kutusuna “username” yazin
        driver.findElement(By.id("user_login")).sendKeys("username");
        // ?4. Password kutusuna “password” yazin
        driver.findElement(By.id("user_password")).sendKeys("password");
        // ?5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
        //*SAyfanın sertifası dolduğundan navigate().back(); kullanıyoruz.
        driver.navigate().back();
        // ?6. Only Banking ,Pay Bills sayfasina gidin
        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.xpath("//span[text()=\"Pay Bills\"]")).click();
        // ?7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//a[text()=\"Purchase Foreign Currency\"]")).click();
        // ?8. “Currency” drop down menusunden Eurozone’u secin
        WebElement drd=driver.findElement(By.id("pc_currency"));
        Select select=new Select(drd);
        select.selectByVisibleText("Eurozone (euro)");

       //? 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        String expectedEuro="Eurozone (euro)";
        String actualEuro=select.getFirstSelectedOption().getText();
        System.out.println("actualEuro = " + actualEuro);
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualEuro,expectedEuro,"Euro seçilemedi,eşleşmedi.");

        // ?//! 10. soft assert kullanarak DropDown listesinde "Switzerland (franc)" oldugunu test edin .
    /*
select.selectByValue("CHF");
String actualswitzerland=select.getFirstSelectedOption().getText();
String expectedSwitzerland="Switzerland";
softAssert.assertEquals(actualswitzerland,expectedSwitzerland,"Switzerland böyle bir para birimi yoktur.");*/
        String  actualSwitzerland="";
        String  expectedSwitzerland="Switzerland";
        String  expectedSwitzerland2="Switzerland";

        List <WebElement> drdList=select.getOptions();


        for (WebElement each:drdList) {
            actualSwitzerland+=each.getText()+",";
        }
        System.out.println("actualSwitzerland = " + actualSwitzerland);
//! actualSwitzerland = Select One,Australia (dollar),Canada (dollar),Switzerland (franc),China (yuan),Denmark (krone),Eurozone (euro),Great Britain (pound),Hong Kong (dollar),Japan (yen),Mexico (peso),Norway (krone),New Zealand (dollar),Sweden (krona),Singapore (dollar),Thailand (baht),
        softAssert.assertTrue(actualSwitzerland.contains(expectedSwitzerland),"Switzerland para birimini bulamadım.");
        softAssert.assertFalse(actualSwitzerland.contains(expectedSwitzerland2),"\"Switzerland para birimini var\"");



        softAssert.assertAll();
    }

}
