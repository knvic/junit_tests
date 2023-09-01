package guru.qa.junit_work.pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;


import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class ParaavisMainPage {

    SelenideElement
            selectLocale = $("#langs");

    public ParaavisMainPage openPage() {
        open("https://paraavis.com/");
        return this;
    }

    public ParaavisMainPage setLocale(Locale locale) {
        selectLocale.find(byText(locale.getLanguage())).click();
        return this;
    }

    public ParaavisMainPage setLocaleStr(String locale) {
        selectLocale.find(byText(locale)).click();
        return this;
    }


    public ParaavisMainPage shouldHaveTargetMenu(List<String> list) {

        $$(".skewed a").should(texts(list));

        return this;
    }

}
