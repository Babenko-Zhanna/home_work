import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = inputName(scanner);
        int age = inputAge(scanner);
        writeUserInfo(name, age);

        scanner.close();
    }

    public static String inputName (Scanner scanner) {
        System.out.println("Введите свое имя:");
        String name = scanner.nextLine();
        if (name == null) {
            return "";
        }
        return name;
    }

    public static int inputAge (Scanner scanner){
        int age = 0;
        while (age == 0 || age < 0) {
            System.out.println("Введите возраст (больше 0):");
            try {
                age = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Некорректный формат");
                scanner.nextLine();
            }
        }
        return age;
    }

    public static void writeUserInfo (String name, int age){
        try (BufferedWriter target = new BufferedWriter(new FileWriter("name.txt"))){
            target.write(name + " ");
            target.write(age + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Возникла ошибка");
        }
    }

}