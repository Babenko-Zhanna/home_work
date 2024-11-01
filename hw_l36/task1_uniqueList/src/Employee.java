import java.util.Objects;

public class Employee {
    private String fName;
    private String lName;
    private MyDate birth;

    public Employee(String fName, String lName, MyDate birth) {
        this.fName = fName;
        this.lName = lName;
        this.birth = birth;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%s)", fName, lName, birth);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;
        return Objects.equals(fName, employee.fName) && Objects.equals(lName, employee.lName) && Objects.equals(birth, employee.birth);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(fName);
        result = 31 * result + Objects.hashCode(lName);
        result = 31 * result + Objects.hashCode(birth);
        return result;
    }
}
