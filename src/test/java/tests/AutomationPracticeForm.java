package tests;

import pages.RegistrationPageComponents;
import pages.RegistrationFormObject;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeForm {

    RegistrationFormObject registrationFormObject = new RegistrationFormObject();
    RegistrationPageComponents registrationPageComponents = new RegistrationPageComponents();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        open("/automation-practice-form");


        registrationFormObject
                .setUserFirstName("Name")
                .setUserLastNameInput("LastName")
                .setUserEmailInput("name@example.com");

        registrationPageComponents.setMaleCheckBox();

        registrationFormObject.setUserPhoneNumberInput("8900000000");

        registrationPageComponents.setDateOfBirth("7", "August", "2019");

        registrationFormObject.setStudySubjectInput("Hindi");

        registrationPageComponents
                .setSportsCheckBox()
                .fileUpload();

        registrationFormObject.setAddress("address");


        registrationPageComponents
                .scrollDown()
                .stateAndCitySelect("NCR", "Delhi")
                .pressSubmit()
                .checkResults();
    }
}
