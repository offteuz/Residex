package br.com.fiap.residex.dto.exibicao;

import br.com.fiap.residex.model.Status;

public record StatusExibicaoDto(

        Long idStatus,

        String descricaoStatus
) {

    public StatusExibicaoDto(Status status) {
        this(
                status.getIdStatus(),
                status.getDescricaoStatus()
        );
    }
}
