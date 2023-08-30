package guru.qa.junit_work.pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;


import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;



public class ParameterizedLocalePage {

      SelenideElement
              selectLocale =$("#langs"),
        menu =$("#menu"),
    setLocalisation= $(".page-header__city > span"),
   // caseCity=$(".base-modal__body"),

    caseCity=$(".modal-cities__inner-wrap"),
    targetCity=$(".page-header__city"),
    tab=$(".base-modal__wrap"),
    //searchCity=$("#search-city");
    searchCity=$("input[placeholder='Поиск города']"),

    vibor=$(".modal-cities__item");

    public ParameterizedLocalePage openPage() {
        open("https://paraavis.com/");
        return this;
    }

       public ParameterizedLocalePage setLocale(Locale locale) {
            selectLocale.find(byText(locale.name())).click();
        return this;
    }

    public ParameterizedLocalePage setLocale1(String locale) {
               selectLocale.find(byText(locale)).click();
        return this;
    }
    public ParameterizedLocalePage shouldHave(List<String> list) {

        //menu.shouldHave(texts(list));

        return this;
    }

    public ParameterizedLocalePage getTabLocalisation() {
        setLocalisation.click();
        return this;
    }

    public ParameterizedLocalePage caseCity(String city) {
        caseCity.find(byText(city)).click();
        return this;
    }

    public ParameterizedLocalePage shouldHaveCity(String target) {

        targetCity.shouldHave(text(target));

        return this;
    }

    public ParameterizedLocalePage tabShouldHaveText() {

        targetCity.shouldHave(text("Твой город"));

        return this;
    }

    public ParameterizedLocalePage search(String city) {
        searchCity.click();
        searchCity.setValue(city);
        $(".modal-cities__wrap-items > .modal-cities__item").click();
        return this;
    }

    public ParameterizedLocalePage clickSearchingCity(String city) {
           $(".modal-cities__wrap-items > .modal-cities__item").click();
        return this;
    }
    public ParameterizedLocalePage checkResultInMenu(String city) {
        $(".modal-cities__wrap-items > .modal-cities__item").click();
        return this;
    }

}
