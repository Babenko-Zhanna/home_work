import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;


class MainTest {
    private static List<Person> personList;

    @BeforeEach
    void setUp() {
        personList = List.of(
                new Person("Jack", "Jackson", 20, "Berlin"),
                new Person("John", "Johnson", 25, "Hanover"),
                new Person("Nick", "Nickson", 45, "Berlin"),
                new Person("Kate", "Hudson", 20, "Berlin"),
                new Person("Sam", "Simpson", 29, "Bremen"),
                new Person("Tom", "Hardy", 45, "Hanover")
        );
    }

    @Test
    void listStringToMap_regularCase() {
        List<String> list = List.of("name:Jack", "length:8", "year:2000", "name:Kate", "city:Berlin", "name:Nick", "length:5", "city:Potsdam", "name:Lena", "year:2020");
        Map<String, String> expectedResult = Map.of("name", "Jack,Kate,Nick,Lena",
                "length", "8,5",
                "year", "2000,2020",
                "city", "Berlin,Potsdam");
        Map<String, String> actualResult = Main.listStringToMap(list);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void listStringToMap_nullList(){
        Map<String, String> expectedResult = Collections.emptyMap();
        Map<String, String> actualResult = Main.listStringToMap(null);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void sumAgeByCity_regularCase() {
        int expectedResult = 85;
        int actualResult = Main.sumAgeByCity(personList, "Berlin");
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void sumAgeByCity_negativeCase() {
        int expectedResult = 0;
        int actualResult = Main.sumAgeByCity(personList, "London");
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void sumAgeByCity_nullCase() {
        int expectedResult = 0;
        int actualResult = Main.sumAgeByCity(null, null);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void countByCity_regularCase() {
        long expectedResult = 3;
        long actualResult = Main.countByCity(personList, "Berlin");
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void countByCity_negativeCase() {
        long expectedResult = 0;
        long actualResult = Main.countByCity(personList, "London");
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void countByCity_nullCase() {
        long expectedResult = 0;
        long actualResult = Main.countByCity(null, null);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void averageAgeByCity_regularCase() {
        int expectedResult = 28;
        int actualResult = Main.averageAgeByCity(personList, "Berlin");
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void averageAgeByCity_negativeCase() {
        int expectedResult = 0;
        int actualResult = Main.averageAgeByCity(personList, "London");
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void personNumberByAge_regularCase() {
        Map<Integer, Integer> expectedResult = Map.of(20, 2, 25, 1, 45, 2, 29, 1);
        Map<Integer, Integer> actualResult = Main.personNumberByAge(personList);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void personNumberByAge_nullCase() {
        Map<Integer, Integer> expectedResult = Collections.emptyMap();
        Map<Integer, Integer> actualResult = Main.personNumberByAge(null);
        Assertions.assertEquals(expectedResult, actualResult);
    }
}