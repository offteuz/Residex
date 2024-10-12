package br.com.fiap.residex.repository;

import br.com.fiap.residex.dto.exibicao.EmpresaExibicaoDto;
import br.com.fiap.residex.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
