import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class BankAccountsHandler {
    private List<BankAccount> list;

    public BankAccountsHandler(List<BankAccount> list) {
        this.list = list;
    }

    private List<BankAccount> filteredList(Predicate<BankAccount> predicate) {
        if (list == null) {
            return new ArrayList<>();
        }
        if (predicate == null) {
            return list;
        }
        List<BankAccount> result = list.stream().filter(predicate).toList();
        return result;
    }

    public List<BankAccount> getAccountsLessThan(double limit) {
        List<BankAccount> result = filteredList(ba -> ba.getBalance() < limit);
        return result;
    }

    public List<BankAccount> getAccountsMoreThan(double limit) {
        List<BankAccount> result = filteredList(ba -> ba.getBalance() > limit);
        return result;
    }

    private <T> List<T> getInfo(Function<BankAccount, T> function) {
        if (list == null) {
            return new ArrayList<>();
        }
        if (function == null) {
            return (List<T>) list;
        }
        List<T> result = list.stream().map(function).toList();
        return result;
    }

    public List<Person> getOwnersList() {
        List<Person> result = getInfo(ba -> ba.getOwner());
        return result;
    }

    public List<String> getAccountsList() {
        return getInfo(ba -> {
            StringBuilder result = new StringBuilder();
            result.append(ba.getOwner().getlName()).append(" ").append(ba.getOwner().getfName().charAt(0)).append(".; IBAN: ").append(ba.getIban()).append("; ").append(ba.getOwner().getEmail());
            return result.toString();
        });
    }
}
