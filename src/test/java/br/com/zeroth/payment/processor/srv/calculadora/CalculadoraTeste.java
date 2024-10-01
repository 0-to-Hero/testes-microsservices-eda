package br.com.zeroth.payment.processor.srv.calculadora;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CalculadoraTeste {

    @Test
    void deveSomarDoisNumeros() {

        Calculadora calculadora = new Calculadora();

        assertEquals(5, calculadora.somar(2,3));
    }
}
