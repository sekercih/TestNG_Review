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
import java.util.Locale;

public class C02_Faker extends TestBase {
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
    public void facebookCreate(){
        //*   //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");
        //“create new account”  butonuna basin
        driver.findElement(By.xpath("//a[text()=\"Create New Account\"]")).click();
        //*  //“firstName” giris kutusuna bir isim yazin
        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        WebElement day=driver.findElement(By.id("day"));
        Select dayselect=new Select(day);
        WebElement month=driver.findElement(By.id("month"));
        Select monthselect=new Select(month);
        WebElement year=driver.findElement(By.id("year"));
        Select yearSelect=new Select(year);
        String email=faker.internet().emailAddress();
        WebElement isim=driver.findElement(By.name("firstname"));
        actions.click(isim).sendKeys(faker.name().firstName()).
        //*“surname” giris kutusuna bir soyisim yazin
        sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).
        //*  //“email” giris kutusuna bir email yazin
        sendKeys(Keys.TAB).sendKeys(email).
        //*“email” onay kutusuna emaili tekrar yazin
        sendKeys(Keys.TAB).sendKeys(email)
        //*Bir sifre girin
                .sendKeys(Keys.TAB).sendKeys(faker.internet().password()).perform();
                //! 10.10.2000
        //*Tarih icin gun secin
        dayselect.selectByIndex(9);
        // *Tarih icin ay secin
        monthselect.selectByIndex(9);
        // *Tarih icin yil secin
        yearSelect.selectByValue("2000");
        //*//Cinsiyeti secin
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.RIGHT).perform();

        WebElement erkek=driver.findElement(By.xpath("//label[text()=\"Male\"]"));
        Assert.assertTrue(erkek.isEnabled(),"Male secili değil.");

        WebElement diger=driver.findElement(By.xpath("//label[text()=\"Custom\"]"));
        Assert.assertFalse(diger.isSelected(),"Custom secili");

    }
    @Test
    public void faker(){
        Faker faker=new Faker(new Locale("tr") );
        //!Faker faker=new Faker(new Locale("tr","TR")); seçilirse türkçe fake öneriler var.
        String isim=faker.name().firstName();
        String soyisim=faker.name().lastName();
        System.out.println("isim = " + isim);
        System.out.println("soyisim = " + soyisim);

        String str=faker.internet().avatar();
        System.out.println("str = " + str);

        str=faker.name().username().toLowerCase(Locale.ROOT);

        System.out.println("str = " + str);

       int int1=faker.number().randomDigit();
        System.out.println("int1 = " + int1);

        str=faker.phoneNumber().cellPhone();
        System.out.println("str = " + str);

        str=faker.address().fullAddress();

        System.out.println("str = " + str);


    }
}
