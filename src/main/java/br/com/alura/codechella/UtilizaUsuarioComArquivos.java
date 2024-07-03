package br.com.alura.codechella;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioEmArquivo;

import java.time.LocalDate;

public class UtilizaUsuarioComArquivos {
    public static void main(String[] args) {
        RepositorioDeUsuarioEmArquivo repositorio = new RepositorioDeUsuarioEmArquivo();

        repositorio.cadastrarUsuario(
                new Usuario(
                        "456.789.123-00",
                        "Joao",
                        LocalDate.parse("1990-01-01"),
                        "joao@gmail.com"));

        repositorio.cadastrarUsuario(
                new Usuario(
                        "456.789.123-01",
                        "Maria",
                        LocalDate.parse("1991-01-01"),
                        "maria@gmail.com"));

        repositorio.cadastrarUsuario(
                new Usuario(
                        "456.789.123-02",
                        "Vinicius",
                        LocalDate.parse("1992-01-01"),
                        "vinicius@gmail.com"));

        repositorio.cadastrarUsuario(
                new Usuario(
                        "456.789.123-03",
                        "Rafael",
                        LocalDate.parse("1993-01-01"),
                        "rafael@gmail.com"));

//        System.out.println(repositorio.listarTodos());
        repositorio.gravaEmArquivo("usuarios.txt");
    }
}
