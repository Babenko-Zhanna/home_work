import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Jack", "Jackson", "jack@mail.de", "+785698001", new Address("52441", "Linnich", "Rurdorfer str.", "51a"));
        Person person1 = new Person("John", "Johnson", "john@mail.de", "+495632156", new Address("52000", "Tetz", "Rurallee", "15"));
        List<Person> list = new ArrayList<>();
        list.add(person);
        list.add(person1);

        List<String> emails = getInfoList(list, p -> p.getAddress().toString());
        System.out.println(emails);

    }

    public static List<String> getInfoList (List<Person> list, PersonInfoGetter getter){
        List<String> result = new ArrayList<>();
        if (list==null) {
            return result;
        }
        for (Person person : list) {
            result.add(getter.getInfo(person));
        }
        return result;
    }
}