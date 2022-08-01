package test.day11;

import org.testng.annotations.Test;

public class C01_Notations1 {


    @Test (priority = 5)
    public void youtubeTest(){
        System.out.println("Youtube Testi");
    }
    @Test(priority = 7)
    public void bestbuyTest(){
        System.out.println("BestBuy Testi");
    }
    @Test(priority = -1)
    public void amazonTest(){
        System.out.println("Amazon Testi");
    }
}
