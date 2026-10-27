package br.com.aula09.service;

import br.com.aula09.model.Usuario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Serviço de gerenciamento de usuários (equivalente em Java ao userStore / api).
 * Permite carregar usuários, consultar detalhes por ID, filtrar e-mails .biz e limpar a lista.
 */
public class UserService {

    private final List<Usuario> usuarios = new ArrayList<>();

    /**
     * Carrega a lista padrão de usuários da base (JSONPlaceholder).
     */
    public void carregarUsuarios() {
        usuarios.clear();
        usuarios.add(new Usuario(1, "Leanne Graham", "Sincere@april.biz", "1-770-736-8031 x56442"));
        usuarios.add(new Usuario(2, "Ervin Howell", "Shanna@melissa.tv", "010-692-6593 x09125"));
        usuarios.add(new Usuario(3, "Clementine Bauch", "Nathan@yesenia.net", "1-463-123-4447"));
        usuarios.add(new Usuario(4, "Patricia Lebsack", "Julianne.OConner@kory.org", "493-170-9623 x156"));
        usuarios.add(new Usuario(5, "Chelsey Dietrich", "Lucio_Hettinger@annie.ca", "(254)954-1289"));
        usuarios.add(new Usuario(6, "Mrs. Dennis Schulist", "Karley_Dach@jasper.info", "1-477-935-8478 x6430"));
        usuarios.add(new Usuario(7, "Kurtis Weissnat", "Telly.Hoeger@billy.biz", "210.067.6132"));
        usuarios.add(new Usuario(8, "Nicholas Runolfsdottir V", "Sherwood@rosamond.me", "586.493.6943 x140"));
        usuarios.add(new Usuario(9, "Glenna Reichert", "Chaim_McDermott@dana.io", "(775)976-6794 x41206"));
        usuarios.add(new Usuario(10, "Clementina DuBuque", "Rey.Padberg@karina.biz", "024-648-3804"));
    }

    /**
     * Adiciona um usuário manualmente na lista.
     *
     * @param usuario objeto Usuario a ser adicionado
     */
    public void adicionarUsuario(Usuario usuario) {
        if (usuario != null) {
            usuarios.add(usuario);
        }
    }

    /**
     * Formata o cabeçalho de exibição tratando referências nulas (hotfix/header-null e issue-123).
     *
     * @param titulo título do cabeçalho
     * @return cabeçalho seguro nunca nulo
     */
    public String formatarHeader(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            return "Todos os Usuários";
        }
        return titulo.trim();
    }

    /**
     * Retorna todos os usuários carregados.
     *
     * @return lista imutável de usuários
     */
    public List<Usuario> getUsuarios() {
        return Collections.unmodifiableList(usuarios);
    }

    /**
     * Retorna o total de usuários cadastrados.
     *
     * @return quantidade de usuários
     */
    public int getTotalUsuarios() {
        return usuarios.size();
    }

    /**
     * Busca os detalhes de um usuário pelo seu ID.
     *
     * @param id identificador do usuário
     * @return Optional contendo o usuário se encontrado
     */
    public Optional<Usuario> usuarioPorId(int id) {
        return usuarios.stream()
                .filter(u -> u.getId() == id)
                .findFirst();
    }

    /**
     * Filtra os usuários cujo e-mail termina com ".biz" (Usuários Biz), tratando nulos.
     *
     * @return lista de usuários com e-mail .biz
     */
    public List<Usuario> usuariosComEmailBiz() {
        return usuarios.stream()
                .filter(u -> u != null && u.getEmail() != null && u.getEmail().endsWith(".biz"))
                .collect(Collectors.toList());
    }

    /**
     * Limpa a lista de usuários carregados.
     */
    public void limparUsuarios() {
        usuarios.clear();
    }
}
