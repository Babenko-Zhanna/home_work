import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Employee> list1 = List.of(
                new Employee("Jack", "Daniels", new MyDate(18,3,1956)),
                new Employee("Ethan", "Carter", new MyDate(15,1,1985)),
                new Employee("Lily", "Anderson", new MyDate(3,4,1992)),
                new Employee("Oliver", "Bennett", new MyDate(27,6,1979)),
                new Employee("Sophia", "Collins", new MyDate(12,9,1988))
        );

        List<Employee> list2 = List.of(
                new Employee("Ava", "Mitchell", new MyDate(30,11,1981)),
                new Employee("Ethan", "Carter", new MyDate(15,1,1985)),
                new Employee("Lily", "Anderson", new MyDate(5,9,1997)),
                new Employee("Lucas", "Parker", new MyDate(8,8,1990)),
                new Employee("Sophia", "Collins", new MyDate(12,9,1988))
        );

        List<Employee> list3 = List.of(
                new Employee("Lucas", "Parker", new MyDate(8,8,1990)),
                new Employee("Mia", "Sanders", new MyDate(5,12,1996)),
                new Employee("Lily", "Turner", new MyDate(3,4,1992)),
                new Employee("Oliver", "Bennett", new MyDate(27,6,1979)),
                new Employee("Noah", "Murphy", new MyDate(10,10,1975))
        );

        Set<Employee> employees = new HashSet<>(list1);
        employees.addAll(list2);
        employees.addAll(list3);


        List<Employee> employeesForTheAward = new ArrayList<>(employees);
        for (Employee employee : employeesForTheAward) {
            System.out.println(employee);
        }



    }
}