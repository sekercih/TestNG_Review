package test.day14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



import java.util.List;
import java.awt.*;
import java.time.Duration;

public class Psikolink {
    WebDriver driver;
    @BeforeClass
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://panel.psikolink.com/");
        Thread.sleep(6000);

    }
    @Test
    public void psiko(){

        JavascriptExecutor executor= (JavascriptExecutor) driver;
    /*    driver.switchTo().frame(0);
        List<WebElement> allElements = driver.findElements(By.cssSelector("*"));
        for (WebElement each:allElements) {
            System.out.println(each.getText());*/

        }


    }

