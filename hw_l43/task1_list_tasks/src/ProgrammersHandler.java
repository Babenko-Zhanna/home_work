import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProgrammersHandler {
    private List<Programmer> programmers;

    public ProgrammersHandler(List<Programmer> programmers) {
        this.programmers = programmers;
    }

    public List<Task> getAllTasksList () {
        if (programmers == null) {
            return Collections.emptyList();
        }
        return programmers.stream()
                .flatMap(p -> p.getTasks().stream())
                .toList();
    }

    public List<Task> getRequiredTasksList () {
        if (programmers == null) {
            return Collections.emptyList();
        }
        return programmers.stream()
                .filter(p -> p.getCity().equalsIgnoreCase("Berlin"))
                .flatMap(p -> p.getTasks().stream())
                .filter(t -> !t.getStatus().equalsIgnoreCase("done") && t.getDaysInProcessing() > 5)
                .toList();
    }

    public Map<Boolean, List<Task>> getMapPartitionedBy (int limitDaysInProcessing) {
        if (programmers == null || limitDaysInProcessing <= 0) {
            return Collections.emptyMap();
        }
        return programmers.stream()
                .flatMap(p -> p.getTasks().stream())
                .collect(Collectors.partitioningBy(t -> t.getDaysInProcessing() < limitDaysInProcessing));

    }

    public Map<Integer, List<Task>> getMapGroupedBy () {
        if (programmers == null) {
            return Collections.emptyMap();
        }
        return programmers.stream()
                .flatMap(p -> p.getTasks().stream())
                .collect(Collectors.groupingBy(t -> t.getDaysInProcessing()));
    }
}
