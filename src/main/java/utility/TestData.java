package utility;

import com.github.javafaker.Faker;

public class TestData {

    public static String getFirstName(){
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public static String getJobName(){
        Faker faker = new Faker();
        return faker.job().position();
    }

}
