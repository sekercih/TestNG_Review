package test.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;
public class C06_Synchronization01 extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        // https://the-internet.herokuapp.com/dynamic_controls sayfasina gidin
        // disable butonuna basin
        // disabled yazisinin ciktigini test edin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("(//button[@type=\"button\"])[1]")).click();
        //Thread.sleep(100); //! burayı kaldır Testbase deki imlicitliyi onar
        WebElement itsDisabledYazielementi = driver.findElement(By.id("message"));
        Assert.assertTrue(itsDisabledYazielementi.isDisplayed());


    }}
