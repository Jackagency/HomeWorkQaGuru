package tests;

import Pages.RegistrarionPageComponents;
import Pages.RegistrationFormObject;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

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
        new RegistrarionPageComponents().setMaleCheckBox();
        //Ввожу телефонный номер
        new RegistrationFormObject().setUserPhoneNumberInput("8900000000");

        //выбираю дату рождения

        new RegistrarionPageComponents().setDateOfBirth("7", "August", "2019");

        //Выбираю тему
        $("#subjectsInput").setValue("Hindi").pressEnter();

        //чек-бокс
        $(byText("Sports")).click();

        //загружаю файл
        $("#uploadPicture").uploadFile(new File("src/test/resources/file.docx"));

        //Пишу адресс
        $("#currentAddress").setValue("address");

        //Проматываю ниже, так как ни в какую не хочет нажимать на элементы ниже экрана
        //Выбираю штат и город
        $("#submit").scrollIntoView(true);
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();

        //Подтверждаю информацию
        $("#submit").click();


        //Проверяю результат
        $(".table-responsive").shouldHave(
                text("Name LastName"),
                text("name@example.com"),
                text("Male"),
                text("8900000000"),
                text("07 August,2019"),
                text("Hindi"),
                text("Sports"),
                text("file.docx"),
                text("address"),
                text("NCR Delhi"));


    }
}
