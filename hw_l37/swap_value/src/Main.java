import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "Bill");
        map.put("b", "Ann");

        printMap(map);
        swapValue(map,"a", "b");
        printMap(map);

        swapValue(map,"b", "j");
        printMap(map);

        swapValue(map,"k", "l");
        printMap(map);

    }

    public static void swapValue (Map<String, String> map, String key1, String key2) {
        boolean containsKey1 = map.containsKey(key1);
        boolean containsKey2 = map.containsKey(key2);
        if ( containsKey1 && containsKey2 ) {
            String temp = map.get(key1);
            map.replace(key1, map.get(key2));
            map.replace(key2, temp);
        }
        if (!containsKey1) {
            map.put(key1, "");
        }
        if (!containsKey2){
            map.put(key2, "");
        }
    }

    public static <T> void printMap (Map<T, T> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (var entry : map.entrySet()) {
            sb.append("\"").append(entry.getKey()).append("\":\"").append(entry.getValue()).append("\", ");
        }
        sb.setLength(sb.length()-2);
        sb.append("}");
        System.out.println(sb.toString());
    }
}