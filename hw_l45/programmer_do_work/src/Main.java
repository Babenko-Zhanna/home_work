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
            System.out.println(programmer + ": ");
            try{
                System.out.println(programmer.doWork("Implement commenting feature"));
            } catch (ProgrammerStatusException e){
                e.printMessage();
            }
            System.out.println();
        });

        //--------------------------------------------------------------------------------------

        programmer3.setStatusBusy();
        TeamLead teamLead = new TeamLead("Sam", "Simpson", list);
        //teamLead.setStatusUnavailable();
        try {
            System.out.println(teamLead.doTask("Implement commenting feature"));
        } catch (TeamMemberStatusException e){
            e.printMessage();
        }

    }
}