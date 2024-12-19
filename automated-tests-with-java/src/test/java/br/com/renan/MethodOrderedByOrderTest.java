package br.com.renan;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodOrderedByOrderTest {

    @Test
    @Order(3)
    void testB() {
        System.out.println("Running test B");
    }

    @Test
    @Order(1)
    void testD() {
        System.out.println("Running test D");
    }

    @Test
    @Order(4)
    void testA() {
        System.out.println("Running test A");
    }

    @Test
    @Order(2)
    void testC() {
        System.out.println("Running test C");
    }


}
