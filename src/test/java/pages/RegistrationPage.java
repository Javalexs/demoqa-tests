package pages;

import com.codeborne.selenide.SelenideElement;
import pages.component.CalendarComponent;
import pages.component.RegistrationResultModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private final String TITLE_TEXT = "Student Registration Form";
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultModal registrationResultModal = new RegistrationResultModal();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName");
    public RegistrationPage openPage(){

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;

    }

    public RegistrationPage setFirstName(String name){
        firstNameInput.setValue(name);
        return this;
    }

    public RegistrationPage setLastName(String surname) {
        lastNameInput.setValue(surname);
        return this;
    }

    public RegistrationPage setEmail(String value){
        $("#userEmail").setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value){
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPhone(String value){
        $("#userNumber").setValue(value);
        return this;
    }
    public RegistrationPage setbirthDate(String day, String month, String year){
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage verifyResultsModelAppears(){
        registrationResultModal.verifyModalAppears();
        return this;
    }
    public RegistrationPage verifyResult(String key, String value){
        registrationResultModal.verifyResult(key, value);
        return this;
    }


}
