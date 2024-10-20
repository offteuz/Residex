package br.com.fiap.residex.dto.exibicao;

import br.com.fiap.residex.dto.cadastro.EmpresaCaminhaoDto;
import br.com.fiap.residex.model.Caminhao;
import br.com.fiap.residex.model.Capacidade;
import br.com.fiap.residex.model.Coordenada;

public record CaminhaoExibicaoDto(

        Long idCaminhao,

        String modelo,

        String placa,

        String emRota,

        Coordenada coordenada,

        Capacidade capacidade,

        EmpresaCaminhaoDto empresa
) {

    public CaminhaoExibicaoDto(Caminhao caminhao) {
        this(
                caminhao.getIdCaminhao(),
                caminhao.getModelo(),
                caminhao.getPlaca(),
                caminhao.getEmRota(),
                caminhao.getCoordenada(),
                caminhao.getCapacidade(),
                new EmpresaCaminhaoDto(caminhao.getEmpresa())
        );
    }
}
