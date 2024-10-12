package br.com.fiap.residex.repository;

import br.com.fiap.residex.dto.exibicao.MoradorExibicaoDto;
import br.com.fiap.residex.model.Morador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoradorRepository extends JpaRepository<Morador, Long> {

    MoradorExibicaoDto findMoradorByIdMorador(Long idMorador);
}
