package Ultrasport;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class UVSTest {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        open("https://ultrasport.ru//");
        //$(".sm-header__catalog").$(byText("ВИДЫ СПОРТА")).click();

    }
    @ValueSource(strings = {
            "Каталог",
            "Акции",
            "Услуги",
            "Помощь",
            "Компания",
            "Информация",
            "Магазины"})

    @ParameterizedTest(name = "Отображение поля {0} в видах спорта")
    @Tag("Critical")
    void steamMenuNewTest(String arg) {
        $(".menu-row middle-block bgcolored").shouldHave(text(arg));
    }
}
