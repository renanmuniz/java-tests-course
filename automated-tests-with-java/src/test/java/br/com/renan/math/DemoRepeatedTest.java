package br.com.renan.math;

import br.com.renan.SimpleMath;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DemoRepeatedTest {
    SimpleMath simpleMath;

    @BeforeEach
    void setupBeforeEach() {
        System.out.println("Running @BeforeEach method");
        simpleMath = new SimpleMath();
    }

    @RepeatedTest(value = 3, name = "{displayName}. Repetiton {currentRepetition} of {totalRepetitions}!")
    @DisplayName("Test Division By Zero")
    void testDivisionByZero(
            RepetitionInfo repetitionInfo,
            TestInfo testinfo
    ) {
        System.out.println("Running " + testinfo.getTestMethod().get().getName());
        System.out.println("Division by zero test running number: " + repetitionInfo.getCurrentRepetition() + " of " + repetitionInfo.getTotalRepetitions());
        Double n1 = 6.0;
        Double n2 = 0.0;
        String expectedMessage = "Impossível dividir por zero!";

        Exception e = assertThrows(ArithmeticException.class, () -> simpleMath.division(n1,n2), "Deveria lançar ArithmeticException ");
        assertEquals(expectedMessage, e.getMessage(), "Mensagem deveria ser: " + expectedMessage);
    }

}
