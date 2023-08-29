package guru.qa.junit_work.tests;





import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import guru.qa.junit_work.BaseTest;
import guru.qa.junit_work.pages.Locale;
import guru.qa.junit_work.pages.ParameterizedPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;


import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

//@Disabled
public class ParameterizedSimpleTest extends BaseTest {

    ParameterizedPage parameterizedPage = new ParameterizedPage();


  //  RU, EN, О НАС, НОВОСТИ, КОНТАКТЫ, МАГАЗИН, Карта сайта, Магазин
//RU, EN, ABOUT US, NEWS, CONTACTS
    static Stream<Arguments> parameterizedSimpleTest() {
        return Stream.of(
                Arguments.of(Locale.ru, List.of("RU", "EN","О НАС", "НОВОСТИ", "КОНТАКТЫ", "МАГАЗИН")),
                Arguments.of(Locale.en, List.of("RU", "EN","ABOUT US", "NEWS", "CONTACTS"))
        );
    }
    @MethodSource("parameterizedSimpleTest")
    @Tag("all")

    @ParameterizedTest(name="Проверка меню сайта при перелючении локали на {0} отображается меню {1}")
    void parameterizedSimpleTest(Locale locale,List<String> list) {
        parameterizedPage
                .openPage()
              .setLocale(locale);
        $$(".skewed a").should(texts(list));



            }
}
