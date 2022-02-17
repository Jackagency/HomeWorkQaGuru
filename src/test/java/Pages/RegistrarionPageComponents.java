package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrarionPageComponents {

    // Выбор чек-бокса Male
    public void setMaleCheckBox() {
        SelenideElement maleCheckBox = $(byText("Male"));
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
}
