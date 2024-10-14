package br.com.fiap.residex.dto.exibicao;

import br.com.fiap.residex.model.Caminhao;
import br.com.fiap.residex.model.Coordenada;

public record CaminhaoExibicaoDto(

        Long idCaminhao,

        String modelo,

        String placa,

        Coordenada coordenada,

        EmpresaSemCaminhoesDto empresa
) {

    public CaminhaoExibicaoDto(Caminhao caminhao) {
        this(
                caminhao.getIdCaminhao(),
                caminhao.getModelo(),
                caminhao.getPlaca(),
                caminhao.getCoordenada(),
                new EmpresaSemCaminhoesDto(caminhao.getEmpresa())
        );
    }
}
