import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class MainTest {
    private static List<Auto> list;

    private static Auto auto1 = new Auto("BMW", 2016, new BigDecimal("28000.00"));
    private static Auto auto2 = new Auto("Toyota", 2018, new BigDecimal("14000.00"));
    private static Auto auto3 = new Auto("Ford", 2020, new BigDecimal("20500.00"));
    private static Auto auto4 = new Auto("Honda", 2019, new BigDecimal("16000.00"));
    private static Auto auto5 = new Auto("Mercedes", 2017, new BigDecimal("35500.00"));
    private static Auto auto6 = new Auto("Audi", 2021, new BigDecimal("31000.00"));

    @BeforeEach
    void setUp() {
        list = new ArrayList<>(List.of(auto1, auto2, auto3, auto4, auto5, auto6));
    }

    @Test
    void sortedList_byId() {
        List<Auto> expectedResult = list;
        List<Auto> actualResult = Main.sortedList(list, (a1, a2) -> a1.getId() - a2.getId());
        Assertions.assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    void sortedList_byBrand() {
        List<Auto> expectedResult = List.of(auto6, auto1, auto3, auto4, auto5, auto2);
        List<Auto> actualResult = Main.sortedList(list, (a1, a2) -> a1.getBrand().compareToIgnoreCase(a2.getBrand()));
        Assertions.assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    void sortedList_byYear() {
        List<Auto> expectedResult = List.of(auto1, auto5, auto2, auto4, auto3, auto6);
        List<Auto> actualResult = Main.sortedList(list, (a1, a2) -> a1.getYear() - a2.getYear());
        Assertions.assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    void sortedList_byYear_reversed() {
        List<Auto> expectedResult = List.of(auto6, auto3, auto4, auto2, auto5, auto1);
        Comparator<Auto> comparator = (a1, a2) -> a1.getYear() - a2.getYear();
        List<Auto> actualResult = Main.sortedList(list, comparator.reversed());
        Assertions.assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    void sortedList_byPrice() {
        List<Auto> expectedResult = List.of(auto2, auto4, auto3, auto1, auto6, auto5);
        List<Auto> actualResult = Main.sortedList(list, (a1, a2) -> a1.getPrice().compareTo(a2.getPrice()));
        Assertions.assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    void sortedList_byPrice_reversed() {
        List<Auto> expectedResult = List.of(auto5, auto6, auto1, auto3, auto4, auto2);
        Comparator<Auto> comparator = (a1, a2) -> a1.getPrice().compareTo(a2.getPrice());
        List<Auto> actualResult = Main.sortedList(list, comparator.reversed());
        Assertions.assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("sortedList: list null -> возвращаем пустой лист")
    void sortedList_ListIsNull() {
        List<Auto> expectedResult = new ArrayList<>();
        List<Auto> actualResult = Main.sortedList(null, (a1, a2) -> a1.getPrice().compareTo(a2.getPrice()));
        Assertions.assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("sortedList: list и компаратор null -> возвращаем пустой лист")
    void sortedList_ListAndComparatorNull() {
        List<Auto> expectedResult = new ArrayList<>();
        List<Auto> actualResult = Main.sortedList(null, null);
        Assertions.assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("sortedList: comparator null -> возвращаем исходный лист")
    void sortedList_comparatorIsNull() {
        List<Auto> expectedResult = list;
        List<Auto> actualResult = Main.sortedList(list, null);
        Assertions.assertIterableEquals(expectedResult, actualResult);
    }
}