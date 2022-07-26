package test.day12;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C04_SoftAssertion01 {

    @Test
    public void test(){

        int a=10;
        int b=20;
        int c=30;

        SoftAssert softAssert=new SoftAssert();
//!
        softAssert.assertEquals(a,b,"1.test basarisiz"); // failed
        softAssert.assertTrue(a>b,"2.test basarisiz"); // failed
        softAssert.assertTrue(a<c,"3.test basarisiz"); // passed
        softAssert.assertTrue(c>b,"4.test basarisiz");//passed
        softAssert.assertTrue(c<a,"5.test basarisiz"); // failed

        // assertAll demezsek class calisir ve passed yazar , cunku aslinda raporlama yapmaz sadece kodlar calismis olur
        softAssert.assertAll();
        System.out.println("eger softassert'lerden fail olan varsa bu satir calismaz");
    }
}