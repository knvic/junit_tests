package guru.qa.junit_work.tests;


import guru.qa.junit_work.BaseTest;
import guru.qa.junit_work.pages.ParameterizedLocalePage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$$;


public class ParameterizedSimpleTest1 extends BaseTest {

    ParameterizedLocalePage parameterizedPage = new ParameterizedLocalePage();


  //  RU, EN, О НАС, НОВОСТИ, КОНТАКТЫ, МАГАЗИН, Карта сайта, Магазин
//RU, EN, ABOUT US, NEWS, CONTACTS


    static Stream<Arguments> parameterizedSimpleTest() {
        return Stream.of(
                Arguments.of("ru", List.of("RU", "EN","О НАС", "НОВОСТИ", "КОНТАКТЫ", "МАГАЗИН")),
                Arguments.of("en", List.of("RU", "EN","ABOUT US", "NEWS", "CONTACTS"))
        );
    }
    @MethodSource("parameterizedSimpleTest")
    @Tag("all")
    @ParameterizedTest(name="Проверка меню сайта при перелючении локали на {0} отображается меню {1}")
    void parameterizedSimpleTest(String locale,List<String> list) {
        parameterizedPage
                .openPage()
              .setLocale1(locale);
        $$(".skewed a").should(texts(list));



            }
}
