import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = List.of(1,2,3,4,6,9,0,4,-5);
        List<Integer> list2 = List.of(1,7,5,4,6,8,0,3,-5);
        List<Boolean> newList = new ArrayList<>();

        Iterator<Integer> iterator1 = list1.iterator();
        Iterator<Integer> iterator2 = list2.iterator();

        while (iterator1.hasNext()) {
           newList.add(iterator1.next().equals(iterator2.next()));
        }

        System.out.println(list1);
        System.out.println(list2);
        System.out.println(newList);
    }
}