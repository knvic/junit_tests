package guru.qa.junit_work.pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class ParameterizedCityPage {

   // ParameterizedPage parameterizedPage=new ParameterizedPage();
    SelenideElement
        selectRu=$("#langs"),
           setLocalisation= $(".page-header__city > span"),
   // caseCity=$(".base-modal__body"),

    caseCity=$(".modal-cities__inner-wrap"),
    targetCity=$(".page-header__city"),
    tab=$(".base-modal__wrap"),
    //searchCity=$("#search-city");
    searchCity=$("input[placeholder='Поиск города']"),

    vibor=$(".modal-cities__item");

    public ParameterizedCityPage openPage() {
        open("https://paraavis.com/");
        return this;
    }

    public ParameterizedCityPage openPagekusnoitochka() {
        open("https://vkusnoitochka.ru/");
        return this;
    }
    public ParameterizedCityPage setLocale(Locale locale) {
        //selectRu.$(byText(locale.name())).click();
       selectRu.find(byText(locale.name())).click();
        return this;
    }

    public ParameterizedCityPage setLocale1(String locale) {
        //selectRu.$(byText(locale.name())).click();
        selectRu.find(byText(locale)).click();
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

}
