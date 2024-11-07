import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Auto> list = List.of(
                new Auto("BMW", 2016, new BigDecimal("28000.00")),
                new Auto("Toyota", 2018, new BigDecimal("14000.00")),
                new Auto("Ford", 2020, new BigDecimal("20500.00"))
        );

        List<Auto> list1 = new ArrayList<>(list);
        List<Auto> list2 = sortedList(list1, (a1, a2) -> a1.getBrand().compareToIgnoreCase(a2.getBrand()));
        System.out.println(list2);
    }

    public static List<Auto> sortedList(List<Auto> list, Comparator<Auto> comparator) {
        if (list == null) {
            return new ArrayList<>();
        }
        if (comparator == null) {
            return list;
        }
        List<Auto> result = new ArrayList<>(list);
        result.sort(comparator);
        return result;
    }
}