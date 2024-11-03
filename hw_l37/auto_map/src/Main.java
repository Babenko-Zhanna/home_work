import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Auto> autos = List.of(
                new Auto("A123MP 77", "Toyota", "black", 2020),
                new Auto("B456KX 99", "BMW", "white", 2019),
                new Auto("O789YP 50", "Mercedes", "gray", 2021),
                new Auto("E321PT 47", "Toyota", "navy", 2018),
                new Auto("T654OB 77", "Hyundai", "red", 2022),
                new Auto("P987AC 78", "Hyundai", "silver", 2023)
        );

        Map<String, Auto> map1 = mapByNumber(autos);
        printMap(map1);

        System.out.println("-------------------------------------------------------------------");
        Map<String, List<Auto>> map2 = mapByBrand(autos);
        printMap(map2);

    }

    public static Map<String, Auto> mapByNumber(List<Auto> list) {
        if (list == null) {
            return null;
        }
        Map<String, Auto> map = new HashMap<>();
        for (Auto auto : list) {
            map.put(auto.getNumber(), auto);
        }
        return map;
    }

    public static Map<String, List<Auto>> mapByBrand(List<Auto> list) {
        if (list == null) {
            return null;
        }
        Map<String, List<Auto>> map = new HashMap<>();
        for (Auto auto : list) {
            List<Auto> autos = map.get(auto.getBrand());
            if (autos == null) {
                autos = new ArrayList<>();
            }
            autos.add(auto);
            map.put(auto.getBrand(), autos);
        }
        return map;
    }

    public static <T, T1> void printMap(Map<T, T1> map) {
        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}