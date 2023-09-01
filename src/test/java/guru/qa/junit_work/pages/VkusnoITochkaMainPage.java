package guru.qa.junit_work.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;


import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class VkusnoITochkaMainPage {

    SelenideElement
            setLocalisation = $(".page-header__city > span"),
            searchCity = $("input[placeholder='Поиск города']"),
            windowSearch = $(".base-modal__wrap"),
            strCity = $(".modal-cities__wrap-items > .modal-cities__item"),
            tabCaseCity=$(".base-modal__wrap");

    public VkusnoITochkaMainPage openPagekusnoitochka() {
        open("https://vkusnoitochka.ru/");
        return this;
    }
    public VkusnoITochkaMainPage waitTabCaseCity() {
        SelenideElement a=   tabCaseCity.shouldBe(enabled, Duration.ofSeconds(10));
        return this;
    }
    public VkusnoITochkaMainPage checkActiveElement() {
        setLocalisation.shouldBe(enabled, Duration.ofSeconds(10));
        return this;
    }

    public VkusnoITochkaMainPage getTabLocalisation() {
        setLocalisation.click();
        return this;
    }

    public VkusnoITochkaMainPage tabShouldVisible() {
        windowSearch.shouldBe(visible);
        return this;
    }

    public VkusnoITochkaMainPage search(String city) {
        searchCity.click();
        searchCity.setValue(city);
        strCity.click();
        return this;
    }

    public VkusnoITochkaMainPage tabShouldHaveText(String city) {
        setLocalisation.shouldHave(text(city));
        return this;
    }

}
