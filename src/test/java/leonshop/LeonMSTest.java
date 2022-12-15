package leonshop;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LeonMSTest {

    @BeforeEach
    void setUp1() {
        Configuration.browserSize = "1920x1080";
        open("http://leon-shop.ru/");

    }


    static Stream<Arguments> gamerButtonsTest() {
        return Stream.of(
                Arguments.of("Игрок", List.of("Коньки", "Клюшка", "Защита", "Суммки", "Аксессуары",
                        "Одежда", "Для фигуристов", "Стрит-хоккей", "Экипировка судьи", "Сувениры", "Станки",
                        "Подарочные сертификаты", "Футбол", "Флорбол")),
                Arguments.of("Вратарь", List.of("Коньки вратаря", "Клюшки вратаря", "Защита вратаря",
                        "Сумки вратаря", "Аксессуары вратаря", "Одежда", "Сувениры", "Подарочный сертификат"))
        );
    }

    @MethodSource("gamerButtonsTest")
    @ParameterizedTest(name = "Проверка наличия кнопок из списка {1} на сайте leon-shop в локали {0}")
    @Tag("BLOCKER")
    void selenideButtonsTest(String locale, List<String> buttons) {
        $$(".toolbar_game").find(text(locale)).click();
        $(".selectedTxt").click();
        $$(".newList").shouldHave(texts(buttons));
    }
}
