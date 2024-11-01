import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println(isUnique("Hello"));
        System.out.println(isUnique("World"));
        System.out.println(isUnique("Pupil"));
        System.out.println(isUnique("Subdermatoglyphic"));
        System.out.println(isUnique("Window"));
    }

    public static boolean isUnique (String word) {
        Set<Character> checkLetters = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            checkLetters.add(word.toLowerCase().charAt(i));
        }
        return checkLetters.size() == word.length();
    }
}