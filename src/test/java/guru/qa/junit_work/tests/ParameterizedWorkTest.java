package guru.qa.junit_work.tests;


import guru.qa.junit_work.pages.Locale;
import guru.qa.junit_work.pages.VkusnoITochkaMainPage;
import guru.qa.junit_work.pages.ParaavisMainPage;
import org.junit.jupiter.api.DisplayName;
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

import static com.codeborne.selenide.logevents.SelenideLogger.step;


public class ParameterizedWorkTest extends BaseTest {
    ParaavisMainPage paraavisMainPage = new ParaavisMainPage();
    VkusnoITochkaMainPage vkusnoITochkaMainPage = new VkusnoITochkaMainPage();

   /* 0)    TEST_DATA_1:
            [
            ['"ru"', '"RU", "EN", "О НАС", "НОВОСТИ", "КОНТАКТЫ", "МАГАЗИН"'],
            ['"en"', '"RU", "EN", "ABOUT US", "NEWS", "CONTACTS"']
            ]

            1) ЗАГОЛОВОК: "На сайте при выборе локали выбранной локали 'TES_DATA[0]' присутствует меню на языке выбранной локали 'TES_DATA[1]'"
            2) ПРИОРОИТЕТ: BLOCKER
            3) ПРЕДУСЛОВИЯ: - Открыт браузер chrome, location: https://paraavis.com/

            4) ШАГИ
            - Нажимаем на выбранную локаль 'TES_DATA[0]'


            5) ОЖИДАЕМЫЙ РЕЗУЛЬТАТ:
            - В в меню присутствует строка 'TES_DATA[1]'*/


    static Stream<Arguments> parameterizedLocalePage() {
        return Stream.of(
                Arguments.of("ru", List.of("RU", "EN", "О НАС", "НОВОСТИ", "КОНТАКТЫ", "МАГАЗИН")),
                Arguments.of("en", List.of("RU", "EN", "ABOUT US", "NEWS", "CONTACTS"))
        );
    }

    @DisplayName("Параметризованный тест с использованием Stream<Arguments> ")
    @MethodSource("parameterizedLocalePage")
    @Tag("all")
    @ParameterizedTest(name = "Проверка меню сайта при перелючении локали на {0} отображается меню {1}")
    void parameterizedLocaleTest(String locale, List<String> list) {
        step("Открываем страницу https://paraavis.com/", () -> {
            paraavisMainPage
                    .openPage();
        });

        step("Выбираем локаль", () -> {
            paraavisMainPage
                    .setLocaleStr(locale);
        });

        step("Проверяем наличие меню", () -> {
            paraavisMainPage
                    .shouldHaveTargetMenu(list);
        });

    }

    @DisplayName("Параметризованный тест с использованием CsvFileSource ")
    @Tags({
            @Tag("all"),
            @Tag("csvfile")
    })
    @ParameterizedTest(name = "Проверка меню сайта при перелючении локали на {0} отображается меню {1}")
    @CsvFileSource(resources = "/csvDataFile.csv", delimiter = '&')
    void parameterizedLocaleCSVTest(String locale, String menu) {
        List<String> list = new ArrayList<String>(Arrays.asList(menu.split(",")));
        paraavisMainPage
                .openPage()
                .setLocaleStr(locale)
                .shouldHaveTargetMenu(list);
    }

    static Stream<Arguments> parameterizedSimpleTest() {
        return Stream.of(
                Arguments.of(Locale.ru, List.of("RU", "EN", "О НАС", "НОВОСТИ", "КОНТАКТЫ", "МАГАЗИН")),
                Arguments.of(Locale.en, List.of("RU", "EN", "ABOUT US", "NEWS", "CONTACTS"))
        );
    }

    @DisplayName("Параметризованный тест с использованием Stream<Arguments> и ENUM")
    @MethodSource("parameterizedSimpleTest")
    @Tag("all")
    @ParameterizedTest(name = "Проверка меню сайта при перелючении локали на {0} отображается меню {1}")
    void parameterizedSimpleTest(Locale locale, List<String> list) {

        step("Открываем страницу https://paraavis.com/", () -> {
            paraavisMainPage
                    .openPage()
                    .setLocale(locale)
                    .shouldHaveTargetMenu(list);
        });
    }


     /*     0) TEST_DATA_2:
            [
            ['"Пятигорск"'],
            ['"Новосибирск"']
            ]

            1) ЗАГОЛОВОК: "На сайте при выборе и смене города  в местоположении отображается выбранный 'TES_DATA[0]' (набранный с строке поиска ) город 'TES_DATA[0]''"
            2) ПРИОРОИТЕТ: BLOCKER
            3) ПРЕДУСЛОВИЯ: - Открыт браузер chrome, location: https://vkusnoitochka.ru/

            4) ШАГИ
            - Нажимаем на местположения
            -В появившемся окне выбора города в строке поиска набираем город 'TES_DATA[0]'
            -В поле найденных городов выбираем наш город 'TES_DATA[0]'


            5) ОЖИДАЕМЫЙ РЕЗУЛЬТАТ:
            - В поле местоположения пристствует набранный/выбранный город 'TES_DATA[0]'*/


    @ValueSource(
            strings = {"Пятигорск", "Новосибирск"}
    )
    @Tags({
            @Tag("all"),
            @Tag("duration")
    })
    @ParameterizedTest(name = "Check city  =>  {0}")
    void parameterizedCityTest(String city) {

        step("Открываем страницу https://vkusnoitochka.ru/", () -> {
            vkusnoITochkaMainPage
                    .openPagekusnoitochka();
        });

        step("Проверяем(ждем) доступность элемента с городом", () -> {
            vkusnoITochkaMainPage
                    .checkActiveElement();
        });

        step("Открываем окно выбора города", () -> {
            vkusnoITochkaMainPage
                    .getTabLocalisation();
        });

        step("Длем появления(доступности) окна выбора города", () -> {
            vkusnoITochkaMainPage
                    .waitTabCaseCity();
        });



        step("Проверяем, что окно выбора города открыто и доступно", () -> {
            vkusnoITochkaMainPage
                    .tabShouldVisible()
                    .waitTabCaseCity();
        });

        step("Открываем окно выбора в поиске набираем город " + city + " и выбираем его", () -> {
            vkusnoITochkaMainPage
                    .search(city);
        });

        step("Проверяем в поле местоположения присутствие выбранного города " + city, () -> {
            vkusnoITochkaMainPage
                    .tabShouldHaveText(city);
        });

    }

}
