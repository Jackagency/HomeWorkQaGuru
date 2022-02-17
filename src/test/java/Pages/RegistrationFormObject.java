package Pages;

import com.codeborne.selenide.SelenideElement;

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

    public RegistrationFormObject setUserFirstName (String userFirstName){
        userNameInput.setValue(userFirstName);
        return this;
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

    public void setStudySubjectInput (String studySubject){
        studySubjectInput.setValue(studySubject).pressEnter();
    }

    public void setAddress (String address){
        addressInput.setValue(address);
    }

}
