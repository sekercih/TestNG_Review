package test.day21;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C03_ReusableRunner01 {


    @Test
    public void test01(){

        // ulkeler excel'indeki Sayfa1'de
        // 11.index'deki satirin, 2.index'deki hucresinin Azerbaycan oldugunu test edin

        String path="src/test/java/resourses/ulkeler.xlsx";
        String expectedData="Azerbaycan";
        String actualData= C03_ReusableMethodsExcel01.hucreGetir(path,"Sayfa1",11,2).toString();
        Assert.assertEquals(actualData,expectedData,"test is Faild");


    }
}
