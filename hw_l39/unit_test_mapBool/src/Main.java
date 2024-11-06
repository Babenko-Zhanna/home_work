import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<String> list = List.of("jack", "john", "georg", "alica", "john", "georg", "john", "john");
        Map<String, Boolean> result = checkDuplicate(list);
        System.out.println(result);
    }

    public static Map<String, Boolean> checkDuplicate (List<String> list) {
        Map<String, Boolean> result = new HashMap<>();
        if (list==null) {
            return result;
        }
        for (var str : list) {
            if (result.containsKey(str)) {
                result.put(str, true);
            } else {
                result.put(str, false);
            }
        }
        return result;
    }

}