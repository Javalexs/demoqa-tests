package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
public class RegistrTestspageobjectsforlesson5 extends TestBase {

    @Test
    void successfulRegistrationTest(){
        String userName = "Alex";
        String lastName = "Fadeev";
        String eMail = "Alexs@mail.ru";
        String gEnder = "Male";
        String nPhone = "8926012345";

        registrationPage.openPage()
                    .setFirstName(userName)
                    .setLastName(lastName)
                    .setEmail(eMail)
                    .setGender(gEnder)
                    .setPhone(nPhone)
                    .setbirthDate("30", "January", "2007");


        $("#subjectsInput").setValue("Math").pressEnter();

        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("img/2.png");

        $("#currentAddress").setValue("Baker Street");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Gurgaon")).click();
        $("#submit").click();

        registrationPage.verifyResultsModelAppears()
                .verifyResult("Student Name", userName + " " + lastName)
                .verifyResult("Student Email", eMail)
                .verifyResult("Gender", gEnder)
                .verifyResult("Mobile", nPhone)
                .verifyResult("Date of Birth", "30 January,2007");



    }
}
