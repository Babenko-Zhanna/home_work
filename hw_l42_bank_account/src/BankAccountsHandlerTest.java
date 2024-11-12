import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


class BankAccountsHandlerTest {
    private static List<BankAccount> list;
    private static BankAccountsHandler bankAccountsHandler;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>(List.of(
                new BankAccount(new Person("Jack", "Jackson", "jack@mail.com"), "DE123456789", 560.99),
                new BankAccount(new Person("John", "Johnson", "john@mail.com"), "DE123456654", 50.33),
                new BankAccount(new Person("Sam", "Simpson", "sam@mail.com"), "DE987654321", 101.15),
                new BankAccount(new Person("Peter", "Peterson", "peter@mail.com"), "DE789456123", 100150.66),
                new BankAccount(new Person("Nick", "Nickson", "nick@mail.com"), "DE654987321", 80.00)
        ));

        bankAccountsHandler = new BankAccountsHandler(list);
    }

    @Test
    void getMapOwnerToBalance_regularCase() {
        Map<Person, Double> expectedResult = Map.of(
                new Person("Jack", "Jackson", "jack@mail.com"), 560.99,
                new Person("John", "Johnson", "john@mail.com"), 50.33,
                new Person("Sam", "Simpson", "sam@mail.com"), 101.15,
                new Person("Peter", "Peterson", "peter@mail.com"), 100150.66,
                new Person("Nick", "Nickson", "nick@mail.com"), 80.00
        );
        Map<Person, Double> actualResult = bankAccountsHandler.getMapOwnerToBalance();
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void getMapOwnerToBalance_NullList() {
        bankAccountsHandler = new BankAccountsHandler(null);
        Map<Person, Double> expectedResult = Collections.emptyMap();
        Map<Person, Double> actualResult = bankAccountsHandler.getMapOwnerToBalance();
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void getMapIbanToOwner_regularCase() {
        Map<String, Person> expectedResult = Map.of(
                "DE123456789", new Person("Jack", "Jackson", "jack@mail.com"),
                "DE123456654", new Person("John", "Johnson", "john@mail.com"),
                "DE987654321", new Person("Sam", "Simpson", "sam@mail.com"),
                "DE789456123", new Person("Peter", "Peterson", "peter@mail.com"),
                "DE654987321", new Person("Nick", "Nickson", "nick@mail.com")
        );
        Map<String, Person> actualResult = bankAccountsHandler.getMapIbanToOwner();
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void getMapIbanToOwner_NullList() {
        bankAccountsHandler = new BankAccountsHandler(null);
        Map<String, Person> expectedResult = Collections.emptyMap();
        Map<String, Person> actualResult = bankAccountsHandler.getMapIbanToOwner();
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void getMapIbanToName_regularCase() {
        Map<String, String> expectedResult = Map.of(
                "DE123456789", "J.Jackson",
                "DE123456654","J.Johnson",
                "DE987654321", "S.Simpson",
                "DE789456123","P.Peterson",
                "DE654987321","N.Nickson"
        );
        Map<String, String> actualResult = bankAccountsHandler.getMapIbanToName();
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void getMapIbanToName_NullList() {
        bankAccountsHandler = new BankAccountsHandler(null);
        Map<String, String> expectedResult = Collections.emptyMap();
        Map<String, String> actualResult = bankAccountsHandler.getMapIbanToName();
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void getRichestClientsNames_regularCase() {
        Map<String, BankAccount> map = Map.of(
                "jack@mail.com", new BankAccount(new Person("Jack", "Jackson", "jack@mail.com"), "DE123456789", 560.99),
                "john@mail.com", new BankAccount(new Person("John", "Johnson", "john@mail.com"), "DE123456654", 50.33),
                "sam@mail.com", new BankAccount(new Person("Sam", "Simpson", "sam@mail.com"), "DE987654321", 101.15),
                "peter@mail.com", new BankAccount(new Person("Peter", "Peterson", "peter@mail.com"), "DE789456123", 100150.66),
                "nick@mail.com", new BankAccount(new Person("Nick", "Nickson", "nick@mail.com"), "DE654987321", 80.00)
        );

        List<String> expectedResult = List.of("Peter Peterson", "Jack Jackson", "Sam Simpson");
        List<String> actualResult = BankAccountsHandler.getRichestClientsNames(map);
        Assertions.assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    void getRichestClientsNames_nullCase() {
        List<String> expectedResult = Collections.emptyList();
        List<String> actualResult = BankAccountsHandler.getRichestClientsNames(null);
        Assertions.assertIterableEquals(expectedResult, actualResult);
    }
}