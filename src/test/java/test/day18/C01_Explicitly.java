package test.day18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;
import java.time.Duration;

public class C01_Explicitly extends TestBase {
    //todo
    // 1. Bir class olusturun : WaitTest
    // 2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //   Iki metod icin de asagidaki adimlari test edin.
    // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    // 4. Remove butonuna basin.
    // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    // 6. Add buttonuna basin
    // 7. It’s back mesajinin gorundugunu test edin

    //! TestBase imlicitliwait comment yapalımmm

    @Test
    public void implicitWait() throws InterruptedException {
    //    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //* // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //*   // 4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[@type=\"button\"]")).click();

        //*  // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGone=driver.findElement(By.id("message"));
        Assert.assertTrue(itsGone.isDisplayed());

        //* // 6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()=\"Add\"]")).click();

        //*// 7. It’s back mesajinin gorundugunu test edin
        WebElement itsBack=driver.findElement(By.id("message"));
        Assert.assertTrue(itsBack.isDisplayed());




    }
    @Test
    public void  explicitWait(){

        //* // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(7));

        //*   // 4. Remove butonuna basin.
        WebElement remove= driver.findElement(By.xpath("//*[@type=\"button\"]"));
        remove.click();

        //*  // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        WebElement itsGone=driver.findElement(By.id("message"));
        Assert.assertTrue(itsGone.isDisplayed());

        Assert.assertTrue(itsGone.isDisplayed());

        //* // 6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()=\"Add\"]")).click();

        //*// 7. It’s back mesajinin gorundugunu test edin
        //
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        Assert.assertTrue(driver.findElement(By.id("message")).isDisplayed());

    }
}
