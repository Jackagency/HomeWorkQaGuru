package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class DemoAperto {
    @Test
    @Description("Soon to be implemented by you (or QA.GURU engineers)")
    @DisplayName("Work Title test")
    void workTitleTest() {
        step("Open 'https://www.aperto.com/aperto/de' and accept cookies", () -> {
            open("https://www.aperto.com/aperto/de");
            SelenideElement accept = $("#uc-btn-accept-banner");
            accept.click();
        });

        step("Open toggle", () -> {
            SelenideElement toggle = $(".toggle-main-nav .inner");
            toggle.click();
        });

        step("Click on the work title", () -> {
            SelenideElement work = $(".headline", 2);
            work.shouldHave(Condition.text("Work")).click();
        });

        step("Check if the Work page is open", () -> {
            SelenideElement workTitle = $("h1.title");
            workTitle.shouldHave(Condition.text("Work"));
        });
    }

    @Test
    @Description("Soon to be implemented by you (or QA.GURU engineers)")
    @DisplayName("Aperto main page test")
    void qaJobTest() {
        step("Open 'https://www.aperto.com/aperto/de' and accept cookies", () -> {
            open("https://www.aperto.com/aperto/de");
            SelenideElement accept = $("#uc-btn-accept-banner");
            accept.click();
        });

        step("Open toggle", () -> {
            SelenideElement toggle = $(".toggle-main-nav .inner");
            toggle.click();
        });

        step("Click on the Karriere title", () -> {
            SelenideElement karriere = $("ul.level-1 li", 5);
            karriere.shouldHave(Condition.text("Karriere")).click();
        });

        step("Click on the Finde hier deine Stelle! link", () -> {
            SelenideElement findYourJobLink = $("div:nth-child(1) li a");
            findYourJobLink.shouldHave(Condition.text("Finde hier deine Stelle!")).click();
        });

        step("Check the info Title", () -> {
            SelenideElement infoTitle = $(".intro");
            infoTitle.shouldHave(Condition.text("Arbeiten bei Aperto, dem IBM iX Studio Berlin"));
        });
    }

    @Test
    @Description("Soon to be implemented by you (or QA.GURU engineers)")
    @DisplayName("Berlin address check")
    void yogaClassCheck() {
        step("Open 'https://www.aperto.com/aperto/de' and accept cookies", () -> {
            open("https://www.aperto.com/aperto/de");
            SelenideElement accept = $("#uc-btn-accept-banner");
            accept.click();
        });

        step("Click Kontakt button", () -> {
            SelenideElement kontaktButton = $("#skrollr-body nav a");
            kontaktButton.scrollIntoView(true).click();
        });

        step("Check Berlin address", () -> {
            SelenideElement berlinAddress = $("div:nth-child(1) > div > div > div.rich-text-content");
            berlinAddress.shouldHave(Condition.text("Chausseestraße 5"));
        });

    }

}
