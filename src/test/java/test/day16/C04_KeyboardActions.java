package test.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;
public class C04_KeyboardActions extends TestBase {
    //todo
    //   sendKeys (): Öğeye bir dizi anahtar gönderir
    // keyDown (): Klavyede tuşa basma işlemi gerçekleştirir
    // keyUp (): Klavyede tuşu serbest bırakma işlemi gerçekleştirir


    //todo
    // https://www.amazon.com sayfasina gidelim
    // Arama kutusuna actions method’larine kullanarak Apple IPHONE 12 yazdirin ve Enter’a basarak arama yaptirin
    // aramanin gerceklestigini test edin
    @Test
    public void keyboardActions() {
        driver.get("https://www.amazon.com");

        //* Arama kutusuna actions method’larine kullanarak Apple IPHONE 12 yazdirin ve Enter’a basarak arama yaptirin
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions = new Actions(driver);
        actions.click(search).keyDown(Keys.SHIFT).
                sendKeys("a").
                keyUp(Keys.SHIFT).
                sendKeys("pple").
                keyDown(Keys.SHIFT).
                sendKeys(" iphone").
                keyUp(Keys.SHIFT).
                sendKeys(" 12").
                sendKeys(Keys.ENTER).perform();


    }

}
