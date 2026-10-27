package br.com.aula09.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    private final Calculadora calculadora = new Calculadora();

    @Test
    void deveDividirDoisNumerosCorretamente() {
        assertEquals(5, calculadora.divide(10, 2));
        assertEquals(-3, calculadora.divide(-9, 3));
    }

    @Test
    void deveLancarArithmeticExceptionQuandoDivisorForZero() {
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> calculadora.divide(10, 0)
        );
        assertEquals("Divisor não pode ser zero", exception.getMessage());
    }
}
