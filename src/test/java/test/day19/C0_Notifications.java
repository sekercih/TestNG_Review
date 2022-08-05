package test.day19;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C0_Notifications extends TestBase {
    @Test
    public void notifications(){
        ChromeOptions options=new ChromeOptions();

        //Add chrome switch to disable notification - "**--disable-notifications**"

        options.addArguments("disable-notifications");
        driver=new ChromeDriver(options);
        driver.get("https://www.getir.com");
        //! Notificatioslar konum bulmayı ignore etmek istediğimizde   options.addArguments("disable-notifications"); bu şekilde ignore edip
        //! driverin içinden çağırıyoruz.

    }

}
