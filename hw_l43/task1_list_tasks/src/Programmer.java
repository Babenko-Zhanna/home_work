import java.util.List;

public class Programmer {
    private String name;
    private String city;
    List<Task> tasks;

    public Programmer(String name, String city, List<Task> tasks) {
        this.name = name;
        this.city = city;
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return String.format("%s, %s (%s)", name, city, tasks);
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
