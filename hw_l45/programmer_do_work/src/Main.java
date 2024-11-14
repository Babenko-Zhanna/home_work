import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Programmer programmer1 = new Programmer("Jack", "Jackson");
        programmer1.setStatusBusy();

        Programmer programmer2 = new Programmer("John", "Johnson");
        programmer2.setStatusNotAvailable();

        Programmer programmer3 = new Programmer("Rachel", "Harrington");

        List<Programmer> list = new ArrayList<>();
        list.add(programmer1);
        list.add(programmer2);
        list.add(programmer3);

        list.forEach( programmer -> {
            System.out.print(programmer + ": ");
            try{
                System.out.println(programmer.doWork());
            } catch (ProgrammerStatusException e){
                e.printMessage();
            }
        });

    }
}