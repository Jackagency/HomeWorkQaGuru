package tests;

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

        //Ввожу имя и фамилию
        $("#firstName").setValue("Name");
        $("#lastName").setValue("LastName");

        //Ввожу имейл
        $("#userEmail").setValue("name@example.com");

        //чек-бокс
        $(".custom-control-label").click();

        //ввожу номер телефона
        $("#userNumber").setValue("8900000000");

        //выбираю дату рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("7");

        $(".react-datepicker__year-select").selectOptionByValue("2019");

        $(".react-datepicker__day.react-datepicker__day--007").click();

        //Выбираю тему
        $("#subjectsInput").setValue("Hindi").pressEnter();

        //чек-бокс
        $(".custom-control-label", 3).click();

        //загружаю файл
        $("#uploadPicture").uploadFile(new File("src/test/java/Files/file.docx"));

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
        $(".table-responsive").shouldHave(text("Name LastName"), text("name@example.com"), text("Male"), text("8900000000"), text("07 August,2019"), text("Hindi"), text("Sports"), text("file.docx"), text("address"), text("NCR Delhi"));


    }
}
