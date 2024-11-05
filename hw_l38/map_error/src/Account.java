import java.math.BigDecimal;

public class Account {
    private String iban;
    private BigDecimal balance;
    private Person owner;

    public Account(String iban, BigDecimal balance, Person owner) {
        this.iban = iban;
        this.balance = balance;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return String.format("%s: %s (%s)", owner, iban, balance);
    }

    public Person getOwner() {
        return owner;
    }
}
