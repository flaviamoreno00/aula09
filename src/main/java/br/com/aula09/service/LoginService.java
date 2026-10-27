package br.com.aula09.service;

/**
 * Serviço responsável pela validação de senha e autenticação (Feature Login - Aula 09).
 */
public class LoginService {

    /**
     * Valida se a senha informada cumpre os critérios de segurança:
     * mínimo de 8 caracteres, ao menos uma letra maiúscula e ao menos um dígito numérico.
     *
     * @param senha senha a ser validada
     * @return true se a senha for válida, false caso contrário
     */
    public boolean validarSenha(String senha) {
        if (senha == null || senha.length() < 8) {
            return false;
        }
        boolean temMaiuscula = senha.chars().anyMatch(Character::isUpperCase);
        boolean temNumero = senha.chars().anyMatch(Character::isDigit);
        return temMaiuscula && temNumero;
    }
}
