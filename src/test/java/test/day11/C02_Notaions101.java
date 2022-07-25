package test.day11;

import org.testng.annotations.Test;

public class C02_Notaions101 {

    @Test (priority = 5)
    public void test01(){
        System.out.println("Youtube testi");

    }
    @Test(priority = 4)
    public void test02(){
        System.out.println("Amazon testi");

    }
    @Test(priority = 11)
    public void test03(){
        System.out.println("BestBuy testi");
    }
}
