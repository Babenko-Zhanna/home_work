public class DHL implements PostDeliveryService{

    @Override
    public void sendPost() {
        System.out.println("Помести письмо в конверт.");
        System.out.println("Наклей марку.");
        System.out.println("Передай письмо почтальону.");
    }
}
