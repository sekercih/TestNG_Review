package test.day14;
import io.github.sukgu.*;
import dev.failsafe.internal.util.Durations;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class Psikolink {
    WebDriver driver;
    @BeforeClass
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    @Test
    public void psiko() throws InterruptedException, FindFailed {
        driver.get("https://panel.psikolink.com/");
        Thread.sleep(10000);

        Screen screen = new Screen();
        screen.click("LoginEmail.png");





        }


    }

