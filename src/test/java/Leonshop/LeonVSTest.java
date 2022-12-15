package Leonshop;

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

    @BeforeEach
    void setStart() {
        Configuration.browserSize = "1920x1080";
        //open("http://leon-shop.ru/");
        //$(".sm-header__catalog").$(byText("ВИДЫ СПОРТА")).click();
    }

    @ValueSource(strings = {"Каталог", "Одежда", "Обувь", "Туризм", "Бег", "Альпинизм",
            "Путешествия", "Горные лыжи", "Сноуборд"})
    @ParameterizedTest(name = "Проверка соответствия названия раздела {0} " +
            "в верхнем меню сайта надписи в хлебных крошках")
    void sportMarafonTestMenu(String section) {
        open("https://sport-marafon.ru/");
        $(".shop-menu__wrap").$(byText(section)).click();
        $(".breadcrumbs__wrap").shouldHave(text(section));
    }}
    /*
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
    void steamMenuNewTest(String arg) {

        $("#nav").shouldHave(text(arg));
    }
}*/
