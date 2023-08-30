package guru.qa.junit_work.tests;


import guru.qa.junit_work.BaseTest;
import guru.qa.junit_work.pages.ParameterizedCityPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.logevents.SelenideLogger.step;


public class ParameterizedCityTest extends BaseTest {

    ParameterizedCityPage parameterizedCityPage = new ParameterizedCityPage();


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
