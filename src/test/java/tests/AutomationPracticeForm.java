package tests;

import org.junit.jupiter.api.Tag;
import pages.RegistrationPageComponents;
import pages.RegistrationFormObject;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeForm extends TestBase{

    RegistrationFormObject registrationFormObject = new RegistrationFormObject();
    RegistrationPageComponents registrationPageComponents = new RegistrationPageComponents();

    String name = "Name";
    String lastName = "LastName";
    String genderMale = "Male";
    String email = "name@example.com";
    String phone = "8900000000";
    String dateDay = "7";
    String dateMonth = "August";
    String dateYear = "2019";
    String studyObject = "Hindi";
    String sportsCheckBox = "Sports";
    String address = "address";
    String state = "NCR";
    String city = "Delhi";



    @Test
    @Tag("Functional")
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
                .pressSubmit();
        registrationPageComponents
                .checkResults("Student Name", name + " " + lastName)
                .checkResults("Student Email", email)
                .checkResults("Gender", genderMale)
                .checkResults("Mobile", phone)
                .checkResults("Date of Birth", dateDay + " " + dateMonth + "," + dateYear)
                .checkResults("Subjects", studyObject)
                .checkResults("Hobbies", sportsCheckBox)
                .checkResults("Address", address)
                .checkResults("State and City",  state+ " " +city);
    }


    @Test
    @Tag("Smoke")
    void successFillTestSmoke() {
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
                .pressSubmit();
        registrationPageComponents
                .checkResults("Student Name", name + " " + lastName)
                .checkResults("Student Email", email)
                .checkResults("Gender", genderMale)
                .checkResults("Mobile", phone)
                .checkResults("Date of Birth", dateDay + " " + dateMonth + "," + dateYear)
                .checkResults("Subjects", studyObject)
                .checkResults("Hobbies", sportsCheckBox)
                .checkResults("Address", address)
                .checkResults("State and City",  state+ " " +city);
    }
    @Test
    void test1() {
        open("https://www.aperto.com/aperto/de");
        $("#uc-btn-accept-banner").click();
        $(".headline", 2).click();
    }
}
