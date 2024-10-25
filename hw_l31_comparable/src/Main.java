import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Employee[] employees = {
                new Employee(1, "O. Ivanov", 23, 550.25),
                new Employee(2, "J. Watson", 44, 1200.65),
                new Employee(3, "Sh. Holmes", 55, 1500.55),
                new Employee(4, "L. Carol", 62, 899.99),
                new Employee(5, "C. Lewis", 19,  550.15),
                new Employee(6, "H. Boss", 30, 5400.52),
        };

        Arrays.sort(employees);
        System.out.println(Arrays.toString(employees));

        System.out.println("-------------------------------------------------------------------------");


        Student[] students = {
                new Student("Jack", List.of(1.5, 2.0, 2.0, 4.3, 3.3, 3.0, 1.0)),
                new Student("John", List.of(4.5, 3.0, 4.0, 4.3, 1.3, 2.0, 3.7, 4.4)),
                new Student("Lena", List.of(2.5, 4.0, 3.0, 1.3, 2.0, 2.3, 1.0)),
                new Student("Olga", List.of(1.2, 1.3, 1.0, 2.5, 1.4, 2.0, 1.7, 1.1)),
                new Student("Ivan", List.of(1.6, 2.8, 2.4, 2.3, 3.0, 2.9, 1.9, 2.2, 2.0)),
                new Student("Rick", List.of(3.1, 2.5, 3.0, 3.3, 4.0, 3.6, 2.4)),
        };

        System.out.println(Arrays.toString(students));

        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}