package br.com.renan;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math Operations in SimpleMath Class")
public class SimpleMathTest {

    SimpleMath simpleMath;

    @BeforeAll
    static void setup() {
        System.out.println("Running @BeforeAll method");
    }

    @AfterAll
    static void cleanup() {
        System.out.println("Running @AfterAll method");
    }

    @BeforeEach
    void setupBeforeEach() {
        System.out.println("Running @BeforeEach method");
        simpleMath = new SimpleMath();
    }

    @AfterEach
    void cleanupAfterEach() {
        System.out.println("Running @AfterEach method");
    }

    @Test
    @DisplayName("Test 2.5 + 3.3 = 5.8")
    void testSum_When_TwoDotFivePlusThreeDotThree_Should_Return_fiveDotEight() {
        System.out.println("Testando sum"); //nao se usa assim, so pra ver o ciclo de vida beforeall after all before each after each

        //Given
        Double n1 = 2.5;
        Double n2 = 3.3;
        Double expected = 5.8;

        //When
        Double actual = simpleMath.sum(n1, n2);

        //Then
        assertEquals(expected, actual, n1 + " + " + n2 + " não é igual a: " + expected);
        assertNotEquals(expected + 1, actual, n1 + " + " + n2 + " não é igual a: " + expected);
        assertNotNull(actual,"Valor calculado é nulo");
    }

    @Test
    @DisplayName("Test 10.0 - 5.0 = 5.0")
    void testSubtraction_When_TenDividedByFive_Should_return_two() {
        System.out.println("Testando subtraction"); //nao se usa assim, so pra ver o ciclo de vida beforeall after all before each after each

        Double n1 = 10.0;
        Double n2 = 5.0;
        Double expected = 5.0;

        Double actual = simpleMath.subtraction(n1,n2);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test 2.0 * 3.0 = 6.0")
    void testMultiplication_when_twoMultiplyedByThree_should_return_six() {
        System.out.println("Testando multiplication"); //nao se usa assim, so pra ver o ciclo de vida beforeall after all before each after each

        Double n1 = 2.0;
        Double n2 = 3.0;
        Double expected = 6.0;

        Double actual = simpleMath.multiplication(n1,n2);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test 6.0 / 3.0 = 2.0")
    void testDivision() {

        Double n1 = 6.0;
        Double n2 = 3.0;
        Double expected = 2.0;

        Double actual = simpleMath.division(n1,n2);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test Division By Zero")
    void testDivisionByZero() {

        Double n1 = 6.0;
        Double n2 = 0.0;
        String expectedMessage = "Impossível dividir por zero!";

        Exception e = assertThrows(ArithmeticException.class, () -> simpleMath.division(n1,n2), "Deveria lançar ArithmeticException ");
        assertEquals(expectedMessage, e.getMessage(), "Mensagem deveria ser: " + expectedMessage);
    }

    @Disabled("falta implementar xyz") //Desabilita a execução do teste, aparece nos resultado que foi ignorado
    @Test
    @DisplayName("Test Mean between 6.0 and 3.0 = 4.5")
    void testMean() {

        Double n1 = 6.0;
        Double n2 = 3.0;
        Double expected = 4.5;

        Double actual = simpleMath.mean(n1,n2);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test SquareRoot of 9.0 = 3.0")
    void testSquareRoot() {

        Double n = 9.0;
        Double expected = 3.0;

        Double actual = simpleMath.squareRoot(n);

        assertEquals(expected, actual);
    }

}
