package pages;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPageComponents {

    // Выбор чек-бокса Male
    public void setMaleCheckBox() {
        SelenideElement maleCheckBox = $(byText("Male"));
        maleCheckBox.click();
    }

    //Выбор чек-бокса Sports
    public void setSportsCheckBox() {
        SelenideElement maleCheckBox = $(byText("Sports"));
        maleCheckBox.click();
    }


    //выбор даты рождения
    public void setDateOfBirth(String day, String month, String year){
        SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
        SelenideElement monthSelect = $(".react-datepicker__month-select");
        SelenideElement yearSelect = $(".react-datepicker__year-select");
        //эту строчку забрал с занятия, полностью понимаю как она составлена, но сам не могу такую составить.
        //не знал что такие вещи как aria-label можно в таком виде обрабатывать
        SelenideElement daySelect = $("[aria-label$='" + month + " " + day + "th, " + year + "']");

        dateOfBirthInput.click();
        monthSelect.selectOption(month);
        yearSelect.selectOption(year);
        daySelect.click();

    }

    //загрузка файла
    public void fileUpload (){
        SelenideElement fileUploadInput = $("#uploadPicture");
        fileUploadInput.uploadFile(new File("src/test/resources/file.docx"));
    }
    //промотка до кнопки submit
    public void scrollDown (){
        SelenideElement submittButton = $("#submit");
        submittButton.scrollIntoView(true);
    }

    //выбор города и штата
    public void stateAndCitySelect (String state, String city){
        SelenideElement stateInput = $("#state");
        SelenideElement cityInput = $("#city");
        SelenideElement wrapperState = $("#stateCity-wrapper").$(byText(state));
        SelenideElement wrapperCity = $("#stateCity-wrapper").$(byText(city));

        stateInput.click();
        wrapperState.click();
        cityInput.click();
        wrapperCity.click();
    }

    public void pressSubmit(){
        SelenideElement submitButton = $("#submit");
        submitButton.click();
    }

    public void checkResults(){
        SelenideElement resultsTable = $(".table-responsive");
        resultsTable.shouldHave(
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
