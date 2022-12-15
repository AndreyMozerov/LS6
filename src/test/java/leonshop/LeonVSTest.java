package leonshop;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LeonVSTest {




    @ValueSource(strings = {
            "Коньки",
            "Клюшки",
            "Защита",
            "Сумки",
            "Аксессуары",
            "Одежда",
            "Для фигуристов",
            "Стрит-хоккей"})

    @ParameterizedTest(name = "Отображение поля {0} в видах спорта")
    @Tag("Critical")
    void steamMenuNewTest(String inventory) {

        $("#nav").shouldHave(text(inventory));
    }
}
