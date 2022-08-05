package test.day18;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;
import java.util.Set;

public class C03_Cookies extends TestBase {
//todo
// Yeni bir class olusturun : cookiesAutomation
// Amazon anasayfaya gidin
// tum cookie’leri listeleyin
// Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
//  ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
// ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
// olusturun ve sayfaya ekleyin
// eklediginiz cookie’nin sayfaya eklendigini test edin
// ismi skin olan cookie’yi silin ve silindigini test edin
// tum cookie’leri silin ve silindigini test edin
    @Test
    public void cookiesAutomation(){
        //* // Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //*// tum cookie’leri listeleyin
      Set<Cookie> cook= driver.manage().getCookies();
int sayac=1;
        for (Cookie each:cook) {

            System.out.println((sayac++)+" each = " + each);
        }
        //*// Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cook.size()>5,"Cooklar 5 den küçük");

        //* ismi i18n-prefs olan cookie degerinin USD oldugunu test edin

      Cookie cooks=driver.manage().getCookieNamed("i18n-prefs");
        System.out.println("cooks = " + cooks);
        Assert.assertEquals(cooks.getValue(),"USD");

        // ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
        Cookie mycook=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(mycook);

        Set<Cookie> cook1= driver.manage().getCookies();
        int sayac1=1;
        for (Cookie each:cook1) {

            System.out.println((sayac1++)+" each = " + each);
        }
        //*// eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertTrue(cook1.contains(mycook),"çikolatalı cook yok");
       //* ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");

        Set<Cookie> cook2= driver.manage().getCookies();
        int sayac2=1;
        for (Cookie each:cook2) {

            System.out.println((sayac2++)+" each = " + each);
        }
Assert.assertFalse(cook2.contains(driver.manage().getCookieNamed("skin")),"skin vardır.");
        //* tum cookie’leri silin ve silindigini test edin

        driver.manage().deleteAllCookies();
        Set <Cookie> cookSon=driver.manage().getCookies();
        Assert.assertTrue(cookSon.size()==0);
    }

}
