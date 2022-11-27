package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
public class RegistrTestspageobjectsforlesson5 extends TestBase {

    @Test
    void successfulRegistrationTest(){
        String userName = "Alex";
        String lastName = "Fadeev";
        String email = "Alexs@mail.ru";
        String gender = "Male";
        String phone = "8926012345";
        String day = "30";
        String month = "January";
        String year = "2007";
        String sub = "Math";
        String hob = "Music";
        String image = "img/2.png";
        String add = "Baker Street";
        String state = "NCR";
        String city = "Gurgaon";

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
                .verifyResult("Date of Birth", "30 January,2007");



    }
}
