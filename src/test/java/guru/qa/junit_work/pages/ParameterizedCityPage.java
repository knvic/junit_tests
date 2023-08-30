package guru.qa.junit_work.pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class ParameterizedCityPage {


    SelenideElement
            setLocalisation = $(".page-header__city > span"),
            searchCity = $("input[placeholder='Поиск города']"),
            caseCity = $(".modal-cities__inner-wrap"),
            targetCity = $(".page-header__city"),
            visibleTab= $(".base-modal__wrap"),
            vibor = $(".modal-cities__item");


    public ParameterizedCityPage openPagekusnoitochka() {
        open("https://vkusnoitochka.ru/");
        return this;
    }


    public ParameterizedCityPage shouldHave(List<String> list) {

        //menu.shouldHave(texts(list));

        return this;
    }

    public ParameterizedCityPage getTabLocalisation() {
        setLocalisation.click();
        return this;
    }

    public ParameterizedCityPage caseCity(String city) {
        caseCity.find(byText(city)).click();
        return this;
    }

    public ParameterizedCityPage shouldHaveCity(String target) {

        targetCity.shouldHave(text(target));

        return this;
    }

    public ParameterizedCityPage tabShouldHaveText() {

        targetCity.shouldHave(text("Твой город"));

        return this;
    }

    public ParameterizedCityPage tabShouldVisible() {

        $(".base-modal__wrap").shouldBe(visible);

        return this;
    }


    public ParameterizedCityPage search(String city) {
        searchCity.click();
        searchCity.setValue(city);
        $(".modal-cities__wrap-items > .modal-cities__item").click();
        return this;
    }

    public ParameterizedCityPage clickSearchingCity(String city) {
        $(".modal-cities__wrap-items > .modal-cities__item").click();
        return this;
    }

    public ParameterizedCityPage checkResultInMenu(String city) {
        $(".modal-cities__wrap-items > .modal-cities__item").click();
        return this;
    }


    public ParameterizedCityPage tabShouldHaveText(String city) {

        setLocalisation.shouldHave(text(city));

        return this;
    }

}
