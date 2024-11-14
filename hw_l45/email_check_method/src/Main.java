import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String email = null;

        while (email == null){
            try {
                email = inputEmail(scanner);
            } catch (NotCorrectEmailFormatException e) {
                System.out.println("Некорректный формат email");
                email = null;
            }
        }

        System.out.println("Создан email: " + email);

        scanner.close();
    }

    public static String inputEmail(Scanner scanner){
        System.out.println("Введите email:");
        String result = scanner.nextLine();

        boolean resultLength = result.length()<5;
        boolean resultStart = result.startsWith("@");
        boolean resultEnd = result.endsWith("@");

        if(resultLength){
            System.out.println("Email должен состоять минимум из 5 символов");
        }
        if (resultStart){
            System.out.println("Email не может начинаться с @");
        }
        if (resultEnd){
            System.out.println("Email не может заканчиваться на @");
        }

        if(resultLength || resultStart || resultEnd) {
            throw new NotCorrectEmailFormatException();
        }

        return result;
    }
}