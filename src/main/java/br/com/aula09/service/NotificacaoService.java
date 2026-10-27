package br.com.aula09.service;

import java.util.regex.Pattern;

/**
 * Serviço de notificações por e-mail (Desafio Colaborativo - Aula 09).
 * Valida o formato do e-mail utilizando Regex antes de realizar o envio.
 */
public class NotificacaoService {

    private static final Pattern EMAIL_REGEX =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    /**
     * Valida se o endereço de e-mail possui formato válido via expressão regular.
     *
     * @param email endereço de e-mail a ser validado
     * @return true se o formato for válido, false caso contrário
     */
    public boolean validarEmail(String email) {
        if (email == null || email.isBlank()) {
            return false;
        }
        return EMAIL_REGEX.matcher(email.trim()).matches();
    }

    /**
     * Envia um e-mail após validar o formato do destinatário e o conteúdo da mensagem.
     *
     * @param destinatario endereço de e-mail do destinatário
     * @param mensagem     conteúdo da mensagem
     * @return true quando o e-mail é enviado com sucesso
     * @throws IllegalArgumentException se o e-mail for inválido ou a mensagem for vazia
     */
    public boolean enviarEmail(String destinatario, String mensagem) {
        if (!validarEmail(destinatario)) {
            throw new IllegalArgumentException("Formato de email inválido: " + destinatario);
        }
        if (mensagem == null || mensagem.isBlank()) {
            throw new IllegalArgumentException("A mensagem não pode ser vazia");
        }
        return true;
    }
}
