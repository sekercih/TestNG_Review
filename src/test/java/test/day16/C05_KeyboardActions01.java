package test.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_KeyboardActions01 extends TestBase {
    @Test
    public void test() throws InterruptedException {
 //todo
 //  https://html.com/tags/iframe/ sayfasina gidelim
//   video’yu gorecek kadar asagi inin
//  videoyu izlemek icin Play tusuna basin
//   videoyu calistirdiginizi test edin


        //2- https://html.com/tags/iframe/ sayfasina gidelim

        driver.get("https://html.com/tags/iframe/");

        //3- video’yu gorecek kadar asagi inin

        Actions actions= new Actions(driver);
        actions.
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                perform();
        Thread.sleep(3000);

        //4- videoyu izlemek icin Play tusuna basin
        WebElement iFrame=driver.findElement(By.xpath("//iframe[@src=\"https://www.youtube.com/embed/owsfdh4gxyc\"]"));
        driver.switchTo().frame(iFrame);



        WebElement playTusu= driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']"));
        actions.click(playTusu).perform();
        Thread.sleep(5000);
        //5- videoyu calistirdiginizi test edin

        Assert.assertFalse(playTusu.isDisplayed());

    }
}
