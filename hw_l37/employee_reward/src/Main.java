import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<Employee> list1 = List.of(
                new Employee("Jack", "Daniels"),
                new Employee("Ethan", "Carter"),
                new Employee("Lily", "Anderson"),
                new Employee("Oliver", "Bennett"),
                new Employee("Sophia", "Collins")
        );

        List<Employee> list2 = List.of(
                new Employee("Ava", "Mitchell"),
                new Employee("Ethan", "Carter"),
                new Employee("Lily", "Anderson"),
                new Employee("Lucas", "Parker"),
                new Employee("Sophia", "Collins")
        );

        List<Employee> list3 = List.of(
                new Employee("Lucas", "Parker"),
                new Employee("Mia", "Sanders"),
                new Employee("Lily", "Anderson"),
                new Employee("Oliver", "Bennett"),
                new Employee("Noah", "Murphy")
        );

        List<List<Employee>> generalList = List.of(list1, list2, list3);
        Map<Employee, Integer> employeeMap = employeeMap(generalList);
        System.out.println(employeeMap);

    }

    public static Map<Employee, Integer> employeeMap (List<List<Employee>> lists) {
        if (lists == null) {
            return null;
        }
        Map<Employee, Integer> result = new HashMap<>();
        for (List<Employee> list : lists) {
            for (Employee employee : list) {
                Integer counter = result.get(employee);
                if (counter==null) {
                    counter = 0;
                }
                counter++;
                result.put(employee, counter);
            }
        }
        return result;
    }
}