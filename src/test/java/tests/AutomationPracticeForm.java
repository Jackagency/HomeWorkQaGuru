package tests;

import pages.RegistrationPageComponents;
import pages.RegistrationFormObject;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeForm extends TestBase{

    RegistrationFormObject registrationFormObject = new RegistrationFormObject();
    RegistrationPageComponents registrationPageComponents = new RegistrationPageComponents();

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

        registrationPageComponents.setSportsCheckBox();

        //селенид не хочет загружать файл
//        registrationPageComponents.fileUpload();

        registrationFormObject.setAddress(address);


        registrationPageComponents
                .scrollDown()
                .stateAndCitySelect(state, city)
                .pressSubmit()
                .checkResults();
    }
}
