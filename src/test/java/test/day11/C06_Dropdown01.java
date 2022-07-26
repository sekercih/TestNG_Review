package test.day11;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C06_Dropdown01 {

    WebDriver driver;
    WebElement dropdownElementi;
    Select select;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    //todo
    // test01
    // https://www.amazon.com/ adresine gidin.
    //	Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
    // Test 2
    // 1. Kategori menusunden Books secenegini  secin
    //	2. Arama kutusuna Java yazin ve aratin
    //	3. Bulunan sonuc sayisini yazdirin
    //	4. Sonucun Java kelimesini icerdigini test edin





@Test
    public void test1(){
        //● https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");
        //- Test 1
        //	Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        dropdownElementi=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select=new Select(dropdownElementi);

        List<WebElement> optionListesi=select.getOptions();

        int actualOptionSayisi=optionListesi.size();
        int expectedOptionSayisi=30;

    System.out.println("actualOptionSayisi = " + actualOptionSayisi);

    Assert.assertEquals(actualOptionSayisi,expectedOptionSayisi);

    }

    @Test
    public void test2(){
        //-Test 2
        //	1. Kategori menusunden Books secenegini  secin

        select.selectByVisibleText("Books");
        //	2. Arama kutusuna Java yazin ve aratin
        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        aramaKutusu.sendKeys("Java" + Keys.ENTER);
        //	3. Bulunan sonuc sayisini yazdirin

        WebElement sonucSayisiElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        //	4. Sonucun Java kelimesini icerdigini test edin

        String actualSonucSayisiYazisi=sonucSayisiElementi.getText();
        System.out.println("actualSonucSayisiYazisi = " + actualSonucSayisiYazisi);
        String arananKelime="Java";

        Assert.assertTrue(actualSonucSayisiYazisi.contains(arananKelime),"Arama sonucu Java icermiyor");

    }

    @AfterClass
    public  void  teardown(){
        //driver.close();
    }

}
