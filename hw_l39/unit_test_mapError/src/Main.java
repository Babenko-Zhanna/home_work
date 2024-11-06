import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Jack", "Jackson");
        Person p2 = new Person("John", "Johnson");
        Person p3 = new Person("Nick", "Nickson");
        Person p4 = new Person("Kit", "Nickson");

        List<Account> accounts1 = List.of(
                new Account("DE10001", new BigDecimal("10000.00"), p1),
                new Account("DE10002", new BigDecimal("10001.00"), p1),
                new Account("DE10003", new BigDecimal("10002.00"), p1),
                new Account("DE10004", new BigDecimal("10003.00"), p1),
                new Account("DE10005", new BigDecimal("10004.00"), p1)
        );

        List<Account> accounts2 = List.of(
                new Account("DE10006", new BigDecimal("10005.00"), p2),
                new Account("DE10007", new BigDecimal("10006.00"), p2),
                new Account("DE10008", new BigDecimal("10007.00"), p2),
                new Account("DE10009", new BigDecimal("10008.00"), p2),
                new Account("DE10010", new BigDecimal("10009.00"), p2)
        );

        List<Account> accounts3 = List.of(
                new Account("DE10011", new BigDecimal("10061.00"), p3),
                new Account("DE10012", new BigDecimal("10091.00"), p3),
                new Account("DE10013", new BigDecimal("100101.00"), p3)
        );

        List<Account> accounts4 = List.of(
                new Account("DE10014", new BigDecimal("10061.20"), p4),
                new Account("DE10015", new BigDecimal("10091.20"), p4),
                new Account("DE10016", new BigDecimal("100101.20"), p4)
        );

        Map<Person, List<Account>> map = new HashMap<>();
        map.put(p1, accounts1);
        map.put(p2, accounts2);
        map.put(p3, accounts3);
        map.put(p4, accounts4);

        printMap(map);
        System.out.println("isMapCorrect: " + isMapCorrect(map));

    }

    public static boolean isMapCorrect(Map<Person, List<Account>> map) {
       if (map == null) {
           return false;
       }
        for (var entry : map.entrySet()) {
            if(isErrorInAccountListByPerson(entry.getKey(), entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    private static boolean isErrorInAccountListByPerson(Person owner, List<Account> list) {
        for (Account account : list) {
            if (!account.getOwner().equals(owner)) {
                return true;
            }
        }
        return false;
    }

    public static <K, V> void printMap (Map<K, V> map) {
        if (map == null) {
            return;
        }
        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}