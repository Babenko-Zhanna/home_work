public class ProgrammerBusyException extends ProgrammerStatusException{
    @Override
    public void printMessage() {
        System.out.println("Программист занят другой задачей");
    }
}
