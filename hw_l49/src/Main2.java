import java.io.*;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        createDirectory("temp");
        String fileName = "temp\\input.txt";
        try {
            inputStringsFile(scanner, fileName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            printFileContent(fileName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void createDirectory(String name) {
        File file = new File(name);
        file.mkdir();
    }

    public static void inputStringsFile(Scanner scanner, String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            throw new IllegalArgumentException("Некорректное название файла");
        }
        String input;
        try (BufferedWriter target = new BufferedWriter(new FileWriter(fileName, false))) {
            while (true) {
                System.out.println("Введите строку для записи (введите \"-exit\" для завершения программы):");
                input = scanner.nextLine();
                if (input.equals("-exit")) break;
                target.write(input + System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл " + fileName + " не найден");
        } catch (IOException e) {
            System.out.println("Произошла ошибка");
        }
    }

    public static void printFileContent(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            throw new IllegalArgumentException("Некорректное название файла");
        }
        try (BufferedReader source = new BufferedReader(new FileReader(fileName))) {
            source.lines().forEach(s -> System.out.println(s));
        } catch (FileNotFoundException e) {
            System.out.println("Файл " + fileName + " не найден");
        } catch (IOException e) {
            System.out.println("Произошла ошибка");
        }
    }
}

