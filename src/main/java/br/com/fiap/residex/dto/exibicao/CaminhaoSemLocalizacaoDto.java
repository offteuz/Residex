package br.com.fiap.residex.dto.exibicao;


import br.com.fiap.residex.model.Caminhao;

public record CaminhaoSemLocalizacaoDto(

        Long idCaminhao,

        String modelo,

        String placa
) {

    public CaminhaoSemLocalizacaoDto(Caminhao caminhao) {
        this(
                caminhao.getIdCaminhao(),
                caminhao.getModelo(),
                caminhao.getPlaca()
        );
    }
}
