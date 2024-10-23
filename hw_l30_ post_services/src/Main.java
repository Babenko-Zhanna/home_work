import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PostDeliveryService[] postOptions = {
                new DHL(),
                new Email(),
                new Owl()
        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите способ отправки почты:");
        for (int i = 0; i < postOptions.length; i++) {
            System.out.println(i + " - " + postOptions[i].postServiceName());
        }

        int select = scanner.nextInt();
        PostDeliveryService selectedService = postOptions[select];
        System.out.println("Вы выбрали услугу " + selectedService.postServiceName());
        send(selectedService);

        scanner.close();
    }

    public static void send (PostDeliveryService element) {
        element.sendPost();
    }

}