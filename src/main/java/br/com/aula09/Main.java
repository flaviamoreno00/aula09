package br.com.aula09;

import br.com.aula09.model.Usuario;
import br.com.aula09.service.UserService;

/**
 * Classe principal de demonstração da listagem de usuários e filtro .biz.
 */
public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.carregarUsuarios();

        System.out.println("=== Todos os Usuários (Total: " + userService.getTotalUsuarios() + ") ===");
        for (Usuario u : userService.getUsuarios()) {
            System.out.println(" - " + u.getName() + " <" + u.getEmail() + ">");
        }

        System.out.println("\n=== Usuários Biz (@biz) (Total: " + userService.usuariosComEmailBiz().size() + ") ===");
        for (Usuario u : userService.usuariosComEmailBiz()) {
            System.out.println(" - " + u.getName() + " <" + u.getEmail() + ">");
        }
    }
}
