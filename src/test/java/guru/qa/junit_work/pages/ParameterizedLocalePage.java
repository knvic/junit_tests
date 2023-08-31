package guru.qa.junit_work.pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;


import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class ParameterizedLocalePage {

    SelenideElement
            selectLocale = $("#langs");

    public ParameterizedLocalePage openPage() {
        open("https://paraavis.com/");
        return this;
    }

    public ParameterizedLocalePage setLocale(Locale locale) {
        selectLocale.find(byText(locale.name())).click();
        return this;
    }

    public ParameterizedLocalePage setLocaleStr(String locale) {
        selectLocale.find(byText(locale)).click();
        return this;
    }


    public ParameterizedLocalePage shouldHaveTargetMenu(List<String> list) {

        $$(".skewed a").should(texts(list));

        return this;
    }

}
