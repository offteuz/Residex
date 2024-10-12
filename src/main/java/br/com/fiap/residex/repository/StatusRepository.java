package br.com.fiap.residex.repository;

import br.com.fiap.residex.dto.exibicao.StatusExibicaoDto;
import br.com.fiap.residex.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StatusRepository extends JpaRepository<Status, Long> {

    @Query("select s from t_status s where s.descricaoStatus like(concat('%', :descricaoStatus, '%'))")
    List<StatusExibicaoDto> findByDescricaoStatusContaining(@Param("descricaoStatus") String descricaoStatus);

    Status findByDescricaoStatus(String descricaoStatus);
}
