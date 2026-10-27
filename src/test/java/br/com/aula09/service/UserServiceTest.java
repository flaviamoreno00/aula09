package br.com.aula09.service;

import br.com.aula09.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
    }

    @Test
    void deveIniciarComListaVazia() {
        assertEquals(0, userService.getTotalUsuarios());
        assertTrue(userService.getUsuarios().isEmpty());
    }

    @Test
    void deveCarregarTodosOsUsuariosEFiltrarEmailsBiz() {
        userService.carregarUsuarios();

        assertEquals(10, userService.getTotalUsuarios());

        List<Usuario> usuariosBiz = userService.usuariosComEmailBiz();
        assertEquals(3, usuariosBiz.size());
        assertTrue(usuariosBiz.stream().allMatch(u -> u.getEmail().endsWith(".biz")));
    }

    @Test
    void deveBuscarDetalhesDoUsuarioPorId() {
        userService.carregarUsuarios();

        Optional<Usuario> usuario = userService.usuarioPorId(1);
        assertTrue(usuario.isPresent());
        assertEquals("Leanne Graham", usuario.get().getName());
        assertEquals("Sincere@april.biz", usuario.get().getEmail());

        assertFalse(userService.usuarioPorId(999).isPresent());
    }

    @Test
    void deveTratarHeaderNuloCorretamente() {
        assertEquals("Todos os Usuários", userService.formatarHeader(null));
        assertEquals("Todos os Usuários", userService.formatarHeader("   "));
        assertEquals("Usuários Biz", userService.formatarHeader("Usuários Biz"));
    }

    @Test
    void deveLimparUsuariosCorretamente() {
        userService.carregarUsuarios();
        assertEquals(10, userService.getTotalUsuarios());

        userService.limparUsuarios();
        assertEquals(0, userService.getTotalUsuarios());
    }
}
