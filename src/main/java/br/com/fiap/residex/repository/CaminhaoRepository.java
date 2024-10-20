package br.com.fiap.residex.repository;

import br.com.fiap.residex.dto.exibicao.CaminhaoRastreioDto;
import br.com.fiap.residex.model.Caminhao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CaminhaoRepository extends JpaRepository<Caminhao, Long> {

    //@Query("select c from t_caminhao c where c.status.descricaoStatus =:status")
    //List<CaminhaoRastreioDto> findCaminhaoByStatus(@Param("status") String status);

    //@Query("select c from t_caminhao c where c.idCaminhao =:idCaminhao and c.status.descricaoStatus =:status")
    //CaminhaoRastreioDto findCaminhaoByIdCaminhaoAndStatus(@Param("idCaminhao") Long idCaminhao, @Param("status") String status);

    CaminhaoRastreioDto findCaminhaoByIdCaminhao(Long idCaminhao);
}
