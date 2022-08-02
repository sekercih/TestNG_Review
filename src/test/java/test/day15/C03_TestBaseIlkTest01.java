package test.day15;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_TestBaseIlkTest01 extends TestBase {
    @Test
    public void test(){

        driver.get("https://www.epey.com");
        System.out.println(driver.getTitle());


    }
}

