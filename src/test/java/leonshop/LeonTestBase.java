package leonshop;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;

import static com.codeborne.selenide.Selenide.open;

public class LeonTestBase {

    @BeforeAll
    static void setStart() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
      }
}
