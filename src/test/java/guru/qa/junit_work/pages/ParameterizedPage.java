package guru.qa.junit_work.pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;


import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;



public class ParameterizedPage {

   // ParameterizedPage parameterizedPage=new ParameterizedPage();
    SelenideElement
        selectRu=$("#langs"),
        menu =$("#menu"),
    setLocalisation= $(".page-header__city > span"),
   // caseCity=$(".base-modal__body"),

    caseCity=$(".modal-cities__inner-wrap"),
    targetCity=$(".page-header__city"),
    tab=$(".base-modal__wrap"),
    //searchCity=$("#search-city");
    searchCity=$("input[placeholder='Поиск города']"),
   // clickcity=$(".modal-cities__outer-wrap modal-cities__outer-wrap--large"),
    vibor=$(".modal-cities__item");

    public ParameterizedPage openPage() {
        open("https://paraavis.com/");
        return this;
    }

    public ParameterizedPage openPagekusnoitochka() {
        open("https://vkusnoitochka.ru/");
        return this;
    }
    public  ParameterizedPage setLocale(Locale locale) {
        //selectRu.$(byText(locale.name())).click();
       selectRu.find(byText(locale.name())).click();
        return this;
    }

    public  ParameterizedPage setLocale1(String locale) {
        //selectRu.$(byText(locale.name())).click();
        selectRu.find(byText(locale)).click();
        return this;
    }
    public  ParameterizedPage shouldHave(List<String> list) {

        //menu.shouldHave(texts(list));

        return this;
    }

    public  ParameterizedPage getTabLocalisation() {
        setLocalisation.click();
        return this;
    }

    public  ParameterizedPage caseCity(String city) {
        //selectRu.$(byText(locale.name())).click();
        caseCity.find(byText(city)).click();
        return this;
    }

    public  ParameterizedPage shouldHaveCity(String target) {

        targetCity.shouldHave(text(target));

        return this;
    }

    public  ParameterizedPage tabShouldHaveText() {

        targetCity.shouldHave(text("Твой город"));

        return this;
    }

    public  ParameterizedPage search(String city) {
        searchCity.click();
        searchCity.setValue(city);
      //  clickcity.find(byText(city)).click();
        caseCity.shouldHave(text(city)).doubleClick();


        return this;
    }

}
