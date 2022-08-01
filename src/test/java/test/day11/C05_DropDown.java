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

public class C05_DropDown {
    //* Amazona gidilsin,4.elemnti seçip,yazdıralım ve adımları yazalım..
    WebDriver driver;

    @BeforeMethod
    public void stup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    //* Amazona gidilsin,3.elemnti seçip,yazdıralım ve adımları yazalım..
    @Test
    public void drobdownTest() throws InterruptedException {
        //*1. www.amazon.com sitesine gidelim
        driver.get("https://www.amazon.com");
        //*2.  Drobdown için lokate almak gerekir
        WebElement drd = driver.findElement(By.id("searchDropdownBox"));

        //* 3. adımda Select classından obje oluşturacağız.
        Select select = new Select(drd);
        //* 4. adım Select classında bulunan 3 adet methottan birini seçip var olan option veya value veya text yöntemiyle Webelemente ulaşalım
        // select.selectByVisibleText("Baby"); //! Webelemntteki text ile locate edildi
        // select.selectByValue("search-alias=baby-products-intl-ship"); //! Webelementteki "value" ile locate edildi
        select.selectByIndex(3); //!Webelementeki index ile locate edildi  Baby
        //? Seçtiğimim option değerini yazdırır.
        System.out.println(select.getFirstSelectedOption().getText()); //*Seçilen öğeyi string olarak yazdırır.

        Thread.sleep(5000);
        select.selectByValue("search-alias=computers-intl-ship"); //*computers
        System.out.println(select.getFirstSelectedOption().getText());

        Thread.sleep(5000);
        select.selectByVisibleText("All Departments"); //*All Departments
        System.out.println(select.getFirstSelectedOption().getText());

        //* eğer optionların değerini yazdırmak istersek Bir list içinde döngüyle yazdırabiliriz.
        List <WebElement> optionList=select.getOptions();

        System.out.println("optionList.size() = " + optionList.size());
        for (WebElement each:optionList) {

            System.out.println("each.getText() = " + each.getText());

        }

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}
