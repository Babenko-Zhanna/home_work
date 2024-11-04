import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<Account> accounts1 = List.of(
                new Account("DE8937040044", new BigDecimal("1523.50"), new Person("Eva", "Longoria", 49)),
                new Account("DE5320130009", new BigDecimal("845.75"), new Person("Eva", "Longoria", 49)),
                new Account("FR7630006011", new BigDecimal("22950.00"), new Person("Eva", "Longoria", 49))
        );

        List<Account> accounts2 = List.of(
                new Account("ES9121000418", new BigDecimal("3945.40"), new Person("Anna", "Schmidt", 34)),
                new Account("IT60X0542811", new BigDecimal("1320.50"), new Person("Carlos", "Gomez", 42))
        );

        List<Account> accounts3 = List.of(
                new Account("GB29NWBK60161", new BigDecimal("160.35"), new Person("Oliver", "Smith", 45)),
                new Account("BE62510007547", new BigDecimal("32600.00"), new Person("Oliver", "Smith", 45))
        );

        Map<Person, List<Account>> map1 = new HashMap<>();
        map1.put(new Person("Eva", "Longoria", 49), accounts1);
        map1.put(new Person("Anna", "Schmidt", 34), accounts2);
        map1.put(new Person("Oliver", "Smith", 45), accounts3);

        Map<Person, List<Account>> map2 = new HashMap<>();
        map2.put(new Person("Eva", "Longoria", 49), accounts1);
        map2.put(new Person("Oliver", "Smith", 45), accounts3);

        printAnswer(map1);
        printAnswer(map2);

    }

    public static boolean isNoErrorInMap(Map<Person, List<Account>> map) {
        boolean result = false;
        if (map == null) {
            return result;
        }
        for (var entry : map.entrySet()) {
            for (var element : entry.getValue()) {
                result = entry.getKey().equals(element.getOwner());
            }
        }
        return result;
    }

    public static void printAnswer (Map<Person, List<Account>> map) {
        if (isNoErrorInMap(map)) {
            System.out.println("Данные в Map корректны.");
        } else {
            System.out.println("Map содержит некорректные данные.");
        }
    }
}