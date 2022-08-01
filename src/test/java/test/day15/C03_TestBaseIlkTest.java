package test.day15;

import org.testng.annotations.Test;
import utilities.TestBase01;

public class C03_TestBaseIlkTest extends TestBase01 {

    @Test
    public void ilkTest(){
        driver.get("https://www.epey.com");
        System.out.println("driver.getTitle() = " + driver.getTitle());


    }

}
