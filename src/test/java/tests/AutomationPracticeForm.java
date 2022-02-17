package tests;

import Pages.RegistrationPageComponents;
import Pages.RegistrationFormObject;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeForm {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        open("/automation-practice-form");

        //Ввожу имя
        new RegistrationFormObject().setUserFirstName("Name");
        //Ввожу фамилию
        new RegistrationFormObject().setUserLastNameInput("LastName");
        //Ввожу имейл
        new RegistrationFormObject().setUserEmailInput("name@example.com");
        //чек-бокс
        new RegistrationPageComponents().setMaleCheckBox();
        //Ввожу телефонный номер
        new RegistrationFormObject().setUserPhoneNumberInput("8900000000");

        //выбираю дату рождения
        new RegistrationPageComponents().setDateOfBirth("7", "August", "2019");

        //Выбираю тему
        new RegistrationFormObject().setStudySubjectInput("Hindi");

        //чек-бокс
        new RegistrationPageComponents().setSportsCheckBox();

        //загружаю файл
        new RegistrationPageComponents().fileUpload();

        //Пишу адресс
        new RegistrationFormObject().setAddress("address");

        //Проматываю ниже, так как ни в какую не хочет нажимать на элементы ниже экрана
        new RegistrationPageComponents().scrollDown();

        //Выбираю штат и город
        new RegistrationPageComponents().stateAndCitySelect("NCR", "Delhi");

        //Нажимаю Submit
        new RegistrationPageComponents().pressSubmit();


        //Проверяю результат
        new RegistrationPageComponents().checkResults();

    }
}
