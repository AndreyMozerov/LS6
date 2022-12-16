package leonshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LeonCSVTest extends LeonTestBase {

    @BeforeEach
     void setUp3() {
        open("http://leon-shop.ru");
    }

    @CsvSource(value = {
            "Одежда, Костюмы спортивные",
            "Аксессуары, Протекторы горла",
            "Станки, BLADEMASTER"
    })
    @ParameterizedTest(name = "Проверка существования подкатегории {1}" +
            "в категории {0}")
    @Tags({@Tag("BLOCKER"), @Tag("FEATURE")})
    void leonSearchTest(String a, String b) {
        $("#nav").$(byText(a)).click();
        $(".price").shouldHave(text(b));
    }
}
