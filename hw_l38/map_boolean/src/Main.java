import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<String> stringList = List.of("hello", "cupboard", "bell", "cat", "bell", "baby", "unicorn", "baby", "hello", "baby");
        System.out.println(isRepeat(stringList));
    }

    public static Map<String, Boolean> isRepeat (List<String> list) {
        Map<String, Boolean> result = new HashMap<>();
        for (String str : list) {
            Boolean isRepeat = result.get(str);
            result.put(str, isRepeat==null ? false : true);
        }
        return result;
    }
}