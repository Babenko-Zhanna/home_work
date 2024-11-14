public class ProgrammerUnavailableNowException extends ProgrammerStatusException{
    @Override
    public void printMessage() {
        System.out.println("Программист не доступен");
    }
}
