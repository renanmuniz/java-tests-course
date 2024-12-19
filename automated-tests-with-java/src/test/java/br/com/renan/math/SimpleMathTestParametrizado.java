package br.com.renan.math;

import br.com.renan.SimpleMath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Test Math Operations in SimpleMath Class")
public class SimpleMathTestParametrizado {

    SimpleMath simpleMath;

    @BeforeEach
    void setupBeforeEach() {
        System.out.println("Running @BeforeEach method");
        simpleMath = new SimpleMath();
    }


    @DisplayName("Test Divisions")
    @ParameterizedTest
    @MethodSource("testDivisionInputParameters")
    void testDivision(double firstNumber, double secondoNumber, double expected) {

        Double actual = simpleMath.division(firstNumber, secondoNumber);

        assertEquals(expected, actual, 0.00999);
        // Esse parametro delta "0.009" é a diferença maxima que pode aceitar, devido a operaçoes de ponto flutuante
        //Ex.:
        //Expected :5.07
        //Actual   :5.071428571428571
        //Isso ocorre com Double e float
        // Com Bigdecimal podemos utilizar setScale com RoundingMode. Exemplo mais abaixo.
    }

    @DisplayName("Test Divisions")
    @ParameterizedTest
    @MethodSource("testDivisionInputParametersBigDecimal")
    void testDivisionBigDecimal(BigDecimal firstNumber, BigDecimal secondoNumber, BigDecimal expected) {

        BigDecimal actual = simpleMath.divisionBigDecimal(firstNumber, secondoNumber);
        assertEquals(expected, actual);

    }


    @DisplayName("Test Divisions")
    @ParameterizedTest
    @CsvSource({
            "10.00,2.00,5.00",
            "15.00,2.00,7.50",
            "10.00,3.00,3.33",
    })
    void testDivisionBigDecimalCsvSource(BigDecimal firstNumber, BigDecimal secondoNumber, BigDecimal expected) {

        BigDecimal actual = simpleMath.divisionBigDecimal(firstNumber, secondoNumber);
        assertEquals(expected, actual);
    }

    @DisplayName("Test Divisions [firstNumber, secondoNumber, expected]")
    @ParameterizedTest
    @CsvFileSource(resources = "/testBigDecimalDivisionCsvSource.csv")
    void testDivisionBigDecimalCsvSourceFile(BigDecimal firstNumber, BigDecimal secondoNumber, BigDecimal expected) {

        BigDecimal actual = simpleMath.divisionBigDecimal(firstNumber, secondoNumber);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Joao", "Jose", "Maria"})
    void testValueSource(String firstName) {
        System.out.println(firstName);
        assertNotNull(firstName);
    }


    public static Stream<Arguments> testDivisionInputParameters() {
        return Stream.of(
                Arguments.of(6.2,2.0,3.1),
                Arguments.of(71.0,14.0,5.07),
                Arguments.of(18.3,3.1,5.9)
        );
    }

    public static Stream<Arguments> testDivisionInputParametersBigDecimal() {
        return Stream.of(
                Arguments.of(BigDecimal.valueOf(6.2),BigDecimal.valueOf(2.0),BigDecimal.valueOf(3.10).setScale(2)),
                Arguments.of(BigDecimal.valueOf(71.0),BigDecimal.valueOf(14.0),BigDecimal.valueOf(5.07).setScale(2)),
                Arguments.of(BigDecimal.valueOf(18.3),BigDecimal.valueOf(3.1),BigDecimal.valueOf(5.90).setScale(2))
        );
    }


}
