package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
public class RegistrTestswithpageobjectsforlesson5 extends TestBase {

    @Test
    void successfulRegistrationTest(){
        String userName = "Alex";
        String lastName = "Fadeev";
        String eMail = "Alexs@mail.ru";
        String gEnder = "Male";
        String nPhone = "8926012345";

        registrationPage.openPage()
                    .setFirstName(userName, lastName)
                    .setEmail(eMail)
                    .setGender(gEnder)
                    .setPhone(nPhone)
                    .setbirthDate("30", "January", "2007")


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
                .verifyResult("Student name", userName + lastName)
                .verifyResult("Student Email", eMail)
                .verifyResult("Gender", gEnder)
                .verifyResult("Mobile", nPhone)
                .verifyResult("Date of Birth", "30 January,2007");


//        $(".table-responsive").shouldHave(text(userName), text(userName), text("Alexs@mail.ru"), text("8926012345"));
        $("#closeLargeModal").click();
    }
}
