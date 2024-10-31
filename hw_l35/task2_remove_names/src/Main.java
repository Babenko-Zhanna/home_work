import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Jack", "John", "Slava", "Nick", "Lena", "Mark"));
        System.out.println(names);
        removeNames(names, 3, 4);
        System.out.println(names);

    }

    public static void removeNames (List<String> list, int n, int i) {
        ListIterator<String> listIterator = list.listIterator(i);
        int counter = 0;
        while (counter != n && listIterator.hasNext()){
            list.remove(i);
            counter++;
        }
    }
}