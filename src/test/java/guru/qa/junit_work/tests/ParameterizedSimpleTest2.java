package guru.qa.junit_work.tests;


import guru.qa.junit_work.BaseTest;
import guru.qa.junit_work.pages.ParameterizedPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;


public class ParameterizedSimpleTest2 extends BaseTest {

    ParameterizedPage parameterizedPage = new ParameterizedPage();


    //  RU, EN, О НАС, НОВОСТИ, КОНТАКТЫ, МАГАЗИН, Карта сайта, Магазин
//RU, EN, ABOUT US, NEWS, CONTACTS


    @ValueSource(
            strings = {"Пятигорск"}
    )
    @MethodSource("parameterizedSimpleTest")
    @Tag("all")
    @ParameterizedTest(name = "Check city  =>  {0}")
    void parameterizedSimpleTest(String city) {
        parameterizedPage
                .openPagekusnoitochka();
        sleep(5000);
        parameterizedPage

                .getTabLocalisation()
                //.tabShouldHaveText()
                .search(city);
        sleep(5000);
              /*  .caseCity(city)

                .shouldHaveCity(city);*/


    }
}
