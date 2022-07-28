package test.day14;

import org.testng.asserts.SoftAssert;

public class C0_Review {

    //todo
    // 1 Bir metodun diğer bir metoda bağ olmasını sağlamak için kullanılan annotation nedir?
    //* @Test(dependsOnMethod="methodismi")
    // 2. Hard Assert icin baska hangi ifade kullanilir?
    //* Assertion
    // 3. Soft Assert icin baska hangi ifade kullanilir?
    //* Verification
    // 4. Hard Assert ve Soft Assert arasindaki benzerlik nedir?
    //*Her ikisi de TestNG den gelir.
    // 5. Hard Assert ve Soft Assert arasindaki farklilik nedir?
    //* Hard assert fail olduğunda çalışmaya devam etmez,soft assert fail olduğunda çalışmaya devam eder.
    //  6. Ogrendigimiz Hard Assert syntaxlerini yazabilir misiniz?
    //* Assert.assertTrue() Assert.assertFalse() Assert.assertEquals()
    //  7. Soft Assert nasil olusturulur, yazabilir misiniz?
    SoftAssert softAssert=new SoftAssert();
    //* softAssert.assertEquals(actual,expected);
    //* softAssert.assertAll();



}
