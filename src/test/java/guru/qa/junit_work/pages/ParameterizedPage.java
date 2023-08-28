package guru.qa.junit_work.pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;


import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;



public class ParameterizedPage {

   // ParameterizedPage parameterizedPage=new ParameterizedPage();
    SelenideElement
        selectRu=$("#langs"),
        menu =$("#menu");


    public ParameterizedPage openPage() {
        open("https://paraavis.com/");
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

}
