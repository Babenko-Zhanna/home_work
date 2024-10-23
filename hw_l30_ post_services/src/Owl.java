public class Owl implements PostDeliveryService{
    @Override
    public void sendPost() {
        System.out.println("Приручи сову.");
        System.out.println("Отдай сове конверт с письмом.");
        System.out.println("Объясни сове куда лететь.");
    }

    @Override
    public String postServiceName() {
        return "Owl Airlines";
    }
}
