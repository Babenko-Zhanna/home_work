import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class BankAccountsHandler {
    private List<BankAccount> list;

    public BankAccountsHandler(List<BankAccount> list) {
        this.list = list;
    }

    public List<BankAccount> filteredList (Predicate<BankAccount> predicate) {
        if (list == null) {
            return new ArrayList<>();
        }
        if (predicate == null) {
            return list;
        }
        List<BankAccount> result = list.stream().filter(predicate).toList();
        return result;
    }

    public <T> List<T> getInfo (Function<BankAccount, T> function) {
        if (list == null) {
            return new ArrayList<>();
        }
        if (function == null) {
            return (List<T>) list;
        }
        List<T> result = list.stream().map(function).toList();
        return result;
    }
}
