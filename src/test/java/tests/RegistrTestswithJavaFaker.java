package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static pages.component.DatebyFakerandRandom.*;


public class RegistrTestswithJavaFaker extends TestBase {


    @Test
    void successfulRegistrationTest(){

        Faker faker = new Faker();
        Random random = new Random();
//
        String userName = getUserNameFaker(faker);
        String lastName = getLastNameFaker(faker);
        String email = getEmailFaker(faker);
        String gender = getGenderFaker(faker);
        String phone = getPhoneFaker(faker);
        String day = getDayFaker(setDateFaker(faker));
        String month = getMonthFaker(setDateFaker(faker));
        String year = getYearFaker(setDateFaker(faker));
        String sub = getSub(random);
        String hob = getHob(random);
        String image = "img/2.png";
        String add = getAdd(faker);
        String state = getState(random);
        String city = getCity(state, random);

        registrationPage.openPage()
                    .setFirstLastName(userName, lastName)
                    .setEmail(email)
                    .setGender(gender)
                    .setPhone(phone)
                    .setbirthDate(day, month, year)
                    .subjects(sub)
                    .hobbies(hob)
                    .picture(image)
                    .address(add)
                    .stateAndCity(state, city);

        registrationPage.verifyResultsModelAppears()
                .verifyResult("Student Name", userName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", phone)
                .verifyResult("Date of Birth", day + " " + month + "," + year)
                .verifyResult("Subjects", sub)
                .verifyResult("Hobbies", hob)
                .verifyResult("Picture", image.substring(4))
                .verifyResult("Address", add )
                .verifyResult("State and City", state + " " + city);


    }


}
