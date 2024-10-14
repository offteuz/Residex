package br.com.fiap.residex.dto.exibicao;

import br.com.fiap.residex.model.Tipo;

public record TipoExibicaoDto(

        Long idTipo,

        String descricaoTipo
) {

    public TipoExibicaoDto(Tipo tipo) {

        this(
                tipo.getIdTipo(),
                tipo.getDescricaoTipo()
        );
    }
}
