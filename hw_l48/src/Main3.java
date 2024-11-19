import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main3 {
    public static void main(String[] args) {
        List<Person> personList = null;
        try (BufferedReader source = new BufferedReader(new FileReader("persons.txt"))){
            personList = getPersonList(source);
        } catch (IOException e) {
            System.out.println("Возникла ошибка");
        }

        System.out.println(personList);
    }

    public static List<Person> getPersonList (BufferedReader source){
        return source.lines()
                .map(str -> new Person(str))
                .toList();
    }
}
