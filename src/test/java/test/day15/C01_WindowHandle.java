package test.day15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;
import utilities.TestBase;
public class C01_WindowHandle {
  //todo
// amazon.com a git
//    Sayfana handell değerini al
//    Yeni bir pencere aç
//    bestbuy.com git
//    yeni açılan pencerenin handel değerini al
//    sonra bütün handelların değerini al
//    şimdi yeni bir tab aç
//    facebook.com a git
//    amazon.com a geri dön
//    arama kısmına  Nutella yaz ve ara
//    sonra bestbuy.com geç, title  doğrula
//    Şimdi de facebook.com penceresine git
//    title  facebook.com olduğunu  doğrula
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void handleWindow() {
        //*    amazon.com a git
        driver.get("https://www.amazon.com");

// *Sayfana handell değerini al
        String amazonHandle = driver.getWindowHandle();
        System.out.println("amazonHandle = " + amazonHandle);
//* Yeni bir pencere aç
//* bestbuy.com git
        driver.switchTo().newWindow(WindowType.WINDOW); //yeni pencere açılır.
        driver.get("https://www.bestbuy.com");
//* yeni açılan pencerenin handel değerini al
        String bestHandle = driver.getWindowHandle();
        System.out.println("bestHandle = " + bestHandle);
//* sonra bütün handelların değerini al
        Set<String> handelslar = driver.getWindowHandles();
        System.out.println("handelslar.toString() = " + handelslar.toString());

 //*      şimdi yeni bir tab aç
        driver.switchTo().newWindow(WindowType.TAB); //yeni bir tab açar..
// *   facebook.com a git
        driver.get("https://www.facebook.com");
// *   amazon.com a geri dön
        driver.switchTo().window(amazonHandle);

        //* arama kısmına  Nutella yaz ve ara
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);

        // *   sonra bestbuy.com geç, Title  doğrula
        driver.switchTo().window(bestHandle);
        String bestTitle=driver.getTitle();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(bestTitle.contains("bestbuy.com"),"bestbuy.com içermiyor");
//   * Şimdi de facebook.com penceresine git
       Set <String> tumHandelslar=driver.getWindowHandles();
        System.out.println("tumHandelslar.toString() = " + tumHandelslar.toString());
String facebookHandle="";
        for (String each:tumHandelslar) {
            if (!each.equals(amazonHandle)||each.equals(bestHandle)){
                facebookHandle=each;
            }
        }
        System.out.println("facebookHandle = " + facebookHandle);


//   * title  facebook.com olduğunu  doğrula
        driver.switchTo().window(facebookHandle);
        String expectedUrl="https://www.facebook.com/";
        String actualUrl=driver.getCurrentUrl();

        softAssert.assertEquals(actualUrl,expectedUrl,"Site yoktur..");



        softAssert.assertAll();
    }
/*
    @Test
    public void setTest(){
        Set <String> liste=new HashSet<>();
        liste.add("Bilecik");
        liste.add("Ankara");
        liste.add("Zonguldak");

        System.out.println("liste.toString() = " + liste.toString()); //liste.toString() = [Ankara, Bilecik, Zonguldak]

}*/

@AfterClass
public void teardown(){
    driver.quit();


}}



