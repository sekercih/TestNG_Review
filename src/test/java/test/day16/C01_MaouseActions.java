package test.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_MaouseActions extends TestBase {
//todo
//    Yeni bir class olusturalim: MouseActions1
//    https://www.amazon.com/ adresine gidelim
//    Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
//    mouse’u bu menunun ustune getirelim
//  “Create a list” butonuna basalim
//    Acilan sayfada “Your Lists” yazisi oldugunu test edelim

@Test
    public void amazonList() throws InterruptedException {
    //*    https://www.amazon.com/ adresine gidelim
    driver.get("https://www.amazon.com");

    //*    Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin  mouse’u bu menunun ustune getirelim
    Actions actions=new Actions(driver);
    WebElement list=driver.findElement(By.id("nav-link-accountList-nav-line-1"));
    actions.moveToElement(list).perform();
    Thread.sleep(5000);
    //*//  “Create a list” butonuna basalim
    WebElement create=driver.findElement(By.xpath("//*[text()=\"Create a List\"]"));
    Thread.sleep(5000);
    actions.click(create).perform();
//*//    Acilan sayfada “Your Lists” yazisi oldugunu test edelim
    Assert.assertTrue(driver.getTitle().contains("Your List"),"Your List sayfada yoktur.");

}
@Test
    public void actions() throws InterruptedException {
    driver.get("https://webdriveruniversity.com/Actions/index.html#");
    Actions actions=new Actions(driver);

    WebElement dont=driver.findElement(By.id("click-box"));
    actions.sendKeys(Keys.PAGE_DOWN).perform();
    String textClick=dont.getText();
    System.out.println("textClick = " + textClick);
    actions.clickAndHold(dont).perform();
    textClick=dont.getText();
    System.out.println("renk = " + textClick);
    Thread.sleep(5000);
    actions.release().perform();
    textClick=dont.getText();

    System.out.println("renk = " + textClick);
}


}
