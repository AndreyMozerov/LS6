package leonshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LeonMSTest extends LeonTestBase {

    @BeforeEach
    void setUp2() {
        open("http://leon-shop.ru/");
   }
    static Stream<Arguments> gamerButtonsTest() {
        return Stream.of(
                Arguments.of("Игрок", List.of("Коньки", "Клюшки", "Защита", "Сумки", "Аксессуары",
                        "Одежда", "Для фигуристов", "Стрит-хоккей", "Экипировка судьи", "Сувениры", "Станки",
                        "Подарочный сертификат", "ФУТБОЛ", "Флорбол")),
                Arguments.of("Вратарь", List.of("Коньки вратаря", "Клюшки вратаря", "Защита вратаря",
                        "Сумки вратаря", "Аксессуары вратаря", "Одежда", "Сувениры", "Подарочный сертификат"))
        );
    }
    @MethodSource("gamerButtonsTest")
    @ParameterizedTest(name = "Проверка наличия кнопок из списка {1} на сайте leon-shop в локали {0}")
    @Tag("BLOCKER")
    void gamerButtonsTest(String gamer, List<String> buttons) {
        $(".toolbar_game").$(byText(gamer)).click();
        $(".selectedTxt").click();
        $(".newList").$$("li").shouldHave(texts(buttons));
    }
}
