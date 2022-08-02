package test.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import javax.swing.*;
import java.util.Set;

public class C02_MouseActions extends TestBase {
    //todo
    // https://the-internet.herokuapp.com/context_menu sitesine gidelim
    //  Cizili alan uzerinde sag click yapalim
    // Alert’te cikan yazinin “You selected a context menu” oldugunu  test edelim.
    // Tamam diyerek alert’I kapatalim
    // Elemental Selenium linkine tiklayalim
    // Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

    @Test
    public void mouseActions() throws InterruptedException {
        //* https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //*  //  Cizili alan uzerinde sag click yapalim
        WebElement rightclick=driver.findElement(By.id("hot-spot"));
        Actions  actions=new Actions(driver);
        actions.contextClick(rightclick).perform();

        Thread.sleep(5000);
        //* Alert’te cikan yazinin “You selected a context menu” oldugunu  test edelim
        String alertText=driver.switchTo().alert().getText();
        String expectedText="You selected a context menu";
        Assert.assertEquals(alertText,expectedText);

        //* Tamam diyerek alert’I kapatalim
        driver.switchTo().alert().accept();

        //* Elemental Selenium linkine tiklayalim
String page1=driver.getWindowHandle();
        driver.findElement(By.xpath("//*[@*=\"_blank\"]")).click();
       Set<String> pageHandles=driver.getWindowHandles();

        //* Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String page2="";
        for (String each:pageHandles) {
            if (!each.equals(page1)){
                page2=each;
            }
        }
        driver.switchTo().window(page2);
        String expectedElement="Elemental Selenium";
        String actualElement=driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(actualElement,expectedElement,"Elemental Selenium yoktur.");


    }
}
