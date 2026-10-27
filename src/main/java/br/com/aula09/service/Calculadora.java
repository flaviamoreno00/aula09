package br.com.aula09.service;

/**
 * Classe Calculadora revisada conforme Atividade 3 (Code Review Simulado - Aula 09).
 */
public class Calculadora {

    /**
     * Realiza a divisão inteira entre dois números com tratamento para divisão por zero.
     *
     * @param a dividendo
     * @param b divisor
     * @return resultado da divisão inteira
     * @throws ArithmeticException quando o divisor for igual a zero
     */
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Divisor não pode ser zero");
        }
        return a / b;
    }
}
