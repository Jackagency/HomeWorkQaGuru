package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationFormObject {

    //locators

    SelenideElement userNameInput = $("#firstName");
    SelenideElement userLastNameInput = $("#lastName");
    SelenideElement userEmailInput = $("#userEmail");
    SelenideElement userPhoneNumberInput = $("#userNumber");
    SelenideElement studySubjectInput = $("#subjectsInput");
    SelenideElement addressInput = $("#currentAddress");


    //actions
    @Step("Вводим имя")
    public RegistrationFormObject setUserFirstName (String userFirstName){
        userNameInput.setValue(userFirstName);
        return this;
    }
    @Step("Вводим фамилию")
    public RegistrationFormObject setUserLastNameInput (String userLastName){
        userLastNameInput.setValue(userLastName);
        return this;
    }
    @Step("Вводим имейл")
    public RegistrationFormObject setUserEmailInput (String userEmail){
        userEmailInput.setValue(userEmail);
        return this;
    }
    @Step("Вводим номер телефона")
    public void setUserPhoneNumberInput (String userPhoneNumber){
        userPhoneNumberInput.setValue(userPhoneNumber);
    }
    @Step("Вводим объект изучения")
    public void setStudySubjectInput (String studySubject){
        studySubjectInput.setValue(studySubject).pressEnter();
    }
    @Step("Вводим адрес")
    public void setAddress (String address){
        addressInput.setValue(address);
    }

}
