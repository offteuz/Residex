package br.com.fiap.residex.repository;

import br.com.fiap.residex.model.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoRepository extends JpaRepository<Tipo, Long> {
}
