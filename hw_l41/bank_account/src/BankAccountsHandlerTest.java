import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BankAccountsHandlerTest {
    private static List<BankAccount> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>(List.of(
                new BankAccount(new Person("Jack", "Jackson", "jack@mail.com"), "DE123456789", 560.99),
                new BankAccount(new Person("John", "Johnson", "john@mail.com"), "DE123456654", 50.33),
                new BankAccount(new Person("Sam", "Simpson", "sam@mail.com"), "DE987654321", 101.15),
                new BankAccount(new Person("Peter", "Peterson", "peter@mail.com"), "DE789456123", 100150.66),
                new BankAccount(new Person("Nick", "Nickson", "nick@mail.com"), "DE654987321", 80.00),
                new BankAccount(new Person("Lena", "Ivanova", "lena@mail.com"), "DE654321987", 250650.00),
                new BankAccount(new Person("Kate", "Hudson", "kate@mail.com"), "DE951462785", 10.01)
        ));
    }

    @Test
    @DisplayName("filteredList: список счетов -> список счетов с балансом больше 100")
    void filteredList_regularCase() {
        BankAccountsHandler bankAccountsHandler = new BankAccountsHandler(list);
        List<BankAccount> actualResult = bankAccountsHandler.filteredList(ba -> ba.getBalance() < 100);
        boolean isFiltered = true;
        for (BankAccount acc : actualResult) {
            if (acc.getBalance() >= 100) {
                isFiltered = false;
            }
        }
        boolean finalIsFiltered = isFiltered;
        int size = 0;
        for (BankAccount acc : list) {
            if (acc.getBalance() < 100) {
                size++;
            }
        }
        int finalSize = size;
        Assertions.assertAll(
                () -> Assertions.assertTrue(finalIsFiltered),
                () -> Assertions.assertTrue(finalSize == actualResult.size())

        );

    }

    @Test
    @DisplayName("filteredList: список счетов -> пустой список (нет элементов, соответствующих условию)")
    void filteredList_negativeCase() {
        list.get(1).setBalance(100.33);
        list.get(4).setBalance(105.33);
        list.get(6).setBalance(106.33);
        BankAccountsHandler bankAccountsHandler = new BankAccountsHandler(list);
        List<BankAccount> actualResult = bankAccountsHandler.filteredList(ba -> ba.getBalance() < 100);
        Assertions.assertTrue(actualResult.isEmpty());
    }

    @Test
    @DisplayName("filteredList: список null -> пустой список")
    void filteredList_listNull() {
        BankAccountsHandler bankAccountsHandler = new BankAccountsHandler(null);
        List<BankAccount> actualResult = bankAccountsHandler.filteredList(ba -> ba.getBalance() < 100);
        Assertions.assertTrue(actualResult.isEmpty());
    }

    @Test
    @DisplayName("getInfo: список счетов -> список владельцев счетов")
    void getInfo_regularCase() {
        List<Person> expectedResult = List.of(
                new Person("Jack", "Jackson", "jack@mail.com"),
                new Person("John", "Johnson", "john@mail.com"),
                new Person("Sam", "Simpson", "sam@mail.com"),
                new Person("Peter", "Peterson", "peter@mail.com"),
                new Person("Nick", "Nickson", "nick@mail.com"),
                new Person("Lena", "Ivanova", "lena@mail.com"),
                new Person("Kate", "Hudson", "kate@mail.com")
        );

        BankAccountsHandler bankAccountsHandler = new BankAccountsHandler(list);
        List<Person> actualResult = bankAccountsHandler.getInfo(ba -> ba.getOwner());
        Assertions.assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("getInfo: список null -> пустой список")
    void getInfo_listNull() {
        BankAccountsHandler bankAccountsHandler = new BankAccountsHandler(null);
        List<Person> actualResult = bankAccountsHandler.getInfo(ba -> ba.getOwner());
        Assertions.assertTrue(actualResult.isEmpty());
    }
}