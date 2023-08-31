package guru.qa.junit_work.tests;


import guru.qa.junit_work.BaseTest;
import guru.qa.junit_work.pages.Locale;
import guru.qa.junit_work.pages.ParameterizedCityPage;
import guru.qa.junit_work.pages.ParameterizedLocalePage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.logevents.SelenideLogger.step;


public class ParameterizedWorkTest extends BaseTest {
    ParameterizedLocalePage parameterizedLocalePage = new ParameterizedLocalePage();
    ParameterizedCityPage parameterizedCityPage = new ParameterizedCityPage();

    static Stream<Arguments> parameterizedLocalePage() {
        return Stream.of(
                Arguments.of("ru", List.of("RU", "EN", "О НАС", "НОВОСТИ", "КОНТАКТЫ", "МАГАЗИН")),
                Arguments.of("en", List.of("RU", "EN", "ABOUT US", "NEWS", "CONTACTS"))
        );
    }

    @MethodSource("parameterizedLocalePage")
    @Tag("all")
    @ParameterizedTest(name = "Проверка меню сайта при перелючении локали на {0} отображается меню {1}")
    void parameterizedLocaleTest(String locale, List<String> list) {
        parameterizedLocalePage
                .openPage()
                .setLocale1(locale);
        $$(".skewed a").should(texts(list));
    }


    @Tags({
            @Tag("all"),
            @Tag("csvfile")
    })
    @ParameterizedTest(name = "Проверка меню сайта при перелючении локали на {0} отображается меню {1}")
    @CsvFileSource(resources = "/csvDataFile.csv", delimiter = '&')
    void parameterizedCSVLocaleTest(String locale, String menu) {
        System.out.println("string = " + locale);
        System.out.println("menu = " + menu);
        List<String> list = new ArrayList<String>(Arrays.asList(menu.split(",")));
        parameterizedLocalePage
                .openPage()
                .setLocale1(locale);
        $$(".skewed a").should(texts(list));
    }


    static Stream<Arguments> parameterizedSimpleTest() {
        return Stream.of(
                Arguments.of(Locale.ru, List.of("RU", "EN", "О НАС", "НОВОСТИ", "КОНТАКТЫ", "МАГАЗИН")),
                Arguments.of(Locale.en, List.of("RU", "EN", "ABOUT US", "NEWS", "CONTACTS"))
        );
    }

    @MethodSource("parameterizedSimpleTest")
    @Tag("all")
    @ParameterizedTest(name = "Проверка меню сайта при перелючении локали на {0} отображается меню {1}")
    void parameterizedSimpleTest(Locale locale, List<String> list) {

        step("Открываем страницу https://paraavis.com/", () -> {
            parameterizedLocalePage
                    .openPage()
                    .setLocale(locale);
            $$(".skewed a").should(texts(list));
        });
    }


    @ValueSource(
            strings = {"Пятигорск", "Новосибирск"}
    )
    @Tag("all")
    @ParameterizedTest(name = "Check city  =>  {0}")
    void parameterizedCityTest(String city) {

        step("Открываем страницу https://vkusnoitochka.ru/", () -> {
            parameterizedCityPage
                    .openPagekusnoitochka();
        });
        sleep(2000);

        step("Открываем окно выбора города", () -> {
            parameterizedCityPage
                    .getTabLocalisation();
        });

        step("Проверяем, что окно выбора города открыто", () -> {
            parameterizedCityPage
                    .tabShouldVisible();
        });

        step("Открываем окно выбора в поиске набираем город " + city + " и выбираем его", () -> {
            parameterizedCityPage
                    .search(city);
        });

        sleep(1000);

        parameterizedCityPage
                .tabShouldHaveText(city);
    }

}
