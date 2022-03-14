package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class GitHubTest extends TestBase{
    //1. Есть ли разница между $("h1 div"); и $("h1").$("div"); - может ли привести к тому что, поиск найдёт разные элементы?
    //Понимаю что может, но затрудняюсь ответить почему. Завязка в том сколько дочерних div имеется у h1


    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void selenideTestGit() {
        open("https://github.com/");
        //ввожу selenide в поиск
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        //проверяю содержит ли первый результат слово селенид и кликаю на него
        $$("ul.repo-list li").first().$("a").shouldHave(Condition.text("selenide/")).click();
        //кликаю по кнопке вики
        $("#wiki-tab").click();
        //проверяю есть ли страница Soft assertion и кликаю на нее
        $("#wiki-body div ul li:nth-child(6) a").shouldHave(Condition.text("Soft assertions")).click();
        //проверяю есть ли в тексте пример для Junit5
        $("#wiki-body h4:nth-child(18)").shouldHave(Condition.text("Using JUnit5 extend test class"));

    }

    @Test
    @Disabled
    void dragAndDropTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //не понимаю почему не работает

        actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-b")).release().perform();

        $("#column-b").shouldHave(Condition.text("A"));

    }
}
