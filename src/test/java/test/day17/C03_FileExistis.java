package test.day17;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExistis {

    @Test
    public void testFilePath(){
        //* C:\Users\Mehmet
        System.getProperty("user.home");//*kendi bilgisayarımızın kullanıcı yolunu verir.
        System.out.println("System.getProperty(\"user.home\") = " + System.getProperty("user.home"));
 //*Masaüstündeki Deneme1 klasöründeki appium.xlsx pathini bize verir.
String path=System.getProperty("user.home")+"\\Desktop\\Deneme1\\appium.xlsx"; //C:\Users\Mehmet\Desktop\Deneme1\appium.xlsx
        System.out.println("path = " + path);
        System.out.println("Files.exists(Paths.get(path)) = " + Files.exists(Paths.get(path)));

        System.getProperty("user.dir"); //*Bir dosya içerisindeki dinamik yolu bize verir.
        //* C:\Users\Mehmet\Desktop\GuiderSoft Gün Package\com.Guidersoft_TestNG
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));

//!C:\Users\Mehmet\Desktop\GuiderSoft Gün Package\com.Guidersoft_TestNG\pom.xml
        String pathPomXml=System.getProperty("user.dir")+"\\pom.xml";
        System.out.println("pathPomXml = " + pathPomXml);
        Assert.assertTrue(Files.exists(Paths.get(pathPomXml)),"pom xml yoktur.");


    }
}
