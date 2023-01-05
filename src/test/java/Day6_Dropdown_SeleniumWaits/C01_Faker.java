package Day6_Dropdown_SeleniumWaits;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C01_Faker {

    @Test
    public void fakerExample(){

        //Faker objesi oluşturuyoruz
        Faker faker=new Faker();

        System.out.println(faker.name().firstName());
        System.out.println(faker.name().lastName());
        System.out.println(faker.address().fullAddress());
    }
}
