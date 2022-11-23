package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
    @Test
    void fillFormTest(){
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Egor");
        $("#lastName").setValue("Egorich");
        $("#userEmail").setValue("Egor@egor.com");
//        "Egor@egor.com
        $("#currentAddress").setValue("Address");
        $("#permanentAddress").setValue("Address1");
        $("#submit").click();
    }
}
