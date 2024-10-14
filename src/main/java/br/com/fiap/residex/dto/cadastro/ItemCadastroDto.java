package br.com.fiap.residex.dto.cadastro;

import br.com.fiap.residex.model.Tipo;
import jakarta.validation.constraints.NotBlank;

public record ItemCadastroDto(

        Long idItem,

        @NotBlank
        String descricaoItem,

        @NotBlank
        Double pesoItem,

        @NotBlank
        Tipo tipo
) {
}
