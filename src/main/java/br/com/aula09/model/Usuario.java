package br.com.aula09.model;

import java.util.Objects;

/**
 * Representa um usuário do sistema (Todos os Usuários / Usuários Biz).
 */
public class Usuario {
    private final int id;
    private final String name;
    private final String email;
    private final String phone;

    /**
     * Construtor do modelo Usuario.
     *
     * @param id    identificador único do usuário
     * @param name  nome completo do usuário
     * @param email endereço de e-mail do usuário
     * @param phone telefone de contato do usuário
     */
    public Usuario(int id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id
                && Objects.equals(name, usuario.name)
                && Objects.equals(email, usuario.email)
                && Objects.equals(phone, usuario.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, phone);
    }

    @Override
    public String toString() {
        return "Usuario{id=" + id + ", name='" + name + "', email='" + email + "', phone='" + phone + "'}";
    }
}
