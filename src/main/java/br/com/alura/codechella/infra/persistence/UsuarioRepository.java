package br.com.alura.codechella.infra.persistence;


import br.com.alura.codechella.infra.persistence.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}
