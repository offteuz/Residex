package br.com.fiap.residex.dto.exibicao;

import br.com.fiap.residex.model.Caminhao;
import br.com.fiap.residex.model.Coordenada;
import br.com.fiap.residex.model.Empresa;
import br.com.fiap.residex.model.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public record CaminhaoExibicaoDto(

        Long idCaminhao,

        String modelo,

        String placa,

        Coordenada coordenada,

        Status status,

        EmpresaSemCaminhoesDto empresa
) {

    public CaminhaoExibicaoDto(Caminhao caminhao) {
        this(
                caminhao.getIdCaminhao(),
                caminhao.getModelo(),
                caminhao.getPlaca(),
                caminhao.getCoordenada(),
                caminhao.getStatus(),
                new EmpresaSemCaminhoesDto(caminhao.getEmpresa())
        );
    }
}
