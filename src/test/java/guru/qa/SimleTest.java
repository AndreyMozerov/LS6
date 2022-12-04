package guru.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@Disabled
public class SimleTest {

    @Disabled("code 5465465")
    @DisplayName("PR 3>2")
    @Test
    void firstTest(){
        assertEquals(1,1,"1 не равен тому, что получили");
        assertTrue(3>2);
    }


    @DisplayName("PR 3>1")
    @Test
    void secondTest(){
        assertEquals(1,1,"1 не равен тому, что получили");
        assertTrue(3>1);
    }
}
