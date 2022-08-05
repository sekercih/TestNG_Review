package test.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;
public class C01_KeyboardActions extends TestBase {
    //todo
    //  https://html.com/tags/iframe/ sayfasina gidelim
   //   video’yu gorecek kadar asagi inin
    //  videoyu izlemek icin Play tusuna basin
   //   videoyu calistirdiginizi test edin
@Test
   public void test(){

    //  https://html.com/tags/iframe/ sayfasina gidelim
    driver.get("https://html.com/tags/iframe/");

    //*   video’yu gorecek kadar asagi inin
    Actions actions=new Actions(driver);

    actions.
            sendKeys(Keys.PAGE_DOWN).
            sendKeys(Keys.PAGE_DOWN).
            perform();
    //* //  videoyu izlemek icin Play tusuna basin
    WebElement iframe=driver.findElement(By.xpath("//iframe[@src=\"https://www.youtube.com/embed/owsfdh4gxyc\"]"));
    driver.switchTo().frame(iframe);

    WebElement play=driver.findElement(By.xpath("//button[@class=\"ytp-large-play-button ytp-button\"]"));
    actions.click(play).perform();

    //   videoyu calistirdiginizi test edin
    Assert.assertFalse(play.isDisplayed(),"Video çalışmıyor.");

}

}
