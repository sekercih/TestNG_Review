package test.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C06_DropDown {
    WebDriver driver;
    Select select;
    WebElement katogori;
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //todo
        // test01
        // https://www.amazon.com/ adresine gidin.
        //	Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        // Test 02
        // 1. Kategori menusunden Books secenegini  secin
        //	2. Arama kutusuna Java yazin ve aratin
        //	3. Bulunan sonuc sayisini yazdirin
        //	4. Sonucun Java kelimesini icerdigini test edin
    }
    @Test
    public void test01(){
        //? test01
        //? https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com");
        //?	Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin

        katogori=driver.findElement(By.id("searchDropdownBox"));

        select=new Select(katogori);

        List <WebElement> katogorilist=select.getOptions();

        int actualkatagoriSayisi=katogorilist.size();
        int expectedKataori=28;
        System.out.println("actualkatagoriSayisi = " + actualkatagoriSayisi);

        Assert.assertEquals(actualkatagoriSayisi,expectedKataori,"Katogori sayısı eşit değil.");

        System.out.println("Hard Assert buraya kadar gelemez.");

    }
    // Test 02
    @Test
    public void test02()
    {


        select.selectByVisibleText("Books");
        //?	2. Arama kutusuna Java yazin ve aratin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);

        //	3. Bulunan sonuc sayisini yazdirin
        WebElement sonucsayisi=driver.findElement(By.xpath("(//div[@class=\"a-section a-spacing-small a-spacing-top-small\"])[1]"));
        String actualsonuc=sonucsayisi.getText();
        System.out.println("actualsonuc = " + actualsonuc);
String arananKelime="Java";

        //	4. Sonucun Java kelimesini icerdigini test edin

Assert.assertTrue(actualsonuc.contains(arananKelime),"Java bulunamadı");


    }

}


