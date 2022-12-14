package Ultrasport;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class UltraCSVTest {

    @BeforeEach
    void setUp1() {
        open("https://google.com");
    }



    @CsvSource(value = {
            "selenide, https://selenide.org, 1",
            "junit 5, https://junit.org, 1"
    })
    @ParameterizedTest(name = "Проверка наличия урла {1}" +
            "в результатах выдачи гугла по запросу {0}")
    @Tags({@Tag("BLOCKER"), @Tag("FEATURE")})
    void googleSearchTest(String searchQuery, String expectedUrl, int resultCount) {
        $("[name=q]").setValue(searchQuery).pressEnter();
        $("[id=search]").shouldHave(text(expectedUrl));
        $$("[id=search]").should(CollectionCondition.size(resultCount));
    }
}
