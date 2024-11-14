import java.util.List;
import java.util.Optional;

public class TeamLead {
    private String fName;
    private String lName;
    private String status = "available";
    private List<Programmer> team;

    public TeamLead(String fName, String lName, List<Programmer> team) {
        this.fName = fName;
        this.lName = lName;
        this.team = team;
    }

    @Override
    public String toString() {
        return String.format("%s %s (status: %s)", fName, lName, status);
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getStatus() {
        return status;
    }

    public List<Programmer> getTeam() {
        return team;
    }

    public void setStatusUnavailable() {
        status = "not available";
    }

    public String doTask(String taskMsg){
        if(status.equals("not available")){
            throw new TeamLeadUnavailableNowException("Почему TeamLead не на месте!");
        }

        Optional<Programmer> firstAvailable = team.stream()
                .filter(p -> p.getStatus().equals("available"))
                .findFirst();

        if(firstAvailable.isEmpty()){
            throw new AllProgrammersAreBusyNowException("Нам не хватает программистов!");
        }

        Programmer availableProgrammer = firstAvailable.get();

        return availableProgrammer.toString() + "\n" + availableProgrammer.doWork(taskMsg);
    }
}
