import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List<String> names = null;
        try (BufferedReader source = new BufferedReader(new FileReader("nameList.txt"))){
            names = uniqueNames(source);
        } catch (IOException e) {
            System.out.println("Возникла ошибка");
        }

        System.out.println(names);

    }

    public static List<String> uniqueNames (BufferedReader source){
        return source.lines().distinct().toList();
    }
}
