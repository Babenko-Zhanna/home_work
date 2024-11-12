import java.util.Objects;

public class Task {
    private int number;
    private String description;
    private String status;
    private int daysInProcessing;

    public Task(int number, String description, String status, int daysInProcessing) {
        this.number = number;
        this.description = description;
        this.status = status;
        this.daysInProcessing = daysInProcessing;
    }

    @Override
    public String toString() {
        return String.format("%d. %s (%s, %d)", number, description, status, daysInProcessing);
    }

    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public int getDaysInProcessing() {
        return daysInProcessing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;
        return number == task.number;
    }

    @Override
    public int hashCode() {
        return number;
    }
}
