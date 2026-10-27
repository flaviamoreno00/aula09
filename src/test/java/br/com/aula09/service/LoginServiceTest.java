package br.com.aula09.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginServiceTest {

    private final LoginService loginService = new LoginService();

    @Test
    void deveAprovarSenhaValida() {
        assertTrue(loginService.validarSenha("SenhaForte123"));
    }

    @Test
    void deveRejeitarSenhaInvalida() {
        assertFalse(loginService.validarSenha(null));
        assertFalse(loginService.validarSenha("Curta1"));
        assertFalse(loginService.validarSenha("semmaiuscula123"));
        assertFalse(loginService.validarSenha("SemNumeroAqui"));
    }
}
