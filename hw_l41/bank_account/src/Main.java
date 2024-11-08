import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<BankAccount> list = new ArrayList<>(List.of(
                new BankAccount(new Person("Jack", "Jackson", "jack@mail.com"), "DE123456789", 560.99),
                new BankAccount(new Person("John", "Johnson", "john@mail.com"), "DE123456654", 50.33),
                new BankAccount(new Person("Sam", "Simpson", "sam@mail.com"), "DE987654321", 101.15),
                new BankAccount(new Person("Peter", "Peterson", "peter@mail.com"), "DE789456123", 100150.66),
                new BankAccount(new Person("Nick", "Nickson", "nick@mail.com"), "DE654987321", 80.00),
                new BankAccount(new Person("Lena", "Ivanova", "lena@mail.com"), "DE654321987", 250650.00),
                new BankAccount(new Person("Kate", "Hudson", "kate@mail.com"), "DE951462785", 10.01)
        ));

        BankAccountsHandler bankAccountsHandler = new BankAccountsHandler(list);
        List<BankAccount> bankAccounts = bankAccountsHandler.filteredList(ba -> ba.getBalance() < 100);

        System.out.println("Bank accounts with balance < 100");
        bankAccounts.forEach((ba) -> System.out.println(ba));

        List<Person> ownersList = bankAccountsHandler.getInfo(ba -> ba.getOwner());

        System.out.println();
        System.out.println("List of owners");
        ownersList.forEach((p) -> System.out.println(p));

        List<BankAccount> filteredList = bankAccountsHandler.filteredList(ba -> ba.getBalance() > 100000);
        BankAccountsHandler bankAccountsHandler1 = new BankAccountsHandler(filteredList);
        List<String> accountsList = bankAccountsHandler1.getInfo(ba -> {
            StringBuilder result = new StringBuilder();
            result.append(ba.getOwner().getlName()).append(" ").append(ba.getOwner().getfName().charAt(0)).append(".; IBAN: ").append(ba.getIban()).append("; ").append(ba.getOwner().getEmail());
            return result.toString();
        });

        System.out.println();
        System.out.println("Bank accounts with balance > 100000");
        accountsList.forEach((ba)-> System.out.println(ba));
    }
}