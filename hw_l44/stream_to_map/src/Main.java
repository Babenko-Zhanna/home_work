import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<String> list = List.of("name:Jack", "length:8", "year:2000", "name:Kate", "city:Berlin", "name:Nick", "length:5", "city:Potsdam", "name:Lena", "year:2020");
        Map<String, String> collect = listStringToMap(list);
        System.out.println(collect);

        List<Person> personList = List.of(
                new Person("Jack", "Jackson", 20, "Berlin"),
                new Person("John", "Johnson", 25, "Hanover"),
                new Person("Nick", "Nickson", 45, "Berlin"),
                new Person("Kate", "Hudson", 20, "Berlin"),
                new Person("Sam", "Simpson", 29, "Bremen"),
                new Person("Tom", "Hardy", 45, "Hanover")
        );

        System.out.println(averageAgeByCity(personList, "Berlin"));
        System.out.println(personNumberByAge(personList));
    }

    public static Map<String, String> listStringToMap(List<String> list) {
        if (list == null || list.isEmpty()) {
            return Collections.emptyMap();
        }
        return list.stream()
                .map(s -> s.split(":"))
                .collect(Collectors.toMap(arr -> arr[0], arr -> arr[1], (s1, s2) -> s1 + "," + s2));
    }

    public static int sumAgeByCity(List<Person> list, String city) {
        if (list==null || list.isEmpty() || city == null) {
            return 0;
        }
        Optional<Integer> sum = list.stream()
                .filter(p -> p.getCity().equalsIgnoreCase(city))
                .map(Person::getAge)
                .reduce((i1, i2) -> i1 + i2);

        return sum.orElse(0);
    }

    public static long countByCity(List<Person> list, String city){
        if (list==null || list.isEmpty() || city == null) {
            return 0;
        }
        return list.stream()
                .filter(p -> p.getCity().equalsIgnoreCase(city))
                .count();
    }

    public static int averageAgeByCity(List<Person> list, String city){
        long count = countByCity(list, city);
        if (count==0) {
            return 0;
        }
        int sumAge = sumAgeByCity(list, city);
        return  (int) (sumAge / count);
    }

    public static Map<Integer, Integer> personNumberByAge(List<Person> list) {
        if (list==null || list.isEmpty()){
            return Collections.emptyMap();
        }
        return list.stream()
                .collect(Collectors.toMap(Person::getAge, p -> 1, Integer::sum) );
    }
}