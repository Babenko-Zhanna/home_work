public class AllProgrammersAreBusyNowException extends ProgrammerStatusException{
    @Override
    public void printMessage() {
        System.out.println("Нам не хватает программистов!");
    }
}
