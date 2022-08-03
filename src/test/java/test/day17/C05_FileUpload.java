package test.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {
    //todo
    // https://the-internet.herokuapp.com/upload adresine gidelim
    // chooseFile butonuna basalim
    // Yuklemek istediginiz dosyayi secelim.
    // Upload butonuna basalim.
    // “File Uploaded!” textinin goruntulendigini test edelim.


    //* https://the-internet.herokuapp.com/upload adresine gidelim
    @Test
    public void uploadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
// chooseFile butonuna basalim
      WebElement fileSec= driver.findElement(By.id("file-upload"));
      String dosyaYol=System.getProperty("user.home")+"\\Desktop\\Deneme1\\appium.xlsx";
        // *Yuklemek istediginiz dosyayi secelim.
        fileSec.sendKeys(dosyaYol);
        Thread.sleep(3000);
        //* Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(3000);

       //* / “File Uploaded!” textinin goruntulendigini test edelim.
        WebElement sonuc=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(sonuc.isDisplayed(),"upload gerçekleşmedi");
    }
}

