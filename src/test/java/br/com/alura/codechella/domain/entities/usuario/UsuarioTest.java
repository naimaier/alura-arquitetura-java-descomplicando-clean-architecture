package br.com.alura.codechella.domain.entities.usuario;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {
    @Test
    public void naoDeveCadastrarUsuarioComCpfNoFormatoInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123456789-00", "fulano",
                        LocalDate.now(), "email@email.com"));

        assertThrows(IllegalArgumentException.class,
                () -> new Usuario("12345678900", "fulano",
                        LocalDate.now(), "email@email.com"));

        assertThrows(IllegalArgumentException.class,
                () -> new Usuario("", "fulano",
                        LocalDate.now(), "email@email.com"));
    }

    @Test
    public void naoDeveCadastrarMenoresDeIdade() {
        LocalDate idade = LocalDate.now().minusYears(17);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123.456.789-00", "fulano",
                        idade, "email@email.com"));

        assertEquals("Não é permitido o cadastro de menores de idade", exception.getMessage());
    }

    @Test
    public void deveCriarUsuarioUsandoFabricaDeUsuario() {
        FabricaDeUsuario fabrica = new FabricaDeUsuario();
        Usuario usuario = fabrica
                .comNomeCpfNascimento("Emily",
                        "789.123.456-00", LocalDate.parse("1990-01-01"));

        assertEquals("Emily", usuario.getNome());

        usuario = fabrica.incluiEndereco("12345-999", 40,
                "ap. 201");
        assertEquals("ap. 201", usuario.getEndereco().getComplemento());
    }
}