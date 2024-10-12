package br.com.fiap.residex.dto.exibicao;

import br.com.fiap.residex.model.Caminhao;
import br.com.fiap.residex.model.Coordenada;

public record CaminhaoRastreioDto(

        Long idCaminhao,

        String placa,

        Coordenada coordenada
) {

    public CaminhaoRastreioDto(Caminhao caminhao) {
        this(
                caminhao.getIdCaminhao(),
                caminhao.getPlaca(),
                caminhao.getCoordenada()
        );
    }
}
