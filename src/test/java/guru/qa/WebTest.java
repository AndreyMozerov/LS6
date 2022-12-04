package guru.qa;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebTest {

    @BeforeEach
    void setup() {
        open("https://google.com");
    }

    @DisplayName("Проверка наличия url 'https://selenide.org'" +
            "в результатах выдачи гугла по запросу 'selenide'")
    @Test
    @Tag("BLOCKER")
    void googleTest() {

        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("https://selenide.org"));

    }
    @Disabled("1")
    @DisplayName("Проверка  popup загрузки фото")
    @Test
    //@Tag("BLOCKER")
    void googlePhotoTest(){

        $("img[alt='Поиск с помощью камеры']").click();
        $(byText("Выполните поиск по изображению в Google Объективе")).shouldBe(visible );
      }
}
