package br.com.renan.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArraysCompareTest {

    @Test
    void test() {
        int[] numbers = {25, 8, 21, 32, 3};
        int[] expected = {3, 8, 21, 25, 32};

        Arrays.sort(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    @Timeout(value = 3000, unit = TimeUnit.MILLISECONDS) //3 segundos
    @DisplayName("Test time execution")
    void testPerformance() {
        highTimeConsumingMethod();
    }

    void highTimeConsumingMethod() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
