import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> ints = List.of(1, 10, 22, 35, 60, 75, 50, 46, 133, 5, 18, 98);

        System.out.println(ints +  System.lineSeparator());
        System.out.println(listOfIntsMoreThan(ints, 10)  + System.lineSeparator());
        System.out.println(listOfIndexes(ints, 10));
    }

    public static List<Integer> listOfIntsMoreThan(List<Integer> list, int number) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > number) {
                result.add(list.get(i));
            }

        }
        return result;
    }

    public static List<Integer> listOfIndexes(List<Integer> list, int number) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > number) {
                result.add(i);
            }
        }
        return result;
    }


}