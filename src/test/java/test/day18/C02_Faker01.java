package test.day18;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;
public class C02_Faker01 extends TestBase {
    //todo
    //   //"https://facebook.com"  Adresine gidin
    //    //“create new account”  butonuna basin
    //    //“firstName” giris kutusuna bir isim yazin
    //    //“surname” giris kutusuna bir soyisim yazin
    //    //“email” giris kutusuna bir email yazin
    //    //“email” onay kutusuna emaili tekrar yazin
    //    //Bir sifre girin
    //    //Tarih icin gun secin
    //    //Tarih icin ay secin
    //    //Tarih icin yil secin
    //    //Cinsiyeti secin
    //    //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
    //    //Sayfayi kapatin

    @Test
    public void facebookKayitTest() throws InterruptedException {
        //"https://facebook.com"  Adresine gidin
        driver.get("https://www.facebook.com");
        driver.manage().deleteAllCookies();
        //“create new account”  butonuna basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //“firstName” giris kutusuna bir isim yazin
        WebElement isimKutusu=driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions=new Actions(driver);
        WebElement birtday=driver.findElement(By.id("day"));
        Select selectday=new Select(birtday);
        WebElement month=driver.findElement(By.id("month"));
        Select selectmonth=new Select(month);
        WebElement year=driver.findElement(By.id("year"));
        Select selectyear=new Select(year);

        Faker faker=new Faker();
        String email=faker.internet().emailAddress();
        actions.click(isimKutusu).sendKeys(faker.name().firstName()).
                //“surname” giris kutusuna bir soyisim yazin
                //WebElement soyisim=driver.findElement(By.xpath("//input[@name='lastname']"));
                        sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).
                //“email” giris kutusuna bir email yazin
                        sendKeys(Keys.TAB).sendKeys(email).
                //“email” onay kutusuna emaili tekrar yazin
                        sendKeys(Keys.TAB).sendKeys(email).
                //Bir sifre girin
                        sendKeys(Keys.TAB).sendKeys(faker.internet().password()).perform();
                //!Tarih icin gun secin 10/10/2010
                        selectday.selectByIndex(9);
        //Tarih icin ay secin
                        selectmonth.selectByIndex(9);
        //Tarih icin yil secin
                        selectyear.selectByIndex(12);

        //Cinsiyeti secin
               actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).


                       sendKeys(Keys.RIGHT).
                //sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).
                        perform();



        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        WebElement erkek=driver.findElement(By.xpath("//input[@value='2']"));
        WebElement kadın=driver.findElement(By.xpath("//input[@value='1']"));
        Assert.assertTrue(erkek.isSelected());
        Assert.assertFalse(kadın.isSelected());
        //Sayfayi kapatin
        Thread.sleep(5000);
    }




}
