package br.com.aula09.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotificacaoServiceTest {

    private final NotificacaoService notificacaoService = new NotificacaoService();

    @Test
    void deveValidarEmailsValidosCorretamente() {
        assertTrue(notificacaoService.validarEmail("Sincere@april.biz"));
        assertTrue(notificacaoService.validarEmail("usuario.teste@dominio.com.br"));
    }

    @Test
    void deveRejeitarEmailsInvalidos() {
        assertFalse(notificacaoService.validarEmail(null));
        assertFalse(notificacaoService.validarEmail("   "));
        assertFalse(notificacaoService.validarEmail("email-sem-arroba.com"));
        assertFalse(notificacaoService.validarEmail("usuario@dominio"));
        assertFalse(notificacaoService.validarEmail("@dominio.com"));
    }

    @Test
    void deveEnviarEmailQuandoDestinatarioEMensagemForemValidos() {
        assertTrue(notificacaoService.enviarEmail("Sincere@april.biz", "Bem-vindo ao sistema!"));
    }

    @Test
    void deveLancarExcecaoParaEmailInvalidoNoEnvio() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> notificacaoService.enviarEmail("email_invalido", "Mensagem de teste")
        );
        assertTrue(ex.getMessage().contains("Formato de email inválido"));
    }

    @Test
    void deveLancarExcecaoParaMensagemVaziaOuNula() {
        assertThrows(
                IllegalArgumentException.class,
                () -> notificacaoService.enviarEmail("Sincere@april.biz", "")
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> notificacaoService.enviarEmail("Sincere@april.biz", null)
        );
    }
}
