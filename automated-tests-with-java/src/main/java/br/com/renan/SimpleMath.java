package br.com.renan;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SimpleMath {

    public Double sum(Double firstNumber, Double secondNumber) {
        return firstNumber + secondNumber;
    }

    public Double subtraction(Double firstNumber, Double secondNumber) {
        return firstNumber - secondNumber;
    }

    public Double multiplication(Double firstNumber, Double secondNumber) {
        return firstNumber * secondNumber;
    }

    public Double division(Double firstNumber, Double secondNumber) {
        if(secondNumber.equals(0D)) throw new ArithmeticException("Impossível dividir por zero!");
        var result = firstNumber / secondNumber;
        return result;
    }

    public BigDecimal divisionBigDecimal(BigDecimal firstNumber, BigDecimal secondNumber) {
        if(secondNumber.equals(BigDecimal.ZERO)) throw new ArithmeticException("Impossível dividir por zero!");
        return firstNumber.divide(secondNumber,2,RoundingMode.HALF_UP);
    }

    public Double mean(Double firstNumber, Double secondNumber) {
        return (firstNumber + secondNumber) / 2;
    }
    
    public Double squareRoot(Double number) {
        return (Double) Math.sqrt(number);
    }
}
