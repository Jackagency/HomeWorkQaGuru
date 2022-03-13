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

    String name = "Name";
    String lastName = "LastName";
    String email = "name@example.com";
    String phone = "8900000000";
    String dateDay = "7";
    String dateMonth = "August";
    String dateYear = "2019";
    String studyObject = "Hindi";
    String address = "address";
    String state = "NCR";
    String city = "Delhi";



    @Test
    void successFillTest() {
        open("/automation-practice-form");


        registrationFormObject
                .setUserFirstName(name)
                .setUserLastNameInput(lastName)
                .setUserEmailInput(email);

        registrationPageComponents.setMaleCheckBox();

        registrationFormObject.setUserPhoneNumberInput(phone);

        registrationPageComponents.setDateOfBirth(dateDay, dateMonth, dateYear);

        registrationFormObject.setStudySubjectInput(studyObject);

        registrationPageComponents
                .setSportsCheckBox()
                .fileUpload();

        registrationFormObject.setAddress(address);


        registrationPageComponents
                .scrollDown()
                .stateAndCitySelect(state, city)
                .pressSubmit()
                .checkResults();
    }
}
