package guru.qa.junit_work.pages;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class ParameterizedCityPage {

    SelenideElement
            setLocalisation = $(".page-header__city > span"),
            searchCity = $("input[placeholder='Поиск города']"),
            windowSearch = $(".base-modal__wrap"),
            strCity = $(".modal-cities__wrap-items > .modal-cities__item");


    public ParameterizedCityPage openPagekusnoitochka() {
        open("https://vkusnoitochka.ru/");
        return this;
    }

    public ParameterizedCityPage getTabLocalisation() {
        setLocalisation.click();
        return this;
    }

    public ParameterizedCityPage tabShouldVisible() {
        windowSearch.shouldBe(visible);
        return this;
    }

    public ParameterizedCityPage search(String city) {
        searchCity.click();
        searchCity.setValue(city);
        strCity.click();
        return this;
    }

    public ParameterizedCityPage tabShouldHaveText(String city) {
        setLocalisation.shouldHave(text(city));
        return this;
    }

}
