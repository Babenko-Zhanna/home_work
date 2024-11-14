public class Programmer {
    private String fName;
    private String lName;
    private String status = "available";

    public Programmer(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    @Override
    public String toString() {
        return String.format("%s %s (current status: %s)", fName, lName, status);
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

    public void setStatusNotAvailable(){
        status = "not available";
    }

    public void setStatusBusy(){
        status = "busy";
    }

    public String doWork(){
        if(status.equals("not available")){
            throw new ProgrammerUnavailableNowException();
        }
        if(status.equals("busy")){
            throw new ProgrammerBusyException();
        }
        return "Приступаю к работе!";
    }
}
