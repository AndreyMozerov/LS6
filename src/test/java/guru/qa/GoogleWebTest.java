package guru.qa;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GoogleWebTest {

    @BeforeEach
    void setup() {
        open("https://google.com");
    }
    @CsvSource({
        "selenide,    https://selenide.org",
        "junit5,      https://junit.org"
    })

    @ParameterizedTest(name="Проверка наличия url {1}" +
            "в результатах выдачи гугла по запросу {0}")
    @Tags({@Tag("BLOCKER"),@Tag("FEATURE")})

    void googleSearchTest(String searchQuery, String expectedUrl) {

        $("[name=q]").setValue(searchQuery).pressEnter();
        $("[id=search]").shouldHave(text(expectedUrl));

    }


}
