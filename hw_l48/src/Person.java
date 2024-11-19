import java.io.BufferedReader;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String infoStr) {
        String[] split = infoStr.split("\\W");
        this.name = split[0];
        this.age = Integer.parseInt(split[1]);
    }

    @Override
    public String toString() {
        return String.format("%s (%d)", name, age);
    }
}
