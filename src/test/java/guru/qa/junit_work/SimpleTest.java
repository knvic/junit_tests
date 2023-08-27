package guru.qa.junit_work;

import org.junit.jupiter.api.*;

public class SimpleTest {

    @Tags({
            @Tag("all"),
            @Tag("WEB"),
            @Tag("API")
    })
    @DisplayName("TEST  WEB&API ")
    @Test
    void loginTest() {
        System.out.println(" TEST Это тест WEB ");
    }

    @Tags({
            @Tag("all"),
            @Tag("smoke")
    })
       @DisplayName("TEST include all впарвапрва")
    @Test
    void loginTest1() {
        System.out.println("TEST Это тест  smoke тестирует @TAG  ");
    }

    @Tags({
            @Tag("all"),
            @Tag("API")
    })
    @DisplayName("TEST include вапролдл API")
    @Test
    void loginTest2() {
        System.out.println("TEST Это тест API ");
    }

    @Tags({
            @Tag("all"),
            @Tag("API"),
            @Tag("regression"),
            @Tag("smoke")
    })
    @DisplayName("TEST include API&regration&smok")
    @Test
    void loginTest3() {
        System.out.println("TEST Это тест API&regration&smoke ");
    }
}
