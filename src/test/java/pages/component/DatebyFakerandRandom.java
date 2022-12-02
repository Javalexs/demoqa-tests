package pages.component;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.*;

public class DatefromJavaFaker {
    public static String getUserNameFaker(Faker faker) {
        return faker.name().firstName();
    }
    public static String getLastNameFaker(Faker faker) {
        return faker.name().lastName();
    }
    public static String getEmailFaker(Faker faker) {
        return faker.internet().emailAddress();
    }
    public static String getGenderFaker(Faker faker) {
        return faker.demographic().sex();
    }
    public static String getPhoneFaker(Faker faker) {
        return faker.phoneNumber().subscriberNumber(10);
    }
    public static String setDateFaker(Faker faker) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMMddyyyy", Locale.ENGLISH);
        Date date = faker.date().birthday();
        return sdf.format(date);
    }
    public static String getDayFaker(String str) {
        return str.substring(str.length() - 6, str.length() - 4);
    }
    public static String getMonthFaker(String str) {
        return str.substring(0, str.length() - 6);
    }
    public static String getYearFaker(String str) {
        return str.substring(str.length() - 4);
    }
    public static String getSub(Random random){
        String[] arraySub = {"Accounting", "Arts", "English", "Physics"};
        return arraySub[random.nextInt(arraySub.length)];
    }
    public static String getHob(Random random){
        String[] arrayHob = {"Sports", "Reading", "Music"};
        return arrayHob[random.nextInt(arrayHob.length)];
    }
    public static String getAdd(Faker faker) {
        return faker.address().streetAddress();
    }

    public static String getState(Random random){
        String[] arrayState = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return arrayState[random.nextInt(arrayState.length)];
    }
    public static String getCity(String key, Random random) {
        Map<String, String[]> map = new HashMap<>();
        map.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        map.put("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"});
        map.put("Haryana", new String[]{"Karnal", "Panipat"});
        map.put("Rajasthan", new String[]{"Jaipur", "Jaiselmer"});

        String[] arrayCity = map.get(key);
        return arrayCity[random.nextInt(arrayCity.length)];
    }



}

