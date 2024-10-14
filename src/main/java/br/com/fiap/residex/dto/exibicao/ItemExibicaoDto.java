package br.com.fiap.residex.dto.exibicao;

import br.com.fiap.residex.model.Item;
import br.com.fiap.residex.model.Tipo;
import jakarta.validation.constraints.NotBlank;

public record ItemExibicaoDto(

        Long idItem,

        String descricaoItem,

        Double pesoItem,

        Tipo tipo
) {

    public ItemExibicaoDto(Item item) {

        this(
                item.getIdItem(),
                item.getDescricaoItem(),
                item.getPesoItem(),
                item.getTipo()
        );
    }
}
