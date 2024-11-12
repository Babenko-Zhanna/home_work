
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BankAccountsHandler {
    private List<BankAccount> list;

    public BankAccountsHandler(List<BankAccount> list) {
        this.list = list;
    }

    private <K, V> Map<K, V> getMap (Function<BankAccount, K> keyMapper, Function<BankAccount, V> valueMapper) {
        if (list == null || list.isEmpty()) {
            return Collections.emptyMap();
        }

        return list.stream()
                .filter(ba -> ba != null)
                .collect(Collectors.toMap(keyMapper, valueMapper));
    }

    public Map<Person, Double> getMapOwnerToBalance () {
        return getMap(BankAccount :: getOwner, BankAccount :: getBalance);
    }

    public Map<String, Person> getMapIbanToOwner () {
        return getMap(BankAccount :: getIban, BankAccount :: getOwner);
    }

    public Map<String, String> getMapIbanToName () {
        return getMap(BankAccount :: getIban, ba -> ba.getOwner().getfName().charAt(0) + "." + ba.getOwner().getlName());
    }

    public static List<String> getRichestClientsNames (Map<String, BankAccount> map) {
       if (map == null || map.isEmpty()) {
           return Collections.emptyList();
       }

        //Comparator<Map.Entry<String, BankAccount>> comparator = (e1, e2) -> Double.compare(e1.getValue().getBalance(), e2.getValue().getBalance());
        return map.entrySet().stream()
                .sorted(  Comparator.comparing(   (Map.Entry<String, BankAccount> entry) -> entry.getValue().getBalance()   ).reversed()  )
                .limit(3)
                .map(e -> e.getValue().getOwner().getfName() + " " + e.getValue().getOwner().getlName())
                .toList();

    }

}
