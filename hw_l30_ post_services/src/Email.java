public class Email implements PostDeliveryService{
    @Override
    public void sendPost() {
        System.out.println("Создай email.");
        System.out.println("Введи адрес получателя.");
        System.out.println("Нажми \"отправить\"");
    }

    @Override
    public String postServiceName() {
        return "Email";
    }
}
