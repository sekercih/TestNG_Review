package test.day18;

import com.github.javafaker.Faker;

import java.util.Locale;

public class Test {
    public static void main(String[] args) {
        Faker faker=new Faker(new Locale("tr"));

        for (int sayac=0;  sayac<100; sayac++){
            System.out.println(sayac+" "+faker.name().firstName()+" "+faker.name().lastName());
        }

    }
}
