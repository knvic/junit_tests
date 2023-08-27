package guru.qa.junit_work.tests;



import com.codeborne.selenide.impl.Arguments;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import guru.qa.junit_work.BaseTest;
import guru.qa.junit_work.pages.Locale;
import guru.qa.junit_work.pages.ParameterizedPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.sleep;

public class ParameterizedSimpleTest extends BaseTest {

    ParameterizedPage parameterizedPage = new ParameterizedPage();




    static Stream<Arguments> jetbrainsSiteStreamSearchTest() {
        return Stream.of(
                Arguments.of("Add Breakpoint"),
                Arguments.of("Search Everywhere")
        );
    }





    @Tag("all")
    @Test
    void parameterizedSimpleTest() {
        parameterizedPage
                .openPage()
              .setLocale(Locale.en);
            }
}
