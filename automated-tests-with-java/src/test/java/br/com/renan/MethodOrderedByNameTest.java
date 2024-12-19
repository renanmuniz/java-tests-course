package br.com.renan;

import org.junit.jupiter.api.Test;

//@TestMethodOrder(MethodOrderer.MethodName.class) //Por default já é assim
public class MethodOrderedByNameTest {

    @Test
    void testB(){
        System.out.println("Running test B");
    }

    @Test
    void testD(){
        System.out.println("Running test D");
    }

    @Test
    void testA(){
        System.out.println("Running test A");
    }

    @Test
    void testC(){
        System.out.println("Running test C");
    }



}
