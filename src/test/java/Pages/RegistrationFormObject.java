package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationFormObject {

    //locators

    SelenideElement userNameInput = $("#firstName");
    SelenideElement userLastNameInput = $("#lastName");
    SelenideElement userEmailInput = $("#userEmail");
    SelenideElement userPhoneNumberInput = $("#userNumber");



    //actions

    public void setUserFirstName (String userFirstName){
        userNameInput.setValue(userFirstName);
    }

    public void setUserLastNameInput (String userLastName){
        userLastNameInput.setValue(userLastName);
    }

    public void setUserEmailInput (String userEmail){
        userEmailInput.setValue(userEmail);
    }

    public void setUserPhoneNumberInput (String userPhoneNumber){
        userPhoneNumberInput.setValue(userPhoneNumber);
    }
}
