package test.day12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class C03_SoftAssertion01 {
    // Yeni bir Class Olusturun : C03_SoftAssert
    // 1. “http://zero.webappsecurity.com/” Adresine gidin
    // 2. Sign in butonuna basin
    // 3. Login kutusuna “username” yazin
    // 4. Password kutusuna “password” yazin
    // 5. Sign in tusuna basin
    // 6. Only Banking Pay Bills sayfasina gidin
    // 7. “Purchase Foreign Currency” tusuna basin
    // 8. “Currency” drop down menusunden Eurozone’u secin
    // 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
    // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void test01(){
        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        // 2. Sign in butonuna basin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        // 3. Login kutusuna “username” yazin
        WebElement loginKutusu=driver.findElement(By.xpath("//input[@id='user_login']"));
        loginKutusu.sendKeys("username");
        // 4. Password kutusuna “password” yazin
        WebElement passwordKutusu=driver.findElement(By.xpath("//input[@id='user_password']"));
        passwordKutusu.sendKeys("password");
        // 5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
        // 6. Online banking menusu altinda Pay Bills sayfasina gidin
        driver.navigate().back(); // guvenli degil uyarisini geciyor
        driver.findElement(By.xpath("//strong[text( )='Online Banking']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
        // 7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();
        // 8. “Currency” drop down menusunden Eurozone’u secin
        WebElement dropdown=driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select=new Select(dropdown);
        select.selectByValue("EUR");
        // 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert = new SoftAssert();
        String actualSecim=select.getFirstSelectedOption().getText();
        String expectedSecim="Eurozone (euro)";

        softAssert.assertEquals(actualSecim,expectedSecim,"Dropdown dogru secilemedi");
        System.out.println("Hard assertion'da ilk assertion failed olsaydi, bu satir calismazdi");
        //! 10. soft assert kullanarak DropDown listesinde "Switzerland (franc)" oldugunu test edin .



        List<WebElement> optionList= select.getOptions();
/*
        String actualOptionListesiStringOlarak="";
        for (WebElement each: optionList
        ) {
            actualOptionListesiStringOlarak += "\""  +   each.getText()  +   "\", ";
        }

        actualOptionListesiStringOlarak=actualOptionListesiStringOlarak.substring(0,actualOptionListesiStringOlarak.length()-2);
        String expectedListeStringOlarak="\"Select One\", \"Australia (dollar)\", \"Canada (dollar)\", \"Switzerland (franc)\", \"China (yuan)\", \"Denmark (krone)\", \"Eurozone (euro)\", \"Great Britain (pound)\", \"Hong Kong (dollar)\", \"Japan (yen)\", \"Mexico (peso)\", \"Norway (krone)\", \"New Zealand (dollar)\", \"Sweden (krona)\", \"Singapore (dollar)\", \"Thailand (baht)\"";
        softAssert.assertEquals(actualOptionListesiStringOlarak,expectedListeStringOlarak); */
        String para="Switzerland (franc)";
        String yeniPara= "";
        for (WebElement each:optionList) {
            yeniPara+=each.getText()+",";
            System.out.println("Yeni Para Birimleri= " +yeniPara);

           }
        softAssert.assertTrue(yeniPara.contains(para),"Para bulunamadı");

        softAssert.assertAll();

        System.out.println("\n"+"testlerden failed olan varsa softAssert.assertAll'dan sonrasi calismaz");
    }

    @AfterMethod
    public void teardown(){
        driver.close();
    }
}