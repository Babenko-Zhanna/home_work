import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainTest {

    @Test
    @DisplayName("checkDuplicate(): в листе есть повторяющиеся строки -> возвращаем Map<String, Boolean>")
    public void checkDuplicate_ifListHasRepeatedString() {
        List<String> list = List.of("jack", "john", "jack", "john", "jack");
        Map<String, Boolean> expectedResult = Map.of("jack", true, "john", true);

        Map<String, Boolean> actualResult = Main.checkDuplicate(list);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("checkDuplicate(): в листе нет повторяющихся строк -> возвращаем Map<String, Boolean>")
    public void checkDuplicate_ifListHasNoRepeatedString() {
        List<String> list = List.of("jack", "john", "nick", "lena");
        Map<String, Boolean> expectedResult = Map.of("jack", false, "john", false, "nick", false, "lena", false);

        Map<String, Boolean> actualResult = Main.checkDuplicate(list);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("checkDuplicate(): лист null -> возвращаем пустой Map")
    public void checkDuplicate_ifListNull() {
        Map<String, Boolean> expectedResult = new HashMap<>();

        Map<String, Boolean> actualResult = Main.checkDuplicate(null);
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
