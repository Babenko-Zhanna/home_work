import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

class MainTest {

    @Test
    @DisplayName("isMapCorrect: Map с корректными данными -> возвращаем True")
    void isMapCorrect_returnTrue() {
        Person person1 = new Person("Rick", "Martin");
        Person person2 = new Person("Kate", "Huston");

        List<Account> list1 = List.of(
                new Account("DE123456", new BigDecimal("123.55"), person1),
                new Account("DE789123", new BigDecimal("1235.55"), person1)
        );

        List<Account> list2 = List.of(
                new Account("DE456789", new BigDecimal("450.25"), person2),
                new Account("DE510023", new BigDecimal("1001.66"), person2)
        );
        Map<Person, List<Account>> map = Map.of(person1, list1, person2, list2);
        boolean actualResult = Main.isMapCorrect(map);
        Assertions.assertTrue(actualResult);
    }

    @Test
    @DisplayName("isMapCorrect: Map с некорректными данными -> возвращаем False")
    void isMapCorrect_returnFalse() {
        Person person1 = new Person("Rick", "Martin");
        Person person2 = new Person("Kate", "Huston");

        List<Account> list1 = List.of(
                new Account("DE456789", new BigDecimal("450.25"), person2),
                new Account("DE789123", new BigDecimal("1235.55"), person1)
        );

        List<Account> list2 = List.of(
                new Account("DE123456", new BigDecimal("123.55"), person1),
                new Account("DE510023", new BigDecimal("1001.66"), person2)
        );
        Map<Person, List<Account>> map = Map.of(person1, list1, person2, list2);
        boolean actualResult = Main.isMapCorrect(map);
        Assertions.assertFalse(actualResult);
    }

    @Test
    @DisplayName("isMapCorrect: Map null -> возвращаем False")
    void isMapCorrect_MapIsNull_returnFalse() {
        boolean actualResult = Main.isMapCorrect(null);
        Assertions.assertFalse(actualResult);
    }
}