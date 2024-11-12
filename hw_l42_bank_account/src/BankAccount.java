import java.util.Objects;

public class BankAccount {
    private Person owner;
    private String iban;
    private double balance;

    public BankAccount(Person owner, String iban, double balance) {
        this.owner = owner;
        this.iban = iban;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return String.format("%s: %s - %.2f", owner, iban, balance);
    }

    public Person getOwner() {
        return owner;
    }

    public String getIban() {
        return iban;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankAccount that = (BankAccount) o;
        return Double.compare(balance, that.balance) == 0 && Objects.equals(owner, that.owner) && Objects.equals(iban, that.iban);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(owner);
        result = 31 * result + Objects.hashCode(iban);
        result = 31 * result + Double.hashCode(balance);
        return result;
    }

}
