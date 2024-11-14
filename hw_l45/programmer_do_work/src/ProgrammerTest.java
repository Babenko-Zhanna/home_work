import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ProgrammerTest {
    private Programmer programmer;

    @BeforeEach
    void setUp() {
        programmer = new Programmer("J", "J");
    }

    @Test
    void doWork_ProgrammerBusyException() {
        programmer.setStatusBusy();
        Assertions.assertThrows(ProgrammerBusyException.class, () -> programmer.doWork("jjj"));
    }

    @Test
    void doWork_ProgrammerBusyExceptionMessage() {
        programmer.setStatusBusy();
        ProgrammerBusyException exception = assertThrows(ProgrammerBusyException.class, () -> programmer.doWork("jjj"));
        Assertions.assertEquals("Программист занят другой задачей", exception.getMessage());
    }

    @Test
    void doWork_ProgrammerUnavailableNowException() {
        programmer.setStatusNotAvailable();
        Assertions.assertThrows(ProgrammerUnavailableNowException.class, () -> programmer.doWork("hhh"));
    }

    @Test
    void doWork_ProgrammerUnavailableNowExceptionMessage() {
        programmer.setStatusNotAvailable();
        ProgrammerUnavailableNowException exception = assertThrows(ProgrammerUnavailableNowException.class, () -> programmer.doWork("hhh"));
        Assertions.assertEquals("Программист не доступен", exception.getMessage());
    }

    @Test
    void doWork_ProgrammerAvailable(){
        String expectedResult = "Приступаю к задаче: Implement commenting feature";
        String actualResult = programmer.doWork("Implement commenting feature");
        Assertions.assertEquals(expectedResult, actualResult);
    }



}