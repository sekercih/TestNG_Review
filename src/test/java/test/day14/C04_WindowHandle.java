package test.day14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C04_WindowHandle {
    WebDriver driver;
    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //  driver.get("https://the-internet.herokuapp.com/iframe");

    }
    @Test
    public void windowHandle(){
        driver.get("https://www.amazon.com");
        System.out.println("driver.getWindowHandle1() = " + driver.getWindowHandle());}
    @Test
    public void windowHandle2(){

        driver.get("https://the-internet.herokuapp.com");
        System.out.println("driver.getWindowHandle2() = " + driver.getWindowHandle());

    }
    @Test
    public void windowHandle3(){

        driver.get("https://www.bestbuy.com");
        System.out.println("driver.getWindowHandle3() = " + driver.getWindowHandle());
    }
    @AfterMethod
    public void tearDown(){
        //driver.close();
    }

}
