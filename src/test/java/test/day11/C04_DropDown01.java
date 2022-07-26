package test.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C04_DropDown01 {


    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    //* Amazona gidilsin,3.elemnti seçip,yazdıralım ve adımları yazalım..

    @Test
    public void dropdownTesti() throws InterruptedException {
        // Dropdown'da var olan seceneklerden birini secmek icin
        // 1.adim : Dropdown webelemntini locate edip bir degiskene atiyoruz
        driver.get("https://www.amazon.com");
        WebElement dropdownElementi=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        // 2.adim : Select class'indan bir obje olusturalim
        // ve parametre olarak locate ettigimiz Webelementi yazalim
        Select select=new Select(dropdownElementi);

        // 3.adim select objesini kullanarak, Select class'inda var olan 3 secim method'undan
        //  istedigimizi kullanarak dropdown'da var olan option'lardan birini sacebiliriz
        //  secim yapmamiza yardim eden bu 3 method void'dir dolayisiyla bize bir sey dondurmezler
        select.selectByIndex(3);

        // eger sectigimiz option degerini yazdirmak istersek
        System.out.println(select.getFirstSelectedOption().getText()); //Baby
        Thread.sleep(3000);

        select.selectByVisibleText("Deals");
        Thread.sleep(3000);

        select.selectByValue("search-alias=arts-crafts-intl-ship");

        List<WebElement> optionList = select.getOptions();
        for (WebElement each: optionList
        ) {
            System.out.println(each.getText());
        }
    }

    @AfterMethod
    public void teardown(){
        driver.close();
    }

}
