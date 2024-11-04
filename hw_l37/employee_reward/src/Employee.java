import java.util.Objects;

public class Employee {
    private String fName;
    private String lName;

    public Employee(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    @Override
    public String toString() {
        return String.format("%s %s", fName, lName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;
        return Objects.equals(fName, employee.fName) && Objects.equals(lName, employee.lName);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(fName);
        result = 31 * result + Objects.hashCode(lName);
        return result;
    }
}
