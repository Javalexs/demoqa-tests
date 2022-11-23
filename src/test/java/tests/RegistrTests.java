package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void successfulRegistrationTest(){
        String userName = "Alex";

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        $("#firstName").setValue(userName);
        $("#lastName").setValue("Egorich");
        $("#userEmail").setValue("Egor@egor.com");
//        $("#gender-radio-1").click();//wrong
//        $("#gender-radio-2").parent().click();
        $("#genterWrapper").$(byText("Other")).click();

        $("#userNumber").setValue("8926012345");
        $("#dateOfBirthInput").click();



        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("2007");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();

        $("#currentAddress").setValue("Some address");
        $("#submit").click();
    }
}
