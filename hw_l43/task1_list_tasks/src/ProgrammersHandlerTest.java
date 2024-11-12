import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


class ProgrammersHandlerTest {
    private List<Programmer> programmers;
    private ProgrammersHandler programmersHandler;

    @BeforeEach
    void setUp() {
        programmers = List.of(
                new Programmer("Jack", "Berlin", new ArrayList<>(List.of(
                        new Task(1, "Authentication system development", "in progress", 5),
                        new Task(2, "Optimisation of sorting algorithm", "done", 2),
                        new Task(3, "External API integration", "opened", 7)))),

                new Programmer("John", "Hanover", new ArrayList<>(List.of(
                        new Task(4, "Database migration", "in progress", 10),
                        new Task(5, "RESTful API for product catalog", "done", 8),
                        new Task(6, "Commenting feature implementation", "awaiting review", 5),
                        new Task(7, "Push notification system", "awaiting review", 6)))),

                new Programmer("Nick", "Berlin", new ArrayList<>(List.of(
                        new Task(8, "Unit testing", "done", 2),
                        new Task(9, "Site search functionality", "in progress", 9),
                        new Task(10, "Code refactoring", "awaiting testing", 9)))
                ));

        programmersHandler = new ProgrammersHandler(programmers);

    }

    @Test
    void getAllTasksList() {
        List<Task> expectedResult = List.of(
                new Task(1, "Authentication system development", "in progress", 5),
                new Task(2, "Optimisation of sorting algorithm", "done", 2),
                new Task(3, "External API integration", "opened", 7),
                new Task(4, "Database migration", "in progress", 10),
                new Task(5, "RESTful API for product catalog", "done", 8),
                new Task(6, "Commenting feature implementation", "awaiting review", 5),
                new Task(7, "Push notification system", "awaiting review", 6),
                new Task(8, "Unit testing", "done", 2),
                new Task(9, "Site search functionality", "in progress", 9),
                new Task(10, "Code refactoring", "awaiting testing", 9)
        );

        List<Task> actualResult = programmersHandler.getAllTasksList();
        Assertions.assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    void getAllTasksList_NullList() {
        programmersHandler = new ProgrammersHandler(null);
        List<Task> expectedResult = Collections.emptyList();
        List<Task> actualResult = programmersHandler.getAllTasksList();
        Assertions.assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    void getRequiredTasksList_regularCase() {
        List<Task> expectedResult = List.of(
                new Task(3, "External API integration", "opened", 7),
                new Task(9, "Site search functionality", "in progress", 9),
                new Task(10, "Code refactoring", "awaiting testing", 9)
        );
        List<Task> actualResult = programmersHandler.getRequiredTasksList();
        Assertions.assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    void getRequiredTasksList_NullList() {
        programmersHandler = new ProgrammersHandler(null);
        List<Task> expectedResult = Collections.emptyList();
        List<Task> actualResult = programmersHandler.getRequiredTasksList();
        Assertions.assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    void getMapPartitionedBy_regularCase() {
        Map<Boolean, List<Task>> expectedResult = Map.of(
                true, List.of(
                        new Task(1, "Authentication system development", "in progress", 5),
                        new Task(2, "Optimisation of sorting algorithm", "done", 2),
                        new Task(6, "Commenting feature implementation", "awaiting review", 5),
                        new Task(8, "Unit testing", "done", 2)
                ),
                false, List.of(
                        new Task(3, "External API integration", "opened", 7),
                        new Task(4, "Database migration", "in progress", 10),
                        new Task(5, "RESTful API for product catalog", "done", 8),
                        new Task(7, "Push notification system", "awaiting review", 6),
                        new Task(9, "Site search functionality", "in progress", 9),
                        new Task(10, "Code refactoring", "awaiting testing", 9)
                )
        );
        Map<Boolean, List<Task>> actualResult = programmersHandler.getMapPartitionedBy(6);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void getMapPartitionedBy_NullList() {
        programmersHandler = new ProgrammersHandler(null);
        Map<Boolean, List<Task>> expectedResult = Collections.emptyMap();
        Map<Boolean, List<Task>> actualResult = programmersHandler.getMapPartitionedBy(6);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void getMapGroupedBy_regularCase() {
        Map<Integer, List<Task>> expectedResult = Map.of(
                2, List.of(
                        new Task(2, "Optimisation of sorting algorithm", "done", 2),
                        new Task(8, "Unit testing", "done", 2)),
                5, List.of(
                        new Task(1, "Authentication system development", "in progress", 5),
                        new Task(6, "Commenting feature implementation", "awaiting review", 5)),
                6, List.of(new Task(7, "Push notification system", "awaiting review", 6)),
                7, List.of(
                        new Task(3, "External API integration", "opened", 7)),
                8, List.of(new Task(5, "RESTful API for product catalog", "done", 8)),
                9, List.of(
                        new Task(9, "Site search functionality", "in progress", 9),
                        new Task(10, "Code refactoring", "awaiting testing", 9)),
                10, List.of(new Task(4, "Database migration", "in progress", 10))
        );
        Map<Integer, List<Task>> actualResult = programmersHandler.getMapGroupedBy();
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void getMapGroupedBy_NullList() {
        programmersHandler = new ProgrammersHandler(null);
        Map<Integer, List<Task>> expectedResult = Collections.emptyMap();
        Map<Integer, List<Task>> actualResult = programmersHandler.getMapGroupedBy();
        Assertions.assertEquals(expectedResult, actualResult);
    }
}