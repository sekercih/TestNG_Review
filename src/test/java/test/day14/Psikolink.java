package test.day14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.HashMap;
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
        ChromeOptions opts = new ChromeOptions();
        opts.addArguments("--disable-javascript");
        driver = new ChromeDriver(opts);

        driver.get("https://panel.psikolink.com/");
        Thread.sleep(6000);

    }
    @Test
    public void psiko() throws InterruptedException {




       JavascriptExecutor executor= (JavascriptExecutor) driver;
    WebElement user=driver.findElement(By.xpath("/html/body/flt-glass-pane//input"));
executor.executeScript("arguments[0].click();",user);

        }


    }

