import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MainTest {
    private static List<Person> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>(
                List.of(
                        new Person("Jack", "Jackson", "jack@mail.de", "+785698001", new Address("52441", "Linnich", "Rurdorfer str.", "51a")),
                        new Person("John", "Johnson", "john@mail.de", "+495632156", new Address("52000", "Tetz", "Rurallee", "15")),
                        new Person("Lena", "Hudson", "lena@mail.de", "+497856985", new Address("46523", "Potsdam", "Blumenstraße", "125/1")),
                        new Person("Oleg", "Ivanov", "oleg@mail.de", "+335698567", new Address("48002", "Reydt", "Julicher str.", "13b"))
                )
        );
    }

    @Test
    @DisplayName("getInfoList: list Person -> возвращаем List<String> с ФИО")
    void getInfoList_getNames() {
        List<String> expectedResult = List.of("Jack Jackson", "John Johnson", "Lena Hudson", "Oleg Ivanov");
        List<String> actualResult = Main.getInfoList(list, p -> p.getfName() + " " + p.getlName());
        Assertions.assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("getInfoList: list Person -> возвращаем List<String> с email")
    void getInfoList_getEmails() {
        List<String> expectedResult = List.of("jack@mail.de", "john@mail.de", "lena@mail.de", "oleg@mail.de");
        List<String> actualResult = Main.getInfoList(list, p -> p.getEmail());
        Assertions.assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("getInfoList: list Person -> возвращаем List<String> с номерами телефонов")
    void getInfoList_getPhones() {
        List<String> expectedResult = List.of("+785698001", "+495632156", "+497856985", "+335698567");
        List<String> actualResult = Main.getInfoList(list, p -> p.getPhone());
        Assertions.assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("getInfoList: list Person -> возвращаем List<String> с адресами")
    void getInfoList_getAddress() {
        List<String> expectedResult = List.of("52441 Linnich Rurdorfer str. 51a", "52000 Tetz Rurallee 15", "46523 Potsdam Blumenstraße 125/1", "48002 Reydt Julicher str. 13b");
        List<String> actualResult = Main.getInfoList(list, p -> p.getAddress().toString());
        Assertions.assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    void getInfoList_ListNull () {
        List<String> expectedResult = new ArrayList<>();
        List<String> actualResult = Main.getInfoList(null, p -> p.getPhone());
        Assertions.assertIterableEquals(expectedResult, actualResult);
    }
}