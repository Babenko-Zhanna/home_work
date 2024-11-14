public class TeamLeadUnavailableNowException extends TeamMemberStatusException{
    @Override
    public void printMessage() {
        System.out.println("Почему TeamLead не на месте!");
    }
}
