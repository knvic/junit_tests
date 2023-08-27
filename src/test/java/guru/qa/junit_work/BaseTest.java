package guru.qa.junit_work;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {


    @BeforeAll
    static void beforeAll() {

        System.setProperty("webdriver.chrome.driver", "C:\\QA\\chromedriver-win64\\chromedriver-win64_116\\chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");
       // Configuration.baseUrl = "https://paraavis.com";
        Configuration.browserSize = "1920x1800";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen=true;
    }

}
