package guru.qa.junit_work.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class ParameterizedPage {

   // ParameterizedPage parameterizedPage=new ParameterizedPage();
    SelenideElement
        selectRu=$("#langs");

    public ParameterizedPage openPage() {
        open("https://paraavis.com/");
        return this;
    }
    public  ParameterizedPage setLocale(Locale locale) {
        //selectRu.$(byText(locale.name())).click();
       selectRu.find(byText(locale.name())).click();

        return this;
    }

}
