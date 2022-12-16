package leonshop;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;



public class LeonTestBase {

    @BeforeAll
    static void setStart() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
      }
}
