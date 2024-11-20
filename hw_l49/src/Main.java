import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = null;
        try {
            name = fileOrDirectoryName(scanner);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        if (name != null) {
            isItFileOrDirectory(name);
        }

        scanner.close();
    }

    public static String fileOrDirectoryName (Scanner scanner){
        System.out.println("Введите название файла или папки:");
        String name = scanner.nextLine();
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("Некорректное название");
        }
        return name;
    }

    public static boolean fileOrDirectoryExists (String name){
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("Некорректное название");
        }
        File file = new File(name);
        return file.exists();
    }

    public static void isItFileOrDirectory (String name) {
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("Некорректное название");
        }
        if (!fileOrDirectoryExists(name)){
            System.out.println("Папки или файла с таким названием не найдено");
            return;
        }

        File file = new File(name);

        if (file.isDirectory()){
            System.out.println(name + " - это папка.");
            if (file.list().length == 0) {
                System.out.println("Папка пустая.");
                return;
            }
            System.out.println("Папка содержит следующие файлы: ");
            for (var f : file.listFiles()){
                System.out.println(f);
            }
        }

        if (file.isFile()){
            System.out.println(name + " - это файл.");
            System.out.println("Размер файла: " + file.length() + " байт.");
        }
    }
}