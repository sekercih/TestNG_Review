package test.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;
public class C03_MouseActions extends TestBase {
    //todo
    // https://demoqa.com/droppable adresine gidelim
    // “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    // “Drop here” yazisi yerine “Dropped!” oldugunu test edin

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://demoqa.com/droppable");
        Actions actions=new Actions(driver);
        WebElement drag= driver.findElement(By.id("draggable"));
        WebElement drop= driver.findElement(By.id("droppable"));
        actions.dragAndDrop(drag,drop).perform();
        Thread.sleep(5000);

//* Drop here” yazisi yerine “Dropped!” oldugunu test edin
       String dropText= driver.findElement(By.id("droppable")).getText();

        Assert.assertEquals(drop.getText(),"Dropped!","Dropped! değildir.");

    }
}
