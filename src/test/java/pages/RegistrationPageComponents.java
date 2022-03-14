package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPageComponents {

    @Step("Выбираем чек-бокс Male")
    public void setMaleCheckBox() {
        SelenideElement maleCheckBox = $(byText("Male"));
        maleCheckBox.click();
    }

    @Step("Выбираем чек-бокс Sports")
    public RegistrationPageComponents setSportsCheckBox() {
        SelenideElement maleCheckBox = $(byText("Sports"));
        maleCheckBox.click();
        return this;
    }

    @Step("Выбираем дату рождения")
    public void setDateOfBirth(String day, String month, String year){
        SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
        SelenideElement monthSelect = $(".react-datepicker__month-select");
        SelenideElement yearSelect = $(".react-datepicker__year-select");
        //не знал что такие вещи как aria-label можно в таком виде обрабатывать
        SelenideElement daySelect = $("[aria-label$='" + month + " " + day + "th, " + year + "']");

        dateOfBirthInput.click();
        monthSelect.selectOption(month);
        yearSelect.selectOption(year);
        daySelect.click();

    }

    @Step("Загружаем файл")
    public RegistrationPageComponents fileUpload (){
        SelenideElement fileUploadInput = $("#uploadPicture");
        fileUploadInput.uploadFile(new File("src/test/resources/file.docx"));
        return this;
    }
    @Step("Проматываем до кнопки Submit")
    public RegistrationPageComponents scrollDown (){
        SelenideElement submitButton = $("#submit");
        submitButton.scrollIntoView(true);
        return this;
    }

    @Step("Выбираем город и штат")
    public RegistrationPageComponents stateAndCitySelect (String state, String city){
        SelenideElement stateInput = $("#state");
        SelenideElement cityInput = $("#city");
        SelenideElement wrapperState = $("#stateCity-wrapper").$(byText(state));
        SelenideElement wrapperCity = $("#stateCity-wrapper").$(byText(city));

        stateInput.click();
        wrapperState.click();
        cityInput.click();
        wrapperCity.click();
        return this;
    }
    @Step("Нажимаем Submit")
    public RegistrationPageComponents pressSubmit(){
        SelenideElement submitButton = $("#submit");
        submitButton.click();
        return this;
    }
    @Step("Сверяем результаты")
    public RegistrationPageComponents checkResults(){
        SelenideElement resultsTable = $(".table-responsive");
        resultsTable.shouldHave(
                text("Name"),
                text("name@example.com"),
                text("Male"),
                text("8900000000"),
                text("07 August,2019"),
                text("Hindi"),
                text("Sports"),
//                text("file.docx"),
                text("address"),
                text("NCR Delhi"));
        return this;
    }
}
